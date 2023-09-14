<%@page import="java.util.Optional"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%
  request.setCharacterEncoding("UTF-8");
  Optional<String> opt = Optional.ofNullable(request.getParameter("title"));
  String title = opt.orElse("환영합니다");
  String ContextPath = request.getContextPath();
%>
<title><%=title%></title>
<script src="<%=ContextPath%>/resource/js/lib/jquery-3.7.1.min.js"></script>
<script src="<%=ContextPath%>/resource/js/header.js?dt=<%=System.currentTimeMillis()%>"></script>
<link rel="stylesheet" href="<%=ContextPath%>/resource/css/header.css?dt=<%=System.currentTimeMillis()%>">
<link rel="stylesheet" href="<%=ContextPath%>/resource/css/main.css?dt=<%=System.currentTimeMillis()%>">
<link rel="stylesheet" href="<%=ContextPath%>/resource/css/footer.css?dt=<%=System.currentTimeMillis()%>">
</head>
<body>

  <nav class="gnb">
    <div class="logo"></div>
    <ul>
      <li><a href="main1.jsp">정치</a></li>
      <li><a href="main2.jsp">경제</a></li>
      <li><a href="main3.jsp">사회</a></li>
    </ul>
  </nav>