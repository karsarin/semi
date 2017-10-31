<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="donation.category.vo.Category, java.sql.Date, java.util.*, donation.member.model.vo.Member" %>

<%
	Category category = (Category)request.getAttribute("category");
	int currentPage = ((Integer)request.getAttribute("ccurrentPage")).intValue();
	
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>카테고리 게시판</title>

<style type="text/css">
	
	tr{
		align: center;
	}
	
	.mainimg{
		align: center;
		width: 855px;
		height: 600px;
	}
	
	#imgarea {
		relation: positive;
		align: center;
		width: 855px;
		height: 600px;
	}
	
	.col-md-3 {
		align: center;
		background: ivory;
	}
	
	#table{
	float: left;
	width:20%;
	
	}
	
	#work{
		align: center;
	}
	

	#categoryboard{
		width: 50%;
		float: left;
		margin-left: 30px;
	}

</style>
<script type="text/javascript">

	
		
	
	function confirmDelete()
	{
		var deleteyn = confirm("정말 재능을 삭제하시겠습니까?");
		
		if(deleteyn == true)
			location.href="/semi/cdelete?cnum=<%= category.getCategoryNo()%>";
	}
	
	function goUpdateView()
	{
		location.href="/semi/cupdate?cnum=<%= category.getCategoryNo() %>&cpage=<%= currentPage %>";
		
	}	
</script>

</head>
<body style="margin-left:30px; margin-right:30px">

<%@ include file="../../headerbar.jsp" %>
<script type="text/javascript">
function goPurchaseView(){
	<% if(member == null){ %>
		alert("재능 신청은 로그인이 필요합니다.");	
	<%} else { %>
		alert("재능 신청이 완료되었습니다.");
		
		location.href="/semi/cpurchaselist?categoryNo=<%= category.getCategoryNo()%>&memberid=<%= member.getMemberId()%>"; 
	<%}%>
	
}

function goSuggestion(){
	<% if(member != null){ %>
	location.href="/semi/views/suggest/suggestWriteForm.jsp";
	<%} else {%>
		alert("로그인이 필요합니다.");
	<% } %>
	
}
</script>

<!-- 판매자 정보 -->

