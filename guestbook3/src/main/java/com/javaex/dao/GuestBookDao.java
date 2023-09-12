package com.javaex.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.javaex.vo.GuestBookVo;



public class GuestBookDao {

	// 필드
	// 0. import java.sql.*;
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String id = "webdb";
	private String pw = "webdb";

	// 생성자
	public GuestBookDao() {
	}

	// 메소드 gs

	// 메소드 일반
	private void getConnect() {

		try {
			// 1. JDBC 드라이버 (Oracle) 로딩
			Class.forName(driver);

			// 2. Connection 얻어오기
			conn = DriverManager.getConnection(url, id, pw);

		} catch (ClassNotFoundException e) {
			System.out.println("error: 드라이버 로딩 실패 - " + e);
		} catch (SQLException e) {
			System.out.println("error:" + e);
		}

	}

	private void close() {
		// 5. 자원정리
		try {
			if (rs != null) {
				rs.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			System.out.println("error:" + e);
		}
	}

	// 사람등록
	public int guestbookInsert(GuestBookVo guestbookVo) { //Vo로 받았음
		int count = -1;

		this.getConnect();
		System.out.println(guestbookVo);

		try {
			// 3. SQL문 준비 / 바인딩 / 실행
			// SQL문 준비
			String query = "";
			query += " insert into guestbook ";
			query += " values(seq_no.nextval, ?, ?, ?, sysdate) ";

			pstmt = conn.prepareStatement(query);

			// 바인딩 vo에서 값을 setter로 꺼낸다
			pstmt.setString(1, guestbookVo.getName());
			pstmt.setString(2, guestbookVo.getPassword());
			pstmt.setString(3, guestbookVo.getContent());

			// 실행
			count = pstmt.executeUpdate();

			// 4.결과처리
			// System.out.println(count + "건 등록되었습니다.");

		} catch (SQLException e) {
			System.out.println("error:" + e);
		}

		this.close();

		return count;
	}

	// 사람삭제
	public int guestbookDelete(int gbId) {

		int count = -1;

		this.getConnect();

		try {
			// 3. SQL문 준비 / 바인딩 / 실행
			// SQL문 준비
			String query = "";
			query += " delete from guestbook ";
			query += " where no = ? ";

			pstmt = conn.prepareStatement(query);

			// 바인딩
			pstmt.setInt(1, gbId);

			// 실행
			count = pstmt.executeUpdate();

			// 4.결과처리
			// System.out.println(count + "건 등록되었습니다.");

		} catch (SQLException e) {
			System.out.println("error:" + e);
		}

		this.close();

		return count;

	}


		
	//수정
	

	
	// 사람리스트  personSelect(String keyword) 로 통합
	/*
	public List<PersonVo> personSelect() {

		List<PersonVo> personList = new ArrayList<PersonVo>();

		this.getConnect();

		try {
			// 3. SQL문 준비 / 바인딩 / 실행
			// SQL문 준비
			String query = "";
			query += " select  person_id, ";
			query += "         name, ";
			query += "         hp, ";
			query += "         company ";
			query += " from person ";

			pstmt = conn.prepareStatement(query);

			// 바인딩

			// 실행
			rs = pstmt.executeQuery();

			// 4.결과처리
			while (rs.next()) {

				int personId = rs.getInt(1);
				String name = rs.getString(2);
				String hp = rs.getString(3);
				String company = rs.getString(4);

				PersonVo personVo = new PersonVo(personId, name, hp, company);

				personList.add(personVo);

			}

		} catch (SQLException e) {
			System.out.println("error:" + e);
		}

		this.close();

		return personList;

	}
	*/
	
	public List<GuestBookVo> guestbookSelect() {

		List<GuestBookVo> guestbookList = new ArrayList<GuestBookVo>();

		this.getConnect();

		try {
			// 3. SQL문 준비 / 바인딩 / 실행
			// SQL문 준비
			String query = "";
			query += " select  no, ";
			query += "         name, ";
			query += "         password, ";
			query += "         content, ";
			query += "         reg_date ";
			query += " from guestbook ";
			
			pstmt = conn.prepareStatement(query);
		
			rs = pstmt.executeQuery();

			// 4.결과처리
			while (rs.next()) {

				int no = rs.getInt(1);
				String name = rs.getString(2);
				String password = rs.getString(3);
				String content = rs.getString(4);
				String date = rs.getString(5);

				GuestBookVo guestbookVo = new GuestBookVo(no, name, password, content, date);

				guestbookList.add(guestbookVo);

			}

		} catch (SQLException e) {
			System.out.println("error:" + e);
		}

		this.close();

		return guestbookList;

	}
	
	
	// 1명 데이터 가져오기
	/*public PersonVo personSelectOne(int personId) {

		//List<PersonVo> personList = new ArrayList<PersonVo>();
		PersonVo personVo = null;
		this.getConnect();

		try {
			// 3. SQL문 준비 / 바인딩 / 실행
			// SQL문 준비
			String query = "";
			query += " select  person_id, ";
			query += "         name, ";
			query += "         hp, ";
			query += "         company ";
			query += " from person ";
			query += " where person_id = ? ";
			
			pstmt = conn.prepareStatement(query);

			// 바인딩**********************************************************************
			pstmt.setInt(1, personId);		// 실행
			rs = pstmt.executeQuery();
			rs.next();
			personId = rs.getInt(1);
			String name = rs.getString(2);
			String hp = rs.getString(3);
			String company = rs.getString(4);
			
			personVo = new PersonVo(personId, name, hp, company);
			// 4.결과처리
			
		} catch (SQLException e) {
			System.out.println("error:" + e);
		}

		this.close();

		return personVo;

	}
	*/
}