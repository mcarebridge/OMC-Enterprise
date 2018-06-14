<%@include file="common/common.jsp"%>
<%@include file="common/header.jsp"%>
<!-- start header -->
<script>

	function clearFields() {

		document.forms[0].elements['locationName'].value = "";
		document.forms[0].elements['line1'].value = "";
		document.forms[0].elements['line2'].value = "";
		document.forms[0].elements['city'].value = "";
		document.forms[0].elements['country'].value = "";
		document.forms[0].elements['state'].value = "";
		document.forms[0].elements['pinCode'].value = "";
		document.forms[0].elements['latitude'].value = "";
		document.forms[0].elements['longitude'].value = "";
	}
	
	function addHolidays()
	{
		document.forms[0].actionParam.value = "addHolidayForLocation";
		document.forms[0].action = "addHolidayForLocation";
		document.forms[0].submit();		
	}
	function editLocation(locationId) {
		document.forms[0].action='editLocation';
		document.forms[0].elements['actionParam'].value='editLocation';
		document.forms[0].elements['locationId'].value=locationId;
		document.forms[0].submit();
		
		
	}
	function setDefaultTimezone() {
		
		var opts = document.forms[0].elements['timezone'].options;
		var dt =new Date();
		var defaultTimeZoneOffset = -dt.getTimezoneOffset();
		
		var len=opts.length;
		for(cnt=0;cnt<len;cnt++)
		 {
			var optionValue=opts[cnt].value;
			var arr = optionValue.split('$');
			var offset = arr[1]*1;
			if(offset==defaultTimeZoneOffset) {
				document.forms[0].elements['timezone'].value=optionValue;
				break;
			}
		 }
		
		
	}
</script>
<!--Load the AJAX API-->
<script type="text/javascript" src="https://www.google.com/jsapi"></script>
<script type="text/javascript">
    var i =0;
	google.load('visualization', '1', {packages:['table, charteditor,corechart']});
  	google.setOnLoadCallback(drawVisualization);
<!-- Load Tables -->
		function drawVisualization() {
		  // Create and populate the data table.
		  var data = new google.visualization.DataTable();
		  data.addColumn('string', 'Location Name');//0
		  data.addColumn('string', 'Status');//1
		  data.addColumn('string', 'City'); //2
		  data.addColumn('string', 'Pincode');//3 		  
		  data.addColumn('string', 'State');//4 
		  data.addColumn('string', 'Country');//5 
		  data.addColumn('string', 'Timezome');//6
		  data.addColumn('string', 'Update');//7
		 
		 
		  
		  <c:forEach var="locationDto" items="${locationList}">
		  	data.addRows(1);
	  		data.setCell(i, 0,"${f:h(locationDto.locationName)}");
	  		data.setCell(i, 1,"${f:h(locationDto.status)}");
	  		data.setCell(i, 2,"${f:h(locationDto.city)}");
	  		data.setCell(i, 3,"${f:h(locationDto.pinCode)}");
	  		data.setCell(i, 4,"${f:h(locationDto.state)}");
	  		data.setCell(i, 5,"${f:h(locationDto.countryName)}");
	  		data.setCell(i, 6,"${f:h(locationDto.timezone)}");
	  		data.setCell(i, 7,"<a href='javascript:editLocation(${f:h(locationDto.locationId)});'>edit</a>");
	  		i++;
	  	</c:forEach>
	  	
	  	 var table = new google.visualization.Table(document.getElementById('locations'));
	  	 table.draw(data, {allowHtml: true, showRowNumber: true, page:'enable', pageSize : 10, sortAscending:true, sortColumn:0});	  	
	  	 
	  	 if(i>0) {
	  		 document.getElementById("addHoliday").disabled=false;
	  	 }
		}
		
		function getlatlon() {
			window.open("http://www.getlatlon.com")
		}
		
