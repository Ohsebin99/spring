package com.tjoeun.vo;

import java.util.ArrayList;

public class RepleList {
	
	ArrayList<RepleVO> list = new ArrayList<RepleVO>();
	
	// getters & setters
	public ArrayList<RepleVO> getList() {
		return list;
	}

	public void setList(ArrayList<RepleVO> list) {
		this.list = list;
	}
	
	// toString
	@Override
	public String toString() {
		return "RepleList [list=" + list + "]";
	}
}
