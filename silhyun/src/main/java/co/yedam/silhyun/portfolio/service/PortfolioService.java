package co.yedam.silhyun.portfolio.service;

import java.util.List;

import co.yedam.silhyun.member.vo.PhotographerVO;
import co.yedam.silhyun.portfolio.vo.LikePhotoVO;
import co.yedam.silhyun.portfolio.vo.PortfolioVO;

public interface PortfolioService {

	boolean isLiked(LikePhotoVO like);// 조아요 데이터 확인

	void addLike(LikePhotoVO like);// 조아요 추가하기

	void removeLike(LikePhotoVO like);// 조아요 삭제하기

	List<PortfolioVO> detailPortfolio(String portNum);//포트폴리오클릭한거내용/사진제외/모달용
	List<PortfolioVO> detailPortfolioPhoto(String portNum);//포트폴리오사진리스트/모달용
	
	List<PhotographerVO> portfolioPtg(String ptgId);//포트폴리오상세페이지작가정보
	List<PhotographerVO> ptgField(String ptgId);//작가필드리스트
	
	List<PortfolioVO> ptgPortfolioList(String ptgId);//작가별 포트폴리오리스트 띄우기

}
