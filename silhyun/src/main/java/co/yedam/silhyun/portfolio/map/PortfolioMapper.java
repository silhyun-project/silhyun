package co.yedam.silhyun.portfolio.map;

import co.yedam.silhyun.portfolio.vo.LikePhotoVO;

public interface PortfolioMapper {

	 int findLike(LikePhotoVO like);// 조아요 데이터 찾기

	void insertLike(LikePhotoVO like);// 조아요 추가하기

	void deleteLike(LikePhotoVO like);// 좋아요 삭제하기

}
