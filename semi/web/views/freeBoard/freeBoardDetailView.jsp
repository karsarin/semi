<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,  donation.freeBoard.model.vo.FreeBoard, donation.freeBoard.model.vo.CommentBoard"%>
 
 <%
 FreeBoard fboard = (FreeBoard)request.getAttribute("fboard");
 CommentBoard cboard = (CommentBoard)request.getAttribute("cboard");
 %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>noticeDetailView</title>
<style type="text/css">
	
	
#replyDiv{
	width:61vw;
	height:50px;
	border-top: 1px solid #BDBDBD;
	border-bottom: 1px solid #BDBDBD;
	padding-top : 5px;
}
	
<!-- 테이블 -->
#detailview{
	width:66vw;
}

#textBox{
	height:415px;
	font-size : 15px;
}
#type{
width:5vw;
}
#title{

width:40vw;
}
#readCount{
width:5vw;
}
#date{ 
width:7vw;
}
#writer{
width:7vw;
}

#detailTitlebar{
background-color: #F29661;
color: #4C4C4C;
}
#textBox{
	height:200px;
	font-size : 15px;
}

<!-- 댓글 -->


	
#replyview{
	width:60vw;
}
#commentWriter{
	color: black;
	font-weight: bold; 
	
}
#commentContent{
	color: black;
}
#deleteBtn{
	height:50px;
	padding-bottom:10px;
	margin-left : 8px;


}
#replyinput{
	width:62vw;
}
	
</style>



<script type="text/javascript" src="/semi/js/jquery-3.2.1.min.js"></script>
<!-- 카테고리  -->

<%-- 헤더바 --%>
<link
	href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700,800'
	rel='stylesheet' type='text/css'>

<link rel="stylesheet" href="/semi/css/bootstrap.min.css">
<link rel="stylesheet" href="/semi/css/font-awesome.css">
<link rel="stylesheet" href="/semi/css/animate.css">
<link rel="stylesheet" href="/semi/css/templatemo_misc.css">
<link rel="stylesheet" href="/semi/css/templatemo_style.css">
<script src="js/vendor/modernizr-2.6.1-respond-1.1.0.min.js"></script>

<%-- 헤더바 끝 --%>



<body>
	
<%@ include file="../../headerbar.jsp" %>
<%@ include file="../../rightList.jsp"%>

<script type="text/javascript">
	window.onload = function(){ 
		var memberid = "<%=member.getMemberId() %>";		
		$.ajax({url: "/semi/reList",			
			data: {boardNum :  $("#boardNum").val()},
			  type: "get", 
			  success: function(data){
					
					
					var jsonStr = JSON.stringify(data); 				
					var json = JSON.parse(jsonStr); 					
					var values = $("#reply").html();						
					for(var i in json.list){
						
			 		if(memberid ==  decodeURIComponent(json.list[i].writer)){
			 		$("#reply").append(							
						"<div   id=\"replyDiv\"  style=\"float:left;  >" + "<label id=\"commentWriter\">"+  " 글쓴이 : " + "</label>" + decodeURIComponent(json.list[i].writer) + "<br>"  +"<label id=\"commentContent\">"+ "내용 : " + "</label>" + decodeURIComponent(json.list[i].content) 
					
					
						+"</div>" + "<div>" 
						
						+"<button id =\"deleteBtn\" class= \"btn btn-danger\" onclick=" + "commentDelete("+json.list[i].commentNum+","+json.list[i].boardNum+")>삭제</button>"	
						
						+"<div>" +"<br style=\"clear:left\">"); 
						
					}else{
						
						
						$("#reply").append(							
								"<div id=\"replyDiv\">" + "<label id=\"commentWriter\">"+  " 글쓴이 : " + "</label>" + decodeURIComponent(json.list[i].writer) + "<br>"  +"<label id=\"commentContent\">"+ "내용 : " + "</label>" + decodeURIComponent(json.list[i].content) 
								+"</div>" +"<br>");					
					}					
					}			
				},
			  error : function(data){  //실패했을 때 구동되는 함수
				  consolse.log("에러발생 : " + data);
			  }
			
		});			

	}
	
	function commentDelete(commentNum, boardNum) {		
        var memberid = "<%=member.getMemberId() %>";		
		$.ajax({url: "/semi/commentDelete",			
			data: {boardNum : boardNum, commentNum : commentNum},
			  type: "get", 
			  success: function(data){
					var jsonStr = JSON.stringify(data);  
				
					var json = JSON.parse(jsonStr); 
					
					$("#reply").html("");
					for(var i in json.list){
			 		if(memberid ==  decodeURIComponent(json.list[i].writer)){

			 			$("#reply").append(							
								"<div   id=\"replyDiv\"  style=\"float:left;  >" + "<label id=\"commentWriter\">"+  " 글쓴이 : " + "</label>" + decodeURIComponent(json.list[i].writer) + "<br>"  +"<label id=\"commentContent\">"+ "내용 : " + "</label>" + decodeURIComponent(json.list[i].content) 
							
							
								+"</div>" + "<div>" 
								
								+"<button id =\"deleteBtn\" class= \"btn btn-danger\" onclick=" + "commentDelete("+json.list[i].commentNum+","+json.list[i].boardNum+")>삭제</button>"	
								
								+"<div>" +"<br style=\"clear:left\">"); 
					}else{
						$("#reply").append(							
								"<div id=\"replyDiv\">" + "<label id=\"commentWriter\">"+  " 글쓴이 : " + "</label>" + decodeURIComponent(json.list[i].writer) + "<br>"  +"<label id=\"commentContent\">"+ "내용 : " + "</label>" + decodeURIComponent(json.list[i].content) 
								+"</div>" +"<br>");					
					}					
					}			
				},
			  error : function(data){  //실패했을 때 구동되는 함수
				  consolse.log("에러발생 : " + data);
			  }
		});			
        
	} 
	
