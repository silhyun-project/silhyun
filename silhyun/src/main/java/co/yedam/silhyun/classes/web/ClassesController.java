package co.yedam.silhyun.classes.web;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	//클래스 메인페이지. 클래스 리스트들을 보여줌
	@RequestMapping("/silhyun/classes/classesMain")
	public String classesMain(Model model) {
		model.addAttribute("c1List", ClassesService.getC1List());
		model.addAttribute("c2List", ClassesService.getC2List());
		System.out.println("컨트롤러로 온 model"+model.getAttribute("c1List"));
		//이거 페이지에 값 제대로 담기는데 안 읽힘. 왜지?
		return "/classes/classesMain";
	}

	
	
	@GetMapping("/classesInfo")
	public String classesInfo() {
		return "/classes/classesInfo";
	}
	
	
	@RequestMapping("/silhyun/classes/classesVideo")
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
	
	@RequestMapping("/silhyun/classes/myClassVideos")
	public String myClassesVidios(Model model) {
		model.addAttribute("IVInfo",ClassesService.getClassIVInfo("2", "catLove"));
		
		System.out.println("컨트롤러로 온 클래스IVInfo"+ model);
		return "/classes/myClassesVideos";	
	}
	
	@GetMapping("/bestClasses")
	public String bestClasses(Model model) {
		model.addAttribute("c1List", ClassesService.getC1List());
		model.addAttribute("c2List", ClassesService.getC2List());
		return "/classes/bestClasses";
	}
	
	@GetMapping("/freeClasses")
	public String freeClasses(Model model) {
		model.addAttribute("fC1List", ClassesService.getFC1List());
		model.addAttribute("fC2List", ClassesService.getFC2List());
		return "/classes/freeClasses";
	}
	
	@GetMapping("/eventClasses")
	public String eventClasses(Model model) {
		model.addAttribute("c1List", ClassesService.getC1List());
		model.addAttribute("c2List", ClassesService.getC2List());
		return "/classes/eventClasses";
	}
	
	
    @ResponseBody
    @RequestMapping(value = "/silhyun/classes/insertWInfo", method = RequestMethod.POST)
    public InetClassesWtchVO insertWInfo(InetClassesWtchVO vo) {

		System.out.println("컨트롤러로 온 vo"+vo);
		int n = ClassesService.insertWInfo(vo);
		if (n != 0) {
			System.out.println("시청기록 갱신완료");
		}else {
			System.out.println("시청기록 갱신실패");
		}
        
        
        return vo;
        
    }
 

    @RequestMapping(value = "/silhyun/classes/cdtCList", method = RequestMethod.GET)
    public @ResponseBody Map<String, Object> cdtCList(@RequestParam("param1") int param1) {
        List<Map<String, Object>> cdtC1List = ClassesService.cdtC1List(param1);
        List<Map<String, Object>> cdtC2List = ClassesService.cdtC2List(param1);

        Map<String, Object> result = new HashMap<>();
        result.put("cdtC1List", cdtC1List);
        result.put("cdtC2List", cdtC2List);
        
        return result;
    }
    
    
}
