package co.yedam.silhyun.mypage.web;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import co.yedam.silhyun.SessionUser;
import co.yedam.silhyun.classes.vo.ClassesVO;
import co.yedam.silhyun.event.vo.CouponVO;
import co.yedam.silhyun.event.vo.EventVO;
import co.yedam.silhyun.member.service.MemberService;
import co.yedam.silhyun.member.vo.MemberVO;
import co.yedam.silhyun.member.vo.OptionsVO;
import co.yedam.silhyun.member.vo.PhotographerVO;
import co.yedam.silhyun.member.vo.ReserTimeVO;
import co.yedam.silhyun.mypage.service.MypageAoService;

@Controller
public class mypageAoController {

	@Value("${silhyun.saveimg}")
	private String saveimg;

	@Autowired
	private MypageAoService mypageAoService;
	@Autowired
	private MemberService memberService;

	@RequestMapping("/photo/mypageAo/{ptgId}")
	public String mypageAo(Model model,PhotographerVO pvo, @PathVariable String ptgId, HttpSession httpSession) {
		SessionUser user = (SessionUser) httpSession.getAttribute("user");  //세션 담기
		if(user != null) {  //세션
			model.addAttribute("id",user.getId());
			model.addAttribute("role",user.getRole());
		}
		model.addAttribute("ptgInfo", mypageAoService.getPhotoinfo(ptgId));
		return "mypageAo/mypageAo";
	}

	@RequestMapping("/photo/modPfAo/{ptgId}")
	public String modpfAo(Model model,@PathVariable String ptgId) {
		model.addAttribute("ptgInfo", mypageAoService.getPhotoinfo(ptgId));

		return "mypageAo/modPfAo";
	}

	@RequestMapping("/photo/resManage/{ptgId}")
	public String resManage(Model model, @PathVariable String ptgId, HttpSession httpSession) {
		SessionUser user = (SessionUser) httpSession.getAttribute("user");  //세션 담기
		if(user != null) {  //세션
			model.addAttribute("id",user.getId());
			model.addAttribute("role",user.getRole());
		}
		model.addAttribute("resList", mypageAoService.getReserList());

		return "mypageAo/resManage";
	}

	@GetMapping("/photo/classManage/{ptgId}")
	public String classManage(Model model,@PathVariable String ptgId) {
		model.addAttribute("ptgInfo", mypageAoService.getPhotoinfo(ptgId));
		model.addAttribute("clManage", mypageAoService.classList());

		return "mypageAo/classManage";
	}

	@GetMapping("/photo/mypageAoAsk/{ptgId}")
	public String mypageAoAsk(Model model,@PathVariable String ptgId) {
		model.addAttribute("ptgInfo", mypageAoService.getPhotoinfo(ptgId));

		return "mypageAo/mypageAoAsk";
	}

	@GetMapping("/photo/resCalendarAo/{ptgId}")
	public String resCalendarAo(Model model,@PathVariable String ptgId) {
		model.addAttribute("ptgInfo", mypageAoService.getPhotoinfo(ptgId));
		
		return "mypageAo/resCalendarAo";
	}
	
	/*
	 * @RequestMapping("/ajaxResTime/{ptgId}/{redate}") //작가가 등록한 시간 아작스 호출
	 * 
	 * @ResponseBody public List<PhotographerVO> ajaxResTime(Model
	 * model,@PathVariable String redate,@PathVariable String ptgId){
	 * System.out.println("호출 되었니"); System.out.println("redate====="+redate);
	 * return mypageAoService.getResTime(ptgId,redate); }
	 */
	

	@GetMapping("/photo/mypageStatsAo/{ptgId}")
	public String mypageStatsAo(Model model,@PathVariable String ptgId) {
		model.addAttribute("ptgInfo", mypageAoService.getPhotoinfo(ptgId));
		return "mypageAo/mypageStatsAo";
	}

	@GetMapping("/photo/reportFormAo/{ptgId}")
	public String reportAo(Model model,@PathVariable String ptgId) {
		model.addAttribute("ptgInfo", mypageAoService.getPhotoinfo(ptgId));
		return "mypageAo/reportFormAo";
	}

	// 작가 정보수정
	@PostMapping("/updateMyPg")
	public String updateMyPg() {

		return "";
	}

	// 작가 예약 시간 정보 수정

	@PostMapping("/upWorkTime")
	@ResponseBody
	public String upWorkTime(@RequestBody List<ReserTimeVO> reserTimeList) {
		//ReserTimeVO vo = new ReserTimeVO();
		// ptg_id 는 null값으로 보낼까??
		System.out.println("kkkkkkkkkkkk"+reserTimeList.toString());
		//mypageAoService.deleteReserTime();
		//VO 객체를 반복문을 통해 insertReserTime 메서드로 전달
		System.out.println(reserTimeList.get(0).getPtgId());
		String ptgId = reserTimeList.get(0).getPtgId();
		mypageAoService.deleteReserTime(ptgId);
		int n = 0;
	
		for (ReserTimeVO vo : reserTimeList) {
			System.out.println(vo + "보입니다 ㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇ");
			n = mypageAoService.insertReserTime(vo);


		}
		
		if(n>0) {
			return "성공";
		}else {
			
			return "실패";
		}
	

	}

