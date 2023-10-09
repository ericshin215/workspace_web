package com.javaex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.BlogDao;
import com.javaex.dao.UserDao;
import com.javaex.vo.BlogVo;
import com.javaex.vo.CategoryVo;
import com.javaex.vo.UserVo;

@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private BlogDao blogDao;

	public UserVo login(UserVo userVo) {
	
		
		UserVo authUser = userDao.userSelect(userVo);
		
		return authUser;
		
		
	}

	public void join(UserVo userVo) {
		
		System.out.println("UserService");
		userDao.userInsert(userVo);
		
		String id = userVo.getId();
		String name = userVo.getUserName();
		
			
		BlogVo blogVo = new BlogVo();
		blogVo.setId(id);
		blogVo.setBlogTitle(name+"의 블로그입니다.");
		blogVo.setLogoFile("spring-logo.jpg");	
		blogDao.blogInsert(blogVo);		
		
		
		
		
	}

}
