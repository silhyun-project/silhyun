package co.yedam.silhyun.classes.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.yedam.silhyun.classes.map.ClassesMapper;
import co.yedam.silhyun.classes.vo.InetClassesWtchVO;

@Service
public class ClassesServiceImpl implements ClassesService {

	@Autowired ClassesMapper ClassesMapper;
	@Override
	public List<Map<String, Object>> getClassIVInfo(String id, String Inum) {
			return ClassesMapper.getClassIVInfo(id, Inum);
}
	@Override
	public Map<String, Object> selectIV(String classNum, String inetNum, String id) {
		return ClassesMapper.selectIV(classNum, inetNum, id);
	}
	@Override
	public int insertWInfo(InetClassesWtchVO iWVo) {
		return ClassesMapper.insertWInfo(iWVo);
	}
}
