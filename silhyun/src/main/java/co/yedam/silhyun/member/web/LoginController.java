package co.yedam.silhyun.member.web;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import co.yedam.silhyun.SessionUser;

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
