<%@include file="common/common.jsp"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.Import"%>
<%@page pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>
<%@ page import="java.util.Date"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="Keywords" content="">
<meta name="Description" content="">
<title>Timesheet Reports</title>
<link href="styles/style.css?updated=<%=new Date()%>" rel="stylesheet"
	type="text/css">
<link href="styles/demo_table.css" rel="stylesheet" type="text/css">
<link href="styles/jqueryui/jquery.ui.all.css" rel="stylesheet"
	type="text/css">
<script type="text/javascript"
	src="scripts/jquery-1.6.2.js?updated=<%=new Date()%>"></script>
<script type="text/javascript"
	src="scripts/jquery.dataTables.js?updated=<%=new Date()%>"></script>
<script type="text/javascript"
	src="scripts/jquery-ui-1.8.16.custom.js?updated=<%=new Date()%>"></script>
<script type="text/javascript"
	src="scripts/date.js?updated=<%=new Date()%>"></script>
<!-- ****************************************************************  -->

<script type="text/javascript">

function selectLocation(_action) 
	{
		document.showDailyReport.actionParam.value = _action;
		var index = document.forms[0].location.selectedIndex;
		document.showDailyReport.selectedLocation.value = document.forms[0].location.options[index].value;
		document.showDailyReport.submit();
	}
	

function loadTimesheet(_action) 
{
	document.showDailyReport.actionParam.value = _action;
	var index = document.forms[0].location.selectedIndex;
	document.showDailyReport.selectedLocation.value = document.forms[0].location.options[index].value;
	index = document.forms[0].shift.selectedIndex;
	document.showDailyReport.selectedShift.value = document.forms[0].shift.options[index].value;
	document.showDailyReport.submit();
}
	
	
</script>

<!--Load the AJAX API-->
<script type="text/javascript" src="https://www.google.com/jsapi"></script>
<script type="text/javascript">
	google.load('visualization', '1', {packages:['table, charteditor,corechart']});
    //google.setOnLoadCallback(drawTable);
	// Set a callback to run when the Google Visualization API is loaded.
	//google.setOnLoadCallback(drawChart);	
	google.setOnLoadCallback(drawVisualization);

	

<!-- Load Tables -->
	
	
		function drawVisualization() {
		  // Create and populate the data table.
		  var data = new google.visualization.DataTable();
		  data.addColumn('string', 'Date');
		  data.addColumn('string', 'Employee Name');
		  data.addColumn('string', 'Location'); 
		  data.addColumn('string', 'Shift'); 		  
		  data.addColumn('string', 'In Time'); 
		  data.addColumn('string', 'Out Time'); 
		  data.addColumn('number', 'Min Effort');
		  data.addColumn('string', 'Effort Clocked');
		  data.addColumn('boolean', 'Attendance Closed');
		  //data.addColumn('number', 'Diff in Effort'); 
		  //data.addColumn('number', 'Variance');	
		  var i =0;
		  
			  
		  <c:forEach var="item" items="${requestScope.dailyAttendanceRecord}">
		  	<c:set var="co" value="${item.value}"/>
			  <c:forEach var="e" items="${co.employeeList}">
			  		data.addRows(1);
			  		data.setCell(i, 0,"${item.key}");
			  	    data.setCell(i, 1,'${e.firstName} ${e.lastName}');
			 	 <c:forEach var="asg" items="${e.assignments}">
			 		var _tsheetFnd = false; 
			 		data.setCell(i, 2,'${asg.shiftRef.model.locationRef.model.locationName}');
			 		data.setCell(i, 3,'${asg.shiftRef.model.shiftName}');
			 		var _asgRowCount = 0;
			  		<c:forEach var="ts" items="${asg.timesheets}">
			  		  _tsheetFnd = true;
			  		  if(_asgRowCount > 0){
			  		  	data.addRows(1);
			  		  }
			  		  data.setCell(i, 0,"${item.key}");
			  		  data.setCell(i, 1,'${e.firstName} ${e.lastName}');
				 	  data.setCell(i, 2,'${asg.shiftRef.model.locationRef.model.locationName}');
				 	  //data.setCell(i, 2,${ts.key.id});
				 	  data.setCell(i, 3,'${asg.shiftRef.model.shiftName}');					  			  		  
					  data.setCell(i, 4,'${f:h(ts.inDateTime)}');
					  data.setCell(i, 5,'${f:h(ts.outDateTime)}');	
					  data.setCell(i, 6,${f:h(e.minWorkingHrsPerDay)});
					  data.setCell(i, 7,'${f:h(ts.secondsToHHMM)}');
					  data.setCell(i,8,false);
					  <c:if test="${(ts.inDateTime != null)  && (ts.outDateTime != null)}">
					  	data.setCell(i,8,true);
					  </c:if>					  
			  		  _asgRowCount++;					  
			  		  i++;
			  		</c:forEach>
			  		
			  		if(_tsheetFnd == false){
			  			data.setCell(i, 4,'-');
						data.setCell(i, 5,'-');
						data.setCell(i, 6,${f:h(e.minWorkingHrsPerDay)});
						data.setCell(i, 7,'-');
						data.setCell(i,8,false);
			  			i++;
					}
			  		
			  	</c:forEach>
		  	</c:forEach>
		  </c:forEach>

		  // Create and draw the visualization.
		  var table = new google.visualization.Table(document.getElementById('visualization'));
		  var colorFormat = new google.visualization.ColorFormat();

		  //var formatter = new google.visualization.TableArrowFormat();
		  //formatter.format(data, 9); // Apply formatter to second column
		  colorFormat.addRange(1, 9, 'green', 'white');
		  colorFormat.format(data, 6);
		  table.draw(data, {allowHtml: true, showRowNumber: true, page:'enable', pageSize : 15, sortAscending:true, sortColumn:0});
		  }	
	<!-- Load Gauges -->
	
	
	
	
