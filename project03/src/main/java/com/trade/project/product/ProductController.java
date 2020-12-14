package com.trade.project.product;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.http.parser.Cookie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProductController {

	@Autowired
	ProductService service;

	@Autowired
	ReplyService service2;

	int countCheck = 0;

	@RequestMapping("product/product_view.do") // 상세페이지
	public void one(ProductVO productVO, Model model, HttpSession session) {
		ProductVO vo = service.one(productVO);// 서비스단에 one메서드를 사용하여 vo로 리턴
		model.addAttribute("vo", vo);// vo를 받아 모델객체로 view.do로 넘김

		// 게시물 하나를 가지고 오고,
		model.addAttribute("one", service.one(productVO));// one를 받아 모델객체로 view.do로 넘김
		// 게시물의 댓글 리스트를 가지고 와야함.
		model.addAttribute("list2", service2.list2(productVO.getProduct_id()));// service2에서 댓글리스트를 모델로 넘김
		model.addAttribute("total", service2.list2(productVO.getProduct_id()).size());// service2에서 댓글의 갯수를 모델로 넘김
		service.count(vo);// view.do를 클릭할때 count가 되며 vo를 service로 넘김
		System.out.println("vo >>>> " + vo.getProduct_title() + vo);

		if (session.getAttribute("list3") == null) {// session값이 없으면
			System.out.println("List null");
			List<ProductVO> list3 = new ArrayList<ProductVO>();// session값을 리스트에 담아줌
			list3.add(vo);// vo를 add시켜줌
			session.setAttribute("list3", list3);// session을 받아 list에 담는다
		} else {
			List<ProductVO> list3 = (List<ProductVO>) session.getAttribute("list3");// session을 리스트에 담아줌
			session.setAttribute("list3", list3);// session에 list3를 입력
			if (list3.size() < 3) {// list3.size가 3보다 작으면
				list3.add(vo);// vo를 add시켜줌
			} else if (list3.size() >= 3) {// list3.size가 3보다 크거나 같으면
				list3.remove(0);// vo를 첫번째 vo를 remove시킨다
				list3.add(vo);// vo를 add시켜줌
			}
			session.setAttribute("list3", list3);// session을 받아 list에 담는다
			System.out.println("list >>>> " + list3);
		}
	}

	@RequestMapping("product/product_create.do") // 상품 등록
	public void product_create(ProductVO productVO) {
		service.insert(productVO);// 입력받은 내용을 service단으로 넘긴다
	}

	@RequestMapping("product/product_delete.do") // 상품 삭제
	public void product_delete(ProductVO productVO) {
		service.delete(productVO);// 입력받은 내용을 service단으로 넘긴다
	}

	@RequestMapping("product/product_update.do") // 상품 정보 수정
	public void update(ProductVO productVO, Model model) {
		ProductVO vo = service.one(productVO);// 서비스단에서 one메서드를 받아 vo로 묶어서 모델로 넘김
		model.addAttribute("vo", vo);// vo를 받아 모델객체로 update.do로 넘김
	}

	@RequestMapping("product/product_update2.do") // 상품 정보 수정
	public void update2(ProductVO productVO, Model model) {
		service.update(productVO);// 입력받은 내용을 service단으로 넘긴다
	}

	/*
	 * @RequestMapping("product/product_view2.do") public void
	 * product_view(ProductVO productVO, Model model) { ProductVO vo =
	 * service.one(productVO); model.addAttribute("vo", vo);
	 * service.update(productVO); }
	 */
	@RequestMapping("/product/product_list.do") // 메인페이지
	public void product_list(ProductUserVO productuserVO, Model model, String www, HttpSession session) {
		String user_id = session.getAttribute("user_id") + "";// user_id session으로 받는다
		List<ProductVO> list = service.list();// service단에서 받은 값을 list로 묶어줌
		productuserVO.setUser_id(user_id); // productuserVO에 session으로 받은 user_id를 삽입
		model.addAttribute("list", list);// list를 받아 모델객체로 product_list.do로 넘김
	}

	/*
	 * @RequestMapping("/product/product_list2.do")//인기매물 페이지 public void
	 * product_list2(Model model, String www) { List<ProductVO> list2 =
	 * service.list2(); System.out.println(www + "===========");
	 * model.addAttribute("list2", list2); }
	 */

	/*
	 * @RequestMapping("/product/product_list2.do")//인기매물 페이지 public void
	 * product_list2(ProductUserVO productuserVO, Model model, HttpSession session)
	 * { String user_id = session.getAttribute("user_id")+""; List<ProductVO> list2
	 * = service.list2(); productuserVO.setUser_id(user_id);
	 * model.addAttribute("list2", list2);
	 * 
	 * }
	 */

	@RequestMapping("product/product_search.do") // 상품검색
	public void product_search(ProductUserVO productuserVO, ProductVO productVO, Model model, HttpSession session) {
		String user_id = session.getAttribute("user_id") + "";// user_id session으로 받는다
		List<ProductVO> list1 = service.list1(productVO); // service단에서 받은 값을 list로 묶어줌
		productuserVO.setUser_id(user_id);// productuserVO에 session으로 받은 user_id를 삽입
		System.out.println("제목검색" + list1.size());
		model.addAttribute("list1", list1); // list를 받아 모델객체로 product_search.do로 넘김
	}

	@RequestMapping("product/product_search1.do") // 나이검색
	public void product_search1(ProductUserVO productuserVO, Model model, HttpSession session) {
		String user_id = session.getAttribute("user_id") + "";// user_id session으로 받는다
		List<ProductUserVO> list4 = service.list4(productuserVO); // service단에서 받은 값을 list로 묶어줌
		productuserVO.setUser_id(user_id);// productuserVO에 session으로 받은 user_id를 삽입
		System.out.println("나이대검색" + list4.size());
		model.addAttribute("list4", list4); // list를 받아 모델객체로 product_search1.do로 넘김

	}

	@RequestMapping("product/product_list2.do") // 유저 나이
	public void product_age(ProductUserVO productuserVO, Model model, HttpSession session) {
		String user_id = session.getAttribute("user_id") + "";// user_id session으로 받는다
		System.out.println("컨트롤go");
		productuserVO.setUser_id(user_id);// productuserVO에 session으로 받은 user_id를 삽입
		List<ProductUserVO> list5 = service.one(productuserVO);// service단에서 받은 값을 list로 묶어줌
		model.addAttribute("list5", list5);// list를 받아 모델객체로 product_search1.do로 넘김
		System.out.println("list5" + list5 + productuserVO + "controller");
		System.out.println("컨트롤back");

	}

	@RequestMapping("product/payment_create.do") // 결제
	public void payment_create(PaymentVO paymentVO) {
		System.out.println("나야......");
		//int s = paymentVO.getProduct_id();
		System.out.println(paymentVO.getProduct_id());
		service.insert1(paymentVO);// 입력받은 내용을 service단으로 넘긴다
		service.payupdate(paymentVO); // 상품 결제되면서 product_status 1로 업데이트
	}
	/*
	 * @RequestMapping("product/test.do") public void payment_create2() {
	 * System.out.println("나야222......"); }
	 */

	/*
	 * @RequestMapping("product/product_view.do")//상세페이지 public void one(ProductVO
	 * productVO, Model model, HttpSession session) { ProductVO vo =
	 * service.one(productVO); model.addAttribute("vo", vo); //로그인한 사람 세션으로 설정
	 * session.setAttribute("id", "cspottswoodc1"); // 게시물 하나를 가지고 오고,
	 * model.addAttribute("one", service.one(productVO)); // 게시물의 댓글 리스트를 가지고 와야함.
	 * model.addAttribute("list2", service2.list2(productVO.getProduct_id()));
	 * model.addAttribute("total",
	 * service2.list2(productVO.getProduct_id()).size()); service.count(vo);
	 * System.out.println("vo >>>> "+vo.getProduct_title());
	 * if(session.getAttribute("list3")== null) { System.out.println("List null");
	 * List<ProductVO> list3 = new ArrayList<ProductVO>(); list3.add(vo);
	 * session.setAttribute("list3", list3); }else { List<ProductVO> list3 =
	 * (List<ProductVO>) session.getAttribute("list3");
	 * session.setAttribute("list3", list3); if(list3.size()<3) { list3.add(vo);
	 * }else if (list3.size()>=3) { list3.remove(0); list3.add(vo); }
	 * session.setAttribute("list3", list3); } }
	 */

}
