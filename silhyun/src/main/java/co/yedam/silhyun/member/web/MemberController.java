package co.yedam.silhyun.member.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemberController {
		
	@Autowired
	
	@GetMapping("/memberList")
	public String memberList() {
		return "/admin/memberList";
	}
	

	
}

