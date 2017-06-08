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
<script type="text/javascript">
	//조건 검색, 페이지 번호로 게시글 요청을 위한 메서드  
	function pagelist(cpage){
		//input 양식의 hidden으로 선언된 page에 요청된 페이지 정보 셋팅 
		document.getElementById("pageNo").value=cpage;
		var frm = document.getElementById("frm");
		frm.action="listReview.do";
		frm.submit();
	}
	//게시글 번호나 타이틀을 클릭하면 해당 게시글 요청을 위한 메서드 
	function getBoard(no){
		//input 양식의 hidden으로 선언된 no(게시글 번호)에 요청된 게시글 번호를 셋팅
		document.getElementById("no").value = no;
		var frm = document.getElementById("frm");
		frm.action="searchReview.do";
		frm.submit();
	}
</script>
<link rel="stylesheet" type="text/css" href="css/basic.css" />
<style type="text/css">
#lion:hover{
	src="images/lion1.gif";
}
</style>
</head>
<body>
	<div class="main">
		<form id="frm">
			<input type="hidden" id="pageNo" name="pageNo" value="1" /> <input
				type="hidden" id="no" name="no" />
			<table align="center">
				<tr align="center">
					<td colspan="3" height="100" align="center" >
					<select name="key" id="key" class="btn btn-success btn-filter">
							<option value="all">-----all-----</option>
							<option value="id" <%=pageBean.getKey("rno")%>>아이디</option>
							<option value="title" <%=pageBean.getKey("spoint")%>>별점</option>
							<option value="contents" <%=pageBean.getKey("fname")%>>음식</option>
							<option value="contents" <%=pageBean.getKey("comments")%>>내용</option>
					</select> <input type="text" id="word" name="word" value="${pageBean.word}" class="btn btn-default btn-filter">
						<a href="#" onclick="pagelist(1)" class="btn btn-danger btn-filter">검색</a> 
						<a href="insertReviewForm.do" class="btn btn-warning btn-filter">글쓰기</a>
						<a href="insert.do" class="btn btn-warning btn-filter">삭제</a>
					</td>
				</tr>
				<tr align="center">
					<div class="table-container">
						<table id = "r-table" class="table table-filter">
							<tbody>
								<tr data-status="pagado">
										<c:forEach var="review" items="${reviewList}">
										<td>
											<a href="javascript:;" class="star">
												<i class="glyphicon glyphicon-star"></i>
											</a>
										</td>
										<div class="media">
											
											<a href="#" class="pull-left" id = "lion"> <img
												src="images/lion.png"
												class="media-photo">
											</a>
											<div class="media-body">
												<span class="media-meta pull-right"></span>
												<h4 class="title">
													<span  class="pull-right pagado">${review.regdate}</span>
												</h4>
												<h2 class="summary">${review.contents }</h2>
											</div>
										</div></c:forEach>
								</tr>
							</tbody>
						</table>
					</div>
				</tr>
			</table>
			<div class="bottom">
				<center>${pageBean.pagelink }</center>
			</div>
		</form>
	</div>
	
	<script type="text/javascript">
	$(document).ready(function () {

		$('.star').on('click', function () {
	      $(this).toggleClass('star-checked');
	    });

	    $('.ckbox label').on('click', function () {
	      $(this).parents('tr').toggleClass('selected');
	    });

	    $('.btn-filter').on('click', function () {
	      var $target = $(this).data('target');
	      if ($target != 'all') {
	        $('.table tr').css('display', 'none');
	        $('.table tr[data-status="' + $target + '"]').fadeIn('slow');
	      } else {
	        $('.table tr').css('display', 'none').fadeIn('slow');
	      }
	    });

	 });
	</script>
</body>
</html>













