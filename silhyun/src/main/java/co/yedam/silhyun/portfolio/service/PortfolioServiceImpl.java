package co.yedam.silhyun.portfolio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.yedam.silhyun.portfolio.map.PortfolioMapper;
import co.yedam.silhyun.portfolio.vo.LikePhotoVO;

@Service
public class PortfolioServiceImpl implements PortfolioService {

	@Autowired
	private PortfolioMapper portfolioMapper;

	@Override
	 public boolean isLiked(LikePhotoVO like) {
        int count = portfolioMapper.findLike(like);
        return count > 0;
    }

	@Override
	public void addLike(LikePhotoVO like) {
		// 조아요 추가하기
		portfolioMapper.insertLike(like);
	}

	@Override
	public void removeLike(LikePhotoVO like) {
		// 조아요삭제하기
		portfolioMapper.deleteLike(like);
	}

}
