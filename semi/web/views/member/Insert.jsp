<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"
   import="donation.member.model.vo.Member,java.util.ArrayList,java.sql.Date"%>

<%
      ArrayList<Member> list = (ArrayList<Member>)request.getAttribute("list");
   
   int flag1 = 0;
   int flag2 = 0;
   
   %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert member</title>
<link rel="stylesheet" href="/semi/css/loginstyle2.css">
</head>


<body>

   <h1 align="center"
      style="margin-top: 50px; font-size: 60pt; color: white;">
      <a href="/semi/index.jsp" style="color: white; text-decoration: none;">다재다능</a>
   </h1>
   <hr>




   <div class="login-page">
      <div class="form">

         <form class="login-form" action="/semi/minsert" method="post" id="login-form"name="login-form">
            <input type="text" id="memberid" placeholder="아이디" name="memberid" />
            <button onclick="return butn_confirm1(this);">중복확인</button>



            <input type="text" id="membername" placeholder="이름"
               name="membername" /> <input type="text" placeholder="주민번호(-제외)"
               name="memberno" id="memberno"/> <input type="password" id="pwd1"
               placeholder="비밀번호" name="memberpwd1" /> <input type="password"
               id="pwd2" placeholder="비밀번호 확인" name="memberpwd2" />
            <button type="button"onclick="return checkpwd();">중복확인</button>
            <input type="text" placeholder="닉네임" name="membernik" id="membernik" />

            <input type="text" placeholder="주소" name="memberaddress1" id="memberaddress1" /> <input
               type="text" placeholder="상세주소" name="memberaddress2" id="memberaddress2" /> <input
               type="text" placeholder="이메일" name="memberemail" id="memberemail"/> <input
               type="text" placeholder="전화번호" name="memberphone" id="memberphone" />

            <table>
               <tr>
                  <td><input type="checkbox" name="talent" class="talent" value="특기1"
                     style="width: 30px;">IT</td>
                  <td><input type="checkbox" name="talent" class="talent" value="특기2"
                     style="width: 30px;">디자인</td>
                  <td><input type="checkbox" name="talent" class="talent" value="특기3"
                     style="width: 30px;">마케팅</td>
               </tr>
               <tr>
                  <td><input type="checkbox" name="talent" class="talent" value="특기4"
                     style="width: 30px;">음악</td>
                  <td><input type="checkbox" name="talent" class="talent" value="특기5"
                     style="width: 30px;">노하우/상담</td>
                  <td><input type="checkbox" name="talent" class="talent" value="특기6"
                     style="width: 30px;">번역</td>
               </tr>
               <tr>
                  <td><input type="checkbox" name="talent" class="talent" value="특기7"
                     style="width: 30px;">건강</td>
                  <td><input type="checkbox" name="talent" class="talent" value="특기8"
                     style="width: 30px;">기타</td>

               </tr>
            </table>
            <button onclick="return insert();">create</button>

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
   
   
   function insert(){
	   
	   var chk = document.getElementsByName("talent"); // 체크박스객체를 담는다

	   var len = chk.length;    //체크박스의 전체 개수

	   var checkRow = '';      //체크된 체크박스의 value를 담기위한 변수

	   var checkCnt = 0;        //체크된 체크박스의 개수

	   var checkLast = '';      //체크된 체크박스 중 마지막 체크박스의 인덱스를 담기위한 변수

	   var talent = '';             //체크된 체크박스의 모든 value 값을 담는다

	   var cnt = 0;                 



	   for(var i=0; i<len; i++){

	   if(chk[i].checked == true){

	   checkCnt++;        //체크된 체크박스의 개수

	   checkLast = i;     //체크된 체크박스의 인덱스

	   }

	   } 
		

	   for(var i=0; i<len; i++){

	   if(chk[i].checked == true){  //체크가 되어있는 값 구분

	   checkRow = chk[i].value;
	   }
	               	

	   if(checkCnt == 1){                            //체크된 체크박스의 개수가 한 개 일때,

	   talent += checkRow;        //'value'의 형태 (뒤에 ,(콤마)가 붙지않게)

	   }else{                                            //체크된 체크박스의 개수가 여러 개 일때,

	   if(i == checkLast){                     //체크된 체크박스 중 마지막 체크박스일 때,

	   talent += checkRow;  //'value'의 형태 (뒤에 ,(콤마)가 붙지않게)

	   }else{
		   if(chk[i].checked == true){
	  		 talent += checkRow+",";	 //'value',의 형태 (뒤에 ,(콤마)가 붙게)         			
		   }
	   }

	   					

	   }

	   cnt++;

	   checkRow = '';    //checkRow초기화.

	   }
	   


	   
	   
	   
	   
	   var memberid = document.getElementById('memberid').value;   //아이디
	   var membername = document.getElementById('membername').value;	//이름
	   var memberno = document.getElementById('memberno').value;	//주민번호
	   var memberpwd1 = document.getElementById('pwd1').value;	//비번
	   var membernik = document.getElementById('membernik').value;	//닉네임
	   var memberaddress1 = document.getElementById('memberaddress1').value;	//주소
	   var memberaddress2 = document.getElementById('memberaddress2').value;	//상세주소
	   var memberemail = document.getElementById('memberemail').value;	//이메일
	   var memberphone = document.getElementById('memberphone').value;	//전화번호
	   //var talent = document.getElementById('talent').value;	//재능
	   
         var id = document.getElementById('memberid').value;
         var idtext = document.getElementById('memberid');
         var flag = 0; 
         
         if(id.length < 8){
           flag = 0;
         }
         else{
            flag = 1;
         }
         
         
         <%for(int i=0;i<list.size();i++){  %>
          if(id == '<%=list.get(i).getMemberId()%>')
             flag =0;
        <% } %>
      
        
        
        var pwd1 = document.getElementById('pwd1').value;
         var pwd2 = document.getElementById('pwd2').value;
         var flag2 = 0;
         
         if(pwd1 == pwd2){
            flag2 = 1;
            
           
         }else{
            flag2 = 0;
          
         }
      
      
      
      
       alert( flag );
       alert( flag2 );
      
      if(flag == 1 && flag2 == 1)
      {
         flag1 = 0;
         flag2 = 0;
         
         //서블릿으로 이동하는거 보내시면 됩니다.
         
         
       alert(memberid);
	   alert(membername);
	   alert(memberno);
	   alert(memberpwd1);
	   alert(membernik);
	   alert(memberaddress1);
	   alert(memberaddress2);
	   alert(memberemail);
	   alert(memberphone);
	   alert(talent);
	   if(membername == null||membername==""){
		   alert("이름을 입력해주세요.");
		   return false;
	   }else if(memberno ==null || memberno ==""){
		   alert("주민번호를 입력해주세요.");
		   return false;
	   }else if(memberpwd1==null||memberpwd1==""){
		alert("비밀번호를 입력해주세요.");  
		return false;
	   }else if(memberpwd1==null||memberpwd1==""){
		alert("닉네임을 입력해주세요.");   
		return false;
	   }else if(memberpwd1==null||memberpwd1==""){
		alert("주소를 입력해주세요.");  
		return false;
	   }else if(memberpwd1==null||memberpwd1==""){
		alert("이메일을 입력해주세요.");  
		return false;
	   }else if(memberpwd1==null||memberpwd1==""){
		alert("전화번호를 입력해주세요.");   
		return false;
	   }else{
       $('#login-form').submit();
       return true;
      }
       
         
      }
   
      
   }
   
   
   </script>
   <script src="/semi/js/loginjs.js"></script>
</body>
