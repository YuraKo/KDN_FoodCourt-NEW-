<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*,com.kdn.model.domain.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id="pageBean" class="com.kdn.model.domain.PageBean"
	scope="request" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<link href="css/kdn-table.css" rel="stylesheet">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/basic.css" />
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.4.0/css/font-awesome.min.css"
	rel='stylesheet' type='text/css'>
<style type="text/css">
</style>
</head>
<body>
		<table border = 1>
			<tr>
				<th></th><th colspan = 2>월</th><th colspan = 2>화</th><th colspan = 2>수</th><th colspan = 2>목</th><th colspan = 2>금</th>
			</tr>
			<tr>
				<td>아침</td><td colspan = 2></td><td colspan = 2></td><td colspan = 2></td><td colspan = 2></td><td colspan = 2></td>
			</tr>
			<tr>
				<td rowspan = 2>점심</td><td>일식</td><td>한식</td><td>일식</td><td>한식</td><td>일식</td><td>한식</td><td>일식</td><td>한식</td><td>일식</td><td>한식</td>
			</tr>
			<tr>
				<td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>
			</tr>
			<tr>
				<td>저녁</td><td colspan = 2></td><td colspan = 2></td><td colspan = 2></td><td colspan = 2></td><td colspan = 2></td>
			</tr>
		</table>

</body>
</html>













