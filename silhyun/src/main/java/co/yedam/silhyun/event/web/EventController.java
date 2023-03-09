package co.yedam.silhyun.event.web;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import co.yedam.silhyun.event.service.EventService;
import co.yedam.silhyun.mypage.vo.ChulcheckVO;

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

	@RequestMapping("/silhyun/chulcheckEv")
	public String chulcheckEv(@RequestParam("id") String id, 
	                        @RequestParam("checkDate") LocalDate checkDate,
	                        Model model) {			//값 이상하면 @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate하기 

	    LocalDate now = LocalDate.now();	//페이지 내 날짜
	    if (checkDate.equals(now)) {		//오늘날짜 = 페이지날짜
	        model.addAttribute("result", "이미 오늘 출석했습니다");
	    } else {
	    	ChulcheckVO chulcheckVO = new ChulcheckVO();
	    	eventService.insertChulcheck(chulcheckVO);
	        model.addAttribute("result", "출석체크 완료🎉");
	    }
	    return "redirect:/silhyun/chulcheck";
	}
	
	@RequestMapping("/silhyun/chulcheck")
	public String chulchecck(Model model) {
		LocalDateTime now = LocalDateTime.now();
		String date = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		String time = now.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
		model.addAttribute("date", date);
		model.addAttribute("time", time);
		
		
		return "event/chulcheck";
	}

}
