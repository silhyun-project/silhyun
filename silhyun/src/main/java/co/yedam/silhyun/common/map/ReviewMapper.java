package co.yedam.silhyun.common.map;

import java.util.List;

import co.yedam.silhyun.common.vo.Criteria;
import co.yedam.silhyun.common.vo.ReviewVO;
import co.yedam.silhyun.member.vo.PhotographerVO;

public interface ReviewMapper {
	List<ReviewVO> reviewList(Criteria cri, String ctgr, String ctgrNum);  //페이징+ 검색
	int getTotalCount(Criteria cri,String ctgr, String ctgrNum); //페이지 총 수 
	ReviewVO reivewSelect(ReviewVO vo); //수정시 필요한 단건조회
	int reviewInsert(ReviewVO vo); //리뷰입력
	int reviewUpdate(ReviewVO vo); //리뷰수정
	int reviewDelete(ReviewVO vo); //리뷰삭제
	
	int isReciewCheck(String id, String ptgId); //리뷰작성시 예약내역 체크
	
	PhotographerVO ptgStarAvg(String ctgr, String ctgrNum); //평균별점

}
