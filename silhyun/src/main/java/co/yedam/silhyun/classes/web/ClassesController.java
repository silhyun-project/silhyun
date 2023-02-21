package co.yedam.silhyun.classes.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ClassesController {

	@Autowired
	
	@GetMapping("/classe/classesInfo")
	public String classesInfo() {
		return "/classes/classesInfo";
	}
	
	@GetMapping("/classes/classesMain")
	public String classesclassesMain() {
		return "/classes/classesMain";
	}
	
	@GetMapping("/classe/classesVideo")
	public String classesVideo() {
		return "/classes/classesVideo";
	}
	
	@GetMapping("/classe/myAllClasses")
	public String myAllClasses() {
		return "/classes/myAllClasses";
	}
	@GetMapping("/classe/myClassesVidios")
	public String myClassesVidios() {
		return "/classes/myClassesVidios";
		
	}
	

}