</script>
</head>
<%@include file="common/pageUpper.jsp"%>
<form method="post" action="addLocation">
	<input type="hidden" name="counter" value="${sessionScope['counter']}">
	<input type="hidden" name="counter" value="${sessionScope['counter']}">
	<input type="hidden" name="actionParam" value="addLocation">
	<!--  <table width="97%" align="left" summary="Test" cellpadding="2px">-->
	<div class='controlbox'>
		<table width="100%" cellpadding="0" cellspacing="0" align="center"
			border="1">
			<tr>
				<td width="30%">&nbsp;</td>
				<td width="70%">&nbsp;</td>
			</tr>
			<tr>
				<td align="right" valign="middle">Location Name <span>*</span></td>
				<td align="left"><input type="text" ${f:text("locationName")}></td>
			<tr>
				<td align="right" valign="middle">Address Line 1 <span>*</span></td>

				<td align="left"><input type="text" ${f:text("line1")}
					cols="49"></td>
			</tr>
			<tr>
				<td align="right" valign="middle">Address Line 2 <span>&nbsp;&nbsp;</span></td>

				<td class="lebel" align="left"><input type="text"
					${f:text("line2")} cols="49"></td>
			</tr>
			<tr>
				<td align="right" valign="middle">City <span>*</span></td>
				<td align="left"><input type="text" ${f:text("city")}></td>
			</tr>
			<tr>
				<td align="right" valign="middle">Country <span>*</span></td>
				<td align="left"><select name="country" id="country">
						<option value="">Select Country</option>
						<c:forEach var="e" items="${sessionScope.countryList}">
							<option ${f:select("country",f:h(e.key.id))}>${f:h(e.countryName)}</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td align="right" valign="middle">State <span>*</span></td>
				<td align="left">
					<div id="stateDiv">
						<select name="state">
							<option value="">Select State</option>
							<c:forEach var="e" items="${requestScope.stateList}">
								<option ${f:select("state",f:h(e.key.id))}>${f:h(e.stateName)}</option>
							</c:forEach>
						</select>
					</div>
				</td>
			</tr>
			<tr>
				<td align="right" valign="middle">Zip <span>*</span></td>
				<td align="left"><input type="text" ${f:text("pinCode")}
					size="20" class="zip"></td>
			</tr>

			<tr>
				<td align="right" valign="middle">Timezone <span>*</span></td>
				<td align="left"><select name="timezone" id="timezone">
						<option value="">Select Timezone</option>
						<c:forEach var="e" items="${sessionScope.timeZoneList}">
							<option ${f:select("timezone",f:h(e.timeZoneId))}>${f:h(e.description)}</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td align="right" valign="middle">Latitude <span>*</span></td>
				<td align="left"><input type="text" ${f:text("latitude")}
					size="20" class="zip">&nbsp;&nbsp; Ex. 21.013321
					&nbsp;&nbsp;&nbsp;<a href="javascript:getlatlon();">Get
						Latitude & Longitude</a></td>
			</tr>
			<tr>
				<td align="right" valign="middle">Longitude <span>*</span></td>
				<td align="left"><input type="text" ${f:text("longitude")}
					size="20" class="zip">&nbsp;&nbsp; Ex. 75.563972</td>
			</tr>
			<tr>

				<td colspan="2">
					<table>
						<tr>
							<td>&nbsp;</td>
							<td align="left"><input type="submit" width="100px"
								value="Save" name="Create" title="Create" class="select1">
								<input type="button" value="Reset" name="Reset" title="Reset"
								class="select1"></td>
							<td><input type="button" width="100px" value="Add Holidays"
								name="addHoliday" id="addHoliday" title="Add Holidays"
								disabled="disabled" class="select1"
								onClick='javascript:addHolidays();' /></td>

						</tr>
					</table>
				</td>
			</tr>
		</table>
	</div>
	<br />
	<%-- 
	<div class="aout">
	<table cellspacing="2" cellpadding="0" border="0" Width="70%" align="center">
		<thead>
			<tr>
				<th width="7%" scope="col">#</th>
				<th width="25%" scope="col">Location Name</th>
				<th width="14%" scope="col">Status</th>
				<th width="22%" scope="col">City</th>
				<th width="13%" scope="col">Pin Code</th>
				<th width="19%" scope="col">State</th>
				<th width="19%" scope="col">TimeZone</th>
				<th width="19%" scope="col"></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="locationDto" items="${locationList}">
				<tr>
					<td>${f:h(locationDto.locationId)}</td>
					<td>${f:h(locationDto.locationName)}</td>
					<td>${f:h(locationDto.status)}</td>
					<td>${f:h(locationDto.city)}</td>
					<td>${f:h(locationDto.pinCode)}</td>
					<td>${f:h(locationDto.state)}</td>
					<td>${f:h(locationDto.timezone)}</td>
					<td><a
						href="javascript:editLocation(${f:h(locationDto.locationId)})">edit</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	</div>
	--%>
	<div id="locations" class="aout" style="clear: left;"></div>

	<input type="hidden" ${f:hidden("companyId")}>
	<!-- start footer -->
	<script type="text/javascript">
		$(function() {
			$('#country')
					.change(
							function() {
								var val = $(this).val();
								if (val != '') {

									$
											.getJSON(
													"jsonRequest?actionParam=stateListRequest&countryId="
															+ val,
													function(data) {

														var str = '';
														var str = '<select class="stateSelect" name="state" >';
														for (cnt = 0; cnt < data.stateList.length; cnt++) {
															str = str
																	+ '<option value='+data.stateList[cnt].stateId+'>'
																	+ data.stateList[cnt].stateName
																	+ '</option>';
														}
														str = str + '</select>';
														$('#stateDiv')
																.html(str);
													});

								}
							});
		});
	</script>
	<%
		if (request.getAttribute("initialLoad") != null) {
	%>
	<script type="text/javascript">
		clearFields();
	</script>

	<%
		}
	%>
	<input type="hidden" name="locationId">
</form>
<script>
	setDefaultTimezone();
</script>
<%@include file="common/footer.jsp"%>

<script>
//document.getElementById("location_submenu").style.display='block';
</script>