package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ActionForward;
import service.BoardService;
import service.BoardServiceImpl;

/**
 * Servlet implementation class BoardController
 */
@WebServlet("*.do")
public class BoardController extends HttpServlet {
  private static final long serialVersionUID = 1L;
       
  /**
   * @see HttpServlet#HttpServlet()
   */
  public BoardController() {
    super();
    // TODO Auto-generated constructor stub
  }

  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    // BoardFilter 실행 후 Controller 실행
    
    // 요청 인코딩(BoardFilter가 수행함) + 응답 타입과 인코딩
    // request.setCharacterEncoding("UTF-8");
    response.setContentType("text/html; charset=UTF-8");
    
    // 요청 주소 확인
    String requestURI = request.getRequestURI();
    String contextPath = request.getContextPath();
    String urlMapping = requestURI.substring(contextPath.length());
    
    // 어디로 어떻게 이동할 것인지 알고 있는 ActionForward 객체
    ActionForward af = null;
    
    // BoardService 객체 생성
    BoardService boardService = new BoardServiceImpl();

    // 요청에 따른 처리
    switch(urlMapping) {
    // 단순 이동 (forward 처리)
    case "/board/write.do":
      af = new ActionForward("/board/write.jsp", false);
      break;
    case "index.do":
      af = new ActionForward("/index.jsp", false);
      break;
    // 서비스 처리
    case "/board/register.do":
      af = boardService.register(request);
      break;
    case "/board/list.do":
      af = boardService.getBoardList(request);
      break;
    case "/board/detail.do":
      af = boardService.getBoardByNo(request);
      break;
    case "/board/adit.do":
      af = boardService.edit(request);
      break;
    case "/board/modify.do":
      af = boardService.modity(request);
      break;
    }
    
    // 이동
    if(af != null) {
      if(af.isRedirect()) {
        response.sendRedirect(af.getPath());
      } else {
        request.getRequestDispatcher(af.getPath()).forward(request, response);
      }
    }
    
  }

  /**
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // TODO Auto-generated method stub
    doGet(request, response);
  }

}