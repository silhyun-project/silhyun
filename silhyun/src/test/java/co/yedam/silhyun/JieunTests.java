package co.yedam.silhyun;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

import co.yedam.silhyun.member.service.PtgService;
import co.yedam.silhyun.member.vo.PhotographerVO;

@SpringBootTest
public class JieunTests {
	@Autowired
	private PtgService ptgService;

	@Test
	public void 검색() {
		
		
		PhotographerVO vo = new PhotographerVO();
		String[] chkArray = {"06"};
		vo.setChkArray(chkArray);
		
		System.out.println("작가정보들"+ ptgService.ptgSearchList(vo));

		
	}
	
}
