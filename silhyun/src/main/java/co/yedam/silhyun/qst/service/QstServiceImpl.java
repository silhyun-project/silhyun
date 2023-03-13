package co.yedam.silhyun.qst.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.yedam.silhyun.common.map.CommentMapper;
import co.yedam.silhyun.qst.map.QstMapper;
import co.yedam.silhyun.qst.vo.QstVO;

@Service
public class QstServiceImpl implements QstService {

	@Autowired QstMapper mapper;
	@Autowired CommentMapper cmapper;
	
	@Override
	public List<QstVO> getAoQstList() {
		// TODO Auto-generated method stub
		return mapper.getAoQstList();
	}

	@Override
	public int aoQstInsert(QstVO vo) {
		// TODO Auto-generated method stub
		return mapper.aoQstInsert(vo);
	}

	@Override
	public int aoQstDelete(QstVO vo) {
		// TODO Auto-generated method stub
		return mapper.aoQstDelete(vo);
	}

}
