<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.util.*, donation.freeBoard.model.vo.FreeBoard"%>
<%
	ArrayList<FreeBoard> list = (ArrayList<FreeBoard>) request.getAttribute("list");
	int listCount = ((Integer) request.getAttribute("listSearchCount")).intValue();
	int currentPage = ((Integer) request.getAttribute("currentPage")).intValue();
	int startPage = ((Integer) request.getAttribute("startPage")).intValue();
	int endPage = ((Integer) request.getAttribute("endPage")).intValue();
	int maxPage = ((Integer) request.getAttribute("maxPage")).intValue();
	String keyword = (String) request.getAttribute("keyword");
	String type = (String) request.getAttribute("type");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>boardListView</title>



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
#table {
	width: 66vw;
}

#table #type {
	width: 6%;
	text-align: center;
}

#table #title {
	width: 50%;
}

#table #writer {
	width: 10%;
	text-align: center;
}

#table #date {
	width: 15%;
	text-align: center;
}

#table #readCount {
	width: 7%;
	text-align: center;
}

#firstTr {
background-color: #F29661; 
}


#searchType{
	height:37px;
}
#searchInput {
	width: 10vw;
	height: 22px;
}

#searchButton{
	width:4vw;
	height:37px;
}
#writeButton{
	
	height:37px;
} 
#typeSelect {
	width: 5vw;
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
					
<%if( !(member != null) || member.getMemberId().equals("admin")) {%>
	
	<%@ include file="../../boardLeftBar2.jsp"%>
	<%}else{ %>
		
	<%@ include file="../../boardLeftBar.jsp"%>
	<%} %> 
		</div>

		<div class="col-md-8">


			<!--  게시판 -->

			<table class="table table-hover" id="table">

				<tr id="firstTr">
					<!-- <th id="type">분류</th> -->
					<th id="type"><select id="typeSelect" class="form-control"
						onchange="chageLangSelect(this.value)">
							<option value="전체">전체</option>
							<option value="자유">자유</option>
							<option value="후기">후기</option>
					</select> <script>
						function chageLangSelect(type) {
							location.href = "/semi/fsearch?type=분류&keyword="
									+ type;

						}
					</script></th>
					<th id="titlie">제목</th>
					<th id="writer">작성자</th>
					<th id="date">날짜</th>
					<th id="readCount">조회수</th>
				</tr>


				<%
					for (FreeBoard fboard : list) {
				%>
				<tr>
					<td id="type"><%=fboard.getBoardType()%></td>
					<%if(member!=null) { %>
					<td id="title"><a href="/semi/fdetail?no=<%=fboard.getfreeBoardNo()%>">
						<%=fboard.getfreeBoardTitle()%>
					</a></td>
					<%} else { %>
					<td id="title"><%=fboard.getfreeBoardTitle()%></td>
					<%} %>
					<td id="writer"><%=fboard.getfreeBoardWriter()%></td>
					<td id="date"><%=fboard.getfreeBoardDate()%></td>
					<td id="readCount"><%=fboard.getReadCount()%></td>
				</tr>
				<%
					}
				%>
			</table>


			<!--  table 끝 -->

			<div align="right">
				<!-- <form action="/semi/fsearch" method="post"> -->

					<table>
						<tr>
							<td><select class="form-control" name="type" id="searchType">
									<option>분류</option>
									<option>제목</option>
									<option>작성자</option>
							</select></td>
							<td><input type="search" class="form-control"
								id="searchInput" autocomlete name="keyword" length="50"></td>
						<!-- 	<td><input type="submit" class="form-control"
								id="searchButton" value="검색">&nbsp;</td>
							 -->
							
							
				<td><button onclick="return serchList();" class="form-control" id="serchList">검색</button></td>
				<script type="text/javascript">
					function serchList() {
					if($("#searchInput").val() == ""){
									
						alert("원하는 검색어를 입력하세요 ");
					}
					else{
						
						var keyword =  $("#searchInput").val() ;
						var type = $("#searchType").val();
						location.href = "/semi/fsearch?keyword="+keyword+"&type="+type;
						return false;						
					}					
				}
				</script>	
				
							
							
							
							
							<td><%if(member!=null) { %>
								<button class="form-control" onclick="return insertPage();" id="writeButton">글쓰기</button>
							<%}%></td>
								<script type="text/javascript">
									function insertPage() {
										location.href = "views/freeBoard/freeBoardWriteForm.jsp";
										return false;
									}
								</script>
							</tr>

					</table>

			<!-- 	</form> -->
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
				<a
					href="/semi/fsearch?page=<%=currentPage - 1%>&type=<%=type%>&keyword=<%=keyword%>">[이전]</a>
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
				<a
					href="/semi/fsearch?page=<%=p%>&type=<%=type%>&keyword=<%=keyword%>"><%=p%></a>
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
				<a
					href="/semi/fsearch?page=<%=currentPage + 1%>&type=<%=type%>&keyword=<%=keyword%>">[다음]</a>
				<%
					}
				%>
			</div>
		</div>

	</div>

<%@ include file="../../footerbar.jsp" %>

	
</body>
</html>