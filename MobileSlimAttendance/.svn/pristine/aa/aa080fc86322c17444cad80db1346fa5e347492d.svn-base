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

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<script type="text/javascript">
	google.load('visualization', '1', {packages:['table, charteditor,corechart']});
  	google.setOnLoadCallback(drawVisualization);
<!-- Load Tables -->

		function drawVisualization() {
		  // Create and populate the data table.
		  var data = new google.visualization.DataTable();
		 var a=a;
		  data.addColumn('string', 'Trans Id')//0
		  data.addColumn('string',  '<fmt:message key="${requestScope.pageTitle}"/>');//1
		  data.addColumn('string', 'Transmission time(${requestScope.timeZone})');//2
		  data.addColumn('string', 'Status'); //3
		  data.addColumn('string', 'State');//9
		  data.addColumn('string', 'IMEI Code');//5
		  data.addColumn('string', 'System accessor');//6 
		  data.addColumn('string', 'User name')//7
		  data.addColumn('string', 'Is Supervisor Role')//8
		  data.addColumn('string', 'Is User Active')//4
		  data.addColumn('string', 'Geo Coordinates');//10
		  data.addColumn('string', 'No. of Records Received');//11
		  data.addColumn('string', 'No. of records sent');//12
		  data.addColumn('string', 'Response Time (milli sec)');//13
		  
		  
		  var i =0;
		  
		  <c:forEach var="mobileAuditTrailReport" items="${requestScope.mobileAuditTrailList}">
		  	data.addRows(1);
	  		data.setCell(i, 0,"${f:h(mobileAuditTrailReport.key)}")
	  		data.setCell(i, 1,"${f:h(mobileAuditTrailReport.action)}");
	  		data.setCell(i, 2,"${f:h(mobileAuditTrailReport.createdDate)}");
	  		data.setCell(i, 3,"${f:h(mobileAuditTrailReport.status)}");
	  		data.setCell(i, 4,"${f:h(mobileAuditTrailReport.state)}");
	  		data.setCell(i, 5,"${f:h(mobileAuditTrailReport.imeiCode)}");
	  		data.setCell(i, 6,"${f:h(mobileAuditTrailReport.empCompanyEmpId)}"); 
	  		data.setCell(i,	7,"${f:h(mobileAuditTrailReport.userName)}"); 
	  		data.setCell(i, 8,"${f:h(mobileAuditTrailReport.isSuperwiser)}"); 
	  		data.setCell(i, 9,"${f:h(mobileAuditTrailReport.userStatus)}"); 
	  		data.setCell(i, 10,"${f:h(mobileAuditTrailReport.attendanceCoordinates)}");
	  		data.setCell(i, 11,"${f:h(mobileAuditTrailReport.recordsReceived)}");
	  		data.setCell(i, 12,"${f:h(mobileAuditTrailReport.recordsSend)}");
	  		data.setCell(i, 13,"${f:h(mobileAuditTrailReport.responseTime)}");
	  		i++;
	  	</c:forEach>
	  	
	  
	  	var table = new google.visualization.Table(document.getElementById('weeklyReport'));
		      
		 
		 table.draw(data,{allowHtml: true, showRowNumber: true, page:'enable',pageSize : 10, sortAscending:true});
		}
		 		
		function cancelNavigation()
		{
			document.forms[0].action='ReportsIndex';
			document.forms[0].submit();
			
		}
</script>

</head>
<%@include file="common/assignmentPageUpper.jsp"%>
<form action="MobileAuditTrailReport" method="post">

	<input type="hidden" name="actionParam" value="MobileAuditTrail">
	 <input type="hidden" name="timeoffset" value="">
	<div class='controlbox'>
		<table>
			<tr>
				<td>Date</td>
				<td><input type="text" name="startDate"
					value="${requestScope.startDate}" readonly="readonly"
					id="startdatepicker" class="dateField"></td>
				<td><input type="button" value="Search" name="Search"
					onclick="javascript:search();" class='select1'></td>
				<td><input type="button" value="Cancel" name="Cancel"
					class='select1' onclick="javascript:cancelNavigation();"></td>
			</tr>
		</table>
	</div>
	<div id="weeklyReport" class="aout" style="overflow: auto; width: 100%;height:100%;float: left; " ></div>

</form>
<script>
$(function() {
	$( "#startdatepicker" ).datepicker({
		showOn: "button",
		buttonImage: "images/calendar.gif",
		buttonImageOnly: true
	});
});
function search() {
	var offset = new Date().getTimezoneOffset()
	document.forms[0].elements['timeoffset'].value=offset;
	document.forms[0].elements['actionParam'].value="search";
	document.forms[0].submit();	
}
</script>
<%@include file="common/footer.jsp"%>