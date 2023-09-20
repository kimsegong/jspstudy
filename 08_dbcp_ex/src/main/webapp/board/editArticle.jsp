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
<script>

  $(function(){
    // 함수 호출
    fnboardList();
    fnBoardModify();  
  })
  
  // 함수 정의
  function fnboardList() {
    $('btn_list').click(function(){
    location.href = '${contextPath}/board/list.do';
    })
  }
  
  // 함수 정의
  function fnBoardModify() {
    $('#frm_edit').submit(function(event){
      if($('#title').val() === '') {
        alert('제목은 필수입니다.');
        $('#title').focus();
        event.preventDefault();
        return;
      }
    })
  }
</script>
</head>
<body>

  <div>
   <form id="frm_edit" method="post" action="${contextPath}/board/modify.do">
    <div>
      <label for="title">제목</label>
      <input type="text" id="title" name="title" value="${board.title}">
    </div>
    <div>
      <textarea rows="5" cols="50" name="content">${board.content}</textarea>
    </div>
    <div>
      <input type="hidden" name="board_no" value="${board.board_no}">
      <button type="submit">수정완료</button>
      <button type="reset">작성초기화</button>
      <button type="button" id="btn_list">목록으로이동</button>
    </div>
   </form>
  </div>

  
</body>
</html>