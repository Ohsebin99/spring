package com.tjoeun.vo;

import java.util.Date;

public class RepleVO {
	
	private int repleIdx;			// PK
	private int originIdx;			// 생성된 방의 글 번호, 외래키
	private String masterID;		// 방장 아이디, 외래키
	private String repleID;			// 참가자 아이디, 외래키
	private String reple;			// 댓글
	private Date writeDate;			// 작성 시간
	private String repleIp;			// 댓글IP
	private String fix = "N";		// 확정여부 
	
	private String repleNickName;	// 참여자 닉네임
	private String repleGender;		// 참여자 성별
	private int repleAge;			// 참여자 나이
	private int repleLimitNum;		// 참여자
	
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
