package co.yedam.silhyun.classes.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.yedam.silhyun.classes.map.ClassesMapper;
import co.yedam.silhyun.classes.vo.ClassesVO;
import co.yedam.silhyun.classes.vo.InetClassesWtchVO;
import javassist.ClassMap;

@Service
public class ClassesServiceImpl implements ClassesService {


	@Autowired ClassesMapper ClassesMapper;
	@Override
	public List<Map<String, Object>> getClassIVInfo(String id, String classNum) {
			return ClassesMapper.getClassIVInfo(id, classNum);
}
	@Override
	public Map<String, Object> selectIV(String classNum, String inetNum, String id) {
		return ClassesMapper.selectIV(classNum, inetNum, id);
	}
	@Override
	public int insertWInfo(InetClassesWtchVO vo) {
		return ClassesMapper.insertWInfo(vo);
	}
	
	@Override
	public List<Map<String, Object>> getC1List() {
		return ClassesMapper.getC1List();
	}

	@Override
	public List<Map<String, Object>> getC2List() {
		return ClassesMapper.getC2List();
	}

	@Override
	public List<Map<String, Object>> getFCList() {
		return ClassesMapper.getFCList();
	}
	
	@Override
	public List<Map<String, Object>> cdtC1List(int param1) {
		return ClassesMapper.cdtC1List(param1);
	}

	@Override
	public List<Map<String, Object>> cdtC2List(int param1) {
		return ClassesMapper.cdtC2List(param1);
	}
	@Override
	public ClassesVO selectClass(java.lang.String classNum) {
				return ClassesMapper.selectClass(classNum);
	}
	@Override
	public Map<String, Object> CPlusInfo(java.lang.String classNum, java.lang.String id) {
				return ClassesMapper.CPlusInfo(classNum, id);
	}
	@Override
	public List<Map<String, Object>> randomList(String classNum) {
				return ClassesMapper.randomList(classNum);
	}
	@Override
	public String getName(String id) {
			return ClassesMapper.getName(id);
	}
	@Override
	public List<Map<String, Object>> myTakeC1(String id) {
			return ClassesMapper.myTakeC1(id);
	}
	@Override
	public List<Map<String, Object>> myTakeC2(String id) {
			return ClassesMapper.myTakeC2(id);
	}
	@Override
	public List<Map<String, Object>> getBCList() {
		return ClassesMapper.getBCList();
	}


}
