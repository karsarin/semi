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
<script src="/semi/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
    	$(function(){
    		$('.main-menu ul #insertc').removeClass('active');
    		$('.main-menu ul #home').removeClass('active');
    		$('.main-menu ul #board').removeClass('active');
    		$('.main-menu ul #category').addClass('active');
    	});
</script>
<style type="text/css">
	
	tr{
		align: center;
	}
	
	.mainimg{
		align: center;
		width: 700px;
		height: 400px;
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
	width:250px;
	margin-left:50px;
	}
	#table th{
	text-align:center;
	}
	#table #noWriter td button:nth-child(1){
		margin-right:20px;
	}
	#table #noWriter td button{
		width:90px;
	}
	#table #writer td button:nth-child(1){
		margin-right:20px;
	}
	#table #writer td button{
		width:90px;
	}
	
	#work{
		align: center;
	}
	

	#categoryboard{
		width: 400px;
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
<%@ include file="../../rightList.jsp" %>
<script type="text/javascript">
function goPurchaseView(){
	<% if(member == null){ %>
		alert("재능 신청은 로그인이 필요합니다.");	
	<%} else { %>
		alert("재능 신청이 완료되었습니다.");
		
		location.href="/semi/cpurchaselist?categoryNo=<%= category.getCategoryNo()%>&memberid=<%= member.getMemberId()%>"; 
	<%}%>
	
}
</script>

<!-- 판매자 정보 -->
<%if(member!=null&&member.getMemberId().equals("admin")) { %>
<div style="margin-top:30px;">
<%}else { %>
<div style="margin-top:100px;">
<%} %>
<br><br><br><br><br>
		<table class="table table-bordered" id="table">
			<tr>
				<th height="250px" colspan="2">
					<img src="/uploadfiles/cuploadfiles/<%=category.getRenameImage()%>" width="185px" height="185px">
				</th>
			</tr>
			<tr>
				<th width="100px">판매자</th>				
				<td><%=category.getUserId()%></td>
			</tr>
			<tr>
				<th>연락처</th>
				<%if (category.getPhone() != null) {%><td><%=category.getPhone()%></td>
				<%} else {%><td>-</td><%}%>
			</tr>
			<tr>
				<th>이메일</th>
				<td><%=category.getEmail()%></td>
			</tr>


			<%if(member==null){%>
			<tr id="noWriter">
				<td align="center" colspan="2">
					<button type="button" class="btn btn-success" onclick="return goSuggestion();">문의</button>
					<button type="button" class="btn btn-success" onclick="return goChatting();">채팅</button>
				</td>
			</tr>
			<%}%>
			<%if (member!=null && !member.getMemberId().equals(category.getCategoryWriter())) {%>
			<tr id="noWriter">
				<td align="center" colspan="2">
					<button type="button" class="btn btn-success" onclick="return goSuggestion();">문의</button>
					<button type="button" class="btn btn-success" onclick="return goChatting();">채팅</button>
				</td>
			</tr>
			<%if (member.getMemberId().equals("admin") && category.getApproval().equals("N")) {%>
				<tr id="noWriter">
					<td align="center" colspan="2">
						<button type="button" class="btn btn-success" onclick="location.href='/semi/capprove?cno=<%=category.getCategoryNo()%>'">승인</button>
						<button type="button" class="btn btn-success" onclick="location.href='/semi/crefusal?cno=<%=category.getCategoryNo()%>'">거절</button>
					</td>
				</tr>
			<%} } %>
			
			
			<%if (member!=null && !(member.getMemberId().equals(category.getCategoryWriter()))) {%>
			<tr>
				<td colspan="2" align="center">
					<button type="button" class="btn btn-primary" onclick="javascript:goPurchaseView();">재능 신청하기</button>
				</td>
			</tr> <!-- 널이거나 다른 사람일떄 -->
			<%} else {
					if(member==null) {%>
					<tr>
						<td colspan="2" align="center">
							<button type="button" class="btn btn-primary" onclick="javascript:goPurchaseView();">재능 신청하기</button>
						</td>
					</tr>
				<%} else {%>
					<tr id="writer">
						<td align="center" colspan="2">
							<button type="button" class="btn btn-danger" onclick="confirmDelete();">삭제</button>
							<button type="button" class="btn btn-warning" onclick="goUpdateView()">수정</button>
						</td>
					</tr>
			<%}}%>	

		</table>
		<script type="text/javascript">
 		 	function goChatting(){
 		 		<% if(member == null){ %>
 		 			alert("채팅은 로그인이 필요합니다.");	
 		 		<%} else { %>
 		 			window.open('/semi/chatcon?reciver=<%= category.getUserId() %>&rsender=<%= member.getMemberId() %>','','width=380,left=50,top=50, height=400');
 		 		<%}%> 		 		
 		 	}


 		 	function goSuggestion(){
 		 		<% if(member == null){ %>
 		 			alert("문의하기는 로그인이 필요합니다.");	
 		 		<%} else { %>
 		 			location.href="/semi/swrite?reciver=<%=category.getUserId()%>&sender=<%=member.getMemberId()%>";
 		 		<%}%> 		 		
 		 	}
 		</script>

	</div>
