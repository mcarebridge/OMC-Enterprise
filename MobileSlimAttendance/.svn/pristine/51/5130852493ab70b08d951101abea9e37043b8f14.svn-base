<%@page pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
<head>
<script type="text/javascript">
	function submitForm(_action) {
		//alert(_action);
		timeZoneDetect();
		document.entityForm.action.value = _action;
		var index = document.forms[0].entityType.selectedIndex;
		document.forms[0].selectedEntityType.value = document.forms[0].entityType.options[index].text;
		document.entityForm.submit();
	}

	function timeZoneDetect() {

		var d = new Date();
		var gmtHours = -d.getTimezoneOffset() / 60;
		if ((gmtHours) > 0) {

			gmtHours = '+' + gmtHours;
		}
		var tzone = "GMT" + gmtHours
		document.entityForm.clientTimeZone.value = tzone;
	}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Entity CRUD Screen</title>
<link rel="stylesheet" type="text/css" href="/css/style.css" />
</head>
<body>
	<form name="entityForm" action="testData" method="post">
		<fmt:setTimeZone value="${f:timeZone()}" />
		<table valign="top" border="1">
			<tr>
				<td colspan='4'>Entity CRUD screen</td>
			</tr>
			<tr>
				<td colspan='4'>${errMessage}</td>
			</tr>
			<tr>
				<td colspan='4'>Your Time Zone is : ${timeZone.displayName}</td>
			</tr>
			<tr>
				<td>File Location</td>
				<td></td>
				<td></td>
				<td><input type="text" name="fileLocation"
					value="${fileLocation}" /></td>
			</tr>
			<tr>
				<td>Select an entity</td>
				<td><select name="entityType" size="1">
						<option values="-1">Select a Entity</option>
						<option values="MA_Country">MA_Country</option>
						<option values="MA_State">MA_State</option>
						<option values="MA_UserProfile">MA_UserProfile</option>
						<option values="MA_NatureOfCompany">MA_NatureOfCompany</option>
						<option values="MA_Company">MA_Company</option>
						<option values="MA_Holiday">MA_Holiday</option>
						<option values="MA_Template">MA_Template</option>
						<option values="MA_TemplateSkill">MA_TemplateSkill</option>
						<option values="MA_User">MA_User</option>
						<option values="MA_Employee">MA_Employee</option>
						<option values="MA_Address">MA_Address</option>
						<option values="MA_Location">MA_Location</option>
						<option values="MA_Shift">MA_Shift</option>
						<option values="MA_Assignment">MA_Assignment</option>
						<option values="MA_Timesheet">MA_Timesheet</option>
						<option values="MA_TimeSheetRule">MA_TimeSheetRule</option>
						<option values="MA_ConsolidatedTimesheet">MA_ConsolidatedTimesheet</option>
						<option values="MA_DashboardData">MA_DashboardData</option>
						<option values="MA_Department">MA_Department</option>
						<option values="MA_LocationHoliday">MA_LocationHoliday</option>
						<option values="MA_EmailTemplate">MA_EmailTemplate</option>
				</select></td>
				<td></td>
				<td><input type="button" name="read" value="Read a Entity"
					onClick="javascript:submitForm('read')" ; /></td>
			</tr>
			<tr>
				<td><input type="button" name="addEntity"
					value="Add/Update a Entity"
					onClick="javascript:submitForm('addEntity')" ; /></td>
				<td><input type="button" name="deleteEntity"
					value="Delete a Entity"
					onClick="javascript:submitForm('deleteEntity')" ; /></td>
				<td><input type="button" name="deleteEntities"
					value="DeleteAll" onClick="javascript:submitForm('deleteEntities')" ; />
				</td>
				<td><input type="button" name="addEntities" value="Add All"
					onClick="javascript:submitForm('addEntities')" ; /></td>
			</tr>
			<tr>
				<td colspan='4'>${entityType}</td>
			</tr>
			<tr>
				<td colspan="4"
					style="position: relative; overflow: scroll; background-color: #EEE;">
					<!--  Display Country --> <c:if
						test="${entityType == 'MA_Country'}">
						<table border="1">
							<tr>
								<td>Key</td>
								<td>Value</td>
								<td>Created Date</td>
								<td>Updated Date</td>
								<td>Created By</td>
								<td>Updated By</td>
							</tr>
							<c:forEach var="e" items="${entityList}">
								<tr>
									<td>${f:h(e.key.id)}</td>
									<td>${f:h(e.countryName)}</td>
									<td><fmt:formatDate value="${e.createdDate}" type="both"
											dateStyle="full" timeStyle="full" /></td>
									<td><fmt:formatDate value="${e.updatedDate}" type="both"
											dateStyle="full" timeStyle="full" /></td>
									<td>${f:h(e.createdBy)}</td>
									<td>${f:h(e.updatedBy)}</td>
								</tr>
							</c:forEach>
						</table>
					</c:if> <!--  Display State --> <c:if test="${entityType == 'MA_State'}">
						<table border="1">
							<tr>
								<td>Key</td>
								<td>Company Key</td>
								<td>Value</td>
								<td>Created Date</td>
								<td>Updated Date</td>
								<td>Created By</td>
								<td>Updated By</td>
							</tr>
							<c:forEach var="e" items="${entityList}">
								<tr>
									<td>${f:h(e.key.id)}</td>
									<td>${f:h(e.countryRef.key.id)}</td>
									<td>${f:h(e.stateName)}</td>
									<td><fmt:formatDate value="${e.createdDate}" type="both"
											dateStyle="full" timeStyle="full" /></td>
									<td><fmt:formatDate value="${e.updatedDate}" type="both"
											dateStyle="full" timeStyle="full" /></td>
									<td>${f:h(e.createdBy)}</td>
									<td>${f:h(e.updatedBy)}</td>
								</tr>
							</c:forEach>
						</table>
					</c:if> <!--  Display UserProfile --> <c:if
						test="${entityType == 'MA_UserProfile'}">
						<table border="1">
							<tr>
								<td>Key</td>
								<td>Value</td>
								<td>Created Date</td>
								<td>Updated Date</td>
								<td>Created By</td>
								<td>Updated By</td>
							</tr>
							<c:forEach var="e" items="${entityList}">
								<tr>
									<td>${f:h(e.key.id)}</td>
									<td>${f:h(e.userProfileDesc)}</td>
									<td><fmt:formatDate value="${e.createdDate}" type="both"
											dateStyle="full" timeStyle="full" /></td>
									<td><fmt:formatDate value="${e.updatedDate}" type="both"
											dateStyle="full" timeStyle="full" /></td>
									<td>${f:h(e.createdBy)}</td>
									<td>${f:h(e.updatedBy)}</td>
								</tr>
							</c:forEach>
						</table>
					</c:if> <!--  Display NatureOfCompany --> <c:if
						test="${entityType == 'MA_NatureOfCompany'}">
						<table border="1">
							<tr>
								<td>Key</td>
								<td>Value</td>
								<td>Created Date</td>
								<td>Updated Date</td>
								<td>Created By</td>
								<td>Updated By</td>
							</tr>
							<c:forEach var="e" items="${entityList}">
								<tr>
									<td>${f:h(e.key.id)}</td>
									<td>${f:h(e.natureOfBusinessDesce)}</td>
									<td><fmt:formatDate value="${e.createdDate}" type="both"
											dateStyle="full" timeStyle="full" /></td>
									<td><fmt:formatDate value="${e.updatedDate}" type="both"
											dateStyle="full" timeStyle="full" /></td>
									<td>${f:h(e.createdBy)}</td>
									<td>${f:h(e.updatedBy)}</td>
								</tr>
							</c:forEach>
						</table>
					</c:if> <!--  Display Company --> <c:if
						test="${entityType == 'MA_Company'}">
						<table border="1">
							<tr>
								<td>Id</td>
								<td>companyName</td>
								<td>natureOfCompanyRefId</td>
								<td>emplyoeePopulation</td>
								<td>Created Date</td>
								<td>Updated Date</td>
								<td>Created By</td>
								<td>Updated By</td>

							</tr>
							<c:forEach var="e" items="${entityList}">
								<tr>
									<td>${f:h(e.key.id)}</td>
									<td>${f:h(e.companyName)}</td>
									<td>${f:h(e.natureOfCompanyRef.key.id)}</td>
									<td>${f:h(e.emplyoeePopulation)}</td>
									<td><fmt:formatDate value="${e.createdDate}" type="both"
											dateStyle="full" timeStyle="full" /></td>
									<td><fmt:formatDate value="${e.updatedDate}" type="both"
											dateStyle="full" timeStyle="full" /></td>
									<td>${f:h(e.createdBy)}</td>
									<td>${f:h(e.updatedBy)}</td>

								</tr>
							</c:forEach>
						</table>
					</c:if> <!--  Display User --> <c:if test="${entityType == 'MA_User'}">
						<table border="1">
							<tr>
								<td>Id</td>
								<td>userName</td>
								<td>password</td>
								<td>imeiCode</td>
								<td>companyRefId</td>
								<td>Created Date</td>
								<td>Updated Date</td>
								<td>Created By</td>
								<td>Updated By</td>

							</tr>
							<c:forEach var="e" items="${entityList}">
								<tr>
									<td>${f:h(e.key.id)}</td>
									<td>${f:h(e.userName)}</td>
									<td>${f:h(e.password)}</td>
									<td>${f:h(e.imeiCode)}</td>
									<td>${f:h(e.companyRef.key.id)}</td>
									<td><fmt:formatDate value="${e.createdDate}" type="both"
											dateStyle="full" timeStyle="full" /></td>
									<td><fmt:formatDate value="${e.updatedDate}" type="both"
											dateStyle="full" timeStyle="full" /></td>
									<td>${f:h(e.createdBy)}</td>
									<td>${f:h(e.updatedBy)}</td>

								</tr>
							</c:forEach>
						</table>
					</c:if> <!--  Display Address --> <c:if
						test="${entityType == 'MA_Address'}">
						<table border="1">
							<tr>
								<td>Id</td>
								<td>companyRefId</td>
								<td>stateRefId</td>
								<td>line1</td>
								<td>line2</td>
								<td>city</td>
								<td>emailAddress</td>
								<td>pinCode</td>
								<td>timeZone</td>
								<td>Created Date</td>
								<td>Updated Date</td>
								<td>Created By</td>
								<td>Updated By</td>
							</tr>
							<c:forEach var="e" items="${entityList}">
								<tr>
									<td>${f:h(e.key.id)}</td>
									<td>${f:h(e.companyRef.key.id)}</td>
									<td>${f:h(e.stateRef.key.id)}</td>
									<td>${f:h(e.line1)}</td>
									<td>${f:h(e.line2)}</td>
									<td>${f:h(e.city)}</td>
									<td>${f:h(e.emailAddress.email)}</td>
									<td>${f:h(e.pinCode)}</td>
									<td>${f:h(e.timeZone)}</td>
									<td><fmt:formatDate value="${e.createdDate}" type="both"
											dateStyle="full" timeStyle="full" /></td>
									<td><fmt:formatDate value="${e.updatedDate}" type="both"
											dateStyle="full" timeStyle="full" /></td>
									<td>${f:h(e.createdBy)}</td>
									<td>${f:h(e.updatedBy)}</td>

								</tr>
							</c:forEach>
						</table>
					</c:if> <!--  Display Employee --> <c:if
						test="${entityType == 'MA_Employee'}">
						<table border="1">
							<tr>
								<td>Id</td>
								<td>companyRefId</td>
								<td>firstName</td>
								<td>lastName</td>
								<td>salutation</td>
								<td>gender</td>
								<td>empCompanyId</td>
								<td>pwd</td>
								<td>minWorkingHrsPerDay</td>
								<td>numOfWorkingDays</td>
								<td>dayOfWeeklyOff</td>
								<td>isWeeklyOfFlexible</td>
								<td>Start Date</td>
								<td>Created Date</td>
								<td>Updated Date</td>
								<td>Created By</td>
								<td>Updated By</td>
								<td>QR Code</td>

							</tr>
							<c:forEach var="e" items="${entityList}">
								<tr>
									<td>${f:h(e.key.id)}</td>
									<td>${f:h(e.companyRef.key.id)}</td>
									<td>${f:h(e.firstName)}</td>
									<td>${f:h(e.lastName)}</td>
									<td>${f:h(e.salutation)}</td>
									<td>${f:h(e.gender)}</td>
									<td>${f:h(e.companyEmpId)}</td>
									<td>${f:h(e.empPwd)}</td>
									<td>${f:h(e.minWorkingHrsPerDay)}</td>
									<td>${f:h(e.numOfWorkingDays)}</td>
									<td>${f:h(e.dayOfWeeklyOff)}</td>
									<td>${f:h(e.weeklyOffFlexible)}</td>
									<td><fmt:formatDate value="${e.startDate}" type="both"
											dateStyle="full" timeStyle="full" /></td>
									<td><fmt:formatDate value="${e.createdDate}" type="both"
											dateStyle="full" timeStyle="full" /></td>
									<td><fmt:formatDate value="${e.updatedDate}" type="both"
											dateStyle="full" timeStyle="full" /></td>
									<td>${f:h(e.createdBy)}</td>
									<td>${f:h(e.updatedBy)}</td>
									<td><img
										src="https://chart.googleapis.com/chart?chs=150x150&amp;cht=qr&amp;chl=${f:h(e.companyRef.key.id)}&#64;${f:h(e.companyEmpId)}&amp;choe=UTF-8"
										alt="QR code" /></td>

								</tr>
							</c:forEach>
						</table>
					</c:if> <!--  Display Location --> <c:if
						test="${entityType == 'MA_Location'}">
						<table border="1">
							<tr>
								<td>Id</td>
								<td>addressRefId</td>
								<td>companyRefId</td>
								<td>locationName</td>
								<td>geoPoints</td>
								<td>active</td>
								<td>TimeZone</td>
								<td>Created Date</td>
								<td>Updated Date</td>
								<td>Created By</td>
								<td>Updated By</td>

							</tr>
							<c:forEach var="e" items="${entityList}">
								<tr>
									<td>${f:h(e.key.id)}</td>
									<td>${f:h(e.addressRef.key.id)}</td>
									<td>${f:h(e.companyRef.key.id)}</td>
									<td>${f:h(e.locationName)}</td>
									<td>tbd</td>
									<td>${f:h(e.active)}</td>
									<td>${f:h(e.timeZone)}</td>
									<td><fmt:formatDate value="${e.createdDate}" type="both"
											dateStyle="full" timeStyle="full" /></td>
									<td><fmt:formatDate value="${e.updatedDate}" type="both"
											dateStyle="full" timeStyle="full" /></td>
									<td>${f:h(e.createdBy)}</td>
									<td>${f:h(e.updatedBy)}</td>

								</tr>
							</c:forEach>
						</table>
					</c:if> <!--  Display Shift --> <c:if test="${entityType == 'MA_Shift'}">
						<table border="1">
							<tr>
								<td>Id</td>
								<td>shiftName</td>
								<td>startTime</td>
								<td>endTime</td>
								<td>active</td>
								<td>locationRefId</td>
								<td>userRefId</td>
								<td>Created Date</td>
								<td>Updated Date</td>
								<td>Created By</td>
								<td>Updated By</td>
								<td>GMT Start Hrs</td>
								<td>GMT Start min</td>
								<td>GMT End Hrs</td>
								<td>GMT End Min</td>
								
							</tr>
							<c:forEach var="e" items="${entityList}">
								<tr>
									<td>${f:h(e.key.id)}</td>
									<td>${f:h(e.shiftName)}</td>
									<td>${f:h(e.startTime)}</td>
									<td>${f:h(e.endTime)}</td>
									<td>${f:h(e.active)}</td>
									<td>${f:h(e.locationRef.key.id)}</td>
									<td>${f:h(e.userRef.key.id)}</td>
									<td><fmt:formatDate value="${e.createdDate}" type="both"
											dateStyle="full" timeStyle="full" /></td>
									<td><fmt:formatDate value="${e.updatedDate}" type="both"
											dateStyle="full" timeStyle="full" /></td>
									<td>${f:h(e.createdBy)}</td>
									<td>${f:h(e.updatedBy)}</td>
									<td>${f:h(e.startGMTHrs)}</td>
									<td>${f:h(e.startGMTMin)}</td>
									<td>${f:h(e.endGMTHrs)}</td>
									<td>${f:h(e.endGMTMin)}</td>
									
								</tr>
							</c:forEach>
						</table>
					</c:if> <!--  Display Assignment --> <c:if
						test="${entityType == 'MA_Assignment'}">
						<table border="1">
							<tr>
								<td>Id</td>
								<td>shiftRefId</td>
								<td>employeeRefId</td>
								<td>CompanyEmpId</td>
								<td>startDate</td>
								<td>endDate</td>
								<td>status</td>
								<td>Created Date</td>
								<td>Updated Date</td>
								<td>Created By</td>
								<td>Updated By</td>

							</tr>
							<c:forEach var="e" items="${entityList}">
								<tr>
									<td>${f:h(e.key.id)}</td>
									<td>${f:h(e.shiftRef.key.id)}</td>
									<td>${f:h(e.employeeRef.key.id)}</td>
									<td>${f:h(e.employeeRef.model.companyEmpId)}</td>
									<td>${f:h(e.startDate)}</td>
									<td>${f:h(e.endDate)}</td>
									<td>${f:h(e.status)}</td>
									<td><fmt:formatDate value="${e.createdDate}" type="both"
											dateStyle="full" timeStyle="full" /></td>
									<td><fmt:formatDate value="${e.updatedDate}" type="both"
											dateStyle="full" timeStyle="full" /></td>
									<td>${f:h(e.createdBy)}</td>
									<td>${f:h(e.updatedBy)}</td>

								</tr>
							</c:forEach>
						</table>
					</c:if> <!--  Display Timesheet --> <c:if
						test="${entityType == 'MA_Timesheet'}">
						<table border="1">
							<tr>
								<td>Id</td>
								<td>assignmentRefId</td>
								<td>inDateTime</td>
								<td>outDateTime</td>
								<td>Daily Effort</td>
								<td>Marker</td>
								<td>Year</td>
								<td>Month</td>
								<td>Day</td>
								<td>Count</td>
								<td>Created Date</td>
								<td>Updated Date</td>
								<td>Created By</td>
								<td>Updated By</td>

							</tr>
							<c:forEach var="e" items="${entityList}">
								<tr>
									<td>${f:h(e.key.id)}</td>
									<td>${f:h(e.assignmentRef.key.id)}</td>
									<td>${f:h(e.inDateTime)}</td>
									<td>${f:h(e.outDateTime)}</td>
									<td>${f:h(e.dailyEffort)}</td>
									<td>${f:h(e.marker)}</td>
									<td>${f:h(e.createYear)}</td>
									<td>${f:h(e.createMonth)}</td>
									<td>${f:h(e.createDay)}</td>
									<td>${f:h(e.count)}</td>
									<td><fmt:formatDate value="${e.createdDate}" type="both"
											dateStyle="full" timeStyle="full" /></td>
									<td><fmt:formatDate value="${e.updatedDate}" type="both"
											dateStyle="full" timeStyle="full" /></td>
									<td>${f:h(e.createdBy)}</td>
									<td>${f:h(e.updatedBy)}</td>
								</tr>
							</c:forEach>
							</c:if>
							<!--  Display ConsolidatedTimesheet -->
							<c:if test="${entityType == 'MA_ConsolidatedTimesheet'}">
								<table border="1">
									<tr>
										<td>Id</td>
										<td>inDateTime</td>
										<td>outDateTime</td>
										<td>createDay</td>
										<td>createMonth</td>
										<td>createYear</td>
										<td>marker</td>
										<td>actualDailyEffort</td>
										<td>billableEfforts</td>
										<td>Created Date</td>
										<td>Updated Date</td>
										<td>Created By</td>
										<td>Updated By</td>

									</tr>
									<c:forEach var="e" items="${entityList}">
										<tr>
											<td>${f:h(e.key.id)}</td>
											<td>${f:h(e.inDateTime)}</td>
											<td>${f:h(e.outDateTime)}</td>
											<td>${f:h(e.createDay)}</td>
											<td>${f:h(e.createMonth)}</td>
											<td>${f:h(e.createYear)}</td>
											<td>${f:h(e.marker)}</td>
											<td>${f:h(e.actualDailyEffort)}</td>
											<td>${f:h(e.billableEfforts)}</td>
											<td><fmt:formatDate value="${e.createdDate}" type="both"
													dateStyle="full" timeStyle="full" /></td>
											<td><fmt:formatDate value="${e.updatedDate}" type="both"
													dateStyle="full" timeStyle="full" /></td>
											<td>${f:h(e.createdBy)}</td>
											<td>${f:h(e.updatedBy)}</td>
										</tr>
									</c:forEach>
								</table>
							</c:if>
							<!--  Display MA_TimeSheetRule -->
							<c:if test="${entityType == 'MA_TimeSheetRule'}">
								<table border="1">
									<tr>
										<td>Id</td>
										<td>ruleKey</td>
										<td>value</td>
										<td>companyRefId</td>
										<td>Created Date</td>
										<td>Updated Date</td>
										<td>Created By</td>
										<td>Updated By</td>
									</tr>
									<c:forEach var="e" items="${entityList}">
										<tr>
											<td>${f:h(e.key.id)}</td>
											<td>${f:h(e.ruleKey)}</td>
											<td>${f:h(e.value)}</td>
											<td>${f:h(e.companyRef.key.id)}</td>
											<td><fmt:formatDate value="${e.createdDate}" type="both"
													dateStyle="full" timeStyle="full" /></td>
											<td><fmt:formatDate value="${e.updatedDate}" type="both"
													dateStyle="full" timeStyle="full" /></td>
											<td>${f:h(e.createdBy)}</td>
											<td>${f:h(e.updatedBy)}</td>
										</tr>
									</c:forEach>
								</table>
							</c:if>
							<!--  Display MA_TimeSheetRule -->
							<c:if test="${entityType == 'MA_EmailTemplate'}">
								<table border="1">
									<tr>
										<td>Id</td>
										<td>templateType</td>
										<td>emailSubject</td>
										<td>emailMessage</td>
									</tr>
									<c:forEach var="e" items="${entityList}">
										<tr>
											<td>${f:h(e.key.id)}</td>
											<td>${f:h(e.templateType)}</td>
											<td>${f:h(e.emailSubject)}</td>
											<td>${f:h(e.emailMessage.value)}</td>
										</tr>
									</c:forEach>
								</table>
							</c:if>
							</td>
							</tr>
						</table>
						<input type="hidden" name="action" value="" />
						<input type="hidden" name="selectedEntityType" value="" />
						<input type="hidden" name="clientTimeZone" value="" />
						</form>
</body>
</html>