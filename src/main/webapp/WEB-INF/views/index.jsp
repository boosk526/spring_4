<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
	<title>Home</title>
<c:import url="./template/bootStrap.jsp"></c:import>	
</head>
<body>

<c:import url="./template/header.jsp"></c:import>


<div class="container">
  <h1><spring:eval expression="@db['user']"></spring:eval> </h1>
  <h3>Right Aligned Navbar</h3>
  <p>The .navbar-right class is used to right-align navigation bar buttons.</p>
  <div>
  	<c:if test="${not empty member}">
  		<h1>Login Success</h1>
  	</c:if>
  	<c:if test="${empty member}">
  		<h1>Login Fail</h1>
  	</c:if>
  	<img alt="main Image" src="./resources/images/index/main.jpg">
  </div>
  
  <a href="./cookie/makeCookie">MakeCookie</a>
</div>

</body>
</html>