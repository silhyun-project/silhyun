package co.yedam.silhyun.common.service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import co.yedam.silhyun.common.map.PhotoMapper;
import co.yedam.silhyun.common.vo.PhotoVO;

@Service
public class PhotoServiceImpl implements PhotoService {
	
	@Autowired PhotoMapper map;
	
	//실 경로를 가져오기 위해 사용함
	@Autowired ServletContext servletContext; 

	@Value("${silhyun.saveimg}")
	private String saveimg;
	
	@Override
	public List<PhotoVO> photoList(PhotoVO vo) {
		
		return map.photoList(vo);
	}

	@Override
	public int photoInsert(List<MultipartFile> files, String ctgrNum, String ctgr) {
		int n = 0;
		String saveImgPath = saveimg + "review";
		if(files != null && !files.isEmpty()) {
			for(MultipartFile file : files) {
				String fileName = UUID.randomUUID().toString(); //UUID생성 
				fileName = fileName + "_" + file.getOriginalFilename(); //유니크한 아이디
				File uploadFile = new File(saveImgPath, fileName); 
				
				try {
					file.transferTo(uploadFile); //파일저장
				} catch (IllegalStateException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				PhotoVO vo = new PhotoVO();
				vo.setCtgr(ctgr);
				vo.setCtgrNum(ctgrNum);
				vo.setPhoRt("/saveImg/review/" + fileName);
				
				n = map.photoInsert(vo);
			}
		}
		return n;
	}

	@Override
	public int photoDelete(PhotoVO vo) {
		
		return map.photoDelete(vo);
	}

}
