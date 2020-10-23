<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/bootStrap.jsp"></c:import>
</head>
<body>
<c:import url="../template/header.jsp"></c:import>

	<div class="container">
		<table class="table table-condensed">
			<tr>
				<th>Num</th> <td>${member.num}</td>
			</tr>
			<tr>
				<th>Id</th> <td>${member.id}</td>
			</tr>
			<tr>
				<th>Name</th> <td>${member.name}</td>
			</tr>
			<tr>
				<th>Email</th> <td>${member.email}</td>
			</tr>
		</table>
		
		<a href="./memberUpdate" class="btn btn-primary">Update</a>
		<a href="./memberDelete" class="btn btn-danger">Delete</a>
		
	</div>

</body>
</html>