<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<meta charset=UTF-8">
<title>sideMenu</title>
<link rel="stylesheet" href="/semi/css/rightMenu.css">
</head>
<body>
	<!--  오른쪽 메뉴바 -->
	<div class="right_menu" style="margin-top:180px;">
		<ul align="center">
			<li id="rtitle">
				<p>다재<br>다능</p>
			</li>
			<li id="m1">
				<a href="#"	onclick="window.open('/semi/views/usage/usage.html','usage','resizable=no ,width=650,left=500,top=100, height=650');return false">
					<image src="/semi/images/rightmenu_m1.png" align="center" width="100px" height="80px"></image>
				</a>
				<p>이용방법</p>
			</li>
			<li id="m2">
				<a href="#" onclick="window.open('/semi/views/usage/usage2.html','usage1','resizable=no ,width=650,left=500,top=100, height=400');return false">
					<image src="/semi/images/rightmenu_m2.png" align="center" width="100px" height="80px"></image>
				</a>
				<p>이용방법<br>동영상</p>
			</li>
			<li id="m3">
				<a href="#" onclick="window.open('/semi/views/usage/usage3.html','usage2','resizable=no ,width=450,left=500,top=100, height=450');return false">
					<image src="/semi/images/rightmenu_m3.png" align="center" width="100px" height="80px"></image>
				</a>
				<p>필수사항</p>
			</li>
			<li id="m4">
				<a href="#" onclick="window.open('/semi/views/usage/usage4.html','usage3','resizable=no ,width=500,left=500,top=100, height=400');return false">
					<image src="/semi/images/rightmenu_m4.png" align="center" width="100px" height="80px"></image>
				</a>
				<p>이벤트</p>
			</li>
		</ul>
	</div>
</body>
</html>