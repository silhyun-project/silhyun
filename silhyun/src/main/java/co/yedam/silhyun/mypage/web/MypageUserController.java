package co.yedam.silhyun.mypage.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import co.yedam.silhyun.SessionUser;
import co.yedam.silhyun.mypage.service.MypageUserService;
import co.yedam.silhyun.mypage.vo.ScheduleVO;



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
		model.addAttribute("myCp",mpgService.selectMyCoupon(id));
		
		
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
   public String mpgCalendar(Model model) {
      
      return "mypageUser/mpgCalendar";	
   }
   
   @GetMapping("/getScheduleList")
   @ResponseBody
   List<ScheduleVO> getScheduleList() {
	   List<ScheduleVO> getScheduleList = mpgService.getScheduleList();
	   System.out.println(getScheduleList+"dddddddddddddddddddddddddd");
	   return getScheduleList;
   }
   
   @PostMapping("/scheduleInsert")
   @ResponseBody
   public Map<String, Object> scheduleInsert(@RequestBody ScheduleVO vo) {
	   System.out.println(vo.getCntn());
	   System.out.println("========================================================");
	    int n = mpgService.scheduleInsert(vo);
	    System.out.println(vo);
	   Map<String, Object> map = new HashMap<String, Object>();
	   map.put("todo", vo);
	   map.put("res", n);

	   return map;
   }
   
   @DeleteMapping("/scheduleDelete")
   public String scheduleDelete(ScheduleVO vo) {
       mpgService.scheduleDelete(vo);
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
