<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="student_registration.dao.DAO" %>
<%
	DAO dao = new DAO();
%>
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
	<title>Student Register</title>
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
		<!-- main area -->
		<section class="main position-absolute" style="left:25%;top:10%;" >
			<h1 class="h3 text-success">Student Register</h1>
		           <form action="studentRegisterServlet" method="post" class="form w-100">
				        <div class="input-group my-2 d-flex flex-column gap-2"><label for="" class="form-label"></label><input type="text" name="id" class="form-control w-100" placeholder="Student's Id" value="${stu.stuId}"></div>
				        <div class="input-group my-2 d-flex flex-column gap-2"><label for="" class="form-label"></label><input type="text" name="name" class="form-control w-100" placeholder="Student's Name" value="${stu.name}"></div>
				        <div class="input-group my-2 d-flex flex-column gap-2"><label for="" class="form-label"></label>
				        	<select name="className" class="form-select w-100">
				        		<option selected disabled>Choose Class</option>
				        		<c:forEach items="<%= dao.takeClasses() %>" var="cls">
				        			<option value="${cls.className}">${cls.className}</option>
				        		</c:forEach>
				        	</select>
				        </div>
				        <div class="input-group my-2 d-flex flex-column gap-2">
				           <input type="date" name="registeredDate" placeholder="Registered Date" class="form-control w-100" value="${stu.registeredDate}">
				        </div>
				        <div class="input-group my-2 d-flex flex-column gap-2">
				            <select name="status" id="" class="form-select w-100">
				                <option value="" selected disabled>Choose Status</option>
				                <option value="Attending">Attending</option>
				                <option value="Passed">Passed</option>
				                <option value="Failed">Failed</option>
				            </select>
				        </div>
				        <div class="input-group my-2 d-flex flex-column gap-2"><button class="btn btn-warning w-100">Add</button></div>
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