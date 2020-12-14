package com.trade.project.bedal;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class BedalListController {
	
	@Autowired
	BedalListService service;
	
	
	// 배달내역 검색(정후)
	@RequestMapping("admin/admin_bedal.do")
	public void list(Model model) {
		List<BedalListVO> list = service.list();
		model.addAttribute("list", list);
	}

	// 배달상세 검색(정후)
	@RequestMapping("admin/admin_bedalajax.do")
	public void one(BedalListVO vo, Model model) {
		BedalListVO one = service.one(vo);
		model.addAttribute("one", one);
		System.out.println("컨트롤러  bedal" + vo.getBedal_id());
		System.out.println("컨트롤러  user" + vo.getUser_id());
	}

	// 해당 배달 거절
	@RequestMapping("admin/admin_bedal_reject.do")
	public void update(BedalListVO vo) {
		service.update(vo);
	}

	// 해당 배달 수락,배송중 이메일
	@RequestMapping("admin/admin_bedal_accept.do")
	public void acceptupdate(BedalListVO bedallistVO) throws Exception{
		service.acceptupdate(bedallistVO);
		service.mailSend2(bedallistVO);
	}

	// 해당 배달 타이머 지나면 완료
	@RequestMapping("admin/admin_bedal_done.do")
	public void update3(BedalListVO vo) {
		service.update3(vo);
	}
	
	
	


	//배달상세화면(혜정)
	@RequestMapping("bedal/bedal_list/bedal_detail.do")
	public void detail(String button_index, Model model) {
		model.addAttribute("bu", button_index);
	}
	@ResponseBody //json으로 데이터 반환
	@RequestMapping("bedal/bedal_list/bedal_detail1.do")
	public List<BedalListVO> detail1(HttpSession session, Model model) throws ParseException {
		String bedal_id = (String) session.getAttribute("bedal_id"); //세션에 저장된 아이디 가져오기
		List<BedalListVO> detail = service.algolist(bedal_id);//아이디 값을 넣어서 데이터를 detail 리스트로 저장
		model.addAttribute("detail", detail);//모델에 저장
		return detail;//리턴
	}
	
	//배달상태 수정, 아이디 저장(혜정)
	@RequestMapping("bedal/bedal_list/bedal_update.do")
	public void update(BedalOriginListVO vo, HttpSession session) {
		String bedal_id = (String) session.getAttribute("bedal_id");
		vo.setBedal_id(bedal_id);
		service.update(vo);
		System.out.println(vo);
	}

	
	//배달 목록, 배달승인내역(혜정)
	@RequestMapping("bedal/bedal_list/bedal_list.do")
	public void algolist(Model model, HttpSession session) throws ParseException {
		String bedal_id = (String) session.getAttribute("bedal_id");
		List<BedalListVO> algolist = service.algolist(bedal_id);
		List<BedalListVO> approval = service.approval(bedal_id);
		model.addAttribute("algolist", algolist);
		model.addAttribute("approval", approval);
	}
	
	
	//최근 본 배달 내역(혜정)
    @RequestMapping("bedal/bedal_list/bedal_lately.do")
    @ResponseBody
    public List<BedalListVO> bedal_lately(BedalListVO vo, HttpSession session) {
        //model이 컨트롤러 통해서 뷰까지만 한번만 보내줌
        //session 계속 가지고 있음
        //model 안에 session값 저장해도 끊김
        if(session.getAttribute("list") == null) {//session에 저장된 값이 없으니까
            List<BedalListVO> list2 = new ArrayList<BedalListVO>(); //list2를 만들어서
            list2.add(vo);//list2에 vo를 add 시켜줌
            session.setAttribute("list2", list2);//vo를 담아둔 list2를 session에 저장
            return list2;
        
        }else {
            List<BedalListVO> list2 = (List<BedalListVO>) session.getAttribute("list2");//session에 list2를 담아줌
            session.setAttribute("list2", list2);
            
            if(list2.size()<5) {//list2.size가 5보다 작으면
                list2.add(vo);//5개까지만 vo를 add시켜줌
                
            }else if (list2.size()>=5) {//list3.size가 5보다 크거나 같으면
                list2.remove(0);//vo의 첫번째 항목을 remove시킨다
                list2.add(vo);//vo에 마지막 항목을 담아서 list2에 add시켜줌           
            }
            session.setAttribute("list2", list2);//session을 받아 list에 담는다(새 리스트를 넣어줌)
            System.out.println("list >>>> "+ list2);
            
            return list2;
        }
    }

	
	
	
}
