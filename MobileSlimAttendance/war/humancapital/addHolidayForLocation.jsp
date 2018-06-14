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
<script>
	function loadHolidays() {
		
		
		var location = document.getElementById("location");
		var locationId = location.options[location.selectedIndex].value;
		if(locationId!=null && locationId!='') {
		//document.forms[0].locationId.value = locationId;
		document.forms[0].actionParam.value = 'loadHolidays';
		document.forms[0].submit();
		}
	}

	function createHolidays() {
		
		var location = document.getElementById("location");
		var locationId = location.options[location.selectedIndex].value;
		//document.forms[0].locationId.value = locationId;
		document.forms[0].actionParam.value = 'createHolidays';
		document.forms[0].submit();
	}

	function createLocationHolidays() {
		var location = document.getElementById("location");
		//var locationId = location.options[location.selectedIndex].value;
		//document.forms[0].locationId.value = locationId;
		document.forms[0].actionParam.value = 'createLocationHolidays';
		document.forms[0].submit();
	}
</script>
</head>
<%@include file="common/pageUpper.jsp"%>

<form method="post" action="addHolidayForLocation">
	<!-- start content -->
	<input type="hidden" name="actionParam" value="">
	<div class='controlbox' style="width: 100%;">
		<table  width="60%" cellpadding="0" cellspacing="0" align="left"
		border="1">
			<tr>
				<td>Select a Location</td>
				<td align="left"><select name="location" class="countrySelect"
					id="location" onchange='javascript:loadHolidays();'>
						<option value="">Select Location</option>
						<c:forEach var="e" items="${sessionScope.locationList}">
							<option ${f:select("location",f:h(e.key.id))}>${f:h(e.locationName)}</option>
						</c:forEach>
				</select></td>
				<td align="left"><input type="button" 
					value="Add Holidays" name="Create" title="Create" class="select1"
					onClick='javascrip:createHolidays();'> <input type="button"
					value="Reset" name="Reset" title="Reset" class="select1"></td>
			</tr>
		</table>
	</div>
	<div id='companyHolidays' class='aout'
		style=" width: 100%; margin: 15px 0 10px 0; height: 190px; overflow-y:auto; clear:left;">
		<table>
			<tr>
				<th></th>
				<th>Date</th>
				<th>Company Holiday</th>
			</tr>
			<tr>
				<c:forEach var="ch" items="${countryHolidays}">
					<tr>
						<td><input type="checkbox" name="holidayId"
							value="${f:h(ch.key.id)}"
							<c:if test="${fn:containsIgnoreCase(requestScope.selectedHolidays,ch.key.id)}">
														checked="yes" disabled='true'
													</c:if> />
						</td>
						<td><fmt:formatDate value="${ch.holidayDate}" type="date"
								dateStyle="short" pattern="MMM-dd-yyyy" /></td>
						<td>${f:h(ch.holidayDesc)}</td>
					</tr>

				</c:forEach>
			</tr>
		</table>
	</div>
		<div class='controlbox'>
		<table>
			<tr>
				<th>Add Location specific Holidays</th>
				<th></th>
			</tr>
			<tr>
				<td>Date of Holiday</td>
				<td><input type="text" name="holidayDate" size="12" value=""
					readonly="readonly" id="holidaydatepicker"></td>
			</tr>
			<tr>
				<td>Holiday</td>
				<td><input type='text' name='locationSpecificHoliday' value='' />
				</td>
			</tr>
			<tr>
				<td></td>
				<td><input type='button' name='addLocationHoliday' class='select1'
					value='Add Holiday'
					onClick='javascript:createLocationHolidays();' /></td>
			</tr>
		</table>
	</div>
	<div class='aout' style="width='100%' border: 1px; margin: 15px 0 0 0; height: 190px; overflow-y:auto">
		<table>
			<tr>
				<th></th>
				<th>Date</th>
				
				<th>Location Holiday</th>
			</tr>
			<c:forEach var="lh" items="${locationHolidays}">
				<c:choose>
					<c:when test="${lh.locationHolidayDate != null}">
						<tr>
							<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
							<td><fmt:formatDate value="${lh.locationHolidayDate}"
									type="date" dateStyle="short" pattern="MMM-dd-yyyy" /></td>
							<td>${f:h(lh.locationHolidayDesc)}</td>
						</tr>
					</c:when>
				</c:choose>
			</c:forEach>
		</table>
	</div>
</form>
<script>
	$(function() {
		$("#holidaydatepicker").datepicker({
			showOn : "button",
			buttonImage : "images/calendar.gif",
			buttonImageOnly : true
		});
	});
</script>
<%@include file="common/footer.jsp"%>

