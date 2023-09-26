package com.javaex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.UserDao;
import com.javaex.vo.UserVo;


@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;
	
	
	//로그인
		public UserVo login(UserVo userVo) {
			System.out.println("UserService.login()");
			
			UserVo authUser = userDao.userSelect(userVo);
			
			return authUser;
		}
		
		//회원가입
		public int join(UserVo userVo) {
			System.out.println("UserService.join()");
			
			//회원가입 비지니스 로직
			//Dao를 통해서 데이터 저장
			int count = userDao.userInsert(userVo);
			
			return count;
		}
	

	
	public boolean idCheck(String id) {
		
		UserVo userVo = userDao.selectUserOneById(id);
		System.out.println(userVo);
		
		
		
		if(userVo == null) { //해당 id사용자 없음. 데이터 못가져와야됨
			return true;
		}else { //해당id 사용자가 있음, 데이터가져옴
			return false;
		}
		
		
	}

}
