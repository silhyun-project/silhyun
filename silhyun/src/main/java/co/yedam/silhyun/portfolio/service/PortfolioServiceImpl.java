package co.yedam.silhyun.portfolio.service;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import co.yedam.silhyun.common.vo.PhotoVO;
import co.yedam.silhyun.member.vo.PhotographerVO;
import co.yedam.silhyun.portfolio.map.PortfolioMapper;
import co.yedam.silhyun.portfolio.vo.LikePhotoVO;
import co.yedam.silhyun.portfolio.vo.PortfolioVO;
import co.yedam.silhyun.portfolio.vo.TagVO;

@Service
public class PortfolioServiceImpl implements PortfolioService {

	@Autowired
	private PortfolioMapper portfolioMapper;

	@Override // 조아요 확인
	public boolean isLiked(LikePhotoVO like) {
		int count = portfolioMapper.findLike(like);
		return count > 0;
	}

	@Override // 조아요 추가하기
	public void addLike(LikePhotoVO like) {
		portfolioMapper.insertLike(like);
	}

	@Override // 조아요삭제하기
	public void removeLike(LikePhotoVO like) {
		portfolioMapper.deleteLike(like);
	}

	@Override // 포트폴리오클릭한거사진리스트;
	public List<PortfolioVO> detailPortfolioPhoto(String portNum) {
		return portfolioMapper.detailPortfolioPhoto(portNum);
	}

	@Override // 포트폴리오상세페이지작가정보
	public List<PhotographerVO> portfolioPtg(String ptgId) {
		return portfolioMapper.portfolioPtg(ptgId);
	}

	@Override // 작가필드리스트
	public List<PhotographerVO> ptgField(String ptgId) {
		return portfolioMapper.ptgField(ptgId);
	}

	@Override // 작가별 포트폴리오리스트 띄우기
	public List<PortfolioVO> ptgPortfolioList(String ptgId) {
		// TODO Auto-generated method stub
		return portfolioMapper.ptgPortfolioList(ptgId);
	}

	@Override
	public void insertPortfolio(List<MultipartFile> files, List<String> tagCntns, String upSta, String cntn,
			String ptgId) {
		// portfolio 테이블에 데이터 삽입
		PortfolioVO portfolioVO = new PortfolioVO();
		portfolioVO.setCntn(cntn);
		portfolioVO.setPtgId(ptgId);
		portfolioVO.setUpsta(upSta);

		portfolioMapper.insertPortfolio(portfolioVO);

		// 삽입된 데이터의 pk를 이용하여 photo 테이블에 데이터 삽입
		for (MultipartFile file : files) {
			String filename = file.getOriginalFilename();
			String filepath = "C:/saveImg/portfolio" + filename;
			file.transferTo(new File(filepath));
			PhotoVO photoVO = new PhotoVO();

			photoVO.setPhoRt(filepath);
			portfolioMapper.insertPhoto(photoVO);
		}

		// tag 테이블에 데이터 삽입
		
		for (String tagCntn : tagCntns) {
			TagVO tagVO = new TagVO();
			tagVO.setTagCntn(tagCntn);
			portfolioMapper.insertTag(tagVO);

		}
	}

}
