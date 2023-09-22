package service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface MemberService {
  public void getMemberList(HttpServletResponse response) throws IOException;
  public void memberAdd(HttpServletRequest request, HttpServletResponse response) throws IOException; //응답만들때는 항상 예외처리  
  public void memberEmailCheck(HttpServletRequest request, HttpServletResponse response) throws IOException;
  public void memberDetail(HttpServletRequest request, HttpServletResponse response) throws IOException;
  public void memberModify(HttpServletRequest request, HttpServletResponse response) throws IOException;
  public void memberDelete(HttpServletRequest request, HttpServletResponse response) throws IOException;
}
