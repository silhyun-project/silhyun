package co.yedam.silhyun.portfolio.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PortfolioController {

	
	@GetMapping("/silhyun/portfolio")
	public String portfolio(Model model) {
		return "portfolio/portfolio";
	}
	
	@RequestMapping("/silhyun/portfolioInsertForm")
	public String portfolioInsertForm(Model model) {
		return "portfolio/portfolioInsertForm";
	}
	
	@RequestMapping("/silhyun/modalTest")//모달화면구현
	public String modalTest(Model model) {
		return "portfolio/modalTest";
	}
	
}
