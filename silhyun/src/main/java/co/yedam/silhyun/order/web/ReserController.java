package co.yedam.silhyun.order.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import co.yedam.silhyun.common.service.PageTestService;
import co.yedam.silhyun.common.vo.Criteria;
import co.yedam.silhyun.common.vo.PageVO;
import co.yedam.silhyun.member.service.PtgService;
import co.yedam.silhyun.member.vo.PhotographerVO;

@Controller
public class ReserController {

	@Autowired
	private PtgService ptgService;

	@RequestMapping("/silhyun/ptgList") // 작가 리스트
	public String ptgList(Criteria cri, Model model, PhotographerVO vo) {
		cri.setAmount(6);
		model.addAttribute("list", ptgService.getPtgLsit(cri, vo));
		model.addAttribute("page", new PageVO(ptgService.getTotalCount(cri, vo), 10, cri));
		model.addAttribute("ptgList", ptgService.getPtgLsit(cri, vo));
		return "reser/ptgList";
	}

	@RequestMapping("/silhyun/searchPtgList") // 지역, 분야 검색
	@ResponseBody
	public List<PhotographerVO> searchPthList(@RequestBody PhotographerVO vo,Criteria cri, Model model) {
		cri.setAmount(6);
		System.out.println("vo : " + vo);
		model.addAttribute("list", ptgService.ptgSearchList(cri, vo));
		model.addAttribute("page", new PageVO(ptgService.getTotalListCount(cri, vo), 10, cri));
		return ptgService.ptgSearchList(cri,vo);
	}

	@GetMapping("/silhyun/AjaxPtgList/{searchType}") // 검색 필터
	@ResponseBody
	public List<PhotographerVO> ajaxPtgList(Model model,@PathVariable String searchType, PhotographerVO vo, Criteria cri) {
		cri.setAmount(6);
		model.addAttribute("list", ptgService.getPtgLsit(cri, vo));
		model.addAttribute("page", new PageVO(ptgService.getTotalCount(cri, vo), 10, cri));
		return ptgService.getPtgLsit(cri, vo);
	}

	@GetMapping("/silhyun/ptgDetail/{ptgId}") // 작가 한명 상세페이지
	public String ptgDetail(Model model, PhotographerVO vo, @PathVariable String ptgId) {
		model.addAttribute("ptg", ptgService.getPtg(ptgId));
		System.out.println(vo);
		System.out.println("호출");
		return "reser/ptgDetail";
	}

	@RequestMapping("/silhyun/stdList")
	public String studioList(Model model) {
		// model.addAttribute("stdList");
		return "reser/stdList";
	}

}
