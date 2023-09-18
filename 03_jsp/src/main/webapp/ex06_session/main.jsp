<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
<script>
  // <body> 태그를 모두 읽은 뒤 function(){}을 실행한다.
  $(function(){
    $('#btn_logout').click(function(){
      location.href = '${contextPath}/logout';
    })
  })
</script>
</head>
<body>

<%-- 로그인 안 된 상태 --%>
<c:if test="${sessionScope.id == null}">
  <div>
    <form method="post" action="${contextPath}/login">
      <div>
        <label for="id">아이디</label>
        <input type="text" name="id" id="id">
      </div>
      <div>
        <label for="pw">비밀번호</label>
        <input type="password" name="pw" id="pw">
      </div>
      <div>
        <button type="submit">로그인</button>
      </div>
    </form>
  </div>
</c:if>

<%-- 로그인 된 상태 --%>
<c:if test="${sessionScope.id != null}">
  <div>${sessionScope.id}님 환영합니다.</div>
  <div><button type="button" id="btn_logout">로그아웃</button></div>
</c:if>

<hr>

<div>
  <form method="get" action="${contextPath}/addToCart">
    <h4>쇼핑목록</h4>
    <div>
      <select name="item">
        <option>진라면</option>
        <option>신라면</option>
        <option>삼양라면</option>
      </select>
      <input type="text" name="ea" placeholder="구매개수">
    </div>
    <div>
      <button type="submit">장바구니추가</button>
    </div>
  </form>
</div>







</body>
</html>