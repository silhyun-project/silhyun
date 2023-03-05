package co.yedam.silhyun.classes.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.yedam.silhyun.classes.map.ClassesMapper;

@Service
public class ClassesServiceImpl implements ClassesService {

	@Autowired ClassesMapper ClassesMapper;
	@Override
	public List<Map<String, Object>> getClassIVInfo(String id, String Inum) {
			return ClassesMapper.getClassIVInfo(id, Inum);
}
}
