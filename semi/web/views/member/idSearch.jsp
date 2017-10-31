<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% 
    	String memberId = (String)request.getAttribute("member");
    	int success = 0;
    	if(request.getAttribute("success")!=null)
    		success = (int)request.getAttribute("success");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/semi/css/loginstyle.css">
</head>
<body>

  <div class="form">
<form class="login-form" action="/semi/msearch" method="post">
	<% if(success == 0){ %>
	<input type="text" name="membername"placeholder="이름"><br>
	<input type="text" name="memberno"placeholder="주민번호">
	<button value="idSearch">ID찾기</button>
	<% }else if(success==1){ %>
	<input type="text" value="검색결과 :<%= memberId %>" readonly="readonly">
	
	<% }else if(success==2){ %>
	<input type="text" value="일치하는 아이디가 없습니다." readonly="readonly">
	
	<% } %>
</form>
</div>
</body>
</html>