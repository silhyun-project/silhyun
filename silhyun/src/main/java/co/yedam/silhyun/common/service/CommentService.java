package co.yedam.silhyun.common.service;

import java.util.List;

import co.yedam.silhyun.common.vo.CommentVO;


public interface CommentService {
	List<CommentVO> getCommentList(); // 댓글 리스트
	
	int commentInsert(CommentVO vo); // 댓글 입력
	
	int commentDelete(CommentVO vo); // 댓글 삭제
	
	int commentUpdate(CommentVO vo); // 댓글 수정
	
	int replyInsert(CommentVO vo); // 대댓글 입력
	
	int replyDelete(CommentVO vo); // 대댓글 삭제
	
	int replyUpdate(CommentVO vo); // 대댓글 수정
}
