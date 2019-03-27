<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html lang="en">

<head>

<title>ADMIN TRANSACTIONS</title>
<!-- Reference Bootstrap files -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

</head>

<body>

	<h2>ADMIN Transactions</h2>

	<hr>

	<p>
		USERS MANAGEMENT PAGE <br>


	</p>

	<hr>

	<div class="container">



		<h1>All Users</h1>

		<table class="table table-striped">
			<thead>
				<tr>
					<th>Username</th>
					<th>Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Contact</th>
					<th>Country</th>
					<th>Roles</th>
					<th>Action</th>
				</tr>
			</thead>



			<c:forEach var="users" items="${user}">

				<c:url var="updateLink" value="/showUpdateForm">
					<c:param name="userId" value="${users.id}" />
				</c:url>

				<c:url var="deleteLink" value="/delete">
					<c:param name="userId" value="${users.id}" />
				</c:url>

				<tr>
					<td>${users.userName}</td>
					<td>${users.firstName}</td>
					<td>${users.lastName}</td>
					<td>${users.email}</td>
					<td>${users.contactNumber}</td>
					<td>${users.country}</td>
					<td>${users.roles}</td>

					<td><a href="${updateLink}" class="btn btn-primary"
						role="button" aria-pressed="true">Update</a></td>
					<td><a href="${deleteLink}" class="btn btn-danger"
						role="button" aria-pressed="true">Delete</a></td>
				</tr>
			</c:forEach>
		</table>

	</div>







	<a href="${pageContext.request.contextPath}/" class="btn btn-warning"
		role="button" aria-pressed="true">Back to Home Page</a>

</body>

</html>
