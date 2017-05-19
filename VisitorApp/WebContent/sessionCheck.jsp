<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	if(session ==null || session.getAttribute("loginOK") ==null){
	%>
		<script> 
		alert("현재 로그인 상태가 아닙니다. 로그인 하세요");
		location.href="controller?cmd=loginUI";
		</script>
	<%	
		return;
	}//if
%>
    ${sessionScope.loginOK }님 환영합니다.
    <a href="controller?cmd=logoutAction">로그아웃</a> <br>