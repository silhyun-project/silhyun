package co.yedam.silhyun;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import co.yedam.silhyun.member.map.PtgMapper;
import co.yedam.silhyun.member.vo.PhotographerVO;

@SpringBootTest
class SilhyunApplicationTests {

	@Autowired PtgMapper ptgMapper;

	@Test
	public void 리스트() {
		List<PhotographerVO> list = ptgMapper.getPtgLsit();
		System.out.println(list.get(0));  //실행 여부만 나오면 됨
		//테이스 할때 ~인지 물어보는 명령어 제대로 되었으면 ture
		assertNotNull(list);
	}
	
}
