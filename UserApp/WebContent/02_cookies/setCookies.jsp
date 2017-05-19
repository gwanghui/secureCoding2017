<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%
Cookie c=new Cookie("user", "jeon2");
//보안 설정
//c.setMaxAge(60*60*24*365);            // 쿠키 유지 기간 - 1년
//c.setPath("/");
c.setHttpOnly(true);

response.addCookie(c); 
%>
server cookies setting <BR>
<a href="getCookies.html"/> getCookie</a>
