<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%System.out.println("start"); %>
<%Thread.sleep(5000); %>
서버에서 전달받은 세션 아이디는 기본적으로는 쿠키에 저장
jsessionId : <%=session.getId()%>