<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

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
	background: #FFBA85 ; 
}


#menuBarBorder{
	
	padding-top : 0px;
	margin-left:10px;
	margin-right:10px;
	width:220px;
	height:155px;
	background-color:#EAEAEA;
}
#leftmebuBarTitle{
	text-align:center;
	font-weight : bold;
	background-color: #F29661;
}
</style>


</head>

<body>


<div id="menuBarBorder">			
			<div style="margin-left: 10px; width: 240px; height: 170px;">
				<ul id="navi">
					<li class="group">
						<div class="title" id="leftmebuBarTitle" >커뮤니티</div>
						<ul class="sub">
							<li><a href="/semi/nlist" align="center" >공지사항</a></li>
							<li><a href="/semi/flist" align="center">자유 게시판</a></li>
							<li><a href="/semi/qlist" align="center">QnA게시판</a></li>
						</ul>
					</li>
				</ul>
			</div>

</div>
	





</body>
</html>