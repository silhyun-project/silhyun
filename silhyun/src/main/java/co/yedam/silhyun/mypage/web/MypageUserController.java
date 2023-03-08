package co.yedam.silhyun.mypage.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MypageUserController {
   
   @GetMapping("/mpg/mpgOrderList")
   public String mpgOrderList() {
      
      return "mypageUser/mpgOrderList";
   }
   
   @GetMapping("/mpg/mpgCouponList")
   public String mpgCouponList() {
      
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
   public String mpgCalendar() {
      
      return "mypageUser/mpgCalendar";
   }
   
   @GetMapping("/mpg/withdrawal")
   public String withdrawal() {
      
      return "mypageUser/withdrawal";
   }
   
   @GetMapping("/mpg/checkPassword")
   public String checkPassword() {
	   
	   return "mypageUser/checkPassword";
   }
   
   @GetMapping("/mpg/withdrawalComplete")
   public String withdrawalComplete() {
	   
	   return "mypageUser/withdrawalComplete";
   }
   
   
   
}
