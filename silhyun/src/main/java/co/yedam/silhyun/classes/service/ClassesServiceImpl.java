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

	private static final String String = null;
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
	public List<Map<String, Object>> getFC1List() {
		return ClassesMapper.getFC1List();
	}

	@Override
	public List<Map<String, Object>> getFC2List() {
		return ClassesMapper.getFC2List();
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
	public Map<java.lang.String, Object> CPlusInfo(java.lang.String classNum, java.lang.String id) {
				return ClassesMapper.CPlusInfo(classNum, id);
	}
	@Override
	public List<Map<java.lang.String, Object>> randomCList() {
		return ClassesMapper.randomCList();
	}

}
