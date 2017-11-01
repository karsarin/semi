<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import ="donation.question.model.vo.Question" %>

<% Question question = (Question)request.getAttribute("question");
	int currentPage = ((Integer)request.getAttribute("currentPage")).intValue();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>boardUpdateView</title>

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

#writetable{
width:66vw;
}
#title{
	width:80px;
}

#textarea textarea{
width:66vw;
height:200px;
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

	
	<%
		//원글일 때 
		if(question.getQuestionLevel() == 0){	%>
	
	<form action="/semi/qupdate0" method="post" enctype="multipart/form-data">
	<input type="hidden" name="no" value="<%=question.getQuestionNum() %>"> 
	<input type="hidden" name="ofile" value="<%=question.getQuestionOriginalImageName()%>">
	<input type="hidden" name="rfile" value="<%=question.getQuestionRenameImageName()%>">
	<input type="hidden" name="page" value="<%=currentPage %>">
		
	<table id="writetable">
	<th colspan="2">QnA 글 수정</th>
	
	<tr><td id="title">제목</td> <td><input type="text" name="title" class="form-control" id="exampleInputEmail1" value="<%=question.getQuestionTitle()%>"></td>	</tr>
	<tr><td>작성자</td> <td><input type="text" name="writer" class="form-control" id="exampleInputEmail1" value="<%=question.getQuestionWriter()%>" readonly></td></tr>
	<tr><td>첨부파일</td> 
	<td>
	<%if(question.getQuestionOriginalImageName() != null){ %>
	<input type="file" name="file" value="<%= question.getQuestionOriginalImageName()%>">
	<%}else{ %>
	<input type="file" name="file" >
	<%} %>
	</td></tr>
	<tr><td colspan="2" id="textarea"><textarea rows="5" cols="50" name="content"  class="form-control" ><%=question.getQuestionContent()%></textarea></td></tr>
	<tr><td colspan="2" align="right"><input type="submit" value="수정" class="btn btn-default">&nbsp; <input type="reset" value="취소" class="btn btn-default"></td></tr>
	</table>


	</form>
	
	<%}else{   //댓글일 때%> 
	<form action="/semi/qupdate1" method="post">
		<input type="hidden" name="no" value="<%=question.getQuestionNum() %>">
		<input type="hidden" name="page" value="<%=currentPage %>">

	<table id="writetable">
	<th colspan="2">QA 답글 수정</th>
	
	<tr><td id="title">제목</td> <td><input type="text" name="title" class="form-control" id="exampleInputEmail1" value="<%=question.getQuestionTitle()%>"></td>	</tr>
	<tr><td>작성자</td> <td><input type="text" name="writer" class="form-control" id="exampleInputEmail1" value="<%=question.getQuestionWriter()%>" readonly></td></tr>
	<tr><td colspan="2" id="textarea"><textarea rows="5" cols="50" name="content"  class="form-control" ><%=question.getQuestionContent()%></textarea></td></tr>
	<tr><td colspan="2" align="right"><input type="submit" value="수정하기" class="btn btn-default">&nbsp; <input type="reset" value="취소하기" class="btn btn-default"></td></tr>
	</table>



	</form>
	<%} %>
	
	
	
	<div align = "center">
	<a href="javascript:history.go(-1);">이전 페이지로</a>
	</div>
	
	

  </div>
  </div>

<%@ include file="../../footerbar.jsp" %>


</body>
</html>


