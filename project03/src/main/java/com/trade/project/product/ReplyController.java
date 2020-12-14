package com.trade.project.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ReplyController {
	
	@Autowired
	ReplyService service;
	// 의존성 주입(di) 할 때는 ReplyService클래스의
	// 싱글톤 객체가 있는지, 찾아서, 그 주소를 주입!!
	// "클래스의 타입"을 가지고 주입!!
	
	
	@RequestMapping(value="product/delete.do", method=RequestMethod.GET)
	public String delete(ReplyVO replyVO) {
		int result = service.delete(replyVO);
		if (result == 1 ) {
			// response.sendRedirect("one.do?no=" + replyVO.getOriginal());
			return "redirect: product_view.do?product_id=" + replyVO.getOriginal();
					
		} else {
			return "fail";  // views/fail.jsp를 호출
		}
		
	}
	
	@RequestMapping("product/create.do")//
	public String create(ReplyVO replyVO) {
		  System.out.println("댓글 달러 갈꺼야");
		int result = service.create(replyVO);
		System.out.println("댓글달고 글 가져올꺼야");
		if (result == 1) {
			System.out.println("답글이 잘 저장 되었다." + replyVO);
			// 답글이 잘 저장 되었다.
			return "ok";//jsp파잏	
			} else {
				System.out.println("나답글 저장할 때 문제가 생겼다.");
			// 답글 저장할 때 문제가 생겼다.
			return "fail";
		}
	}
	
	
	
}
