package co.yedam.silhyun.mypage.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class mypageUserController {
	
	@GetMapping("/mypageOrderList")
	public String mypageOrderList() {
		
		return "mypageUser/mypageOrderList";
	}
	
	@GetMapping("/mypageCouponList")
	public String mypageCouponList() {
		
		return "mypageUser/mypageCouponList";
	}


}
