package co.yedam.silhyun.portfolio.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import co.yedam.silhyun.portfolio.service.AroundService;



@Controller
public class AroundController {
	
	
	@Autowired
	private AroundService aroundService;
	
	@GetMapping("/around")
	public String around(Model model) {
		model.addAttribute("portfolioList",aroundService.getPortfolioList());
		return "portfolio/around";
	}
	
	
	
}
