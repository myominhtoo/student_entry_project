<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 <div class="bg p-0 py-1" id="sidebar"  style="height:90vh;width:15%;padding:0;">
 	<ul class="d-flex flex-column w-100 justify-content-center p-0" style="top:0;left:0">
 		<li class="dropdown w-100">
 			<button class="btn btn-warning w-100 mb-1 dropdown-toggle" data-bs-toggle="dropdown">Class Management</button>
 			
 			<ul class="dropdown-menu dropdown-menu-dark w-100 text-center">
 				<li><a class="dropdown-item" href="./classregister.jsp">Class Registration</a></li>
 				<li><a class="dropdown-item" href="selectAllStusServlet">Student Search</a></li>
 				<li><a class="dropdown-item" href="studentregister.jsp">Student Registration</a></li>
 			</ul>
 		</li>
 		<li class="w-100">
 			<a class="btn btn-warning text-decoration-none w-100 m-0" href="selectAllUserServlet">User Management</a>
 		</li>
 	</ul>
 </div>