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
      <a href="../../index.jsp" style="color: white; text-decoration: none;">다재다능</a>
   </h1>
   <hr>




   <div class="login-page">
      <div class="form">

         <form class="login-form" method="post">
            <input type="text" id="memberid" placeholder="아이디" name="memberid" />
            <button onclick="butn_confirm1();return false;">중복확인</button>



            <input type="text" id="membername" placeholder="이름"
               name="membername" /> <input type="text" placeholder="주민번호(-제외)"
               name="memberno" /> <input type="password" id="pwd1"
               placeholder="비밀번호" name="memberpwd1" /> <input type="password"
               id="pwd2" placeholder="비밀번호 확인" name="memberpwd2" />
            <button onclick="checkpwd();return false;">중복확인</button>
            <input type="text" placeholder="닉네임" name="membernik" id="membernik" />

            <input type="text" placeholder="주소" name="memberaddress1" /> <input
               type="text" placeholder="상세주소" name="memberaddress2" /> <input
               type="text" placeholder="이메일" name="memberemail" /> <input
               type="text" placeholder="전화번호" name="memberphone" />

            <table>
               <tr>
                  <td><input type="checkbox" name="talent" value="특기1"
                     style="width: 30px;">IT</td>
                  <td><input type="checkbox" name="talent" value="특기2"
                     style="width: 30px;">디자인</td>
                  <td><input type="checkbox" name="talent" value="특기3"
                     style="width: 30px;">마케팅</td>
               </tr>
               <tr>
                  <td><input type="checkbox" name="talent" value="특기4"
                     style="width: 30px;">음악</td>
                  <td><input type="checkbox" name="talent" value="특기5"
                     style="width: 30px;">노하우/상담</td>
                  <td><input type="checkbox" name="talent" value="특기6"
                     style="width: 30px;">번역</td>
               </tr>
               <tr>
                  <td><input type="checkbox" name="talent" value="특기7"
                     style="width: 30px;">건강</td>
                  <td><input type="checkbox" name="talent" value="특기8"
                     style="width: 30px;">기타</td>

               </tr>
            </table>
            <button onclick="insert()">create</button>

         </form>

      </div>
      <div></div>
   </div>
   <script type="text/javascript">
   
   
   function butn_confirm1(){
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
   }
   
   function checkpwd(){
      var pwd1 = document.getElementById('pwd1').value;
      var pwd2 = document.getElementById('pwd2').value;
      
      if(pwd1 == pwd2){
         
         
         alert("확인되었습니다.");
      }else{
         alert("비밀번호가 같지 않습니다.");
      }
      
   }
   
   
   function insert(){
      
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
         
         location.href="/semi/minsert?memberid="+memberid
		 +"&membername="+membername+"&memberno"+memberno
		 +"&memberpwd1="+memberpwd1+"&membernik="+membernik
		 +"&memberaddress1="+memberaddress1+"&memberaddress2="+memberaddress2
		 +"&memberemail="+memberemail+"&memberphone="+memberphone+"&talent="+talent;
         
         
         
      }
      
      
   }
   
   
   </script>
   <script src="/semi/js/loginjs.js"></script>
</body>
