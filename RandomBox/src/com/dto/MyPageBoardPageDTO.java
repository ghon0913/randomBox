package com.dto;

import java.util.List;

public class MyPageBoardPageDTO {
	private List<BoardDTO> list;// 전체데이터

	private int curPage;// 현재페이지

	private int totalCount;// 전체페이지

	private static int perPage = 3;// 보여줄행 개수

	private String searchName;
	private String searchValue;
	private int perBlock = 5; // 페이지 당 보여줄 페이지 번호 갯수

	
	public int getPerBlock() {
		return perBlock;
	}
	public void setPerBlock(int perBlock) {
		this.perBlock = perBlock;
	}
	public String getSearchName() {
		return searchName;
	}
	public void setSearchName(String searchName) {
		this.searchName = searchName;
	}
	public String getSearchValue() {
		return searchValue;
	}
	public void setSearchValue(String searchValue) {
		this.searchValue = searchValue;
	}
	public List<BoardDTO> getList() {
		return list;
	}
	public void setList(List<BoardDTO> list) {
		this.list = list;
	}
	public int getCurPage() {
		return curPage;
	}
	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public static int getPerPage() { //STATIC으로 하면 PERSERVLET에서 예외사라짐
		return perPage;
	}
	public static void setPerPage(int perPage) {
		MyPageBoardPageDTO.perPage = perPage;
	}
}
