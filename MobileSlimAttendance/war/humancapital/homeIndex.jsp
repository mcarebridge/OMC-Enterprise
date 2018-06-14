<%@include file="common/common.jsp"%>
<%@include file="common/header.jsp"%>
<%@ page import="java.util.Date"%>
<link href="styles/jqueryui/jquery.ui.all.css" rel="stylesheet"
	type="text/css">
<link href="styles/tabcontent.css" rel="stylesheet"
	type="text/css">
<script type="text/javascript"
	src="scripts/tabcontent.js"></script>
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
      google.load('visualization', '1', {packages: ['corechart']});
    </script>
<script type="text/javascript">
	// Load the Visualization API and the piechart package.
	google.load('visualization', '1.0', {
		'packages' : [ 'corechart' ]
	});
	google.load('visualization', '1', {packages:['gauge']});
    //google.setOnLoadCallback(drawTable);
	// Set a callback to run when the Google Visualization API is loaded.
	//google.setOnLoadCallback(drawChart);	
	google.setOnLoadCallback(drawVisualization);
<!-- Load Tables -->
	<!-- Table ArrowFormat -->
	function drawVisualization() {
		var sNewline = navigator.userAgent.match(/Windows/) ? "\r\n" : "\n";
		var data = new google.visualization.DataTable();
		var data1 = new google.visualization.DataTable();
		var data2 = new google.visualization.DataTable();
		
        data.addColumn('string', 'Label');
        data.addColumn('number', 'Value');        
        data.addRows([
          ['Utilization %', ${utilization_percent}],
          ['Not Reported %',  ${not_reported_percent}]
        ]);
        
        data1.addColumn('string', 'Label');
        data1.addColumn('number', 'Value');
        data1.addRows([
          ['Late In %', ${late_in_percent} ],                       
          ['Early left %', ${early_left_percent}]
        ]);

        var data2 = new google.visualization.DataTable();
        data2.addColumn('string', 'Label');
        data2.addColumn('number', 'Value');  
        data2.addRows([
                      ['Utilization %', ${utilization_percent}]
                    ]);
        
        var data3 = new google.visualization.DataTable();
        data3.addColumn('string', 'Label');
        data3.addColumn('number', 'Value');  
        data3.addRows([
                      ['Not Reported %',  ${not_reported_percent}]
                    ]);
        
        var data4 = new google.visualization.DataTable();
        data4.addColumn('string', 'Label');
        data4.addColumn('number', 'Value');  
        data4.addRows([
                      ['Late In %', ${late_in_percent}]
                    ]);
        
        var data5 = new google.visualization.DataTable();
        data5.addColumn('string', 'Label');
        data5.addColumn('number', 'Value');  
        data5.addRows([
                      ['Early left %', ${early_left_percent}]
                    ]);
               
        var options2 = {
                width: 300, height: 150,
                greenFrom:0, greenTo:5,
                yellowFrom:6, yellowTo: 15,                
                redFrom: 16, redTo: 200,
                minorTicks: 5
              };
        
        var options3 = {
                width: 300, height: 150,
                greenFrom:0, greenTo:5,
                yellowFrom:6, yellowTo: 15,                
                redFrom: 16, redTo: 100,
                minorTicks: 5
              };
        
        var options4 = {
                width: 300, height: 150,
                greenFrom:0, greenTo:5,
                yellowFrom:6, yellowTo: 15,                
                redFrom: 16, redTo: 100,
                minorTicks: 5
              };
        
        var options5 = {
                width: 300, height: 150,
                greenFrom:0, greenTo:5,
                yellowFrom:6, yellowTo: 15,                
                redFrom: 16, redTo: 100,
                minorTicks: 5
              };

        var chart2 = new google.visualization.Gauge(document.getElementById('gauge_Utilization'));
        var chart3 = new google.visualization.Gauge(document.getElementById('gauge_NotReported'));
        var chart4 = new google.visualization.Gauge(document.getElementById('gauge_LateIn'));
        var chart5 = new google.visualization.Gauge(document.getElementById('gauge_EarlyLeft'));

        chart2.draw(data2, options2);
        chart3.draw(data3, options3);
        chart4.draw(data4, options4);
        chart5.draw(data5, options5);
	}
</script>
<script>
function setShfitId(val) {
	document.forms[0].elements['actionParam'].value='getLocationShiftDashboard';
	document.forms[0].elements['shiftId'].value=val;
	document.forms[0].submit();
	
}
function populateShiftList(val) {
	document.forms[0].elements['actionParam'].value='getLocationDashboard';
	document.forms[0].elements['locationId'].value=val;
	document.forms[0].submit();
}


function setShfitId1(val) {
	document.forms[0].elements['actionParam'].value='getShiftDepartmentDashboard';
	document.forms[0].elements['shiftId1'].value=val;
	document.forms[0].submit();
	
}
function populateShiftList1(val) {
	document.forms[0].elements['actionParam'].value='getLocationDepartmentDashboard';
	document.forms[0].elements['locationId1'].value=val;
	document.forms[0].submit();
}
</script>


</head>
<%@include file="common/pageUpperBranded.jsp"%>
<!-- Start Code to display error messgae -->
<form action="home" method="post">
	<input type="hidden" name="actionParam"
		value="getshiftDepartmentDashbaord">
	<div
		style="width: 100%; height: 100%; border: 0px solid red; margin: 15px 0 0 15px;">
		
<ul id="dashboardtabs" class="shadetabs">
<li><a href="#" rel="dash1" class="selected">Dashboard-1</a></li>
<li><a href="#" rel="dash2">Dashboard-2</a></li>
<!--  <li><a href="#" rel="dash3">Dashdoard-3</a></li>-->

</ul>

<div style="border:1px solid gray; margin-bottom: 1em; padding: 10px;height: 450px ;">

<div id="dash1" class="tabcontent" style="width: 100%; align: center; border: 0px solid red;">
<%@include file="gaugeDashboard.jsp"%>
	
</div>

<div id="dash2" class="tabcontent" >
<%@include file="factSheetDashboard.jsp"%>
</div>

<div id="dash3" class="tabcontent">

<%@include file="trendlineDashboard.jsp"%>

</div>

</div>

<script type="text/javascript">

var countries=new ddtabcontent("dashboardtabs")
countries.setpersist(true)
countries.setselectedClassTarget("link") //"link" or "linkparent"
countries.init()

</script>
		
	</div>
	<input type="hidden" ${f:hidden("shiftId1")}> <input
		type="hidden" ${f:hidden("locationId1")}>
</form>
<!-- end page -->
<%@include file="common/footer.jsp"%>