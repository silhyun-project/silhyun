package co.yedam.silhyun.common.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import co.yedam.silhyun.common.vo.PhotoVO;

public interface PhotoService {
	List<PhotoVO> photoList(PhotoVO vo);
	int photoInsert(List<MultipartFile> files, String ctgrNum, String ctgr);
	int photoDelete(PhotoVO vo);
}
