<%@page pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome to Test Data</title>

<script type="text/javascript"> 
	function submitForm(_action) {
		//alert(_action);
		timeZoneDetect();
		document.timeSheetForm.action.value = _action;
		document.timeSheetForm.submit();
	}

	function timeZoneDetect() {

		var d = new Date();
		var gmtHours = -d.getTimezoneOffset() / 60;
		if ((gmtHours) > 0) {

			gmtHours = '+' + gmtHours;
		}
		var tzone = "GMT" + gmtHours
		document.timeSheetForm.clientTimeZone.value = tzone;
	}
</script>
</head>
<body>
	<form name="timeSheetForm" action="testTimeSheet" method="post">

		<table border='1'>
			<tr>
				<td colspan='4'>
					<table>
						<tr>
							<td>Company Id</td>
							<td><input type='text' name='companyId' value='' /></td>
							<td></td>
							<td></td>
						</tr>
					</table>
				</td>
			</tr>
			</td>
			</tr>

			<tr>
				<td>Company Name :</td>
				<td>${company.companyName}</td>
				<td colspan='2'>
					<table border='1' width='800px'>
						<tr>
							<td width='100px'>Location</td>
							<c:forEach var="mc" items="${monthlyCalendar}">
								<td width='20px'>${mc}</td>
							</c:forEach>
						</tr>
					</table>
				</td>
			</tr>
			<c:forEach var="l" items="${company.employeeList}">
				<tr>
					<td>${l.key.id}</td>
					<td>${l.firstName}, ${l.lastName}</td>
					<td colspan='2'>
						<table border='1' width="800px">

							<c:forEach var="a" items="${l.assignments}">
								<tr>
									<td width='100px'>${a.locationRef.key.id}</td>
									<c:forEach var="t" items="${a.timesheets}">
										<td width='20px'>${t.dailyEffort}</td>
									</c:forEach>

								</tr>
							</c:forEach>
						</table></td>
				</tr>
			</c:forEach>
			
			<tr>
				<td><input type="button" name="loadtimesheet"
					value="Load Timesheet"
					onClick="javascript:submitForm('loadtimesheet')" ; />
				</td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
		</table>


		<input type="hidden" name="action" value="" /> <input type="hidden"
			name="clientTimeZone" value="" />
	</form>
</body>
</html>