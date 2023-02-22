package co.yedam.silhyun;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import co.yedam.silhyun.common.vo.Criteria;
import co.yedam.silhyun.common.vo.PageVO;

@SpringBootTest
public class TaekyeongTests {

	@Test
	public void 페이징검색테스트() {
		Criteria cri = new Criteria();
		cri.setKeyword("리뷰");
		cri.setType("C");
		PageVO vo = new PageVO(100, 10, cri);
	}
}
