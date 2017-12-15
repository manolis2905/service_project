<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="ui segment">

	<h3>Delete User</h3>


	<form:form action="deleteuser" modelAttribute="appUser" method="POST"
		class="ui form">
		<div class="number">
			<label>User ID</label>
			<form:input path="id" />
		</div>
		<button class="ui button" type="submit">Delete User</button>
	</form:form>
	<a href="${pageContext.request.contextPath}/admin/administrator"><button class="ui button"
			type="button">Back</button></a>

</div>
