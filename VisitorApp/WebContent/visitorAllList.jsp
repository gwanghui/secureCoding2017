<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
    <!-- 세션이 없으면 로그인을 유도한다. -->
  <%@ include file="sessionCheck.jsp" %>   
   
  <h1>방명록 리스트</h1>
  
  <table border="1">
  <tr>
  	<th>작성자</th><th>내용</th><th>작성날짜</th>  	
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