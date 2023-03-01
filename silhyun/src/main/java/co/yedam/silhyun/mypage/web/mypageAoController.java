package co.yedam.silhyun.mypage.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import co.yedam.silhyun.mypage.service.MypageAoService;

@Controller
public class mypageAoController {
	@Autowired
	private MypageAoService mypageAoService;
	
	@GetMapping(" /photo/mypageAo")
	public String mypageAo() {
		return "mypageAo/mypageAo";
	}
	
	@GetMapping("/modPfAo")
	public String modpfAo() {
			
			return "mypageAo/modPfAo";
		}
	@GetMapping("/resManage")
	public String resManage(Model model) {
	model.addAttribute("resList", mypageAoService.getReserList());
	
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
	/*
	@RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<?> uploadFile(
		    @RequestParam("uploadfile") MultipartFile uploadfile) {
		  
		  try {
		    // Get the filename and build the local file path (be sure that the 
		    // application have write permissions on such directory)
		    String filename = uploadfile.getOriginalFilename();
		    String directory = "C:\\saveImg";
		    String filepath = Paths.get(directory, filename).toString();
		    
		    // Save the file locally
		    BufferedOutputStream stream =
		        new BufferedOutputStream(new FileOutputStream(new File(filepath)));
		    stream.write(uploadfile.getBytes());
		    stream.close();
		  }
		  catch (Exception e) {
		    System.out.println(e.getMessage());
		    return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		  }
		  
		  return new ResponseEntity<>(HttpStatus.OK);
		} // method uploadFile
*/
}
