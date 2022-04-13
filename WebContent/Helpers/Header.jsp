<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
  <div class="navbar navbar-expand w-100 bg nav-light mb-1">
        <div class="container">
            <div class="navbar-brand"><h1 class="h4 fw-bold text-warning">Student Registration</h1></div>
           <ul class="navbar-nav">
               <c:if test="${sessionScope.acc == null}">
               		<li class="nav-item"><a href="./register.jsp" class="btn btn-warning mx-2 ">Register</a></li>
               		<li class="nav-item"><a href="./login.jsp" class="btn btn-success">Login</a></li>
               </c:if>
               <c:if test="${sessionScope.acc != null}">
               		<li class="nav-item mx-3 dropdown">
               			<i class="fa-solid fa-user-check dropdown-toggle fs-4 mx-5 text-warning" data-bs-toggle="dropdown"></i>
               			
               			<ul class="dropdown-menu">
               				<li class="dropdown-item">${sessionScope.acc.name}</li>
               				<li class="dropdown-item">${sessionScope.acc.email }</li>
               				<li class="dropdown-item" id="date"></li>
               			</ul>
               		</li>
               		<li class="nav-item"><a href="logoutServlet" class="btn btn-danger mx-2 ">Logout</a></li>
               </c:if>
           </ul>
        </div>
    </div>

 
