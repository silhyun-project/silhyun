package co.yedam.silhyun;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import co.yedam.silhyun.common.service.PageTestService;
import co.yedam.silhyun.common.vo.Criteria;
import co.yedam.silhyun.common.vo.PageVO;

@SpringBootTest
public class TaekyeongTests {
	@Autowired PageTestService service;

	//@Test
	public void 페이징검색테스트() {
		Criteria cri = new Criteria();
		cri.setKeyword("리뷰");
		cri.setType("C");
		PageVO vo = new PageVO(100, 10, cri);
	}
	
	@Test
	public void 총갯수() {
		Criteria cri = new Criteria();
		cri.setKeyword("리뷰");	
		cri.setType("CW");
		service.getTotalCount(cri);
		System.out.println("총갯수는?"  +service.getTotalCount(cri));
	}
}
