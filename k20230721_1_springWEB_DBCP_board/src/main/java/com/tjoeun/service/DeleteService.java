package com.tjoeun.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.ui.Model;

import com.tjoeun.dao.MvcBoardDAO;
import com.tjoeun.vo.MvcBoardVO;

public class DeleteService implements MvcBoardService {

   private static final Logger logger = LoggerFactory.getLogger(DeleteService.class);
   
   @Override
   public void execute(MvcBoardVO mvcboardVO) { }

   @Override
   public void execute(Model model) {
      logger.info("execute()");
      Map<String, Object> map = model.asMap();
      HttpServletRequest request = (HttpServletRequest) map.get("request");

//      Model 인터페이스 객체에 저장되서 넘어온 HttpServletRequest 인터페이스 객체에서 삭제할
//      글번호를 받는다.
      int idx = Integer.parseInt(request.getParameter("idx"));

//      글 1건을 삭제하는 메소드를 실행한다.
      AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationCTX.xml");
      MvcBoardDAO mvcboardDAO = ctx.getBean("mvcboardDAO", MvcBoardDAO.class);
      mvcboardDAO.delete(idx);
      
//      글 삭제 작업 후 돌아갈 페이지 번호를 Model 인터페이스 객체에 저장한다.
      model.addAttribute("currentPage", request.getParameter("currentPage"));
   }

}