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

  <div>
    <ul>
      <li>${vo.name}</li>
      <li>${vo.age}</li>
      <li>${vo.gender}</li>
      <li>
        <c:forEach var="hobby" items="${vo.hobbies}">
          ${hobby}&nbsp;
        </c:forEach>
      </li>
    </ul>
  </div>
</body>
</html>