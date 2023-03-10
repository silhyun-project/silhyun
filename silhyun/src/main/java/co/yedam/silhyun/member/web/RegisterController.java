package co.yedam.silhyun.member.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RegisterController {
	@RequestMapping("/shin/ptgRegister")
	public String ptgRegister() {
		return "home/ptgRegisterForm";
	}
}
