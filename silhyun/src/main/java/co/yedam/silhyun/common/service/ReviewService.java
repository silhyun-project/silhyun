package co.yedam.silhyun.common.service;

import java.util.List;

import co.yedam.silhyun.common.vo.ReviewVO;

public interface ReviewService {
	List<ReviewVO> reviewList();  //나중에 페이징+ 검색으로 바꾸기
	ReviewVO reviewSelect(ReviewVO vo); //단건검색
	int reviewHitUpdate(String num); //조회수 업댓
	String reviewInsert(ReviewVO vo); //리뷰입력
	int reviewUpdate(ReviewVO vo); //리뷰수정
	int reviewDelete(ReviewVO vo); //리뷰삭제
	
}
