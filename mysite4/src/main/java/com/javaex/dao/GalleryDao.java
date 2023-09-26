package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.GalleryVo;

@Repository
public class GalleryDao {

	@Autowired
	private SqlSession sqlSession;

	public List<GalleryVo> gallerySelectList() {
		// TODO Auto-generated method stub

		List<GalleryVo> galleryList = sqlSession.selectList("gallery.selectList");

		return galleryList;
	}

	public void insertGallery(GalleryVo galleryVo) {
		// TODO Auto-generated method stub
		System.out.println(galleryVo);
		sqlSession.insert("gallery.insertGallery", galleryVo);
		
	}

}
