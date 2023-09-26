package com.tjoeun.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;

import com.tjoeun.springWEB_DBCP_board.HomeController;
import com.tjoeun.vo.MvcBoardVO;

public class MvcBoardDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	private JdbcTemplate template;
	
	private DataSource dataSource;
	
	public MvcBoardDAO() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:/comp/env/jdbc/oracle");
			logger.info("연결 성공!!!");
		} catch (NamingException e) {
		//	e.printStackTrace();
			logger.info("연결 실패!!!");
		}
	}
	
	public void insert(final MvcBoardVO mvcBoardVO) {
		
		logger.info("MvcBoardDAO 클래스의 insert() 메소드 실행");
		
		String sql = "insert into mvcboard (idx, name, subject, content, gup, lev, seq) " +
				 "values (mvcboard_idx_seq.nextval, ?, ?, ?, mvcboard_idx_seq.currval, 0, 0)";
		
		// update(): 테이블의 내용이 갱신되는 sql 명령 실행 => insert, delete, update
		// query(): 테이블의 내용이 갱신되지 않는 sql 명령 => select => 결과가 여러건일 경우
		// queryForInt(): 테이블의 내용이 갱신되지 않는 sql 명령 => select => 결과가 정수일 경우
		// queryForObjectr(): 테이블의 내용이 갱신되지 않는 sql 명령 => select => 결과가 1건일 경우
		
		// update(sql 명령 "?"를 채운다)
		// update() 메소드의 2번째 인수로 PreparedStatementSetter 인터페이스 객체를 익명으로 구현해서
		// Override된 setValues() 메소드에서 실행할 sql 명령의 "?"를 채운다.
		template.update(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				pstmt.setString(1, mvcBoardVO.getName());
				pstmt.setString(2, mvcBoardVO.getSubject());
				pstmt.setString(3, mvcBoardVO.getContent());
			}
		});
		
	}
  public int selectCount() {
     logger.info("MvcBoardDAO 클래스의 selectCount() 매소드 실행");
     
       
     	String sql = "select count(*) from mvcboard";
     	// return template.queryForInt(sql);
     	return template.queryForObject(sql, Integer.class);
  }

public ArrayList<MvcBoardVO> selectList(HashMap<String, Integer> hmap) {
	logger.info("MvcBoardDAO 클래스의 selectList() 매소드 실행");
    
	
	String sql = "select * from (" +
			"    select rownum rnum, AA.* from(" +
			"        select * from mvcboard order by gup desc, seq asc" +
			"    ) AA where rownum <= ?" +
			") where rnum >= ?";
	return (ArrayList<MvcBoardVO>) template.query(sql, new BeanPropertyRowMapper());
}

public void increment(final int idx) {
	logger.info("MvcBoardDAO 클래스의 selectCount() 매소드 실행");
    
	String sql = "update mvcboard set hit = hit + 1 where idx = " + idx;
	template.update(sql);
}

public MvcBoardVO selectByIdx(int idx) {
	logger.info("MvcBoardDAO 클래스의 selectCount() 매소드 실행");
    
	
	String sql = "select * from mvcboard where idx = ?";
	return template.queryForObject(sql, new BeanPropertyRowMapper(MvcBoardVO.class));
}

public void update(int idx, String subject, String content) {
	
	String sql = "update mvcboard set subject = '" + subject + "', content = '" + content +
				"' where idx = " + idx;
	template.update(sql);
}

public void update(final MvcBoardVO mvcBoardVO) {
	String sql = "update mvcboard set subject = ?, content = ? where idx = ?";
	template.update(sql, new PreparedStatementSetter() {

		@Override
		public void setValues(PreparedStatement pstmt) throws SQLException {
			pstmt.setString(1, mvcBoardVO.getSubject());
	    	pstmt.setString(2, mvcBoardVO.getContent());
	    	pstmt.setInt(3, mvcBoardVO.getIdx());
		}
		
	});
}

public void delete(final int idx) {
	String sql = "delete from mvcboard where idx = " + idx;
	template.update(sql);
	
}


public void replyIncrement(final HashMap<String, Integer> hmap) {
	String sql = "update mvcboard set seq = seq + 1 where gup = ? and seq >= ?";
	template.update(sql, new PreparedStatementSetter() {

		@Override
		public void setValues(PreparedStatement pstmt) throws SQLException {
			pstmt.setInt(1, hmap.get("gup"));
	    	pstmt.setInt(2, hmap.get("seq"));
			
		}
		
	});
}

public void replyInsert(final MvcBoardVO mvcBoardVO) {
	
	String sql = "insert into mvcboard(idx, name, subject, content, gup, lev, seq) " +
			"values (mvcboard_idx_seq.nextval, ?, ?, ?, ?, ?, ?";
	template.update(sql, new PreparedStatementSetter() {

		@Override
		public void setValues(PreparedStatement pstmt) throws SQLException {
			pstmt.setString(1, mvcBoardVO.getName());
	    	pstmt.setString(2, mvcBoardVO.getSubject());
	    	pstmt.setString(3, mvcBoardVO.getContent());
	    	pstmt.setInt(4, mvcBoardVO.getGup());
	    	pstmt.setInt(5, mvcBoardVO.getLev());
	    	pstmt.setInt(6, mvcBoardVO.getSeq());
			
		}
		
	});
}
	
}


































