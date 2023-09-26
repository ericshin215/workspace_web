package com.javaex.service;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.javaex.dao.GalleryDao;

import com.javaex.vo.GalleryVo;

@Service
public class GalleryService {
	
	@Autowired
	private GalleryDao galleryDao;

	
	
	
	
	public List<GalleryVo> getGalleryList() {
		// TODO Auto-generated method stub

		List<GalleryVo> galleryList = galleryDao.gallerySelectList();

		return galleryList;

		
	}

	public void insertGallery(GalleryVo galleryVo) {
		// TODO Auto-generated method stub
		
		galleryDao.insertGallery(galleryVo);
		
	}
	
	public GalleryVo save(MultipartFile file, int user_no, String content, String name) {
		System.out.println("GalleryService.save()");
		System.out.println(file.getOriginalFilename());

		// 파일저장디렉토리
		String saveDir = "C:\\javaStudy\\upload";

		// (1)파일관련 정보 추출////////////////////////////////////////////////

		// 오리지널 파일명
		String orgName = file.getOriginalFilename();
		System.out.println(orgName);

		// 확장자
		String exName = orgName.substring(orgName.lastIndexOf("."));
		System.out.println(exName);

		// 저장파일명(겹치지 않아야한다)
		String saveName = System.currentTimeMillis() + UUID.randomUUID().toString() + exName;
		System.out.println(saveName);

		// 파일사이즈
		long fileSize = file.getSize();
		System.out.println(fileSize);

		// 파일전체경로
		String filePath = saveDir + "\\" + saveName;
		System.out.println(filePath);

		// vo로 묶기
		GalleryVo galleryVo = new GalleryVo(0,content,filePath, orgName, saveName,  fileSize, name, user_no);
		System.out.println(galleryVo);

		// Dao만들기 --> DB저장 과제 ㅇㅇ 잘묶었으니 insert만들면 된다는데
		System.out.println(galleryVo +"DB저장");
		galleryDao.insertGallery(galleryVo);

		// (2)파일저장(서버쪽 하드디스크에 저장)//////////////////////////
		// Stream 사용

		try {
			byte[] fileData;
			fileData = file.getBytes();

			OutputStream os = new FileOutputStream(filePath);
			BufferedOutputStream bos = new BufferedOutputStream(os);

			bos.write(fileData);
			bos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return galleryVo;

	}

}
