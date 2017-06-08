<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">



</style>
<script type="text/javascript" src="js/jquery-1.10.1.js"></script>
<script type="text/javascript">
$(function(){
	$("#addFile").click(addFileForm);
});
var count=0;   //file form index
function addFileForm(){
	var html="<div id='item_"+count+"'>"
	html+="<input type='file' name='fileup' id='items"+count+"' />";
	html+="<input type='button' value='삭제' onclick='removeForm("+count+")'/></div>";
	count++;
	//html=$("#content").html()+html;
	//$("#content").html(html);
	$("#fileUpForm").append(html);
}
function removeForm(count){
	var item = document.getElementById('item_'+count);
	if(item !=null) item.parentNode.removeChild(item);
}
</script>
</head>
<body>
<form method="post" action="insertNoticeBoard.do" enctype="multipart/form-data" >
<div class="container-noticeboardinsert">
    <div class="container">
        <div class="row" id="insertNoticeBoardRow">
			<div class="col-md-8">
                <form>
                    <div class="row">
                        <div class="page-header" id="insertBoard">
                            <h3 class="text-center">New Announcement</h3>
                        </div>
                        <div class="col-md-6">
                            <div class="form-group">
                                <input type="text" class="form-control" name="mno" id="mno" placeholder="Register Number" />
                            </div>
                        </div>
                        <div class="col-md-6">
                           <!-- 원래 여기 작성자 이름이랑 날짜 입력 부분 있었음 -->
                           <!-- 위에 있던 제목 입력 부분 여기로 내림 -->
                            <div class="form-group">
                                <input type="text" class="form-control" name="title" id="title"placeholder="Title" />
                            </div>
                        </div>
                        <div class="col-md-12 text-center">
                            <div class="form-group">
                                <textarea class="form-control" name="contents" id="contents" placeholder="Enter announcement to be notified" rows="6"></textarea>
                            </div>
                            <button type="submit" class="btn btn-danger">Submit</button>
                            <button type="submit" class="btn btn-default">Cancel</button> <br/><br/>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
</form>
</body>
</html>