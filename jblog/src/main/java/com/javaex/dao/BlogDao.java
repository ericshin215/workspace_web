package com.javaex.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.BlogVo;

@Repository
public class BlogDao {

	@Autowired
	private SqlSession sqlSession;
	
	public BlogVo selectBlog(String id) {
		
		
		
		
		
		
		return sqlSession.selectOne("blog.selectBlog", id);
	}
	
	

	public void blogInsert(BlogVo blogVo) {
		
		sqlSession.insert("blogInsert", blogVo);
	}

	

	public void blogUpdate(BlogVo blogVo) {
		
		System.out.println(blogVo);
		sqlSession.update("blogUpdate", blogVo);
	}

	

}
