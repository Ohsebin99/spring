package com.tjoeun.meokjang;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class RepleController {
	
	private static final Logger logger = LoggerFactory.getLogger(RepleController.class);
	
	@Autowired
	private SqlSession sqlSession; 
	
	
}
