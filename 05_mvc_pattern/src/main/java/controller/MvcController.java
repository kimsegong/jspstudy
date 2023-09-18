package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		
	  request.setCharacterEncoding("UTF-8");
	  
	  String requestURI = request.getRequestURI();                    /* /mvc/getDate.do */
	  String contextPath = request.getContextPath();                  /* /mvc */
	  String urlMapping = requestURI.substring(contextPath.length()); /* /getDate.do */
	  
	  MvcService mvcService = new MvcServiceImpl();
	  String path = null;
	  
	  switch(urlMapping) {
	  case "/getDate.do":
	    path = mvcService.getDate(request);
	    break;
	  case "/getTime.do":
	    path = mvcService.getTime(request);
	    break;
	  }
 	  request.getRequestDispatcher(path).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
