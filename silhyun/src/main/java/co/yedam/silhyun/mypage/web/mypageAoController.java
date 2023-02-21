package co.yedam.silhyun.mypage.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class mypageAoController {
	
	@GetMapping("/mypageAo")
	public String mypageAo() {
		return "mypageAo/mypageAo";
	}
	
	@GetMapping("/modPfAo")
	public String modpfAo() {
			
			return "mypageAo/modPfAo";
		}
	@GetMapping("/resManage")
	public String resManage() {
		
		return "mypageAo/resManage";
	}
	@GetMapping("/classManage")
	public String classManage() {
		
		return "mypageAo/classManage";
	}

}
