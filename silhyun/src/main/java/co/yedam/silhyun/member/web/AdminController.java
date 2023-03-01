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
import org.springframework.web.bind.annotation.ResponseBody;

import co.yedam.silhyun.common.vo.Criteria;
import co.yedam.silhyun.common.vo.PageVO;
import co.yedam.silhyun.common.vo.ReviewVO;
import co.yedam.silhyun.member.service.AdminSercive;
import co.yedam.silhyun.member.vo.MemberVO;
import co.yedam.silhyun.member.vo.PhotographerVO;

@Controller
public class AdminController {
		
	@Autowired
	private AdminSercive adminService;
	
	@GetMapping("/admin/eventManage")
	public String eventManage() {
		return "/admin/eventManage";
	}
	
	@GetMapping("/admin/memberAccept")
	public String memberAccept() {
		return "/admin/memberAccept";
	}
	
	@RequestMapping("/admin/memberManage")
	public String memberManage(Criteria cri, MemberVO vo, Model model) {
		model.addAttribute("todayMem", adminService.todayMem());
		model.addAttribute("todayPtg", adminService.todayPtg());
		model.addAttribute("todayStd", adminService.todayStd());
		
		//model.addAttribute("memberList", adminService.memberList());
		model.addAttribute("ptgList",adminService.ptgList());
		model.addAttribute("stdList",adminService.stdList());
		
		
		
		//회원전체리스트 페이징 
		model.addAttribute("memberList", adminService.getListMember(cri));
		model.addAttribute("page", new PageVO(adminService.getTotalCount(cri), 10, cri));
		
		return "/admin/memberManage";
	}
	
	
	//소속 작가 보기
//	@PostMapping("/belongPtg")
//	@ResponseBody
//	public Model belongPtg(String stId, Model model) {
//		System.out.println("컨트롤러로 온 stId는 =" + stId);
//		model.addAttribute("belongPtg", adminService.belongPtg(stId));
//		
//		System.out.println("컨트롤러의 model은"+model);
//		model.addAttribute("STbelong", stId);
//		return model;
//	}
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
	
	
	
	@GetMapping("/admin/orderManage")
	public String orderManage() {
		return "/admin/orderManage";
	}
	
	@GetMapping("/admin/qstManage")
	public String qstManage() {
		return "/admin/qstManage";
	}
	
	@GetMapping("/admin/quitManage")
	public String quitManage(Model model) {
		model.addAttribute("qtList",adminService.qtList());
		return "/admin/quitManage";
	}
	
	@GetMapping("/admin/rankManage")
	public String rankManage() {
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
	public String dashBoard() {
		return "/admin/dashBoard";
	}
	

	
}

