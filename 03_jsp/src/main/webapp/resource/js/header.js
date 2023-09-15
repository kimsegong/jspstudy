/**
 *  본문을 모두 읽은 뒤 JavaScript를 수행할 수 있도록 load 이벤트 처리한다.
 *   방법1. window.onload = function(){}
 *   방법2. $(document).ready(function(){})
 *   방법3. $(function(){})
 */
 
 $(function(){
 
 
  $('.gnb a').mouseover(function(){
  $(this).css('background-color', 'silver');
  })
  $('.gnb a').mouseout(function(){
    $(this).css('background-color', '');
  })
  
  var img = new Image();
  $(img).attr('src', getContextPath() + '/resource/assets/image/naver.png');
  $(img).css('width', '150px');
  $('.logo').html(img);
  
 })
 
 
   // 컨테스트패스를 반환하는 함수
 function getContextPath(){
   // location.href === http://localhost:8080/jsp/ex03_layout/main1.jsp
   // location.host === localhost:8080
   var begin = location.href.indexof(location.host) + loction.host.length;
   var end = location.href.indexof('/', begin + 1);
   return location.href.substring(begin, end);                
 }
 