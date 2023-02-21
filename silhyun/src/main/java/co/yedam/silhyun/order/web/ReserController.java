package co.yedam.silhyun.order.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class ReserController {

	@GetMapping("/ptgList")
		public String ptgList(Model model) {
		
			return "reser/ptgList";
		}
	
}
