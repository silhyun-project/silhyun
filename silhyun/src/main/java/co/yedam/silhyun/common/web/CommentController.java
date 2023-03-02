package co.yedam.silhyun.common.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import co.yedam.silhyun.common.service.CommentService;
import co.yedam.silhyun.common.vo.CommentVO;

@Controller
public class CommentController {

	@Autowired
	private CommentService commentService;
	
	@GetMapping("/silhyun/commentReply")
	public String commentReply() {
	      
		return "mypageUser/commentReply";
	   }
	
	@GetMapping("/commentList")
	public String commentList(Model model) {
		model.addAttribute("commentList", commentService.getCommentList());
		
		return "mypageUser/commentReply";
	}
	
//	@GetMapping("/replyList")
//	   public String replyList(Model model) {
//	      model.addAttribute("replyList", commentService.getReplyList());
//	      
//	      return "mypageUser/commentReply";
//	   }
//	
//	@PostMapping("/commentInsert")
//	public String commentInsert(CommentVO vo) {
//		
//		
//		return "mypageUser/commentReply";
//	}
//	
//	@PostMapping("/commentDelete")
//	public String commentDelete(CommentVO vo) {
//		
//		
//		return "mypageUser/commentReply";
//	}
//	@PostMapping("/commentUpdate")
//	public String commentUpdate(CommentVO vo) {
//	
//	
//		return "mypageUser/commentReply";
//	}
//	@PostMapping("/replyInsert")
//	public String replyInsert(CommentVO vo) {
//	
//		return "mypageUser/commentReply";
//	}
//	
}
