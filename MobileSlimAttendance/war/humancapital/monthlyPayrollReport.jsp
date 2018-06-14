<%@include file="common/common.jsp"%>
<%@include file="common/header.jsp"%>
<%@ page import="java.util.Date"%>
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
<script type="text/javascript" src="https://www.google.com/jsapi"></script>
<script type="text/javascript">
      google.load('visualization', '1.1', {packages: ['controls']});
    </script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<script type="text/javascript">
	google.load('visualization', '1', {packages:['table, charteditor,corechart']});
  	google.setOnLoadCallback(drawVisualization);
<!-- Load Tables -->

		function drawVisualization() {
		  // Create and populate the data table.
		  var data = new google.visualization.DataTable();
		 
		  data.addColumn('string', 'Month ')
		  data.addColumn('string', 'Month Start Date'); //1
		  data.addColumn('string', 'Month End Date');//2
		  data.addColumn('string', 'Download Report');//3 	
		 
		  var i =0;
		  
		  <c:forEach var="monthlyPayroll" items="${requestScope.monthlyPayrollList}">
		  	data.addRows(1);
		  
	  		data.setCell(i, 0,"${f:h(monthlyPayroll.monthName)}");
	  		data.setCell(i, 1,"${f:h(monthlyPayroll.startDate)}");
	  		data.setCell(i, 2,"${f:h(monthlyPayroll.endDate)}");
	  				
	  		<c:if test="${monthlyPayroll.noOfRecords!=0}">
	  		data.setCell(i,3,"<a href='javascript:fnGetDataTablesData(${f:h(monthlyPayroll.startTime)});' style='text-decoration: none;'>Download (${f:h(monthlyPayroll.noOfRecords)} Records)</a> ");
	  		</c:if>
	  		<c:if test="${monthlyPayroll.noOfRecords==0}">
	  		data.setCell(i,3,"");
	  		</c:if>
	  		
	  		i++;
	  	</c:forEach>
	  	
	     var categoryPicker = new google.visualization.ControlWrapper({
	          'controlType': 'CategoryFilter',
	          'containerId': 'control1',
	          'options': {
	        	          	  
	            'filterColumnLabel': 'Month ',
	            'ui': {	            	
	              'labelStacking': 'horizontal',
	              'labelSeparator': ':',
	              'allowTyping': false,
	              'allowMultiple': true
	            }
	          }
	        });
		 var table = new google.visualization.ChartWrapper({'chartType': 'Table',
		          'containerId': 'chart1',
		          'options': {            
		          'allowHtml': true, 'showRowNumber': true, 'page':'enable',pageSize : 12, 'sortAscending':true, 'sortColumn':0}
		 });
		 var dashboard=new google.visualization.Dashboard(document.getElementById('monthlyReport'));
			     
		 dashboard.bind([categoryPicker], [table]);
		 dashboard.draw(data);
		}
				
		function cancelNavigation()
		{
			document.forms[0].action='employeeIndex';
			document.forms[0].submit();
			
		}
</script>

</head>
<%@include file="common/assignmentPageUpper.jsp"%>
<form action="monthlyPayrollReport" method="post">

	<input type="hidden" name="actionParam" value="weeklyPayRoll">
	<input type="hidden" name="wwww" value=""> <input
		type="hidden" name="timeSheetIds">


	<div id="monthlyReport" style="width: 100%">
		<table style="width: 100%">
			<tr>
				<td >
					<div class='controlbox'>
						<table style="padding-top: 10px; font-size: 12px; font: bold;">
							<tr>
								<td  style="font: bold; margin-top: 6px;"><h6>Year:</h6></td>
								<td ><h6><select name="year" id="year"
									class="year" style="font-weight: bold; margin-top: 6px;" onchange="javascript:fnGetYear();">
										<option ${f:select("year","2012")} >2012</option>
										<option ${f:select("year","2013")}>2013</option>
										<option ${f:select("year","2014")}>2014</option>
										<option ${f:select("year","2015")}>2015</option>
										<option ${f:select("year","2016")}>2016</option>
								</select></h6></td>
								<td style="min-width: 200px; font: bold;"><h6>
									<div id="control1" style="width: 100%; margin-top: 8px;">
									</div></h6>
								</td>

							</tr>
						</table>
					</div>
				</td>
			</tr>

			<tr>
				<td>
					<div id="chart1" style="width: 90%;border: 0px solid; height:100%;"></div>
								</td>

			</tr>
		</table>
	</div>
</form>
<script>
function fnGetDataTablesData(startDate)
{
	document.forms[0].action='exportToCSV?startDate='+startDate;
	document.forms[0].submit();
	
}
function fnGetYear()
{
	document.forms[0].submit();
}
</script>
<%@include file="common/footer.jsp"%>