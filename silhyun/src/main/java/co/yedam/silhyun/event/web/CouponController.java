package co.yedam.silhyun.event.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import co.yedam.silhyun.event.service.CouponService;
import co.yedam.silhyun.event.vo.CouponHistoryVO;

@Controller
public class CouponController {
	
	@Autowired
	private CouponService couponService;

	@RequestMapping("/silhyun/eventCoupon")
	public String eventCoupon(Model model) {
		model.addAttribute("couponList", couponService.couponSelectList());
		
		return "coupon/eventCoupon";
	}
	
	@GetMapping("/myCoupon")
	public String myCoupon(Model model) {
		
		return "coupon/myCoupon";
	}
	
	@PostMapping("/silhyun/getCoupon")
	@ResponseBody
	public boolean getCoupon(CouponHistoryVO hvo) {
		couponService.insertCoupon(hvo);
	
		return true;
	}
}
