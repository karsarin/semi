<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.util.*,donation.member.model.vo.Member, donation.suggest.model.vo.Suggest" %>
<%	ArrayList<Suggest> list = (ArrayList<Suggest>) request.getAttribute("list"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>suggestListView</title>
<link href="/semi/css/suggest/suggest.css" rel="stylesheet" type="text/css" media="all" />
</head>
<body>
	<%@ include file="../../headerbar.jsp" %>
	<%@ include file = "../../rightList.jsp" %>
	
	<div style="margin-top:200px; margin-left: 30px; width: 230px; height: 500px; float: left;">
		<ul id="navi">
			<li class="group">
				<div class="title">마이페이지</div>
				<ul class="sub">
					<li><a href="minfor?userid=<%=member.getMemberId()%>">내정보보기</a></li>
					<li><a href="suglist?reciver=<%=member.getMemberId()%>">쪽지보관함</a></li>
					<li><a href="sugslist?writer=<%=member.getMemberId()%>">보낸쪽지함</a></li>
					<li><a href="dselect?memberid=<%= member.getMemberId() %>">기부현황보기</a></li>
					<li><a href="#">작성한 글 보기</a></li>
					<li><a href="mdelete?memberid=<%=member.getMemberId()%>">회원탈퇴</a></li>					
				</ul>
			</li>
		</ul>
	</div>
<%if(member!=null && member.getMemberId().equals("admin")) {%>
<div class="heading-section text-center" style="margin-top:150px;">	
<%} else {%>
<div class="heading-section text-center" style="margin-top:200px;">	
<%}%>		
		<h2 style="text-shadow:1px 1px 2px gray;">쪽지함</h2>
	</div>

	<table class="suggesttb">
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>발신자</th>
				<th>발신날짜</th>
				<th>첨부파일</th>
			</tr>
		</thead>
		<tbody>
			<% for (Suggest suggest : list) { %>
			<tr height="30">
				<td align="center"><%=suggest.getSuggestNo()%></td>
				<td>
					<a href="/semi/sugdetail?no=<%=suggest.getSuggestNo()%>"><%=suggest.getSuggestTitle()%></a>
				</td>
				<td align="center"><%=suggest.getSuggestWriter()%></td>
				<td align="center"><%=suggest.getSuggestDate()%></td>
				<td align="center">
					<% if (suggest.getSuggestOriginalFileName() != null) { %>◎
					<% } else { %>&nbsp;<% } %>
				</td>
			</tr>	
			<% } %>
		</tbody>
	</table>
</body>
</html>