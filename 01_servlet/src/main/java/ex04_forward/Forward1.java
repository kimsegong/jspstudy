package ex04_forward;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Forward1
 */
@WebServlet("/forward1")
public class Forward1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Forward1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	  /*
	   * forward 
	   * 1. 다른 경로로 이동하는 방식 중 하나이다.
	   * 2. 다른 경로로 직접 요청 파라미터를 이동시킨다.
	   * 3. 경로를 작성할 때 URLMapping만 작성한다. (ContextPath는 작성하지 않는다)
	   */
	  
	  // 요청의 전달 객체 생성 경유하는곳 경유
	  RequestDispatcher dispatcher = request.getRequestDispatcher("/forward2");
	  
	  // 전달 (요청과 응답을 모두 전달함)
	  dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
