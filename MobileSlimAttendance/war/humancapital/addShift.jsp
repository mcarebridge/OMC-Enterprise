<%@include file="common/common.jsp"%>
<%@include file="common/header.jsp"%>

<!-- start header -->
<script>

	/*$(document).ready(function() {

		$('#results').dataTable({
			"sPaginationType" : "full_numbers",
			"bLengthChange" : false,
			"bFilter" : false
		});
	});*/
	document.onload=function(){
		
		document.forms[0].elements['location'].value = "";
		document.forms[0].elements['shiftName'].value = "";
		document.forms[0].elements['start_hrs'].value = "";
		document.forms[0].elements['start_min'].value = "";
		document.forms[0].elements['end_hrs'].value = "";
		document.forms[0].elements['end_min'].value = "";
		
		
	}
	function clearFields() {

		document.forms[0].elements['location'].value = "";
		document.forms[0].elements['shiftName'].value = "";
		document.forms[0].elements['start_hrs'].value = "";
		document.forms[0].elements['start_min'].value = "";
		document.forms[0].elements['end_hrs'].value = "";
		document.forms[0].elements['end_min'].value = "";
		
		

	}
	function editShift(shiftId) {
		document.forms[0].action = 'editShift';
		document.forms[0].elements['actionParam'].value = 'editShift';
		document.forms[0].elements['shiftId'].value = shiftId;
		document.forms[0].submit();

	}
	function cancelNavigation()
	{
		document.forms[0].elements['actionParam'].value = null;
		document.forms[0].submit();
		
	}
</script>

<!--Load the AJAX API-->
<script type="text/javascript" src="https://www.google.com/jsapi"></script>
<script type="text/javascript">
	google.load('visualization', '1', {packages:['table, charteditor,corechart']});
  	google.setOnLoadCallback(drawVisualization);
<!-- Load Tables -->
		function drawVisualization() {
		  // Create and populate the data table.
		  var data = new google.visualization.DataTable();
		  data.addColumn('string', 'Shift');//1
		  data.addColumn('string', 'Location(Timezome)'); //2
		  data.addColumn('string', 'Status'); //2
		  data.addColumn('string', 'Start Time');//3 		  
		  data.addColumn('string', 'End Time');//4 
		  data.addColumn('string', 'Created Date');//5 
		  data.addColumn('string', 'Duration');//6
		  data.addColumn('string', 'Update');//7
		  var i =0;
		  <c:forEach var="shiftDto" items="${shiftList}">
		  	data.addRows(1);
	  		data.setCell(i, 0,"${f:h(shiftDto.shiftName)}");
	  		data.setCell(i, 1,"${f:h(shiftDto.locationName)}(${f:h(shiftDto.timeZone)})");
	  		data.setCell(i, 2,"${f:h(shiftDto.active)}");
	  		data.setCell(i, 3,"${f:h(shiftDto.startTime)}");
	  		data.setCell(i, 4,"${f:h(shiftDto.endTime)}");
	  		data.setCell(i, 5,"${f:h(shiftDto.createdDate)}(${f:h(shiftDto.timeZone)})");
	  		data.setCell(i, 6,"${f:h(shiftDto.duration)}");
	  		data.setCell(i, 7,"<a href='javascript:editShift(${f:h(shiftDto.shiftId)})'>edit</a>");
	  		i++;
	  	</c:forEach>
	  	
	  	 var table = new google.visualization.Table(document.getElementById('shifts'));
	  	 table.draw(data, {allowHtml: true, showRowNumber: true, page:'enable', pageSize : 5, sortAscending:true, sortColumn:5});	  	
		}
