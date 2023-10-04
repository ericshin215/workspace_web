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
		
		
		return sqlSession.selectOne("users.selectAuthUser", userVo);
	}

	public void userInsert(UserVo userVo) {
		
		
		sqlSession.insert("users.insert", userVo);
		
	}

}
