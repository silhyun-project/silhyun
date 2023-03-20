package co.yedam.silhyun.member.web;


//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import co.yedam.silhyun.event.vo.EventVO;
import co.yedam.silhyun.member.service.AdminSercive;
import co.yedam.silhyun.member.vo.AdminCriteria;
import co.yedam.silhyun.member.vo.AdminPageVO;
import co.yedam.silhyun.member.vo.MemberVO;
import co.yedam.silhyun.member.vo.PhotographerVO;
import co.yedam.silhyun.mypage.vo.QuitVO;

@Controller
public class AdminController {
		
	@Autowired
	private AdminSercive adminService;
	
	
	/*
	 * 작성자:
	 * 작성일자:
	 * 작성내용:
	 */
	   
	
	//이벤트관리
	@GetMapping("/admin/eventManage")
	public String eventManage(Model model, AdminCriteria cri) {
		List<Map<String,Object>> eList = adminService.getEventList();
		model.addAttribute("eList", eList);
		
		List<Map<String,Object>> eAList = adminService.getEventAllList();
		model.addAttribute("eAList", eAList);

		model.addAttribute("eCnt", adminService.getEventCnt());
		
		
		
		System.out.println(model);
		return "/admin/eventManage";
	}
	
	//이벤트관리 아작스 
	@RequestMapping("/admin/eventManageSelect")
	@ResponseBody
	public EventVO eventManageSelect(@RequestParam("eventNum") String eventNum) {
	    System.out.println("컨트롤러로 온 eventNum는 = " + eventNum);
	    return adminService.getEventContent(eventNum);
	}
	
	@PostMapping("/admin/addAdminEvent")
	@ResponseBody
	public EventVO addAdminEvent(EventVO vo, List<MultipartFile> files) {
	    // 파일 저장하는 로직 추가
	    // ...
	    System.out.println("컨트롤러로 온 EventVO는 = " + vo);
	    adminService.addAdminEvent(vo);
	    return vo;
		
	}

	
	
	

	
	
	
	
	
	
	//ptg 승인 상세======================================================
	@RequestMapping("/admin/ptgSelect")
	@ResponseBody
	public Map<String, Object> ptgSelect(@RequestParam("ptgId") String ptgId){
		 System.out.println("컨트롤러로 온 ptgId는 = " + ptgId);
		return adminService.ptgSelect(ptgId);
	}
	
	//ptg 승인요청 승인
	@RequestMapping("/admin/ptgAccept")
	@ResponseBody
	public String ptgAccept(@RequestParam("ptgId") String ptgId){
		 System.out.println("컨트롤러로 온 ptgId2는 = " + ptgId);
		 String msg="";
		 int n;
		 
		 n = adminService.ptgAccept(ptgId);
		
		 if (n!=0) {
			 msg = ptgId+"님을 승인 완료했습니다.";
		 }else {
			 msg ="승인 실패";
		 }
		 System.out.println("컨트롤러 msg"+msg);
		 return msg;
	}
	
	//ptg 승인요청 반려
	@RequestMapping("/admin/noAccept")
	@ResponseBody
	public String noPtgAccept(@RequestParam("ptgId") String ptgId){
		 System.out.println("컨트롤러로 온 ptgId2는 = " + ptgId);
		 String msg="";
		 int n;
		 
		 n = adminService.noPtgAccept(ptgId);
		
		 if (n!=0) {
			 msg = ptgId+"님을 승인 반려했습니다.";
		 }else {
			 msg ="반려 실패";
		 }
		 System.out.println("컨트롤러 msg"+msg);
		 return msg;
	}
	
	//사진관 승인=======================================
	@RequestMapping("/admin/stdSelect")
	@ResponseBody
	public Map<String, Object> stdSelect(@RequestParam("stId") String stId){
		 System.out.println("컨트롤러로 온 stId는 = " + stId);
		return adminService.stdSelect(stId);
	}
	
	//사진관 승인요청 승인
	@RequestMapping("/admin/stdAccept")
	@ResponseBody
	public String stdAccept(@RequestParam("stId") String stId){
		 System.out.println("컨트롤러로 온 stId는 = " + stId);
		 String msg="";
		 int n;
		 
		 n = adminService.stdAccept(stId);
		
		 if (n!=0) {
			 msg = stId+"님을 승인 완료했습니다.";
		 }else {
			 msg ="승인 실패";
		 }
		 System.out.println("컨트롤러 msg"+msg);
		 return msg;
	}
	
