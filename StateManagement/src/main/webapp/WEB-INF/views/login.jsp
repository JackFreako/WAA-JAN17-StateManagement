<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Login Page</title>
</head>

<body>

<div class="container">
<div class="row">
<div class="col-md-4 col-md-offset-4">
<div class="panel panel-default">

<div class="panel-heading">
<h3 class="panel-title">Please sign in</h3>
</div>


<div class="panel-body">

<spring:url var="loginUrl" value="/login"/>

<form:form action="${loginUrl}" method="post" modelAttribute="user">

<fieldset>

<div class="form-group">
<input class="form-control" placeholder="User Name" type="text" name="userName">
</div>

<div class="form-group">
<input class="form-control" placeholder="Password" type="password" name="password">
</div>


<div class="form-group">
<label> Remember Me : <input type="checkbox" name="remember">
<c:if test="${cookie.containsKey('userName')}">
</c:if>
</label>   
</div>


<input class="btn btn-lg btn-success btn-block" type="submit" value="Login">

</fieldset>


<c:if test="${not empty error}">
<p>UserName and/or password incorrect.</p>
</c:if>

</form:form>
</div>
</div>
</div>
</div>
</div>
</body>