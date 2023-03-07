package co.yedam.silhyun.mypage.web;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import co.yedam.silhyun.classes.vo.ClassesVO;
import co.yedam.silhyun.event.vo.CouponVO;
import co.yedam.silhyun.event.vo.EventVO;
import co.yedam.silhyun.member.vo.OptionsVO;
import co.yedam.silhyun.member.vo.ReserTimeVO;
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

	@RequestMapping("/photo/resManage")
	public String resManage(Model model) {
		model.addAttribute("resList", mypageAoService.getReserList());

		return "mypageAo/resManage";
	}

	@GetMapping("/photo/classManage")
	public String classManage(Model model) {
		model.addAttribute("ptgInfo", mypageAoService.getPhotoinfo());

		return "mypageAo/classManage";
	}

	@GetMapping("/photo/mypageAoAsk")
	public String mypageAoAsk(Model model) {
		model.addAttribute("ptgInfo", mypageAoService.getPhotoinfo());

		return "mypageAo/mypageAoAsk";
	}

	@GetMapping("/photo/resCalendarAo")
	public String resCalendarAo(Model model) {
		model.addAttribute("ptgInfo", mypageAoService.getPhotoinfo());
		return "mypageAo/resCalendarAo";
	}

	@GetMapping("/photo/mypageStatsAo")
	public String mypageStatsAo(Model model) {
		model.addAttribute("ptgInfo", mypageAoService.getPhotoinfo());
		return "mypageAo/mypageStatsAo";
	}

	@GetMapping("/photo/reportFormAo")
	public String reportAo(Model model) {
		model.addAttribute("ptgInfo", mypageAoService.getPhotoinfo());
		return "mypageAo/reportFormAo";
	}

	// 작가 정보수정
	@PostMapping("/updateMyPg")
	public String updateMyPg() {

		return "";
	}

	// 작가 예약 시간 정보 수정
	/*
	 * @RequestMapping("/upWorkTime") public Map<String, Object>
	 * upWorkTime(@RequestBody List<ReserTimeVO> voList) { Map<String, Object> map =
	 * new HashMap<>();
	 * 
	 * mypageAoService.updateReserTime(voList);
	 * 
	 * map.put("voList", voList); return map; }
	 */


//	@RequestMapping("/upWorkTime")
//	public Map<String, Object> upWorkTime(@RequestParam List<String> resTime, @RequestParam String ptgId) {
//		ReserTimeVO vo = new ReserTimeVO();
//		Map<String, Object> map = new HashMap<>();
//		//추가
//		List<String> ptgIdList = new ArrayList<>();
//
//		List<ReserTimeVO> voList = new ArrayList<>(); // 크기가 동적으로 변하기때문에 arraylist를 씀
//	
//		
//		System.out.println(resTime + "resTime" + ptgId + "ptgId" + "qqqqqqqqqqqqqqqqqqqq");
//		System.out.println(Arrays.asList(resTime)+"wwwwwwwww");
//		System.out.println(ptgId+"Eeeeeeeeeeeee");
//		for (int i = 0; i < resTime.size(); i++) { // 예약시간 받은 값 만큼
//			
//		    ptgIdList.add(ptgId);
//			vo.setResTimeList(Arrays.asList(resTime.get(i).split(",")));
//			// Arrays.aslist->aslist로 반환되는 List도 배열을 갖게됨+원본 배열의 주소값을 가져옴
//			vo.setPtgId(ptgIdList.get(i));
//			voList.add(vo);
//			System.out.println(vo+"aaaaaaaaaaaaaa");
//			System.out.println(voList+"bbbbbbbbbaaaaaaaaaaaaaa");
//		}
//		System.out.println(vo+"vvvvvvvvvva");
//		//mypageAoService.updateReserTime(voList);
//		mypageAoService.deleteReserTime(vo);
//		mypageAoService.insertReserTime(vo);
//		System.out.println(vo+"ccccccc");
//		map.put("vo",vo);
//		
//		
//		//map.put("voList", voList);
//
//		return map;
//	}
	@RequestMapping("/upWorkTime")
	public Map<String, Object> upWorkTime(@RequestParam List<String> resTime,
										  @RequestParam String ptgId)
	{
	    Map<String, Object> map = new HashMap<>();
	    List<ReserTimeVO> voList = new ArrayList<>();
	    for (int i = 0; i < resTime.size(); i++) {
	        ReserTimeVO vo = new ReserTimeVO();
	        vo.setResTime(resTime.get(i));
	        System.out.println(vo.getResTime()+"rrrrrrrrrrrrrrrr");
	        vo.setPtgId(ptgId);
	        System.out.println(vo.getPtgId()+"iiiiiiiiiiiiii");
	        voList.add(vo);
	        System.out.println(vo+"qqqqqqqqqqqqq");
	    }
	    System.out.println(voList+"aaaaaaaaaaaa");	//[reserTimeVO(restime='',ptgid=''),...]
	    System.out.println(voList.size()+"dddddddddddddd");
//	    // ==ptgId 삭제
	    mypageAoService.deleteReserTime(ptgId);
//	    // voList값 추가
	    for(int i=0; i<voList.size();i++) {
	    	mypageAoService.insertReserTime(voList);	    	
	    	System.out.println("jjjjjjjjj");
	    }
//	    mypageAoService.updateReserTime(voList);			//업데이트
	    map.put("voList", voList);
	    System.out.println(voList+"aaaaaaaaaaaa");
	    return map;
	}


	

//	
//	  @RequestMapping("/upWorkTime") public Map<String, Object> 
//	  upWorkTime(@RequestParam String ptgId, @RequestParam List<String> resTime) {
//		  ReserTimeVO vo = new ReserTimeVO(); Map<String, Object> map = new
//		  HashMap<>(); vo.setPtgId(ptgId); vo.setResTime(resTime);
//		  System.out.println(resTime+"resTime"+ptgId+"ptgId"+"qqqqqqqqqqqqqqqqqqqq");
//		  System.out.println(vo.getResTime()+"vo.resTime"+vo.getPtgId()+"vo.ptgId"+
//		  "wwwwwwwwww"); mypageAoService.updateReserTime(vo);
//		  
//		  map.put("vo", vo); return map; 
//	  }

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
			vo.setEventNum(vo.getPtgId() + key);
			mypageAoService.applyEvent(vo); // db에 담음
			// System.out.println("넘어오니?"+vo.getEventNum());
			cvo.setEventNum(vo.getEventNum()); // vo에 담긴 eventNum을 들고오기
			cvo.setCpnNum(vo.getEventNum()); // eventNum이랑 값 같게
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
			vo.setThni("/saveImg/thum/" + fileName);
			vo.setClassNum(vo.getPtgId() + key);
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