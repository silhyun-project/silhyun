package co.yedam.silhyun.portfolio.service;

import co.yedam.silhyun.portfolio.vo.LikePhotoVO;

public interface PortfolioService {

	boolean isLiked(LikePhotoVO like);// 조아요 데이터 확인

	void addLike(LikePhotoVO like);// 조아요 추가하기

	void removeLike(LikePhotoVO like);// 조아요 삭제하기

	

}
