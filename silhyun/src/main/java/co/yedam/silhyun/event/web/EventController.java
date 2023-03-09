package co.yedam.silhyun.event.web;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import co.yedam.silhyun.event.service.EventService;

@Controller
public class EventController {

	@Autowired
	private EventService eventService;

	@RequestMapping("/silhyun/eventPage")
	public String eventPage(Model model) {
		model.addAttribute("eventPage", eventService.getEventList());
		model.addAttribute("bannerList", eventService.getBannerList());
		return "event/eventPage";
	}

	@GetMapping("/silhyun/siteIntroduce")
	public String siteIntroduce() {

		return "event/siteIntroduce";
	}

	@GetMapping("/eventForm")
	public String eventForm() {

		return "event/eventForm";
	}

	@RequestMapping("/silhyun/chulcheck")
	public String chulcheck(Model model) {

		LocalDateTime now = LocalDateTime.now();
		String date = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		String time = now.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
		model.addAttribute("date", date);
		model.addAttribute("time", time);
		

		return "event/chulcheck";
	}

}
