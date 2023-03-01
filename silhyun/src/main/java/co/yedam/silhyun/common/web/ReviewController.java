package co.yedam.silhyun.common.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

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
	public String reviewInsert(ReviewVO vo, @RequestParam("files") List<MultipartFile> files) {
		vo.setCtgr("A");
		System.out.println(vo.getStar()+"별갯구========================");
		System.out.println(vo.getCntn()+"리뷰내용========================");
		System.out.println(files.size());
		//rService.reviewInsert(vo);
		return "review/test";
	}
	
}
