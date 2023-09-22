package service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import domain.MemberDto;
import repository.MemberDao;

public class MemberServiceImpl implements MemberService {

  private MemberDao dao = MemberDao.getDao();
  
  @Override
  public void getMemberList(HttpServletResponse response) throws IOException {
    
    List<MemberDto> memberList = dao.memberList();
    int memberCount = dao.memberCount();
    
    JSONObject obj = new JSONObject();    // { }
    obj.put("memberList", memberList);    // {"memberList":[{}, {}, {}, ...]}
    obj.put("memberCount", memberCount);  // {"memberList":[{}, {}, {}, ...], "memberCount":5}
    //                                       -------------------------------------------------
    //                                                            ↓
    PrintWriter out = response.getWriter();                   //  ↓  
    out.println(obj.toString());  // $.ajax({success: function(resData){}})
    //               ↓                                            ↑
    //               └--------------------------------------------┘
    out.flush();
    out.close();
    
  }

  @Override
  public void memberAdd(HttpServletRequest request, HttpServletResponse response) throws IOException {
    
    MemberDto dto = MemberDto.builder()
                      .email(request.getParameter("email"))
                      .name(request.getParameter("name"))
                      .gender(request.getParameter("gender"))
                      .address(request.getParameter("address"))
                      .build();
    
    int addResult = dao.memberAdd(dto);
    
    JSONObject obj = new JSONObject();  // { }
    obj.put("addResult", addResult);    // {"addResult":1}
    
    PrintWriter out = response.getWriter();
    out.println(obj.toString());
    out.flush();
    out.close();
    
  }
  
  @Override
  public void memberEmailCheck(HttpServletRequest request, HttpServletResponse response) throws IOException {
    
    String email = request.getParameter("email");
    
    MemberDto dto = dao.getMemberByEmail(email);
    
    JSONObject obj = new JSONObject();  // { }
    obj.put("ableEmail", dto == null);  // {"ableEmail":true}
    
    PrintWriter out = response.getWriter();
    out.println(obj.toString());
    out.flush();
    out.close();
    
  }
  
  @Override
  public void memberDetail(HttpServletRequest request, HttpServletResponse response) throws IOException {
    
    String email = request.getParameter("email");
    
    MemberDto dto = dao.getMemberByEmail(email);
    
    JSONObject obj = new JSONObject();       // { }
    obj.put("member", new JSONObject(dto));  // {"member":{"memberNo":1,...}}
    
    PrintWriter out = response.getWriter();
    out.println(obj.toString());
    out.flush();
    out.close();
    
  }
  
  @Override
  public void memberModify(HttpServletRequest request, HttpServletResponse response) throws IOException {
    
    MemberDto dto = MemberDto.builder()
                      .email(request.getParameter("email"))
                      .name(request.getParameter("name"))
                      .gender(request.getParameter("gender"))
                      .address(request.getParameter("address"))
                      .memberNo(Integer.parseInt(request.getParameter("memberNo")))
                      .build();
    
    int modifyResult = dao.memberModify(dto);
    
    JSONObject obj = new JSONObject();      // { }
    obj.put("modifyResult", modifyResult);  // {"modifyResult":1}
    
    PrintWriter out = response.getWriter();
    out.println(obj.toString());
    out.flush();
    out.close();
    
  }
  
  @Override
  public void memberDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
    
    int memberNo = Integer.parseInt(request.getParameter("memberNo"));
    
    int deleteResult = dao.memberDelete(memberNo);
    
    JSONObject obj = new JSONObject();      // { }
    obj.put("deleteResult", deleteResult);  // {"deleteResult":1}
    
    PrintWriter out = response.getWriter();
    out.println(obj.toString());
    out.flush();
    out.close();
    
  }
  
}