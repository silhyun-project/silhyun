package co.yedam.silhyun.portfolio.map;

import java.util.List;

import co.yedam.silhyun.portfolio.vo.LikePhotoVO;
import co.yedam.silhyun.portfolio.vo.PortfolioVO;

public interface PortfolioMapper {

	 int findLike(LikePhotoVO like);// 조아요 데이터 찾기

	void insertLike(LikePhotoVO like);// 조아요 추가하기

	void deleteLike(LikePhotoVO like);// 좋아요 삭제하기

	List<PortfolioVO> detailPortfolio(String portNum);//포트폴리오클릭한거내용;
	List<PortfolioVO> detailPortfolioPhoto(String portNum);//포트폴리오사진
}
