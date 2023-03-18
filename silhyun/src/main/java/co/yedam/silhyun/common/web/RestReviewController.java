package co.yedam.silhyun.common.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import co.yedam.silhyun.common.service.PhotoService;
import co.yedam.silhyun.common.service.ReviewService;
import co.yedam.silhyun.common.vo.PhotoVO;
import co.yedam.silhyun.common.vo.ReviewVO;

@RestController
public class RestReviewController {
	@Autowired ReviewService rService;
	@Autowired PhotoService pService;
	
	@PostMapping("/silhyun/review")
	public ReviewVO reviewInsert(ReviewVO vo, List<MultipartFile> files) {  //@RequestParam => 필수값임
		vo.setCtgr("A");
		String ctgrNum = rService.reviewInsert(vo);
		String ctgr = "R";
		pService.photoInsert(files, ctgrNum, ctgr);
		return vo;
	}

	
	@PostMapping("/silhyun/getPhoto")
	public List<PhotoVO> getPhoto(PhotoVO vo) {
		List<PhotoVO> list = new ArrayList<PhotoVO>();
		list = pService.photoList(vo);
		return list;
	}
	
	@GetMapping("/silhyun/reviewUpdate/{revNum}")
	public Map<String, Object> selectReview(@PathVariable("revNum") String revNum, ReviewVO vo, PhotoVO pvo){
		vo.setRevNum(revNum);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("rev", rService.reivewSelect(vo));
		pvo = new PhotoVO();
		pvo.setCtgr("R");
		pvo.setCtgrNum(vo.getRevNum());
		map.put("pho", pService.photoList(pvo));
		
		return map;
	}
	@PostMapping("/silhyun/update")
	public ReviewVO updateReview(PhotoVO pvo, ReviewVO rvo, List<MultipartFile> files) {
		//리뷰 업댓
		System.out.println("reviewVodd"+rvo);
		rService.reviewUpdate(rvo);
		System.out.println("여기까지 오는거얌?");
		//사진(uesed -> N/ phoNum 반복문 돌려서...)
		String[] ary = pvo.getPhoNum().split(",");
		for(String id : ary) {
			System.out.println(id);
			pvo.setPhoNum(id);
			pvo.setUsed("N");
			pService.photoDelete(pvo);
		}
//		//사진 업댓
		String ctgrNum = rvo.getRevNum(); 
		String ctgr = "R";
		pService.photoInsert(files, ctgrNum, ctgr);
		return rvo;
	}
	
	@GetMapping("/reviewDel")
	public String reviewDelete(ReviewVO vo) {
		//파일삭제
		PhotoVO pvo = new PhotoVO();
		pvo.setUsed("N");
		pvo.setCtgr("R");
		pvo.setCtgrNum(vo.getRevNum());
	    pService.photoDelete(pvo);
	    //리뷰삭제
	    rService.reviewDelete(vo);
		
		return "del";
	}
}
