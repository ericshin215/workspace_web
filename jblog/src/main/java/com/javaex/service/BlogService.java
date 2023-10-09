package com.javaex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.BlogDao;
import com.javaex.dao.UserDao;
import com.javaex.vo.BlogVo;
import com.javaex.vo.UserVo;


@Service
public class BlogService {
	
	@Autowired
	public BlogDao blogDao;
	
	@Autowired
	public UserDao userDao;
	
	
	public void blogInsert(BlogVo blogVo) {
		
		blogDao.blogInsert(blogVo);
	}

	public BlogVo selectBlog(String id) {
		
		
		
		return blogDao.selectBlog(id);
	}


	public UserVo selectBlogHost(String id) {
		
		return userDao.selectBlogHost(id);
	}
	
	public void blogUpdate( BlogVo blogVo) {
		
		blogDao.blogUpdate(blogVo);
		
		
	}
	
	
	
	
	

	

}
