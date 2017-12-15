<nav class="ui fixed menu teal inverted navbar">
	<a href="" class="brand item">Employee</a> <a
		href="${pageContext.request.contextPath}/user/employee/employee"
		class="item">Home</a> <a
		href="${pageContext.request.contextPath}/user/employee/newCustomer"
		class="item">Customers</a>
</nav>
<!-- end nav -->
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="ui container">

	<div class="ui segment">
		<form name="newCustomerForm" method="post" action="saveNewCustomer">
			<fieldset>
				<legend>Customer Information</legend>
				Last Name<br> <input type="text" name="lastName"><br>
				First Name<br> <input type="text" name="firstName"><br>
				A.F.M.<br> <input type="number" name="afm"><br>
			</fieldset>
			<fieldset>
				<legend>Car Information</legend>
				Car Model<br> <input type="text" name="model"><br>
				License Plate<br> <input type="text" name="licensePlate"><br>
				Fuel Type: <select name="fueltype">
					<option value="gasoline">Gasoline</option>
					<option value="gas">Gas</option>
					<option value="oil">Oil</option>
				</select><br> Release Year<br> <input type="number"
					name="releaseYear"><br>
			</fieldset>
			<input type="submit" value="Submit">
		</form>
		<c:if test="${not empty message}">
			<div style="color: green">${message}</div>
			<br>
		</c:if>
	</div>
</div>
