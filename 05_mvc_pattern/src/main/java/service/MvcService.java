package service;

import javax.servlet.http.HttpServletRequest;

public interface MvcService {
  public String getDate(HttpServletRequest request);
  public String getTime(HttpServletRequest request);
}