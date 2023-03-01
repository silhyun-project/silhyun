package co.yedam.silhyun.classes.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ClassesController {

	@Autowired
	
	@GetMapping("/classesInfo")
	public String classesInfo() {
		return "/classes/classesInfo";
	}
	
	@GetMapping("/classesMain")
	public String classesMain() {
		return "/classes/classesMain";
	}
	
	@GetMapping("/classesVideo")
	public String classesVideo() {
		return "/classes/classesVideo";
	}
	
	@GetMapping("/myClasses")
	public String myClasses() {
		return "/classes/myClasses";
	}
	@GetMapping("/myClassesVideos")
	public String myClassesVidios() {
		return "/classes/myClassesVideos";	
	}
	
	@GetMapping("/bestClasses")
	public String bestClasses() {
		return "/classes/bestClasses";
	}
	
	@GetMapping("/freeClasses")
	public String freeClasses() {
		return "/classes/freeClasses";
	}
	
	@GetMapping("/eventClasses")
	public String eventClasses() {
		return "/classes/eventClasses";
	}

}
