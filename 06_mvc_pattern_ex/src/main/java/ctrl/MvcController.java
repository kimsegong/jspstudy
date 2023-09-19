package ctrl;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ActionForward;
import service.MvcService;
import service.MvcServiceImpl;

/**
 * Servlet implementation class MvcController
 */
@WebServlet("*.do")
public class MvcController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MvcController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	  // 요청 인코딩 + 응답 타입과 인코딩
	  request.setCharacterEncoding("UTF-8");
	  response.setContentType("text/html; charset=UTF-8");
	  
	  // 요청 확인
	  String requestURI = request.getRequestURI();
	  String contextPath = request.getContextPath();
	  String urlMapping = requestURI.substring(contextPath.length());
	  
	  // 서비스 객체 생성
	  MvcService mvcService = new MvcServiceImpl();
	  
	  // ActionForward 객체 생성 (서비스의 실행 결과를 저장할 객체)
	  ActionForward af = null;
	  
	  // 요청에 따른 서비스 선택과 실행
	  switch(urlMapping) {
	  case "/getAge.do" :
	    af = mvcService.getAge(request);
	    break;
	  case "/getAbs.do" :
	    mvcService.getAbs(request, response);
	    break;
	  case "/getInfo.do":
	    af = mvcService.getInfo(request);
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
