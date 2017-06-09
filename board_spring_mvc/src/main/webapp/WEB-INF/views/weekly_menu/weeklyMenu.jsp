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
	<c:forEach var = "diets" items = "${dietList}">
		<span>식단 번호 : </span> ${diets.dietNo}<br/>
		<span>아 점 저 : </span>  ${diets.scode}<br/>
		<span>식단 날짜 : </span> ${diets.dietDate}<br/>
		<span>메인 음식 :</span>  ${diets.mainDish}<br/>
		<span> 반찬 : </span>   ${diets.sideDish}<br/>
		<hr/>
	</c:forEach>
</body>
</html>













