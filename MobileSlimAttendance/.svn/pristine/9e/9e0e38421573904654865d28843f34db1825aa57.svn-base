<%@include file="common/common.jsp"%>
<%@include file="common/header.jsp"%>
<script type="text/javascript" src="https://www.google.com/jsapi"></script>
<script type="text/javascript">
      google.load('visualization', '1.1', {packages: ['controls']});
    </script>
	
<script type="text/javascript">
	google.load('visualization', '1', {packages:['table, charteditor,corechart']});
  	google.setOnLoadCallback(drawVisualization);
<!-- Load Tables -->
		function drawVisualization() {
		  // Create and populate the data table.
		  var data = new google.visualization.DataTable();
		  data.addColumn('string', 'Alert Id');//0
		  data.addColumn('string', 'Alert Name');//1
		  data.addColumn('string', 'Location Name'); //2
		  data.addColumn('string', 'Shift Name');//3
		  data.addColumn('string', '1st Level Manager');//3
		  data.addColumn('string', '2nd Level Manager');//3
		  data.addColumn('string', 'Target Value');//4
		  data.addColumn('string', 'Min. Value');//5 	
		  data.addColumn('string', 'Max. Value');//6
		  data.addColumn('string', 'tolerance ');//7
		  data.addColumn('string', 'Is Active');//8
		  data.addColumn('string', 'Check to Disable Alert');//9
		  var i =0;
		  
		  <c:forEach var="alert" items="${alertList}">
		  	data.addRows(1);
		  	var msg=""
		  	var min=${f:h(alert.minValueForAlert)};
			var max=${f:h(alert.maxValueForAlert)};
			var tgt=${f:h(alert.targetValues)};
			var tolerance=${f:h(alert.toleranceLevelForEscalation)};
			if( min !="" && max != "")
			{			
				min=parseInt(min)-parseInt(min/100*tolerance);
				max=parseInt(max)+parseInt(max/100*tolerance);
				msg="( <"+min+" or >"+max+" )";
			}
		  	
		  	data.setCell(i, 0,"${f:h(alert.key.id)}")
		  	data.setCell(i, 1,"${f:h(alert.alertTypeRef.model.displayName)}")
		  	data.setCell(i, 2,"${f:h(alert.locationRef.model.locationName)}","<a href=javascript:editAlertLocation('${f:h(alert.key.id)}');>${f:h(alert.locationRef.model.locationName)}</a>");
	  		data.setCell(i, 3,"<a href=javascript:editAlertShift('${f:h(alert.key.id)}');>${f:h(alert.shiftRef.model.shiftName)}</a>");
	  		data.setCell(i, 4,"${f:h(alert.firstLevelManager.model.salutation)} ${f:h(alert.firstLevelManager.model.firstName)} ${f:h(alert.firstLevelManager.model.lastName)}");
	  		data.setCell(i, 5,"${f:h(alert.secondLevelManager.model.salutation)} ${f:h(alert.secondLevelManager.model.firstName)} ${f:h(alert.secondLevelManager.model.lastName)}");	  		
	  		data.setCell(i, 6,"${f:h(alert.targetValues)}");
	  		data.setCell(i, 7,"${f:h(alert.minValueForAlert)}");
	  		data.setCell(i, 8,"${f:h(alert.maxValueForAlert)}");
	  		data.setCell(i, 9,"${f:h(alert.toleranceLevelForEscalation)}% "+msg+"");
	  		data.setCell(i, 10,"${f:h(alert.active)}");
	  			  		
	  		<c:if test="${alert.active=='Y'}">
	  		data.setCell(i,11,"<input type='checkbox' name='selectedAlertId' value='${f:h(alert.key.id)}'  id='alertCheckbox'>");
	  		</c:if>
	  		<c:if test="${alert.active=='N'}">
	  		data.setCell(i,11,"<input type='checkbox' name='selectedAlertId' value='${f:h(alert.key.id)}'  id='alertCheckbox' disabled='disabled'>");
	  		</c:if>
	  		
	  		i++;
	  	 </c:forEach>
	  	
	 	var categoryPicker = new google.visualization.ControlWrapper({
	          'controlType': 'CategoryFilter',
	          'containerId': 'control1',
	          'options': {
	        	          	  
	            'filterColumnLabel': 'Alert Name' ,
	            'ui': {	            	
	              'labelStacking': 'horizontal',
	              'labelSeparator': ':',
	              'allowTyping': false,
	              'allowMultiple': true
	            }
	          }
	        });
	  	var categoryPicker2 = new google.visualization.ControlWrapper({
	          'controlType': 'CategoryFilter',
	          'containerId': 'control3',
	          'options': {
	        	          	  
	            'filterColumnLabel': 'Location Name' ,
	            'ui': {	            	
	              'labelStacking': 'horizontal',
	              'labelSeparator': ':',
	              'allowTyping': false,
	              'allowMultiple': true
	            }
	          }
	        });
	  	var categoryPicker1 = new google.visualization.ControlWrapper({
	          'controlType': 'CategoryFilter',
	          'containerId': 'control2',
	          'options': {
	        	          	  
	            'filterColumnLabel': 'Is Active' ,
	            'ui': {	            	
	              'labelStacking': 'horizontal',
	              'labelSeparator': ':',
	              'allowTyping': false,
	              'allowMultiple': false
	            }
	          }
	        });
		
	  	var table = new google.visualization.ChartWrapper({'chartType': 'Table',
		          'containerId': 'chart1',
		          'options': {            
		          'allowHtml': true, 'showRowNumber': true, 'page':'enable',pageSize : 10, 'sortAscending':true, 'sortColumn':0}
		 });
		 var dashboard=new google.visualization.Dashboard(document.getElementById('alertList'));
			     
		 dashboard.bind([categoryPicker,categoryPicker1,categoryPicker2], [table]);
		 dashboard.draw(data);
		}
	
	  	</script>
	  	<script>
	  	
	  	function editAlertLocation(alertId) {
			document.forms[0].action='editAlert';
			document.forms[0].elements['actionParam'].value='editAlertLocation';
			document.forms[0].elements['alertId'].value=alertId;
			
			document.forms[0].submit();
		}
	  	function editAlertShift(alertId) {
			document.forms[0].action='editAlert';
			document.forms[0].elements['actionParam'].value='editAlertShift';
			document.forms[0].elements['alertId'].value=alertId;
			
			document.forms[0].submit();
		}
		function makeInactive()	{		
			document.forms[0].action='editAlert';
			document.forms[0].elements['actionParam'].value='inactivateAlert';
			var a=document.forms[0].elements['selectedAlertId'];
			
			var inactiveAlertId="";
			if(a.length==undefined)	{
					inactiveAlertId=inactiveAlertId+a.value+",";
				}
			else {
				for(var i=0;i<a.length;i++)	{				
					if(a[i].checked) {		
						inactiveAlertId=inactiveAlertId+a[i].value+",";
					}
				}
			}			
			document.forms[0].elements['inactiveAlertId'].value=inactiveAlertId;
			document.forms[0].submit();			
		}
		function cancelNavigation()	{
			document.forms[0].action="configurationIndex";
			document.forms[0].elements['actionParam'].value = null;
			document.forms[0].submit();			
		}
	  	</script>
	  	
  	</head>
