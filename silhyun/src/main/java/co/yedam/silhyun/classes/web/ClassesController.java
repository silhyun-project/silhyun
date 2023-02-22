package co.yedam.silhyun.classes.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ClassesController {

	@Autowired
	
	@GetMapping("/classes/classesInfo")
	public String classesInfo() {
		return "/classes/classesInfo";
	}
	
	@GetMapping("/classes/classesMain")
	public String classesclassesMain() {
		return "/classes/classesMain";
	}
	
	@GetMapping("/classes/classesVideo")
	public String classesVideo() {
		return "/classes/classesVideo";
	}
	
	@GetMapping("/classes/myClasses")
	public String myClasses() {
		return "/classes/myClasses";
	}
	@GetMapping("/classes/myClassesVidios")
	public String myClassesVidios() {
		return "/classes/myClassesVidios";
		
	}
	

}
