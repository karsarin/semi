<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta  charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
공지사항 오류입니다. : <%= (String)request.getAttribute("message") %>
<a href="/semi/index.jsp">시작 페이지로 이동</a>
</body>
</html> 