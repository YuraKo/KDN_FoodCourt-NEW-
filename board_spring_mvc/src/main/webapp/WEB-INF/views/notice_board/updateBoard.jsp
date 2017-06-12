<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link  rel="stylesheet" type="text/css" href="css/basic.css"  />
<script type="text/javascript">
	function init(){
		var writeNoticeBoard = document.getElementById("writeNoticeBoard");
		writeNoticeBoard.style.display="";
	}
	function updateNoticeBoard(){
		var nfrm = document.getElementById("updatenfrm");
		nfrm.action="updateNoticeBoard.do";
		nfrm.submit();
	}
	function deleteNoticeBoard(){
		var nfrm = document.getElementById("nfrm");
		nfrm.action="deleteNoticeBoard.do";
		nfrm.submit();
	}
	function listNoticeBoard(){
		location.href="listNoticeBoard.do?<%=request.getQueryString()%>";
	}
	function resetNoticeBoard(){
		var nfrm = document.getElementById("updatenfrm");
		nfrm.title.value="";
		nfrm.content.value="";
	}
</script>
</head>
<body onload="init()">
    <c:if test="${msg != null }"> 
    	<script type="text/javascript">  alert('${msg}');</script>
    </c:if>
    
    <form method="post" action="updateNoticeBoard.do" enctype="multipart/form-data">
		<div class="container-noticeboardinsert">
			<div class="container">
				<div class="row" id="updateNoticeBoardRow">
					<div class="col-md-8">
						<form>
							<div class="row">
								<div class="page-header" id="insertBoard">
									<h3 class="text-center">Update Announcement</h3>
								</div>
								<div class="col-md-6">
									<div class="form-group">
										<input type="hidden" class="form-control" name="mno" id="mno"
											value="${mno}" placeholder="Register Number" />
									</div>
								</div>
								<div class="col-md-6">
									<div class="form-group">
										<input type="hidden" class="form-control" name="nno" id="nno"
											value="${noticeBoard.nno}" placeholder="Register Number" />
									</div>
								</div>
								<div class="col-md-12">
									<div class="form-group">
										<input type="text" class="form-control" name="title" value="${noticeBoard.title }"
											id="title" placeholder="Title" />
									</div>
								</div>
								<div class="col-md-12 text-center">
									<div class="form-group">
										<textarea class="form-control" name="contents" id="contents"
											placeholder="Enter announcement to be notified" rows="6">${noticeBoard.contents}</textarea>
									</div>
									<a href="listNoticeBoard.do" class="btn btn-default">Cancel</a>
									<button type="submit"  class="btn btn-danger">Submit</button>
									<br />
									<br />
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</form>
        
	<%-- <div class="main" id="writeNoticeBoard" style="display:none">
	 	<form  id="updatenfrm" method="post">
	 	    <input type ="hidden" name="nno"  id="nno"  value="${noticeBoard.nno}"/>
	 	    <input type ="hidden" name="mno"  id="mno"  value="${noticeBoard.mno}"/>
			<table border="1" align="center">
				<caption>게시글 작성</caption>
				<tbody>
					<tr><td><label for="title">제목</label></td>
					    <td><input type="text" name="title" id="title" value="${noticeBoard.title}"/></td>
					</tr>
					<tr><td colspan="2">내용</td></tr>
					<tr><td colspan="2">
						<textarea name="contents" id="contents" cols="30" rows="10">
							${noticeBoard.contents}
						</textarea>
						</td></tr>
				</tbody>
				<tfoot>
					<tr><td colspan="2" align="center">
						<a href="#" onclick="updateNoticeBoard()"> 수정 </a> 
						<a href="#" onclick="resetNoticeBoard()"> 다시 쓰기</a> 
						<a href="#" onclick="listNoticeBoard()"> 목 록</a>
						</td>
					</tr>
				</tfoot>
			</table>
		</form>
	</div> --%>
</body>
</html>