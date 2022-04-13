<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
 	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Register</title>
	<!--  cdn connectors -->
	<jsp:include page="./Helpers/link.jsp"/>
	<!--  style css -->
	<link rel="stylesheet" href="./Helpers/style.css" type="text/css"/>
</head>
<style>
	.card{
	width:25%;
	}

@media (max-width:1100px){
	.card{
		width:35%;
	}
}

	

@media (max-width:700px){
	.card{
		width:100%;
	}
}

	
</style>
<body style="height:100vh;max-height:100vh;">
	<!--  header -->
	<jsp:include page="./Helpers/Header.jsp"/>
	
	<main class="w-100 d-flex flex-column justify-content-center align-items-center p-5">
		<h1 class="h1 text-center text-danger my-2">${error}</h1>
		<div class="card  my-3">
        <div class="card-header"><h1 class="h1 text-center text-warning">Registration Form</h1></div>
        <form action="AddUserServlet" method="post" class="card-body form">
            <div class="input-group d-flex flex-column g-1 my-3 "><label for="" class="form-label">Username</label><input type="text" class="form-control w-100" name="name" value="${user.name}" placeholder="Your Name "></div>
            <div class="input-group d-flex flex-column g-1 my-3"><label for="" class="form-label">Email Address</label><input type="email" class="form-control w-100" name="email" value="${user.email}" placeholder="Your Email "></div>
            <div class="input-group d-flex flex-column g-1 my-3"><label for="" class="form-label">Password</label><input type="password" class="form-control w-100" name="password" value="${user.password}" placeholder="Your Password "></div>
            <div class="input-group d-flex justify-content-between align-items-center "><a href="./login.jsp" class="btn btn-warning">Already?</a><button type="submit" class="btn btn-success">Register</button></div>
        </form>
    </div>
	</main>
	
	<!--  footer jsp -->
	<jsp:include page="./Helpers/Footer.jsp"/>
</body>
</html>