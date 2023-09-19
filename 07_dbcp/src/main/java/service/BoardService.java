package service;

import javax.servlet.http.HttpServletRequest;

import common.ActionForward;

public interface BoardService {
  public ActionForward register(HttpServletRequest request);
}
