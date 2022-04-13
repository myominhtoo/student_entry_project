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
	<title>User Search</title>
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
		<section class="main position-absolute w-75" style="left:20%;top:5%;" >
			<h1 class="h3 text-success">User Search</h1>
		        <form action="userSearchServlet" method="post" class="card-body form w-75">
		            <div class="d-flex gap-2">
		            	<div class="input-group d-flex flex-column g-1 my-3 "><label for="" class="form-label">Username</label><input type="text" class="form-control w-100" name="name" value="${user.name}" placeholder="Your Name "></div>
		            <div class="input-group d-flex flex-column g-1 my-3"><label for="" class="form-label">Email Address</label><input type="email" class="form-control w-100" name="email" required value="${user.email}" placeholder="Your Email "></div>
		            </div>
		            <div class="gap-2 d-flex ">
		            	<button class="btn btn-warning" type="submit">Search</button>
		            	<a href="./userregister.jsp" class="btn btn-success">Add</a>
		            	<a href="selectAllUserServlet" class="btn btn-danger">Reset</a>
		            </div>
		        </form>
		        
		        <h1 class="h6 text-danger">${error}</h1>
		        <h1 class="h6 text-dark">${status}</h1>
		        
		        <section class="datas w-100" style="height:300px;overflow-y:scroll;" >
		       		<table class="table w-100 table-striped table-dark">
		       			<thead>
		       				<tr class="">
		       					<td colspan="4" class="h3 text-center text-warning">User's</td>
		       				</tr>
		       				<tr>
		       					<td class="text-warning">Id</td>
		       					<td class="text-warning">Name</td>
		       					<td class="text-warning">Email</td>
		       					<td class="text-warning">Actions</td>
		       				</tr>
		       			</thead>
		       			<tbody>
		       				<c:if test="${user == null && users == null }">
		       					<tr>
		       						<td class="text-danger text-center" colspan="4">There is no user to show!</td>
		       					</tr>
		       				</c:if>
		       				<c:if test="${user != null && users == null}">
		       					<tr class="text-light">
		       						<td>${user.id}</td>
		       						<td>${user.name}</td>
		       						<td>${user.email}</td>
		       						<td><a class="btn btn-warning mx-2" href="userUpdateServlet?email=${user.email}">Update</a><a class="btn btn-danger" href="userDeleteServlet?id=${user.id}">Delete</a></td>
		       					</tr>
		       				</c:if>
		       				<c:if test="${users != null}">
		       					<c:forEach items="${users}" var="user">
		       						<tr class="text-light">
		       							<td>${user.id}</td>
		       							<td>${user.name}</td>
		       							<td>${user.email}</td>
		       							<td><a class="btn btn-warning mx-2" href="userUpdateServlet?email=${user.email}">Update</a><a class="btn btn-danger" href="userDeleteServlet?id=${user.id}">Delete</a></td>
		       						</tr>
		       					</c:forEach>
		       				</c:if>
		       			</tbody>
		       		</table>
		        </section>
		</section>
		
		<!--  footer -->
		<footer class="w-100 bg mt-1 p-2 align-self-end" style="width:85%;left:0;bottom:0;">
      		<h1 class="h6 text-center text-warning">Copy righted <i class="fa-solid fa-copyright"></i> <span id="year"></span>.Created By Lionel As Exam Project!</h1>
		</footer>
		<!--  for date -->
		<script src="./actions/script.js" type="text/javascript"></script>
	</main>
	
</body>
</html>