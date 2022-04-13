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
	<title>Student Search</title>
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
			<h1 class="h3 text-success">Student Search</h1>
		        <form action="studentSearchServlet" method="post" class="card-body form w-75">
		            <div class="d-flex gap-2">
		            	<div class="input-group d-flex flex-column g-1 my-3 "><label for="" class="form-label">Student's Id</label><input type="text" class="form-control w-100" name="id" value="${data.stuId}" placeholder="Student's Id "></div>
		            </div>
		            <div class="gap-2 d-flex ">
		            	<button class="btn btn-warning" type="submit">Search</button>
		            	<a href="./studentregister.jsp" class="btn btn-success">Add</a>
		            	<a href="selectAllStusServlet" class="btn btn-danger">Reset</a>
		            </div>
		        </form>
		        
		        <h1 class="h6 text-danger">${error}</h1>
		        <h1 class="h6 text-dark">${status}</h1>
		        
		        <section class="datas w-100" style="height:300px;overflow-y:scroll;" >
		       		<table class="table w-100 table-striped table-dark">
		       			<thead>
		       				<tr class="">
		       					<td colspan="5" class="h3 text-center text-warning">Student's</td>
		       				</tr>
		       				<tr>
		       					<td class="text-warning">Id</td>
		       					<td class="text-warning">Name</td>
		       					<td class="text-warning">Joined Class</td>
		       					<td class="text-warning">Joined Date</td>
		       					<td class="text-warning">Status</td>
		       				</tr>
		       			</thead>
		       			<tbody>
		       				<c:if test="${stu == null  && stus.isEmpty()}">
		       					<tr>
		       						<td class="text-danger text-center" colspan="5">There is no student to show!</td>
		       					</tr>
		       				</c:if>
		       				<c:if test="${stu != null && stus == null}">
		       					<tr class="text-light">
		       						<td>${stu.stuId}</td>
		       						<td><a href="studentUpdateServlet?id=${stu.stuId}">${stu.name}</a></td>
		       						<td>${stu.className}</td>
		       						<td> ${stu.registeredDate} </td>
		       						<c:choose>
		       								<c:when test="${stu.status == 'Attending'}">
		       									<td class="text-warning fw-bold">${stu.status }</td>
		       								</c:when>
		       								<c:when test="${stu.status == 'Passed'}">
		       									<td class="text-success fw-bold">${stu.status }</td>
		       								</c:when>
		       								<c:when test="${stu.status == 'Failed'}">
		       									<td class="text-danger fw-bold">${stu.status }</td>
		       								</c:when>		       								
		       						</c:choose>
		       					</tr>
		       				</c:if>
		       				<c:if test="${stus != null}">
		       					<c:forEach items="${stus}" var="stu">
		       						<tr class="text-light">
		       							<td>${stu.stuId}</td>
		       							<td><a href="studentUpdateServlet?id=${stu.stuId}">${stu.name}</a></td>
		       							<td>${stu.className}</td>
		       							<td> ${stu.registeredDate} </td>
		       							<c:choose>
		       								<c:when test="${stu.status == 'Attending'}">
		       									<td class="text-warning fw-bold">${stu.status }</td>
		       								</c:when>
		       								<c:when test="${stu.status == 'Passed'}">
		       									<td class="text-success fw-bold">${stu.status }</td>
		       								</c:when>
		       								<c:when test="${stu.status == 'Failed'}">
		       									<td class="text-danger fw-bold">${stu.status }</td>
		       								</c:when>		       								
		       							</c:choose>
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