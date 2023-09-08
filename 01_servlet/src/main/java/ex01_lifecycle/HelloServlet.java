package ex01_lifecycle;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServlet
 * 
 * 서블릿이란?
 * 1. 웹 브라우저를 통해서 실행되는 Java 클래스이다.
 * 2. 클라이언트의 요청을 받을 수 있는 Java 클래스이다.
 * 3. javax.servlet.http.HttpServlet 클래스를 상속 받는다.
 * 4. jsp/servlet container(톰캣)에 저장되기 때문에 동일한 이름의 서블릿을 2개 이상 만들 수 없다.
 * 5. 응답을 만들어서 클라이언트에게 전송할 수 있다.
 */


/*
 * URL
 * 
 * 1. 형식
 *   protocol://host:port/ContextPath(root)/URLMapping
 * 2. ContextPath(root)
 *   1) 프로젝트가 실행될 때 가지는 기본 경로를 의미한다.
 *   2) 수정 방법
 *      프로젝트 속성(properties) - web project Settings
 *   3) URL Mapping
 *     (1) 서블릿의 실행 경로를 의미한다. (URL Pattern)
 *     (2) 수정 방법
 *        (1) @WebServlet 애너테이션
 *        (2) 프로젝트 src/main/webapp/WEB-INF/web.xml
 */
@WebServlet("/HelloServlet")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * 1. 생성자
     *   1) 서블릿 생성할 때 호출된다. (가장 먼저 호출된다.)
     *   2) 서블릿 생성 후 자동으로 init() 메서드가 호출횐다.
     *   
     * @see HttpServlet#HttpServlet()
     */
    public HelloServlet() {
        super();
        // TODO Auto-generated constructor stub
        System.out.println("1. HelloServlet() 생성자 호출");
    }

	/**
	 * 2. init()
	 *   1) 서블릿 환경 설정을 담당하는 메서드이다.
	 *   2) init() 메서드 호출 뒤 자동으로 service() 메서드가 호출된다.
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	  System.out.println("2. init() 메서드 호출");
	}

	/**
	 * 3. service() 메서드
	 *   1) 클라이언트가 요청할 때 자동으로 호출되는 메서드이다.
	 *   2) 클라이언트로부터 요청을 받을 수 있고, 클라이언트에게 응답할 수 있다.
	 *   3) 요청을 처리하는 클래스 : javax.servlet.http.HttpServletRequest
	 *   4) 응답을 처리하는 클래스 : javax.servlet.http.HttpServletResponse
	 *   5) service() 메서드가 없으면 doGet() 또는 doPost()와 같은 메서드가 요청 메서드에 따라서 자동으로 호출된다.
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	  System.out.println("3. service() 메서드 호출");
	  // 요청 메서드에 따라서 doGet() 또는 doPost() 메서드 호출하기
	  switch(request.getMethod()) {
	  case "GET": doGet(request, response);break;
	  case "POST": doPost(request, response);break;
	  }
	}

	/**
	 * 4. doGet()
	 *   1) GET 방식의 요청을 처리하는 메서드이다.
	 *   2) 기본적으로 POST 방식의 요청도 처리하도록 구성되어 있다.
	 *   3) GET 방식으로 요청하는 방법
	 *     (1) <a href="/servlet/HelloServlet">
	 *     (2) <form method="get" action="/servlet/HelloServlet">
	 *     (3) location.href = '/servlet/HelloServlet'
	 *     (4) window.open('/servlet/HelloServlet','','')
	 *     (5) $.ajax({
	 *           type: 'get',
	 *           url: '/servlet/HelloServlet', 
	 *           ...
	 *         })
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	  System.out.println("4. doGet() 메서드 호출");
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * 5. doPost()
	 *   1) Post 방식의 요청을 처리하는 메서드이다.
	 *   2) 기본적으로 POST 방식의 요청이 오더라도 doGet()으로 처리를 이관한다.
	 *   3) POST 방식으로 요청하는 방법
   *     (1) <a href="/servlet/HelloServlet">
   *     (2)  $.ajax({
   *           type: 'post',
   *           url: '/servlet/HelloServlet', 
   *           ...
   *         })
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	  System.out.println("4. doPost() 메서드 호출");
		doGet(request, response);
	}

}
