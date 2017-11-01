<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, donation.freeBoard.model.vo.FreeBoard"%>
<%
	FreeBoard fboard = (FreeBoard)request.getAttribute("fboard");

%>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>NoticeUpdateView</title>

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
	width:65px;
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
				<%@ include file="../../boardLeftBar.jsp"%>
			</div>
  
  <div class="col-md-8">

	
	<form action="/semi/fupdate" method="post" enctype="multipart/form-data">
	<input type="hidden" name="no" value="<%=fboard.getfreeBoardNo()%>"> 		
	<form action="/semi/fupdate" method="post" enctype="multipart/form-data">
	<table id="writetable">
	<th colspan="2">자유게시판 쓰기</th>
	
	<tr>
	<td id="category">분류</td>
	<td>	
	<select class="form-control">
 	 	<option>자유</option>
  		<option>후기</option>
	</select>
	</td>
	</tr>
	
	<tr><td id="title">제목</td> <td><input type="text" name="title" class="form-control" id="exampleInputEmail1" value="<%= fboard.getfreeBoardTitle()%>"></td>	</tr>
	<tr><td>작성자</td> <td><input type="text" name="writer" class="form-control" id="exampleInputEmail1" value="<%=fboard.getfreeBoardWriter() %>" readonly></td></tr>
	<tr><td>첨부파일</td> 
	<td>
	<%if(fboard.getOriginalImageName() != null){ %>
	<input type="file" name="file" value="<%=fboard.getOriginalImageName()%>">
	<%}else{ %>
	<input type="file" name="file" >
	<%} %></td>
	</tr>
	
	
	<tr><td colspan="2" id="textarea"><textarea rows="5" cols="50" name="content"  class="form-control"><%=fboard.getfreeBoardContent() %></textarea></td></tr>
	<tr><td colspan="2" align="right"><input type="submit" value="수정" class="btn btn-default">&nbsp; <input type="reset" value="취소" class="btn btn-default"></td></tr>
	</table>
	</form>

	</form>


	<div align="center">
	<a href="/semi/flist">목록</a>
	</div>


  </div>
	
	
  <div class="col-md-2">
  	  		<%if(member != null){ %>
	<%@ include file="../../boardLeftBar.jsp"%>
	<%}else{ %>
	<%@ include file="../../boardLeftBar2.jsp"%>	
	<%} %>
	</div>
  </div>

<%@ include file="../../footerbar.jsp" %>




</body>
</html>