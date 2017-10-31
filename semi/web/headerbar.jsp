<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="donation.member.model.vo.Member"%>

<!DOCTYPE html >
<html>
<head>
<meta charset="UTF-8">
<title>header</title>

<%-- 헤더바 --%>
<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700,800' rel='stylesheet' type='text/css'>
<link rel="stylesheet" href="/semi/css/bootstrap.min.css">
<link rel="stylesheet" href="/semi/css/font-awesome.css">
<link rel="stylesheet" href="/semi/css/animate.css">
<link rel="stylesheet" href="/semi/css/templatemo_misc.css">
<link rel="stylesheet" href="/semi/css/templatemo_style.css">
<script src="js/vendor/jquery-1.11.0.min.js"></script>
<script>window.jQuery || document.write('<script src="js/vendor/jquery-1.11.0.min.js"><\/script>')</script>
<script src="/semi/js/bootstrap.js"></script>
<script src="/semi/js/plugins.js"></script>
<script src="/semi/js/main.js"></script>
<script src="/semi/js/vendor/modernizr-2.6.1-respond-1.1.0.min.js"></script>
<%-- 헤더바 끝 --%>

<script type="text/javascript">
        function goBoardPage() { location.href="/semi/nlist"; }
        function goHomePage() { location.href="/semi/index.jsp"; }        
        function goCategoryPage(){location.href="/semi/clist";}
       	function insertCategory(){location.href="/semi/views/category/categoryInsertView.jsp";}
       	function loginView(){
       		alert("재능 등록을 위해선 로그인이 필요합니다. 로그인 화면으로 이동합니다.");
       		location.href="/semi/views/member/Login.jsp"
       		}
</script>
</head>
<body>
	<%@ include file="header.jsp"%>
	<%if(member!=null&&member.getMemberId().equals("admin")) { %>
	<%@ include file="../views/manager/managerHeader.jsp" %>
	<% } else { %> 
	<br><br><hr style="border-style:none">
	<div class="main-header">
		<div class="container">
			<div id="menu-wrapper">
				<div class="row">
					<div class="logo-wrapper col-md-4 col-sm-2">
						<a style="text-shadow:1px 1px 1px gray;">다재다능</a>
					</div>
					<!-- /.logo-wrapper -->
					<div class="col-md-8 col-sm-10 main-menu text-right">
						<div class="toggle-menu visible-sm visible-xs">
							<i class="fa fa-bars"></i>
						</div>
						<ul class="menu-first">
							<li style="margin-right:30px;">
								<form action="/semi/tsearch" method="post">
									<input type="search" name="keyword" autocomplete style="width:200px; height:auto;">
									<input type="submit" value="search" style="height:auto; background:white;">
								</form>
							</li>
							<li id="home"><a href="javascript:goHomePage()">Home</a></li>
							<li id="category"><a href="javascript:goCategoryPage()">카테고리</a></li>
							<li id="board"><a href="javascript:goBoardPage()">게시판</a></li>							
							<% if(member!=null){ %>
							<li id="insertc"><a href="javascript:insertCategory()">재능 등록</a></li>
							<% } else { %>
							<li><a href="javascript:loginView()">재능 등록</a></li>
							<% } %>							
						</ul>
					</div>
					<!-- /.main-menu -->
				</div>
				<!-- /.row -->
			</div>
			<!-- /#menu-wrapper -->
		</div>
		<!-- /.container -->
	</div>
	<!-- /.main-header -->
	</div>
	<!-- /.site-header -->
	<%} %>
	<script src="/semi/js/vendor/jquery-1.11.0.min.js"></script>
	<script>window.jQuery || document.write('<script src="js/vendor/jquery-1.11.0.min.js"><\/script>')</script>
	<script src="/semi/js/bootstrap.js"></script>
	<script src="/semi/js/plugins.js"></script>
	<script src="/semi/js/main.js"></script>
</body>
</html>