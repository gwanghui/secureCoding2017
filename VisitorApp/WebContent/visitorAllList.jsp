<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
    <!-- ������ ������ �α����� �����Ѵ�. -->
  <%@ include file="sessionCheck.jsp" %>   
   
  <h1>���� ����Ʈ</h1>
  
  <table border="1">
  <tr>
  	<th>�ۼ���</th><th>����</th><th>�ۼ���¥</th>  	
  </tr>
  <c:forEach var="visitorVO" items="${visitorAllList}" >
  <tr>
  	<td>${visitorVO.memberId }</td>
  	<td>${visitorVO.contents }</td>
  	<td>${visitorVO.inDate }</td>  	
  </tr>
 </c:forEach>
 </table>
 
 <br>
 <img src="img/logo.png">	
 <jsp:include page="visitorMenu.jsp" />