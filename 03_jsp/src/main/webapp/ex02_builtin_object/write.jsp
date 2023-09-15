<%@page import="java.time.LocalDate"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>작성화면</title>
</head>
<body>

  <div>
    <form method="post" action="<%=request.getContextPath()%>/ex02_builtin_object/save.jsp">
      <div>
        <label for="created_at">작성일자</label>
        <input type="text" id="created_at" name="createdAt" value="<%=LocalDate.now()%>">
      </div>
      <div>
        <label for="title">제목</label>
        <input type="text" id="title" name="title">
      </div>
      <div>
        <textarea name="content" rows="5" cols="50" placeholder="내용"></textarea>
      </div>
      <div>
        <button type="submit">작성완료</button>
        <button type="reset">다시작성</button>
      </div>
    </form>
  </div>

</body>
</html>