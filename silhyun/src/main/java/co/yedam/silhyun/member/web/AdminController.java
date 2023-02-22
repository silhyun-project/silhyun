package co.yedam.silhyun.member.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {
		
	@Autowired
	
	@GetMapping("/admin/eventManage")
	public String eventManage() {
		return "/admin/eventManage";
	}
	
	@GetMapping("/admin/memberAccept")
	public String memberAccept() {
		return "/admin/memberAccept";
	}
	
	@GetMapping("/admin/memberManage")
	public String memberManage() {
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
	public String quitManage() {
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
	public String adminManage() {
		return "/admin/adminManage";
	}
	
	@GetMapping("/admin/dashBoard")
	public String dashBoard() {
		return "/admin/dashBoard";
	}
	
}

