package co.yedam.silhyun.mypage.web;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import co.yedam.silhyun.event.vo.CouponVO;
import co.yedam.silhyun.event.vo.EventVO;
import co.yedam.silhyun.mypage.service.MypageAoService;

@Controller
public class mypageAoController {
	

	@Value("${silhyun.saveimg}")
	private String saveimg;
	
	
	@Autowired
	private MypageAoService mypageAoService;

	@GetMapping("/photo/mypageAo")
	public String mypageAo(Model model) {
		model.addAttribute("ptgInfo", mypageAoService.getPhotoinfo());
		
		return "mypageAo/mypageAo";
	}

	@GetMapping("/photo/modPfAo")
	public String modpfAo(Model model) {
		model.addAttribute("ptgInfo", mypageAoService.getPhotoinfo());

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
	public Map<String, Object> applyEvent(EventVO vo, CouponVO cvo,  MultipartFile file) {
		System.out.println("내가 볼려는거"+vo);
		System.out.println("쿠폰"+cvo);
		System.out.println("파일확인"+file);
		Map<String, Object> map = new HashMap<>();

		if (file != null && !file.isEmpty()) {
			String saveImgPath = saveimg + "banner";

			String fileName = UUID.randomUUID().toString(); // UUID생성
			fileName = fileName + "_" + file.getOriginalFilename(); // 유니크한 아이디
			File uploadFile = new File(saveImgPath, fileName);
			
			try {
				file.transferTo(uploadFile); // 파일저장
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			vo.setBnph("/saveImg/banner/"+fileName);
			mypageAoService.applyEvent(vo);
			cvo.setEventNum(vo.getEventNum());
			mypageAoService.applyECoupon(cvo);
			
			map.put("vo", vo);
			map.put("cvo", cvo);
			map.put("file", file);

		}
		return map;
	}

}