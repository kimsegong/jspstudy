<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
<script>

  $(function(){
    fnMemberList();
    fnInit();
    ////초기상태를위해 fnInitDetail()호출////
    fnInitDetail();
    /////////////////////////////////////////
    fnMemberAdd();
    fnEmailCheck();
    fnMemberDetail();
    fnMemberModify();
    fnMemberDelete();
  })

  function fnMemberList(){
    $.ajax({
      type: 'get',
      url: '${contextPath}/member/list.do',
      dataType: 'text',
      success: function(resData){
        var obj = JSON.parse(resData);
        $('#member_count').text(obj.memberCount);
        var memberList = $('#member_list');
        memberList.empty();  // 기존의 회원 목록을 지운다.
        if(obj.memberCount === 0){
          memberList.append('<tr><td colspan="6">등록된 회원이 없습니다.</td></tr>');
        } else {
          // $.each(배열, function(인덱스, 요소){})
          $.each(obj.memberList, function(i, elem){
            var str = '<tr>';
            str += '<td>' + elem.memberNo + '</td>';
            str += '<td>' + elem.email + '</td>';
            str += '<td>' + elem.name + '</td>';
            str += '<td>' + (elem.gender === 'man' ? '남자' : (elem.gender === 'woman' ? '여자' : '선택안함')) + '</td>';
            str += '<td>' + elem.address + '</td>';
            str += '<td><button class="btn_detail" data-email="' + elem.email + '">조회</button></td>';
            str += '</tr>';
            memberList.append(str);
          })
        }
      }
    })
  }
  
  function fnInit(){
    $('#btn_init').click(fnInitDetail);
  }
  
  function fnInitDetail(){
    $('#email').val('');
    $('#name').val('');
    $('#none').prop('checked', true);
    $('#address').val('');
    $('#msg_email').text('');
    ////    입력초기화를 클릭하면 신규등록버튼 활성화      ////
    //                            수정,삭제버튼 비활성화     //
    $('#btn_add').prop('disabled', false);
    $('#btn_modify').prop('disabled', true);
    $('#btn_delete').prop('disabled', true);
    ///////////////////////////////////////////////////////////
  }
  
  function fnMemberAdd(){
    $('#btn_add').click(function(){
      if(!ableEmail){
        alert('등록할 수 없는 이메일입니다.');
        $('#email').focus();
        return;
      }
      $.ajax({
        type: 'post',
        url: '${contextPath}/member/add.do',
        data: $('#frm_member').serialize(),  // 폼의 모든 입력 요소를 파라미터로 전송함(입력 요소는 name 속성이 필요함)
        dataType: 'text',
        success: function(resData){      // resData === '{"addResult":1}'   string
          var obj = JSON.parse(resData); //     obj === {"addResult":1}     object
          if(obj.addResult === 1){
            alert('회원 정보가 등록되었습니다.');
            fnMemberList();
            fnInitDetail();
          } else {
            alert('회원 정보 등록이 실패했습니다.');
          }
        }
      })
    })
  }
  
  var ableEmail = false;
  ////// myEmail 변수 추가 //////
  var myEmail = '';
  ///////////////////////////////
  
  function fnEmailCheck(){
    $('#email').keyup(function(){
      $.ajax({
        type: 'get',
        url: '${contextPath}/member/emailCheck.do',
        data: 'email=' + $(this).val(),
        dataType: 'text',
        success: function(resData){   // resData === '{"ableEmail":true}'
          var obj = JSON.parse(resData);  // obj === {"ableEmail":true}
          //// myEmail === $('#email').val() 조건은 입력된 이메일이 원래 자신의 email과 같음을 의미한다. ////
          ableEmail = obj.ableEmail || myEmail === $('#email').val();
          ///////////////////////////////////////////////////////////////////////////////////////////////////
          if(ableEmail){
            $('#msg_email').text('');
          } else {
            $('#msg_email').text('이미 등록된 이메일입니다.');
          }
        }
      })
    })
  }
  
  function fnMemberDetail(){
    $(document).on('click', '.btn_detail', function(){
      $.ajax({
        type: 'get',
        url: '${contextPath}/member/detail.do',
        data: 'email=' + $(this).data('email'),
        dataType: 'text',
        success: function(resData){          // resData === '{"member":{"memberNo":1,...}}'
          var obj = JSON.parse(resData);     //     obj === {"member":{"memberNo":1,...}}
          ///////////// 상세보기하면 해당 회원의 email이 myEmail에 저장된다. /////////////////
          myEmail = obj.member.email;
          ////////////////////////////////////////////////////////////////////////////////////
          $('#email').val(obj.member.email);
          $('#name').val(obj.member.name);
          $(':radio[name=gender][value=' + obj.member.gender + ']').prop('checked', true);
          $('#address').val(obj.member.address);
          $('#memberNo').val(obj.member.memberNo);
          //// 조회를 클릭하면 신규등록버튼 비활성화  ////
          //                      수정,삭제버튼 활성화  //
          $('#btn_add').prop('disabled', true);
          $('#btn_modify').prop('disabled', false);
          $('#btn_delete').prop('disabled', false);
          ////////////////////////////////////////////////
          //// ableEmail 상태 갱신을 위해 email의 keyup 이벤트 강제 실행 ////
          $('#email').trigger('keyup');
          ///////////////////////////////////////////////////////////////////
        }
      })
    })
  }
  
  function fnMemberModify(){
    $('#btn_modify').click(function(){
      /////////////다른 사람이 쓰는 이메일로 수정 불가능///////////////////
      if(!ableEmail ){
        alert('등록할 수 없는 이메일입니다.');
        $('#email').focus();
        return;
      }
      ////////////////////////////////////////////////////////////////////
      $.ajax({
        type: 'post',
        url: '${contextPath}/member/modify.do',
        data: $('#frm_member').serialize(),
        dataType: 'text',
        success: function(resData){       // resData === '{"modifyResult":1}'
          var obj = JSON.parse(resData);  //     obj === {"modifyResult":1}
          if(obj.modifyResult == 1){
            alert('회원 정보가 수정되었습니다.');
            fnMemberList();
          } else {
            alert('회원 정보 수정이 실패했습니다.');
          }
        }
      })
    })
  }
  
  function fnMemberDelete(){
    $('#btn_delete').click(function(){
      if(!confirm('회원 정보를 삭제할까요?')){
        return;
      }
      $.ajax({
        type: 'get',
        url: '${contextPath}/member/delete.do',
        data: 'memberNo=' + $('#memberNo').val(),
        dataType: 'text',
        success: function(resData){      // resData === '{"deleteResult":1}'
          var obj = JSON.parse(resData); //     obj === {"deleteResult":1}
          if(obj.deleteResult == 1){
            alert('회원 정보가 삭제되었습니다.');
            fnMemberList();
            fnInitDetail();
          } else {
            alert('회원 정보 삭제가 실패했습니다.');
          }
        }
      })
    })
  }

