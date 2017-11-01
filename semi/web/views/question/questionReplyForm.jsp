<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	int no = Integer.parseInt(request.getParameter("no"));
	int currentPage = Integer.parseInt(request.getParameter("page"));
	
%>    
<!DOCTYPE html >
<html>
<head>
<meta charset="UTF-8">
<title>boardReplyForm</title>

 
<script src="/semi/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
	$(function() {
		$('.main-menu ul #minfo').removeClass('active');
		$('.main-menu ul #home').removeClass('active');
		$('.main-menu ul #category').removeClass('active');
		$('.main-menu ul #board').addClass('active');
	});
</script>

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
height:200px;
}


</style>
<!-- 세로목록 끝 -->



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
<%if( !(member != null) || member.getMemberId().equals("admin")) {%>
	
	<%@ include file="../../boardLeftBar2.jsp"%>
	<%}else{ %>
		
	<%@ include file="../../boardLeftBar.jsp"%>
	<%} %> 
			</div>
  <div class="col-md-8">

	
<form action="/semi/qreply" method="post">
	<input type="hidden" name="no" value="<%=no %>">
	<input type="hidden" name="page" value="<%=currentPage %>">
	<table id="writetable">
	<th colspan="2">답글 쓰기</th>
	
	<tr><td id="title">제목</td> <td><input type="text" name="title" class="form-control" id="exampleInputEmail1" placeholder="제목을 입력하세요"></td>	</tr>
	<tr><td>작성자</td> <td><input type="text" name="writer" class="form-control" id="exampleInputEmail1" value="<%=member.getMemberId() %>" readonly></td></tr>
	<tr><td colspan="2" id="textarea"><textarea rows="5" cols="50" name="content"  class="form-control" placeholder="내용을 입력하세요"></textarea></td></tr>
	<tr><td colspan="2" align="right"><input type="submit" value="등록" class="btn btn-default">&nbsp; <input type="reset" value="취소" class="btn btn-default"></td></tr>
	</table>
	</form>




	<div align="right">
	<a href="/semi/qlist?page=<%=currentPage%>">목록</a>
    </div>

	

  </div>
	
	
  <div class="col-md-2">
  	<%@ include file="../../rightList.jsp"%>
	</div>
  </div>
  
	
<%@ include file="../../footerbar.jsp" %>


</body>
</html>
