<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test="${sessionScope.acc == null}">
	<% 
		out.println("<script>alert('Plese continue to login!');window.location.href = 'login.jsp';</script>");
	%>
</c:if>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Home</title>
	<!--  cdn connectors -->
	<jsp:include page="./Helpers/link.jsp"/>
	<!--  style css -->
	<link rel="stylesheet" href="./Helpers/style.css" type="text/css"/>
</head>
<style>
main{
	background:rgba(0,0,0,0.23);
}
</style>
<body style="height:100vh;max-height:100vh;">
	<!--  header -->
	<jsp:include page="./Helpers/Header.jsp"/>
	
	<main class="d-flex m-0 justify-content-between position-relative align-items-center">
		<!--  side bar -->
		<jsp:include page="./Helpers/SideBar.jsp"/>
		
		<!-- main area -->
		<section class="main position-absolute" style="left:25%;top:10%;" >
			<h1 class="h3 text-success">Welcome ${sessionScope.acc.name}!</h1>
			<span class="h6">This is the final exam project of The Java Web Development Course!</span>
		</section>
		
		<!--  footer -->
		<footer class="w-100 bg mt-1 p-2 align-self-end" style="width:85%;left:0;bottom:0;">
      		<h1 class="h6 text-center text-warning">Copy righted <i class="fa-solid fa-copyright"></i> <span id="year"></span>.Created By Lionel As Exam Project!</h1>
		</footer>
		<!--  for date -->
		<script src="./actions/index.js" type="text/javascript"></script>
	</main>
	
</body>
</html>