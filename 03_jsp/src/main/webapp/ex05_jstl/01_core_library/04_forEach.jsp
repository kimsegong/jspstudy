<%@page import="java.time.LocalDate"%>
<%@page import="ex05_jstl.BlogPost"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.util.List"%>
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
    <c:forEach>
    1. 반복문을 처리한다.
    2. 형식
      1) 일반 for문
        <c:forEach var="속성" begin="시작값" end="종료값" step="증가값">
          ${속상}
        </c:forEach>
      2) 향상 for문
        <c:forEach var="요소" items="배열 or 리스트">
          ${요소}
        </c:forEach>
   --%>
   
    <c:forEach var="num" begin="1" end="5" step="1">
    <div>${num}</div>
    </c:forEach>
    
    <hr>
    
    <%-- <c:forEach> 태그와 배열 --%>
    <%
      String[] season = {"봄", "여름", "가을", "겨울"};
      pageContext.setAttribute("season", season);
    %>
    <c:forEach var="season" items="${seasons}" varStatus="vs">
      <div>인덱스 : ${vs.index}</div>
      <div>요소 : ${season}</div>
    </c:forEach>
    
    <%-- <c:forEach> 태그와 리스트 --%>
    <%
      List<String> jobs = Arrays.asList("PM", "기획자", "개발자", "퍼블리셔");
      pageContext.setAttribute("jobs", jobs);
     %>
     <c:forEach var="job" items="${jobs}" varStatus="vs">
      <div>인덱스 : ${vs.index}</div>
      <div>직업 : ${job}</div> 
     </c:forEach>
     
    <%-- 임의의 BlogPost 3개를 List에 저장하고 화면에 출력하기 --%>
    <%
      List<BlogPost> list = Arrays.asList(
      new BlogPost(1, "여행", 23, LocalDate.of(2023, 9, 3)),
      new BlogPost(2, "취미", 12, LocalDate.of(2023, 9, 14)),
      new BlogPost(3, "음식", 21, LocalDate.of(2023, 9, 11))
      );
      pageContext.setAttribute("list", list);
    %>
    <c:forEach var="blogPost" items="${list}">
      <div class="blog">
        <span class="blogPostNo">${blogPost.blogPostNo}</span>
        <span class="title"><a href="">${blogPost.title}</a></span>
        <span class="hit">${blogPost.hit}</span>
        <span class="createdAt">${blogPost.createdAt}</span>
      </div>
    </c:forEach>
    
</body>
</html>