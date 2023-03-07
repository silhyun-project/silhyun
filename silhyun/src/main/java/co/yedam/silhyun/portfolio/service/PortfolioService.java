package co.yedam.silhyun.portfolio.service;

import java.util.List;

import co.yedam.silhyun.portfolio.vo.LikePhotoVO;
import co.yedam.silhyun.portfolio.vo.PortfolioVO;

public interface PortfolioService {

	boolean isLiked(LikePhotoVO like);// 조아요 데이터 확인

	void addLike(LikePhotoVO like);// 조아요 추가하기

	void removeLike(LikePhotoVO like);// 조아요 삭제하기

	List<PortfolioVO> detailPortfolio(String portNum);//포트폴리오클릭한거내용;
	List<PortfolioVO> detailPortfolioPhoto(String portNum);//포트폴리오사진

}
