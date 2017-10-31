<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.util.*, donation.notice.model.vo.Notice"%>

<%
	ArrayList<Notice> list = (ArrayList<Notice>) request.getAttribute("list");
	int listCount = ((Integer) request.getAttribute("listCount")).intValue();
	int currentPage = ((Integer) request.getAttribute("currentPage")).intValue();
	int startPage = ((Integer) request.getAttribute("startPage")).intValue();
	int endPage = ((Integer) request.getAttribute("endPage")).intValue();
	int maxPage = ((Integer) request.getAttribute("maxPage")).intValue();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>boardListView</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/notice/main.css">
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
	function insertPage() {
		location.href = "views/notice/noticeWriteForm.jsp";
		return false;
	}
</script>
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
	background:aliceblue;
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
		<div class="col-md-2" style="margin-top:60px;">
			<div style="margin-left: 30px; width: 230px; height: 300px; float: left;">
				<ul id="navi">
					<li class="group">
						<div class="title">메뉴</div>
						<ul class="sub">
							<li><a href="/semi/nlist">공지사항</a></li>
							<li><a href="/semi/flist">자유 게시판</a></li>
							<li><a href="/semi/qlist">QnA 게시판</a></li>
						</ul>
					</li>
					<script type="text/javascript">					
						$(function() {
							$.ajax({url : "/semi/ftop3",
									type : "get",
									dataType : "json",
									success : function(data) {
										var json = JSON.parse(JSON.stringify(data));
										var values = "";
										var rank = 0;
										for ( var i in json.list) {
											rank += 1;
											values += "<li><a href='/semi/fdetail?no=" + json.list[i].bnum + "&page=1'>"
													   + "<img src=\"/semi/uploadfiles/top3Images/" + rank + ".jpg\" width=\"200px\" height=\"70px\">"
													   + "</a></li>";
											}
										$('#toplist').html(values);
									}
							});
						});
					</script>
					<li class="group">
						<div class="title">후기 인기 순위</div>
						<ul id="toplist"></ul>
					</li>
				</ul>
			</div>
		</div>

		<div class="col-md-8 ntb">
			<!--  게시판 -->
			<table class="table">
				<tr ><td colspan="6">
					<form action="/semi/nsearch" method="post"><div align="right">
						<input id="keyword" type="search" autocomlete name="keyword">
						<input id="sbt" type="submit" value="검색">
						<%if(member!=null && member.getMemberId().equals("admin")) {%>
						<button onclick="return insertPage();" id="sbt" style="width:80px;">글쓰기</button>
						<%}%>
					</div></form>
				</td></tr>
				<tr id="firstTr">
					<th id="no">번호</th>
					<th id="titlie">제목</th>
					<th id="writer">작성자</th>
					<th id="date">날짜</th>
					<th id="file">첨부파일</th>
					<th id="readCount">조회수</th>
				</tr>

				<% if(member!=null) {
					for (Notice notice : list) { %>
					<tr>
						<td><%=notice.getNoticeNo()%></td>
						<td>
							<a href="/semi/ndetail?no=<%=notice.getNoticeNo()%>"><%=notice.getNoticeTitle()%></a>
						</td>
						<td><%=notice.getNoticeWriter()%></td>
						<td><%=notice.getNoticeDate()%></td>
						<td>
							<% if (notice.getOriginalFileName() != null) { %> O 
							<% } else { %> X <% } %>
						</td>
						<td><%=notice.getReadCount()%></td>
					</tr>
				<% }} else { 
					for (Notice notice : list) { %>
					<tr>
						<td><%=notice.getNoticeNo()%></td>
						<td><%=notice.getNoticeTitle()%></td>
						<td><%=notice.getNoticeWriter()%></td>
						<td><%=notice.getNoticeDate()%></td>
						<td>
							<% if (notice.getOriginalFileName() != null) { %> O 
							<% } else { %> X <% } %>
						</td>
						<td><%=notice.getReadCount()%></td>
					</tr>
				<% }} %>
			</table>




			<%-- 페이지 번호 처리 --%>
			<div align="center">
				<%-- 이전 페이지 있을 경우에 대한 처리 --%>
				<%
					if (currentPage <= 1) {
				%>
				[이전] &nbsp;
				<%
					} else {
				%>
				<a href="/semi/nlist?page=<%=currentPage - 1%>">[이전]</a>
				<%
					}
				%>
				<%-- 현재 페이지 숫자 보여주기 --%>
				<%
					for (int p = startPage; p <= endPage; p++) {
							if (p == currentPage) {
				%>
				<b><font size="4" color="red">[<%=p%>]
				</font></b>
				<%
					} else {
				%>
				<a href="/semi/nlist?page=<%=p%>"><%=p%></a>
				<%
					}
						}
				%>
				<%-- 현재 페이지 다음 페이지에 대한 처리 --%>
				<%
					if (currentPage >= maxPage) {
				%>
				[다음]
				<%
					} else {
				%>
				<a href="/semi/nlist?page=<%=currentPage + 1%>">[다음]</a>
				<%
					}
				%>
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
