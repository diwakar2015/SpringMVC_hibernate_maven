<%@include file="header.jsp"%>



<center>

	<h1>Add an Employee</h1>

	<form class="navbar-form navbar-middle" role="add-information"
		name="person" action="person/add" method="post">
		<div class="form-group">
			<table>


				<tr>
					<td><br></br>Name&nbsp;<input type="text" name="name"
						class="form-control" placeholder="Employee Name"></td>
				</tr>
				<tr>
					<td><br></br> &nbsp;&nbsp;Country&nbsp;&nbsp;<input
						type="text" name="country" class="form-control"
						placeholder="Country"></td>
				</tr>

			</table>


			<br></br> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<button type="submit" class="btn btn-primary navbar-middle">Add
				Employee</button>

		</div>


	</form>

	<%
		Boolean status = (Boolean) request.getAttribute("status");
		if (status != null) {
			if (status) {
	%>
	<p>
		<font color="green">New Employee Added Successfully</font>
	</p>

	<%
		} else {
	%>
	<p>
		<font color="red">Unable to add new employee a this time!! Try Again!!</font>
	</p>

	<%
		}
		}
	%>
</center>

<%@include file="footer.jsp"%>