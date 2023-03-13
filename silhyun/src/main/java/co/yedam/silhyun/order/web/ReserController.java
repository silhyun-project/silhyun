package co.yedam.silhyun.order.web;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import co.yedam.silhyun.SessionUser;
import co.yedam.silhyun.common.vo.Criteria;
import co.yedam.silhyun.common.vo.PageVO;
import co.yedam.silhyun.event.service.CouponService;
import co.yedam.silhyun.event.vo.CouponHistoryVO;
import co.yedam.silhyun.member.service.PtgService;
import co.yedam.silhyun.member.service.StdService;
import co.yedam.silhyun.member.vo.OptionsVO;
import co.yedam.silhyun.member.vo.PhotographerVO;
import co.yedam.silhyun.member.vo.StudioVO;
import co.yedam.silhyun.mypage.service.PointService;
import co.yedam.silhyun.mypage.vo.PointVO;
import co.yedam.silhyun.mypage.vo.UsedPointVO;
import co.yedam.silhyun.order.service.OrderService;
import co.yedam.silhyun.order.service.PaymentService;
import co.yedam.silhyun.order.service.SelectedOpService;
import co.yedam.silhyun.order.vo.PaymentVO;
import co.yedam.silhyun.order.vo.ReserVO;
import co.yedam.silhyun.order.vo.SelectedOpVO;

@Controller
public class ReserController {
	@Autowired PtgService ptgService;
	@Autowired StdService stdService;
	@Autowired OrderService orderService;
	@Autowired PaymentService paymentService;
	@Autowired SelectedOpService selectedOpService;
	@Autowired PointService pointService;
	@Autowired CouponService couponService;

	/// ▶작가
	@RequestMapping("/silhyun/ptgList") // 작가 리스트
	public String ptgList(Criteria cri, Model model, PhotographerVO vo) {
		cri.setAmount(6);
		model.addAttribute("ptgList", ptgService.getPtgLsit(cri, vo));
		model.addAttribute("page", new PageVO(ptgService.getTotalCount(cri, vo), 10, cri));
//		model.addAttribute("ptgList", ptgService.getPtgLsit(cri, vo));
		return "reser/ptgList";
	}
//
//	@RequestMapping("/silhyun/searchPtgList") // 지역, 분야 검색
//	@ResponseBody
//	public List<PhotographerVO> searchPthList(@RequestBody PhotographerVO vo,Criteria cri, Model model) {
//		cri.setAmount(6);
//		System.out.println("vo : " + vo);
//		model.addAttribute("list", ptgService.ptgSearchList(cri, vo));
//		model.addAttribute("page", new PageVO(ptgService.getTotalListCount(cri, vo), 10, cri));
//		return ptgService.ptgSearchList(cri,vo);
//	}
//
//	@GetMapping("/silhyun/AjaxPtgList/{searchType}") // 검색 필터
//	@ResponseBody
//	public List<PhotographerVO> ajaxPtgList(Model model,@PathVariable String searchType, PhotographerVO vo, Criteria cri) {
//		cri.setAmount(6);
//		model.addAttribute("list", ptgService.getPtgLsit(cri, vo));
//		model.addAttribute("page", new PageVO(ptgService.getTotalCount(cri, vo), 10, cri));
//		return ptgService.getPtgLsit(cri, vo);
//	}

	@GetMapping("/silhyun/ptgDetail/{ptgId}") // 작가 한명 상세페이지
	public String ptgDetail(Model model, PhotographerVO vo, @PathVariable String ptgId) {

		model.addAttribute("ptg", ptgService.getPtg(ptgId));
		System.out.println(vo);
		System.out.println(vo.getZzims());
		System.out.println("호출");
		return "reser/ptgDetail";
	}

	/// ▶사진관
	@RequestMapping("/silhyun/stdList") // 사진관 전체 리스트
	public String studioList(Criteria cri, Model model, StudioVO vo) {
		cri.setAmount(6);
		// model.addAttribute("stdList");
		model.addAttribute("page", new PageVO(stdService.getTotalCount(cri, vo), 10, cri));
		model.addAttribute("stdList", stdService.getStdList(cri, vo));
		System.out.println(vo);
		return "reser/stdList";
	}

