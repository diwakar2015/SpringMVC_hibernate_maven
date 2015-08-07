<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.diwakar.springexample.model.User" %>
<%@ page session="false" %>

<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Employee Management System</title>

    <!-- Bootstrap Core CSS -->
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">




    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<%
//Check for session
User user= null;
		String userName="";
HttpSession session = request.getSession();
if(session!=null)
{
	if(session.getAttribute("userInfo")==null)
	{
		response.sendRedirect("indexpage");
	}
	else
	{
		 user = (User)session.getAttribute("userInfo");
		 userName = user.getUserName();
	}
}


%>


<nav class="navbar navbar-default">
  <div class="container-fluid" style="height: 60px"> 
    <div class="navbar-header">
     
      <a class="navbar-brand" href="#" style="
    padding-bottom: 0px;
    padding-left: 0px;
    padding-top: 0px;
    padding-right: 0px;
">
        <img alt="Brand" src="${pageContext.request.contextPath}/resources/logo/logo.jpg">
      </a>
    
    </div>
  </div>
</nav>

<nav class="navbar navbar-default">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="#">Employee Management System</a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li class="active"><a href="${contextPath}/home">Add Employee </a></li>
        <li><a href="${contextPath}/personlist">Existing employees</a></li>
      </ul>
      
   
      
      <form class="navbar-form navbar-left" role="search" name="searchForm" action="${pageContext.request.contextPath}/getEmployeeBySearchID" method ="get">
        <div class="form-group">
          <input type="text" name="searchKey" class="form-control" placeholder="Search an employee">
        </div>
        <button type="submit" class="btn btn-primary">Search</button>
      </form>
      
     
      <ul class="nav navbar-nav navbar-right">
        <li>Welcome! <%=userName %></li>
        <li><a href="${contextPath}/logout">Logout</a></li>
        
      </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav> 