<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="donation.question.model.vo.Question, java.sql.Date, java.util.*" %>
<%
	Question q = (Question)request.getAttribute("question");
	int currentPage = ((Integer)request.getAttribute("currentPage")).intValue();
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>QuestionDetailView</title>

<script src="/semi/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
	$(function() {
		$('.main-menu ul #minfo').removeClass('active');
		$('.main-menu ul #home').removeClass('active');
		$('.main-menu ul #category').removeClass('active');
		$('.main-menu ul #board').addClass('active');
	});
</script>

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

<style>

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

#detailTitlebar {
background-color: #F29661; 
}

#textBox {
	height: 415px;
	font-size: 15px;
}

</style>






</head>

<body>

<%@ include file="../../headerbar.jsp" %>
<%@ include file="../../rightList.jsp"%>
<%if(member!=null && member.getMemberId().equals("admin")) {%>
<div class="row" style="margin-top:150px;">
<%} else {%>
<div class="row" style="margin-top:200px;">
<%}%>
  			<div class="col-md-2">
				  		<%if(member != null){ %>
	<%@ include file="../../boardLeftBar.jsp"%>
	<%}else{ %>
	<%@ include file="../../boardLeftBar2.jsp"%>	
	<%} %>
			</div>
  
  <div class="col-md-8">

	

<table  class="table table-hover" id="detailview">
<tr id = "detailTitlebar">
<td id="titlie"><label><%= q.getQuestionTitle() %></label></td>
<td id="readCount"><label>조회수 : <%= q.getQuestionReadCount() %></label></td>
<td id="date"><label><%= q.getQuestionDate() %> </label></td>
<td id="writer"><label><%= q.getQuestionWriter() %></label></td>

</tr>	
	

<tr id="textBox">
		<td colspan="6" height="415px">
		<%if(q.getQuestionOriginalImageName() != null){	%>	
			
		
			<img src="/semi/uploadfiles/quploadfiles/<%=q.getQuestionRenameImageName()%>" width="400px" height="400px" title="클릭하시면 원본크기로 보실 수 있습니다."
   				  style="cursor: pointer;" onclick="doImgPop('/semi/uploadfiles/quploadfiles/<%=q.getQuestionRenameImageName()%>')"  />
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
		
			<%=q.getQuestionContent().replaceAll("\n","<br>") %>
		<%}else{ %> 			
			<%=q.getQuestionContent().replaceAll("\n","<br>") %>
			<%} %>
		</td>
	
	</tr>

 



<tr><td colspan="5" align="right">
<%  if(member != null){ 
	if(member.getMemberId().equals("admin")) {%>
	<%--쿼리스트링에는 반드시 공백 사용하면 안됨 다 붙여서 써야됨 꼭 --%>
	<a href="/semi/views/question/questionReplyForm.jsp?no=<%= q.getQuestionNum() %>&page=<%= currentPage %>">[답글]</a>
	&nbsp;<a href="/semi/qdelete?no=<%= q.getQuestionNum() %>">[삭제]</a>
<%  } else if(member.getMemberId().equals(q.getQuestionWriter())){ %>
	<a href="/semi/qupview?no=<%= q.getQuestionNum() %>&page=<%= currentPage %>">[수정]</a>
	&nbsp;<a href="/semi/qdelete?no=<%= q.getQuestionNum() %>">[삭제]</a>
<%  }} %>
</td></tr>
</table>



	<br>
	<div align="center">
	<a href="/semi/qlist?page=<%=currentPage %>">목록</a>
    </div>


	

  </div>
  </div>
 </div>

<%@ include file="../../footerbar.jsp" %>


</body>
</html>
