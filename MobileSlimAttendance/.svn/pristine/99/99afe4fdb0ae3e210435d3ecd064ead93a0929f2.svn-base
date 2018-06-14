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
		  <c:if test="${sessionScope.isDepartment == 'Y'}">
		  data.addColumn('string', 'Department');//3
		  </c:if>
		  data.addColumn('string', 'Date');//3
		  data.addColumn('string', 'In Time');//4 
		  data.addColumn('string', 'Out Time');//5 
		  
		  csvStr= csvStr +'Employee Id,Employee Name,Location,Shift,Department,Created Date,In Time,Out Time';
		  
		 
		  csvStr= csvStr +sNewline;
		  
		  var i =0;
		  
		  
		  <c:if test="${sessionScope.isDepartment == 'Y'}">
		  <c:forEach var="item" items="${requestScope.dailyAttendanceRecord}">
		            data.addRows(1);
		            //document.getElementById("timeseetId_div").innerHTML=document.getElementById("timeseetId_div").innerHTML+'<input type="hidden" name="timesheetId" value=${item.timesheetId} >';
			  		data.setCell(i, 0,"${item.companyEmpId}");
			  	    data.setCell(i, 1,"${item.employeeName}");
			 		data.setCell(i, 2,'${item.locationName}');
			 		data.setCell(i, 3,'${item.shiftName}');
			 		data.setCell(i, 4,'${item.departmentName}');
			 		data.setCell(i, 5,'${item.createdDate}');
			 		data.setCell(i, 6,"${item.inTimeDayOfWeek}","${item.inTime}");
			  		data.setCell(i, 7,"${item.outTimeDayOfWeek}","${item.outTime}");
    			 	
    			 	  csvStr= csvStr + "${item.companyEmpId}" +",";
    			  	  csvStr= csvStr + "${item.employeeName}"+"," ; 
    			  	  csvStr= csvStr + "${item.locationName}"+",";
    			  	  csvStr= csvStr + "${item.shiftName}"+",";
    			  	  csvStr= csvStr + "${item.departmentName}"+",";
    			  	  csvStr= csvStr + "${item.createdDate}"+",";
    			  	  csvStr= csvStr + "${item.inTime}"+",";
    			  	  csvStr= csvStr + "${item.outTime}"+",";
					  csvStr+=sNewline;
					i++;
		  </c:forEach>
		  
		  </c:if>
		  
		  <c:if test="${sessionScope.isDepartment == 'N'}">
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
    			 	
    			 	  csvStr= csvStr + "${item.companyEmpId}" +",";
    			  	  csvStr= csvStr + "${item.employeeName}"+"," ; 
    			  	  csvStr= csvStr + "${item.locationName}"+",";
    			  	  csvStr= csvStr + "${item.shiftName}"+",";
    			      csvStr= csvStr + "${item.createdDate}"+",";
    			  	  csvStr= csvStr + "${item.inTime}"+",";
    			  	  csvStr= csvStr + "${item.outTime}";
					  csvStr+=sNewline;
					i++;
		  </c:forEach>
		  
		  </c:if>
		  // Create and draw the visualization.
		  var table = new google.visualization.Table(document.getElementById('visualization'));
		  table.draw(data, {allowHtml: true, showRowNumber: true, page:'enable', pageSize : 35, sortAscending:true, sortColumn:0,width:80});
		  document.getElementById("csvString").value="Current Day Timesheet Report" +sNewline +csvStr;
		  }	
</script>
</head>

<%@include file="common/timesheetPageUpper.jsp"%>
<body>
	<form action="consolidatedTimesheetReport" method="post">
		<input type="hidden" name="actionParam" value="search"> 
		<input type="hidden" name="csvString" id="csvString">
		<input type="hidden" name="reportFileName" value="Current_Day_Timesheet_Report.csv">
		<input
			type="hidden" name="timeSheetIds">
		  <table width='100%'>
		    <tr>
				<td>
					<div id="visualization" class='aout' style="border: 0px; margin: 0 0 0 0; height: 300px; width: 99%" ></div>
				</td>
			</tr>
			<tr align="right">
				
                                <td align="right" style="text-align: right;">
                                 
                                <input type="button" value="Export" name="Export" class='select1'
						                 onclick="javascript:fnGetDataTablesData();"> 
						                 
                                 <input type="button" value="Cancel" name="Cancel" class='select1'
						                 onclick="javascript:cancelNavigation();">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>  						                 
			</tr>
		</table>
	</form>
<script>
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
</script>
	<%@include file="common/footer.jsp"%>
	
	<script>
//document.getElementById("reports_submenu").style.display='block';
</script>