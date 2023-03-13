package co.yedam.silhyun.common.service;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
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
import net.coobird.thumbnailator.Thumbnailator;
import net.coobird.thumbnailator.Thumbnails;

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
					
					//섬네일 처리(이미지만 들어오니까 이미지 타입 체크는 생락
					Thumbnails.of(uploadFile)
							  .size(170, 170)
							  .toFile(new File(saveImgPath, "s_"+fileName));
					
					
				} catch (IllegalStateException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				PhotoVO vo = new PhotoVO();
				vo.setCtgr(ctgr);
				vo.setCtgrNum(ctgrNum);

				if(vo.getCtgr().equals("R")) {
					vo.setPhoRt("/saveImg/review/" + fileName);
					vo.setThumbnail("/saveImg/review/"+"s_" + fileName);
				}else if(vo.getCtgr().equals("P")){
					vo.setPhoRt("/saveImg/portfolio/" + fileName);
					vo.setThumbnail("/saveImg/portfolio/"+"s_" + fileName);
				}
				
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
