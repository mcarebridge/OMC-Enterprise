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
<script type="text/javascript"
	src="scripts/jquery.ui.datepicker.js?updated=<%=new Date()%>"></script>
<script type="text/javascript" src="https://www.google.com/jsapi"></script>
<script type="text/javascript">
      google.load('visualization', '1.1', {packages: ['controls']});
    </script>
<script>

	function editEmployee(_empCompanyEmpId,empCompanyId) {
		document.forms[0].action='editEmployee';
		document.forms[0].elements['actionParam'].value='editEmployee';
		document.forms[0].elements['_empCompanyEmpId'].value=_empCompanyEmpId;
		document.forms[0].elements['empCompanyId'].value=empCompanyId;
		document.forms[0].submit();
	}
	
	function makeInactive() {		
		document.forms[0].action='editEmployee';
		document.forms[0].elements['actionParam'].value='inactivateEmployee';
		var a=document.forms[0].elements['selectedEmployeeId'];
		
		var inactiveEmployeeId="";
		if(a.length==undefined)	{
				inactiveEmployeeId=inactiveEmployeeId+a.value+",";
			}
		else{
			for(var i=0;i<a.length;i++)	{			
				if(a[i].checked) {		
						inactiveEmployeeId=inactiveEmployeeId+a[i].value+",";
				}
			}
		}
		
		document.forms[0].elements['inactiveEmployeeId'].value=inactiveEmployeeId;
		document.forms[0].submit();
		
	}
	
	function backToMain() {
		
		document.forms[0].actionParam.value = 'backToMain';
		document.forms[0].submit();
	}
	
	
</script>


<script type="text/javascript">
	google.load('visualization', '1', {packages:['table, charteditor,corechart']});
  	google.setOnLoadCallback(drawVisualization);
<!-- Load Tables -->
		function drawVisualization() {
		  // Create and populate the data table.
		  var data = new google.visualization.DataTable();
		  data.addColumn('string', 'Employee Id');//0
		  data.addColumn('string', 'Name');//1
		  data.addColumn('string', 'Employee Type'); //2
		  data.addColumn('string', 'City');//3
		  data.addColumn('string', 'Role');//4
		  data.addColumn('string', 'Is Active');//5 	
		  data.addColumn('string', 'Update');//6
		  data.addColumn('string', 'Check to Disable Employee');//7
		 
		  var i =0;
		  
		  <c:forEach var="employeeDto" items="${employeeList}">
		  	data.addRows(1);
	  		data.setCell(i, 0,"${f:h(employeeDto.companyEmployeeId)}");
	  		data.setCell(i, 1,"${f:h(employeeDto.name)}");
	  		data.setCell(i, 2,"${f:h(employeeDto.employeeType)}");
	  		data.setCell(i, 3,"${f:h(employeeDto.city)}");
	  		
	  		<c:if test="${employeeDto.isSupervisor=='Y'}">
	  		data.setCell(i, 4,"Supervisor");
	  		</c:if>
	  		<c:if test="${employeeDto.isSupervisor=='N'}">
	  		data.setCell(i, 4,"None");
	  		</c:if>
	  		<c:if test="${employeeDto.isSupervisor=='M'}">
	  		data.setCell(i, 4,"Manager");
	  		</c:if>
	  		data.setCell(i, 5,"${f:h(employeeDto.isActive)}");
	  		
	  		<c:if test="${employeeDto.isActive=='Y'}">
	  		data.setCell(i, 6,"<a href=javascript:editEmployee('${f:h(employeeDto.companyEmployeeId)}',${f:h(employeeDto.companyId)});>edit</a>");
	  		</c:if>
	  		<c:if test="${employeeDto.isActive=='N'}">
	  		data.setCell(i, 6,"");
	  		</c:if>
	  		<c:if test="${employeeDto.isActive=='Y'}">
	  		data.setCell(i,7,"<input type='checkbox' name='selectedEmployeeId' value='${f:h(employeeDto.companyEmployeeId)}'  id='employeeId'>");
	  		</c:if>
	  		<c:if test="${employeeDto.isActive=='N'}">
	  		data.setCell(i,7,"<input type='checkbox' name='selectedEmployeeId' value='${f:h(employeeDto.companyEmployeeId)}'  id='employeeId' disabled='disabled'>");
	  		</c:if>
	  		i++;
	  	</c:forEach>
	    
	  	var categoryPicker = new google.visualization.ControlWrapper({
	          'controlType': 'CategoryFilter',
	          'containerId': 'control1',
	          'options': {
	        	          	  
	            'filterColumnLabel': 'Employee Type' ,
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
	        	          	  
	            'filterColumnLabel': 'City' ,
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
		 var dashboard=new google.visualization.Dashboard(document.getElementById('employeeList'));
			     
		 dashboard.bind([categoryPicker,categoryPicker1,categoryPicker2], [table]);
		 dashboard.draw(data);
		}  			    
		
		function cancelNavigation()
		{
			document.forms[0].action='employeeIndex';
			document.forms[0].submit();
			
		}
</script>
</head>
<%@include file="common/pageUpper.jsp"%>
<form method="post" action="addEmployee" onsubmit="javascript:test();">
	<input type="hidden" name="actionParam" value="addEmployee"> <br>
	<div id="employeeList" >
		<table style="width: 100%">
		<tr>
			<td>
				<div class='controlbox'>
					<table style="padding-top: 10px;padding-bottom:10px; font-size: 12px; font: bold;">
						<tr>
							<td ><h6><div id="control1" style="width: 100%;padding-top: 5px;"></div>
							</h6>
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
			<td colspan="2" ><div id="chart1" style="width: 90%;border: 0px solid;"></div></td>
		</tr>
		</table>
	</div>

	<!-- end page -->
	<input type="hidden" ${f:hidden("companyId")} id="companyId"> <input
		type="hidden" name="_empCompanyEmpId"> <input type="hidden"
		${f:hidden("empCompanyId")} id="empCompanyId"> <input
		type="hidden" ${f:hidden("inactiveEmployeeId")}
		id="inactiveEmployeeId">
	<table width='100%'>
		<tr align="right">

			<td align="right" style="text-align: right;">
				<!-- 
                                <input type="button" value="Export" name="Export" class='select1'
						                 onclick="javascript:fnGetDataTablesData();"> -->
				<input type="button" class='select1' value="Disable Emp"
				onclick="javascript:makeInactive();" width="150px"> <input
				type="button" value="Cancel" name="Cancel" class='select1'
				onclick="javascript:cancelNavigation();">
			</td>

		</tr>
	</table>

</form>
<!-- start footer -->

<%@include file="common/footer.jsp"%>


