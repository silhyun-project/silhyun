package co.yedam.silhyun.mypage.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MypageUserController {
	
	@GetMapping("/mpgOrderList")
	public String mpgOrderList() {
		
		return "mypageUser/mpgOrderList";
	}
	
	@GetMapping("/mpgCouponList")
	public String mpgCouponList() {
		
		return "mypageUser/mpgCouponList";
	}
	
	@GetMapping("/mpgQstPage")
	public String mpgQstPage() {
		
		return "mypageUser/mpgQstPage";
	}

	@GetMapping("/mpgUser")
	public String mpgUser() {
		
		return "mypageUser/mpgUser";
	}

	@GetMapping("/mpgEditProfile")
	public String mpgEditProfile() {
		
		return "mypageUser/mpgEditProfile";
	}
	
	@GetMapping("/commentReply")
	public String commentReply() {
		
		return "mypageUser/commentReply";
	}
	
}
