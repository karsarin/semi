<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  import="donation.suggest.model.vo.Suggest" %>
<%	Suggest suggest = (Suggest) request.getAttribute("suggest");
	String reciver = String.valueOf(request.getAttribute("reciver")); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>suggestWriteForm</title>

<link href="/semi/css/suggest/suggest.css" rel="stylesheet" type="text/css" media="all"/>

<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!--  헤더바 -->

        <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700,800' rel='stylesheet' type='text/css'>
        
        <link rel="stylesheet" href="/semi/css/bootstrap.min.css">
        <link rel="stylesheet" href="/semi/css/font-awesome.css">
        <link rel="stylesheet" href="/semi/css/animate.css">
        <link rel="stylesheet" href="/semi/css/templatemo_misc.css">
        <link rel="stylesheet" href="/semi/css/templatemo_style.css">
        <script src="/semi/js/vendor/modernizr-2.6.1-respond-1.1.0.min.js"></script>

<script src="/semi/js/jquery-3.2.1.min.js"></script>

<script type="text/javascript">	
  	$(function(){
  		$('.main-menu ul #home').removeClass('active');
		$('.main-menu ul #category').removeClass('active');
		$('.main-menu ul #board').removeClass('active');
		$('.main-menu ul #minfo').removeClass('active');
		<%if(suggest!=null) {%>
  			var originalContent = '<%=suggest.getSuggestContent()%>';
  			$("textarea[name=content]").val("\n\n\n-------Original Message-------\n\n"+originalContent);
  		<%}%>
   	});
</script>

<%-- 세로목록 --%>
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
   background: lightblue;
}
</style>
<!-- 세로목록 끝 -->

</head>
<body>

	<%@ include file="../../headerbar.jsp" %>	
	<%@ include file = "../../rightList.jsp" %>
	<%--<%@ include file="../../leftList.jsp" %> --%>
	<%-- <%@ include file="../../myPageLeftBar.jsp" %> --%>
	
	<div style="margin-left: 30px; width: 230px; height: 500px; float: left; margin-top:250px;">

		<ul id="navi">
			<li class="group">
				<div class="title">카테고리</div>
				<ul class="sub">
				<li><a href="/semi/clist">모두 보기</a>
					<li><a href="/semi/cfIT">IT</a></li>
               <li><a href="/semi/cfdesign">디자인</a></li>
               <li><a href="/semi/cfmarketing">마케팅</a></li>
               <li><a href="/semi/cfmusic">음악</a></li>
               <li><a href="/semi/cfknowhow">노하우/상담</a></li>
               <li><a href="/semi/cftranslation">번역</a></li>
               <li><a href="/semi/cfhealth">건강</a></li>
               <li><a href="/semi/cfetc">기타</a></li>
				</ul>
			</li>
		</ul>
	</div>
	
<%if(member!=null && member.getMemberId().equals("admin")) {%>
<div class="heading-section text-center" style="margin-top:150px;">	
<%} else {%>
<!-- <div class="heading-section text-center" style="margin-top:200px;"> -->
<div style="text-align: center; padding-right: 160px; margin-top:200px;">	
<%}%>

		<h2 style="text-shadow:1px 1px 2px gray; font-weight: bold; font-size: 30px; margin-bottom: 15px;">쪽지 보내기</h2>
	</div>

	<form action="/semi/sugsend" method="post" enctype="multipart/form-data">
		<table class="suggestWritetb">
			<tr>
				<th>제목</th>
				<% if(suggest!=null) { %>
					<td align="left"><input type="text" name="title" value="RE: <%=suggest.getSuggestTitle()%>" readonly></td>
				<% } else { %>
					<td align="left"><input type="text" name="title"></td>
				<% } %>
			</tr>
			<%if(!member.getMemberId().equals("admin")) {%>
			<tr>
				<th>기간</th>
				<% if(suggest!=null) { %>
					<td align="left"><input type="text" name="preoid" value="<%=suggest.getSuggestPreoid()%>" readonly></td>
				<% } else { %>
					<td align="left"><input type="text" name="preoid"></td>
				<% } %>
			</tr>
			<%}%>
			<tr>
				<th>내용</th>
				<td><textarea rows="15" cols="50" name="content"></textarea></td>
			</tr>
			<tr>
				<th>발신자</th>
				<td>
					<input type="text" name="writer" value="<%=member.getMemberId()%>" readonly>
				</td>
			</tr>
			<tr>
				<th>수신자</th>
				<td>
					<input type="text" name="reciver" value="<%=reciver%>" readonly>
				</td>
			</tr>
			<tr>
				<th>첨부파일</th>
				<td><input type="file" name="file"></td>
			</tr>
		</table>
		<div align="center" style="margin-top:30px; margin-bottom:100px;">
			<input type="submit" value="보내기" style="background:white;">
			<input type="reset" value="취소" style="background:white;">
		</div>
	</form>
	
	<%@ include file="../../footerbar.jsp" %>	
</body>
</html>