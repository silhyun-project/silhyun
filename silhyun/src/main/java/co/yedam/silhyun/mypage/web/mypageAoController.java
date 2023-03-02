package co.yedam.silhyun.mypage.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import co.yedam.silhyun.event.vo.CouponVO;
import co.yedam.silhyun.event.vo.EventVO;
import co.yedam.silhyun.mypage.service.MypageAoService;

@Controller
public class mypageAoController {
	@Autowired
	private MypageAoService mypageAoService;
	
	@GetMapping(" /photo/mypageAo")
	public String mypageAo() {
		return "mypageAo/mypageAo";
	}
	
	@GetMapping("/photo/modPfAo")
	public String modpfAo(Model model) {
		model.addAttribute("ptgInfo",mypageAoService.getPhotoinfo());

			return "mypageAo/modPfAo";
		}
	@GetMapping("/photo/resManage")
	public String resManage(Model model) {
	model.addAttribute("resList", mypageAoService.getReserList());
	
		return "mypageAo/resManage";
	}
	@GetMapping("/photo/classManage")
	public String classManage() {
		
		return "mypageAo/classManage";
	}
	@GetMapping("/photo/mypageAoAsk")
	public String mypageAoAsk() {
		
		return "mypageAo/mypageAoAsk";
	}
	@GetMapping("/photo/resCalendarAo")
	public String resCalendarAo() {
		
		return "mypageAo/resCalendarAo";
	}
	@GetMapping("/photo/mypageStatsAo")
	public String mypageStatsAo() {
		
		return "mypageAo/mypageStatsAo";
	}
	
	@GetMapping("/photo/reportFormAo")
	public String reportAo() {
		
		return "mypageAo/reportFormAo";
	}
	@PostMapping("/applyEvent")
	@ResponseBody
	public boolean applyEvent(EventVO vo, CouponVO cvo) {
		mypageAoService.applyEvent(vo);
		mypageAoService.applyECoupon(cvo);
		return true;
	}
}
