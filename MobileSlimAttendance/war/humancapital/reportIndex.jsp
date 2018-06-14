<%@include file="common/common.jsp"%>
<%@include file="common/header.jsp"%>
<script>
	function listAndPrint(_action) {

		document.forms[0].actionParam.value = 'listAndPrint';
		document.forms[0].submit();
	}
</script>
</head>
<%@include file="common/assignmentPageUpper.jsp"%>
<form method="post" action="mobileAuditTrailReport">
	<input type="hidden" name="actionParam" value="">
	<input type="hidden" name="timeoffset" value="">
	<div class="secondarymenu"
		style="height: 400px; width: 98%;  vertical-align: middle; margin-left: 40px ">
		
		<h2 style="font-family: 'Gruppo', cursive;color: #6699CC;">
			<fmt:message key="${requestScope.pageSubHeader1}" />
		</h2>
		<ol style="font-size: 12px;font-family: 'Gruppo', cursive; position:relative;
						left:30px; padding-top: 5px">
			
				<%-- 
				<li  type=disc style="font-family: 'Gruppo', cursive;"><a
					href="/humancapital/currentDayTimesheetReport?MM=00&DD=00&YY=00">Current
						Day Timesheet Report</a></li>
				--%>
				 
					<li  type=disc style="padding-top: 5px"><a
						href="/humancapital/currentDayTimesheetReport">Current
							Day Timesheet Report</a></li>
				
			
			
				<li  type=disc style="padding-top: 5px"><a
					href="/humancapital/consolidatedTimesheetReport">Consolidated Timesheet
						Report</a></li>
			
			
				<li   type=disc style="padding-top: 5px"><a
					href="/humancapital/periodicTimesheetReport">Monthly Time Card Grid</a></li>
			
			<%-- 
				<li   type=disc style="padding-top: 5px"><a
					href="/humancapital/payRollTimesheetReport">Payroll Report</a></li>
			--%>
			


			<c:if test="${sessionScope.isDepartment == 'Y'}" >
				
					<li   type=disc style="padding-top: 5px"><a
						href="/humancapital/departmentDashboard">Department Dashboard</a></li>
				
			</c:if>
			</ol>
		
			<br><br>
			<h2 style="font-family: 'Gruppo', cursive;color: #6699CC;">
			<fmt:message key="${requestScope.pageSubHeader2}" />
		</h2>
			<ol style="font-size: 12px;font-family: 'Gruppo', cursive; position:relative;
						left:30px;">
			<li  type=disc style="padding-top: 5px"><a
						href="weeklyTimeRecord">Weekly Time Report</a></li>
			<li  type=disc style="padding-top: 5px"><a
						href="monthlyPayrollReport">Monthly Payroll Report</a></li>	
				
			</ol>
			
			<br>
			<h2 style="font-family: 'Gruppo', cursive;color: #6699CC;">
			<fmt:message key="${requestScope.pageSubHeader3}" />
		</h2>
			<ol style="font-size: 12px;font-family: 'Gruppo', cursive; position:relative;
						left:30px;">
			<li  type=disc style="padding-top: 5px" ><a
						href="javascript:mobileAuditTrail();"  >System access & Data Transmission Report</a></li>
			
			<!--  <li  type=disc style="padding-top: 5px" ><a
						href="javascript:test();"  >To check jodaTime</a></li>-->
			
			
			</ol>
			
		
	</div>
</form>
<script >
function mobileAuditTrail() {
	var offset = new Date().getTimezoneOffset()
	document.forms[0].elements['timeoffset'].value=offset;
	document.forms[0].elements['actionParam'].value="search";
	
	document.forms[0].submit();
}


function test() {
	var offset = new Date().getTimezoneOffset()
	document.forms[0].elements['timeoffset'].value=offset;
	document.forms[0].action='test';
	document.forms[0].submit();	
}
</script>
</script>
<%@include file="common/footer.jsp"%>