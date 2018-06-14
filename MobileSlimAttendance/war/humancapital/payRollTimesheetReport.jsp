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
		  data.addColumn('string', 'Employee Type');//2
		  data.addColumn('string', 'Designation');//2
		  data.addColumn('string', 'Location'); //3
		  data.addColumn('string', 'Shift');//4
		  data.addColumn('string', 'Date');//5 	
		  data.addColumn('string', 'In Time');//6 
		  data.addColumn('string', 'Out Time');//7 
		  data.addColumn('string', 'Regular Effort <br> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;A');//8
		  data.addColumn('string', 'Over Time <br>  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;B');//9
		  data.addColumn('string', 'Total Effort<br>  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;A+B');//10
		  data.addColumn('string', 'Leave');//11
		 
		 
		
		  
		  csvStr= csvStr +'Employee Id,Employee Name,Employee Type,Designation,Location,Shift,Date,In Time,Out Time,Regular Effort,Leave,Over Time,Total Effort';
		  csvStr= csvStr +sNewline;
		  var i =0;
		  
		 <c:forEach var="item" items="${requestScope.dailyAttendanceRecord}">
		            data.addRows(1);
		            //document.getElementById("timeseetId_div").innerHTML=document.getElementById("timeseetId_div").innerHTML+'<input type="hidden" name="timesheetId" value=${item.timesheetId} >';
			  		data.setCell(i, 0,"${item.companyEmpId}");
			  	    data.setCell(i, 1,"${item.employeeName}");
			  	    data.setCell(i, 2,"${item.employeeType}");
			  	    data.setCell(i, 3,"${item.designation}");
			 		data.setCell(i, 4,'${item.locationName}');
			 		data.setCell(i, 5,'${item.shiftName}');
			 		data.setCell(i, 6,'${item.createdDate}');
			 		data.setCell(i, 7,"${item.inTimeDayOfWeek}","${item.inTime}");
			  		data.setCell(i, 8,"${item.outTimeDayOfWeek}","${item.outTime}");
				 	data.setCell(i, 9,"${item.regularEffort}");
    			 	data.setCell(i, 10,"${item.overTime}");
    			 	data.setCell(i, 11,"${item.actualEffort}");
    			 	data.setCell(i, 12,"${item.leave}");
    			 	
    			 	
    			 	  csvStr= csvStr + "${item.companyEmpId}" +",";
    			  	  csvStr= csvStr + "${item.employeeName}"+"," ;
    			  	  csvStr= csvStr + "${item.employeeType}"+"," ; 
    			  	  csvStr= csvStr + "${item.designation}"+"," ; 
    			  	  csvStr= csvStr + "${item.locationName}"+",";
    			  	  csvStr= csvStr + "${item.shiftName}"+",";
    			  	  csvStr= csvStr + "${item.createdDate}"+",";
    			  	  csvStr= csvStr + "${item.inTime}"+",";
    			  	  csvStr= csvStr + "${item.outTime}"+",";
    			  	  csvStr= csvStr + "${item.regularEffort}"+",";
    			  	  csvStr= csvStr + "${item.overTime}"+",";
    			  	  csvStr= csvStr + "${item.actualEffort}" +",";
    			  	  csvStr= csvStr + "${item.leave}";
    			  	  
    			 	
    			 	
					 csvStr+=sNewline;
					i++;
		  </c:forEach>
		  // Create and draw the visualization.
		  var table = new google.visualization.Table(document.getElementById('visualization'));
		  table.draw(data, {allowHtml: true, showRowNumber: true, page:'enable', pageSize : 35, sortAscending:true, sortColumn:0,width:80});
		  document.getElementById("csvString").value="Payroll Report" +sNewline +csvStr;
		  }	
</script>
</head>

<%@include file="common/timesheetPageUpper.jsp"%>
<body>
	<form action="payRollTimesheetReport" method="post">
		<input type="hidden" name="actionParam" value="search"> 
		<input type="hidden" name="csvString" id="csvString">
		<input type="hidden" name="reportFileName" value="Payroll_Report.csv">
		<input
			type="hidden" name="timeSheetIds">
		<table width='100%'>
			<tr>
				<td>
					<div class='controlbox'>
						<table>
							<tr>
								<td>From Date</td>
								<td><input type="text" name="startDate"
									value="${requestScope.startDate}" readonly="readonly"
									id="startdatepicker" class="dateField"></td>
								<td>To Date</td>
								<td><input type="text" name="toDate" size="12"
									value="${requestScope.toDate}" readonly="readonly"
									id="todatepicker" class="dateField"></td>
								<td><input type="button" value="Search" name="Search"
									onclick="javascript:search();" class='select1'></td>
                                <td><input type="button" value="Export" name="Export" class='select1'
						                 onclick="javascript:fnGetDataTablesData();"></td>		
						       <td><input type="button" value="Cancel" name="Cancel" class='select1'
						                 onclick="javascript:cancelNavigation();"></td>  	
							</tr>
						</table>
					</div>
				</td>
			</tr>
			<tr>
				<td>
					<div id="visualization" class='aout' style="border: 0px; margin: 0 0 0 0; height: 300px; width: 98%" ></div>
				</td>
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

function search() {
	
	if(document.forms[0].elements['startDate'].value=='' || document.forms[0].elements['toDate'].value=='')
	{
		alert("Please enter From date and To date.");
		return;
		
	}
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
</script>
	<%@include file="common/footer.jsp"%>
	
	<script>
//document.getElementById("reports_submenu").style.display='block';
</script>