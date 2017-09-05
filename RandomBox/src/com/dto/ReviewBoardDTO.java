package com.dto;

public class ReviewBoardDTO {
	private int num;
	private String category;
	private String title;
	private String content;
	private String writeDay;
	private int readCnt;
	private String userId;
	
	
	
	
	public ReviewBoardDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ReviewBoardDTO(int num, String category, String title, String content, String writeDay, int readCnt,
			String userId) {
		super();
		this.num = num;
		this.category = category;
		this.title = title;
		this.content = content;
		this.writeDay = writeDay;
		this.readCnt = readCnt;
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "ReviewBoardDTO [num=" + num + ", category=" + category + ", title=" + title + ", content=" + content
				+ ", writeDay=" + writeDay + ", readCnt=" + readCnt + ", userId=" + userId + ", getNum()=" + getNum()
				+ ", getCategory()=" + getCategory() + ", getTitle()=" + getTitle() + ", getContent()=" + getContent()
				+ ", getWriteDay()=" + getWriteDay() + ", getReadCnt()=" + getReadCnt() + ", getUserId()=" + getUserId()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
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
	public String getWriteDay() {
		return writeDay;
	}
	public void setWriteDay(String writeDay) {
		this.writeDay = writeDay;
	}
	public int getReadCnt() {
		return readCnt;
	}
	public void setReadCnt(int readCnt) {
		this.readCnt = readCnt;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}

}
