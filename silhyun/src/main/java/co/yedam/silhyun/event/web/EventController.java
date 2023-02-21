package co.yedam.silhyun.event.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EventController {

	@GetMapping("/eventPage")
	public String eventPage(Model model) {
	
		return "event/eventPage";
	}
	
	@GetMapping("/siteIntroduce")
	public String siteIntroduce() {
		
		return "event/siteIntroduce";
	}
	
	@GetMapping("/eventForm")
	public String eventForm() {
		
		return "event/eventForm";
	}
	
}
 