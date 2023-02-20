package co.yedam.silhyun;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SilhyunController {
	
	@GetMapping("/silhyun")
	public String silhyun() {
		
		return "silhyun";
	}
	

	
}
