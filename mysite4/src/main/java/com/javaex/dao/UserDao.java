package com.javaex.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.UserVo;

@Repository
public class UserDao {


	@Autowired
	private SqlSession sqlSession;



	public UserVo userSelect(UserVo userVo) {
		
		return sqlSession.selectOne("user.selectAuthUser", userVo);
	}

	
	public void userInsert(UserVo userVo) {
		
		sqlSession.insert("user.insert", userVo);
	}

	
	
	
	public UserVo userSelect2(UserVo userVo) {
		
		return sqlSession.selectOne("user.select2", userVo);
		
	}


	public void userUpdate(UserVo userVo) {
		
		sqlSession.update("user.update", userVo);
		
	}	
	
}