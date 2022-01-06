<%@ page language="java" isELIgnored="false"%>
<h1 style="text-align: center; color: blue;">Customer Registration
	Form</h1>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<f:form action="ckt_register" modelAttribute="ckt">
	<table>

		<tr>
			<td>Crikter Number::</td>
			<td><f:input path="cno" /></td>
		</tr>

		<tr>
			<td>Crickter name::</td>
			<td><f:input path="cname" /></td>
		</tr>

		<tr>
			<td>Crickter type::</td>
			<td><f:input path="ctype" /></td>
		</tr>
		<%-- <tr>
			<td>Crickter DOB::</td>
			<td><f:input path="dob" type="date" /></td>
		</tr> --%>
		
		<tr>
			<td>Crickter DOB::</td>
			<td><f:input path="dob" type="datetime-local"/></td>
		</tr>
		

		<tr>
			<td>Crickter DebueDate::</td>
			<td><f:input path="doj" type="date" /></td>
		</tr>
	
		<tr>
			<td><input type="submit" value="register"></td>
			<td><input type="Reset" value="cancel"></td>
		</tr>
	</table>
</f:form>