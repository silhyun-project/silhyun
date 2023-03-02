package co.yedam.silhyun.common.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.yedam.silhyun.common.map.ReviewMapper;
import co.yedam.silhyun.common.vo.ReviewVO;

@Service
public class ReviewServiceImpl implements ReviewService {
	@Autowired ReviewMapper mapper;

	@Override
	public List<ReviewVO> reviewList() {
		
		return mapper.reviewList();
	}

	@Override
	public ReviewVO reviewSelect(ReviewVO vo) {
		
		reviewHitUpdate(vo.getRevNum());
		return mapper.reviewSelect(vo);
	}

	@Override
	public String reviewInsert(ReviewVO vo) {
		mapper.reviewInsert(vo);
		System.out.println("리뷰번호가 넘어오는감??? ================"+vo.getRevNum());
		return vo.getRevNum();
	}

	@Override
	public int reviewUpdate(ReviewVO vo) {
		
		return mapper.reviewUpdate(vo);
	}

	@Override
	public int reviewDelete(ReviewVO vo) {
		
		return mapper.reviewDelete(vo);
	}

	@Override
	public int reviewHitUpdate(String num) {
		
		return mapper.reviewHitUpdate(num);
	}

}
