package service;

import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ActionForward;

public class MvcServiceImpl implements MvcService {

  @Override
  public ActionForward getDate(HttpServletRequest request) {
    request.setAttribute("today", LocalDate.now().toString());
    return new ActionForward("views/date.jsp", false);
  }

  @Override
  public ActionForward getTime(HttpServletRequest request) {
    request.setAttribute("now", LocalTime.now().toString());
    return new ActionForward("views/time.jsp", false);
  }
  
  @Override
  public void getDatetime(HttpServletRequest request, HttpServletResponse response) {
    String datetime = LocalDateTime.now().toString();
    PrintWriter out = null;
    try {
      out = response.getWriter();
      out.println("<script>");
      out.println("alert('" + datetime + "')");                           // 요청 결과 보여주기
      out.println("location.href = '" + request.getContextPath() + "'");  // 이동하기 (redirect와 같은 방식의 이동)
      out.println("</script>");
      out.flush();
      out.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}