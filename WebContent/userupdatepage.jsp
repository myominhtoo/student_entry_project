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
	<title>User Update Page</title>
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
		<section class="main position-absolute" style="left:25%;top:10%;overflow-y:scrollable;" >
			<h1 class="h3 text-success">User Update</h1>
		        <form action="userUpdateServlet" method="post" class="card-body form">
		        <input type="hidden" class="form-control w-100" name="id" value="${user.id}" placeholder="Your Name ">
		            <div class="input-group d-flex flex-column g-1 my-3 "><label for="" class="form-label">Username</label><input type="text" class="form-control w-100" name="name" value="${user.name}" placeholder="Your Name "></div>
		            <div class="input-group d-flex flex-column g-1 my-3"><label for="" class="form-label">Email Address</label><input type="email" class="form-control w-100" name="email" value="${user.email}" placeholder="Your Email "></div>
		            <div class="input-group d-flex flex-column g-1 my-3"><label for="" class="form-label">Password</label><input type="password" class="form-control w-100" name="password" value="${user.password}" placeholder="Your Password "></div>
		            <div class="input-group d-flex justify-content-between align-items-center "><button type="submit" class="btn btn-success w-100">Update</button></div>
		        </form>
		        
		        <h1 class="h6 text-danger">${error}</h1>
		        <h1 class="h6 text-dark">${status}</h1>
		</section>
		
		<!--  footer -->
		<footer class="w-100 bg mt-1 p-2 align-self-end" style="width:85	%;left:0;bottom:0;">
      		<h1 class="h6 text-center text-warning">Copy righted <i class="fa-solid fa-copyright"></i> <span id="year"></span>.Created By Lionel As Exam Project!</h1>
		</footer>
		<!--  for date -->
		<script src="./actions/script.js" type="text/javascript"></script>
	</main>
	
</body>
</html>