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
<title>Consolidated Timesheets</title>
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
<script type="text/javascript" src="https://www.google.com/jsapi"></script>
<script type="text/javascript">
		// Load the Visualization API and the piechart package.
		google.load('visualization', '1', {packages:['table, charteditor,corechart']});
	    //google.setOnLoadCallback(drawTable);
		// Set a callback to run when the Google Visualization API is loaded.
		//google.setOnLoadCallback(drawChart);	
		google.setOnLoadCallback(drawVisualization);
		
	function selectLocation(_action) {
		document.forms[0].actionParam.value = _action;
		var index = document.forms[0].location.selectedIndex;
		document.forms[0].selectedLocation.value = document.forms[0].location.options[index].value;
		document.forms[0].submit();
	}

	function loadTimesheet(_action) {
		document.forms[0].actionParam.value = _action;
		var index = document.forms[0].location.selectedIndex;
		document.forms[0].selectedLocation.value = document.forms[0].location.options[index].value;
		index = document.forms[0].shift.selectedIndex;
		document.forms[0].selectedShift.value = document.forms[0].shift.options[index].value;
		document.forms[0].submit();
	}
	
	
<!-- Load Tables -->
	function drawVisualization() {
		  // Create and populate the data table.
		  var data = new google.visualization.DataTable();
		  //data.addColumn('number', '#');
		   data.addColumn('string', 'Employee-Id');
		  data.addColumn('string', 'Employee-Name');
		  for(i=1; i < 32; i++)
		  {
		  	data.addColumn('string', i );
		  }
		  		  
		  
		  var rowsAdded = false;
		  var k = 2;// This has to start from 1 as this for populating the effort column
		  alert(1);
		  <c:forEach var="item" items="${requestScope.dailyAttendanceRecord}">
		  alert(1.1);
		  	<c:set var="co" value="${item.value}"/>
		  	var j = 0;
			  <c:forEach var="e" items="${co.employeeList}">
			  alert(2);
			  		if(!rowsAdded){
			  			data.addRows(1);
				  		data.setCell(j, 0, '${e.companyEmpId}');			  			
				  	    data.setCell(j, 1,'${e.firstName} ${e.lastName}');			  			
					}
			 	 <c:forEach var="asg" items="${e.assignments}">
				  alert(3);
			 		var _tsheetFnd = false; 
			  		<c:forEach var="ts" items="${asg.timesheets}">
					  alert(4);
					  data.setCell(j, k,'${f:h(ts.secondsToHHMM)}');
					  _tsheetFnd = true;
			  		</c:forEach>//end-timesheet
			  		//Show Zero time if no timesheet is found
			  		if(!_tsheetFnd){
			  			data.setCell(j, k,'0');
			  		}
			  	</c:forEach>//end-assignment
			  	j++;
		  	</c:forEach>//end-emplyoee
		  	rowsAdded = true;
		  	k++;
		  </c:forEach>	//end-date array  
		  
			  
		  
		  // Create and draw the visualization.
		  var table = new google.visualization.Table(document.getElementById('timesheet'));
		  var colorFormat = new google.visualization.ColorFormat();
		  colorFormat.addRange(0, 7, 'red', 'white');
		  
		  for(q=2; q < 32; q++)
		  {
			  colorFormat.format(data, q);
		  }
		  table.draw(data, {allowHtml: true, 
			  showRowNumber: true, 
			  page:'enable', 
			  pageSize : 15, 
			  sortAscending:true, 
			  sortColumn:0},
			  {style: 'font-style:normal; font-size:8px;'});
	}
</script>


