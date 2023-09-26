package com.tjoeun.dao;

import java.util.ArrayList;
import java.util.HashMap;

import com.tjoeun.vo.Param;
import com.tjoeun.vo.PartyVO;

public interface PartyDAO {

	int selectCount();
	int selectCountMulti(Param param);

	ArrayList<PartyVO> selectList(HashMap<String, Integer> hmap);
	ArrayList<PartyVO> selectListMulti(Param param);

	ArrayList<PartyVO> selectSlider();
	PartyVO selectByIdx(int idx);



}