</script>

<%if(member!=null && member.getMemberId().equals("admin")) {%>
<div class="row" style="margin-top:150px;">
<%} else {%>
<div class="row" style="margin-top:200px;">
<%}%>
			<div class="col-md-2">
<%if( !(member != null) || member.getMemberId().equals("admin")) {%>
	
	<%@ include file="../../boardLeftBar2.jsp"%>
	<%}else{ %>
		
	<%@ include file="../../boardLeftBar.jsp"%>
	<%} %> 
			</div>
  <div class="col-md-8">

	<!-- 게시글 -->
	<table  class="table table-hover" id="detailview">
	<tr id = "detailTitlebar">
	
		<input type="hidden" id="writer" value="<%=fboard.getfreeBoardWriter() %>">
		<input type="hidden" id="commentWriter" value="<%=member.getMemberId() %>">
		<input type="hidden" id="boardNum" value="<%=fboard.getfreeBoardNo() %>">
		
		<td id="type"><label><%= fboard.getBoardType() %></label></td> 
	
		
		<td id="titlie"><label><%= fboard.getfreeBoardTitle() %></label></td>
		<td id="readCount"><label>조회:<%=fboard.getReadCount() %></label></td>
		<td id="date"><label><%=fboard.getfreeBoardDate() %></label></td>
		<td id="writer"><label><%=fboard.getfreeBoardWriter() %></label></td>
		
		
	<tr id="textBox">
		<td colspan="6" height="415px">
		<%if(fboard.getOriginalImageName() != null){	%>	
			
		
			<img src="/semi/uploadfiles/fuploadfiles/<%=fboard.getRenameImageName()%>" width="400px" height="400px" title="클릭하시면 원본크기로 보실 수 있습니다."
   				  style="cursor: pointer;" onclick="doImgPop('/semi/uploadfiles/fuploadfiles/<%=fboard.getRenameImageName()%>')"  />
			<script>
			function doImgPop(img){ 
				 img1= new Image(); 
				 img1.src=(img); 
				 imgControll(img); 
				} 
				  
				function imgControll(img){ 
				 if((img1.width!=0)&&(img1.height!=0)){ 
				    viewImage(img); 
				  } 
				  else{ 
				     controller="imgControll('"+img+"')"; 
				     intervalID=setTimeout(controller,20); 
				  } 
				}
				function viewImage(img){ 
				 W=img1.width; 
				 H=img1.height; 
				 O="width="+W+",height="+H+",scrollbars=yes"; 
				 imgWin=window.open("","",O); 
				 imgWin.document.write("<html><head><title>원본 이미지 보기</title></head>");
				 imgWin.document.write("<body topmargin=0 leftmargin=0>");
				 imgWin.document.write("<img src="+img+" onclick='self.close()' style='cursor:pointer;' title ='클릭하시면 창이 닫힙니다.'>");
				 imgWin.document.close();
				}
			</script>
		
			<%=fboard.getfreeBoardContent().replaceAll("\n","<br>") %>
		<%}else{ %> 			
			<%=fboard.getfreeBoardContent().replaceAll("\n","<br>") %>
			<%} %>
		</td>
	
	</tr>

	<%if(member.getMemberId().equals(fboard.getfreeBoardWriter()) || member.getMemberId().equals("admin")) { %>
	<tr><td colspan="6" align="right">
		<%if(member.getMemberId().equals(fboard.getfreeBoardWriter())) { %>
		<a href="/semi/fupview?no=<%=fboard.getfreeBoardNo()%>">수정</a> &nbsp;
		<%} %> 
		<a href="/semi/fdel?no=<%=fboard.getfreeBoardNo()%>">삭제</a>
	</td></tr>
	<%} %>
	 
	</table>
	<!-- 게시글 -->


	<!-- 댓글 입력-->
		<table>
		<tr><td colspan="2">댓글</td></tr>
		<tr><td width="900px">
		<input type="text" class="form-control"  name="replyinput" id="replyinput">
		</td>
		<td>
		<input type="button" class="form-control" onclick="insertReply()" value="등록" ><br>
		</td>
		<tr>
		</table>
			<script type="text/javascript">
			
			function insertReply(){
			
			 var memberid = "<%=member.getMemberId() %>";		
				$.ajax({url:  "/semi/reInsert",			
					data: {content : $("input[name=replyinput]").val() , writer : $("#commentWriter").val(), boardNum : $("#boardNum").val()},
					  type: "get", 
					  success: function(data){
							//console.log(data);
							$("#replyinput").val("");
							var jsonStr = JSON.stringify(data);  //객체를 문자열로 변환
							//console.log(jsonStr);
							var json = JSON.parse(jsonStr); //문자열을 배열 객체로 바꿈
							
							//var values = $("#reply").html();	
							
							$("#reply").html("");
							
							
							for(var i in json.list){
								
					 		if(memberid ==  decodeURIComponent(json.list[i].writer)){
						 
					 		$("#reply").append(							
										"<div   id=\"replyDiv\"  style=\"float:left;  >" + "<label id=\"commentWriter\">"+  " 글쓴이 : " + "</label>" + decodeURIComponent(json.list[i].writer) + "<br>"  +"<label id=\"commentContent\">"+ "내용 : " + "</label>" + decodeURIComponent(json.list[i].content) 
										+"</div>" + "<div>" 
										+"<button id =\"deleteBtn\" class= \"btn btn-danger\" onclick=" + "commentDelete("+json.list[i].commentNum+","+json.list[i].boardNum+")>삭제</button>"	
										+"<div>" +"<br style=\"clear:left\">"); 
								 
							}else{
								$("#reply").append(							
										"<div id=\"replyDiv\">" + "<label id=\"commentWriter\">"+  " 글쓴이 : " + "</label>" + decodeURIComponent(json.list[i].writer) + "<br>"  +"<label id=\"commentContent\">"+ "내용 : " + "</label>" + decodeURIComponent(json.list[i].content) 
										+"</div>" +"<br>");					
							}					
							}			
						},
					  error : function(data){  //실패했을 때 구동되는 함수
						  consolse.log("에러발생 : " + data);
					  }
					
				});			
		        
	}
			
			
			
			
	</script>
			
	<!-- 댓글 표시될 공간 -->
	<div id="reply">
	</div>
			

		
	<div align ="center">
		<a href="/semi/flist">목록</a>
    </div>	
</div>	

	
	
	
<%@ include file="../../footerbar.jsp" %>




</body>
</html>