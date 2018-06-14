<%@include file="common/common.jsp"%>
<%@include file="common/header.jsp"%>
<%@ page import="java.util.Date"%>
<script type="text/javascript"
	src="scripts/jquery-1.6.2.js?updated=<%=new Date()%>"></script>
<script type="text/javascript"
	src="scripts/jquery.dataTables.js?updated=<%=new Date()%>"></script>
<script type="text/javascript"
	src="scripts/jquery-ui-1.8.16.custom.js?updated=<%=new Date()%>"></script>
<script type="text/javascript"
	src="scripts/date.js?updated=<%=new Date()%>"></script>

<script type="text/javascript" src="scripts/assignment.js"></script>
<link href="styles/demo_table.css" rel="stylesheet" type="text/css">	
</head>
<%@include file="common/assignmentPageUpper.jsp"%>
<form action="assignment" method="post" onsubmit="return validate('<%=request.getSession().getAttribute("isDepartment")%>');">
	<input type="hidden" name="actionParam" value="addAssignment">
	<div class='aout'>
		<table width="100%" bordercolor="black" id="results" class="display">
			<thead>
				<tr>
					<th style="width:1%" scope="col"></th>
					<th  style="width:8%" scope="col">Emp Id</th>
					<th  style="width:8%" scope="col">Type</th>
					<th  style="width:8%" scope="col">First</th>
					<th  style="width:8%" scope="col">Last</th>
					<th  style="width:2%" scope="col" align="center">Gender</th>
					<th  style="width:10%" scope="col">Location</th>
					<th  style="width:8%" scope="col">Shift</th>
					 <c:if test="${sessionScope.isDepartment == 'Y'}">
					 <th  style="width:8%" scope="col">Department</th>
					 </c:if>
					<th  style="width:14%" scope="col">Start Date</th>
					<th style="width:14%" scope="col">End Date</th>
					<th  style="width:10%" scope="col">Status</th>
					<th  style="width:8%" scope="col"></th>

				</tr>
			</thead>
			<tbody>
				<%
					int count = 0;
				%>

				<c:forEach var="assignment" items="${assignmentList}">
					<tr <%if (count % 2 == 0) {%> class='altrow' <%}%>>
						<td align="center" valign='middle' id="ass_<%=count%>" >

							${f:h(assignment.locked)} <input type="hidden"
							name="assignmentId" value="${f:h(assignment.assignmentId)}" /> <input
							type="hidden" name="locked" id="locked_<%=count %>"
							value="${f:h(assignment.locked)}" />
							<c:if test="${assignment.supervisor == 'Y'}">
								<img src='/humancapital/images/captain_icon.png' 
								alt='Supervisor' border='0' height='12' width='12'/>
							</c:if>
							
						</td>
						<td>${f:h(assignment.companyEmpId)} <input type="hidden"
							name="employeeId" value="${f:h(assignment.employeeId)}">
						</td>
						<c:choose>
							<c:when test="${assignment.employeeType == 1}">
								<td>Permanent</td>
							</c:when>
							<c:when test="${assignment.employeeType == 2}">
								<td>Contractor</td>
							</c:when>
							<c:when test="${assignment.employeeType == 3}">
								<td>Individual Contractor</td>
							</c:when>
							<c:otherwise>
								<td>${f:h(assignment.employeeType)}-Not defined</td>
							</c:otherwise>
						</c:choose>
						<td>${f:h(assignment.firstName)}</td>
						<td>${f:h(assignment.lastName)}</td>
						<td style="text-align: center;">${f:h(assignment.gender)}</td>
						<td align="left"><select name="location"
							class="locationSelect" id="location"
							onchange="populateShiftList(this.value,<%=count%>,'<%=request.getSession().getAttribute("isDepartment")%>');">
								<option value="">Select Location</option>
								<c:forEach var="e" items="${sessionScope.locationList}">
									<option ${f:select("location",f:h(e.key.id))}>${f:h(e.locationName)}</option>
								</c:forEach>
						</select> <input type="hidden" name="locationId"
							value="${f:h(assignment.locationId)}"></td>
						<td>
							<div id="shiftDiv_<%=count%>">
								<select class="shiftSelect1" name="shift" id="shift_<%=count%>"
									onchange="javascript:setShfitId(<%=count%>);">
									<option value="">Select Shift</option>
									<c:forEach var="shift" items="${assignment.shiftList}">
										<option ${f:select("shift",f:h(shift.shiftId))}>${f:h(shift.shiftName)}</option>
									</c:forEach>
								</select>
							</div> <input type="hidden" name="shiftId" id="shiftId_<%=count%>"
							value="${f:h(assignment.shiftId)}">

						</td>
						 <c:if test="${sessionScope.isDepartment == 'Y'}">
						<td align="left">
						   <div id="departmentDiv_<%=count%>">
						   <select name="department" onchange="javascript:setDepartmentId(<%=count%>);"
							class="locationSelect" id="departmentSelect_<%=count%>">
								<option value="">Select Department</option>
								<c:forEach var="e" items="${assignment.departmentList}">
									<option ${f:select("department",f:h(e.key.id))}>${f:h(e.departmentName)}</option>
								</c:forEach>
						   </select> 
						  </div>
						  <input type="hidden" name="departmentId" id="departmentId_<%=count%>"
							value="${f:h(assignment.departmentId)}">
						</td>
							</c:if>
						<td><input type="text" name="startDate"
							value="${f:h(assignment.startDt)}" readonly="readonly" size="11"
							style="width: 80px" id="startDate_<%=count %>"></td>
						<td><input type="text" name="endDate"
							value="${f:h(assignment.endDt)}" readonly="readonly" size="11"
							style="width: 80px" id="endDate_<%=count %>"></td>
						<td>${f:h(assignment.status)} <input type="hidden"
							name="status" value="${f:h(assignment.status)}"> <input
							type="hidden" name="validated" value="false">
						</td>
						<td style="text-align: center;"><input type="hidden" name="editable"
							value="${f:h(assignment.editable)}" />
							
							 <c:if
								test="${assignment.editable == 'N'}">
								<a href="javascript:editRecord(<%=count%>)">edit</a>
							</c:if>
							
							 <c:if
								test="${assignment.editable == 'Y'}">
								-
							</c:if>
							
							
							</td>

					</tr>
					<%
						count++;
					%>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<br>
	<!--  TODO : This is a improper tag. Need to be replaced. -->
	<c:if test="${count != '0'}">
		<div style="float: right">
			<table>
				<td align="left"><input type="submit" value="Assign"
					class="select1"></td>
				<td><input type="button" value="Reset" name="Reset"
					title="Reset" class="select1"></td>
				</tr>
			</table>
		</div>
	</c:if>
	<input type="hidden" id="currentDate"${f:hidden("currentDate")}>
</form>
<script>
$(function() {
	var len=<%=count%>;
	setUpPageComponents(len,'<%=request.getSession().getAttribute("isDepartment")%>');
});
$(document).ready(function() {  
	setDataTable('<%=request.getSession().getAttribute("isDepartment")%>');
} ); 
</script>
<%@include file="common/footer.jsp"%>
<script>
//document.getElementById("assignment_submenu").style.display='block';
</script>