</script>
</head>
<body>
	<form name="showDailyReport" method="post">
		<!-- start header -->
		<div style="width: 100%">
			<div id="header">
				<div id="logo">
					<h1></h1>
				</div>
				<%--@include file="menu.jsp" --%>
				<div id="menu">
					<ul>
						<li><a href="${f:url('home')}">Home</a></li>
						<li><a href="${f:url('addLocation')}">Add Location</a></li>
						<li><a href="${f:url('addShift')}">Add Shift</a></li>
						<li><a href="${f:url('addEmployee')}">Add Employee</a></li>
						<li><a href="${f:url('assignment')}">Assignment</a></li>
						<li><a href="${f:url('reports')}">Reports</a></li>
						<li><a href="${f:url('timesheetIndex')}">Timesheet</a></li>
						<li><a href="${f:url('rechargeIndex')}">Charge your
								account</a></li>
						<li><a href="${f:url('logout')}">Logout</a></li>
					</ul>
				</div>
			</div>
		</div>
		<!-- start page -->
		<div style="clear: both;">&nbsp;</div>
		<div id="page">
			<!-- start content -->

			<div id="content" style="height: 520px">
				<input type="hidden" name="actionParam" value="loadReport" /> <input
					type="hidden" name="selectedLocation" value="" /> <input
					type="hidden" name="selectedShift" value="" />

				<!--  
				<fieldset title="fieldset1" class="reports_fieldset">
					<legend align="left" id="test">Report Parameters</legend>	
-->
				<table width="100%" border="1">
					<tr height="100%">
						<td width='15%'>From Date</td>
						<td width='15%'><input type="text" name="startDate" size="12"
							value="${requestScope.startDate}" readonly="readonly"
							id="startdatepicker" class="dateField"></td>
						<td width='15%'>To Date</td>
						<td width='15%'><input type="text" name="toDate" size="12"
							value="${requestScope.toDate}" readonly="readonly"
							id="todatepicker" class="dateField"></td>
						<td width='10%'>Location</td>
						<td align="left" width='15%'><select name="location"
							class="countrySelect" id="location"
							onChange="selectLocation('loadShiftForLocation')";>
								<option value="">Select a Location</option>
								<c:forEach var="e" items="${sessionScope.locationList}">
									<option ${f:select("location",f:h(e.key.id))}>${f:h(e.locationName)}</option>
								</c:forEach>
						</select></td>
						<td align="left" width='15%'><select name="shift"
							class="shiftSelect" id="shift"
							onChange="selectShift('loadTimeData')">
								<option value="">Select a Shift</option>
								<c:forEach var="e" items="${requestScope.shiftList}">
									<option ${f:select("shift",f:h(e.key.id))}>${f:h(e.shiftName)}</option>
								</c:forEach>
						</select></td>
					</tr>
					<tr>
						<td colspan='2'></td>
						<td colspan='3'>Show daily consolidated <input
							type="checkbox" name="dailyConsolidated" /></td>
						<td><input type="button" value="Get Timesheet"
							onClick="loadTimesheet('loadTimeData')" /></td>
					</tr>
				</table>
				<!--  

				</fieldset>
-->
				<br />

				<!--Div that will hold the pie chart-->
				<div id="chart_div"></div>
				<div id="table_div"></div>
				<div id="gauge_div"></div>
				<div id="visualization"></div>
				<div id="colorformat_div"></div>
	</form>

	</div>
	<!-- end content -->

	</div>
	<!-- end page -->
	<!-- start footer -->
	<!-- end footer -->
	<div style="clear: both;">&nbsp;</div>

	<%@include file="common/footerWithMenu.jsp"%>
</body>

</html>
<script>
$(function() {
	$( "#startdatepicker" ).datepicker({
		showOn: "button",
		buttonImage: "images/calendar.gif",
		buttonImageOnly: true
	});
});

$(function() {
	$( "#todatepicker" ).datepicker({
		showOn: "button",
		buttonImage: "images/calendar.gif",
		buttonImageOnly: true
	});
});



</script>