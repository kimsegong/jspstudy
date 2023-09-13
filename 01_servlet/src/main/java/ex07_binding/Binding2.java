package ex07_binding;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Binding2
 */
@WebServlet("/binding2")
public class Binding2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Binding2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	  // ServletContext 영역의 msg 확인하기
	  String msg1 = (String)request.getServletContext().getAttribute("msg");
	  System.out.println(msg1);
	  
	  // HttpSession 영역의 msg 확인하기
	  String msg2 = (String)request.getSession().getAttribute("msg");
	  System.out.println(msg2);
	  
	  // HttpServletRequset 영역의 msg 확인하기
	  String msg3 = (String)request.getAttribute("msg");
	  System.out.println(msg3);
	  
	  request.getRequestDispatcher("/binding3").forward(request, response);
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
