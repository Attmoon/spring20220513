package com.choong.spr.domain;

public class PageInfoDto {
	private int current;
	private int end;
	private String keyword;
	private String searchType;
	
	public String getSearchType() {
		return searchType;
	}
	
	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}
	
	
	public void setCurrent(int current) {
		this.current = current;
	}
	
	public int getCurrent() {
		return current;
	}
	
	public int getLeft() {
		return Math.min(current, 1);
	}
	
	public int getRight() {
		return Math.min(current + 3, end);
	}
	
	public void setEnd(int end) {
		this.end = end;
	}
	
	public int getEnd() {
		return end;
	}
	
	public String getKeyword() {
		return keyword;
	}
	
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
	
}
