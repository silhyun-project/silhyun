package co.yedam.silhyun.photographer.web;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

public class PtgController {

	@GetMapping("/ptgList")
		public String ptgList(Model model) {
			return "ptgList";
		}
	
}
