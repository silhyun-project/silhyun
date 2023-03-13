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
		String[] array = pvo.getPhoNum().split(",");
		System.out.println(array);
		for(String i : array) {
			System.out.println(i);
		}
		System.out.println(rvo);
		for(MultipartFile file: files) {
			System.out.println(file);
		}
		return rvo;
	}
}
