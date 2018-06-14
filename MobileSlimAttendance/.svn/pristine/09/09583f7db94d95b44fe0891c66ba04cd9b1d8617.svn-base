<%@include file="common/common.jsp"%>
<%@include file="common/header.jsp"%>
<!-- start header -->
<script type="text/javascript"
	src="scripts/jquery-1.6.2.js?updated=<%=new Date()%>"></script>
<script type="text/javascript"
	src="scripts/jquery.dataTables.js?updated=<%=new Date()%>"></script>
<script type="text/javascript"
	src="scripts/jquery-ui-1.8.16.custom.js?updated=<%=new Date()%>"></script>
<script type="text/javascript"
	src="scripts/date.js?updated=<%=new Date()%>"></script>

<script type="text/javascript" src="https://www.google.com/jsapi"></script>
<script type="text/javascript">
var csvStr='';
var sNewline = navigator.userAgent.match(/Windows/) ? "\r\n" : "\n";
	google.load('visualization', '1', {packages:['table, charteditor,corechart']});
  	google.setOnLoadCallback(drawVisualization);
<!-- Load Tables -->
		function drawVisualization() {
		  // Create and populate the data table.
		  var data = new google.visualization.DataTable();
		  data.addColumn('string', 'Employee Id');//0
		  data.addColumn('string', 'Employee Name');//1
		  data.addColumn('string', 'Location'); //2
		  data.addColumn('string', 'Shift');//3
		  data.addColumn('string', 'Date');//4 
		  data.addColumn('string', 'In Time');//5 
		  data.addColumn('string', 'Out Time');//6 
		  data.addColumn('string', 'Total Effort');//7
		  data.addColumn('string', 'Net Effort');//8
		  data.addColumn('string', 'Over Time');//9
		  data.addColumn('string', 'In Time Result');//10
		  data.addColumn('string', 'Out Time Result');//11
		  data.addColumn('string', 'Effort');//12
		  data.addColumn('string', 'Action');//13
		  data.addColumn('string', 'Is Approved')//14
		  //  data.addColumn('string', 'Day');//15
		  
		  csvStr= csvStr +'Employee Id,Employee Name,Location,Shift,Date,In Time,Out Time,Total Effort,'
		  csvStr=csvStr+'Net Effort,Over Time,In Time Result,Out Time Result,Effort,Action,Is Approved'//,Day';
		  csvStr= csvStr +sNewline;
		  var i =0;
		  
		 <c:forEach var="item" items="${requestScope.dailyAttendanceRecord}">
		            data.addRows(1);
		            //document.getElementById("timeseetId_div").innerHTML=document.getElementById("timeseetId_div").innerHTML+'<input type="hidden" name="timesheetId" value=${item.timesheetId} >';
			  		data.setCell(i, 0,"${item.companyEmpId}");
			  	    data.setCell(i, 1,"${item.employeeName}");
			 		data.setCell(i, 2,'${item.locationName}');
			 		data.setCell(i, 3,'${item.shiftName}');
			 		data.setCell(i, 4,'${item.createdDate}');
			 		data.setCell(i, 5,"${item.inTimeDayOfWeek}","${item.inTime}");
			  		data.setCell(i, 6,"${item.outTimeDayOfWeek}","${item.outTime}");
				 	data.setCell(i, 7,"${item.dailyEffort}");
    			 	data.setCell(i, 8,"${item.actualEffort}");
    			 	data.setCell(i, 9,"${item.overTime}");
    			 	
    			 	
    			 	  csvStr= csvStr + "${item.companyEmpId}" +",";
    			  	  csvStr= csvStr + "${item.employeeName}"+"," ; 
    			  	  csvStr= csvStr + "${item.locationName}"+",";
    			  	  csvStr= csvStr + "${item.shiftName}"+",";
    			  	  csvStr= csvStr + "${item.createdDate}"+",";
    			  	  csvStr= csvStr + "${item.inTime}"+",";
    			  	  csvStr= csvStr + "${item.outTime}"+",";
    			  	  csvStr= csvStr + "${item.dailyEffort}"+",";
    			  	  csvStr= csvStr + "${item.actualEffort}"+",";
    			  	  csvStr= csvStr + "${item.overTime}"+",";
    			  	  
    			 	
    			 	
    			 	if('${item.inTimeResult}' == 1){
    			 		data.setCell(i, 10,'${item.inTimeResult}', 'Right IN');
    			 		  csvStr= csvStr + 'Right IN'+",";
    			 	} else if('${item.inTimeResult}' == 2){
    			 		data.setCell(i, 10,'${item.inTimeResult}', 'Early IN');
    			 		 csvStr= csvStr + 'Early IN'+",";
    			 	} else if('${item.inTimeResult}' == 3){
    			 		data.setCell(i, 10,'${item.inTimeResult}', 'Late IN');
    			 		csvStr= csvStr + 'Late IN'+",";
    			 	} else {
    			 		data.setCell(i, 10,'${item.inTimeResult}', '-');
    			 		csvStr= csvStr + '-'+",";
    			 	}
    			 	
					//data.setCell(i, 9,'${item.inTimeResult}');
					
    			 	if('${item.outTimeResult}' == 1){
    			 		data.setCell(i, 11,'${item.outTimeResult}', 'Right OUT');
    			 		csvStr= csvStr + 'Right OUT'+",";
    			 	} else if('${item.outTimeResult}' == 2){
    			 		data.setCell(i, 11,'${item.outTimeResult}', 'Early OUT');
    			 		csvStr= csvStr + 'Early OUT'+",";
    			 	} else if('${item.outTimeResult}' == 3){
    			 		data.setCell(i, 11,'${item.outTimeResult}', 'Late OUT');
    			 		csvStr= csvStr + 'Late OUT'+",";
    			 	} else {
    			 		data.setCell(i, 11,'${item.outTimeResult}', '-');
    			 		csvStr= csvStr + '-'+",";
    			 	}   			 	
					//data.setCell(i, 10,'${item.outTimeResult}');
					
					if('${item.effortResult}' == 1){
    			 		data.setCell(i, 12,'${item.effortResult}', 'Right Effort');
    			 		csvStr= csvStr + 'Right Effort'+",";
    			 	}
    			 	else if('${item.effortResult}' == 2){
    			 		data.setCell(i, 12,'${item.effortResult}', 'Less Effort');
    			 		csvStr= csvStr + 'Less Effort'+",";
    			 	}
    			 	else if('${item.effortResult}' == 3){
    			 		data.setCell(i, 12,'${item.effortResult}', 'Over Time');
    			 		csvStr= csvStr + 'Over Time'+",";
    			 	}
    			 	else if('${item.effortResult}' == 4){
    			 		data.setCell(i, 12,'${item.effortResult}', 'Half Day');
    			 		csvStr= csvStr + 'Half Day'+",";
    			 	}
    			 	else if('${item.effortResult}' == 5){
    			 		data.setCell(i, 12,'${item.effortResult}', 'Unpaid Leave');
    			 		csvStr= csvStr + 'Leave'+",";
    			 	}   
    			 	else if('${item.effortResult}' == 6){
    			 		data.setCell(i, 12,'${item.effortResult}', 'Unresolved');
    			 		csvStr= csvStr + 'Unresolved'+",";
    			 	} 
    			 	else if('${item.effortResult}' == 7){
    			 		data.setCell(i, 12,'${item.effortResult}', 'Not Reported');
    			 		csvStr= csvStr + 'Not Reported'+",";
    			 	} 
    			 	else if('${item.effortResult}' == 9){
    			 		data.setCell(i, 12,'${item.effortResult}', 'No Out Time');
    			 		csvStr= csvStr + 'No Out Time'+",";
    			 	}else if('${item.effortResult}' == 11){
    			 		data.setCell(i, 12,'${item.effortResult}', 'Paid Leave');
    			 		csvStr= csvStr + 'Leave'+",";
    			 	}  else if('${item.effortResult}' == 12){
    			 		data.setCell(i, 12,'${item.effortResult}', 'Comp-Off');
    			 		csvStr= csvStr + 'Leave'+",";
    			 	}  else if('${item.effortResult}' == 13){
    			 		data.setCell(i, 12,'${item.effortResult}', 'Casual Leave');
    			 		csvStr= csvStr + 'Leave'+",";
    			 	} else if('${item.effortResult}' == 14){
    			 		data.setCell(i, 12,'${item.effortResult}', 'Weekly Off');
    			 		csvStr= csvStr + 'Leave'+",";
    			 	} else if('${item.effortResult}' == 15){
    			 		data.setCell(i, 12,'${item.effortResult}', 'Location Holiday');
    			 		csvStr= csvStr + 'Leave'+",";
    			 	} else {
    			 		data.setCell(i, 12,'${item.effortResult}', '-');
    			 		csvStr= csvStr + '-'+",";
    			 	}
    			 	
					
					//data.setCell(i, 11,'${item.effortResult}');
					<c:if test="${item.approved == null || item.approved=='N'}">
					
					if(${item.weeklyOff == true}){
						data.setCell(i, 13,'<select name="billableEffort" style="width:80px;height=25px;" id='+'${item.timesheetId}><option value="1" >Full Day</option><option value="4" >Half Day</option><option value="3">Over Time</option><option value="5">Unpaid Leave</option><option value="11">Paid Leave</option><option value="12">Comp-Off</option><option value="13">Casual Leave</option><option value="14" selected>Weekly Off</option><option value="15">Location Holiday</option><option value="6">Unresolved</option></select>');
						csvStr= csvStr + 'Weekly Off'+",";
					}else if(${item.holiday == true}){
						data.setCell(i, 13,'<select name="billableEffort" style="width:80px;height=25px;" id='+'${item.timesheetId}><option value="1" >Full Day</option><option value="4" >Half Day</option><option value="3">Over Time</option><option value="5">Unpaid Leave</option><option value="11">Paid Leave</option><option value="12">Comp-Off</option><option value="13">Casual Leave</option><option value="14">Weekly Off</option><option value="15" selected>Location Holiday</option><option value="6">Unresolved</option></select>');
						csvStr= csvStr + 'Location Holiday'+",";
					}else if('${item.effortResult}' == 1){
						data.setCell(i, 13,'<select name="billableEffort" style="width:80px;height=25px;" id='+'${item.timesheetId}><option value="1" selected>Full Day</option><option value="4" >Half Day</option><option value="3">Over Time</option><option value="5">Unpaid Leave</option><option value="11">Paid Leave</option><option value="12">Comp-Off</option><option value="13">Casual Leave</option><option value="14">Weekly Off</option><option value="15">Location Holiday</option><option value="6">Unresolved</option></select>');
						csvStr= csvStr + 'Full Day'+",";	
					} else if('${item.effortResult}' == 2){
					data.setCell(i, 13,'<select name="billableEffort" style="width:80px;height=25px;" id='+'${item.timesheetId}><option value="1">Full Day</option><option value="4" >Half Day</option><option value="3" selected>Over Time</option><option value="5">Unpaid Leave</option><option value="11">Paid Leave</option><option value="12">Comp-Off</option><option value="13">Casual Leave</option><option value="14">Weekly Off</option><option value="15">Location Holiday</option><option value="6">Unresolved</option></select>');
					csvStr= csvStr + 'Half Day'+",";
					} else if('${item.effortResult}' == 3){
					data.setCell(i, 13,'<select name="billableEffort" style="width:80px;height=25px;" id='+'${item.timesheetId}><option value="1">Full Day</option><option value="4" >Half Day</option><option value="3" selected>Over Time</option><option value="5">Unpaid Leave</option><option value="11">Paid Leave</option><option value="12">Comp-Off</option><option value="13">Casual Leave</option><option value="14">Weekly Off</option><option value="15">Location Holiday</option><option value="6">Unresolved</option></select>');
					csvStr= csvStr + 'Over Time'+",";
					} else if('${item.effortResult}' == 4){
					data.setCell(i, 13,'<select name="billableEffort" style="width:80px;height=25px;" id='+'${item.timesheetId}><option value="1">Full Day</option><option value="4" selected>Half Day</option><option value="3">Over Time</option><option value="5">Unpaid Leave</option><option value="11">Paid Leave</option><option value="12">Comp-Off</option><option value="13">Casual Leave</option><option value="14">Weekly Off</option><option value="15">Location Holiday</option><option value="6" >Unresolved</option></select>');
					csvStr= csvStr + 'Half Day'+",";
					} else if('${item.effortResult}' == 6){
					data.setCell(i, 13,'<select name="billableEffort" style="width:80px;height=25px;" id='+'${item.timesheetId}><option value="1">Full Day</option><option value="4">Half Day</option><option value="3">Over Time</option><option value="5">Unpaid Leave</option><option value="11">Paid Leave</option><option value="12">Comp-Off</option><option value="13">Casual Leave</option><option value="14">Weekly Off</option><option value="15">Location Holiday</option><option value="6" selected>Unresolved</option></select>');
					csvStr= csvStr + 'Unresolved'+",";
					} else if('${item.effortResult}' == 5 || '${item.effortResult}' == 7 || '${item.effortResult}' == 9){
						data.setCell(i, 13,'<select name="billableEffort" style="width:80px;height=25px;" id='+'${item.timesheetId}><option value="1">Full Day</option><option value="4" >Half Day</option><option value="3">Over Time</option><option value="5" selected>Unpaid Leave</option><option value="11">Paid Leave</option><option value="12">Comp-Off</option><option value="13">Casual Leave</option><option value="14">Weekly Off</option><option value="15">Location Holiday</option<option value="6">Unresolved</option>></select>');
						csvStr= csvStr + 'Unpaid Leave'+",";
					} else if('${item.effortResult}' == 11 ){
						data.setCell(i, 13,'<select name="billableEffort" style="width:80px;height=25px;" id='+'${item.timesheetId}><option value="1">Full Day</option><option value="4" >Half Day</option><option value="3">Over Time</option><option value="5">Unpaid Leave</option><option value="11" selected>Paid Leave</option><option value="12">Comp-Off</option><option value="13">Casual Leave</option><option value="14">Weekly Off</option><option value="15">Location Holiday</option><option value="6">Unresolved</option></select>');
						csvStr= csvStr + 'Paid Leave'+",";
					} else if('${item.effortResult}' == 12 ){
						data.setCell(i, 13,'<select name="billableEffort" style="width:80px;height=25px;" id='+'${item.timesheetId}><option value="1">Full Day</option><option value="4" >Half Day</option><option value="3">Over Time</option><option value="5">Unpaid Leave</option><option value="11">Paid Leave</option><option value="12" selected>Comp-Off</option><option value="13">Casual Leave</option><option value="14">Weekly Off</option><option value="15">Location Holiday</option><option value="6">Unresolved</option></select>');
						csvStr= csvStr + 'Comp-Off'+",";
					} else if('${item.effortResult}' == 13 ){
						data.setCell(i, 13,'<select name="billableEffort" style="width:80px;height=25px;" id='+'${item.timesheetId}><option value="1">Full Day</option><option value="4" >Half Day</option><option value="3">Over Time</option><option value="5">Unpaid Leave</option><option value="11">Paid Leave</option><option value="12">Comp-Off</option><option value="13" selected>Casual Leave</option><option value="14">Weekly Off</option><option value="15">Location Holiday</option></select>');
						csvStr= csvStr + 'Casual Leave'+",";
					} else {
						data.setCell(i, 13,'-');
						csvStr= csvStr + '-'+",";
					}
					data.setCell(i, 14,'Pending');
					csvStr= csvStr + 'Pending'+",";
					</c:if>
                   <c:if test="${item.approved=='Y'}">
                       data.setCell(i, 13,'${item.approvalResult}');
                       csvStr= csvStr + '${item.approvalResult}'+",";
                       data.setCell(i, 14,'Approved');
                       csvStr= csvStr + 'Approved'+",";
					</c:if>
					
				//	var _flag = ${item.holiday};
				//	data.setCell(i, 14,'${item.holidayDesc}');
					
				//	csvStr= csvStr + '${item.holidayDesc}';
					 csvStr+=sNewline;
					i++;
		  </c:forEach>
		  // Create and draw the visualization.
		  var table = new google.visualization.Table(document.getElementById('visualization'));
		  var IN_colorFormat = new google.visualization.ColorFormat();

		  IN_colorFormat.addRange(1, 3, 'green', 'none');
		  IN_colorFormat.addRange(3, null, 'red', 'none');
		  IN_colorFormat.format(data, 10);
		  
		  
		  var OUT_colorFormat = new google.visualization.ColorFormat();

		  OUT_colorFormat.addRange(0, 2, 'green', 'none');
		  OUT_colorFormat.addRange(3, null, 'green', 'none');
		  OUT_colorFormat.addRange(2, null, 'red', 'none');
		  OUT_colorFormat.format(data, 11);
		  
		  var Result_colorFormat = new google.visualization.ColorFormat();

		  Result_colorFormat.addRange(0, 1, 'green', 'none');
		  Result_colorFormat.addRange(2, null, 'red', 'none');
		  Result_colorFormat.addRange(3, null, 'white', 'none');
		  Result_colorFormat.addRange(4, 5, 'orange', 'none');
		  Result_colorFormat.addRange(5, null, 'white', 'none');
		  Result_colorFormat.addRange(6, null, 'gray', 'none');
		  Result_colorFormat.format(data, 9);
		  
		  var dayOfWeek_colorFormat = new google.visualization.ColorFormat();
		  dayOfWeek_colorFormat.addRange("Sat","Sun",'gray','#EDDA74');
		  dayOfWeek_colorFormat.format(data,5);
		  dayOfWeek_colorFormat.format(data,6);
		  
		  table.draw(data, {allowHtml: true, showRowNumber: true, page:'enable', pageSize : 35, sortAscending:true, sortColumn:0,width:80});
		  document.getElementById("csvString").value="Consolidated Timesheet Report" +sNewline +csvStr;
		  }	
