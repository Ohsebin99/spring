package com.tjoeun.vo;

public class Param {
	
	private int startNo;
	private int endNo;
	private int minLimitAge = 19;
	private int maxLimitAge = 80;
	private String condition;
	private String item;
	private String location;
	private String acholchk;
	private String partyGender;
	private String category;
	// getters & setters 
	public int getStartNo() {
		return startNo;
	}
	public void setStartNo(int startNo) {
		this.startNo = startNo;
	}
	public int getEndNo() {
		return endNo;
	}
	public void setEndNo(int endNo) {
		this.endNo = endNo;
	}
	public int getMinLimitAge() {
		return minLimitAge;
	}
	public void setMinLimitAge(int minLimitAge) {
		this.minLimitAge = minLimitAge;
	}
	public int getMaxLimitAge() {
		return maxLimitAge;
	}
	public void setMaxLimitAge(int maxLimitAge) {
		this.maxLimitAge = maxLimitAge;
	}
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getAcholchk() {
		return acholchk;
	}
	public void setAcholchk(String acholchk) {
		this.acholchk = acholchk;
	}
	public String getPartyGender() {
		return partyGender;
	}
	public void setPartyGender(String partyGender) {
		this.partyGender = partyGender;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	// toString
	@Override
	public String toString() {
		return "Param [startNo=" + startNo + ", endNo=" + endNo + ", minLimitAge=" + minLimitAge + ", maxLimitAge="
				+ maxLimitAge + ", condition=" + condition + ", item=" + item + ", location=" + location + ", acholchk="
				+ acholchk + ", partyGender=" + partyGender + ", category=" + category + "]";
	}
	
	
	
}
