package co.yedam.silhyun.common.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import co.yedam.silhyun.common.service.PhotoService;
import co.yedam.silhyun.common.service.ReviewService;
import co.yedam.silhyun.common.vo.PhotoVO;

@RestController
public class RestReviewController {
	@Autowired ReviewService rService;
	@Autowired PhotoService pService;
	
	@PostMapping("/silhyun/getPhoto")
	public List<PhotoVO> getPhoto(PhotoVO vo) {
		List<PhotoVO> list = new ArrayList<PhotoVO>();
		list = pService.photoList(vo);
		return list;
	}
}
