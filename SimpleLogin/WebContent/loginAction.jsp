<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%//1. ���� üũ - DBMS üũ
  //2. ������� ȭ�鿡 ���
  String id=request.getParameter("id");
%>
 <%=id.length()%> 
  <%=id.charAt(10)%> 