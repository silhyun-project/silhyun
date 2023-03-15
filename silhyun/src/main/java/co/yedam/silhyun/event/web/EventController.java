package co.yedam.silhyun.event.web;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import co.yedam.silhyun.SessionUser;
import co.yedam.silhyun.event.service.EventService;
import co.yedam.silhyun.mypage.vo.ChulcheckVO;

@Controller
public class EventController {

	@Autowired
	private EventService eventService;

	@RequestMapping("/silhyun/eventPage")
	public String eventPage(Model model,HttpSession httpSession) {
		SessionUser user = (SessionUser) httpSession.getAttribute("user");  //세션 담기
		if(user != null) {  //세션
			model.addAttribute("id",user.getId());
			model.addAttribute("role",user.getRole());
		}
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

	@PostMapping("/silhyun/chulcheckEv")
	@ResponseBody
	public boolean chulcheckEv(@RequestParam String id, 
	                       @RequestParam  @DateTimeFormat(pattern = "yyyy-MM-dd") Date checkDate,
	                        Model model) {			//면 @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)가 없으면 Localdate를 불러 올 수 없다
		System.out.println("들어오는감++++++++++++++++");
		
		List<ChulcheckVO> cvo = eventService.chulIdSelect(id);	
		ChulcheckVO vo = new ChulcheckVO();
		vo.setId(id);
	 	if(cvo.size()!=0) {
		Date date= cvo.get(0).getCheckDate();	//db에 들어 가있는 시간
		System.out.println(date+"db값123123");
	
		System.out.println(checkDate + "들어오는 값 1111111111");
		

	    if (checkDate.equals(date)) {		//오늘 지역 날짜 == db에 있는 날짜
	    
	        System.out.println("rrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrr");
	    } else {											//조회도 되고 날짜도 다르다면
	    	//ChulcheckVO vo = new ChulcheckVO();
	    	 eventService.updateChulcheck(vo);
	
	    	 System.out.println("rrrrrrrrrrrrrrr3333333333333333333rrrrr");
	    	
	    }
	  
	 	}else if (cvo.isEmpty()){						//정보 조회가 안된다면
	    	//ChulcheckVO vo = new ChulcheckVO();
	    	System.out.println("rrrrrrrrrrrrrr2들어왔나?");
	    	vo.setCheckDate(checkDate);					//날짜 넣기
	    	 eventService.insertChulcheck(vo);
	       
	    }
	 	
	 	
		 return true;
	}
	
	@RequestMapping("/silhyun/chulcheck")
	public String chulchecck(Model model) {
		//local Date생성
		LocalDateTime now = LocalDateTime.now(); // 현재 시간 정보를 가진 LocalDateTime 객체
		
		//localDate=> date 변환
		ZoneId zone = ZoneId.systemDefault(); // 현재 시스템 시간대 정보를 가진 ZoneId 객체		
		Date date = Date.from(now.atZone(zone).toInstant()); // Date 객체로 변환

		// Date 객체를 String 형식으로 변환
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String dateString = dateFormat.format(date);
		
		model.addAttribute("date", dateString);
		//model.addAttribute("time", time);
		
		
		return "event/chulcheck";
	}

}
