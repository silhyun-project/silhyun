package co.yedam.silhyun.common.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import co.yedam.silhyun.common.vo.Criteria;
import co.yedam.silhyun.common.vo.ReviewVO;
import co.yedam.silhyun.member.vo.PhotographerVO;

public interface ReviewService {
	List<ReviewVO> reviewList(Criteria cri, String ctgr, String ctgrNum);  //나중에 페이징+ 검색으로 바꾸기
	int getTotalCount(Criteria cri); //페이지 총 수 
	ReviewVO reivewSelect(ReviewVO vo); //수정시 필요한 단건조회
	String reviewInsert(ReviewVO vo); //리뷰입력
	int reviewUpdate(ReviewVO vo); //리뷰수정
	int reviewDelete(ReviewVO vo); //리뷰삭제
	
	
	//나중에 지은이꺼랑 합치기
	PhotographerVO ptgStarAvg(String ctgr, String ctgrNum); //평균별점
	
}
