package com.tjoeun.vo;

import java.util.Date;

public class RepleVO {
	
	private int repleIdx;			// PK
	private int originIdx;			// ������ ���� �� ��ȣ, �ܷ�Ű
	private String masterID;		// ���� ���̵�, �ܷ�Ű
	private String repleID;			// ������ ���̵�, �ܷ�Ű
	private String reple;			// ���
	private Date writeDate;			// �ۼ� �ð�
	private String repleIp;			// ���IP
	private String fix = "N";		// Ȯ������ 
	
	private String repleNickName;	// ������ �г���
	private String repleGender;		// ������ ����
	private int repleAge;			// ������ ����
	private int repleLimitNum;		// ������
	
	// getters & setters
	public int getRepleIdx() {
		return repleIdx;
	}
	public void setRepleIdx(int repleIdx) {
		this.repleIdx = repleIdx;
	}
	public int getOriginIdx() {
		return originIdx;
	}
	public void setOriginIdx(int originIdx) {
		this.originIdx = originIdx;
	}
	public String getMasterID() {
		return masterID;
	}
	public void setMasterID(String masterID) {
		this.masterID = masterID;
	}
	public String getRepleID() {
		return repleID;
	}
	public void setRepleID(String repleID) {
		this.repleID = repleID;
	}
	public String getReple() {
		return reple;
	}
	public void setReple(String reple) {
		this.reple = reple;
	}
	public Date getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}
	public String getRepleIp() {
		return repleIp;
	}
	public void setRepleIp(String repleIp) {
		this.repleIp = repleIp;
	}
	public String getFix() {
		return fix;
	}
	public void setFix(String fix) {
		this.fix = fix;
	}
	public String getRepleNickName() {
		return repleNickName;
	}
	public void setRepleNickName(String repleNickName) {
		this.repleNickName = repleNickName;
	}
	public String getRepleGender() {
		return repleGender;
	}
	public void setRepleGender(String repleGender) {
		this.repleGender = repleGender;
	}
	public int getRepleAge() {
		return repleAge;
	}
	public void setRepleAge(int repleAge) {
		this.repleAge = repleAge;
	}
	public int getRepleLimitNum() {
		return repleLimitNum;
	}
	public void setRepleLimitNum(int repleLimitNum) {
		this.repleLimitNum = repleLimitNum;
	}
	
	// toString
	@Override
	public String toString() {
		return "RepleVO [repleIdx=" + repleIdx + ", originIdx=" + originIdx + ", masterID=" + masterID + ", repleID="
				+ repleID + ", reple=" + reple + ", writeDate=" + writeDate + ", repleIp=" + repleIp + ", fix=" + fix
				+ ", repleNickName=" + repleNickName + ", repleGender=" + repleGender + ", repleAge=" + repleAge
				+ ", repleLimitNum=" + repleLimitNum + "]";
	}
}
