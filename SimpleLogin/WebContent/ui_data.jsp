<%@page import="org.json.simple.JSONArray"%>
<%@page import="java.util.Base64"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="javax.servlet.http.Cookie" %>
userSessionID <%=session.getId()%><br>
<%	//쿠키 가져오기
	Cookie[] clist=request.getCookies();
	//jdk 5.0 열거형 데이터 처리(0부터 시작되는 주소)
	for(Cookie tmp : clist){
		out.print(tmp.getValue() +"<br>");
	}
	//쿠키 전달
	//Cookie user=new Cookie("user", "jeonhye0");
	JSONArray json = new JSONArray();
	json.add(Base64.getEncoder().encodeToString(
			new String("jeonhye0").getBytes() ));
	
	Cookie user=new Cookie("user",json.toJSONString());
	
	user.setHttpOnly(true);
	response.addCookie(user);
%>
<a href="javascript:alert(document.cookie)"> 현재 쿠키정보 체크</a> <br>