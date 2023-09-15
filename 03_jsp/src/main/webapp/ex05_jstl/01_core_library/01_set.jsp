<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%--
  <c:set> 태그
  1. 속성(Attribute)을 저장할 때 사용한다.
  2. binding 영역을 지정할 수 있다. (디폴트는 pageContext에 저장임)
         영역           : 작성방법
    1) pageScope        : page
    2) requestScope     : request
    3) sessionScope     : session
    4) applicationScope : application
  3. 형식
    <c:set var="속성명" value="값" scope="binding영역"/>
 --%>
 
 <%-- 속성 저장하기 --%>
 <c:set var="age" value="30"/> <%-- pageContext.setAttribute("age", 30) --%>
 <c:set var="isAdult" value="${age >= 20}"/>
 
 <div>나이 : ${age}살</div>
 <div>${isAdult ? "성인" : "미성년자"}</div>
 
 <%-- 앞으로 자주 사용할 c:set --%>
 <c:set var="contextPath" value="${pageContext.request.contextPath}"/>
 <div>${contextPath}</div>
</body>
</html>