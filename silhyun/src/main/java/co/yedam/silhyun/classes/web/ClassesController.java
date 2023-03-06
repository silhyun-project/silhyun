package co.yedam.silhyun.classes.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
	
	
    @RequestMapping("/insertWInfo")
    @ResponseBody
    public String insertWInfo(@RequestParam("inetNum") String inetNum,
                              @RequestParam("classNum") String classNum,
                              @RequestParam("id") String id,
                              @RequestParam("stwTime") String stwTime,
                              @RequestParam("ewTime") String ewTime,
                              @RequestParam("cumlwTime") String cumlwTime) {
        InetClassesWtchVO ICVo = new InetClassesWtchVO();
        ICVo.setInetNum(inetNum);
        ICVo.setClassNum(classNum);
        ICVo.setId(id);
        ICVo.setStwTime(stwTime);
        ICVo.setEwTime(ewTime);
        ICVo.setCumlwTime(cumlwTime);
        // service 메소드를 호출하여 데이터 삽입 또는 업데이트 수행
        ClassesService.insertWInfo(ICVo);
        return "success";
    }
	
}
