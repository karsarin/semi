<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*, donation.notice.model.vo.Notice"%>
<%
ArrayList<Notice> list = (ArrayList<Notice>)request.getAttribute("list");
int listCount = ((Integer)request.getAttribute("listSearchCount")).intValue();
int currentPage = ((Integer)request.getAttribute("currentPage")).intValue();
int startPage = ((Integer)request.getAttribute("startPage")).intValue();
int endPage = ((Integer)request.getAttribute("endPage")).intValue();
int maxPage = ((Integer)request.getAttribute("maxPage")).intValue();
String keyword  = (String)request.getAttribute("keyword");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>boardListView</title>

<script src="/semi/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
	$(function() {
		$('.main-menu ul #minfo').removeClass('active');
		$('.main-menu ul #home').removeClass('active');
		$('.main-menu ul #category').removeClass('active');
		$('.main-menu ul #board').addClass('active');
	});
</script>

<script type="text/javascript">
	function insertPage()
	{
		location.href="views/notice/noticeWriteForm.jsp";
		return false;
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
ul#navi {
	width: 200px;
	text-indent: 10px;
	background-color: lightgray;
}

ul#navi, ul#navi ul {
	margin: 0;
	padding: 0;
	list-style: none;
}

li.group {
	margin-bottom: 3px;
}

li.group div.title {
	height: 35px;
	line-height: 35px;
	background: lightblue;
	cursor: pointer;
}

ul.sub li {
	margin-bottom: 2px;
	height: 35px;
	line-height: 35px;
	background: #f4f4f4;
	cursor: pointer;
}

ul.sub li a {
	display: block;
	width: 100%;
	height: 100%;
	text-decoration: none;
	color: #000;
}

ul.sub li:hover {
	background: aliceblue;
}

<!-- 세로목록 끝 -->


#table{
width:66vw;
}
#table #no{
width:4vw;
text-align:center;
}
#table #title{
width:40vw;
}
#table #writer{
width:7vw;
text-align:center;
}
#table #date{
width:7vw;
text-align:center;
}
#table #readCount{
width:7vw;
text-align:center;
}
#firstTr{
background-color:lightblue;
}
#searchInput{
	width:10vw;
	height:22px;

}
#searchButton{
	width:3vw;
		height:36px;
}
#writeButton{
	
	height:36px;
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
  	<div style="margin-left: 30px; width: 230px; height: 300px; float: left;">
		<ul id="navi">
			<li class="group">
				<div class="title">카테고리</div>
				<ul class="sub">
					<li><a href="/semi/nlist">공지사항</a></li>
					<li><a href="/semi/flist">자유 게시판</a></li>
					<li><a href="/semi/qlist">QnA게시판</a></li>
				</ul>
									<script type="text/javascript">
						$(function() {
							$
									.ajax({
										url : "/semi/ftop3",
										type : "get",
										dataType : "json",
										success : function(data) {
											var json = JSON.parse(JSON
													.stringify(data));
											var values = "";
											var rank = 0;
											for ( var i in json.list) {
										/* 		values += "<tr><td><a href='/first/bdetail?bnum="
														+ json.list[i].bnum
														+ "&page=1'>"
														+ decodeURIComponent(json.list[i].btitle)
														+ "</a></td></tr>"; */
											rank += 1;		
														
														values += "<li><a href='/semi/fdetail?no="
												+ json.list[i].bnum
												+ "&page=1'>"
												/* + decodeURIComponent(json.list[i].btitle) */
												+"<img src=\"/semi/uploadfiles/top3Images/" + rank + ".jpg\" width=\"200px\" height=\"70px\">"
												+ "</a></li>"; 	 
											
												
											}

											$('#toplist').html(values);
										}
									});
						});
					</script>
			<li class="group">
			<div class="title">후기 인기 순위</div>
				<ul id="toplist">				
				</ul>
			</li>
		</ul>
	</div>
	
	
	
				</ul>
			</div>
		
  <div class="col-md-8">

	
	<!--  게시판 -->
			<table class="table table-hover" id="table">		
					<tr id="firstTr">
						<th id="no">번호</th>
						<th id="titlie">제목</th>
						<th id="writer">작성자</th>
						<th id="date">날짜</th>
						<th id="readCount">조회수</th>
					</tr>

				<%
					for (Notice notice : list) {
				%>


					<tr>
						<td id="no"><%=notice.getNoticeNo()%></td>
						<%if(member!=null) { %>
						<td id="title"><a href="/semi/ndetail?no=<%=notice.getNoticeNo()%>">
								<%=notice.getNoticeTitle()%>
						</a></td>
						<%} else{ %>
						<td id="title"><%=notice.getNoticeTitle()%></td>
						<%} %>
						<td id="writer"><%=notice.getNoticeWriter()%></td>
						<td id="date"><%=notice.getNoticeDate()%></td>
						<td id="readCount"><%=notice.getReadCount()%></td>
					</tr>
					<%
						}
					%>
				
			</table>

		<!--  table 끝 -->

		
		<!--  table 끝 -->
		
			<div align="right">
				<form action="/semi/nsearch" method="post">
				
			<table>
				<tr>
				<td><input type="search" autocomlete class="form-control" name="keyword" id="searchInput" length="50"></td>
				<td><input type="submit" class="form-control" value="검색" id="searchButton" ></td>
				<%if(member!=null && member.getMemberId().equals("admin")) {%>
				<td><button onclick="return insertPage();" class="form-control">글쓰기</button></td>
				<%}%>
				</tr>
			
			</table>
			
				</form>
			</div>
			
		
		

	<%-- 페이지 번호 처리 --%>
<div align="center">
<%-- 이전 페이지 있을 경우에 대한 처리 --%>
<% if(currentPage <= 1){ %>
	[이전] &nbsp;
<% }else{ %>
	<a href="/semi/nsearch?page=<%= currentPage - 1 %>&keyword=<%=keyword%>">[이전]</a>
<% } %>
<%-- 현재 페이지 숫자 보여주기 --%>
<% for(int p = startPage; p <= endPage; p++){ 
		if(p == currentPage){
%>
	<b><font size="4" color="red">[<%= p %>]</font></b>
<%     }else{ %>
	<a href="/semi/nsearch?page=<%=p%>&keyword=<%=keyword%>"><%=p%></a>
<% }} %>
<%-- 현재 페이지 다음 페이지에 대한 처리 --%>
<% if(currentPage >= maxPage){ %>
	[다음]
<% }else{ %>
	<a href="/semi/nsearch?page=<%= currentPage + 1 %>&keyword=<%=keyword%>">[다음]</a>
<% } %>
</div>
	

  </div>
  </div>
	
	<div id="footer" style="clear: both;">
		<div class="container">
			<div class="row">
				<div class="col-md-8 col-xs-12 text-left">
					<span>Copyright &copy; 2014 Company Name</span>
				</div>
				<!-- /.text-center -->
				<div class="col-md-4 hidden-xs text-right">
					<a href="#top" id="go-top">Back to top</a>
				</div>
				<!-- /.text-center -->
			</div>
			<!-- /.row -->
		</div>
		<!-- /.container -->
	</div>
	<!-- /#footer -->
</body>
</html>