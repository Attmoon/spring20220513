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

<title>Insert title here</title>
</head>
<body>
	<ex:navBar current="list" />
	
	<div class="container">
		<div class="row">
			<div class="col-6">
			
				<h2>글 작성</h2>
				
				<c:url value="/project/board/write" var="writeLink" />
				
				<form action="${writeLink }" method="post">
					<div>
						<label class="form-label" for="input1">제목</label>
						<input class="form-control" type="text" name="title" required id="input1" />
					</div>
					
					<div>
						<label class="form-label" for="textarea1">본문</label>
						<textarea class="form-control" name="body" id="textarea1" cols="20" rows="10"></textarea>
					</div>
					
					<button class="btn btn-primary">등록</button>
				</form>
			</div>
		</div>
	</div>
	
	<%-- <h1>글 작성</h1>
	
	
	<c:url value="/project/board/write" var="writeLink"></c:url>
	<form action="${writeLink }" method="post">
		제목 : <input type="text" name="title" value="제목" /> <br />
		본문 : <textarea name="body" id="" cols="30" rows="10">새 글</textarea> <br />
		
		<button>등록</button>
	</form> --%>
</body>
</html>