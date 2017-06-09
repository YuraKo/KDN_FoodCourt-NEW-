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
	function pagelist(cpage) {
		//input 양식의 hidden으로 선언된 page에 요청된 페이지 정보 셋팅 
		document.getElementById("pageNo").value = cpage;
		var frm = document.getElementById("frm");
		frm.action = "listReview.do";
		frm.submit();
	}
	//게시글 번호나 타이틀을 클릭하면 해당 게시글 요청을 위한 메서드 
	function getBoard(no) {
		//input 양식의 hidden으로 선언된 no(게시글 번호)에 요청된 게시글 번호를 셋팅
		document.getElementById("rno").value = rno;
		var frm = document.getElementById("frm");
		frm.action = "searchReview.do";
		frm.submit();
	}
</script>
<link rel="stylesheet" type="text/css" href="css/basic.css" />
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.4.0/css/font-awesome.min.css"
	rel='stylesheet' type='text/css'>
<style type="text/css">
</style>
</head>
<body>
	<div class="main">
		<form id="frm">
			<input type="hidden" id="pageNo" name="pageNo" value="1" /> <input
				type="hidden" id="no" name="no" />

			<div class="container">
				<div class="row">

					<div class="col-md-10 col-md-offset-1">

						<div class="panel panel-default panel-table">
							<div class="panel-heading">
								<div class="row">
									<div class="col col-xs-6">
										<select name="key" id="key" class="btn btn-success btn-filter">
											<option value="all">-----all-----</option>
											<option value="rno" <%=pageBean.getKey("rno")%>>리뷰번호</option>
											<option value="mno" <%=pageBean.getKey("mno")%>>사원번호</option>
											<option value="fname" <%=pageBean.getKey("fname")%>>음식이름</option>
											<option value="spoint" <%=pageBean.getKey("spoint")%>>별점</option>
											<option value="comments" <%=pageBean.getKey("comments")%>>코멘트</option>
										</select> <input type="text" id="word" name="word"
											value="${reviewPageBean.word}"
											class="btn btn-default btn-filter"> <a href="#"
											onclick="pagelist(1)" class="btn btn-danger btn-filter">검색</a>

									</div>
									<div class="col col-xs-6 text-right">
										<c:if test="${ !empty mno }">
											<a href="#"
												class="btn btn-sm btn-primary btn-create"
												data-toggle="modal" data-target="#reviewModal">글쓰기</a>
										</c:if>
									</div>
								</div>
							</div>
							<div class="panel-body">
								<table class="table table-striped table-bordered table-list">
									<thead>
										<tr>
											<th><em class="fa fa-cog"></em></th>
											<th class="hidden-xs">리뷰번호</th>
											<th>사원번호</th>
											<th>음식이름</th>
											<th>별점</th>
											<th>코멘트</th>
											<th>등록일</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="reviewBoard" items="${list}">
											<tr>

												<td align="center"> <c:if
														test="${ mno == reviewBoard.mno }">  
														<a href="#" class="btn btn-default" data-toggle="modal" data-target="#updateReviewModal" > 
														<em class="fa fa-pencil"></em></a>
														<a href="#" class="btn btn-danger"><em
															class="fa fa-trash"
															data-toggle="modal" data-target="#deleteReviewModal"></em></a>
													 </c:if>  </td>

												<td class="hidden-xs">${reviewBoard.rno}</td>
												<td>${reviewBoard.mno }</td>
												<td>${reviewBoard.fname }</td>
												<td>${reviewBoard.spoint }</td>
												<td>${reviewBoard.comments}</td>
												<td>${reviewBoard.regdate }</td>

												<td>
											</tr>
										</c:forEach>
									</tbody>
								</table>

							</div>
							<div class="panel-footer">
								<div class="row">
									<center>${reviewPageBean.pagelink }</center>
								</div>
							</div>
						</div>

					</div>
				</div>
			</div>




			<%-- <table align="center">
				<tr align="center">
					<td colspan="3" height="100" align="center">
					<select
						name="key" id="key" class="btn btn-success btn-filter">
							<option value="all">-----all-----</option>
							<option value="rno" <%=pageBean.getKey("rno")%>>아이디</option>
							<option value="spoint" <%=pageBean.getKey("spoint")%>>별점</option>
							<option value="fname" <%=pageBean.getKey("fname")%>>음식</option>
							<option value="comments" <%=pageBean.getKey("comments")%>>내용</option>
					</select> <input type="text" id="word" name="word" value="${reviewPageBean.word}"
						class="btn btn-default btn-filter"> <a href="#"
						onclick="pagelist(1)" class="btn btn-danger btn-filter">검색</a> 
						<c:if test="${ !empty mno }">
						<a href="insertReviewForm.do" class="btn btn-warning btn-filter">글쓰기</a>
						<a href="insert.do" class="btn btn-warning btn-filter">삭제</a></td>
						</c:if>
				</tr>
				<tr align="center">
					<div class="table-container">
						<table id="r-table" class="table table-filter">
							<tbody>
								<tr data-status="pagado">
									<c:forEach var="reviewBoard" items="${list}">
										<div class="col-md-2 text-center">
											<p class="">
												<span class="glyphicon glyphicon-calendar"
													aria-hidden="true"></span>
											</p>
										</div>
										<div class="col-md-10 text-justify">
											<p>${reviewBoard.rno}</p>
											<p>${reviewBoard.mno }</p>
											<p>${reviewBoard.spoint }</p>
											<p>${reviewBoard.fno }</p>
											<p>${reviewBoard.fname }</p>
											<p>${reviewBoard.comments}</p>
											<p>${reviewBoard.regdate }</p>
										</div>
									</c:forEach>
								</tr>
							</tbody>
						</table>
					</div>
				</tr>
			</table>
			<div class="bottom">
				<center>${reviewPageBean.pagelink }</center>
			</div> --%>
		</form>
	</div>



	<script type="text/javascript">
		$(document).ready(
				function() {

					$('.star').on('click', function() {
						$(this).toggleClass('star-checked');
					});

					$('.ckbox label').on('click', function() {
						$(this).parents('tr').toggleClass('selected');
					});

					$('.btn-filter').on(
							'click',
							function() {
								var $target = $(this).data('target');
								if ($target != 'all') {
									$('.table tr').css('display', 'none');
									$(
											'.table tr[data-status="' + $target
													+ '"]').fadeIn('slow');
								} else {
									$('.table tr').css('display', 'none')
											.fadeIn('slow');
								}
							});

				});
	</script>
</body>
</html>













