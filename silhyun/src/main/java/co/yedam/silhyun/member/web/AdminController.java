package co.yedam.silhyun.member.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
		model.addAttribute("memberList", adminService.memberList());
		model.addAttribute("ptgList",adminService.ptgList());
		model.addAttribute("stdList",adminService.stdList());
		return "/admin/memberManage";
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

