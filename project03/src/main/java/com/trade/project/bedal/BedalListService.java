package com.trade.project.bedal;

import java.text.ParseException;
import java.util.List;

import javax.mail.internet.MimeMessage;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Aspect
@Service("mail")
public class BedalListService implements BedalInterface {
	
	@Autowired
	BedalListDAO dao;
	
	@Autowired
	Algorithm algo;
	
	@Autowired
	private JavaMailSender mailSender;
	
	
	@Override//(정후)
	public BedalListVO mailSend2(BedalListVO vo) throws Exception{
		String setfrom = "dlwjdgn8720@gmail.com"; //보내는사람 이메일
		String tomail = vo.getUser_email(); //받는 사람 이메일
		String title = vo.getUser_name() + "님의 배달현황입니다."; //받는 사람 아이디
		String content = "현재 배송중입니다.";
		
		try {
			//MIME Message 객체 생성
			MimeMessage message = mailSender.createMimeMessage();
			//messager안에 값을 넣어야 하는데,vo같은 클래스 객체를 만들어서
			//값을 넣어주도록 하자.
			MimeMessageHelper messageHelper = new MimeMessageHelper(message,true,"UTF-8");
			messageHelper.setFrom(setfrom);
			messageHelper.setTo(tomail);
			messageHelper.setSubject(title);
			messageHelper.setText(content);
			mailSender.send(message);
			System.out.println("메일전송");	
		} catch (Exception e) {
			System.out.println("메일 보내는 중 에러 발생 ..>>>>"+e);
		}
		return vo;
		
	}
	
	//정후
	@Override
	public List<BedalListVO> list() {
		return dao.list();
	}
	//정후
	@Override
	public BedalListVO one(BedalListVO vo) {
		return dao.one(vo);
	}
	//정후
	@Override
	public void update(BedalListVO vo) {
		dao.update(vo);
    }
	//정후
	@Override
	public void acceptupdate(BedalListVO vo) {
		dao.acceptupdate(vo);
		
	}
	//정후
	@Override
	public void update3(BedalListVO vo) {
		dao.update3(vo);
		
	}
	
	
	
	
	//배달목록 추천(혜정)
	public List<BedalListVO> algolist(String bedal_id) throws ParseException {
		return algo.algolist(bedal_id);
	}
	
	//배달상태 수정(혜정)
	public void update(BedalOriginListVO vo) {
		dao.update(vo);
		System.out.println("서비스 가는중");
	}
	
	
	//배달 승인내역(혜정)
	public List<BedalListVO> approval(String bedal_id) {
		System.out.println(bedal_id);
		return dao.approval(bedal_id);
	}
	
	//최근 본 배달 내역(혜정)
	public List<BedalListVO> bedal_lately(List<String> list) {
		return dao.bedal_lately(list);
	}


}
