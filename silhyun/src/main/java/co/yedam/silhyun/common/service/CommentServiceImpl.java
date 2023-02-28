package co.yedam.silhyun.common.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import co.yedam.silhyun.common.map.CommentMapper;
import co.yedam.silhyun.common.vo.CommentVO;

public class CommentServiceImpl implements CommentService{

	@Autowired CommentMapper mapper;
	
	@Override
	public List<CommentVO> CommentList() {
		// TODO Auto-generated method stub
		return mapper.CommentList();
	}

}
