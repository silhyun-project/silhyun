package co.yedam.silhyun.member.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PostMapping;

import co.yedam.silhyun.member.service.AdminSercive;
import co.yedam.silhyun.member.vo.MemberVO;

@Controller
public class AdminController {
		
	@Autowired
	private AdminSercive adminService;
	
	@GetMapping("/admin/eventManage")
	public String eventManage() {
		return "/admin/eventManage";
	}
	
	@GetMapping("/admin/memberAccept")
	public String memberAccept() {
		return "/admin/memberAccept";
	}
	
	@RequestMapping("/admin/memberManage")
	public String memberManage(Model model) {
		model.addAttribute("todayMem", adminService.todayMem());
		model.addAttribute("todayPtg", adminService.todayPtg());
		model.addAttribute("todayStd", adminService.todayStd());
		
		model.addAttribute("memberList", adminService.memberList());
		model.addAttribute("ptgList",adminService.ptgList());
		model.addAttribute("stdList",adminService.stdList());
		return "/admin/memberManage";
	}
	
	//@ResponseBody
	@RequestMapping("/deleteMember")
	public String deleteMember(String id) {
		System.out.println("내가 보려는 거 "+id);
		
		int n = adminService.deleteMember(id);

		if(n !=0) {
			System.out.println(id+"삭제완료");
		}else {
		}
		return "redirect:/admin/memberManage";
		//test
	}
	
	@GetMapping("/admin/orderManage")
	public String orderManage() {
		return "/admin/orderManage";
	}
	
	@GetMapping("/admin/qstManage")
	public String qstManage() {
		return "/admin/qstManage";
	}
	
	@GetMapping("/admin/quitManage")
	public String quitManage(Model model) {
		model.addAttribute("qtList",adminService.qtList());
		return "/admin/quitManage";
	}
	
	@GetMapping("/admin/rankManage")
	public String rankManage() {
		return "/admin/rankManage";
	}
	
	@GetMapping("/admin/reportManage")
	public String reportManagr() {
		return "/admin/reportManage";
	}
	
	@GetMapping("/admin/adminManage")
	public String adminManage(Model model) {
		model.addAttribute("adminInfo", adminService.adminInfo());
		return "/admin/adminManage";
	}
	
	@GetMapping("/admin/dashBoard")
	public String dashBoard() {
		return "/admin/dashBoard";
	}
	
}

