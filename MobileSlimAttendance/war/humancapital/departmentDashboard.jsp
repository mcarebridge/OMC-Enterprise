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
<!-- ****************************************************************  -->
<!--Load the AJAX API-->
<script type="text/javascript" src="https://www.google.com/jsapi"></script>
   <script type="text/javascript">
   <c:if test="${requestScope.departmentDashboardRecord != null}">
	google.load('visualization', '1', {packages:['table, charteditor,corechart']});
  	google.setOnLoadCallback(drawDepartmentDashbaord);
<!-- Load Tables -->
		function drawDepartmentDashbaord() {
		  // Create and populate the data table.
		  <c:if test="${sessionScope.isDepartment == 'Y'}">
		  var data = new google.visualization.DataTable();	
		  data.addColumn('string', 'Location');//0
		  data.addColumn('string', 'Shift');//0
		  data.addColumn('string', 'Department');//0
		  data.addColumn('string', 'Planned');//1
		  data.addColumn('string', 'Actual'); //2
		  data.addColumn('string', 'More / Less');//3
		  data.addColumn('string', 'More / Less  (%)');//3
		  
		  var i =0;
		  
		  
		  
		  <c:forEach var="item" items="${requestScope.departmentDashboardRecord}">
		            data.addRows(1);
			  		data.setCell(i, 0,"${item.locationName}");
			  	    data.setCell(i, 1,"${item.shiftName}");
		            data.setCell(i, 2,"${item.departmentName}");
			  	    data.setCell(i, 3,"${item.planned}");
			 		data.setCell(i, 4,'${item.actual}');
			 		data.setCell(i, 5,'${item.excessLess}');
			 		data.setCell(i, 6,'${item.excessLessPercent}'+'%');
			 		i++;
		  </c:forEach>
		  // Create and draw the visualization.
		  var table = new google.visualization.Table(document.getElementById('department_dashboard'));
		  table.draw(data, {allowHtml: true, showRowNumber: true, page:'enable', pageSize : 35, sortAscending:true, sortColumn:0,width:80});
		  </c:if>
		  
		 
		  }	
		 </c:if>
</script>
<script>

function populateShiftList(val) {
	if(val!='') {
		
		document.forms[0].elements['locationId'].value=val;
		document.forms[0].submit();
	
}
}
function cancelNavigation()
{
	document.forms[0].action='reportsIndex';
	document.forms[0].submit();
	
}
</script>    	
    
</head>
<%@include file="common/pageUpper.jsp"%>
<body>
	<!-- Start Code to display error messgae -->
	<form action="departmentDashboard" method="post" >
	<input type="hidden" name="actionParam" value="getshiftDepartmentDashbaord">
	<div
		style="width: 100%; height: 400px; border: 0px solid red; margin: 15px 0 0 0">
		<table style="width: 100%; align:center; border: 0px solid red;">
		   <c:if test="${sessionScope.isDepartment == 'Y'}">
			<tr>
				<td align="left" colspan="2">Please select Location: &nbsp;&nbsp;<select name="location"
							class="locationSelect" id="location"
							onchange="populateShiftList(this.value);">
								<option value="">Select Location</option>
								<c:forEach var="e" items="${sessionScope.locationList}">
									<option ${f:select("location",f:h(e.key.id))}>${f:h(e.locationName)}</option>
								</c:forEach>
						</select>
						
						<input type="hidden" name="locationId">
						&nbsp;&nbsp;&nbsp;<input type="button" value="Cancel" name="Cancel" class='select1'
						                 onclick="javascript:cancelNavigation();"></td>  	
			</tr>
			
			<tr>
				<td align="center" style="border: 0px solid red;" colspan="2">
				<div id="department_dashboard"  class='aout' style="border: 0px; margin: 0 0 0 0; height: 300px; width: 100%"></div>
				
				
				</td>
			</tr>
			</c:if>
		</table>
	</div>
	</form>
	<!-- end page -->
	<%@include file="common/footer.jsp"%>