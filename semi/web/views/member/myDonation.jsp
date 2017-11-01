<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="donation.donate.model.vo.Donate,java.util.ArrayList,java.sql.Date" %>
    <% Donate donate = (Donate)request.getAttribute("donate"); 
    int memberTotal = (int)request.getAttribute("memberTotal");
    int myDonation = (int)request.getAttribute("myDonation"); 
    int ranking = (int)request.getAttribute("result");
    
    ArrayList<Donate> list = (ArrayList<Donate>)request.getAttribute("list");
    int currentPage = ((Integer)request.getAttribute("currentPage")).intValue();
    int startPage = ((Integer)request.getAttribute("startPage")).intValue();
    int endPage = ((Integer)request.getAttribute("endPage")).intValue();
    int maxPage = ((Integer)request.getAttribute("maxPage")).intValue();
    int listCount = ((Integer)request.getAttribute("listCount")).intValue();
    String beforeDate = (String)request.getAttribute("beforeDate");
    String afterDate = (String)request.getAttribute("afterDate");
    
    
    
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
#table th{
	background-color:skyblue;
}
#table{
width:69%
}
#table #no{
width:6%
}
#table #title{
width:50%
}
#table #writer{
width:10%
}
#table #date{
width:15%
}
#table #file{
width:12%
}
#table #readCount{
width:7%
}
#firstTr{
background-color:lightblue;
}
#date{
	width:100px;
	height:30px;
	font-size:8pt;
}
/* Removes the clear button from date inputs */
#date::-webkit-clear-button {
    display: none;
}

/* Removes the spin button */
#date::-webkit-inner-spin-button { 
    display: none;
}
#dateclick{
	width:80px;
	height:35px;
	font-size:8pt;
}
</style>
</head>
<body>
<%@ include file = "../../myPageLeftBar.jsp" %>
<% if(ranking !=0){ %>
<div align="center">
<br>
<hr>

<br><br><br><br>
<%if(((double)ranking/memberTotal*100)<1){ %>
<image src="/semi/images/rank/challenger.jpg" align="center" width="250px" height="150px"></image>
<% }else if(((double)ranking/memberTotal*100)<4){ %>
<image src="/semi/images/rank/master.jpg" align="center" width="250px" height=150px"></image>
<% }else if(((double)ranking/memberTotal*100)<11){ %>
<image src="/semi/images/rank/Diamond.jpg" align="center" width="250px" height="150px"></image>
<% }else if(((double)ranking/memberTotal*100)<24){ %>
<image src="/semi/images/rank/Platinum.jpg" align="center" width="250px" height="150px"></image>
<% }else if(((double)ranking/memberTotal*100)<48){ %>
<image src="/semi/images/rank/gold.jpg" align="center" width="250px" height="150px"></image>
<% }else if(((double)ranking/memberTotal*100)<70){ %>
<image src="/semi/images/rank/silver.jpg" align="center" width="250px" height="150px"></image>
<% }else{ %>
<image src="/semi/images/rank/bronze.png" align="center" width="250px" height="150px"></image>
<% } %>
<%=member.getMemberNik() %>님의 기부 랭킹 : <%= ranking %>위<br>

상위<%= (int)((double)ranking/memberTotal*100) %>%<br>
 총 기부금액  총 <%= myDonation %>원
</div>

<br><br><br>
<form action="/semi/dselect?memberid=<%= member.getMemberId() %>"method="post">
	<div style="margin-left:0%;">
		<a style="font-size:8pt;">총 <%= listCount %>개의 글을 찾았습니다.<a>
		<a style="margin-left:41%;">
		<input type="date" name ="beforedate" value="<%= beforeDate %>" id="date"required="required">~<input type="date" name="afterdate" value="<%= afterDate %>" id="date"required="required">
		<input type="submit"value="검색" id="dateclick">
		</a>
	</div>
</form>
<table align="center"class="table table-hover" id="table">
<tr><th width = "50pt">No</th><th width = "100pt">기부자</th><th width = "200pt">기부금</th><th width="100pt">날짜</th>
<% if(listCount != 0){ %>
	<% for(Donate d : list){ %>
	<tr>
	<td align="center"><%= d.getDonationNo() %></td>
	<td><%= d.getMemberId() %></td>
	<td><%= d.getDonation() %></td>	
	<td><%=d.getDonationDate() %></td>	
	</tr>
	<% } %>
<% }else{ %>
	<tr>
		<td colspan="4" align="center" style="font-size:10pt; color:gray;">기부내역이 없습니다</td>
	</tr>
<% } %>
</table>
<div align ="center">
<% if(currentPage <=1){ %>
	[이전] &nbsp;
	<%}else{ %>
	<a href="/semi/dselect?page=<%= currentPage -1%>&memberid=<%= member.getMemberId() %>&beforedate=<%= beforeDate %>&afterdate=<%= afterDate %>">[이전]</a>
	<% } %>
	<% for(int p = startPage;p<=endPage;p++){
		if(p==currentPage){
	%>
	<b><font size="4"color="red">[<%= p %>]</font></b>
	<%}else{ %>
	<a href="/semi/dselect?page=<%= p %>&memberid=<%= member.getMemberId() %>&beforedate=<%= beforeDate %>&afterdate=<%= afterDate %>"><%= p %></a>
	<% }} %>
	<% if(currentPage >= maxPage){ %>
	[다음]
	<%}else{ %>
	<a href="/semi/dselect?page=<%= currentPage+1 %>&memberid=<%= member.getMemberId() %>&beforedate=<%= beforeDate %>&afterdate=<%= afterDate %>">[다음]</a>
	<% }}else{ %>
	<br><br><br><br><hr>
	<div align="center" style="font-size:20pt;color:crimson;"><%= member.getMemberNik() %>님의 기부기록이 없습니다.</div>
	<% } %> 

</div> 
</body>
</html>