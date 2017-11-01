<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<%-- 세로목록 --%>
<style>
ul#navi {
	width: 150px;
	text-indent: 10px;
	background-color:lightgray;
	
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
	background: lightblue;
}
</style>
<!-- 세로목록 끝 -->



</head>
<body>
	<%@ include file = "../../headerbar.jsp" %>
	<%@ include file = "../../rightList.jsp" %>
<div style=" margin-top:200px;margin-left: 30px; width: 230px; height: 500px; float: left;">

		<ul id="navi">
			<li class="group">
				<div class="title">마이페이지</div>
				<ul class="sub">
					<li><a href="/semi/minfor?userid=<%=member.getMemberId()%>">내정보보기</a></li>
					<li><a href="/semi/dselect?memberid=<%= member.getMemberId() %>">기부현황보기</a></li>
					<li><a href="/semi/mylist?memberid=<%= member.getMemberId() %>">작성한 글 보기</a></li>
					<li><a href="/semi/suglist?reciver=<%= member.getMemberId() %>">쪽지 보관함</a></li>
					<li><a href="/semi/sugslist?writer=<%= member.getMemberId() %>">보낸 쪽지함</a></li>
					<li><a href="/semi/myapp?memberid=<%= member.getMemberId() %>">재능기부신청현황</a></li>
					<li><a href="/semi/views/member/DeleteCheck.jsp">회원탈퇴</a></li>
					
				</ul>
			</li>

		</ul>



	</div>

</html>