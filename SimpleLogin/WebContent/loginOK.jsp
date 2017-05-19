<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<% String id=session.getAttribute("loginOK").toString(); 
   String name=request.getAttribute("loginName").toString();
%>
{"loginId" : "<%=id%>", "loginName" : "<%=name%>"}