package ex06_session;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ClearCart
 */
@WebServlet("/clearCart")
public class ClearCart extends HttpServlet {
  private static final long serialVersionUID = 1L;
       
  /**
   * @see HttpServlet#HttpServlet()
   */
  public ClearCart() {
    super();
    // TODO Auto-generated constructor stub
  }

  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    // 장바구니 비우기 : session에 저장된 cart 지우기
    HttpSession session = request.getSession();
    session.removeAttribute("cart");
    
    // main 화면으로 되돌아가기
    response.sendRedirect(request.getContextPath() + "/ex06_session/main.jsp");
    
  }

  /**
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // TODO Auto-generated method stub
    doGet(request, response);
  }

}