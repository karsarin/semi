<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="donation.member.model.vo.Member" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원탈퇴</title>
<link rel="stylesheet" href="/semi/css/loginstyle.css">
</head>
<body>

	<%@ include file = "../../myPageLeftBar.jsp" %>
<br><br><br><br><br><br><br>
<div class="login-page" >
  <div class="form">
<h4 align="center"style="font-size: 12pt;">회원탈퇴를 위한 패스워드를 입력해주세요.</h4>
<br>

<div align="center">
<input type="password" id="inputpwd" value="" placeholder="password">
<input type="hidden" id="memberpwd" value="<%= member.getMemberPwd() %>">
<input type="hidden" name="memberid" value="<%= member.getMemberId() %>">
<br>
<button onclick="memberDelete();">탈퇴</button>
	<script type="text/javascript">



function memberDelete(){
	var memberPwd = document.getElementById("memberpwd").value;
	var inPwd = document.getElementById("inputpwd").value;
	if(inPwd != memberPwd){
		alert("비밀번호가 일치하지않습니다 다시입력해주세요.");
	}else{
		location.href="/semi/mdelete?inputpwd=" + inPwd + "&memberid=<%= member.getMemberId() %>";
		alert("회원탈퇴가 정상처리되었습니다.");
		
	}
	
}


</script>
 <script type="text/javascript">
   
   document.getElementById('inputpwd').focus();
   </script>
</div>
</div>
</div>

<script src="/semi/js/loginjs.js"></script>
</body>
</html>