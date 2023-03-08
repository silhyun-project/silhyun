package co.yedam.silhyun.member.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
	
	@GetMapping("/login")
	public String login() {
		return "login/loginForm";
	}

	@GetMapping("/fingInfoForm")
	public String findInfoForm() {
		return "login/fingInfoForm";
	}
	@GetMapping("/silhyun/joinForm")
	public String joinForm() {
		return "join/joinForm";
	}
	@GetMapping("/silhyun/joinEnd")
	public String joinEnd() {
		return "join/joinCompl";
	}
	
	@GetMapping("/login/naver")
	public String loginNaver(String code) {
		System.out.println(code);
		
		return "home/home";
	}

}
