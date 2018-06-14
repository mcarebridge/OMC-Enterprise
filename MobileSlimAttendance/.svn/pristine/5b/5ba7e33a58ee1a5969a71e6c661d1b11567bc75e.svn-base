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

<!--Load the AJAX API-->
<script type="text/javascript" src="https://www.google.com/jsapi"></script>
<script type="text/javascript">
var csvStr='';
	google.load('visualization', '1', {packages:['table, charteditor,corechart']});
	
  	google.setOnLoadCallback(drawVisualization);
<!-- Load Tables -->
	
	
		function drawVisualization() {
		  // Create and populate the data table.
		  
		 var sNewline = navigator.userAgent.match(/Windows/) ? "\r\n" : "\n";
		  var data = new google.visualization.DataTable();
		  data.addColumn('string', 'Employee Id');
		  data.addColumn('string', 'Employee Name');
		  csvStr= csvStr +'Employee Id,Employee Name';
		  var noOfDays=31;
		  for(cnt=1;cnt<=noOfDays;cnt++) {
			  data.addColumn('string', cnt);
			  csvStr=csvStr+","+cnt;
		  }
		  csvStr+=sNewline;
		  var i =0;
		  
		 <c:forEach var="item" items="${requestScope.peroidicTimesheetRecord}">
		            data.addRows(1);
			  		data.setCell(i, 0,"${item.employeeId}");
			  	    data.setCell(i, 1,"${item.employeeName}");
			  	  csvStr= csvStr + "${item.employeeId}" +",";
			  	  csvStr= csvStr + "${item.employeeName}";  
			  	   var ind=2;
				  <c:forEach var="timesheet" items="${item.timsheetList}">
				      data.setCell(i, ind,"${timesheet.effort}");
				      csvStr=csvStr+","+"${timesheet.effort}";
				      ind++;
				  </c:forEach>
			 		
					i++;
					 csvStr+=sNewline;
		  </c:forEach>
		  document.getElementById("csvString").value="Monthly Time Card Grid" +sNewline +csvStr;
		  // Create and draw the visualization.
		  var table = new google.visualization.Table(document.getElementById('visualization'));
		  var colorFormat = new google.visualization.ColorFormat();

		  //var formatter = new google.visualization.TableArrowFormat();
		  //formatter.format(data, 9); // Apply formatter to second column
		  //colorFormat.addRange(1, 9, 'green', 'white');
		  //colorFormat.format(data, 6);
		  
		  table.draw(data, {allowHtml: true, showRowNumber: true, page:'enable', pageSize : 15, sortAscending:true, sortColumn:0});
		  }	
		</script>
</head>
<%@include file="common/pageUpper.jsp"%>

	<form action="periodicTimesheetReport" method="post">
		<div class='controlbox'>
			<table width="70%" border="1">
				<tr >
					<td width='15%'>From Date</td>
					<td width='15%'><select name="startDate">
					       
							<option ${f:select("startDate","01/01/2012")}>Jan-2012</option>
							<option ${f:select("startDate","02/01/2012")}>Feb-2012</option>
							<option ${f:select("startDate","03/01/2012")}>Mar-2012</option>
							<option ${f:select("startDate","04/01/2012")}>Apr-2012</option>
							<option ${f:select("startDate","05/01/2012")}>May-2012</option>
							<option ${f:select("startDate","06/01/2012")}>Jun-2012</option>
							<option ${f:select("startDate","07/01/2012")}>Jul-2012</option>
							<option ${f:select("startDate","08/01/2012")}>Aug-2012</option>
							<option ${f:select("startDate","09/01/2012")}>Sep-2012</option>
							<option ${f:select("startDate","10/01/2012")}>Oct-2012</option>
							<option ${f:select("startDate","11/01/2012")}>Nov-2012</option>
							<option ${f:select("startDate","12/01/2012")}>Dec-2012</option>
							<option ${f:select("startDate","01/01/2013")}>Jan-2013</option>
							<option ${f:select("startDate","02/01/2013")}>Feb-2013</option>
							<option ${f:select("startDate","03/01/2013")}>Mar-2013</option>
							<option ${f:select("startDate","04/01/2013")}>Apr-2013</option>
							<option ${f:select("startDate","05/01/2013")}>May-2013</option>
							<option ${f:select("startDate","06/01/2013")}>Jun-2013</option>
							<option ${f:select("startDate","07/01/2013")}>Jul-2013</option>
							<option ${f:select("startDate","08/01/2013")}>Aug-2013</option>
							<option ${f:select("startDate","09/01/2013")}>Sep-2013</option>
							<option ${f:select("startDate","10/01/2013")}>Oct-2013</option>
							<option ${f:select("startDate","11/01/2013")}>Nov-2013</option>
							<option ${f:select("startDate","12/01/2013")}>Dec-2013</option>
				
					</select></td>
					<td><input type="button" value="Search" name="Search" class='select1'
						onclick="javascript:search();"></td>
					<td><input type="button" value="Export" name="Export" class='select1'
						onclick="javascript:fnGetDataTablesData();"></td>
					 <td><input type="button" value="Cancel" name="Cancel" class='select1'
						                 onclick="javascript:cancelNavigation();"></td>  	
				</tr>
			</table>
		</div>
		<br>
		<div id="visualization"  class='aout'></div>
		<input type="hidden" name="csvString" id="csvString">
		<input type="hidden" name="reportFileName" value="Monthly_Time_Card_Grid.csv">
	</form>
	<script>

function fnGetDataTablesData()
{
	document.forms[0].action='exportToCSV';
	document.forms[0].submit();
	
}
function search()
{
	document.forms[0].action='periodicTimesheetReport';
	document.forms[0].submit();
	
}
function cancelNavigation()
{
	document.forms[0].action='reportsIndex';
	document.forms[0].submit();
	
}

</script>
	<%@include file="common/footer.jsp"%>