package service;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Vo.UserVo;
import common.ActionForward;

public class MvcServiceImpl implements MvcService {

  @Override
  public ActionForward getAge(HttpServletRequest request) {
    
    String year = request.getParameter("year");
    int iYear = Integer.parseInt(year);
    int nowYear = LocalDate.now().getYear();
    
    request.setAttribute("age", nowYear - iYear);
    
    return new ActionForward("views/age.jsp", false);
    
  }
  
  @Override
  public void getAbs(HttpServletRequest request, HttpServletResponse response) throws IOException {
    
    int n = Integer.parseInt(request.getParameter("n"));
    
    PrintWriter out = response.getWriter();
    out.println("<script>");
    out.println("alert('" + (n >= 0 ? n : -n) + "')");
    out.println("location.href='" + request.getContextPath() + "'");
    out.println("</script>");
    out.flush();
    out.close();
    
  }  
  @Override
  public ActionForward getInfo(HttpServletRequest request) {
    String name = request.getParameter("name");
    int age = Integer.parseInt(request.getParameter("age"));
    String gender = request.getParameter("gender");
    String[] hobbies = request.getParameterValues("hobbies");
    
    UserVo vo = new UserVo();
    vo.setName(name);
    vo.setAge(age);
    vo.setGender(gender);
    vo.setHobbies(hobbies);
    
    request.setAttribute("vo", vo);
    
    return new ActionForward("views/info.jsp", false);
  }
}