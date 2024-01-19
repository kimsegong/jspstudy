<h1>JSP(JavaServerPages)정복하기</h1>

HTML 코드에 JAVA 코드를 넣어 동적 웹페이지를 생성하는 웹어플리케이션 도구이다.<br>
JSP가 실행되면 자바 서블릿(Servlet)으로 변환되며 웹 어플리케이션 서버에서 동작되면서 필요한 기능을 수행하고 
그렇게 생성된 데이터를 웹페이지와 함께 클라이언트로 응답한다.


<img src=https://blog.kakaocdn.net/dn/0CaN9/btqEiMKbAQf/zcJr0xohg1aV228f2wtzq0/img.jpg></img>

HTML코드에 직접 자바 코드를 작성하는 방법을 알아보려고 한다.

<h3>📌 스크립트 태그 종류</h3>

<p><strong>1. 선언문(Declaration):</strong> <%! %>. 자바 변수나 메소드를 정의하는 데 사용하는 태그</p>

<p><strong>2. 스크립틀릿(Scriptlet):</strong> <% %>. 자바 변수 선언 및 자바 로직 코드를 작성하는 데 사용되는 태그</p>

<p><strong>3. 표현문(Expression):</strong> <%= %>. 변수, 계산식, 메소드 호출 결과를 나타내는 태그</p>

<p><strong>4. 지시자(Directive):</strong> <%@ %>. 페이지 속성 지정</p>

<p><strong>5. 주석(Comment):</strong> <%-- -->. 주석 처리. 이것을 HTML로 앞에 숫자를 달아줄 수 있게 태그를 달아줘</p>
