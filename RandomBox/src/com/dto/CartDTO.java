package com.dto;

public class CartDTO {
	private int num;
	private String userId;
	private String gCode;
	private String gName;
	private int gPrice;
	private String gImage;
	
	
	
	public CartDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CartDTO(int num, String userId, String gCode, String gName, int gPrice, String gImage) {
		super();
		this.num = num;
		this.userId = userId;
		this.gCode = gCode;
		this.gName = gName;
		this.gPrice = gPrice;
		this.gImage = gImage;
	}
	@Override
	public String toString() {
		return "CartDTO [num=" + num + ", userId=" + userId + ", gCode=" + gCode + ", gName=" + gName + ", gPrice="
				+ gPrice + ", gImage=" + gImage + "]";
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getgCode() {
		return gCode;
	}
	public void setgCode(String gCode) {
		this.gCode = gCode;
	}
	public String getgName() {
		return gName;
	}
	public void setgName(String gName) {
		this.gName = gName;
	}
	public int getgPrice() {
		return gPrice;
	}
	public void setgPrice(int gPrice) {
		this.gPrice = gPrice;
	}
	public String getgImage() {
		return gImage;
	}
	public void setgImage(String gImage) {
		this.gImage = gImage;
	}

}