</script>
</head>
<%@include file="common/pageUpper.jsp"%>
<form method="post" action="addShift">
<input type="hidden" name="counter" value="${sessionScope['counter']}">
	
	<div class='controlbox'>
		<table width="70%">
			<tr>
				<td width="30%">&nbsp;</td>
				<td width="70%">&nbsp;</td>
			</tr>
			<tr>
				<td><span>*</span>Location</td>
				<td><select name="location" class="countrySelect" id="location">
						<option value="">Select Location</option>
						<c:forEach var="e" items="${sessionScope.locationList}">
							<option ${f:select("location",f:h(e.key.id))}>${f:h(e.locationName)}</option>
						</c:forEach>
				</select>
				</td>
			</tr>
			<tr>
				<td><span>*</span>Shift Name</td>
				<td><input type="text"${f:text("shiftName")}></td>
			</tr>
			<tr>
						<td></td>
						<td>Use only number and Alphabet with No spaces.
							</td>
			</tr>
			<tr>
				<td></td>
				<td><b> Hours&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Minutes</b></td>
			</tr>
			<tr>
				<td><span>*</span>Start Time</td>
				<td><select name="start_hrs" class="hour" id="start_hrs">
						<option ${f:select("start_hrs",f:h(""))}>Hours</option>
						<option ${f:select("start_hrs",f:h(00))}>00</option>
						<option ${f:select("start_hrs",f:h(01))}>01</option>
						<option ${f:select("start_hrs",f:h(02))}>02</option>
						<option ${f:select("start_hrs",f:h(03))}>03</option>
						<option ${f:select("start_hrs",f:h(04))}>04</option>
						<option ${f:select("start_hrs",f:h(05))}>05</option>
						<option ${f:select("start_hrs",f:h(06))}>06</option>
						<option ${f:select("start_hrs",f:h(07))}>07</option>
						<option ${f:select("start_hrs",f:h(08))}>08</option>
						<option ${f:select("start_hrs",f:h(09))}>09</option>
						<option ${f:select("start_hrs",f:h(10))}>10</option>
						<option ${f:select("start_hrs",f:h(11))}>11</option>
						<option ${f:select("start_hrs",f:h(12))}>12</option>
						<option ${f:select("start_hrs",f:h(13))}>13</option>
						<option ${f:select("start_hrs",f:h(14))}>14</option>
						<option ${f:select("start_hrs",f:h(15))}>15</option>
						<option ${f:select("start_hrs",f:h(16))}>16</option>
						<option ${f:select("start_hrs",f:h(17))}>17</option>
						<option ${f:select("start_hrs",f:h(18))}>18</option>
						<option ${f:select("start_hrs",f:h(19))}>19</option>
						<option ${f:select("start_hrs",f:h(20))}>20</option>
						<option ${f:select("start_hrs",f:h(21))}>21</option>
						<option ${f:select("start_hrs",f:h(22))}>22</option>
						<option ${f:select("start_hrs",f:h(23))}>23</option>

				</select> &nbsp; <select name="start_min" class="hour" id="start_min">
						<option ${f:select("start_min",f:h(""))}>Min</option>
						<option ${f:select("start_min",f:h(00))}>00</option>
						<option ${f:select("start_min",f:h(15))}>15</option>
						<option ${f:select("start_min",f:h(30))}>30</option>
						<option ${f:select("start_min",f:h(45))}>45</option>
				</select></td>
			</tr>
			<tr>
				<td><span>*</span>End Time</td>
				<td><select name="end_hrs" class="hour" id="end_hrs">
						<option ${f:select("end_hrs",f:h(""))}>Hours</option>
						<option ${f:select("end_hrs",f:h(0))}>00</option>
						<option ${f:select("end_hrs",f:h(1))}>01</option>
						<option ${f:select("end_hrs",f:h(2))}>02</option>
						<option ${f:select("end_hrs",f:h(3))}>03</option>
						<option ${f:select("end_hrs",f:h(4))}>04</option>
						<option ${f:select("end_hrs",f:h(5))}>05</option>
						<option ${f:select("end_hrs",f:h(6))}>06</option>
						<option ${f:select("end_hrs",f:h(7))}>07</option>
						<option ${f:select("end_hrs",f:h(8))}>08</option>
						<option ${f:select("end_hrs",f:h(9))}>09</option>
						<option ${f:select("end_hrs",f:h(10))}>10</option>
						<option ${f:select("end_hrs",f:h(11))}>11</option>
						<option ${f:select("end_hrs",f:h(12))}>12</option>
						<option ${f:select("end_hrs",f:h(13))}>13</option>
						<option ${f:select("end_hrs",f:h(14))}>14</option>
						<option ${f:select("end_hrs",f:h(15))}>15</option>
						<option ${f:select("end_hrs",f:h(16))}>16</option>
						<option ${f:select("end_hrs",f:h(17))}>17</option>
						<option ${f:select("end_hrs",f:h(18))}>18</option>
						<option ${f:select("end_hrs",f:h(19))}>19</option>
						<option ${f:select("end_hrs",f:h(20))}>20</option>
						<option ${f:select("end_hrs",f:h(21))}>21</option>
						<option ${f:select("end_hrs",f:h(22))}>22</option>
						<option ${f:select("end_hrs",f:h(23))}>23</option>

				</select>&nbsp;&nbsp;&nbsp;<select name="end_min" class="hour" id="end_min">
						<option ${f:select("end_min",f:h(""))}>Min</option>
						<option ${f:select("end_min",f:h(0))}>00</option>
						<option ${f:select("end_min",f:h(15))}>15</option>
						<option ${f:select("end_min",f:h(30))}>30</option>
						<option ${f:select("end_min",f:h(45))}>45</option>
				</select></td>
			</tr>
		
			<tr>
				<td>&nbsp;</td><td>
				<c:if test="${requestScope.initialLoad == true || requestScope.invalid == true}">
				
				<input type="hidden" name="actionParam" value="addShift">
				<input type="submit" value="Save" name="Create" title="Create" class="select1" > 
				<input type="reset"	value="Reset" name="Reset" title="Reset" class="select1">
				</c:if>
				<c:if test="${requestScope.invalid != true}">
					<input type="hidden" name="actionParam" value="confirm">
					<input type="submit" value="Confirm" name="Create" class="select1">
					<input type="button" value="Cancel" name="Cancel" title="Cancel" class="select1" onclick="cancelNavigation()">
				</c:if>
					
			</td>
			</tr>
		</table>
	</div>
	<br />
	<div id='shifts' class='aout' style="clear: left;"></div>
	<%-- 
	<table width="53%" bordercolor="black" id="results" class="display">
		<thead>
			<tr>
				<th width="12%" scope="col">#</th>
				<th width="39%" scope="col">Shift Name</th>
				<th width="39%" scope="col">Location Name</th>
				<th width="21%" scope="col">Start Time</th>
				<th width="28%" scope="col">End Time</th>
				<th width="28%" scope="col"></th>

			</tr>
		</thead>
		<tbody>
			<c:forEach var="shiftDto" items="${shiftList}">
				<tr>
					<td>${f:h(shiftDto.shiftId)}</td>
					<td>${f:h(shiftDto.shiftName)}</td>
					<td>${f:h(shiftDto.locationName)}</td>
					<td>${f:h(shiftDto.startTime)}</td>
					<td>${f:h(shiftDto.endTime)}</td>
					<td><a href="javascript:editShift(${f:h(shiftDto.shiftId)})">edit</a></td>
				</tr>

			</c:forEach>


		</tbody>

	</table>
	--%>
	<%
		if (request.getAttribute("initialLoad") != null) {
	%>
	<script>
			clearFields();
			  </script>
	<%
		}
	%>
	<input type="hidden"${f:hidden("shiftId")}>
</form>
<%@include file="common/footer.jsp"%>
<script>
//document.getElementById("shift_submenu").style.display='block';
</script>