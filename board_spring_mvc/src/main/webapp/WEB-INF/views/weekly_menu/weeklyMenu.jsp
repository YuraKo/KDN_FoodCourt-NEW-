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
<style type="text/css">
	th {
		text-align : center;
		font-size : 12px;
	}
	a {
		color : magenta;
	}
</style>
<script type="text/javascript">
	function writeReviewInMenu(fname){
		console.log(fname);
		$("#fname").val(fname);
	}
</script>
</head>
<body>
	<div style ="float:left;">
		<c:if test = "${!empty mno }">
			<a href = "addWeeklyMenuForm.do" >Add Menu</a>
    	</c:if>
    </div> 
	<div>
		<table width = "1100px" border = 1>
			<thead>
				<tr>
					<th rowspan = 2></th><th colspan = 2>월</th><th colspan = 2>화</th><th colspan = 2>수</th><th colspan = 2>목</th><th colspan = 2>금</th>
				</tr>
				<tr>
					<th colspan = 2>${dietList[0].dietDate }</th>
					<th colspan = 2>${dietList[4].dietDate }</th>
					<th colspan = 2>${dietList[8].dietDate }</th>
					<th colspan = 2>${dietList[12].dietDate }</th>
					<th colspan = 2>${dietList[16].dietDate }</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>아침</td><td colspan = 2><a href = "#" data-toggle="modal" data-target="#reviewModal" onclick = "writeReviewInMenu('${dietList[0].mainDish}')">${dietList[0].mainDish }</a><br/>${dietList[0].sideDish }</td>
							    <td colspan = 2><a href = "#" data-toggle="modal" data-target="#reviewModal" onclick = "writeReviewInMenu('${dietList[4].mainDish}')">${dietList[4].mainDish }</a><br/>${dietList[4].sideDish }</td>
							    <td colspan = 2><a href = "#" data-toggle="modal" data-target="#reviewModal" onclick = "writeReviewInMenu('${dietList[8].mainDish}')">${dietList[8].mainDish }</a><br/>${dietList[8].sideDish }</td>
							    <td colspan = 2><a href = "#" data-toggle="modal" data-target="#reviewModal" onclick = "writeReviewInMenu('${dietList[12].mainDish}')">${dietList[12].mainDish }</a><br/>${dietList[12].sideDish }</td>
							    <td colspan = 2><a href = "#" data-toggle="modal" data-target="#reviewModal" onclick = "writeReviewInMenu('${dietList[16].mainDish}')">${dietList[16].mainDish }</a><br/>${dietList[16].sideDish }</td>
				</tr>
				<tr>
					<td rowspan = 2>점심</td><td>일품</td><td>한식</td>
										   <td>일품</td><td>한식</td>
										   <td>일품</td><td>한식</td>
										   <td>일픔</td><td>한식</td>
										   <td>일품</td><td>한식</td>
				</tr>
				<tr>
					<td><a href = "#" data-toggle="modal" data-target="#reviewModal" onclick = "writeReviewInMenu('${dietList[1].mainDish}')">${dietList[1].mainDish }</a><br/>${dietList[1].sideDish }</td>
					<td><a href = "#" data-toggle="modal" data-target="#reviewModal" onclick = "writeReviewInMenu('${dietList[2].mainDish}')">${dietList[2].mainDish }</a><br/>${dietList[2].sideDish }</td>
					<td><a href = "#" data-toggle="modal" data-target="#reviewModal" onclick = "writeReviewInMenu('${dietList[5].mainDish}')">${dietList[5].mainDish }</a><br/>${dietList[5].sideDish }</td>
					<td><a href = "#" data-toggle="modal" data-target="#reviewModal" onclick = "writeReviewInMenu('${dietList[6].mainDish}')">${dietList[6].mainDish }</a><br/>${dietList[6].sideDish }</td>
					<td><a href = "#" data-toggle="modal" data-target="#reviewModal" onclick = "writeReviewInMenu('${dietList[9].mainDish}')">${dietList[9].mainDish }</a><br/>${dietList[9].sideDish }</td>
					<td><a href = "#" data-toggle="modal" data-target="#reviewModal" onclick = "writeReviewInMenu('${dietList[10].mainDish}')">${dietList[10].mainDish }</a><br/>${dietList[10].sideDish }</td>
					<td><a href = "#" data-toggle="modal" data-target="#reviewModal" onclick = "writeReviewInMenu('${dietList[13].mainDish}')">${dietList[13].mainDish }</a><br/>${dietList[13].sideDish }</td>
					<td><a href = "#" data-toggle="modal" data-target="#reviewModal" onclick = "writeReviewInMenu('${dietList[14].mainDish}')">${dietList[14].mainDish }</a><br/>${dietList[14].sideDish }</td>
					<td><a href = "#" data-toggle="modal" data-target="#reviewModal" onclick = "writeReviewInMenu('${dietList[17].mainDish}')">${dietList[17].mainDish }</a><br/>${dietList[17].sideDish }</td>
					<td><a href = "#" data-toggle="modal" data-target="#reviewModal" onclick = "writeReviewInMenu('${dietList[18].mainDish}')">${dietList[18].mainDish }</a><br/>${dietList[18].sideDish }</td>
				</tr>
				<tr>
					<td>저녁</td><td colspan = 2><a href = "#" data-toggle="modal" data-target="#reviewModal" onclick = "writeReviewInMenu('${dietList[3].mainDish}')">${dietList[3].mainDish }</a><br/>${dietList[3].sideDish }</td>
								<td colspan = 2><a href = "#" data-toggle="modal" data-target="#reviewModal" onclick = "writeReviewInMenu('${dietList[8].mainDish}')">${dietList[8].mainDish }</a><br/>${dietList[8].sideDish }</td>
								<td colspan = 2><a href = "#" data-toggle="modal" data-target="#reviewModal" onclick = "writeReviewInMenu('${dietList[11].mainDish}')">${dietList[11].mainDish }</a><br/>${dietList[11].sideDish }</td>
								<td colspan = 2><a href = "#" data-toggle="modal" data-target="#reviewModal" onclick = "writeReviewInMenu('${dietList[15].mainDish}')">${dietList[15].mainDish }</a><br/>${dietList[15].sideDish }</td>
								<td colspan = 2><a href = "#" data-toggle="modal" data-target="#reviewModal" onclick = "writeReviewInMenu('${dietList[19].mainDish}')">${dietList[19].mainDish }</a><br/>${dietList[19].sideDish }</td>
				</tr>
			</tbody>
		</table>
	</div>
</body>
</html>













