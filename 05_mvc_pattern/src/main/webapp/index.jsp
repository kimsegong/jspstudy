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
  $(function(){
    $('#btn').click(function(){
      if($('#type').val() === '1'){
        location.href = '${contextPath}/getDate.do';
      } else if($('#type').val() === '2'){
        location.href = '${contextPath}/getTime.do';
      } else if($('#type').val() === '3'){
        location.href = '${contextPath}/getDatetime.do';
      }
    })
  })
</script>
</head>
<body>

<div>
  <form method="get">
    <select id="type">
      <option value="1">현재날짜</option>
      <option value="2">현재시간</option>
      <option value="3">현재날짜시간</option>
    </select>
    <button id="btn" type="button">요청</button>
  </form>
</div>

</body>
</html>