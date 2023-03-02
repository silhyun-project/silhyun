package co.yedam.silhyun.common.map;

import java.util.List;

import co.yedam.silhyun.common.vo.CommentVO;


public interface CommentMapper {

	List<CommentVO> getCommentList(); // 댓글 리스트
}
