<%@page pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="cronJobManualPush" method="post">
	
	<input type="hidden" name="actionParam" value="cronJobManual"/> 
	<table>
	<tr>
	<td>
	Action :</td><td><select name="processName">
		<option value="STORE_WEEKLY_REPORT">Store Weekly Report</option>
		<option value="UPDATE_PREV_TIMESHEET">Update Previous Timesheet</option>
		<option value="STORE_PAYROLL_REPORT">Store Payroll Report</option>
	</select></td>
	</tr>
	<tr>
	<td>
	Current Date:</td>
	<td>
		<input type="text" name="currentDate">  * MM/dd/yyyy format
	</td>
	</tr>
	<tr>
	<td>
		Company Id:
	</td>
	<td>
		<select name="companyId">
			<c:forEach var="e" items="${requestScope.companyIds}">
						<option ${f:select("companyId",f:h(e))}>${f:h(e)}</option>
			</c:forEach>
		</select>
	</td>
	</tr>
	<tr>
	<td>
		<input type="submit" name="Submit" value="submit">	
	</td>
	</tr>
</table>


</form>


</body>
</html>