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
    <c:choose>
    1. <c:if> 태그를 대체할 수 있다.
    2. else if, else 문 처리가 가능하다.
    3. 형식
      <c:choose>
        <c:when test="조건식">
          실행문
        </c:when>
        <c:when test="조건식">
          실행문
        </c:when>
        <c:otherwise>
          실행문
        </c:otherwise>
      </c:choose>
   --%>
   
   <c:set var="age" value="20"/>
   <c:choose>
    <c:when test="${age < 8 }">
      <c:set var="result" value="미취학아동"/>
    </c:when>
    <c:when test="${age < 14 }">
      <c:set var="result" value="초등학생"/>
    </c:when>
    <c:when test="${age < 17 }">
      <c:set var="result" value="중학생"/>
    </c:when>
    <c:when test="${age < 20 }">
      <c:set var="result" value="고등학생"/>
    </c:when>
    <c:otherwise>
      <c:set var="result" value="성인"/>
    </c:otherwise>
   </c:choose>
   
   <div>${age}살, ${result}</div>
</body>
</html>