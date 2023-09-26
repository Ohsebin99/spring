package com.tjoeun.dao;

import java.util.ArrayList;
import java.util.HashMap;

import com.tjoeun.vo.MvcBoardVO;

// 	mapper와 연결에 사용할 인터페이스
//	이 인터페이스의 풀 패키지와 이름을 mvcboard.xml 파일의 namespace에 정확히 적어야 한다.
public interface MyBatisDAO {
	
	void insert(MvcBoardVO mvcBoardVO);
	
	int selectCount();
	
	ArrayList<MvcBoardVO> selectList(HashMap<String, Integer> hmap);
	
	void increment(int idx);
	
	MvcBoardVO selectByIdx(int idx);
	
	void update(MvcBoardVO mvcBoardVO);
	
	void delete(int idx);
	
	void replyInsert(MvcBoardVO mvcBoardVO);
	
	void replyIncrement(HashMap<String, Integer> hmap);
}
