package co.yedam.silhyun.common.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import co.yedam.silhyun.common.service.CommentService;

@Controller
public class CommentController {

	@Autowired
	private CommentService commentService;
	
	@RequestMapping("/silhyun/commentReply")
	   public String commentReply(Model model) {
	      model.addAttribute("commentList", commentService.getCommentList());
	      
	      return "mypageUser/commentReply";
	   }
	
}
