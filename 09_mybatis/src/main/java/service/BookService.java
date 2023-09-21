package service;

import javax.servlet.http.HttpServletRequest;

import common.ActionForward;

public interface BookService {
   public ActionForward bookList(HttpServletRequest request);
   public ActionForward bookDetail(HttpServletRequest request);
   public ActionForward bookAdd(HttpServletRequest request);
   public ActionForward bookEdit(HttpServletRequest request);
   public ActionForward bookModify(HttpServletRequest request);
   public ActionForward bookDelete(HttpServletRequest request);
}