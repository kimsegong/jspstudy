package ex06_session;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AddToCart
 */
@WebServlet("/addToCart")
public class AddToCart extends HttpServlet {
  private static final long serialVersionUID = 1L;
       
  /**
   * @see HttpServlet#HttpServlet()
   */
  public AddToCart() {
    super();
    // TODO Auto-generated constructor stub
  }

  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
    // 요청 인코딩
    request.setCharacterEncoding("UTF-8");
    
    // 요청 파라미터
    String item = request.getParameter("item");
    int ea = Integer.parseInt(request.getParameter("ea"));
    
    // item + ea -> Map
    Map<String, Object> map = new HashMap<String, Object>();
    map.put("item", item);
    map.put("ea", ea);
    
    // 장바구니 처리 방법 : session에 cart 속성을 저장하고 cart에 [item + ea -> Map] 저장하기
    HttpSession session = request.getSession();
    List<Map<String, Object>> cart = (List<Map<String, Object>>)session.getAttribute("cart");
    if(cart == null) {
      cart = new ArrayList<Map<String,Object>>();
      session.setAttribute("cart", cart);
    }
    
    // cart에 Map 저장하기
    cart.add(map);
    
    // 응답 타입과 인코딩
    response.setContentType("text/html; charset=UTF-8");
    
    // 응답 출력 스트림
    PrintWriter out = response.getWriter();
    
    // 응답하기
    out.println("<script>");
    out.println("if(confirm('" + item + "을 장바구니에 담았습니다. 장바구니로 가려면 \"확인\" 계속 쇼핑하려면 \"취소\" 버튼을 누르세요')){");
    out.println("location.href='" + request.getContextPath() + "/ex06_session/cart.jsp'");
    out.println("}else{");
    out.println("location.href='" + request.getContextPath() + "/ex06_session/main.jsp'");
    out.println("}");
    out.println("</script>");
    out.flush();
    out.close();
    
  }

  /**
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // TODO Auto-generated method stub
    doGet(request, response);
  }

}