package co.yedam.silhyun;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	@GetMapping("/")
	public String layoutTest(Model model, HttpSession httpSession) {
		SessionUser user = (SessionUser) httpSession.getAttribute("user");  
		if(user != null) {
			model.addAttribute("id", user.getId());
			model.addAttribute("role", user.getRole());			
		}
		return "home/home";
	}

}
