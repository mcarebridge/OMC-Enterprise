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
		var data = new google.visualization.DataTable();
		var data1 = new google.visualization.DataTable();
        data.addColumn('string', 'Label');
        data.addColumn('number', 'Value');
        
        data.addRows([
          ['Utilization', ${utilization}],
          ['Future \n Assigned', 95]
        ]);
        data1.addColumn('string', 'Label');
        data1.addColumn('number', 'Value');
        data1.addRows([
          ['Late In', ${late_in} ],                       
          ['Early left', ${early_left}]
        ]);

        var options = {
          width: 600, height: 150	,
          redFrom: 0, redTo: 30,
          yellowFrom:31, yellowTo: 80,
          greenFrom:81, greenTo:100,
          minorTicks: 5
        };
        
        var options1 = {
                width: 600, height: 150,
                redFrom: 16, redTo: 100,
                yellowFrom:6, yellowTo: 15,
                greenFrom:0, greenTo:5,
                minorTicks: 5
              };

        var chart = new google.visualization.Gauge(document.getElementById('gauge_div'));
        var chart1 = new google.visualization.Gauge(document.getElementById('gauge_div1'));
        chart.draw(data, options);
        chart1.draw(data1, options1);
	}
</script>

<script type="text/javascript">
      google.load("visualization", "1", {packages:["corechart"]});
      google.setOnLoadCallback(drawChart);
      function drawChart() {
        var data = new google.visualization.DataTable();
        data.addColumn('string', 'Resource Distributions');
        data.addColumn('number', '# of Resources');
        var i=0;
        <c:forEach var="item" items="${requestScope.location_details}">
        data.addRows(1);
        data.setCell(i, 0,"${item.locationName}");
        data.setCell(i, 1,"${item.totalInCount}"*1);
        i++;
        </c:forEach>

        var options = {
          width: 420, height: 200,
          title: 'Resource Distribution'
        };

        var chart = new google.visualization.PieChart(document.getElementById('chart_div'));
        chart.draw(data, options);
      }
    </script>

<script type="text/javascript" src="https://www.google.com/jsapi"></script>
<script type="text/javascript">
      google.load("visualization", "1", {packages:["corechart"]});
      google.setOnLoadCallback(drawChart);
      function drawChart() {
        var data = new google.visualization.DataTable();
        data.addColumn('string', 'Location');
        data.addColumn('number', 'Planned');
        data.addColumn('number', 'Actual');
        var i=0;
        <c:forEach var="item" items="${requestScope.location_details}">
        data.addRows(1);
        data.setCell(i, 0,"${item.locationName}");
        data.setCell(i, 1,"${item.assignmentCount}"*1);
        data.setCell(i, 2,"${item.totalInCount}"*1);
        
        
        i++;
        </c:forEach>

        var options = {
          width: 420, height: 200,
          title: 'Head Count : Planned Vs Actual',
          vAxis: {title: 'Locations', titleTextStyle: {color: 'gray'}},
          hAxis: {title: 'Resources', titleTextStyle: {color: 'gray'}}
        };

        var chart = new google.visualization.BarChart(document.getElementById('bar_div'));
        chart.draw(data, options);
      }
    </script>

</head>
<%@include file="common/pageUpper.jsp"%>
<body>
	<!-- Start Code to display error messgae -->
	<div
		style="width: 100%; height: 400px; border: 0px solid red; margin: 15px 0 0 0">
		<table style="width: 100%; align: center; border: 0px solid red;">
			<tr>
				<td>
					<table>
						<tr>
							<td>Location-1</td>
							<td>Diagram</td>
						</tr>
						<tr>
							<td>Shift-1</td>
							<td>Diagram</td>
						</tr>
						<tr>
							<td>Shift-2</td>
							<td>Diagram</td>
						</tr>
						<tr>
							<td>Shift-3</td>
							<td>Diagram</td>
						</tr>
					</table>
				</td>
				<td>
					<table>
						<tr>
							<td>Location-2</td>
							<td>Diagram</td>
						</tr>
						<tr>
							<td>Shift-1</td>
							<td>Diagram</td>
						</tr>
						<tr>
							<td>Shift-2</td>
							<td>Diagram</td>
						</tr>
						<tr>
							<td>Shift-3</td>
							<td>Diagram</td>
						</tr>
					</table>
				</td>
				<td>
					<table>
						<tr>
							<td>Location-2</td>
							<td>Diagram</td>
						</tr>
						<tr>
							<td>Shift-1</td>
							<td>Diagram</td>
						</tr>
						<tr>
							<td>Shift-2</td>
							<td>Diagram</td>
						</tr>
						<tr>
							<td>Shift-3</td>
							<td>Diagram</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</div>
	<!-- end page -->
	<%@include file="common/footer.jsp"%>