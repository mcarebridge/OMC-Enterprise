<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<body>
	<div id="wrapper" style="width: 99%;">
		<c:if test="${requestScope.showHeader == true}">
			<div id="header">
				<span title="${sessionScope.currentUser.employeeRef.model.firstName}  &nbsp;${sessionScope.currentUser.employeeRef.model.lastName}">${sessionScope.currentUser.employeeRef.model.firstName}&nbsp;${sessionScope.currentUser.employeeRef.model.lastName}</span> 
				<span title="${sessionScope.currentUser.companyRef.model.companyName}">${fn:substring(sessionScope.currentUser.companyRef.model.companyName,0,15)}</span> <span><a
					href="/humancapital/logout">Logout</a></span>
			</div>
			<div id="Nav">
			        <ul id="maintab" class="basictab">
			        
				 <li>  <a href="/humancapital/home" class="active">Dashboard</a></li> 
				 
				  <li  rel="location_submenu"><a href="/humancapital/addLocation">Location</a> </li>
				  <li  rel="shift_submenu"><a href="/humancapital/addShift">Shift</a> </li>
				  <li  rel="employee_submenu"><a href="/humancapital/employeeIndex" >Employee</a></li> 
				  <li  rel="assignment_submenu"><a href="/humancapital/assignmentIndex">Assignment</a></li>
				  <li  rel="assignment_submenu"><a href="/humancapital/createContractorCompany">Contractor</a></li>  
				  <li  rel="reports_submenu" ><a href="/humancapital/reportsIndex">Reports</a></li>
				  <li><a href="/humancapital/configurationIndex">Configuration</a></li>
				</ul>
				
			</div>
			<!-- 
			   <div id="location_submenu" class="submenustyle">
				<a href="/humancapital/addLocation">Create Location</a>
				<a href="#">Edit Location</a>
				</div>
				
				 <div id="shift_submenu" class="submenustyle">
				<a href="/humancapital/addShift">Create Shift</a>
				<a href="#">Edit Shift</a>
				</div>
				
				 <div id="employee_submenu" class="submenustyle">
				<a href="/humancapital/addEmployee">Create Employee</a>
				<a href="#">Edit Employee</a>
				</div>
				
				 <div id="assignment_submenu" class="submenustyle">
				<a href="/humancapital/assignment">Current Assignments</a>
				<a href="/humancapital/assignment">Future Assignments</a>
				</div>
				
				 <div id="reports_submenu" class="submenustyle">
				<a href="/humancapital/consolidatedTimesheetReport?actionParam=search">Consolidated Timesheet Report</a>
				<a href="#">Time Card</a>
				</div>
				 -->
		</c:if>
		<div id="contentWrapper">
			<div>
				<h2
					style="float: right; color: #6699CC; font-size: 8px; right; padding: 10px 10px 0px 0px">TM</h2>
				<a href='#' class='logo'>OneMasterControl</a>
			</div>
			<div class="left" style="width: 99%;">
				<div class="content">
					<h1 style="font-family: 'Gruppo', cursive;">
						<fmt:message key="${requestScope.pageHeader}" />
					</h1>
					<div class="about" style="width: 100%;">
						<c:if test="${requestScope.showErrBox == true}">
							<div class="required_string">
								<span>*</span>Required Fields
							</div>
							<span id="errormsg" class="error_main"> <a
								href="javascript:hidediv()">X</a>
								<h3>Please check the following error(s):</h3> <span
								class="error_list"> <c:forEach var="e"
										items="${f:errors()}">
										<li>${f:h(e)}</li>
									</c:forEach>
									<ul>
									</ul>
							</span></span>
						</c:if>