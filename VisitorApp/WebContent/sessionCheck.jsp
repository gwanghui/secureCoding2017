<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	if(session ==null || session.getAttribute("loginOK") ==null){
	%>
		<script> 
		alert("���� �α��� ���°� �ƴմϴ�. �α��� �ϼ���");
		location.href="controller?cmd=loginUI";
		</script>
	<%	
		return;
	}//if
%>
    ${sessionScope.loginOK }�� ȯ���մϴ�.
    <a href="controller?cmd=logoutAction">�α׾ƿ�</a> <br>