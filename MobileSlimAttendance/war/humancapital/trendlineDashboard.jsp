<!--   For trendlineDashBoard   --> 
<script type="text/javascript">
	// Load the Visualization API and the piechart package.
	google.load('visualization', '1.0', {
		'packages' : [ 'corechart' ]
	});
	 google.load('visualization', '1', {packages: ['annotatedtimeline']});
	//google.setOnLoadCallback(drawTable);
	// Set a callback to run when the Google Visualization API is loaded.
	//google.setOnLoadCallback(drawChart);	
	google.setOnLoadCallback(drawVisualization);

function drawVisualization() {
	  var data = new google.visualization.DataTable();
	  data.addColumn('date', 'Date');
	  data.addColumn('number', 'Sold Pencils');
	  data.addColumn('string', 'title1');
	  data.addColumn('string', 'text1');
	  data.addColumn('number', 'Sold Pens');
	  data.addColumn('string', 'title2');
	  data.addColumn('string', 'text2');
	  data.addRows([
	    [new Date(2008, 1 ,1), 30000, null, null, 40645, null, null],
	    [new Date(2008, 1 ,2), 14045, null, null, 20374, null, null],
	    [new Date(2008, 1 ,3), 55022, null, null, 50766, null, null],
	    [new Date(2008, 1 ,4), 75284, null, null, 50766, null, null],
	    [new Date(2008, 1 ,5), 41476, null, null, 50766, null, null],
	    [new Date(2008, 1 ,6), 33322, null, null, 39463, null, null]
	  ]);

	  var annotatedtimeline = new google.visualization.AnnotatedTimeLine(
	      document.getElementById('dashboard3'));
	  annotatedtimeline.draw(data, {'displayAnnotations': true});
	}

</script>
<div id='dashboard3' style="width: 800px; height: 400px;"></div>

