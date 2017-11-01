<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="donation.member.model.vo.Member,java.util.ArrayList,java.sql.Date"%>

<%
      ArrayList<Member> list = (ArrayList<Member>)request.getAttribute("list");
   
   int flag1 = 0;
   int flag2 = 0;
   
   boolean insertR = true;
   
   %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert member</title>
<link rel="stylesheet" href="/semi/css/loginstyle2.css">
<script type="text/javascript" src="/semi/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
	function insert(){
	   var result = true;
	   <%insertR=true;%>
	   
	   var memberId = $('input[name="memberid"]').val();
	   var memberName = $('input[name="membername"]').val();
	   var memberNo = $('input[name="memberno"]').val();
	   var memberPwd = $('input[name="memberpwd1"]').val();
	   var memberPwdCk = $('input[name="memberpwd2"]').val();
	   var memberNik = $('input[name="membernik"]').val();
	   var memberAddress = $('input[name="memberaddress1"]').val();
	   var memberAddressDetail = $('input[name="memberaddress2"]').val();
	   var memberEmail = $('input[name="memberemail"]').val();
	   var memberPhone = $('input[name="memberphone"]').val();
	   
	   //alert(memberId+"\n"+memberName+"\n"+memberNo+"\n"+memberPwd+"\n"+memberPwdCk+"\n"+memberNik+"\n"+memberAddress+"\n"+memberAddressDetail+"\n"+memberEmail+"\n"+memberPhone);
	   
	   var allData = {"memberId":memberId, "memberNo":memberNo, "memberPwd":memberPwd, "memberNik":memberNik, "memberPhone":memberPhone};
		$.ajax({url:"/semi/menrollcheck",
				data:allData,
				type:"post",
				success:function(data){
						if(data!="success") {
							if(data=="글자수초과") {alert("아이디 또는 비밀번호 최대 글자 수를 조과하였습니다."); <%insertR = false;%>}
							else if(data=="영문자와숫자만") {alert("아이디와 비밀번호는 영문자와 숫자만 입력가능합니다."); <%insertR = false;%>}
							else if(data=="영문자와숫자모두") {alert("아이디와 비밀번호는 영문자와 숫자의 조합으로 입력하세요."); <%insertR = false;%>}
							else if(data=="ID중복") {alert("ID가 중복되었습니다.\n다른 ID를 입력해주세요."); <%insertR = false;%>}
							else if(data=="주민확인") {alert("주민등록번호를 확인하세요."); <%insertR = false;%>}
							else if(data=="닉네임중복") {alert("닉네임이 중복되었습니다.\n다른 닉네임을 입력해주세요."); <%insertR = false;%>}
							else if(data=="번호확인") {alert("전화번호를 확인해주세요."); <%insertR = false;%>}
						} else {<%insertR=true;%>}
				 },
				 error:function(data){
						console.log("에러 발생 : "+data);
				 }
			});
		result = <%=insertR%>;
		
	   if(memberId=="" || memberName=="" || memberNo=="" || memberPwd=="" || memberPwdCk==""
		 || memberNik=="" || memberAddress=="" || memberAddressDetail=="" 
		 || memberEmail=="" || memberPhone==""){ alert("모든 항목을 입력하세요."); result=false; }
	   
	   else if(memberPwd!=memberPwdCk) { alert("비밀번호를 확인하세요."); result=false;}	   
	   
	   return result;
	}
</script>
</head>


<body>

	<h1 align="center"
		style="margin-top: 50px; font-size: 60pt; color: white;">
		<a href="/semi/index.jsp" style="color: white; text-decoration: none;">다재다능</a>
	</h1>
	<hr>




	<div class="login-page">
		<div class="form">

			<form class="login-form" action="/semi/minsert" method="post" id="login-form" name="login-form" onSubmit="return insert();">
				<input type="text" id="memberid" placeholder="아이디" name="memberid" value="wltjs1796"/>



				<input type="text" id="membername" placeholder="이름"
					name="membername" value="윤지선"/> <input type="text" placeholder="주민번호(-제외)"
					name="memberno" id="memberno" value="9510102200614"/> <input type="password" id="pwd1"
					placeholder="비밀번호" name="memberpwd1" /> <input type="password"
					id="pwd2" placeholder="비밀번호 확인" name="memberpwd2" />
				<input type="text" placeholder="닉네임" name="membernik" id="membernik" value="지선짱짱" />

				<input type="text" placeholder="주소" name="memberaddress1"
					id="memberaddress1" value="경기도 안산시 단원구"/> <input type="text" placeholder="상세주소"
					name="memberaddress2" id="memberaddress2" value="222-2번지"/> <input type="text"
					placeholder="이메일" name="memberemail" id="memberemail" value="wltjs1796@naver.com"/> <input
					type="text" placeholder="전화번호" name="memberphone" id="memberphone" value="01062436597"/>

				<table>
					<tr>
						<td><input type="checkbox" name="talent" class="talent"
							value="특기1" style="width: 30px;">IT</td>
						<td><input type="checkbox" name="talent" class="talent"
							value="특기2" style="width: 30px;">디자인</td>
						<td><input type="checkbox" name="talent" class="talent"
							value="특기3" style="width: 30px;">마케팅</td>
					</tr>
					<tr>
						<td><input type="checkbox" name="talent" class="talent"
							value="특기4" style="width: 30px;">음악</td>
						<td><input type="checkbox" name="talent" class="talent"
							value="특기5" style="width: 30px;">노하우/상담</td>
						<td><input type="checkbox" name="talent" class="talent"
							value="특기6" style="width: 30px;">번역</td>
					</tr>
					<tr>
						<td><input type="checkbox" name="talent" class="talent"
							value="특기7" style="width: 30px;">건강</td>
						<td><input type="checkbox" name="talent" class="talent"
							value="특기8" style="width: 30px;">기타</td>

					</tr>
				</table>
				<!-- <button onclick="return insert();">create</button> -->
				<button type="submit">create</button>

			</form>

		</div>
		<div></div>
	</div>
	<script type="text/javascript">
		
	
   
   function butn_confirm1(event){
	   
      var id = document.getElementById('memberid').value;
      var idtext = document.getElementById('memberid');
      var flag = 0; 
      
      <%for(int i=0;i<list.size();i++){  %>
            if(id == '<%=list.get(i).getMemberId()%>')
               flag =1;
      <% } %>
      
      
      if(id.length < 8){
         alert("8자리 이상해주세요.");
         idtext.value="";
      }else if(flag == 1){
         
         alert("아이디가 중복입니다.");
      }
      
      else{
      
         
         alert("확인되었습니다.");
      }
      return false;
   }
   
   function checkpwd(){
      alert("확인");
	  var pwd1 = document.getElementById('pwd1').value;
      var pwd2 = document.getElementById('pwd2').value;
      if(id.length < 8){
          alert("8자리 이상해주세요.");
          idtext.value="";
          else if(pwd1 == pwd2){
         
         
         alert("확인되었습니다.");
      }else{
         alert("비밀번호가 같지 않습니다.");
      }
          
      return false;
   }
   </script>
	<script src="/semi/js/loginjs.js"></script>
</body>