package co.yedam.silhyun.common.web;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;


import co.yedam.silhyun.SessionUser;
import co.yedam.silhyun.common.service.PhotoService;
import co.yedam.silhyun.common.service.ReviewService;
import co.yedam.silhyun.common.vo.Criteria;
import co.yedam.silhyun.common.vo.PageVO;
import co.yedam.silhyun.common.vo.PhotoVO;
import co.yedam.silhyun.common.vo.ReviewVO;

@Controller
@CrossOrigin(value = "*")
public class ReviewController {
	
	@Autowired ReviewService rService;
	@Autowired PhotoService pService;
	
	@GetMapping("/silhyun/test")
	public String test(Model model, /*HttpServletRequest request,*/ HttpSession httpSession) {
		//model.addAttribute("session", request.getSession());
		//세션보를 사용할때 세션 사용
		SessionUser user = (SessionUser) httpSession.getAttribute("user");  
		if(user != null) {
			model.addAttribute("id", user.getId());
			model.addAttribute("role", user.getRole());			
		}
		
		return "review/test";
	}
	
	//인써트 폼으로 가는 아작스
	@GetMapping("/reviewform")   
	public String reviewForm(ReviewVO vo, Model model) {
		///이걸로 리뷰폼 정보 변경하기  
		model.addAttribute("id", vo.getCtgrNum());
		model.addAttribute("ctgr", vo.getCtgr());
		return "review/reviewForm";
	}

	//리뷰 업데이트로 가는 아작스
	@GetMapping("/reviewUpform")   
	public String reviewUpform(ReviewVO vo, Model model) { 
		model.addAttribute("revNum", vo.getRevNum());
		return "review/reviewUpdateForm";
	}
	
	//필요없음 나중에 지우자
//	@GetMapping("/silhyun/reviewList")
//	public String reviewList(Model model, HttpSession httpSession, Criteria cri, PhotoVO pvo) {
//		//세션보를 사용할때 세션 사용
//		SessionUser user = (SessionUser) httpSession.getAttribute("user");  
//		if(user != null) {
//			model.addAttribute("id", user.getId());		
//		}
//		cri.setAmount(5);
//		model.addAttribute("list", rService.reviewList(cri, "A", "user24"));
//		model.addAttribute("page", new PageVO(rService.getTotalCount( "A", "user24"), 10, cri));
//		model.addAttribute("star", rService.ptgStarAvg("A", "user24"));
//
//		return "review/reviewList";
//	}
	
	
	@GetMapping("/ajaxCall")
	public String ajaxCallReview(Model model, HttpSession httpSession, Criteria cri, PhotoVO pvo) {
		SessionUser user = (SessionUser) httpSession.getAttribute("user");    ///이거 수정하기
		if(user != null) {
			model.addAttribute("id", user.getId());		
		}
		cri.setAmount(5);
		model.addAttribute("list", rService.reviewList(cri, "A", "user24"));
		model.addAttribute("page", new PageVO(rService.getTotalCount("A", "user24"), 10, cri));
		model.addAttribute("star", rService.ptgStarAvg("A", "user24"));

		return "review/reviewList";
	}
	
	
	
	
}