	//사진관 승인요청 반려
	@RequestMapping("/admin/noStdAccept")
	@ResponseBody
	public String noStdAccept(@RequestParam("stId") String stId){
		 System.out.println("컨트롤러로 온 stId222222는 = " + stId);
		 String msg="";
		 int n;
		 
		 n = adminService.noStdAccept(stId);
		
		 if (n!=0) {
			 msg = stId+"님을 승인 반려했습니다.";
		 }else {
			 msg ="반려 실패";
		 }
		 System.out.println("컨트롤러 msg"+msg);
		 return msg;
	}
	
	//클래스 승인 상세======================================================
		@RequestMapping("/admin/classSelect")
		@ResponseBody
		public Map<String, Object> classSelect(@RequestParam("classNum") String classNum){
			 System.out.println("컨트롤러로 온 classNum는 = " + classNum);
			return adminService.classSelect(classNum);
		}
		
		//클래스 승인요청 승인
		@RequestMapping("/admin/classAccept")
		@ResponseBody
		public String classAccept(@RequestParam("classNum") String classNum){
			 System.out.println("컨트롤러로 온 classNum는 = " + classNum);
			 String msg="";
			 int n;
			 
			 n = adminService.classAccept(classNum);
			
			 if (n!=0) {
				 msg = classNum+"을 승인 완료했습니다.";
			 }else {
				 msg ="승인 실패";
			 }
			 System.out.println("컨트롤러 msg"+msg);
			 return msg;
		}
		
		//클래스 승인요청 반려
		@RequestMapping("/admin/noClassAccept")
		@ResponseBody
		public String noClassAccept(@RequestParam("classNum") String classNum){
			 System.out.println("컨트롤러로 온 classNum는 = " + classNum);
			 String msg="";
			 int n;
			 
			 n = adminService.noClassAccept(classNum);
			
			 if (n!=0) {
				 msg = classNum+"님을 승인 반려했습니다.";
			 }else {
				 msg ="반려 실패";
			 }
			 System.out.println("컨트롤러 msg"+msg);
			 return msg;
		}
	
	
	//event 승인요청 승인
	@RequestMapping("/admin/eventAccept")
	@ResponseBody
	public String eventAccept(@RequestParam("eventNum") String eventNum){
		 System.out.println("컨트롤러로 온 eventNum는 = " + eventNum);
		 String msg="";
		 int n;
		 
		 n = adminService.eventAccept(eventNum);
		
		 if (n!=0) {
			 msg = "이벤트를 승인 완료했습니다.";
		 }else {
			 msg ="승인 실패";
		 }
		 System.out.println("컨트롤러 msg"+msg);
		 return msg;
	}
	
	//event 승인요청 반려
	@RequestMapping("/admin/noEventAccept")
	@ResponseBody
	public String noEventAccept(@RequestParam("eventNum") String eventNum){
		 System.out.println("컨트롤러로 온 eventNum는 = " + eventNum);
		 String msg="";
		 int n;
		 
		 n = adminService.noEventAccept(eventNum);
		
		 if (n!=0) {
			 msg = "이벤트를 승인 반려했습니다.";
		 }else {
			 msg ="반려 실패";
		 }
		 System.out.println("컨트롤러 msg"+msg);
		 return msg;
	}
	
	
	
	
	
	
	
	
	@GetMapping("/admin/memberAccept")
	public String memberAccept(String ptgId, Model model) {
		
		model.addAttribute("needCfm", adminService.countNeedCfm());
		
		model.addAttribute("ptgList", adminService.ptgCfmList());
		
		model.addAttribute("stdList", adminService.stdCfmList());
		
		model.addAttribute("classList", adminService.classCfmList());
		
		List<Map<String,Object>> eList = adminService.getEventOList();
		model.addAttribute("eList", eList);

		
		System.out.println(model);
		
		return "/admin/memberAccept";
	}
	
