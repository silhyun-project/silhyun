package co.yedam.silhyun.order.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import co.yedam.silhyun.common.vo.Criteria;
import co.yedam.silhyun.common.vo.PageVO;
import co.yedam.silhyun.member.service.PtgService;
import co.yedam.silhyun.member.service.StdService;
import co.yedam.silhyun.member.vo.PhotographerVO;
import co.yedam.silhyun.member.vo.StudioVO;

@Controller
public class ReserController {
	@Autowired PtgService ptgService;
	@Autowired StdService stdService;

	@RequestMapping("/silhyun/ptgList") // 작가 리스트
	public String ptgList(Criteria cri, Model model, PhotographerVO vo) {
		cri.setAmount(3);
		System.out.println("나와라=============================="+vo.getChkArray());
		model.addAttribute("ptgList", ptgService.getPtgLsit(cri, vo));
		model.addAttribute("page", new PageVO(ptgService.getTotalCount(cri, vo), 10, cri));
//		model.addAttribute("ptgList", ptgService.getPtgLsit(cri, vo));
		return "reser/ptgList";
	}
//
//	@RequestMapping("/silhyun/searchPtgList") // 지역, 분야 검색
//	@ResponseBody
//	public List<PhotographerVO> searchPthList(@RequestBody PhotographerVO vo,Criteria cri, Model model) {
//		cri.setAmount(6);
//		System.out.println("vo : " + vo);
//		model.addAttribute("list", ptgService.ptgSearchList(cri, vo));
//		model.addAttribute("page", new PageVO(ptgService.getTotalListCount(cri, vo), 10, cri));
//		return ptgService.ptgSearchList(cri,vo);
//	}
//
//	@GetMapping("/silhyun/AjaxPtgList/{searchType}") // 검색 필터
//	@ResponseBody
//	public List<PhotographerVO> ajaxPtgList(Model model,@PathVariable String searchType, PhotographerVO vo, Criteria cri) {
//		cri.setAmount(6);
//		model.addAttribute("list", ptgService.getPtgLsit(cri, vo));
//		model.addAttribute("page", new PageVO(ptgService.getTotalCount(cri, vo), 10, cri));
//		return ptgService.getPtgLsit(cri, vo);
//	}

	@GetMapping("/silhyun/ptgDetail/{ptgId}") // 작가 한명 상세페이지
	public String ptgDetail(Model model, PhotographerVO vo, @PathVariable String ptgId) {
		
		model.addAttribute("ptg", ptgService.getPtg(ptgId));
		System.out.println(vo);
		System.out.println("호출");
		return "reser/ptgDetail";
	}
	
	
	@RequestMapping("/silhyun/stdList")  //사진관 전체 리스트
	public String studioList(Criteria cri,Model model,StudioVO vo) {
		cri.setAmount(3);
		// model.addAttribute("stdList");
		model.addAttribute("page", new PageVO(stdService.getTotalCount(cri, vo), 10, cri));
		model.addAttribute("stdList",stdService.getStdList(cri, vo));
		System.out.println(vo);
		return "reser/stdList";
	}
	
	@RequestMapping("/silhyun/stdDetail/{stId}") //사진관 상세 보기
	public String stdDetail(Model model,StudioVO vo, @PathVariable String stId) {
		model.addAttribute("std",stdService.getStd(stId));
		return "reser/stdDetail";
	}

}
