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

}