	//프사변경
	@PostMapping("/uploadProfileImage")
	@ResponseBody
	public Map<String,Object> uploadProfileImage(MemberVO vo, MultipartFile file){
		System.out.println("프사볼려는 멤버보?" + vo);
		System.out.println("프사 들어오는지 확인" + file);
		Map<String, Object> map = new HashMap<>();
		
		if (file != null && !file.isEmpty()) {
			String saveImgPath = saveimg + "profil";

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
			vo.setProfile("/saveImg/profil/" + fileName);
			memberService.updateProfileImage(vo);
			map.put("vo", vo);
			map.put("profile", file);
		
		}
		
		return map;
	}


	@PostMapping("/applyEvent")
	@ResponseBody
	public Map<String, Object> applyEvent(EventVO vo, CouponVO cvo, MultipartFile file) {
		System.out.println("내가 볼려는거" + vo);
		System.out.println("쿠폰" + cvo);
		System.out.println("파일확인" + file);
		Map<String, Object> map = new HashMap<>();

		if (file != null && !file.isEmpty()) {
			String saveImgPath = saveimg + "banner";

			String fileName = UUID.randomUUID().toString(); // UUID생성
			fileName = fileName + "_" + file.getOriginalFilename(); // 유니크한 아이디
			File uploadFile = new File(saveImgPath, fileName);
			// 이벤트번호,쿠폰번호 난수 생성
			StringBuffer key = new StringBuffer();
			Random rnd = new Random();

			for (int i = 0; i < 6; i++) {
				int index = rnd.nextInt(3);
				switch (index) {
				case 0:
					key.append((char) ((rnd.nextInt(26)) + 97));
					break;
				case 1:
					key.append((char) ((rnd.nextInt(26)) + 65));
					break;
				case 2:
					key.append((rnd.nextInt(10)));
					break;
				}
			}
			// System.out.println(key+"========================");
			try {
				file.transferTo(uploadFile); // 파일저장
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			vo.setBnph("/saveImg/banner/" + fileName);
			vo.setEventNum(vo.getId() + key);
			
			mypageAoService.applyEvent(vo); // db에 담음
			// System.out.println("넘어오니?"+vo.getEventNum());
			cvo.setEventNum(vo.getEventNum()); // vo에 담긴 eventNum을 들고오기
			cvo.setCpnNum(vo.getEventNum()); // eventNum이랑 값 같게
			cvo.setCtgrNum(vo.getId());
			cvo.setCpnCd("C1");	//개인인지 공통인지 작가는 c1(개인)만
			mypageAoService.applyECoupon(cvo);

			map.put("vo", vo);
			map.put("cvo", cvo);
			map.put("file", file);

		}
		return map;
	}

	@PostMapping("/applyClass")
	@ResponseBody
	public Map<String, Object> applyEvent(ClassesVO vo, MultipartFile file) {
		System.out.println("내가 볼려는거" + vo);
		System.out.println("파일확인" + file);
		Map<String, Object> map = new HashMap<>();

		if (file != null && !file.isEmpty()) {
			String saveImgPath = saveimg + "thum";

			String fileName = UUID.randomUUID().toString(); // UUID생성
			fileName = fileName + "_" + file.getOriginalFilename(); // 유니크한 아이디
			File uploadFile = new File(saveImgPath, fileName);
			// 클래스 번호 난수 생성
//			StringBuffer key = new StringBuffer();
//			Random rnd = new Random();
//
//			for (int i = 0; i < 6; i++) {
//				int index = rnd.nextInt(3);
//				switch (index) {
//				case 0:
//					key.append((char) ((rnd.nextInt(26)) + 97));
//					break;
//				case 1:
//					key.append((char) ((rnd.nextInt(26)) + 65));
//					break;
//				case 2:
//					key.append((rnd.nextInt(10)));
//					break;
//				}
//			}
			// System.out.println(key+"========================");
			try {
				file.transferTo(uploadFile); // 파일저장
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			vo.setThni("/saveImg/thum/" + fileName);
//			vo.setClassNum(vo.getPtgId() + key);
			mypageAoService.applyClass(vo); // db에 담음
			// System.out.println("넘어오니?"+vo.getEventNum());
			map.put("vo", vo);
			map.put("file", file);

		}
		return map;
	}

	@PostMapping("/photo/insertOption")
	@ResponseBody
	public String insertOption(@RequestBody List<OptionsVO> options) {

		// OptionsVO 객체를 반복문을 통해 insertOption 메서드로 전달
		for (OptionsVO vo : options) {
			vo.setPtgId("user1");
//	        vo.setOpNum(vo.getPtgId() + key.toString());
			System.out.println("+++~~~~~~" + vo);
			mypageAoService.insertOption(vo);
		}

		return "";
	}

}