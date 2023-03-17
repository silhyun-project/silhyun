package co.yedam.silhyun.classes.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.yedam.silhyun.classes.map.ClassesMapper;
import co.yedam.silhyun.classes.vo.ClassesVO;
import co.yedam.silhyun.classes.vo.InetClassesWtchVO;
import co.yedam.silhyun.common.vo.ZzimVO;
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
		System.out.println("서비스임플 확인용 selectTV"+classNum+' '+inetNum+' '+id);
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
	public Map<String, Object> CPlusInfo(String classNum) {
				return ClassesMapper.CPlusInfo(classNum);
	}
	
	@Override
	public Map<String, Object> CMPlusInfo(String classNum, String id) {
		return ClassesMapper.CMPlusInfo(classNum, id);
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
	@Override
	public Map<String, Object> myC1Ajax(String classNum) {
		return ClassesMapper.myC1Ajax(classNum);
	}

	@Override  //찜 확인
	public boolean cIsZzim(ZzimVO vo) {
		int count = ClassesMapper.cFindZzim(vo);
		return count > 0;
	}
	@Override  //찜 추가
	public void cInsertZzim(ZzimVO vo) {
		ClassesMapper.cInsertZzim(vo);
	}
	@Override //찜 삭제
	public void cDelZzim(ZzimVO vo) {
		ClassesMapper.cDelZzim(vo);
	}

}
