package co.yedam.silhyun.portfolio.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

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
	public String insertPortfolio(List<MultipartFile> files, PortfolioVO portfolioVO) {
		// portfolio 테이블에 데이터 삽입

		portfolioMapper.insertPortfolio(portfolioVO);

		// tag 테이블에 데이터 삽입
		ObjectMapper objectMapper = new ObjectMapper();
		TagVO[] tagCntns = null;
		try {
			tagCntns = objectMapper.readValue(portfolioVO.getTagCntn(), TagVO[].class);
			System.out.println(tagCntns[0].getTagCntn() + "sssssssssssssssssssss");
			for (TagVO tagVO : tagCntns) {
				portfolioMapper.insertTag(tagVO);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return portfolioVO.getPortNum();
	}

	@Override // 작가별 임시리스
	public List<PortfolioVO> imsiList(String ptgId) {
		// TODO Auto-generated method stub
		return portfolioMapper.imsiList(ptgId);
	}

	@Override
	public PortfolioVO portfolioSelectOne(String portNum) {
		// TODO Auto-generated method stub
		return portfolioMapper.portfolioSelectOne(portNum);
	}
	
	
	
	
	
	

//	@Override
//	public void updatePortfolio(PortfolioVO portfolioVO, List<MultipartFile> files) throws IOException {
//
//		// 1. Portfolio 정보 업데이트
//		portfolioMapper.updatePortfolio(portfolio);
//
//		// 2. 기존 사진 정보 가져오기
//		List<Picture> existingPictures = pictureMapper.getPicturesByPfId(portfolio.getPf_id());
//		portfolio.setPictures(existingPictures);
//
//		// 3. 중복 제거한 새로운 사진 업로드
//		List<Picture> newPictures = new ArrayList<>();
//		if (files != null && files.size() > 0) {
//			for (MultipartFile file : files) {
//				if (!file.isEmpty()) {
//					// 중복 체크
//					boolean isDuplicate = false;
//					for (Picture existingPicture : existingPictures) {
//						if (existingPicture.getPic_file_name().equals(file.getOriginalFilename())) {
//							isDuplicate = true;
//							break;
//						}
//					}
//					for (Picture newPicture : newPictures) {
//						if (newPicture.getPic_file_name().equals(file.getOriginalFilename())) {
//							isDuplicate = true;
//							break;
//						}
//					}
//					if (!isDuplicate) {
//						// 사진 파일 저장
//						Picture picture = new Picture();
//						picture.setPf_id(portfolio.getPf_id());
//						picture.setPic_file_name(file.getOriginalFilename());
//						picture.setPic_file_size(file.getSize());
//						picture.setPic_file_type(file.getContentType());
//						byte[] pic_data = file.getBytes();
//						picture.setPic_data(pic_data);
//						newPictures.add(picture);
//					}
//				}
//			}
//		}
//
//		// 4. 새로운 사진 추가
//		if (newPictures.size() > 0) {
//			for (Picture newPicture : newPictures) {
//				pictureMapper.insertPicture(newPicture);
//			}
//		}
//	}

}
