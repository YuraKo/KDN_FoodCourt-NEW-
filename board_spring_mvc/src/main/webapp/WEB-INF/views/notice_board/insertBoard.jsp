<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
<div class="container-reservations">
    <div class="container">
        <div class="row">
			<div class="col-md-8">
                <form>
                    <div class="row">
                        <div class="page-header" id="insertBoard">
                            <h1 class="text-center text-default">Edit Notice Board</h1>
                        </div>
                        <div class="col-md-6">
                            <div class="form-group">
                                <input type="text" class="form-control" name="mno" id="mno" placeholder="ID" />
                            </div>
                            <div class="form-group">
                                <input type="text" class="form-control" name="title" id="title"placeholder="Title" />
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-group">
                                <input type="text" class="form-control" name="mname" id="mname"placeholder="Name" />
                            </div>
                            <div class="form-group">
                                <input type="text" class="form-control" name="ndate" id="ndate" placeholder="Date" />
                            </div>
                        </div>
                        <div class="col-md-12 text-center">
                            <div class="form-group">
                                <textarea class="form-control" placeholder="Enter anonouncement to be notified" rows="6"></textarea>
                            </div>
                            <button type="submit" class="btn btn-default">Cancel</button>
                            <button type="submit" class="btn btn-danger">Submit</button>
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