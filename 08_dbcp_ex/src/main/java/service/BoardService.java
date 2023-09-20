package service;

import javax.servlet.http.HttpServletRequest;

import common.ActionForward;

public interface BoardService {
  public ActionForward addArticle(HttpServletRequest request);
  public ActionForward getBoardList(HttpServletRequest request);
  public ActionForward getBoardByNo(HttpServletRequest request);
  public ActionForward editArticle(HttpServletRequest request);
  public ActionForward modityArticle(HttpServletRequest request);
  public ActionForward deleteArticle(HttpServletRequest request);
  public ActionForward plusHit(HttpServletRequest request);
}
