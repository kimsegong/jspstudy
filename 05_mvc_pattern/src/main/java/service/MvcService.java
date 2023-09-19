package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ActionForward;

public interface MvcService {
  public ActionForward getDate(HttpServletRequest request);
  public ActionForward getTime(HttpServletRequest request);
  public void getDatetime(HttpServletRequest request, HttpServletResponse response);
}