<div>
<br><br><br><br><br>
<table class="table table-bordered" id="table">

  <tr><th width="160px"><img src="cuploadfiles/<%=category.getRenameImage() %>" width="75" height="75"></th><td width="160px"><%= category.getUserId() %></td></tr>
  <tr><th width="160px">로그인여부</th>
  <td><% if(member != null && member.getConnection().equals("Y")){ %>
			<font color="red">로그인 중!</font>
  		<%} else { %>
  			로그인 중이 아님
  		<%} %>
  </td>
  </tr>
  <tr><th width="160px">연락처</th>
  <% if(category.getPhone() != null){ %>
  <td><%= category.getPhone() %></td>
  <% } else { %>
  <td>-</td>
  <%} %>
  </tr>
  <tr><th width="160px">이메일</th><td><%= category.getEmail() %></td></tr>
  <% if(member != null && !member.getMemberId().equals(category.getCategoryWriter()) || member == null){ %>
 <tr><td colspan="2" align="center"> <button type="button" class="btn btn-primary btn-lg" onclick="javascript:goPurchaseView();">재능 신청하기</button></tr>
 <% } else if(member != null && member.getMemberId().equals(category.getCategoryWriter())){ %>
 		<tr><td align="center">
 	<button type="button" class="btn btn-danger" onclick="confirmDelete();">재능 삭제</button>
 	</td>
 	<td align="center"><button type="button" class="btn btn-warning" onclick="goUpdateView()">재능 수정</button></td>
 	</tr>
<%} %>
 
 <% if(member == null || !member.getMemberId().equals(category.getCategoryWriter())){ %>

 <tr>
 	<td align="center"><a href="/semi/swrite?reciver=<%= category.getUserId() %>" class="btn btn-success">문의 보내기</a></button></td>
 	<td align="center"><% if(member != null && member.getConnection().equals("Y")){ %>

<%--  <tr><td align="center"><a href="/semi/swrite?reciver=<%= category.getUserId() %>" class="btn btn-success">문의 보내기</a></button></td>
 		<td align="center"><% if(member != null && member.getConnection().equals("Y")){ %> --%>

 				<button type="button" class="btn btn-success"><a href="/semi/chatcon?chatRe=<%= category.getUserId() %>">채팅가능</a></button>
 			<%} else { %>
 				<button type="button" class="btn btn-danger">로그아웃상태</button>
 			<%} %>
 	</td>
 </tr>
<%if(member.getMemberId().equals("admin") && category.getApproval().equals("N")){%>
 <tr>
 	<td align="center"><button type="button" class="btn btn-success" onclick="location.href='/semi/capprove?cno=<%=category.getCategoryNo()%>'">승인</button></td>
 	<td align="center"><button type="button" class="btn btn-success" onclick="location.href='/semi/crefusal?cno=<%=category.getCategoryNo()%>'">거절</button></td>
 </tr>
<%} } %>
 	
</table>

</div>
<!-- 판매자 정보 끝 -->

<!-- 게시글 정보 -->
	<div align="left">
		<font size="5">&nbsp;&nbsp;<%=category.getCategoryTitle() %></font>
	</div>
	
	<div id="categoryboard">
	<div align="center">
 	 <table class="table table-condensed" id="work">
 	 	<tr><th>요구 기부금</th><th>작업기간</th><th>신청횟수</th><th>조회수</th></tr>
 	 	<tr><td><%= category.getCategoryDonation() %></td><td><%= category.getWorkDate() %></td><td><%= category.getPurchaseCount() %></td><td><%= category.getCategoryReadcount() %></td></tr>
 	 </table>
	<img class="mainimg" src="cuploadfiles/<%= category.getRenameImage()%>" width="855px" height="600px"> <br>
	<font size="6">기부금 <%= category.getCategoryDonation() %>원 이상 신청 가능</font> &nbsp; 
	<% if(member != null && !member.getMemberId().equals(category.getCategoryWriter())){ %>
	<button type="button" class="btn btn-primary btn-lg" onclick="javascript:goPurchaseView();">재능 신청하기</button><br>
	<%} else {%>
	<button type="button" class="btn btn-primary btn-lg" onclick="javascript:loginAlert();">재능 신청하기</button><br>
	<%} %>
	<hr>
	</div>
	
	<div class="prd_detail_sub_title" style="">
		<p><strong><font size="4"> 재능 <font color="blue">상세 내용</font></font></strong></p><br>
		
		<p style="margin-bottom:20px">
			<%= category.getCategoryContent().replaceAll("\n", "<br>") %> 
		</p>
	</div>
	
	<hr>
	<% if(category.getAddRenameImage1() != null){ %>
		<img class="mainimg" src="cuploadfiles/<%= category.getAddRenameImage1() %>" width="855px" height="600px"><br>
	<%} %>
	
	<% if(category.getAddRenameImage2() != null){ %>
		<img class="mainimg" src="cuploadfiles/<%= category.getAddRenameImage2() %>" width="855px" height="600px"><br>
	<%} %>
	
 	<% if(category.getAddRenameImage3() != null){ %> 
		<img class="mainimg" src="cuploadfiles/<%= category.getAddRenameImage3() %>" width="855px" height="600px"><br>
	 <%} %> 
	
	 <% if(category.getAddRenameImage4() != null){ %> 
		<img class="mainimg" src="cuploadfiles/<%= category.getAddRenameImage4() %>" width="855px" height="600px"><br>
	 <% } %>
	</div>
<!-- 게시글 정보 끝 -->
<%@ include file="../../rightList.jsp" %>
<%@ include file="../../footerbar.jsp" %>
</body>
</html>