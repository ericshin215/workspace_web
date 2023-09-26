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

	
	public int userInsert(UserVo userVo) {
		
		return sqlSession.insert("user.insert", userVo);
	}

	
	
	
	public UserVo userSelect2(UserVo userVo) {
		
		return sqlSession.selectOne("user.select2", userVo);
		
	}


	public void userUpdate(UserVo userVo) {
		
		sqlSession.update("user.update", userVo);
		
	}	
	
	//id 체크
	public UserVo selectUserOneById(String id) {
		
		UserVo userVo = sqlSession.selectOne("user.selectUserOneById", id);
		System.out.println(userVo);
		return userVo;
		
	}
	
}