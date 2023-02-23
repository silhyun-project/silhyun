package co.yedam.silhyun.order.web;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import co.yedam.silhyun.member.service.PtgService;
import co.yedam.silhyun.member.vo.PhotographerVO;
@Controller
public class ReserController {

	@Autowired
	private PtgService ptgService;
	
	@RequestMapping("/ptgList")
		public String ptgList(Model model) {
		model.addAttribute("ptgList", ptgService.getPtgLsit());
			return "reser/ptgList";
		}
	
	@RequestMapping("/searchPtgList")
	@ResponseBody
	public List<PhotographerVO> searchPthList(@RequestBody PhotographerVO vo) {
		
		System.out.println(vo);

		return ptgService.ptgSearchList(vo);
	
		
	}
}
