package co.yedam.silhyun.common.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import co.yedam.silhyun.common.service.PageTestService;
import co.yedam.silhyun.common.vo.Criteria;
import co.yedam.silhyun.common.vo.PageVO;
import javassist.expr.NewArray;

@Controller
public class CommonController {

	@Autowired PageTestService pService;
	
	@GetMapping("/reviewList")
	public String reviewList(Criteria cri, Model model) {
		model.addAttribute("list", pService.getListReview(cri));
		model.addAttribute("page", new PageVO(pService.getTotalCount(), 10, cri));
		return "home/pagingTest";
	}
}
