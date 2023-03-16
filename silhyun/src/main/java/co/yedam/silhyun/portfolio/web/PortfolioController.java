package co.yedam.silhyun.portfolio.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import co.yedam.silhyun.common.service.PhotoService;
import co.yedam.silhyun.common.vo.CommentVO;
import co.yedam.silhyun.common.vo.PhotoVO;
import co.yedam.silhyun.member.vo.PhotographerVO;
import co.yedam.silhyun.portfolio.service.PortfolioService;
import co.yedam.silhyun.portfolio.vo.PortfolioVO;

@Controller
public class PortfolioController {

	@Autowired
	private PortfolioService portfolioService;
	@Autowired
	private PhotoService photoService;

	@GetMapping("/silhyun/portfolio/{ptgId}")
	public String portfolio(Model model) {
		return "portfolio/portfolio";
	}

	@RequestMapping("/silhyun/portfolioInsert")
	public String portfolioInsertForm(Model model) {
		return "portfolio/portfolioInsertForm";
	}

	@RequestMapping("/silhyun/modalTest") // 모달화면구현~
	public String modalTest(Model model) {
		return "portfolio/modalTest";
	}
	
	
	@RequestMapping("/silhyun/detailPortfolioPhoto/{portNum}")// 포트폴리오 번호당 디테일포토 가져오기.
	@ResponseBody
	public List<PortfolioVO> detailPortPhoto(Model model, PortfolioVO vo, @PathVariable String portNum) {
		model.addAttribute("detailPortfolioPhoto", portfolioService.detailPortfolioPhoto(portNum));
		return portfolioService.detailPortfolioPhoto(portNum);
	}
	
	@RequestMapping("/silhyun/portfolioptg/{ptgId}")//포트폴리오상세페이지 해당작가정보
	@ResponseBody
	public List<PhotographerVO> portPtg(Model model, PhotographerVO vo, @PathVariable String ptgId) {
		model.addAttribute("portfolioPtg", portfolioService.portfolioPtg(ptgId));
		return portfolioService.portfolioPtg(ptgId);
	}
	
	@RequestMapping("/silhyun/ptgField/{ptgId}")//해당작가필드리스트
	@ResponseBody
	public List<PhotographerVO> portPtgField(Model model, PhotographerVO vo, @PathVariable String ptgId) {
		model.addAttribute("ptgField", portfolioService.ptgField(ptgId));
		return portfolioService.ptgField(ptgId);
	}
	
	@RequestMapping("/silhyun/ptgPortfolioList/{ptgId}")//작가별 포트폴리오리스트 띄우기
	@ResponseBody
	public List<PortfolioVO> ptgPortList(Model model, PortfolioVO vo, @PathVariable String ptgId) {
		model.addAttribute("ptgPortList", portfolioService.ptgPortfolioList(ptgId));
		return portfolioService.ptgPortfolioList(ptgId);
	}
	
	
	
	//insert
	@PostMapping("/silhyun/addPortfolio")
	public ResponseEntity<?> insertPortfolio(@RequestParam("files") List<MultipartFile> files,
											PortfolioVO portfolioVO) {
		 try {
			 	String ctgrNum =  portfolioService.insertPortfolio(files, portfolioVO);
			 	photoService.photoInsert(files, ctgrNum, "P");
		        return ResponseEntity.ok().build();
		    } catch (Exception e) {
		        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		    }
	    }
	
	
	
	@RequestMapping("/silhyun/imsiList/{ptgId}")//작가별 포트폴리오리스트 띄우기
	@ResponseBody
	public List<PortfolioVO> ptgImsiList(Model model, PortfolioVO vo, @PathVariable String ptgId) {
		model.addAttribute("imsiList", portfolioService.imsiList(ptgId));
		return portfolioService.imsiList(ptgId);
	}
	
	
	@RequestMapping("/silhyun/portfolioUpdate")
	public String portfolioUpdateForm(Model model) {
		return "portfolio/portfolioUpdateForm";
	}
	
	
}
