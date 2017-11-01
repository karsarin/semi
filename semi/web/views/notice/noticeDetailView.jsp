<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.util.*, donation.notice.model.vo.Notice"%>

<%
	Notice notice = (Notice) request.getAttribute("notice");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>noticeDetailView</title>

<script src="/semi/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
	$(function() {
		$('.main-menu ul #minfo').removeClass('active');
		$('.main-menu ul #home').removeClass('active');
		$('.main-menu ul #category').removeClass('active');
		$('.main-menu ul #board').addClass('active');
	});
</script>

<style type="text/css">
	
	#replyDiv{
	width:61vw;
	height:50px;
	border-top: 1px solid #BDBDBD;
	border-bottom: 1px solid #BDBDBD;
	padding-top : 5px;
	}
	
	#detailview {
	width: 66vw;
}

#title {
	width: 40vw;
}

#readCount {
	width: 7vw;
}

#date {
	width: 7vw;
}

#writer {
	width: 7vw;
}

#file {
	width: 10vw;
}

#detailTitlebar {
background-color: #F29661;
}

#textBox {
	height: 415px;
	font-size: 15px;
}

	
#replyview{
	width:62vw;
}
#commentWriter{
	color: black;
	font-weight: bold;
	
}
#commentContent{
	color: black;
	font-weight: bold;
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



</head>

<body>
	<%@ include file="../../headerbar.jsp"%>
	<%@ include file="../../rightList.jsp"%>


<script type="text/javascript">
	window.onload = function(){ 
		var memberid = "<%=member.getMemberId() %>";		
		$.ajax({url: "/semi/nreList",			
			data: {noticeNum :  $("#noticeNum").val()},
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
						
						+"<button id =\"deleteBtn\" class= \"btn btn-danger\" onclick=" + "commentDelete("+json.list[i].commentNum+","+json.list[i].noticeNum+")>삭제</button>"	
						
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
	
	function commentDelete(commentNum, noticeNum) {		
        var memberid = "<%=member.getMemberId() %>";		
		$.ajax({url: "/semi/ncommentDelete",			
			data: {noticeNum : noticeNum, commentNum : commentNum},
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
								
								+"<button id =\"deleteBtn\" class= \"btn btn-danger\" onclick=" + "commentDelete("+json.list[i].commentNum+","+json.list[i].noticeNum+")>삭제</button>"	
								
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

















	<%
		if (member != null && member.getMemberId().equals("admin")) {
	%>
	<div class="row" style="margin-top: 150px;">
		<%
			} else {
		%>
		<div class="row" style="margin-top: 200px;">
			<%
				}
			%>
			<div class="col-md-2">
				<%if(member != null){ %>
				<%@ include file="../../boardLeftBar.jsp"%>
				<%}else{ %>
				<%@ include file="../../boardLeftBar2.jsp"%>
				<%} %>
			</div>

			<div class="col-md-8">




				<table class="table table-hover" id="detailview">
					<input type="hidden" id="writer"
						value="<%=notice.getNoticeWriter() %>">
					<input type="hidden" id="commentWriter"
						value="<%=member.getMemberId()%>">
					<input type="hidden" id="noticeNum"
						value="<%=notice.getNoticeNo() %>">

					<tr id=detailTitlebar>


						<td id="titlie"><label><%=notice.getNoticeTitle()%></label></td>
						<td id="readCount"><label>조회:<%=notice.getReadCount()%></label></td>
						<td id="date"><label><%=notice.getNoticeDate()%></label></td>
						<td id="writer"><label><%=notice.getNoticeWriter()%></label></td>
						<td id="file"><label> <%
									if (notice.getOriginalFileName() != null) {
								%> <a
								href="/semi/nfdown?oname=<%=notice.getOriginalFileName()%>&rname=<%=notice.getRenameFileName()%>">
									<%=notice.getOriginalFileName()%></a> <%
 	} else {
 %> 첨부파일 없음 <%
 	}
 %>
						</label></td>
					<tr id="textBox" height="500px">
						<td colspan="5"><%=notice.getNoticeContent().replaceAll("\n","<br>")%></td>
					</tr>

					<%
						if (member.getMemberId().equals("admin")) { //include에서 sission값을 가지고있기 때문에 그냥 사용할 수 있다.
					%>
					<tr align="right">
						<td colspan="5"><a
							href="/semi/nupview?no=<%=notice.getNoticeNo()%>"
							style="margin-right: 10px">수정</a> <a
							href="/semi/ndel?no=<%=notice.getNoticeNo()%>"
							style="margin-right: 10px">삭제</a></td>
					</tr>
					<%
						}
					%>
				</table>








				<!-- 댓글 -->
				<!-- 댓글 입력-->
				<table>
					<tr>
						<td colspan="2">댓글</td>
					</tr>
					<tr>
						<td width="900px"><input type="text" class="form-control"
							name="replyinput" id="replyinput"></td>
						<td><input type="button" class="form-control"
							onclick="insertReply()" value="등록"><br></td>
					<tr>
				</table>
				<script type="text/javascript">
			
			function insertReply(){
			
			 var memberid = "<%=member.getMemberId() %>";		
				$.ajax({url:  "/semi/nreInsert",			
					data: {content : $("input[name=replyinput]").val() , writer : $("#commentWriter").val(), noticeNum : $("#noticeNum").val()},
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
										
										+"<button id =\"deleteBtn\" class= \"btn btn-danger\" onclick=" + "commentDelete("+json.list[i].commentNum+","+json.list[i].noticeNum+")>삭제</button>"	
										
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
				<div id="reply"></div>


				<div align="center">
					<a href="/semi/nlist">목록</a>
				</div>

			</div>
		</div>


		<%@ include file="../../footerbar.jsp"%></body>
</html>