package co.yedam.silhyun.mypage.web;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Controller
public class mypageAoController {
	
	@GetMapping("/mypageAo")
	public String mypageAo() {
		return "mypageAo/mypageAo";
	}
	
	@GetMapping("/modPfAo")
	public String modpfAo() {
			
			return "mypageAo/modPfAo";
		}
	@GetMapping("/resManage")
	public String resManage() {
		
		return "mypageAo/resManage";
	}
	@GetMapping("/classManage")
	public String classManage() {
		
		return "mypageAo/classManage";
	}
	@GetMapping("/mypageAoAsk")
	public String mypageAoAsk() {
		
		return "mypageAo/mypageAoAsk";
	}
	@GetMapping("/resCalendarAo")
	public String resCalendarAo() {
		
		return "mypageAo/resCalendarAo";
	}
	@GetMapping("/mypageStatsAo")
	public String mypageStatsAo() {
		
		return "mypageAo/mypageStatsAo";
	}
	
	@GetMapping("/reportFormAo")
	public String reportAo() {
		
		return "mypageAo/reportFormAo";
	}
	
	 @RequestMapping(value = "/url",method = RequestMethod.POST)
	    public String getData(Model model,MultipartHttpServletRequest req){
	 
	        //get image file.
	        List<MultipartFile> multipartFileList = new ArrayList<>();
	        try{
	            MultiValueMap<String, MultipartFile> files = req.getMultiFileMap();
	            for (Map.Entry<String, List<MultipartFile>> entry : files.entrySet()) {
	                List<MultipartFile> fileList = entry.getValue();
	                for (MultipartFile file : fileList) {
	                    if (file.isEmpty()) continue;
	                    multipartFileList.add(file);
	                }
	            }
	 
	            if(multipartFileList.size()>0) {
	                for(MultipartFile file: multipartFileList) {
	                    file.transferTo(new File("파일 옮길 폴더경로 적기" + File.separator + file.getOriginalFilename()));
	                }
	            }
	            }catch (Exception e){
	            e.printStackTrace();
	            //logger.info(" has no multipartFile!");
	        }
	 
	 
	        model.addAttribute("log","사진 "+multipartFileList.size()+"장 전송완료!");
	        return "html템플릿 주소 :: #resultDiv";
	    }

	

}
