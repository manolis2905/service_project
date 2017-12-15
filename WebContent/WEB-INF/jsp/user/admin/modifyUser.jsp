

<div class="ui segment">



<form name="findUserForm" method="post" action="findId">

<br><br>
Enter ID to find user<br>
<input type="text" name="id"><br>
<input type="submit" value="Find">
</form>
<form name="modifyUserForm" method="post" action="saveModifiedUser">
Username <input type="text" name="username" value="${username}"><br>
Password <input type="text" name="password" value="${password}"><br>
Rights <input type="number" name="rights" value="${rights}"><br>
<input type="submit" value="Save Changes">
</form>
<c:if test="${not empty message}">
<div style="color:green">${message}</div><br>
</c:if>

</div>