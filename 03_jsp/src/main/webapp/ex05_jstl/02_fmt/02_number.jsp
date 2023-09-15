<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

  <c:set var="n" value="12345.6789"/>
  
  <div><fmt:formatNumber value="${n}" pattern="#,##0"/></div>
  <div><fmt:formatNumber value="${n}" pattern="#,##0.00"/></div>
  
  
  <div><fmt:formatNumber value="0.5" type="percent"/></div>
  <div><fmt:formatNumber value="${n}" type="currency" currencySymbol="$"/></div>
  <div><fmt:formatNumber value="${n}" type="currency" currencySymbol="￦"/></div>
  
</body>
</html>