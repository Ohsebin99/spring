package com.tjoeun.vo;

import java.util.Date;

public class PartyVO {
	
	private int idx; 				// �� ��ȣ
	private String ID;		 	  	// �ۼ��� ���̵�
	private String nickName;  	  	// �г���
	private String category;  	 	// ī�װ�
	private String location; 	   	// ����
	private String subject;   		// ��Ƽ��
	private String content;   	 	// �� ����
	private String place;      	 	// �Ļ� ���
	private String partyGender; 	// ���� ( �� �� �� )
	private Date mealDate;    		// ���� ��¥
	private Date limitDate;  		// ���� ����
	private Date writeDate;   		// �ۼ� ��¥
	private String photo;   	    // ���� ����
	private String acholchk;		// ���� ����
	private String ip;          	// ������ �ּ�
	private int minLimitAge = 18;	// ��������
	private int maxLimitAge = 100;	// ��������
	private int limitNum = 2;		// �ο�����
	private String show = "Y";		// �ð� ������ ��
	private int deleteReport = 0; 	// �Ű� Ƚ��
	
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
