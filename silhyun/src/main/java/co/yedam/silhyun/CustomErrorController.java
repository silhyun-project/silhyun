package co.yedam.silhyun;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CustomErrorController implements ErrorController {
//마지막 날에 풀기
    // error path를 꼭 "/error" 로 하자!
//	private final String ERROR_PATH = "/error";
	
//    @GetMapping(ERROR_PATH)
//    public String redirectRoot(){
//        return "home/home";
//    }
//
//    public String getErrorPath(){
//        return null;
//    }
}
