<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>

<html>

<head>
<title>Yunus Company Home Page</title>
<!-- Reference Bootstrap files -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>

<body>
	<h2>Company Project Management and Information System - CPMIS</h2>
	<hr>
	<p>

		<security:authorize access="hasRole('EMPLOYEE')">

			<a href="${pageContext.request.contextPath}/project/1"
				class="btn btn-success" role="button" aria-pressed="true">Projects</a>


		</security:authorize>
	<p>
		User:
		<security:authentication property="principal.username" />
		<br> <br> Role(s):
		<security:authentication property="principal.authorities" />
		<br> <br> First name: ${user.firstName}, Last name:
		${user.lastName}, Email: ${user.email}
	</p>

	<security:authorize access="hasRole('MANAGER')">


		<p>
			<a href="${pageContext.request.contextPath}/leaders">Leader</a>

		</p>

	</security:authorize>


	<security:authorize access="hasRole('ADMIN')">


		<p>
			<a href="${pageContext.request.contextPath}/systems"
				class="btn btn-primary" role="button" aria-pressed="true">User
				List</a>

		</p>

	</security:authorize>

	<hr>


	<!-- Add a logout button -->
	<form:form action="${pageContext.request.contextPath}/logout"
		method="POST">

		<input type="submit" value="Logout" />

	</form:form>
	<div id="footer">&copy;2019 Jr Java Developer Yunus Bagriyanik</div>
</body>

</html>



