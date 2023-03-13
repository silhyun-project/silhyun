package co.yedam.silhyun.member.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import co.yedam.silhyun.member.service.EmailService;
import co.yedam.silhyun.member.service.MemberService;
import co.yedam.silhyun.member.vo.MemberVO;

@RestController
public class joinController {
	@Autowired MemberService memberService;
	@Autowired EmailService emailService;
	
	@PostMapping("/silhyun/idCk")
	public boolean idCk(MemberVO vo) {
		return memberService.isidCheck(vo);
	}
	
	@GetMapping("/silhyun/emailCk")
	public String emailCk(String email){
		String code = emailService.sendSimpleMessage(email);
		
		return code;
	}
}
