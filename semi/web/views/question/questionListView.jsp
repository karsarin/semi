<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- page 지시자 태그는 한 페이지에 한 개만 사용이 원칙임
     예외로 import 속성에 대해서만 따로 작성할 수 있음. --%>
<%@ page
	import="donation.question.model.vo.Question, java.util.ArrayList, java.sql.Date"%>
<%
	ArrayList<Question> list = (ArrayList<Question>) request.getAttribute("list");
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
<title>QuestionListView</title>

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
		location.href = "views/question/questionWriteForm.jsp";
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
#table {
	width: 66vw;
}

#table #no {
	width: 4vw;
	text-align: center;
}

#table #title {
	width: 40vw;
}

#table #writer {
	width: 7vw;
	text-align: center;
}

#table #date {
	width: 7vw;
	text-align: center;
}

#table #readCount {
	width: 7vw;
	text-align: center;
}

#firstTr {
	background-color: #F29661;
}

#searchInput {
	width: 10vw;
	height: 22px;
}

#searchButton {
	width: 4vw;
	height: 37px;
}

#writeButton {
	height: 37px;
}

#menuBarBorder {
	padding-top: 20px;
	margin-left: 10px;
	margin-right: 10px;
	width: 220px;
	height: 450px;
	background-color: #EAEAEA;
}
</style>





</head>

<body>

	<%@ include file="../../headerbar.jsp"%>
	<%@ include file="../../rightList.jsp"%>
	<%
		if (member != null && member.getMemberId().equals("admin")) {
	%>
	<div class="row" style="margin-top: 150px;">
		<%
			} else {
		%>
		<div class="row" style="margin-top: 200px;">
			<%
				}
			%>
			<div class="col-md-2">
				<%
					if (!(member != null) || member.getMemberId().equals("admin")) {
				%>

				<%@ include file="../../boardLeftBar2.jsp"%>
				<%
					} else {
				%>

				<%@ include file="../../boardLeftBar.jsp"%>
				<%
					}
				%>
			</div>
			<div class="col-md-8">


				<table class="table table-hover" id="table">


					<tr id="firstTr">
						<th id="no">번호</th>
						<th id="titlie">제목</th>
						<th id="writer">작성자</th>
						<th id="date">날짜</th>
						<th id="readCount">조회수</th>
					</tr>



					<%
						for (Question q : list) {
					%>



					<tr>
						<td id="no"><%=q.getQuestionNum()%></td>
						<td id="title">
							<%-- 답글일 때는 들여쓰기하면서 앞에 ▶ 표시함 --%> <%
 	if (q.getQuestionLevel() == 1) { //원글의 댓글일 때
 %>
							&nbsp; &nbsp; ┕> <%
 	} else if (q.getQuestionLevel() == 2) { //댓글의 댓글일 때
 %>
							&nbsp; &nbsp; &nbsp; &nbsp; ┕> <%
 	}
 %> <%-- 로그인한 경우 상세보기 가능하게 처리함 --%>
							<%
								if (member != null) {
							%> <a
							href="/semi/qdetail?no=<%=q.getQuestionNum()%>&page=<%=currentPage%>">
								<%=q.getQuestionTitle()%>
						</a> <%
 	} else {
 %> <%=q.getQuestionTitle()%> <%
 	}
 %>
						</td>
						<td id="writer"><%=q.getQuestionWriter()%></td>
						<td id="date"><%=q.getQuestionDate()%></td>
						<td id="readCount"><%=q.getQuestionReadCount()%></td>
					</tr>
					<%
						}
					%>


				</table>



				<!-- 검색 -->
				<div align="right">


					<table>
						<tr>
							<td><input type="search" autocomlete class="form-control"
								name="keyword" id="searchInput" length="50"></td>
							<td><button onclick="return serchList();"
									class="form-control" id="serchList">검색</button></td>
							<script type="text/javascript">
								function serchList() {
									if ($("#searchInput").val() == "") {

										alert("원하는 검색어를 입력하세요 ");
									} else {
										var keyword = $("#searchInput").val();
										location.href = "/semi/qsearch?keyword="
												+ keyword;
										return false;
									}
								}
							</script>



							<td>
								<%
									if (member != null) {
								%>
								<button onclick="return insertPage();" class="form-control"
									id="writeButton">글쓰기</button> <%
 	}
 %>
							</td>

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
					<a href="/semi/qlist?page=<%=currentPage - 1%>">[이전]</a>
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
					<a href="/semi/qlist?page=<%=p%>"><%=p%></a>
					<%
						}
						}
					%>
					<%-- 현재 페이지 다음 페이지에 대한 처리 --%>
					<% if(currentPage >= maxPage){ %>
					[다음]
					<% }else{ %>
					<a href="/semi/qlist?page=<%= currentPage + 1 %>">[다음]</a>
					<% } %>
				</div>



			</div>
		</div>

		<%@ include file="../../footerbar.jsp"%>
</body>
</html>









