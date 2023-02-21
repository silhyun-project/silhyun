package co.yedam.silhyun.mypage.web;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/modPfAo")
public class mypageAoController {
	
	@PostMapping()
	public String modpfAo() {
			
			return "/mypageAo/modPfAo";
		}

}
