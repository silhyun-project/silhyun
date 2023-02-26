package co.yedam.silhyun.order.web;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller; 
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import co.yedam.silhyun.member.service.PtgService;
import co.yedam.silhyun.member.vo.PhotographerVO;
@Controller
public class ReserController {

	@Autowired
	private PtgService ptgService;
	
	@RequestMapping("/ptgList") //작가 리스트
		public String ptgList(Model model) {
		model.addAttribute("ptgList", ptgService.getPtgLsit(null));
			return "reser/ptgList";
		}
	
	@RequestMapping("/searchPtgList") //지역, 분야 검색
	@ResponseBody
	public List<PhotographerVO> searchPthList(@RequestBody PhotographerVO vo) {
		System.out.println("vo : "+ vo);
		return ptgService.ptgSearchList(vo);
	}
	
	@GetMapping("/AjaxPtgList/{searchType}") //검색필터
	@ResponseBody
	public List<PhotographerVO> ajaxPtgList(@PathVariable String searchType,PhotographerVO vo) {
		
		System.out.println("searchType : "+ searchType);
		System.out.println("vo : "+ vo);
		return ptgService.getPtgLsit(searchType);
		}
	
	@GetMapping("/ptgDetail/{ptgId}")
	public String ptgDetail(Model model,PhotographerVO vo, @PathVariable String ptgId){
		model.addAttribute("ptg",ptgService.getPtg(ptgId));
		System.out.println(vo);
		System.out.println("호출");
		return "reser/ptgDetail";
	}
	

	
}
