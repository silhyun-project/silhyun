package co.yedam.silhyun.common.map;

import java.util.List;

import co.yedam.silhyun.common.vo.Criteria;
import co.yedam.silhyun.common.vo.ReviewVO;
import co.yedam.silhyun.member.vo.PhotographerVO;

public interface ReviewMapper {
	List<ReviewVO> reviewList(Criteria cri, String ctgr, String ctgrNum);  //나중에 페이징+ 검색으로 바꾸기
	int getTotalCount(String ctgr, String ctgrNum); //페이지 총 수 
	ReviewVO reivewSelect(ReviewVO vo); //수정시 필요한 단건조회
	int reviewInsert(ReviewVO vo); //댓글입력
	int reviewUpdate(ReviewVO vo); //댓글수정
	int reviewDelete(ReviewVO vo); //댓글삭제
	
	PhotographerVO ptgStarAvg(String ctgr, String ctgrNum); //평균별점

}
