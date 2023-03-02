package co.yedam.silhyun.common.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.yedam.silhyun.common.map.CommentMapper;
import co.yedam.silhyun.common.vo.CommentVO;

@Service
public class CommentServiceImpl implements CommentService{
	@Autowired CommentMapper mapper;
	
	@Override
	public List<CommentVO> getCommentList() {
		// TODO Auto-generated method stub
		return mapper.getCommentList();
	}

	@Override
	public List<CommentVO> getReplyList() {
		// TODO Auto-generated method stub
		return mapper.getReplyList();
	}

	@Override
	public int commentInsert(CommentVO vo) {
		// TODO Auto-generated method stub
		return mapper.commentInsert(vo);
	}

	@Override
	public int commentDelete(CommentVO vo) {
		// TODO Auto-generated method stub
		return mapper.commentDelete(vo);
	}

	@Override
	public int commentUpdate(CommentVO vo) {
		// TODO Auto-generated method stub
		return mapper.commentUpdate(vo);
	}

	@Override
	public int replyInsert(CommentVO vo) {
		// TODO Auto-generated method stub
		return mapper.replyInsert(vo);
	}

	@Override
	public int replyDelete(CommentVO vo) {
		// TODO Auto-generated method stub
		return mapper.replyDelete(vo);
	}

	@Override
	public int replyUpdate(CommentVO vo) {
		// TODO Auto-generated method stub
		return mapper.replyUpdate(vo);
	}
}
