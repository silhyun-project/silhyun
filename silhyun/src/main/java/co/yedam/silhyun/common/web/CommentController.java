package co.yedam.silhyun.common.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
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
	
	@RequestMapping("/silhyun/commentReply") ///댓글창 이동 silhyun/commentReply{ctgrNum}
	public String commentReply(Model model) {
		model.addAttribute("commentList", commentService.getCommentList());
		return "mypageUser/commentReply";
	   }
	
	@GetMapping("/commentList")
	@ResponseBody
	public List<CommentVO> commentList(CommentVO vo, Model model) {
		List<CommentVO> comList = commentService.getCommentList();
		return comList;
	}
	
	@PostMapping("/commentInsert")
	@ResponseBody
	public String commentInsert(@RequestBody CommentVO vo) {
//		vo.setCntn("M");
//		vo.setComNum("1");
		commentService.commentInsert(vo);
		
		return "seccess";
	}	
	
	@DeleteMapping("/commentDelete")
	@ResponseBody
	public String commentDelete(CommentVO vo) {
		
		commentService.commentDelete(vo);
		return "mypageUser/commentReply";
	}
	
	@DeleteMapping("/replyDelete")
	public String replyDelete(CommentVO vo) {
		
		commentService.replyDelete(vo);
		return "mypageUser/commentReply";
	}
	
//	@PostMapping("/commentUpdate")
//	public String commentUpdate(CommentVO vo) {
//	
//	
//		return "mypageUser/commentReply";
//	}
	
}
