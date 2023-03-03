package co.yedam.silhyun.portfolio.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import co.yedam.silhyun.portfolio.service.AroundService;
import co.yedam.silhyun.portfolio.vo.PortfolioVO;
import co.yedam.silhyun.portfolio.vo.TagVO;

@Controller
public class AroundController {

	@Autowired      
	private AroundService aroundService;

	@RequestMapping("/silhyun/around")
	public String around(Model model) {
		model.addAttribute("portfolioList", aroundService.getAroundList());
		return "portfolio/around";
	}
	//@ResponseBody 제이슨 객체로 받아올라면 ~ 이거 꼭 써야햇....
	@RequestMapping("/silhyun/aroundTagList")
	@ResponseBody
	public List<PortfolioVO> aroundTagList(PortfolioVO tagCntn) {
		
		return aroundService.aroundTagList(tagCntn);
	}
	
	@RequestMapping("/silhyun/tagList")//태그리스트 가져오기..
	@ResponseBody
	public List<TagVO> tagList(Model model) {
		return aroundService.tagList();
	}
	
	@RequestMapping("/silhyun/detailPortfolio/{portNum}")//태그리스트 가져오기..
	@ResponseBody
	public List<PortfolioVO> detailPort(Model model, PortfolioVO vo, @PathVariable String portNum) {
		model.addAttribute("detailPortfolio", aroundService.detailPortfolio(portNum));
		return aroundService.detailPortfolio(portNum);
	}

}