</script>
<script type="text/javascript">

$(document).ready(function(){
	 
	if(${requestScope.startDate!=null} && ${requestScope.startDate!=""})
	{
		document.forms[0].elements["month"].disabled=true;
		document.forms[0].elements["employeeId"].disabled=true;
	}
	else
	{
		document.forms[0].elements["month"].disabled=false;
		document.forms[0].elements["employeeId"].disabled=false;
	}	
	if(${requestScope.month!=null} &&${requestScope.month!=""})
	{
		document.forms[0].elements["startDate"].disabled=true;
	}
	else
	{
		document.forms[0].elements["startDate"].disabled=false;
	}	
	
});


</script>
</head>

<%@include file="common/timesheetPageUpper.jsp"%>
<body>
	<form action="consolidatedTimesheetReport" method="post">
		<input type="hidden" name="actionParam" value="search"> 
		<input type="hidden" name="csvString" id="csvString">
		<input type="hidden" name="reportFileName" value="Consolidated_Timesheet_Report.csv">
		<input
			type="hidden" name="timeSheetIds">
		<table width='100%'>
			<tr>
				<td>
					<div class='controlbox'>
						<table>
							<tr>
								<td>Date</td>
								<td><input type="text" name="startDate"
									value="${requestScope.startDate}" readonly="readonly"
									id="startdatepicker" class="dateField" onchange="fnDisableMonth() "></td>
								<%-- 									
								<td>To Date</td>
								<td><input type="text" name="toDate" size="12"
									value="${requestScope.toDate}" readonly="readonly"
									id="todatepicker" class="dateField"></td>
								--%>
								<td>Month : </td>
								<td><select name="month" 
									 style="font-weight: bold; margin-top: 6px;" onchange="fnDisableStartDate()" >
											<option value="">Select</option>
									 	<c:forEach var="monthName" items="${requestScope.monthNames}">
									 		<option value="${monthName}">${monthName}</option>
									 		</c:forEach>
								</select>
									<td>Employee Id:</td>
								<td><input type="text" name="employeeId" ></td>
								
								<td><input type="button" value="Search" name="Search"
									onclick="javascript:search();" class='select1'></td>
                                <td><input type="button" value="Export" name="Export" class='select1'
						                 onclick="javascript:fnGetDataTablesData();"></td>									
								 <td><input type="reset" value="Reset" class='select1' onclick="resetfunction()"></td>
                                 <td><input type="button" value="Cancel" name="Cancel" class='select1'
						                 onclick="javascript:cancelNavigation();"></td> 
						                 						                 
							</tr>
							<tr>
							<td colspan="9" style="color: red;padding-left: 50px">
										<ul>
											<li type=disc><fmt:message key="${requestScope.ConsolidatedNote1}" />
											</li>
											<li type=disc>
											<fmt:message key="${requestScope.ConsolidatedNote2}" />
											</li>
										</ul>
							</td>
							</tr>
						</table>
					</div>
				</td>
			</tr>
			<tr>
				<td>
					<div id="visualization" class='aout' style="border: 0px; margin: 10px; height: 300px; width: 98% ;" ></div>
				</td>
			</tr>
			<tr>
				<div style="float: right">
				<td align='right'><input type="button" class='select1'
					name="Approve" value="Approve"
					onclick="javascript:getbillableEffort();"></td>
				</div>
			</tr>
		</table>
	</form>
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

