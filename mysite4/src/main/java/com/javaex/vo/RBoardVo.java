package com.javaex.vo;

public class RBoardVo {
	
	
	private int no;
	private String title;
	private String content;
	private int hit;
	private String reg_date;
	private int userNo;
	private int group_no;
	private int order_no;
	private int depth;
	private String name;
	
	
	
	public RBoardVo() {
		
	}
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public RBoardVo(int no, String title, String content, int hit, String reg_date, int userNo, int group_no,
			int order_no, int depth, String name) {
		
		super();
		this.no = no;
		this.title = title;
		this.content = content;
		this.hit = hit;
		this.reg_date = reg_date;
		this.userNo = userNo;
		this.group_no = group_no;
		this.order_no = order_no;
		this.depth = depth;
		this.name = name;
		
	}




	public int getNo() {
		return no;
	}


	public void setNo(int no) {
		this.no = no;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}




	public String getContent() {
		return content;
	}




	public void setContent(String content) {
		this.content = content;
	}




	public int getHit() {
		return hit;
	}




	public void setHit(int hit) {
		this.hit = hit;
	}




	public String getReg_date() {
		return reg_date;
	}




	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}




	public int getUserNo() {
		return userNo;
	}




	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}




	public int getGroup_no() {
		return group_no;
	}




	public void setGroup_no(int group_no) {
		this.group_no = group_no;
	}




	public int getOrder_no() {
		return order_no;
	}




	public void setOrder_no(int order_no) {
		this.order_no = order_no;
	}




	public int getDepth() {
		return depth;
	}




	public void setDepth(int depth) {
		this.depth = depth;
	}




	@Override
	public String toString() {
		return "RBoardVo [no=" + no + ", title=" + title + ", content=" + content + ", hit=" + hit + ", reg_date="
				+ reg_date + ", userNo=" + userNo + ", group_no=" + group_no + ", order_no=" + order_no + ", depth="
				+ depth + ", name=" + name + "]";
	}
	
	
	

}
