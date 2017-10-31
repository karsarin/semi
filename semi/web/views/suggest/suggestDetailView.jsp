<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="donation.suggest.model.vo.Suggest" %>
<%	Suggest suggest = (Suggest) request.getAttribute("suggest"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8">
<title>suggestDetailView</title>
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
		<p><%=suggest.getSuggestWriter()%>님의 쪽지입니다.</p>
	</div>

	<table class="suggestDetailtb">
		<tr>
			<th>제목</th>
			<td><%=suggest.getSuggestTitle()%></td>
			<th>발신자</th>
			<td><%=suggest.getSuggestWriter()%></td>
		</tr>
		<tr>
			<th>기간</th>
			<td><%=suggest.getSuggestPreoid()%></td>
			<th>발신날짜</th>
			<td><%=suggest.getSuggestDate()%></td>
		</tr>
		<tr>
			<td colspan="4" id="content"><%=suggest.getSuggestContent()%></td>
		</tr>
		<tr>
			<th>첨부파일</th>
			<td colspan="3">
				<% if (suggest.getSuggestOriginalFileName() != null) { %> 
					<a href="/semi/sugdown?oname=<%=suggest.getSuggestOriginalFileName()%>&rname=<%=suggest.getSuggestRenameFileName()%>">
					<%=suggest.getSuggestOriginalFileName()%></a>
				<% } else { %> 첨부파일 없음 <% } %>
			</td>
		</tr>
	</table>
	<div align="center" style="margin-bottom:100px;">
		<button onclick="location.href='/semi/sugdel?no=<%=suggest.getSuggestNo()%>'" id="deleteBt" style="margin-top:70px;">삭제</button>
		<button onclick="location.href='/semi/swrite?reciver=<%=suggest.getSuggestWriter()%>&suggest=<%=suggest.toString()%>&sender=<%=member.getMemberId()%>'" id="replyBt" style="margin-top:70px;">답장</button>
	</div>
	
</body>
</html>