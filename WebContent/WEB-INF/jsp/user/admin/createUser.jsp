

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="ui segment">

	<h3>New User Information</h3>


	<form:form action="saveNewUser" modelAttribute="appUser" method="POST"
		class="ui form">
		<div class="field">
			<label>Username</label>
			<form:input path="username" />
		</div>
		<div class="field">
			<label>Password</label>
			<form:input path="password" />
		</div>
		<div class="number">
			<label>Position</label>
			<form:input path="rights" />
		</div>
		<button class="ui button" type="submit">Create User</button>
	</form:form>
	<a href="${pageContext.request.contextPath}/admin/administrator"><button class="ui button"
			type="button">Back</button></a>

</div>
