<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%//1. 인증 체크 - DBMS 체크
  //2. 결과값을 화면에 출력
  String id=request.getParameter("id");
%>
 <%=id.length()%> 
  <%=id.charAt(10)%> 