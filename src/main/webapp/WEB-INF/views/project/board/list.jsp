<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ex" tagdir="/WEB-INF/tags/project/board" %>
<%@ page import="java.util.*" %>
<% request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g==" crossorigin="anonymous" referrerpolicy="no-referrer" />
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.1.3/css/bootstrap.min.css" integrity="sha512-GQGU0fMMi238uA+a/bdWJfpUGKUkBdgfFdgBm72SUQ6BeyWjoY/ton0tEjH+OSH9iP4Dfh+7HM0I9f5eR0L/4w==" crossorigin="anonymous" referrerpolicy="no-referrer" />
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js" referrerpolicy="no-referrer"></script>
<script>

	$(document).ready(function() {
		$(".search_area button").on("click", function(e) {
			e.preventDefault();
			let moveForm = $("#moveForm");
			let val1 = $("input[name='keyword']").val();
			let val2 = $("input[name='current']").val();
			moveForm.find("input[name='keyword']").val(val1);
			moveForm.find("input[name='current']").val(val2);
			moveForm.find("input[name='searchType']").val("title");
			moveForm.submit();
		});
	});
	
</script>

<title>Insert title here</title>
</head>
<body>
	
	<ex:navBar current="list" />
	
	<div class="container">
		<div class="row">
			<div class="col">
				<div class="search_wrap">
					<div class="search_area">
						<input style="solid 2px #D2691E; border-radius: 8px" type="text" name="keyword" value="${pageInfo.keyword }" />
						<button type="button" class="btn btn-outline-secondary"><i class="fa-solid fa-magnifying-glass"></i></button>
					</div>
				</div>
				
				<form id="moveForm" method="get">
					<input type="hidden" name="current" value="${pageInfo.current }" />
					<input type="hidden" name="keyword" value="${pageInfo.keyword }" />
					<input type="hidden" name="searchType" value="${pageInfo.searchType }" />
				</form>
				
				<h1>글 목록</h1>
				
				<table class="table table-striped" style="text-align: center; border: 1px solid #dddddd">
					<thead style="background-color: #8f8f89">
						<tr>
							<th style="text-align: left">게시물 번호</th>
							<th>제목</th>
							<th style="text-align: right">작성 시간</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${boardList }" var="board">
							<tr>
								<td style="text-align: left">${board.id }</td>
								<td>
								
								<c:url value="/project/board/${board.id }" var="link"></c:url>
								
								<a href="${link }">
									${board.title }
								</a>
								
								<c:if test="${board.numOfReply > 0 }">
									[${board.numOfReply }]
								</c:if>
								
								</td>
								<td style="text-align: right">${board.inserted }</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	
	<div class="mt-3">
		<ex:PageNation path="list"/>
	</div>
</body>
</html>

