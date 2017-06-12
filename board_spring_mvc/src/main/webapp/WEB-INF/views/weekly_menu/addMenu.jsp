<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	.blackColor {
		color : black;
	}
</style>
<script type="text/javascript">
	var count = 1;
	$(document).ready(function(){
		$("#addButton").click(function(){
			console.log("test");
			var html = "<input type = 'text'  name = 'sideDish' id = sideDish" + count + "><span>&nbsp&nbsp</span><button onclick = deleteAttr('sideDish" + count + "')>삭제</button><br/>";
			$("#foodDiv").append(html);
		});
	});
	
	function deleteAttr(attr){
		console.log(attr);
		var item = document.getElementById(attr);
		item.remove();
	}
</script>
</head>
<body>
	<div>
		<table width = "500px" >
			<tr>
				<td>식단</td>
				<td colspan = "2" class = "blackColor">
					<select name="scode" id="scode">
					    <option value="1">아침</option>
					    <option value="2">일품</option>
					    <option value="3">한식</option>
					    <option value="4">저녁</option>
					</select>
				</td>
			</tr>
			<tr>
				<td >메인 메뉴</td>
				<td colspan = "2" class = "blackColor"><input type = "text"  name = "mainDish" id = "mainDish"></td>
			</tr>
			<tr>
				<td>반찬</td>
				<td class = "blackColor" id = "foodDiv">
					
				</td>
				<td><button id = "addButton">추가</button></td>
			</tr>
		</table>
	</div>
</body>
</html>