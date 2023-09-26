package com.tjoeun.meokjang;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tjoeun.dao.PartyDAO;
import com.tjoeun.dao.RepleDAO;
import com.tjoeun.service.PartyService;
import com.tjoeun.vo.Param;
import com.tjoeun.vo.PartyList;
import com.tjoeun.vo.PartyVO;
import com.tjoeun.vo.RepleList;

@Controller
public class PartyController {
	
	private static final Logger logger = LoggerFactory.getLogger(PartyController.class);
	
	@Autowired
	private SqlSession sqlSession; 
	
	@Autowired
	private PartyList partyList;
	
	@Autowired
	private PartyVO vo;
	
	@Autowired
	private RepleList repleList;
	
	
	@RequestMapping("/list")
	public String list(HttpServletRequest request, Model model, Param param) {
		logger.info("PartyController의 list()");
		PartyDAO mapper = sqlSession.getMapper(PartyDAO.class);
		logger.info("{} line39", partyList);
		logger.info("{} line40", param);
		int pageSize = 8;
		int currentPage = 1;
		try{
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}catch(NumberFormatException e){}
//
		if (param.getLocation() == null && param.getAcholchk() == null && param.getPartyGender() == null && param.getCategory() == null) {
		//	검색어가 입력되지 않은 경우
			int totalCount = mapper.selectCount();
			logger.info("{} line50", totalCount);
			partyList.initPartyList(pageSize, totalCount, currentPage);
			logger.info("{} line52", partyList);
			
			HashMap<String, Integer> hmap = new HashMap<String, Integer>();
			hmap.put("startNo", partyList.getStartNo());
			hmap.put("endNo", partyList.getEndNo());
			partyList.setList(mapper.selectList(hmap));

			logger.info("{} line59", partyList);
			
		} else {
			// 검색어가 입력된 경우 (condition 구별을 xml에서 한다.)
			int totalCount = mapper.selectCountMulti(param);
			System.out.println(totalCount);
			
			partyList.initPartyList(pageSize, totalCount, currentPage);
			param.setStartNo(partyList.getStartNo());
			param.setEndNo(partyList.getEndNo());
			System.out.println(partyList);	
			
			partyList.setList(mapper.selectListMulti(param));
			
			System.out.println(partyList);
		}
		
//		추후 수정 코드
		PartyList partyListSlider = new PartyList();
//		
		partyListSlider.setList(mapper.selectSlider());
		
	
//		1페이지 분량의 글 목록, 상단에 표시할 글목록, 현재페이지, ("\r\n", "enter")를 request 영역에 저장한다.
		request.setAttribute("partyListSlider", partyListSlider);
		request.setAttribute("partyList", partyList);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("enter", "\r\n"); 
	
		return "list";
	}
	
	@RequestMapping("/selectByIdx")
	public String selectByIdx(HttpServletRequest request, Model model) {
		logger.info("PartyController의 list()");
		PartyDAO mapper = sqlSession.getMapper(PartyDAO.class);
		RepleDAO repleMapper = sqlSession.getMapper(RepleDAO.class); 
		
//		idx=${so.idx}&currentPage=${currentPage}&job=repleView
		int currentPage = 1;
		int	idx = Integer.parseInt(request.getParameter("idx"));
//		listView.jsp 또는 repleInsert.jsp에서 넘어오는 글번호, 돌아갈 페이지 번호, 분기할 페이지 이름을 받는다.
		try {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		} catch(NumberFormatException e) {	}
		String job = request.getParameter("job");
		
//		로그인이 되어있지 않을 경우
//		if (session.getAttribute("mo") == null) {
//			out.println("<script> "+
//					"alert('로그인이 필요한 서비스입니다.');" +
//						"location.href='login-register/login.jsp';" +
//					"</script>"
//			);
//		} else {
		// 메인글 1건을 얻어오는 메소드를 호출한다.	
			vo = mapper.selectByIdx(idx);
			
			System.out.println(vo);
		// 메인글 1건의 종속한 reple List를 얻어온다.	
			RepleList repleList = repleMapper.selectRepleList(idx);
				
			System.out.println(repleList);
			
			
		// 브라우저에 출력할 메인글이 저장된 객체(vo), 작업 후 돌아갈 페이지 번호, 줄바꿈에 사용할
			request.setAttribute("repleList", repleList);
			request.setAttribute("vo", vo);
			request.setAttribute("currentPage", currentPage);
			request.setAttribute("enter", "\r\n");
//		}
		
		
		
		
		
		return job;
	}
}
