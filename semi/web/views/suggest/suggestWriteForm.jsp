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
</head>
<body>
	<%@ include file="../../headerbar.jsp" %>	
	<%@ include file = "../../rightList.jsp" %>
<%if(member!=null && member.getMemberId().equals("admin")) {%>
<div class="heading-section text-center" style="margin-top:150px;">	
<%} else {%>
<div class="heading-section text-center" style="margin-top:200px;">	
<%}%>

		<h2 style="text-shadow:1px 1px 2px gray;">쪽지 보내기</h2>
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