</head>
<body>

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

		<div id="content" style="height: 590px">
			<form name="showTimesheet" method="post">
				<input type="hidden" name="actionParam" value="loadReport" /> <input
					type="hidden" name="selectedLocation" value="" /> <input
					type="hidden" name="selectedShift" value="" />
				<fieldset title="fieldset1" class="reports_fieldset">
					<legend align="left" id="test">Timesheet</legend>

					<table width="99%" border="0">
						<tr>
							<th width="2.5%" scope="col">&nbsp;</th>
							<th width="16%" scope="col">&nbsp;</th>
							<th width="7%" scope="col">&nbsp;</th>
							<th width="16%" scope="col">&nbsp;</th>
							<th width="4%" scope="col">&nbsp;</th>
							<th width="16%" scope="col">&nbsp;</th>
							<th width="5%" scope="col">&nbsp;</th>
							<th width="15%" scope="col">&nbsp;</th>
							<th width="6%" scope="col">&nbsp;</th>
							<th width="12%" scope="col">&nbsp;</th>
						</tr>
						<tr>
							<td height="41"></td>
							<td></td>
							<td>Location</td>
							<td><select name="location" class="countrySelect"
								id="location" onChange="selectLocation('loadShiftForLocation')";>
									<option value="">Select a Location</option>
									<c:forEach var="e" items="${sessionScope.locationList}">
										<option ${f:select("location",f:h(e.key.id))}>${f:h(e.locationName)}</option>
									</c:forEach>
							</select></td>
							<td>Shift</td>
							<td><select name="shift" class="shiftSelect" id="shift"
								onChange="selectShift('loadTimeData')">
									<option value="">Select a Shift</option>
									<c:forEach var="e" items="${requestScope.shiftList}">
										<option ${f:select("shift",f:h(e.key.id))}>${f:h(e.shiftName)}</option>
									</c:forEach>
							</select></td>
							<td>Year</td>
							<td><select name="yearSelected" class="yearSelect">
									<option value="-1">Select Year</option>
									<option value="2011">2011</option>
									<option value="2012">2012</option>
									<option value="2013">2013</option>
							</select></td>
							<td>Month</td>
							<td><select name="monthSelected" class="monthSelect">
									<option value="-1">Select Month</option>
									<option value="0">Jan</option>
									<option value="1">Feb</option>
									<option value="2">Mar</option>
									<option value="3">Apr</option>
									<option value="4">May</option>
									<option value="5">June</option>
									<option value="6">July</option>
									<option value="7">Aug</option>
									<option value="8">Sept</option>
									<option value="9">Oct</option>
									<option value="10">Nov</option>
									<option value="11">Dec</option>
							</select></td>
						</tr>

					</table>
					<div align="right">
						<input type="button" value="Get Timesheet"
							onClick="loadTimesheet('loadTimeData')" /> <input type="reset"
							value="Reset" name="Reset" title="Reset" class="searchButtons">
						&nbsp;&nbsp;&nbsp;&nbsp;
					</div>
					<br /> <br />
					<div style="clear: both;">&nbsp;</div>

					<div style="clear: both;">&nbsp;</div>

					<div style="clear: both;"></div>
					<div width="870px">
						<table width="50%" height="10px">
							<tr>
								<td width="10%"></td>
								<td width="10%" style="background-color: red"></td>
								<td width="25%">Less Working Hrs</td>
								<td width="10%" style="background-color: #55FF55"></td>
								<td width="35%">Overtime</td>
							</tr>
						</table>
					</div>
					<div id='timesheet'></div>
					<!--  
					<div style="clear: both">&nbsp;</div>
					<table width="100%" border="1" class="timesheet_table"
						cellpadding="0" cellspacing="0">
						<tr style="background-color: white; border-color: black"
							align="center">
							<th width="2.5%" scope="col">#</th>
							<th width="12%" scope="col">Name</th>
							<th width="2.5%" scope="col">1</th>
							<th width="2.5%" scope="col">2</th>
							<th width="2.5%" scope="col">3</th>
							<th width="2.5%" scope="col">4</th>
							<th width="2.5%" scope="col">5</th>
							<th width="2.5%" scope="col">6</th>
							<th width="2.5%" scope="col"
								style="background-color: rgb(255, 191, 170)">7</th>
							<th width="2.5%" scope="col">8</th>
							<th width="2.5%" scope="col">9</th>
							<th width="2.5%" scope="col">10</th>
							<th width="2.5%" scope="col">11</th>
							<th width="2.5%" scope="col">12</th>
							<th width="2.5%" scope="col">13</th>
							<th width="2.5%" scope="col"
								style="background-color: rgb(255, 191, 170)">14</th>
							<th width="2.5%" scope="col">15</th>
							<th width="2.5%" scope="col">16</th>
							<th width="2.5%" scope="col">17</th>
							<th width="2.5%" scope="col">18</th>
							<th width="2.5%" scope="col">19</th>
							<th width="2.5%" scope="col">20</th>
							<th width="2.5%" scope="col"
								style="background-color: rgb(255, 191, 170)">21</th>
							<th width="2.5%" scope="col">22</th>
							<th width="2.5%" scope="col">23</th>
							<th width="2.5%" scope="col">24</th>
							<th width="2.5%" scope="col">25</th>
							<th width="2.5%" scope="col">26</th>
							<th width="2.5%" scope="col">27</th>
							<th width="2.5%" scope="col"
								style="background-color: rgb(255, 191, 170)">28</th>
							<th width="2.5%" scope="col">29</th>
							<th width="2.5%" scope="col">30</th>
							<th width="2.5%" scope="col">31</th>
							<th width="8%" scope="col">Total</th>
						</tr>
						<tr style="background-color: white" align="center">
							<td>1</td>
							<td>xxxxx1</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td style="background-color: red">6</td>
							<td style="background-color: rgb(255, 191, 170)">0</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td style="background-color: rgb(255, 191, 170)">0</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td style="background-color: rgb(255, 191, 170)">0</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td style="background-color: rgb(255, 191, 170)">0</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>214</td>
						</tr>
						<tr style="background-color: white" align="center">
							<td>2</td>
							<td>xxxxx2</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td style="background-color: rgb(255, 191, 170)">0</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td style="background-color: red">7.3</td>
							<td>8</td>
							<td style="background-color: rgb(255, 191, 170)">0</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td style="background-color: #55FF55">8.5</td>
							<td style="background-color: rgb(255, 191, 170)">0</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td style="background-color: rgb(255, 191, 170)">0</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>215.5</td>
						</tr>
						<tr style="background-color: white" align="center">
							<td>3</td>
							<td>xxxxx3</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td style="background-color: rgb(255, 191, 170)">0</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td style="background-color: rgb(255, 191, 170)">0</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td style="background-color: rgb(255, 191, 170)">0</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td style="background-color: red">0</td>
							<td>8</td>
							<td>8</td>
							<td style="background-color: rgb(255, 191, 170)">0</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>208</td>
						</tr>
						<tr style="background-color: white" align="center">
							<td>4</td>
							<td>xxxxx4</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td style="background-color: rgb(255, 191, 170)">0</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td style="background-color: rgb(255, 191, 170)">0</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td style="background-color: rgb(255, 191, 170)">0</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td style="background-color: rgb(255, 191, 170)">0</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>216</td>
						</tr>
						<tr style="background-color: white" align="center">
							<td>5</td>
							<td>xxxxx5</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td style="background-color: rgb(255, 191, 170)">0</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td style="background-color: rgb(255, 191, 170)">0</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td style="background-color: #55FF55">9</td>
							<td style="background-color: #55FF55">10</td>
							<td style="background-color: rgb(255, 191, 170)">0</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td style="background-color: rgb(255, 191, 170)">0</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>219</td>
						</tr>
						<tr style="background-color: white" align="center">
							<td>6</td>
							<td>xxxxx6</td>
							<td>8</td>
							<td>8</td>
							<td style="background-color: red">4</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td style="background-color: rgb(255, 191, 170)">0</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td style="background-color: rgb(255, 191, 170)">0</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td style="background-color: rgb(255, 191, 170)">0</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td style="background-color: rgb(255, 191, 170)">0</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>212</td>
						</tr>
						<tr style="background-color: white" align="center">
							<td>7</td>
							<td>xxxxx7</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td style="background-color: #55FF55">11</td>
							<td>8</td>
							<td style="background-color: rgb(255, 191, 170)">0</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td style="background-color: rgb(255, 191, 170)">0</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td style="background-color: rgb(255, 191, 170)">0</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td style="background-color: rgb(255, 191, 170)">0</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>218</td>
						</tr>
						<tr style="background-color: white" align="center">
							<td>8</td>
							<td>xxxxx8</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td style="background-color: rgb(255, 191, 170)">0</td>
							<td>8</td>
							<td>8</td>
							<td style="background-color: #55FF55">12</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td style="background-color: rgb(255, 191, 170)">0</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td style="background-color: rgb(255, 191, 170)">0</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td style="background-color: rgb(255, 191, 170)">0</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>219</td>
						</tr>
						<tr style="background-color: white" align="center">
							<td>9</td>
							<td>xxxxx9</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td style="background-color: rgb(255, 191, 170)">0</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td style="background-color: rgb(255, 191, 170)">0</td>
							<td>8</td>
							<td style="background-color: red">6</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td style="background-color: rgb(255, 191, 170)">0</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td style="background-color: rgb(255, 191, 170)">0</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>214</td>
						</tr>
						<tr style="background-color: white" align="center">
							<td>10</td>
							<td>xxxxx10</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td style="background-color: rgb(255, 191, 170)">0</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td style="background-color: rgb(255, 191, 170)">0</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td style="background-color: rgb(255, 191, 170)">0</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td style="background-color: #55FF55">11</td>
							<td>8</td>
							<td>8</td>
							<td style="background-color: rgb(255, 191, 170)">0</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>218</td>
						</tr>

						<tr style="background-color: white" align="center">
							<td>11</td>
							<td>xxxxx11</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td style="background-color: red">6</td>
							<td style="background-color: rgb(255, 191, 170)">0</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td style="background-color: rgb(255, 191, 170)">0</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td style="background-color: rgb(255, 191, 170)">0</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td style="background-color: rgb(255, 191, 170)">0</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>214</td>
						</tr>
						<tr style="background-color: white" align="center">
							<td>12</td>
							<td>xxxxx12</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td style="background-color: rgb(255, 191, 170)">0</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td style="background-color: red">7.3</td>
							<td>8</td>
							<td style="background-color: rgb(255, 191, 170)">0</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td style="background-color: #55FF55">8.5</td>
							<td style="background-color: rgb(255, 191, 170)">0</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td style="background-color: rgb(255, 191, 170)">0</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>215.5</td>
						</tr>
						<tr style="background-color: white" align="center">
							<td>13</td>
							<td>xxxxx13</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td style="background-color: rgb(255, 191, 170)">0</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td style="background-color: rgb(255, 191, 170)">0</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td style="background-color: rgb(255, 191, 170)">0</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td style="background-color: red">0</td>
							<td>8</td>
							<td>8</td>
							<td style="background-color: rgb(255, 191, 170)">0</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>208</td>
						</tr>
						<tr style="background-color: white" align="center">
							<td>14</td>
							<td>xxxxx14</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td style="background-color: rgb(255, 191, 170)">0</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td style="background-color: rgb(255, 191, 170)">0</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td style="background-color: rgb(255, 191, 170)">0</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td style="background-color: rgb(255, 191, 170)">0</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>216</td>
						</tr>
						<tr style="background-color: white" align="center">
							<td>15</td>
							<td>xxxxx15</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td style="background-color: rgb(255, 191, 170)">0</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td style="background-color: rgb(255, 191, 170)">0</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td style="background-color: #55FF55">9</td>
							<td style="background-color: #55FF55">10</td>
							<td style="background-color: rgb(255, 191, 170)">0</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td style="background-color: rgb(255, 191, 170)">0</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>219</td>
						</tr>
						<tr style="background-color: white" align="center">
							<td>16</td>
							<td>xxxxx16</td>
							<td>8</td>
							<td>8</td>
							<td style="background-color: red">4</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td style="background-color: rgb(255, 191, 170)">0</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td style="background-color: rgb(255, 191, 170)">0</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td style="background-color: rgb(255, 191, 170)">0</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td style="background-color: rgb(255, 191, 170)">0</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>212</td>
						</tr>
						<tr style="background-color: white" align="center">
							<td>17</td>
							<td>xxxxx17</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td style="background-color: #55FF55">11</td>
							<td>8</td>
							<td style="background-color: rgb(255, 191, 170)">0</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td style="background-color: rgb(255, 191, 170)">0</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td style="background-color: rgb(255, 191, 170)">0</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td style="background-color: rgb(255, 191, 170)">0</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>218</td>
						</tr>
						<tr style="background-color: white" align="center">
							<td>18</td>
							<td>xxxxx18</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td style="background-color: rgb(255, 191, 170)">0</td>
							<td>8</td>
							<td>8</td>
							<td style="background-color: #55FF55">12</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td style="background-color: rgb(255, 191, 170)">0</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td style="background-color: rgb(255, 191, 170)">0</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td style="background-color: rgb(255, 191, 170)">0</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>219</td>
						</tr>
						<tr style="background-color: white" align="center">
							<td>19</td>
							<td>xxxxx19</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td style="background-color: rgb(255, 191, 170)">0</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td style="background-color: rgb(255, 191, 170)">0</td>
							<td>8</td>
							<td style="background-color: red">6</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td style="background-color: rgb(255, 191, 170)">0</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td style="background-color: rgb(255, 191, 170)">0</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>214</td>
						</tr>
						<tr style="background-color: white" align="center">
							<td>20</td>
							<td>xxxxx20</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td style="background-color: rgb(255, 191, 170)">0</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td style="background-color: rgb(255, 191, 170)">0</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td style="background-color: rgb(255, 191, 170)">0</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td style="background-color: #55FF55">11</td>
							<td>8</td>
							<td>8</td>
							<td style="background-color: rgb(255, 191, 170)">0</td>
							<td>8</td>
							<td>8</td>
							<td>8</td>
							<td>218</td>
						</tr>
					</table>
					-->
				</fieldset>

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