function getbillableEffort() {
	
	if(confirm("Approved Timesheet can not be modified in future.Do you want to continue?")) {
	
	var billableEffortArr =document.forms[0].elements["billableEffort"];
	var timesheetIds='';
	for(cnt=0;cnt<billableEffortArr.length;cnt++) {
		if(timesheetIds!='') {
			timesheetIds=timesheetIds+',';
		}
		timesheetIds +=billableEffortArr[cnt].id;
	}
	document.forms[0].elements['timeSheetIds'].value=timesheetIds;
	document.forms[0].elements['actionParam'].value="approve";
	document.forms[0].submit();
	}
	
	
}
function search() {
	
	/*
	if(document.forms[0].elements['startDate'].value=='' || document.forms[0].elements['toDate'].value=='')
	{
		alert("Please enter From date and To date.");
		return;	
		
	}
	*/
	document.forms[0].action='consolidatedTimesheetReport';
	document.forms[0].elements['actionParam'].value="search";
	document.forms[0].submit();
	
	
}
function fnGetDataTablesData()
{
	document.forms[0].action='exportToCSV';
	document.forms[0].submit();
	
}
function cancelNavigation()
{
	document.forms[0].action='reportsIndex';
	document.forms[0].submit();
	
}
function fnDisableMonth()
{

	var s=document.forms[0].elements["startDate"].value;
	
	if(s!="")
	{
		document.forms[0].elements["month"].disabled=true;
		document.forms[0].elements["employeeId"].disabled=true;
	}
	else
	{
		document.forms[0].elements["month"].disabled=false;
		document.forms[0].elements["employeeId"].disabled=false;
	}
	
}
function fnDisableStartDate()
{
	
	var s=document.forms[0].elements["month"].value;
	
	if(s!="")
	{
		document.forms[0].elements["startDate"].disabled=true;
	}
	else
	{
		document.forms[0].elements["startDate"].disabled=false;
	}
	
}
function resetfunction()
{
	document.forms[0].elements["employeeId"].disabled=false;
	document.forms[0].elements["startDate"].disabled=false;
	
	document.forms[0].elements["month"].disabled=false;
	document.forms[0].elements["startDate"].value="";
	document.forms[0].elements["month"].value="";
	document.forms[0].elements["employeeId"].value="";
	
}
</script>
	<%@include file="common/footer.jsp"%>
	
	<script>
//document.getElementById("reports_submenu").style.display='block';
</script>