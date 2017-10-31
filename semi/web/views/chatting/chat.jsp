<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="donation.category.vo.Category, java.sql.Date, java.util.*, donation.member.model.vo.Member" %>


<!-- 객체 생성 request 로 받음 -->
<%-- <% String chatRe = String.valueOf(request.getAttribute("chatRe")); %> --%>
<%-- <% String chatWriter = (String)session.getAttribute("chatWriter"); %> --%>
<% String reciver = String.valueOf(request.getAttribute("reciver")); %>


<!DOCTYPE html>
<html>
<head>
   <meta charset="UTF-8">
    <title>Chatting</title>    
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">      
</head>
<body>
   	<%@ include file = "../../header.jsp" %>
	<!-- 채팅 -->
	<div id="_chatbox" style="margin-top:180px; width:auto;">
	   <fieldset>
	        <textarea id="messageWindow" rows="10" cols="50" readonly="true"></textarea>
	        <br/>
	        <!-- enter 눌렀을 시 전송 설정 -->
	        <input id="inputMessage" type="text" onkeydown="if(event.keyCode==13){send();}">
	        <input type="submit" value="send" onclick="send()">
	    </fieldset>
	</div>   
</body>

   <!-- 채팅 -->   
   <script id="sochat" type="text/javascript">
   
   var textarea = document.getElementById("messageWindow");
   var webSocket = new WebSocket('ws://localhost:8888/semi/broadcasting');
   var inputMessage = document.getElementById('inputMessage');
   var sender = "<%= member.getMemberId() %>";
   var reciver = "<%= reciver %>";       
        
       webSocket.onerror = function(event) {
         onError(event)
       };
       
       webSocket.onopen = function(event) {
         onOpen(event)
       };
       
       webSocket.onmessage = function(event) {
         onMessage(event)
       };
       
       function onMessage(event) {
    	   var message = event.data.split(",");
    	   if(message[0]=="start") {
    		   textarea.value += message[1] + "\n";
    	   } else {
    	   var otherReciver = message[0];
    	   var otherSender = message[1];
    	   var content = message[2];
    	   if (otherReciver==reciver && otherSender==sender) {
           		textarea.value += reciver + " : " + content + "\n";
           		textarea.scrollTop = textarea.scrollHeight;
    	   }
    	   }
       }
       
       function onOpen(event) {
           textarea.value += sender + "님과 " + reciver + "님의 채팅방입니다.\n";
           /* var startMsg = sender + "님과 " + reciver + "님의 채팅방입니다."
    	   if(textarea.value==startMsg) {
    		   webSocket.send("start,"+sender+"님이 입장하셨습니다.");
    		   textarea.value += "\n"+sender+"님이 입장하셨습니다.\n";
    		   inputMessage.value = "";
    	   }  */
       }
       
       function onError(event) {
          alert(event.data);
       }
       
       function send() {
           textarea.value += sender + " : " + inputMessage.value + "\n";
           webSocket.send(sender+","+reciver+","+inputMessage.value);
           inputMessage.value = "";
           //채팅 전송시 항상 스크롤이가장 아래로  가게 설정
           textarea.scrollTop = textarea.scrollHeight;
       }    
  </script>  
  <!-- 채팅 끝 -->
</html>