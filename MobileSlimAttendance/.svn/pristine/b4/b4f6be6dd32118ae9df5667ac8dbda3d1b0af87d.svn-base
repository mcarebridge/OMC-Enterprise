<%@include file="common/common.jsp"%>
<%@include file="common/header.jsp"%>
<script>
	function navigateCancel() {
		document.forms[0].action = "addLocation";
		document.forms[0].submit();
	}
	function updateLocation() {
		document.forms[0].elements['country'].disabled = false;
		document.forms[0].elements['state'].disabled = false;
		document.forms[0].elements['city'].disabled = false;
		document.forms[0].submit();
	}
	function getlatlon() {
		window.open("http://www.getlatlon.com")
	}
</script>
</head>
<%@include file="common/pageUpper.jsp"%>
<form method="post" action="editLocation">
	<input type="hidden" name="actionParam" value="updateLocation">
	<table width="70%" cellpadding="0" cellspacing="0" align="center"
		border="1">
		<tr>
			<td width="30%">&nbsp;</td>
			<td width="70%">&nbsp;</td>
		</tr>
		<tr>
			<td align="right" valign="middle"> <span>*</span>Location Name</td>
			<td align="left"><input type="text"${f:text("locationName")}></td>
		<tr>
			<td align="right" valign="middle"><span>*</span>Address Line 1 </td>

			<td align="left"><input type="text"
				${f:text("line1")}   ></td>
		</tr>
		<tr>
			<td align="right" valign="middle"><span>&nbsp;</span>Address Line 2</td>

			<td class="lebel" align="left"><input type="text"
				${f:text("line2")} ></td>
		</tr>
		<tr>
			<td align="right" valign="middle"><span>*</span>City</td>
			<td align="left"><input type="text"
				${f:text("city")}  disabled="disabled"></td>
		</tr>
		<tr>
			<td align="right" valign="middle"><span>*</span>Country</td>
			<td align="left"><select name="country" id="country"
				disabled="disabled">
					<option value="">Select Country</option>
					<c:forEach var="e" items="${sessionScope.countryList}">
						<option ${f:select("country",f:h(e.key.id))}>${f:h(e.countryName)}</option>
					</c:forEach>
			</select></td>
		</tr>
		<tr>
			<td align="right" valign="middle"><span>*</span>State</td>
			<td align="left">
				<div id="stateDiv">
					<select class="stateSelect" name="state" disabled="disabled">
						<option value="">Select State</option>
						<c:forEach var="e" items="${requestScope.stateList}">
							<option ${f:select("state",f:h(e.key.id))}>${f:h(e.stateName)}</option>
						</c:forEach>
					</select>
			</td>
			</div>
		</tr>
		<tr>
			<td align="right" valign="middle"><span>*</span>Zip</td>
			<td align="left"><input type="text"
				${f:text("pinCode")}  size="20" class="zip"></td>
		</tr>
		<tr>
			<td align="right" valign="middle"><span>*</span>Timezone</td>
			<td align="left"><select name="timezone" id="timezone">
					<option value="">Select Timezone</option>
					<c:forEach var="e" items="${sessionScope.timeZoneList}">
						<option ${f:select("timezone",f:h(e.timeZoneId))}>${f:h(e.description)}</option>
					</c:forEach>
			</select></td>
		</tr>
       <tr>
			<td align="right" valign="middle">Latitude <span>*</span></td>
			<td align="left"><input type="text"
				${f:text("latitude")}  size="20" class="zip">&nbsp;&nbsp; Ex. 21.013321 &nbsp;&nbsp;&nbsp;<a href="javascript:getlatlon();">Get Latitude & Longitude</a> </td>
		</tr>
		<tr>
			<td align="right" valign="middle">Longitude <span>*</span></td>
			<td align="left"><input type="text"
				${f:text("longitude")}  size="20" class="zip">&nbsp;&nbsp; Ex. 75.563972</td>
		</tr>

		<tr>
		<td align="right" valign="middle" height="31"><span>*</span>Status</td>
		<td valign="top" align="left"><input type="radio"
			${f:radio("active", "Y")}   class="choice" />Active &nbsp;&nbsp;<input
			type="radio" ${f:radio("active", "N")}  class="choice" />Inactive</td>
		</tr>
		<tr>
			<td>&nbsp;</td>
			<td align="left"><input type="button" value="Save"
				name="Create" title="Create" class="select1"
				onclick="javascript:updateLocation();"> <input
				type="button" value="Cancel" name="Cancel" title="Cancel"
				class="select1" onclick="javascript:navigateCancel();"></td>
		</tr>
	</table>
	<input type="hidden"${f:hidden("companyId")}> <input
		type="hidden"${f:hidden("locationId")}>
	<!-- start footer -->
</form>
<%@include file="common/footer.jsp"%>

