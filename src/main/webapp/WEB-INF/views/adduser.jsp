<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Spring MVC App With Hibernate</title>

<!-- Bootstrap Core CSS -->
<link href="resources/css/bootstrap.min.css" rel="stylesheet">




<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

	<nav class="navbar navbar-default">
		<div class="container-fluid" style="height: 60px">
			<div class="navbar-header">

				<a class="navbar-brand" href="#"
					style="padding-bottom: 0px; padding-left: 0px; padding-top: 0px; padding-right: 0px;">
					<img alt="Brand" src="resources/logo/logo.jpg">
				</a>

			</div>
		</div>
	</nav>


	<center>
		<h3>Register a User</h3>
	</center>
	<br></br>

	<center>
		<%
			Boolean status = (Boolean) request.getAttribute("status");
			if (status != null) {
				if (status) {
		%>
		<p>
			<font color="green">User created Successfully!! To login <a
				href="indexpage">Click here</font>
		</p>

		<%
			} else {
		%>
		<p>
			<font color="red">User creation failed!! Try Again!!</font>
		</p>

		<%
			}
			}
		%>
		<form class="navbar-form navbar-middle" role="ticket-information"
			name="resgisterForm" action="registerUser" method="post">
			<div class="form-group">
				<table>


					<tr>
						<td><br></br>User Name&nbsp;<input type="text"
							name="userName" class="form-control" placeholder="User Name"></td>
					</tr>
					<tr>
						<td><br></br> &nbsp;&nbsp;Password&nbsp;&nbsp;<input
							type="password" name="password" class="form-control"
							placeholder="Password"></td>
					</tr>

				</table>


				<br></br> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<button type="submit" class="btn btn-primary navbar-middle">Create
					User</button>

			</div>


		</form>

	</center>

	<!-- /.container -->

	<!-- jQuery -->
	<script src="js/jquery.js"></script>



	<!-- Bootstrap Core JavaScript -->
	<script src="js/bootstrap.min.js"></script>

	<!-- Footer -->
	<footer>
		<div class="row">
			<div class="col-lg-12">
				<br></br> <br></br> <br></br> <br></br> <br></br>

				<center>
					<p>Copyright &copy; Diwakar & Co. 2015</p>
				</center>
			</div>
		</div>
		<!-- /.row -->
	</footer>

</body>

</html>