	@RequestMapping("/silhyun/stdDetail/{stId}") // 사진관 상세 보기
	public String stdDetail(Model model, StudioVO vo, @PathVariable String stId) {
		model.addAttribute("std", stdService.getStd(stId));
		return "reser/stdDetail";
	}

	@RequestMapping("/ajaxStdList/{stdId}") // 사진관 아작스 호출
	@ResponseBody
	public List<StudioVO> ajaxStdList(@PathVariable String stdId) {
		System.out.println("호출");
		return stdService.getReserList(stdId);
	}

	// ▶예약 폼
	@RequestMapping("/pay/reserList/{ptgId}")  //선택한 작가 예약하러 가기
	public String reserList(Model model, PhotographerVO vo, @PathVariable String ptgId,HttpSession httpSession) {
		SessionUser user = (SessionUser) httpSession.getAttribute("user");  //세션 담기
		if(user != null) {  //세션
			model.addAttribute("id",user.getId());
			model.addAttribute("role",user.getRole());
		}
		model.addAttribute("res",ptgService.getReser(ptgId));
		System.out.println("예약폼====="+vo);
		System.out.println(ptgId);
		return "reser/reserList";
	}
	
	@RequestMapping("/ajaxResTime/{ptgId}/{redate}")  //작가가 등록한 시간 아작스 호출
	@ResponseBody
	public List<PhotographerVO> ajaxResTime(Model model,@PathVariable String redate,@PathVariable String ptgId){
		System.out.println("호출 되었니");
		System.out.println("redate====="+redate);
		return ptgService.getResTime(ptgId,redate);
	}

	@RequestMapping("/pay/orderForm")
	public String orderForm(ReserVO vo,SelectedOpVO svo,Model model,OptionsVO ovo){
		model.addAttribute("memInfo", orderService.getMemberInfoList(vo));
		System.out.println("호출 되니");
		System.out.println(vo.getId()+"3333333");
		return "order/orderList";
	}
	
	@PostMapping("/pay/reserInsert")
	@ResponseBody
	public ReserVO reserInsert(ReserVO rvo, PaymentVO pvo,SelectedOpVO svo,PointVO ptvo, UsedPointVO upvo,CouponHistoryVO chvo) {//@RequestBody
		String resNum = orderService.reserInsert(rvo);
		System.out.println("여기는 예약 insert resNum=>"+resNum);  //정상적으로 넘어옴 
		System.out.println("rvo에 담겼니 =>"+rvo);
		
		//예약시 paymentInsert 테이블에 추가
		pvo.setResNum(rvo.getResNum());
		paymentService.paymentInsert(pvo);  

		//결제 시 SelectedOpVO 테이블에 추가 
		svo.setResNum(pvo.getResNum());  
		selectedOpService.selectedOpInsert(svo);
		
		//결제시 결제 금액의 10% 포인트로 지급
		ptvo.setSaveNum(pvo.getOrdNum()); //포인트vo에 pvo에 주문번호 넣어주기(결제금액의 10%)
		System.out.println("pvo.getOrdNum() ========>>"+pvo.getOrdNum());
		pointService.pointInsert(ptvo);  //결제하면 멤버 테이블에 pointSum에 증가 
		
		//결제시 사용한 포인트가 있으면!
		if(pvo.getUPoint() != 0) {  
			upvo.setUsedNum(pvo.getOrdNum()); // 사용된 포인트 vo에 pvo주문 번호 넣어주기
			pointService.usedPointInsert(upvo);  //결제시 사용한 포인트테이블에 추가하고  멤버테이블에서 차감
		}
		//결제 시 사용한 쿠폰이 있으면!
		if(pvo.getUCpNum() !=null) {  
			chvo.setId(pvo.getId());
			chvo.setCpnNum(pvo.getUCpNum());
			couponService.updateCoupon(chvo);
		}
		return rvo;
	}
	
	@RequestMapping("/pay/orderEnd/{id}")  //결제 다 하면 주문 내역서 창
	public String orderEnd(Model model,@PathVariable String id,ReserVO vo) {
		model.addAttribute("resInfo",paymentService.getPaymentInfo(id));
		return "order/orderEnd";
	}
}
