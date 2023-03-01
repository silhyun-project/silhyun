package co.yedam.silhyun.common.map;

import java.util.List;

import co.yedam.silhyun.common.vo.ReviewVO;

public interface ReviewMapper {
	List<ReviewVO> reviewList();  //나중에 페이징+ 검색으로 바꾸기
	ReviewVO reviewSelect(ReviewVO vo); //단건검색
	int reviewHitUpdate(String num); //조회수 업댓
	int reviewInsert(ReviewVO vo); //댓글입력
	int reviewUpdate(ReviewVO vo); //댓글수정
	int reviewDelete(ReviewVO vo); //댓글삭제

}
