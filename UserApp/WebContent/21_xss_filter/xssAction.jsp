<%@page import="com.nhncorp.lucy.security.xss.XssFilter"%>
<%@page import="java.util.Scanner"%>
<%@page import="java.io.InputStream"%>
<%
String data=request.getParameter("data") ;

//1.secure coding
//data = data.replaceAll("<", "&lt");
//data = data.replaceAll(")();", "");
//data = data.replaceAll(")()", "");
//data = data.replaceAll(")", "");


//2. luycy-xss
XssFilter filter = XssFilter.getInstance("lucy-xss-superset.xml");
data = filter.doFilter(data);
%>
<h1>XSS Request Parameter Data</h1>
<%=data%>