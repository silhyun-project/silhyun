package co.yedam.silhyun.mypage.web;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import co.yedam.silhyun.SessionUser;
import co.yedam.silhyun.member.service.StdService;
import co.yedam.silhyun.member.vo.PhotographerVO;
import co.yedam.silhyun.member.vo.StudioVO;
import co.yedam.silhyun.mypage.service.MypageAoService;

@Controller
public class MyStdController {

	@Value("${silhyun.saveimg}")
	private String saveimg;
	
	@Autowired
	private StdService stdService;
	private MypageAoService mypagesAoService;

	
	@RequestMapping("/photo/mypageStd/{stId}")
	private String mypageStd(Model model, StudioVO svo, @PathVariable String stId, HttpSession httpSession) {
		SessionUser user = (SessionUser) httpSession.getAttribute("user");  //세션 담기
		if(user != null) {  //세션
			model.addAttribute("id",user.getId());
			model.addAttribute("role",user.getRole());
		}
		model.addAttribute("stdInfo", stdService.getStd(stId));
		return "mypageStd/mypageStd";
	}
	
	@RequestMapping("/photo/modStd/{stId}")
	public String modStd(Model model,@PathVariable String stId) {
		model.addAttribute("stdInfo", stdService.getStd(stId));

		return "mypageStd/modStd";
	}
	
	@RequestMapping("/photo/stdManage/{stId}")
	private String stdManage(Model model,@PathVariable String stId)
	{	
		model.addAttribute("stdInfo", stdService.stdlistget(stId));
		model.addAttribute("ptglist", stdService.ptgList(stId));
		return "mypageStd/stdManage";
	}
	
	//삭제


	@PostMapping("/photo/ptgdel")
	@ResponseBody
	public boolean ptgdel(PhotographerVO vo) {
		stdService.ptgdel(vo);
		return true;
	}
	

}
