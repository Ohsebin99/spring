package com.tjoeun.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import com.tjoeun.vo.CardVO;

public class TransactionDAO {
   private static final Logger logger = LoggerFactory.getLogger(TransactionDAO.class);
   private JdbcTemplate template;
   
   public void setTemplate(JdbcTemplate template) {
      this.template = template;
   }
   
//   PlatformTransactionManager 인터페이스 객체 대신 TransactionTemplate 클래스 객체를 사용해서 트랜잭션
//   을 처리하기 때문에 주속으로 처리한다.
   
//   private PlatformTransactionManager transactionManager;
//
//   public void setTransactionManager(PlatformTransactionManager transactionManager) {
//      this.transactionManager = transactionManager;
//   }

// 트랜잭션 처리를 위해 사용했던 PlatformTransactionManager 인터페이스 객체 대신 트랜잭션 템플릿을
// 사용하기 위해 TransactionTemplate 클래스 객체를 선언한다.
   private TransactionTemplate transactionTemplate;
   
// 트랜잭션 처리를 위해 사용했던 PlatformTransactionManager 인터페이스 객체를 대신해서 사용할
// TransactionTemplate 클래스 객체를 초기화 하기 위해 setter 메소드를 선언하고 servlet-context.xml
// 파일에서 초기화 시킨다.
   
   public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
		this.transactionTemplate = transactionTemplate;
	}
   
   public void buyTicket(final CardVO cardVO) {
//      TransactionDefinition definition = new DefaultTransactionDefinition();
//      TransactionStatus status = transactionManager.getTransaction(definition);
//      
//      
//      try {
//         String sql = "insert into card (consumerID, amount) values (?, ?)";
//         template.update(sql, new PreparedStatementSetter() {
//            
//            @Override
//            public void setValues(PreparedStatement ps) throws SQLException {
//               ps.setString(1, cardVO.getConsumerId());
//               ps.setString(2, cardVO.getAmount());
//            }
//         });
//         
//         template.update(new PreparedStatementCreator() {
//            
//            @Override
//            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
//               String sql = "insert into ticket (consumerID, countnum) values (?, ?)";
//               PreparedStatement pstmt = con.prepareStatement(sql);
//               pstmt.setString(1, cardVO.getConsumerId());
//               pstmt.setString(2, cardVO.getAmount());
//               return pstmt;
//            }
//         });
//         
//         logger.info("정상수");
//         transactionManager.commit(status);
//         
//      } catch (Exception e) {
//         logger.info("비정상수");
//         transactionManager.rollback(status);
//      }
	  
	   // 트랜잭션 템플릿 코딩
	   try {
		   transactionTemplate.execute(new TransactionCallbackWithoutResult() {
			
			@Override
			protected void doInTransactionWithoutResult(TransactionStatus status) {
				 String sql = "insert into card (consumerID, amount) values (?, ?)";
		         template.update(sql, new PreparedStatementSetter() {
		            
		            @Override
		            public void setValues(PreparedStatement ps) throws SQLException {
		               ps.setString(1, cardVO.getConsumerId());
		               ps.setString(2, cardVO.getAmount());
		            }
		         });
		         
		         template.update(new PreparedStatementCreator() {
		            
		            @Override
		            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
		               String sql = "insert into ticket (consumerID, countnum) values (?, ?)";
		               PreparedStatement pstmt = con.prepareStatement(sql);
		               pstmt.setString(1, cardVO.getConsumerId());
		               pstmt.setString(2, cardVO.getAmount());
		               return pstmt;
		            }
		         });
				
			}
		});
		   logger.info("정상수");
	   }catch (Exception e) {
		   e.printStackTrace();
		   logger.info("비정상수");
	   }
      
   }
   
}

























