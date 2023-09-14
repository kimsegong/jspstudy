<%@page import="java.net.URLEncoder"%>
<%@page import="java.io.FileWriter"%>
<%@page import="java.io.BufferedWriter"%>
<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

  // 요청 인코딩
  request.setCharacterEncoding("UTF-8");
  
  // 요청 파라미터
  String createdAt = request.getParameter("createdAt");
  String title = request.getParameter("title");
  String content = request.getParameter("content");
  
  // 요청 파라미터를 작성일자_제목.txt 파일에 저장하기
  
  // 저장할 디렉터리 경로
  String realPath = application.getRealPath("storage");
  
  // 저장할 디렉터리가 없으면 생성
  File dir = new File(realPath);
  if(!dir.exists()){
    dir.mkdirs();
  }
  
  // 저장할 파일명
  String filename = createdAt + "_" + title + ".txt";
  
  // 저장할 파일의 File 객체
  File file = new File(dir, filename);
  
  // 문자 기반 파일 출력 스트림 생성
  BufferedWriter bout = new BufferedWriter(new FileWriter(file));
  
  // 파일로 데이터 보내기 (파일 만들기)
  bout.write("제목 : " + title + "\n");
  bout.write("내용\n");
  bout.write(content);
  bout.flush();
  bout.close();
  
  // 파일 생성 여부를 확인하는 xx.jsp로 이동
  response.sendRedirect(request.getContextPath() + "/ex02_builtin_object/result.jsp?dir=storage&filename=" + URLEncoder.encode(filename, "UTF-8"));
  
%>