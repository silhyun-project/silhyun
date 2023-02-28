package co.yedam.silhyun.common.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import co.yedam.silhyun.common.service.ReviewService;
import co.yedam.silhyun.common.vo.ReviewVO;

@Controller
@CrossOrigin(value = "*")
public class ReviewController {
	
	@Autowired ReviewService rService;
	
	@GetMapping("silhyun/reviewform")
	public String reviewForm() {
		return "review/reviewForm";
	}

	@GetMapping("silhyun/review")
	public String test() {
		return "review/test";
	}
	
	@PostMapping("silhyun/review")
	public String reviewInsert(ReviewVO vo) {
		vo.setCtgr("A");
		rService.reviewInsert(vo);
		return "review/test";
	}
}
