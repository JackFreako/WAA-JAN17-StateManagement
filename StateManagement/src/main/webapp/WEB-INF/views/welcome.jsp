<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@ page language="java" 
	contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
          
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Welcome Page</title>
</head>


<body>	

<section>
<div class="jumbotron">
<a href="<spring:url value="/logout"/>" class="btn btn-danger btn-mini pull-right">Logout</a>
<div class="container">
</div>
</div>
</section>

<h1> Welcome, ${user.userName}</h1>
 		 	
</body>
</html>