</script>
</head>
<body>

  <div class="wrap">
  
    <form id="frm_member">
      <div>
        <label for="email">이메일</label>
        <input type="text" name="email" id="email">
        <span id="msg_email"></span>
      </div>
      <div>
        <label for="name">이름</label>
        <input type="text" name="name" id="name">
      </div>
      <div>
        <input type="radio" name="gender" id="man" value="man">
        <label for="man">남자</label>
        <input type="radio" name="gender" id="woman" value="woman">
        <label for="woman">여자</label>
        <input type="radio" name="gender" id="none" value="none" checked>
        <label for="none">선택안함</label>
      </div>
      <div>
        <label for="address">주소</label>
        <input type="text" name="address" id="address">
      </div>
      <div>
        <input type="hidden" name="memberNo" id="memberNo">
        <button type="button" id="btn_init">입력초기화</button>
        <button type="button" id="btn_add">회원신규등록</button>
        <button type="button" id="btn_modify">회원정보수정</button>
        <button type="button" id="btn_delete">회원정보삭제</button>
      </div>
    </form>
  
    <hr>
    
    <table border="1">
      <caption>전체 회원수 <span id="member_count"></span>명</caption>
      <thead>
        <tr>
          <td>회원번호</td>
          <td>이메일</td>
          <td>이름</td>
          <td>성별</td>
          <td>주소</td>
          <td></td>
        </tr>
      </thead>
      <tbody id="member_list"></tbody>
    </table>
  
  </div>

</body>
</html>