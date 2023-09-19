package service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ActionForward;

public interface MvcService {

  public ActionForward getAge(HttpServletRequest request);
  public void getAbs(HttpServletRequest request, HttpServletResponse response) throws IOException;
  public ActionForward getInfo(HttpServletRequest request);
}
