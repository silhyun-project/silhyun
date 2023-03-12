package co.yedam.silhyun.qst.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import co.yedam.silhyun.common.vo.CommentVO;
import co.yedam.silhyun.qst.service.QstService;
import co.yedam.silhyun.qst.vo.QstVO;

public class QstController {

	@Autowired
	private QstService qstService;
	
	@RequestMapping("/qst/aoQst")
	public String aoQst(Model model) {
		model.addAttribute("aoQstList", qstService.getAoQstList());
		return "qst/aoQst";
	}
	
	@GetMapping("/aoQstList")
	@ResponseBody
	public List<QstVO> aoQstList(QstVO vo, Model model){
		List<QstVO> aQstList = qstService.getAoQstList();
		return aQstList;
	}
	
	@PostMapping("/aoQstInsert")
	@ResponseBody
	public String aoQstInsert(@RequestBody QstVO vo) {
		
		qstService.aoQstInsert(vo);
		return "seccess";
	}	
	
	
	
	
}
