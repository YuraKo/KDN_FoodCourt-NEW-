<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,com.kdn.model.domain.*"  %>
<%@ taglib prefix="c"    uri="http://java.sun.com/jsp/jstl/core"%> 
<jsp:useBean 	id="pageBean"         class="com.kdn.model.domain.PageBean" 
				scope="request"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function pagelist(cpage){
		document.getElementById("pageNo").value=cpage;
		var nfrm = document.getElementById("nfrm");
		nfrm.action="listNoticeBoard.do";
		nfrm.submit();
	}
	function getNoticeBoard(nno){
		document.getElementById("nno").value = nno;
		var nfrm = document.getElementById("nfrm");
		nfrm.action="searchNoticeBoard.do";
		nfrm.submit();
	}
</script>
<link rel="stylesheet" type="text/css" href="css/basic.css" />
</head>
<body>
	<div class="main">
	<a href="insertBoardForm.do">NEW</a></td>
		<form id="nfrm">
			<input type="hidden" id="pageNo" name="pageNo" value="1" /> 
			<input type="hidden" id="nno" name="nno" />
			<c:forEach var="noticeBoard" items="${list }">
				<div class="col-md-2 text-center">
					<p class="">
						<span class="glyphicon glyphicon-calendar" aria-hidden="true"></span>
					</p>
				</div>
				<div class="col-md-10 text-justify">
					<h3>${noticeBoard.nno }</h3>
					<p>${noticeBoard.ndate }</p>
					<br />
					<p>${noticeBoard.contents }</p>
				</div>
			</c:forEach>
			<div class="bottom">
				<center>${pageBean.pagelink }</center>
			</div>
		</form>
	</div>
</body>
</html>













