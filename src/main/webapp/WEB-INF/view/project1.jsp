<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Reference Bootstrap files -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>

	<div class="container">
		<h1>Projects</h1>

		<table class="table table-striped">
			<thead>
				<tr>
					<th>Created At</th>
					<th>Project Name</th>
					<th>Project Code</th>
					<th>Manager</th>

				</tr>
			</thead>



			<c:forEach var="projects" items="${project}">



				<tr>
					<td>${projects.createdAt}</td>
					<td>${projects.projectName}</td>
					<td>${projects.projectCode}</td>
					<td>${projects.manager.firstName}${projects.manager.lastName}</td>



				</tr>
			</c:forEach>
		</table>
		<security:authorize access="hasRole('MANAGER')">
			<a href="${pageContext.request.contextPath}/project/showProjectForm"
				class="btn btn-warning" role="button" aria-pressed="true">Add
				New Project</a>

		</security:authorize>
	</div>
	<br>
	<br>

	<hr>

	<div class="container">
		<h1>Details of Projects</h1>

		<table class="table table-striped">
			<thead>
				<tr>
					<th>Created At</th>
					<th>Description</th>
					<th>Details</th>
					<th>Project Status</th>
					<th>Project Name</th>
					<th>Responsible Employee</th>


				</tr>
			</thead>



			<c:forEach var="projectdetail" items="${project2}">



				<tr>
					<td>${projectdetail.createdAt}</td>
					<td>${projectdetail.description}</td>
					<td>${projectdetail.details}</td>
					<td>${projectdetail.projectStatus}</td>
					<td>${projectdetail.project.projectName}</td>
					<td>${projectdetail.assignee.firstName}
						${projectdetail.assignee.lastName}</td>



				</tr>
			</c:forEach>
		</table>
		<a href="${pageContext.request.contextPath}/project/showInfoForm"
			class="btn btn-warning" role="button" aria-pressed="true">Add New
			Details</a>
	</div>

	<br>
	<br>

	<a href="${pageContext.request.contextPath}/" class="btn btn-warning"
		role="button" aria-pressed="true">Back to Home Page</a>

</body>
</html>