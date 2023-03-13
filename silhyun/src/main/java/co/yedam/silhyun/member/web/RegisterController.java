package co.yedam.silhyun.member.web;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import co.yedam.silhyun.SessionUser;
import co.yedam.silhyun.common.service.PhotoService;
import co.yedam.silhyun.member.service.RegisterService;
import co.yedam.silhyun.member.vo.FieldVO;
import co.yedam.silhyun.member.vo.MemberVO;
import co.yedam.silhyun.member.vo.PhotographerVO;
import co.yedam.silhyun.member.vo.StudioVO;

@Controller
public class RegisterController {
	@Autowired
	RegisterService registerService;
	@Autowired
	PhotoService photoService;

	@RequestMapping("/shin/ptgRegister")
	public String ptgRegister(Model model, MemberVO vo, HttpSession httpSession) {
		SessionUser user = (SessionUser) httpSession.getAttribute("user");
		if (user != null) { // 세션
			model.addAttribute("id", user.getId());
			model.addAttribute("role", user.getRole());
		}
		model.addAttribute("member", registerService.getMember(user.getId()));
		return "home/ptgRegisterForm";
	}

	@PostMapping("/shin/ptgRegiInsert")
	@ResponseBody
	public PhotographerVO ptgRegiInsert(PhotographerVO pvo, List<MultipartFile> files, FieldVO fvo) {
		String ptgId = registerService.ptgRegiInsert(pvo);
		System.out.println("ptgRegiInsert까지 왔니");
		String ctgrNum = ptgId;
		photoService.ptgRegiInsert(files, ctgrNum, "A");

		fvo.setPtgId(pvo.getPtgId());
		System.out.println("작가 아이디 들고왔니" + fvo.getPtgId());
		registerService.ptgFldRegiInsert(fvo);

		return pvo;
	}
	
	@RequestMapping("/shin/stdRegister")
	public String stdRegister(Model model,HttpSession httpSession) {
		SessionUser user = (SessionUser) httpSession.getAttribute("user");
		if (user != null) { // 세션
			model.addAttribute("id", user.getId());
			model.addAttribute("role", user.getRole());
		}
		return "home/stdRegisterForm";
	}
	
	@PostMapping("/shin/stdRegister")
	@ResponseBody
	public String stdRegiste(StudioVO vo,Model model) {
		registerService.stdRegiInsert(vo);
		return "home/home";
	}
}
