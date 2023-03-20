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

}
