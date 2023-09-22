package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.MemberService;
import service.MemberServiceImpl;

@WebServlet("*.do")
public class MemberController extends HttpServlet {
  
  private static final long serialVersionUID = 1L;
  private MemberService memberService = new MemberServiceImpl();

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
    request.setCharacterEncoding("UTF-8");
    response.setContentType("text/plain; charset=UTF-8");  // JSON 데이터를 문자열로 반환함
    
    String requestURI = request.getRequestURI();
    String contextPath = request.getContextPath();
    String urlMapping = requestURI.substring(contextPath.length());
    
    switch(urlMapping) {
    case "/member/list.do":
      memberService.getMemberList(response);
      break;
    case "/member/add.do":
      memberService.memberAdd(request, response);
      break;
    case "/member/emailCheck.do":
      memberService.memberEmailCheck(request, response);
      break;
    case "/member/detail.do":
      memberService.memberDetail(request, response);
      break;
    case "/member/modify.do":
      memberService.memberModify(request, response);
      break;
    case "/member/delete.do":
      memberService.memberDelete(request, response);
      break;
    }
    
  }


  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // TODO Auto-generated method stub
    doGet(request, response);
  }

}