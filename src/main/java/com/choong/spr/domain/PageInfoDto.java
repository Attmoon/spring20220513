package com.choong.spr.domain;

public class PageInfoDto {
	private int current;
	private int end;
	private int amount;
	private String keyword;
	
	public int getAmount() {
		return amount;
	}
	
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	public void setCurrent(int current) {
		this.current = current;
	}
	
	public int getCurrent() {
		return current;
	}
	
	public int getLeft() {
		return Math.max(current - 3, 1);
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
	
	@Override
	public String toString() {
		return "[pageNum =" + current + ", amount=" + amount + "]";
	}
	
}
