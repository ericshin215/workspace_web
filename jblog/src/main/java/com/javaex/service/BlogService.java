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
	

	public BlogVo selectBlog(String id) {
		// TODO Auto-generated method stub
		
		
		return blogDao.selectBlog(id);
	}


	public UserVo selectBlogHost(String id) {
		// TODO Auto-generated method stub
		return userDao.selectBlogHost(id);
	}
	
	
	
	
	
	

	

}
