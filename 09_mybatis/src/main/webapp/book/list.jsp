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
  .book_list table {
    border-collapse: collapse;
  }
  .book_list table td {
    border-top: 1px solid gray;
    border-bottom: 1px solid gray;
  }
</style>
<script>

  $(function(){
    fnEvent();
  })
  
  function fnEvent(){
    $('.btn_detail').click(function(){
      location.href = '${contextPath}/book/detail.do?bookNo=' + $(this).parent().data('book_no');
    })
    $('.btn_edit').click(function(){
      location.href = '${contextPath}/book/edit.do?bookNo=' + $(this).parent().data('book_no');
    })
    $('.btn_delete').click(function(){
      if(confirm('도서 정보를 삭제할까요?')){
        location.href = '${contextPath}/book/delete.do?bookNo=' + $(this).parent().data('book_no');
      }
    })
  }

</script>
</head>
<body>

  <div>
    <a href="${contextPath}/book/write.do">작성하러가기</a>
  </div>

  <hr>
  
  <div class="book_list">
    <table>
      <thead>
        <tr>
          <td>책번호</td>
          <td>제목</td>
          <td>저자</td>
          <td></td>
        </tr>
      </thead>
      <tbody>
        <c:forEach var="book" items="${bookList}">
          <tr>
            <td>${book.bookNo}</td>
            <td>${book.title}</td>
            <td>${book.author}</td>
            <td data-book_no="${book.bookNo}">
              <button type="button" class="btn_detail">상세조회</button>
              <button type="button" class="btn_edit">정보수정</button>
              <button type="button" class="btn_delete">정보삭제</button>
            </td>
          </tr>
        </c:forEach>
      </tbody>
    </table>
  </div>
  
  <div>${paging}</div>

</body>
</html>