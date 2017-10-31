<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="donation.category.vo.CategoryUsed,java.util.ArrayList,java.sql.Date" %>
    <%    
    ArrayList<CategoryUsed> list = (ArrayList<CategoryUsed>)request.getAttribute("list");
    int currentPage = ((Integer)request.getAttribute("currentPage")).intValue();
    int startPage = ((Integer)request.getAttribute("startPage")).intValue();
    int endPage = ((Integer)request.getAttribute("endPage")).intValue();
    int maxPage = ((Integer)request.getAttribute("maxPage")).intValue();
    int listCount = ((Integer)request.getAttribute("listCount")).intValue();
      
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
#select {
	margin-left:49%;
    width: 110px;
    height: 40px;
    padding-left: 10px;
    font-size: 11px;
    color: gray;
    border: 1px solid gray;
    border-radius: 3px;
}
#select option:hover {    
    background: #ff00ff; 
    color: #fff;
}
</style>
</head>
<body>
<%@ include file = "../../myPageLeftBar.jsp" %>
<hr>
<br><br><br>

	<div style="margin-left:220px;font-size:8pt;">
		총 <%= listCount %>개의 글을 찾았습니다.
	</div>
<table align="center" class="table table-hover" id="table">
<tr><th width = "50pt">No</th><th width="100pt">구 분</th><th width="500pt"><div align="center">제목</div></th><th width = "150pt">사용자</th><th width = "150pt">작성자</th><th>신청일자</th>
<% if(listCount != 0){ %>
	<% for(CategoryUsed d : list){ %>
	<tr>
	<td align="center"><%=d.getUseNo() %></td>
	<td><%=d.getCategoryName() %></td>
	<td><a href="#"><%=d.getCategoryTitle() %></a></td>
	<td><%=d.getUse_id() %></td>
	<td><%=d.getWriter_id() %></td>
	<td><%=d.getUsedDate() %></td>
	
	</tr>
	<% } %>
<% }else{ %>
	<tr>
		<td colspan="6" align="center" style="font-size:10pt; color:gray;">신청내역이 없습니다.</td>
	</tr>
<% } %>
</table>
<div align ="center">
<% if(currentPage <=1){ %>
	[이전] &nbsp;
	<%}else{ %>
	<a href="/semi/myapp?page=<%= currentPage -1%>&memberid=<%= member.getMemberId() %>">[이전]</a>
	<% } %>
	<% for(int p = startPage;p<=endPage;p++){
		if(p==currentPage){
	%>
	<b><font size="4"color="red">[<%= p %>]</font></b>
	<%}else{ %>
	<a href="/semi/myapp?page=<%= p %>&memberid=<%= member.getMemberId() %>"><%= p %></a>
	<% }} %>
	<% if(currentPage >= maxPage){ %>
	[다음]
	<%}else{ %>
	<a href="/semi/myapp?page=<%= currentPage+1 %>&memberid=<%= member.getMemberId() %>">[다음]</a>
	<% } %>


</div> 
</body>
</html>