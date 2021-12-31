<%@ page language="java" isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<h1 style="text-align: center" >Add Employee</h1>

<f:form modelAttribute="emp">
<table>
<tr>
<td>Employee No:</td>
<td><f:input path="empno"/></td>
</tr>
<tr>
<td>Employee Name</td>
<td><f:input path="ename"/></td>
</tr>
<tr>
<td>Designation</td>
<td><f:input path="desig"/></td>
</tr>

<tr>
<td>Sallary</td>
<td><f:input path="salary"/></td>
</tr>

<tr>
<td>Address</td>
<td><f:input path="location"/></td>
</tr>
<tr>
<td><input type="submit" value="submit"></td>
</tr>

</table>

</f:form>

