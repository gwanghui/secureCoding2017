<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
 
 <%@ include file="sessionCheck.jsp" %>   
    
    
<h1>���� �ۼ�</h1>
<form action="controller?cmd=visitorInsertAction" method="post">
		�ۼ��� id : <input type="text" name="id" 
		                                           value="${sessionScope.loginOK}"><br>
		�� ��й�ȣ : <input type="password" name="visitor_pw"> <br>
		���� : <br>
		<textarea rows="10" cols="50" name="contents" ></textarea>
		<br>
		<input type="submit" value="���� �ۼ�" >
		<input type="reset" value=" �� �� "  >
</form>

<br>
 <jsp:include page="visitorMenu.jsp" />