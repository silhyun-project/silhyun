package co.yedam.silhyun.member.web;


//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import co.yedam.silhyun.member.vo.AdminCriteria;
import co.yedam.silhyun.member.vo.AdminPageVO;
import co.yedam.silhyun.event.vo.EventVO;
import co.yedam.silhyun.member.service.AdminSercive;
import co.yedam.silhyun.member.vo.MemberVO;
import co.yedam.silhyun.member.vo.PhotographerVO;
import co.yedam.silhyun.mypage.vo.QuitVO;

@Controller
public class AdminController {
		
	@Autowired
	private AdminSercive adminService;
	
	
	//이벤트관리
	@GetMapping("/admin/eventManage")
	public String eventManage(Model model) {
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
	@RequestMapping("/admin/noPtgAccept")
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
		model.addAttribute("ptgList", adminService.ptgCfmList());
		
		List<Map<String,Object>> eList = adminService.getEventOList();
		model.addAttribute("eList", eList);

		
		System.out.println(model);
		
		return "/admin/memberAccept";
	}
	
	@RequestMapping("/admin/memberManage")
	public String memberManage(AdminCriteria cri, MemberVO vo, Model model) {
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
		cri.setAmount(5);
		model.addAttribute("ptglist", adminService.getListPtg(cri));
		model.addAttribute("ptgPage", new AdminPageVO(adminService.getTotalPtg(cri), 10, cri));

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
	
	
	
	//멤버 삭제 단건
	@RequestMapping("/deleteMember")
	public String deleteMember(String id) {
		System.out.println("내가 보려는 거 "+id);
		
		int n = adminService.deleteMember(id);

		if(n !=0) {
			System.out.println(id+"삭제완료");
			adminService.insertQuitMember(id);
			System.out.println(id+"탈퇴등록완료");
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
	
	//탈퇴 삭제
	@RequestMapping("/deleteQMember")
	public String deleteQMember(String id) {
		System.out.println("내가 보려는 거 "+id);
		
		int n = adminService.deleteQMember(id);

		if(n !=0) {
			System.out.println(id+"삭제완료");
		}else {
		}
		return "redirect:/admin/quitManage";
		//test
	}
	
	@GetMapping("/admin/rankManage")
	public String rankManage(Model model) {
		
		List<Map<String,String>> PGraph = adminService.ptgGraph();
		model.addAttribute("PGraph",PGraph);
		
		model.addAttribute("ptgRank", adminService.ptgRank());
		model.addAttribute("classRank", adminService.classRank());
		
		return "/admin/rankManage";
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
		System.out.println("컨트롤러"+model);
		return "/admin/dashBoard";
	}
	

	
}