<!-- 판매자 정보 끝 -->

<!-- 게시글 정보 -->
		<div>
			<font size="5" style="margin-left:30px;"><%=category.getCategoryTitle()%></font>
		</div>
		<div id="categoryboard">
			<div>
				<table class="table table-condensed" id="work">
					<tr>
						<th>요구 기부금</th>
						<th>작업기간</th>
						<th>신청횟수</th>
						<th>조회수</th>
					</tr>
					<tr>
						<td><%=category.getCategoryDonation()%></td>
						<td><%=category.getWorkDate()%></td>
						<td><%=category.getPurchaseCount()%></td>
						<td><%=category.getCategoryReadcount()%></td>
					</tr>
				</table>
				<img class="mainimg" src="cuploadfiles/<%=category.getRenameImage()%>"><br><br><br><br><br>
				<font size="4" style="width:500px;">기부금 <%=category.getCategoryDonation()%>원이상 신청 가능</font><br><br>
				<%
					if (member != null && !member.getMemberId().equals(category.getCategoryWriter())) {
				%>
				<button type="button" class="btn btn-primary btn-lg"
					onclick="javascript:goPurchaseView();">재능 신청하기</button>
				<br>
				<%
					} else {
				%>
				<button type="button" class="btn btn-primary btn-lg"
					onclick="javascript:loginAlert();">재능 신청하기</button>
				<br>
				<%
					}
				%>
				<hr>
			</div>

			<div class="prd_detail_sub_title" style="">
				<p>
					<strong><font size="4"> 재능 <font color="blue">상세
								내용</font></font></strong>
				</p>
				<br>

				<p style="margin-bottom: 20px">
					<%=category.getCategoryContent().replaceAll("\n", "<br>")%>
				</p>
			</div>

			<hr>
			<%
				if (category.getAddRenameImage1() != null) {
			%>
			<img class="mainimg"
				src="cuploadfiles/<%=category.getAddRenameImage1()%>"
				width="855px" height="600px"><br>
			<%
				}
			%>

			<%
				if (category.getAddRenameImage2() != null) {
			%>
			<img class="mainimg"
				src="cuploadfiles/<%=category.getAddRenameImage2()%>"
				width="855px" height="600px"><br>
			<%
				}
			%>

			<%
				if (category.getAddRenameImage3() != null) {
			%>
			<img class="mainimg"
				src="cuploadfiles/<%=category.getAddRenameImage3()%>"
				width="855px" height="600px"><br>
			<%} %>

			<% if(category.getAddRenameImage4() != null){ %>
			<img class="mainimg"
				src="cuploadfiles/<%= category.getAddRenameImage4() %>"
				width="855px" height="600px"><br>
			<% } %>
		</div>
		<!-- 게시글 정보 끝 -->
<%@ include file="../../footerbar.jsp" %>
</body>
</html>