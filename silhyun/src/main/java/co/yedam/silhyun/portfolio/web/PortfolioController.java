package co.yedam.silhyun.portfolio.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PortfolioController {

	
	@GetMapping("/portfolio")
	public String around(Model model) {
		return "portfolio/portfolio";
	}
}
