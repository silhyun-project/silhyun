package co.yedam.silhyun.member.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import co.yedam.silhyun.member.service.MemberService;
import co.yedam.silhyun.member.vo.MemberVO;

@RestController
public class RestLoginController {
	@Autowired MemberService mService;
	
	@PostMapping("/findId")
	public String findId(MemberVO vo) {
		String id = "";
		id = mService.findid(vo);
		return id;
		
	}
	
	@PostMapping("/findPwd")
	public String findPwd(MemberVO vo) {
		String msg = "";
		//pwd여부 int값 체크 
		
		//0보다 크면 임시 비번 이메일 발송후 코드 값을 암호화 해서 멤버정보 수정
		
		return msg;
	}

}
