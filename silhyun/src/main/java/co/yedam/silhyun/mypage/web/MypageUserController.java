package co.yedam.silhyun.mypage.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MypageUserController {
   
   @GetMapping("/mpg/mpgOrderList/{ptgId}")
   public String mpgOrderList() {
      
      return "mypageUser/mpgOrderList";
   }
   
   @GetMapping("/mpg/mpgCouponList/{ptgId}")
   public String mpgCouponList() {
      
      return "mypageUser/mpgCouponList";
   }
   
   @GetMapping("/mpg/mpgQstPage")
   public String mpgQstPage() {
      
      return "mypageUser/mpgQstPage";
   }

   @GetMapping("/mpg/mpgUser/{ptgId}")
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
