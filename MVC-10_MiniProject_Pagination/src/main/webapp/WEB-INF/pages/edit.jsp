<%@ page language="java" isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="c"%>
<h1 style="text-align: center;color: green;" >Edit Employee</h1>
<c:form modelAttribute="emp">
	<table>
	<tr>
			<td>Employee number::</td>
			<td><c:input path="empno" /></td>
		</tr>
	
		<tr>
			<td>Employee name::</td>
			<td><c:input path="ename" /></td>
		</tr>

		<tr>
			<td>Designation::</td>
			<td><c:input path="desig" /></td>
		</tr>

		<tr>
			<td>Sallary::</td>
			<td><c:input path="salary" /></td>
		</tr>

		<tr>
			<td>Adress::</td>
			<td><c:input path="location" /></td>
		</tr>
		<tr>
			<td><input type="submit" value="editEmployee"></td>
			<td><button type="reset">cancel</button></td>
		</tr>
	</table>

</c:form>