	@RequestMapping("/admin/memberManage")
	public String memberManage(@ModelAttribute("cri") AdminCriteria cri, @ModelAttribute("cri2") AdminCriteria cri2,  @ModelAttribute("cri3") AdminCriteria cri3, 
			MemberVO vo, Model model, 
			@RequestParam(value = "pageNum2", required = false, defaultValue = "1") int pageNum2,
			@RequestParam(value = "keyword2", required = false) String keyword2,
			@RequestParam(value = "pageNum3", required = false, defaultValue = "1") int pageNum3,
			@RequestParam(value = "keyword3", required = false) String keyword3) {
		
		cri2.setPageNum(pageNum2);
		cri2.setKeyword(keyword2);
		cri3.setPageNum(pageNum3);
		cri3.setKeyword(keyword3);
		model.addAttribute("todayMem", adminService.todayMem());
		model.addAttribute("todayPtg", adminService.todayPtg());
		model.addAttribute("todayStd", adminService.todayStd());
		
		model.addAttribute("memberList", adminService.memberList());
		model.addAttribute("ptgList",adminService.ptgList());
		model.addAttribute("stdList",adminService.stdList());
		
		
		
		//회원전체리스트 페이징 
		cri.setAmount(5);
		model.addAttribute("list", adminService.getListMember(cri));
		model.addAttribute("page", new AdminPageVO(adminService.getTotalCount(cri), 10, cri));
		
		//작가리스트 페이징
		cri2.setAmount(5);
		model.addAttribute("ptglist", adminService.getListPtg(cri2));
		model.addAttribute("ptgPage", new AdminPageVO(adminService.getTotalPtg(cri2), 10, cri2));
		
		//작가리스트 페이징
		cri3.setAmount(5);
		model.addAttribute("stdList", adminService.getListStd(cri3));
		model.addAttribute("stdPage", new AdminPageVO(adminService.getTotalStd(cri3), 10, cri3));
		
		System.out.println(model);

		return "/admin/memberManage";
	}
	
	
	@RequestMapping("/belongPtg")
	@ResponseBody
	public Map<String,Object> belongPtg(String stId) {
		
		System.out.println("컨트롤러로 온 stId는 =" + stId);
		
		Map<String, Object> map = new HashMap<String, Object>();
		List<PhotographerVO> list = adminService.belongPtg(stId);
		
		map.put("belongPtg", list);
		map.put("result", "success");
		map.put("STbelong", stId);
		System.out.println("컨트롤러의 map은"+map);
		return map;
	}
	
	
	
	//멤버 비활성화 단건
	@RequestMapping("/disableMember")
	public String disableMember(String id) {
		System.out.println("내가 보려는 거 "+id);
		
		int n = adminService.disableMember(id);

		if(n !=0) {
			System.out.println(id+"비활성화완료");
		}else {
		}
		return "redirect:/admin/memberManage";
		//test
	}
	
	//멤버 활성화 단건
	@RequestMapping("/ableMember")
	public String ableMember(String id) {
		System.out.println("내가 보려는 거 "+id);
		
		int n = adminService.ableMember(id);

		if(n !=0) {
			System.out.println(id+"비활성화완료");
		}else {
		}
		return "redirect:/admin/memberManage";
		//test
	}
	
	
	//관리자 정보 수정
	@PostMapping("/updateAdmin")
	public String updateAdmin(MemberVO vo) {
		
		int n = adminService.updateAdmin(vo);

		if(n!=0) {
			System.out.println("수정성공");
			
		}else {
			System.out.println("수정실패");
		}
		return "redirect:/admin/adminManage";
	}
	
	//회원정보 수정
	@PostMapping("/updateMember")
	public String updateMember(MemberVO vo) {
		
		
		System.out.println("컨트롤러 멤버수정 보"+vo);
		
		int n = adminService.updateMember(vo); 
		
		if(n!=0) {
			System.out.println("회원정보 수정성공");
		}else {
			System.out.println("회원정보 수정실패");
		}
		return "redirect:/admin/memberManage";
	}
	
	@GetMapping("/admin/orderManage")
	public String orderManage() {
		return "/admin/orderManage";
	}
	
	@GetMapping("/admin/qstManage")
	public String qstManage() {
		return "/admin/qstManage";
	}
	
	//탈퇴관리
	@GetMapping("/admin/quitManage")
	public String quitManage(AdminCriteria cri, QuitVO vo, Model model) {
		model.addAttribute("qtList",adminService.qtList());
		
		List<Map<String,String>> list = adminService.quitGraph();
		model.addAttribute("gtGraph",list);
	
		//페이징
		cri.setAmount(5);
		model.addAttribute("list", adminService.getListQuit(cri));
		model.addAttribute("page", new AdminPageVO(adminService.getTotalQuit(cri), 10, cri));

		return "/admin/quitManage";
	}
	
	
	@GetMapping("/admin/reportManage")
	public String reportManagr() {
		return "/admin/reportManage";
	}
	
	@GetMapping("/admin/adminManage")
	public String adminManage(Model model) {
		model.addAttribute("adminInfo", adminService.adminInfo());
		return "/admin/adminManage";
	}
	
	
	@GetMapping("/admin/dashBoard")
	public String dashBoard(Model model) {
		model.addAttribute("com", adminService.recentCom());
		model.addAttribute("join", adminService.recentJoin());
		model.addAttribute("buy", adminService.recentBuy());
		model.addAttribute("cfm", adminService.cfmCnt());
		model.addAttribute("qst", adminService.qstCnt());
		model.addAttribute("lastS", adminService.lastSales());

			List<Map<String,String>> PGraph = adminService.ptgGraph();
			model.addAttribute("PGraph",PGraph);
			
			model.addAttribute("ptgRank", adminService.ptgRank());
			model.addAttribute("classRank", adminService.classRank());
			

		return "/admin/dashBoard";
	}
	

	
}

