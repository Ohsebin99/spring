package com.tjoeun.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.security.auth.Subject;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.tjoeun.springWEB_DBCP_board.HomeController;
import com.tjoeun.vo.MvcBoardVO;

public class MvcBoardDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

//	DBCP에 사용할 DataSource 인터페이스 객체를 선언한다.
	private DataSource dataSource;
	
//	MvcBoardDAO 클래스의 bean이 생성될 때 데이터베이스와 연결한다.
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
	
	public void insert(MvcBoardVO mvcBoardVO) {
		logger.info("MvcBoardDAO 클래스의 insert() 메소드 실행");
		// logger.info("{}", mvcBoardVO);
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = dataSource.getConnection();
			String sql = "insert into mvcboard (idx, name, subject, content, gup, lev, seq) " +
						 "values (mvcboard_idx_seq.nextval, ?, ?, ?, mvcboard_idx_seq.currval, 0, 0)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mvcBoardVO.getName());
			pstmt.setString(2, mvcBoardVO.getSubject());
			pstmt.setString(3, mvcBoardVO.getContent());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
//	SelectService 클래스에서 호출되는 테이블에 저장된 전체 글의 개수를 얻어오는 select sql 명령을 
//	실행하는 메소드
//  SelectService 클래스에서 호출되는 테이블에 저장된 전체 글의 개수를 얻어오는 select sql 명령을 실행하는 메소드
  public int selectCount() {
     logger.info("MvcBoardDAO 클래스의 selectCount() 매소드 실행");
     
     Connection conn = null;
     PreparedStatement pstmt = null;
     ResultSet rs = null;
     int result = 0; // 테이블에 저장된 전체 글의 개수를 저장해서 return시킬 변수를 선언한다.
     
     try {
        conn = dataSource.getConnection(); // db연결
        String sql = "select count(*) from mvcboard";
        pstmt = conn.prepareStatement(sql);
        rs = pstmt.executeQuery();
        
        //   테이블에 저장된 글의 개수는 null이 나올 수 없으므로 조건 비교는 필요없다.
        rs.next();
        result = rs.getInt(1);
     } catch (SQLException e) {
        e.printStackTrace();
     } finally {
        if (conn != null) { try {conn.close();} catch (SQLException e) {e.printStackTrace();}} 
     } 
     
     return result;
  }

//  SelectService 클래스에서 호출되는 브라우저에 표시할 1페이지 분량의 글 목록을 얻어오기 위해서 시작
//  인덱스, 끝 인덱스가 저장된 HashMap 객체를 넘겨받고 1페이지 분량의 글 목록을 얻어오는 select sql
//  명령을 실행하는 메소드
public ArrayList<MvcBoardVO> selectList(HashMap<String, Integer> hmap) {
	logger.info("MvcBoardDAO 클래스의 selectList() 매소드 실행");
    
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    ArrayList<MvcBoardVO> list = null; // 1페이지 분량의 글 목록을 저장해 리턴시킬 ArrayList
    
    try{
    	conn = dataSource.getConnection();
    	String sql = "select * from (" +
    				"    select rownum rnum, AA.* from(" +
    				"        select * from mvcboard order by gup desc, seq asc" +
    				"    ) AA where rownum <= ?" +
    				") where rnum >= ?";
    	pstmt = conn.prepareStatement(sql);
    	pstmt.setInt(1, hmap.get("endNo"));
    	pstmt.setInt(2, hmap.get("startNo"));
    	rs = pstmt.executeQuery();
    	
    	// ResultSet 객체에 저장된 1페이지 분량의 글 목록을 저장할 ArrayList 객체 생성
    	list = new ArrayList<MvcBoardVO>();
    	// ResultSet 객체에 저장된 글의 개수만큼 반복하며 ArrayList에 저장한다.
    	while (rs.next()) {
    		AbstractApplicationContext ctx = 
    				new GenericXmlApplicationContext("classpath:applicationCTX.xml");
    		MvcBoardVO mvcBoardVO = ctx.getBean("mvcBoardVO", MvcBoardVO.class);
    		mvcBoardVO.setIdx(rs.getInt("idx"));
    		mvcBoardVO.setName(rs.getString("name"));
    		mvcBoardVO.setSubject(rs.getString("subject"));
    		mvcBoardVO.setContent(rs.getString("content"));
    		mvcBoardVO.setGup(rs.getInt("gup"));
    		mvcBoardVO.setLev(rs.getInt("lev"));
    		mvcBoardVO.setSeq(rs.getInt("seq"));
    		mvcBoardVO.setHit(rs.getInt("hit"));
    		mvcBoardVO.setWriteDate(rs.getTimestamp("writeDate"));
    		list.add(mvcBoardVO);
    	}
	} catch (SQLException e) {
	    e.printStackTrace();
	 } finally {
	    if (conn != null) { try {conn.close();} catch (SQLException e) {e.printStackTrace();}} 
	 } 
	return list;
}
// IncrementService 클래스에서 호출되는 조회수를 증가시킬 글번호를 넘겨받고 조회수를 증가시키는
// 

public void increment(int idx) {
	logger.info("MvcBoardDAO 클래스의 selectCount() 매소드 실행");
    
    Connection conn = null;
    PreparedStatement pstmt = null;
    
    try {
    	conn = dataSource.getConnection();
    	String sql = "update mvcboard set hit = hit + 1 where idx = ?";
    	pstmt = conn.prepareStatement(sql);
    	pstmt.setInt(1, idx);
    	pstmt.executeUpdate(sql);
    } catch (SQLException e) {
	    e.printStackTrace();
	 } finally {
	    if (conn != null) { try {conn.close();} catch (SQLException e) {e.printStackTrace();}} 
	 } 
}

public MvcBoardVO selectByIdx(int idx) {
	logger.info("MvcBoardDAO 클래스의 selectCount() 매소드 실행");
    
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    MvcBoardVO mvcBoardVO = null;
    
    try {
    	conn = dataSource.getConnection();
    	String sql = "select * from mvcboard where idx = ?";
    	pstmt = conn.prepareStatement(sql);
    	pstmt.setInt(1, idx);
    	rs = pstmt.executeQuery();
    	
    	// ResultSet 객체에 저장된 글 1건을 리턴시키기 위해서 MvcBoardVO 클래스 객체에 저장한다.
    	if (rs.next()) {
    		AbstractApplicationContext ctx = 
    				new GenericXmlApplicationContext("classpath:applicationCTX.xml");
    		mvcBoardVO = ctx.getBean("mvcBoardVO", MvcBoardVO.class);
    		mvcBoardVO.setIdx(rs.getInt("idx"));
    		mvcBoardVO.setName(rs.getString("name"));
    		mvcBoardVO.setSubject(rs.getString("subject"));
    		mvcBoardVO.setContent(rs.getString("content"));
    		mvcBoardVO.setGup(rs.getInt("gup"));
    		mvcBoardVO.setLev(rs.getInt("lev"));
    		mvcBoardVO.setSeq(rs.getInt("seq"));
    		mvcBoardVO.setHit(rs.getInt("hit"));
    		mvcBoardVO.setWriteDate(rs.getTimestamp("writeDate"));
    	}
    } catch (SQLException e) {
	    e.printStackTrace();
	 } finally {
	    if (conn != null) { try {conn.close();} catch (SQLException e) {e.printStackTrace();}} 
	 } 
    
	return mvcBoardVO;
}

public void update(int idx, String subject, String content) {
	
	Connection conn = null;
    PreparedStatement pstmt = null;
    
    try {
    	conn = dataSource.getConnection();
    	String sql = "update mvcboard set subject = ?, content = ? where idx = ?";
    	pstmt = conn.prepareStatement(sql);
    	pstmt.setString(1, subject);
    	pstmt.setString(2, content);
    	pstmt.setInt(3, idx);
    	pstmt.executeUpdate();
    }catch (SQLException e) {
	    e.printStackTrace();
	 } finally {
	    if (conn != null) { try {conn.close();} catch (SQLException e) {e.printStackTrace();}} 
	 } 
}

public void update(MvcBoardVO mvcBoardVO) {
	Connection conn = null;
    PreparedStatement pstmt = null;
    
    try {
    	conn = dataSource.getConnection();
    	String sql = "update mvcboard set subject = ?, content = ? where idx = ?";
    	pstmt = conn.prepareStatement(sql);
    	pstmt.setString(1, mvcBoardVO.getSubject());
    	pstmt.setString(2, mvcBoardVO.getContent());
    	pstmt.setInt(3, mvcBoardVO.getIdx());
    	pstmt.executeUpdate();
    }catch (SQLException e) {
	    e.printStackTrace();
	 } finally {
	    if (conn != null) { try {conn.close();} catch (SQLException e) {e.printStackTrace();}} 
	 } 
}

public void delete(int idx) {
	Connection conn = null;
    PreparedStatement pstmt = null;
    
    try {
    	conn = dataSource.getConnection();
    	String sql = "delete from mvcboard where idx = ?";
    	pstmt = conn.prepareStatement(sql);
    	pstmt.setInt(1, idx);
    	pstmt.executeUpdate();
    }catch (SQLException e) {
	    e.printStackTrace();
	 } finally {
	    if (conn != null) { try {conn.close();} catch (SQLException e) {e.printStackTrace();}} 
	 } 
}

// ReplyService 클래스에서 호출되는 글그룹과 글이 출력되는 순서가 저장돤 HashMap 객체를 넘겨받고
// 조건에 만족하는 레코드의 seq를 1씩 증가시키는 update sql 명령을 실행하는 메소드

public void replyIncrement(HashMap<String, Integer> hmap) {
	Connection conn = null;
    PreparedStatement pstmt = null;
    
    try {
    	conn = dataSource.getConnection();
    	String sql = "update mvcboard set seq = seq + 1 where gup = ? and seq >= ?";
    	pstmt = conn.prepareStatement(sql);
    	pstmt.setInt(1, hmap.get("gup"));
    	pstmt.setInt(2, hmap.get("seq"));
    	pstmt.executeUpdate();
    } catch (SQLException e) {
	    e.printStackTrace();
	 } finally {
	    if (conn != null) { try {conn.close();} catch (SQLException e) {e.printStackTrace();}} 
	 } 
}

// ReplyService 클래스에서 호출되는 답글이 저장된 객체를 넘겨받고 답글을 저장하는 insert sql 명령을
// 실행하는 메소드
public void replyInsert(MvcBoardVO mvcBoardVO) {
	Connection conn = null;
    PreparedStatement pstmt = null;
    
    try {
    	conn = dataSource.getConnection();
    	String sql = "insert into mvcboard(idx, name, subject, content, gup, lev, seq) " +
    					"values (mvcboard_idx_seq.nextval, ?, ?, ?, ?, ?, ?";
    	pstmt = conn.prepareStatement(sql);
    	pstmt.setString(1, mvcBoardVO.getName());
    	pstmt.setString(2, mvcBoardVO.getSubject());
    	pstmt.setString(3, mvcBoardVO.getContent());
    	pstmt.setInt(4, mvcBoardVO.getGup());
    	pstmt.setInt(5, mvcBoardVO.getLev());
    	pstmt.setInt(6, mvcBoardVO.getSeq());
    	pstmt.executeUpdate();
    } catch (SQLException e) {
	    e.printStackTrace();
	 } finally {
	    if (conn != null) { try {conn.close();} catch (SQLException e) {e.printStackTrace();}} 
	 } 
}
	
}


































