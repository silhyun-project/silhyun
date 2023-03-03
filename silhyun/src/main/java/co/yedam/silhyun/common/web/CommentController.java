package co.yedam.silhyun.common.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import co.yedam.silhyun.common.service.CommentService;
import co.yedam.silhyun.common.vo.CommentVO;

@Controller
public class CommentController {

	@Autowired
	private CommentService commentService;
	
	@RequestMapping("/silhyun/commentReply") ///silhyun/commentReply{ctgrNum}
	public String commentReply(Model model) {
		model.addAttribute("commentList", commentService.getCommentList());
		model.addAttribute("replyList", commentService.getReplyList());
		return "mypageUser/commentReply";
	   }
	
//	@RequestMapping("/commentList")
//	public String commentList(Model model) {
//		
//		return "mypageUser/commentReply";
//	}
	
	@GetMapping("/replyList")
	   public String replyList(Model model) {
	      
	      return "mypageUser/commentReply";
	   }
//	
	@PostMapping("/commentInsert")
	@ResponseBody
	public String commentInsert(@RequestBody CommentVO vo) {
		vo.setCntn("M");
		vo.setComNum("1");
		commentService.commentInsert(vo);
		
		return "seccess";
	}
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
