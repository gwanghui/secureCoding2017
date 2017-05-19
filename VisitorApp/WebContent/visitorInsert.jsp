<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
 
 <%@ include file="sessionCheck.jsp" %>   
    
    
<h1>방명록 작성</h1>
<form action="controller?cmd=visitorInsertAction" method="post">
		작성자 id : <input type="text" name="id" 
		                                           value="${sessionScope.loginOK}"><br>
		글 비밀번호 : <input type="password" name="visitor_pw"> <br>
		내용 : <br>
		<textarea rows="10" cols="50" name="contents" ></textarea>
		<br>
		<input type="submit" value="방명록 작성" >
		<input type="reset" value=" 취 소 "  >
</form>

<br>
 <jsp:include page="visitorMenu.jsp" />