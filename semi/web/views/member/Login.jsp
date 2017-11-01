<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="donation.member.model.vo.Member" %>
    <% Member member = (Member)session.getAttribute("member"); %>
    <% int loginCheck = 0;
    if(request.getAttribute("loginCheck")!=null){
    	loginCheck = (int)request.getAttribute("loginCheck");
    } %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
 <link rel="stylesheet" href="/semi/css/loginstyle.css">
</head>
<body>

<h1 align="center" style="margin-top:50px;font-size:60pt;color:white;"><a href="../../index.jsp" 
style="color:white;text-decoration:none;">다재다능</a></h1>
<hr>
	<% if(loginCheck ==1){ %>
	<script type="text/javascript">
		window.onload = function () {
		 	alert("아이디 혹은 비밀번호가 틀립니다.");
		 	location.href= "/semi/views/member/Login.jsp";
		}
	</script>
	<% } %>
  <div class="login-page">
  <div class="form">
    
	
    <form class="login-form" action="../../login" method="post"name ="" >
      <input type="text" placeholder="username" name="memberid" placeholder="아이디" id="memberid">
      <input type="password" placeholder="password"  name="memberpwd" placeholder="비밀번호" id="memberpwd">
      <button value="로그인">login</button>
      <br>
      <br>
      <button value="idSearch" style="width:150px;" onclick="window.open('/semi/views/member/idSearch.jsp','usage1','resizable=no ,width=490,left=500,top=100, height=270');return false">ID</button>
	  <button value="pwdSearch" style="width:150px;" onclick="window.open('/semi/views/member/pwdSearch.jsp','usage1','resizable=no ,width=490,left=500,top=100, height=330');return false">PW</button>
      
   </form>
   <script type="text/javascript">
   
   document.getElementById('memberid').focus();
   </script>
  
  </div>
</div>

  
    <script  src="/semi/js/loginjs.js"></script>





</div>
</body>
</html>