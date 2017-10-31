<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <% 
    	String memberId = null;
        if(request.getAttribute("member") !=null)
        	memberId = (String)request.getAttribute("member");
    	int success = 0;
    	if(request.getAttribute("success")!=null)
    		success = (int)request.getAttribute("success");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<link rel="stylesheet" href="/semi/css/loginstyle.css">
</head>
<body>
  <div class="form">
<form class="login-form" action="/semi/msearch" method="post">
	<% if(success == 0){ %>
	<input type="text" name="memberid"placeholder="아이디"><br>
	<input type="text" name="membername"placeholder="이름"><br>
	<input type="text" name="memberno"placeholder="주민번호">
	<button value="pwSearch">PW찾기</button>
	<% }else if(success==2){ %>
	<input type="text" value="일치하는 아이디가 없습니다." readonly="readonly">
	
	<% }else if(success==3){ %>
	<input type="text" value="비밀번호 변경이 완료되었습니다." readonly="readonly">
	<% } %>
</form>

	<% if(success==1){ %>
	<form class="login-form" action="/semi/mpwdupdate" method="post">
	<input type="password" id= "pwd1" name="pwd1"placeholder="변경하실 비밀번호를 입력해주세요"><br>
	<input type="password" id="pwd2" name="pwd2"placeholder="비밀번호 확인"><br>
	<button value="pwSearch"onclick="pwdupdate();return false;">PW변경</button>
	</form>
	<% }%>
</div>
<script type="text/javascript">
function pwdupdate(memberid){
	var pwd1 = document.getElementById("pwd1").value;
	var pwd2 = document.getElementById("pwd2").value;
	if(pwd1 != pwd2){
		alert("비밀번호가 일치하지않습니다.다시 입력해주세요.");
	}else{
		location.href="/semi/mpwdupdate?memberpwd=" + pwd1 + "&memberid=<%= memberId %>";
		
	}
}

</script>
</body>
</html>