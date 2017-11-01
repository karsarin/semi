<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="donation.member.model.vo.MyWrite,java.util.ArrayList,java.sql.Date" %>
    <% 
    ArrayList<MyWrite> list = (ArrayList<MyWrite>)request.getAttribute("list");
    int currentPage = ((Integer)request.getAttribute("currentPage")).intValue();
    int startPage = ((Integer)request.getAttribute("startPage")).intValue();
    int endPage = ((Integer)request.getAttribute("endPage")).intValue();
    int maxPage = ((Integer)request.getAttribute("maxPage")).intValue();
    int listCount = ((Integer)request.getAttribute("listCount")).intValue();
    int boardNo = ((Integer)request.getAttribute("boardNo")).intValue();
    
    
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
<script type="text/javascript">
	function select(value){
		location.href = "/semi/mylist?value="+value+"&memberid=<%= member.getMemberId() %>";
	}

</script>
<br><br><br><br><br>
<div align="center">내가 쓴 글  총 <%=listCount %>개 조회
	
	<select  name="select" onchange="select(this.options[this.selectedIndex].value)"id="select">
	<option value="0"<% if(boardNo ==0){ %>selected="selected"<% }%>>전체</option>
	<option value="1"<% if(boardNo ==1){ %>selected="selected"<% }%>>재능기부</option>
	<option value="2"<% if(boardNo ==2){ %>selected="selected"<% }%>>자유게시판</option>
	<option value="3"<% if(boardNo ==3){ %>selected="selected"<% }%>>QnA</option>
	</select>
</div>
<table class="table table-hover" id="table">
<tr><th width = "50pt">No</th><th width="150pt">구 분</th><th width="70pt">글 번호</th><th width="400pt"><div align="center">제 목</div></th><th>조회수</th><th width = "100pt">작성자</th><th width="150pt">작성일</th>
<% if(listCount != 0){ %>
	<% for(MyWrite d : list){ %>
	<tr>
	<td align="center"><%= d.getListNo() %></td>
	<td><%= d.getBoardName() %></td>
	<td><%= d.getBoardNo() %></td>
	<% if(d.getBoardName().equals("재능기부")){ %>
	<td><a href="/semi/cdetail?cnum=<%=d.getBoardNo() %>&cpage=<%= currentPage%>"><%= d.getTitle() %></a></td>
	<% }else if(d.getBoardName().equals("자유게시판")){ %>
	<td><a href="/semi/fdetail?no=<%=d.getBoardNo()%>"><%= d.getTitle() %></a></td>
	<% }else if(d.getBoardName().equals("QnA")){ %>
	<td><a href="/semi/qdetail?no=<%= d.getBoardNo() %>&page=<%= currentPage %>"><%= d.getTitle() %></a></td>
	<% } %>
	<td><%= d.getCount() %></td>
	<td><%= d.getWriter() %></td>
	<td><%= d.getWriteDate()%></td>
	</tr>
	<% } %>
<% }else{ %>
	<tr>
		<td colspan="7" align="center" style="font-size:10pt; color:gray;">게시글이 없습니다</td>
	</tr>
<% } %>
</table>
<div align ="center">
<% if(currentPage <=1){ %>
	[이전] &nbsp;
	<%}else{ %>
	<a href="/semi/mylist?page=<%= currentPage -1%>&memberid=<%= member.getMemberId() %>&value=<%= boardNo %>">[이전]</a>
	<% } %>
	<% for(int p = startPage;p<=endPage;p++){
		if(p==currentPage){
	%>
	<b><font size="4"color="red">[<%= p %>]</font></b>
	<%}else{ %>
	<a href="/semi/mylist?page=<%= p %>&memberid=<%= member.getMemberId() %>&value=<%= boardNo %>"><%= p %></a>
	<% }} %>
	<% if(currentPage >= maxPage){ %>
	[다음]
	<%}else{ %>
	<a href="/semi/mylist?page=<%= currentPage+1 %>&memberid=<%= member.getMemberId() %>&value=<%= boardNo %>">[다음]</a>
	<% } %>
</body>
</html>