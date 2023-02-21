package co.yedam.silhyun.member.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {
		
	@Autowired
	
	@GetMapping("/eventManage")
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
	
	@GetMapping("/orderManage")
	public String orderManage() {
		return "/admin/orderManage";
	}
	
	@GetMapping("/qstManage")
	public String qstManage() {
		return "/admin/qstManage";
	}
	
	@GetMapping("/quitManage")
	public String quitManage() {
		return "/admin/quitManage";
	}
	
	@GetMapping("/rankManage")
	public String rankManage() {
		return "/admin/rankManage";
	}
	
	@GetMapping("/reportManagr")
	public String reportManagr() {
		return "/admin/reportManagr";
	}
	

	
}

