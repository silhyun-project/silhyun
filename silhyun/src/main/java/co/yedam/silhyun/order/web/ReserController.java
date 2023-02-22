package co.yedam.silhyun.order.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import co.yedam.silhyun.member.service.PtgService;
@Controller
public class ReserController {

	@Autowired
	private PtgService ptgService;
	
	@RequestMapping("/ptgList")
		public String ptgList(Model model) {
		model.addAttribute("ptgList", ptgService.getPtgLsit());
			return "reser/ptgList";
		}
	
}
