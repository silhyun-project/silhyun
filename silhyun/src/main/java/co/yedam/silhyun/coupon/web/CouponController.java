package co.yedam.silhyun.coupon.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CouponController {

	@GetMapping("/eventCoupon")
	public String eventCoupon() {
		
		return "event/eventCoupon";
	}
	
	@GetMapping("/myCoupon")
	public String myCoupon(Model model) {
		
		return "coupon/myCoupon";
	}
}
