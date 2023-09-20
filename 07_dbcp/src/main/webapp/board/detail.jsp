<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="<%=request.getContextPath()%>" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
<style>
  .link a {
    margin-right: 20px;
  }
</style>
<script>

  $(function(){
    fnDelete();
  })
  
  function fnDelete(){
    $('#delete_link').click(function(event){
      if(!confirm('게시글을 삭제할까요?')){
        event.preventDefault();
        return;
      } 
    })
  }

</script>
</head>
<body>

  <div class="link">
    <a href="${contextPath}/board/write.do">작성하러가기</a>
    <a href="${contextPath}/board/list.do">목록으로이동</a>
    <a href="${contextPath}/board/adit.do?board_no=${board.board_no}">수정</a>
    <a id="delete_link" href="${contextPath}/board/delete.do?board_no=${board.board_no}">삭제</a>
  </div>

  <hr>
  
  <div>
    <div>게시글번호: ${board.board_no}</div>
    <div>제목: ${board.title}</div>
    <div><pre>${board.content}</pre></div>
    <div>최종수정일: ${board.modified_at}</div>
    <div>최초작성일: ${board.created_at}</div>
  </div>>
   
</body>
</html>