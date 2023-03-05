package co.yedam.silhyun.portfolio.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import co.yedam.silhyun.portfolio.service.PortfolioService;
import co.yedam.silhyun.portfolio.vo.LikePhotoVO;

@RestController
public class LikeController {

	 @Autowired
	  private PortfolioService PortfolioService;
	 
	 @PostMapping("/addLike")//조아요 추가하기
	  public ResponseEntity<String> addLike(@RequestBody LikePhotoVO like) {
		 PortfolioService.addLike(like);
	    return ResponseEntity.ok("success");
	  }
	
}
