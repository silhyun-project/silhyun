package co.yedam.silhyun.common.service;

import java.util.List;

import co.yedam.silhyun.common.vo.ReviewVO;

public interface ReviewService {
	List<ReviewVO> reviewList();  //나중에 페이징+ 검색으로 바꾸기
	ReviewVO reviewSelect(ReviewVO vo); //단건검색
	
	
}
