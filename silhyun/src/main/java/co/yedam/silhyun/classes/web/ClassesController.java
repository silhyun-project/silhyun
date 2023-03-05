package co.yedam.silhyun.classes.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import co.yedam.silhyun.classes.service.ClassesService;

@Controller
public class ClassesController {

	@Autowired
	private ClassesService ClassesService;
	
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
	
	@RequestMapping("classes/myClassVideos")
	public String myClassesVidios(Model model) {
		model.addAttribute("IVInfo",ClassesService.getClassIVInfo("2", "catLove"));
		System.out.println("컨트롤러로 온 클래스IVInfo"+ model);
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
