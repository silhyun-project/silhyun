package co.yedam.silhyun.mypage.web;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import co.yedam.silhyun.SessionUser;
import co.yedam.silhyun.mypage.service.MypageUserService;



@Controller
public class MypageUserController {
	
	@Autowired
	private MypageUserService mpgService;
   
   @GetMapping("/mpg/mpgOrderList")
   public String mpgOrderList() {
      
      return "mypageUser/mpgOrderList";
   }
   
   @GetMapping("/mpg/mpgCouponList")
   public String mpgCouponList(Model model ,HttpSession session ) {
	   model.addAttribute("id",session.getAttribute("id"));
		String id = (String) session.getAttribute("id");
		model.addAttribute("myCp",mpgService.selectMyCoupon(session.getId()));
		
		
      return "mypageUser/mpgCouponList";
   }
   
   @GetMapping("/mpg/mpgQstPage")
   public String mpgQstPage() {
      
      return "mypageUser/mpgQstPage";
   }

   @GetMapping("/mpg/mpgUser")
   public String mpgUser() {
      
      return "mypageUser/mpgUser";
   }

   @GetMapping("/mpg/mpgEditProfile")
   public String mpgEditProfile() {
      
      return "mypageUser/mpgEditProfile";
   }
   
   @GetMapping("/mpg/mpgCalendar")
   public String mpgCalendar(Model model,HttpSession httpSession) {
      SessionUser user = (SessionUser) httpSession.getAttribute("user");
      
      return "mypageUser/mpgCalendar";	
   }
   
   @GetMapping("/mpg/mpgQuit/{id}")
   public String mpgQuit() {
      
      return "mypageUser/mpgQuit";
   }
   
   @GetMapping("/mpg/checkPwd")
   public String checkPassword() {
	   
	   return "mypageUser/checkPwd";
   }
   
   @GetMapping("/mpg/quitComplete")
   public String withdrawalComplete() {
	   
	   return "mypageUser/quitComplete";
   }
   
   
   
}
