package co.yedam.silhyun.portfolio.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import co.yedam.silhyun.portfolio.service.AroundService;
import co.yedam.silhyun.portfolio.vo.PortfolioVO;

@Controller
public class AroundController {

	@Autowired
	private AroundService aroundService;

	@RequestMapping("/silhyun/around")
	public String around(Model model) {
		model.addAttribute("portfolioList", aroundService.getAroundList());
		return "portfolio/around";
	}

	@RequestMapping("/silhyun/aroundTagList")
	@ResponseBody
	public List<PortfolioVO> aroundTagList(@RequestBody PortfolioVO tagCntn) {
		
		return aroundService.aroundTagList(tagCntn);
	}

}
