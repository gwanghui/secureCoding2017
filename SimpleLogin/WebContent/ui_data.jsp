<%@page import="org.json.simple.JSONArray"%>
<%@page import="java.util.Base64"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="javax.servlet.http.Cookie" %>
userSessionID <%=session.getId()%><br>
<%	//��Ű ��������
	Cookie[] clist=request.getCookies();
	//jdk 5.0 ������ ������ ó��(0���� ���۵Ǵ� �ּ�)
	for(Cookie tmp : clist){
		out.print(tmp.getValue() +"<br>");
	}
	//��Ű ����
	//Cookie user=new Cookie("user", "jeonhye0");
	JSONArray json = new JSONArray();
	json.add(Base64.getEncoder().encodeToString(
			new String("jeonhye0").getBytes() ));
	
	Cookie user=new Cookie("user",json.toJSONString());
	
	user.setHttpOnly(true);
	response.addCookie(user);
%>
<a href="javascript:alert(document.cookie)"> ���� ��Ű���� üũ</a> <br>