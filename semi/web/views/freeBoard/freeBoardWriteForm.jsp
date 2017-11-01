<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>boardListView</title>
<script type="text/javascript">
	function insertPage()
	{
		location.href="/semi/finsert";
	}
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
	width:65px;
}

#textarea textarea{
height: 500px;
width:66vw;
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

	<form action="/semi/finsert" method="post" enctype="multipart/form-data">
	<table id="writetable">
	<th colspan="2" style="font-size:20px;">자유게시판 쓰기</th>
	
	<tr>
	<td id="category">분류</td>
	<td>	
	<select class="form-control" name="type">
 	 	<option>자유</option>
  		<option>후기</option>
	</select>
	</td>
	</tr>
	
	<tr><td id="title">제목</td> <td><input type="text" name="title" class="form-control" id="exampleInputEmail1" placeholder="제목을 입력하세요"></td>	</tr>
	<tr><td>작성자</td> <td><input type="text" name="writer" class="form-control" id="exampleInputEmail1" value="<%=member.getMemberId() %>" readonly></td></tr>
	<tr><td>이미지</td> <td><input type="file" name="file" id="exampleInputFile"></td></tr>
	<tr><td colspan="2" id="textarea"><textarea rows="5" cols="50" name="content"  class="form-control" placeholder="내용을 입력하세요"></textarea></td></tr>
	<tr><td colspan="2" align="right"><input type="submit" value="등록" class="btn btn-default">&nbsp; <input type="reset" value="취소" class="btn btn-default"></td></tr>
	</table>
	</form>
	
	
	
	<br>
	<div align="center">
	<a href="/semi/flist">목록</a>
    </div>


	


  </div>
	
	

  </div>
	


<%@ include file="../../footerbar.jsp" %>




</body>
</html>