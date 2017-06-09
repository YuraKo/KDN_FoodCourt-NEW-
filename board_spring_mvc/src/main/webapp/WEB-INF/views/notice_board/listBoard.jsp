<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*,com.kdn.model.domain.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id="noticePageBean" class="com.kdn.model.domain.NoticePageBean" scope="request" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function noticePagelist(cpage) {
		document.getElementById("noticePageNo").value = cpage;
		var nfrm = document.getElementById("nfrm");
		nfrm.action = "listNoticeBoard.do";
		nfrm.submit();
	}
	function getNoticeBoard(nno) {
		document.getElementById("nno").value = nno;
		var nfrm = document.getElementById("nfrm");
		nfrm.action = "searchNoticeBoard.do";
		nfrm.submit();
	}
</script>
<link rel="stylesheet" type="text/css" href="css/basic.css" />
</head>
<body>
	<div class="main">
		<div class="check_member_grade">
			<%-- <c:choose>
				<c:when test='${grade == "Y"}'>
					<a href="insertNoticeBoardForm.do">NEW</a>
				</c:when>
			</c:choose> --%>
			<c:if test="${!empty grade and grade=='Y' }">
				<a href="insertNoticeBoardForm.do">NEW</a>
			</c:if>
		</div>
		<form id="nfrm">
			<input type="hidden" id="noticePageNo" name="noticePageNo" value="1" /> 
			<input type="hidden" id="nno" name="nno" />
			<c:forEach var="noticeBoard" items="${noticeList}">
				<div class="col-md-2 text-center">
					<p class="">
						<span class="glyphicon glyphicon-calendar" aria-hidden="true"></span>
					</p>
				</div>
				<div class="col-md-10 text-justify">
					<h3>${noticeBoard.title}</h3>
					<p>${noticeBoard.ndate}</p>
					<br />
					<p>${noticeBoard.contents }</p>
				</div>
			</c:forEach>
			<div class="bottom">
				<center>${noticePageBean.pagelink }</center>
			</div>
		</form>
	</div>
</body>
</html>













