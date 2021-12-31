<%@ page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h1 style="color: green; text-align: center;">Employee Report</h1>

<c:choose>
	<c:when test="${!empty pageData}">
		<table border="1" bgcolor="cyan" align="center">
			<tr bgcolor="pink">
				<th>eno</th>
				<th>eName</th>
				<th>desg</th>
				<th>salary</th>
				<th>location</th>
				<th>operation</th>
			</tr>
			<c:forEach var="emp" items="${pageData.getContent()}">
				<tr>
					<td>${emp.empno}</td>
					<td>${emp.ename}</td>
					<td>${emp.desig}</td>
					<td>${emp.salary}</td>
					<td>${emp.location}</td>
					<td><a href="edit_employee?empno=${emp.empno}">edit</a> <a
						href="delete_employee?empno=${emp.empno}"
						onclick="confirm('Do you want to delete')">delete</a></td>
				</tr>
			</c:forEach>
		</table>
		<br>
		<br>
		<h3 style="color: red;text-align: center">
			<c:if test="${!pageData.isFirst()}">
				<a href="emp_report?page=0">[First]</a>&nbsp;&nbsp;
            </c:if>
			
				<c:if test="${!pageData.isLast()}">
					<a href="emp_report?page=${pageData.getNumber()+1}">[Next]</a>&nbsp;&nbsp;
  				</c:if>

				<c:forEach var="i" begin="1" end="${pageData.getTotalPages()}" step="1">
					[<a href="emp_report?page=${i-1}">${i}</a>]&nbsp;&nbsp;
				</c:forEach>

				<c:if test="${!pageData.isLast()}">
					<a href="emp_report?page=${pageData.getTotalPages()-1}">[Last]</a>&nbsp;&nbsp;
				</c:if>

				<c:if test="${!pageData.isFirst()}">
					<a href="emp_report?page=${pageData.getNumber()-1}">[Previous]</a>
				</c:if>
			</h3>
	</c:when>
	<c:otherwise>
		<h1 style="text-align: center; color: red">Record Not Found</h1>
	</c:otherwise>
</c:choose>

<h1 style="text-align: right; color: red; font-size: small;">
	<a style="color: red" href="insert_employee">Add Employee</a>
</h1>

<h1 style="text-align: left; color: red; font-size: small;">
	<a style="color: red" href="./">Home</a>
</h1>
<br>
<h1 style="text-align: center; color: green; font-size: small;">${result}</h1>

