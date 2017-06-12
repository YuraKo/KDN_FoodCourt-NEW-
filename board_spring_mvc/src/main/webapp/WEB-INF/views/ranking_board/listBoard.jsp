<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*,com.kdn.model.domain.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id="noticePageBean"
	class="com.kdn.model.domain.RankingPageBean" scope="request" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function rankingPagelist(cpage) {
		//input 양식의 hidden으로 선언된 page에 요청된 페이지 정보 셋팅 
		document.getElementById("reviewPageNo").value = cpage;
		var rkfrm = document.getElementById("rkfrm");
		rkfrm.action = "listRanking.do";
		rkfrm.submit();
	}
</script>
<link rel="stylesheet" type="text/css" href="css/basic.css" />
</head>
<body>
	<div class="main">
		<form id="rfrm">
		<a href="#" onclick="rankingPagelist(1)" class="btn btn-danger btn-filter">검색</a>
			<div class="col-md-12 text-center">
				<ul class="list-unstyled text-center">
					<li class="filter btn btn-success" data-filter=".dishes">아침</li>
					<li class="filter btn btn-success" data-filter=".restaurant">한식</li>
					<li class="filter btn btn-success" data-filter=".garden">일품</li>
					<li class="filter btn btn-success" data-filter=".kids">저녁</li>
					<li class="filter btn btn-success" data-filter="all">전체</li>
				</ul>
			</div>
			<div class="mix restaurant col-md-4">
				<a href="images/gallery/gallery1.jpg" class="img-wrapper"> <img
					class="img-responsive" src="images/gallery/gallery1.jpg" />
				</a>
			</div>
			<div class="mix restaurant col-md-4">
				<a href="images/gallery/gallery2.jpg" class="img-wrapper"> <img
					class="img-responsive" src="images/gallery/gallery2.jpg" />
				</a>
			</div>
			<div class="mix restaurant col-md-4">
				<a href="images/gallery/gallery3.jpg" class="img-wrapper"> <img
					class="img-responsive" src="images/gallery/gallery3.jpg" />
				</a>
			</div>
			<div class="mix restaurant col-md-4">
				<a href="images/gallery/gallery4.jpg" class="img-wrapper"> <img
					class="img-responsive" src="images/gallery/gallery4.jpg" />
				</a>
			</div>
			<div class="mix garden col-md-4">
				<a href="images/gallery/gallery5.jpg" class="img-wrapper"> <img
					class="img-responsive" src="images/gallery/gallery5.jpg" />
				</a>
			</div>
			<div class="mix garden col-md-4">
				<a href="images/gallery/gallery6.jpg" class="img-wrapper"> <img
					class="img-responsive" src="images/gallery/gallery6.jpg" />
				</a>
			</div>
			<div class="mix dishes col-md-4">
				<a href="images/gallery/gallery7.jpg" class="img-wrapper"> <img
					class="img-responsive" src="images/gallery/gallery7.jpg" />
				</a>
			</div>
			<div class="mix dishes col-md-4">
				<a href="images/gallery/gallery8.jpg" class="img-wrapper"> <img
					class="img-responsive" src="images/gallery/gallery8.jpg" />
				</a>
			</div>
			<div class="mix dishes col-md-4">
				<a href="images/gallery/gallery9.jpg" class="img-wrapper"> <img
					class="img-responsive" src="images/gallery/gallery9.jpg" />
				</a>
			</div>
			<div class="mix dishes col-md-4">
				<a href="images/gallery/gallery10.jpg" class="img-wrapper"> <img
					class="img-responsive" src="images/gallery/gallery10.jpg" />
				</a>
			</div>
			<div class="mix dishes col-md-4">
				<a href="images/gallery/gallery11.jpg" class="img-wrapper"> <img
					class="img-responsive" src="images/gallery/gallery11.jpg" />
				</a>
			</div>
			<div class="mix dishes col-md-4">
				<a href="images/gallery/gallery12.jpg" class="img-wrapper"> <img
					class="img-responsive" src="images/gallery/gallery12.jpg" />
				</a>
			</div>
			<div class="mix kids col-md-4">
				<a href="images/gallery/gallery13.jpg" class="img-wrapper"> <img
					class="img-responsive" src="images/gallery/gallery13.jpg" />
				</a>
			</div>
			<div class="mix kids col-md-4">
				<a href="images/gallery/gallery14.jpg" class="img-wrapper"> <img
					class="img-responsive" src="images/gallery/gallery13.jpg" />
				</a>
			</div>
		</form>
	</div>
</body>
</html>













