package co.yedam.silhyun.common.web;

import java.util.List;
import java.util.Map;

import javax.crypto.spec.RC2ParameterSpec;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import co.yedam.silhyun.SessionUser;
import co.yedam.silhyun.common.service.PhotoService;
import co.yedam.silhyun.common.service.ReviewService;
import co.yedam.silhyun.common.vo.ReviewVO;

@Controller
@CrossOrigin(value = "*")
public class ReviewController {
	
	@Autowired ReviewService rService;
	@Autowired PhotoService pService;
	
	@GetMapping("/silhyun/reviewform")
	public String reviewForm() {
		return "review/reviewForm";
	}

	@GetMapping("/silhyun/reviewList")
	public String reviewList(Model model, /*HttpServletRequest request,*/ HttpSession httpSession) {
		//model.addAttribute("session", request.getSession());
		//세션보를 사용할때 세션 사용
		SessionUser user = (SessionUser) httpSession.getAttribute("user");  
		if(user != null) {
			model.addAttribute("id", user.getId());
			model.addAttribute("role", user.getRole());			
		}
		return "review/test";
	}
	
	@PostMapping("/silhyun/review")
	@ResponseBody
	public ReviewVO reviewInsert(ReviewVO vo, List<MultipartFile> files) {  //@RequestParam => 필수값임
		vo.setCtgr("A");
		String ctgrNum = rService.reviewInsert(vo);
		String ctgr = "R";
		pService.photoInsert(files, ctgrNum, ctgr);
		return vo;
	}

	
}
