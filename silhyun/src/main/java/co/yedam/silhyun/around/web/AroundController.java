package co.yedam.silhyun.around.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AroundController {
	
	
	@GetMapping("/around")
	public String around(Model model) {
		return "around";
	}
}
