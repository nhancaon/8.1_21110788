<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ include file="/header.html"%>
<h1>Thanks for taking our survey</h1>
<p>Here is the information that you enter:</p>
<label>Email:</label>
<span>${user.email}</span>
<br>
<label>FirstName:</label>
<span>${user.firstName}</span>
<br>
<label>LastName:</label>
<span>${user.lastName}</span>
<br>
<label>DateOfBirth:</label>
<span>${user.dateOfBirth}</span>
<br>
<label>Heard From:</label>
<span>${user.heardFrom}</span>
<br>
<label>Updates:</label>
<span>${user.updates}</span>
<br>
<c:if test="${user.updates!='No' }">
	<label>Contact Via:</label>
	<span>${user.contactVia}</span>
<br>
</c:if>




<p>To enter another email address, clock on the Back button in your
	browser or the Return button shown below.</p>

<form action="index.jsp" method="post">
	<input type="hidden" name="action" value="join"> <input
		type="submit" value="Return">
</form>

<h2>The first two users in the ArrayList of User objects</h2>
<label>FirstName:</label>
<span>${requestScope.users[0].firstName}</span>
<br>
<label>LastName:</label>
<span>${requestScope.users[0].lastName}</span>
<br>
<label>Email:</label>
<span>${requestScope.users[0].email}</span>
<br>
<label>DateOfBirth:</label>
<span>${requestScope.users[0].dateOfBirth}</span>
<br>
<br>
<label>FirstName:</label>
<span>${requestScope.users[1].firstName}</span>
<br>
<label>LastName:</label>
<span>${requestScope.users[1].lastName}</span>
<br>
<label>Email:</label>
<span>${requestScope.users[1].email}</span>
<br>
<label>DateOfBirth:</label>
<span>${requestScope.users[1].dateOfBirth}</span>

<p>The current date is ${requestScope.currentDate}</p>
<p>The context init param: ${initParam.custServEmail}</p>
<%@ include file="/footer.jsp"%>

