package co.yedam.silhyun.classes.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import co.yedam.silhyun.classes.service.ClassesService;
import co.yedam.silhyun.classes.vo.InetClassesWtchVO;

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
	
	@RequestMapping("/classes/classesVideo")
	public String classesVideo(Model model, @RequestParam("inetNum") String inetNum) {
	    System.out.println("inetNum="+inetNum);
	    model.addAttribute("IV", ClassesService.selectIV("2", inetNum, "catLove"));
	    System.out.println("컨트롤러에 온 비디오의 세부 IVModel"+model);
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
	
	
    @ResponseBody
    @RequestMapping(value = "/insertWInfo", method = RequestMethod.POST)
    public String insertWInfo(@RequestBody InetClassesWtchVO vo) {
        
    	
		String id = "catLove";
		String msg;
		
		vo.setId(id);
		
		System.out.println("컨트롤러로 온 vo"+vo);
		int n = ClassesService.insertWInfo(vo);
        
		if(n !=0) {
			msg="갱신완료";
			
		}else {
			msg="갱신실패";
		}
        
        
        return msg;
        
    }
	
}