<%@include file="common/pageUpper.jsp"%>
<div class="secondarymenu" style=" width: 98%;  vertical-align: middle; margin-left: 40px ;clear: left;">
<form method="post" action="editAlert" onsubmit="javascript:test();">
	<input type="hidden" name="actionParam" value="addAlert"/>
	<input type="hidden" name="alertId" value=""/> 
	<input type="hidden" name="inactiveAlertId"	id="inactiveAlertId" value="">
	<div id="alertList" >
		<table style="width: 100%;height: 100%">
		<tr>
			<td>
				<div class='controlbox'>
					<table style="padding-top: 10px;padding-bottom:10px; font-size: 12px; font: bold;">
						<tr>
							<td ><h6><div id="control1" style="width: 100%;padding-top: 5px;"></div></h6>
							</td>
							<td><h6><div id="control2" style="width: 100%; padding-top: 5px;"></div></h6>
							</td>
							<td><h6><div id="control3" style="width: 100%; padding-top: 5px;"></div></h6>
							</td>
						</tr>
					</table>
				</div>		
			</td>
		</tr>
		<tr style="margin-top: 10px">
			<td colspan="2" ><div id="chart1" style="width: 100%;border: 0px solid;height: 100%" ></div></td>
		</tr>
		</table>
	</div>
	<table width='100%'>
		<tr align="right">
			<td align="right" style="text-align: right;">
				<!-- 
                                <input type="button" value="Export" name="Export" class='select1'
						                 onclick="javascript:fnGetDataTablesData();"> -->
				<input type="button" class='select1' value="Inactivate Alert"
				onclick="javascript:makeInactive();" width="150px"> <input
				type="button" value="Cancel" name="Cancel" class='select1'
				onclick="javascript:cancelNavigation();">
			</td>

		</tr>
	</table>
	</form>
</div>
<%@include file="common/footer.jsp"%>