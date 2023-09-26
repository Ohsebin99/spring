package com.tjoeun.vo;

import java.util.Date;

public class PartyVO {
	
	private int idx; 				// 글 번호
	private String ID;		 	  	// 작성자 아이디
	private String nickName;  	  	// 닉네임
	private String category;  	 	// 카테고리
	private String location; 	   	// 지역
	private String subject;   		// 파티명
	private String content;   	 	// 글 내용
	private String place;      	 	// 식사 장소
	private String partyGender; 	// 성별 ( 남 여 무 )
	private Date mealDate;    		// 모임 날짜
	private Date limitDate;  		// 모집 마감
	private Date writeDate;   		// 작성 날짜
	private String photo;   	    // 메인 사진
	private String acholchk;		// 음주 여부
	private String ip;          	// 아이피 주소
	private int minLimitAge = 18;	// 나이제한
	private int maxLimitAge = 100;	// 나이제한
	private int limitNum = 2;		// 인원제한
	private String show = "Y";		// 시간 지났을 때
	private int deleteReport = 0; 	// 신고 횟수
	
	// getters & setters
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getPartyGender() {
		return partyGender;
	}
	public void setPartyGender(String partyGender) {
		this.partyGender = partyGender;
	}
	public Date getMealDate() {
		return mealDate;
	}
	public void setMealDate(Date mealDate) {
		this.mealDate = mealDate;
	}
	public Date getLimitDate() {
		return limitDate;
	}
	public void setLimitDate(Date limitDate) {
		this.limitDate = limitDate;
	}
	public Date getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getAcholchk() {
		return acholchk;
	}
	public void setAcholchk(String acholchk) {
		this.acholchk = acholchk;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
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
	public int getLimitNum() {
		return limitNum;
	}
	public void setLimitNum(int limitNum) {
		this.limitNum = limitNum;
	}
	public String getShow() {
		return show;
	}
	public void setShow(String show) {
		this.show = show;
	}
	public int getDeleteReport() {
		return deleteReport;
	}
	public void setDeleteReport(int deleteReport) {
		this.deleteReport = deleteReport;
	}
	
	// toString
	@Override
	public String toString() {
		return "PartyVO [idx=" + idx + ", ID=" + ID + ", nickName=" + nickName + ", category=" + category
				+ ", location=" + location + ", subject=" + subject + ", content=" + content + ", place=" + place
				+ ", partyGender=" + partyGender + ", mealDate=" + mealDate + ", limitDate=" + limitDate
				+ ", writeDate=" + writeDate + ", photo=" + photo + ", acholchk=" + acholchk + ", ip=" + ip
				+ ", minLimitAge=" + minLimitAge + ", maxLimitAge=" + maxLimitAge + ", limitNum=" + limitNum + ", show="
				+ show + ", deleteReport=" + deleteReport + "]";
	}
}
