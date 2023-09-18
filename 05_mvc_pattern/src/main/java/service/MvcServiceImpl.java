package service;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.servlet.http.HttpServletRequest;

public class MvcServiceImpl implements MvcService {

  @Override
  public String getDate(HttpServletRequest request) {
    request.setAttribute("today", LocalDate.now().toString());
    return "views/result.jsp";
  }

  @Override
  public String getTime(HttpServletRequest request) {
    request.setAttribute("now", LocalTime.now().toString());
    return "views/result.jsp";
  }

}