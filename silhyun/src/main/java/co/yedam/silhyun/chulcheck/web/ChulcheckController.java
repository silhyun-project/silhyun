package co.yedam.silhyun.chulcheck.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ChulcheckController {

	@GetMapping("/chulcheckPage")
	public String chulcheckPage() {
		
		return "event/chulcheck";
	}
}
