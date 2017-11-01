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

#searchInput{
	width:10vw;
	height:22px;

}
#searchButton{
	width:4vw;
	height:37px;
}
#writeButton{
	
	height:37px;
}

#firstTr{
background-color: #F29661;
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
	<%if(member != null ){ %>
	<%@ include file="../../boardLeftBar.jsp"%>
	<%}else{ %>
	<%@ include file="../../boardLeftBar2.jsp"%>	
	<%} %>
	
</div>
		  <div class="col-md-8">
			<!--  게시판 -->
			<table  class="table table-hover" id="table">
				
				<tr id="firstTr">
					<th id="no">번호</th>
					<th id="titlie">제목</th>
					<th id="writer">작성자</th>
					<th id="date">날짜</th>
					<th id="readCount">조회수</th>
				</tr>

				<% if(member!=null) {
					for (Notice notice : list) { %>
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
				<% }} else { 
					for (Notice notice : list) { %>
						<tr>
						<td id="no"><%=notice.getNoticeNo()%></td>						
						<td id="title"><%=notice.getNoticeTitle()%></td>						
						<td id="writer"><%=notice.getNoticeWriter()%></td>
						<td id="date"><%=notice.getNoticeDate()%></td>
						<td id="readCount"><%=notice.getReadCount()%></td>
					</tr>
				<% }} %>
			</table>



	<div align="right">
			<table>
				<tr>
				<td><input type="search" autocomlete class="form-control" name="keyword" id="searchInput" length="50"></td>
							
				<td><button onclick="return serchList();" class="form-control" id="serchList">검색</button></td>
				<script type="text/javascript">
					function serchList() {					
					
					
					if($("#searchInput").val() == ""){
									
						alert("원하는 검색어를 입력하세요 ");
					}
					else{
						var keyword =  $("#searchInput").val() ;
						location.href = "/semi/nsearch?keyword="+keyword;
						return false;						
					}					
				}
				</script>				
				
				<%if(member!=null && member.getMemberId().equals("admin")) {%>
				<td><button onclick="return insertPage();" class="form-control" id="writeButton">글쓰기</button></td>
				<%}%>
				</tr>
			
			</table>

			</div>
			



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

	
<%@ include file="../../footerbar.jsp" %>


</body>
</html>
