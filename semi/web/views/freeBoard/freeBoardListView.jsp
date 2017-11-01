<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.util.*, donation.freeBoard.model.vo.FreeBoard"%>
<%-- page 지시자 태그는 한 페이지에 한 개만 사용이 원칙임
     예외로 import 속성에 대해서만 따로 작성할 수 있음. --%>


<%
	ArrayList<FreeBoard> list = (ArrayList<FreeBoard>) request.getAttribute("list");
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
	width: 4vw;
text-align:center;
}

#table #title {
	width: 40vw;
}

#table #writer {
	width: 7vw;
text-align:center;
}

#table #date {
	width: 7vw;
text-align:center;
}


#table #readCount {
	width: 7vw;
text-align:center;
}

#firstTr {
background-color: #F29661;

}

#searchInput{
	width:10vw;
	height:22px;

}
#searchButton{
	width:4vw;
	height:37px;
}
#searchType{
	height:37px;
}
#writeButton{ 
	height:37px;
	
}
#typeSelect{
	width:5vw;
	height:34px;
}

#menuBarBorder{
	
	padding-top : 20px;
	margin-left:10px;
	margin-right:10px;
	width:220px;
	height:450px;
	background-color:#EAEAEA;
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
			<!--  게시판 -->
			<table class="table table-hover" id="table">					
					<tr id="firstTr">
					<th id="type">
					<select class="form-control" onchange="chageLangSelect(this.value)" id="typeSelect">
						<option  value="전체">전체</option>
						<option  value="자유">자유</option>
						<option  value="후기">후기</option>
					</select>
					</th>

					<script>
						function chageLangSelect(type) {
							location.href = "/semi/fsearch?type=분류&keyword="+type; 
						}
					</script>				
					<th id="titlie" >제목</th>
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
					<td id="titlie"><a href="/semi/fdetail?no=<%=fboard.getfreeBoardNo()%>">
							<%=fboard.getfreeBoardTitle()%>
					</a></td>
					<% } else{ %>
					<td id="titlie"><%=fboard.getfreeBoardTitle()%></td>
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
	<!-- 			<form action="/semi/fsearch" method="post"> -->
				
			<table>
							<tr>
								<td><select class="form-control" name="type"
									id="searchType">
										<option>분류</option>
										<option>제목</option>
										<option>작성자</option>
								</select>
								</td>
								<td><input type="search" autocomlete class="form-control"
									name="keyword" id="searchInput" length="50"></td>
							<!-- 	<td><input type="submit" class="form-control" value="검색"
									id="searchButton"></td> -->
								
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
								
								
			
								
								<td> 
								<%if(member!=null) { %>
								<button class="form-control" onclick="return insertPage();" id="writeButton">글쓰기</button>
								<%}%>
								</td>
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
				<a href="/semi/flist?page=<%=currentPage - 1%>">[이전]</a>
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
				<a href="/semi/flist?page=<%=p%>"><%=p%></a>
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
				<a href="/semi/flist?page=<%=currentPage + 1%>">[다음]</a>
				<%
					}
				%>
			</div>



		</div>

	
	<%@ include file="../../footerbar.jsp" %>

	</div>


	

</body>
</html>
