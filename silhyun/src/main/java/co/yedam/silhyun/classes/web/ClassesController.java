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
	
	@GetMapping("/myAllClasses")
	public String myAllClasses() {
		return "/classes/myAllClasses";
	}
	@GetMapping("/myClassesVidios")
	public String myClassesVidios() {
		return "/classes/myClassesVidios";
	}
	

}
