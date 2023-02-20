package co.yedam.silhyun;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SilhyunController {
	
	@GetMapping("/silhyun")
	public String silhyun() {
		
		return "silhyun";
	}
	
}
