<%@include file="common/common.jsp"%>
<%@include file="common/header.jsp"%>
<script>
	function clearFields() {

		document.forms[0].elements["firstName"].value = "";
		document.forms[0].elements['lastName'].value = "";
		document.forms[0].elements['company'].value = "";
		document.forms[0].elements['contact'].value = "";
		document.forms[0].elements['registerEmail'].value = "";
		document.forms[0].elements['alternateEmail'].value = "";
		document.forms[0].elements['city'].value = "";
		document.forms[0].elements['country'].value = "";
		document.forms[0].elements['state'].value = "";

	}
</script>
</head>
<%@include file="common/pageUpper.jsp"%>
<body>
	<div
		style="width: 75%; height: 15px; border: 0px solid red; margin: 15px 0 0 0; position: relative;">
		<form method="post" action="helpDesk">
			
				
			<table align="left" summary="Test" cellpadding="2px">
				<tr>
					<td valign="top"><span>*</span>Salutation</td>
					<td><select name="salutation">

							<option ${f:select("salutation","Mr.")}>Mr.</option>
							<option ${f:select("salutation","Mrs.")}>Mrs.</option>
							<option ${f:select("salutation","Miss.")}>Miss</option>
					</select></td>
				</tr>
				<tr>
					<td><span>*</span> First Name:</td>
					<td><input type="text" ${f:text("firstName")}></td>
				</tr>
				<tr>
					<td valign="top"><span>*</span>Last Name</td>
					<td><input type="text" ${f:text("lastName")}></td>
				</tr>
				<tr>
					<td><span>*</span> Company Name:</td>
					<td><input type="text" ${f:text("company")}></td>
				</tr>
				<tr>
					<td><span>*</span> Registered Email address:</td>
					<td><input type="text" ${f:text("registerEmail")}></td>
				</tr>
				<tr>
					<td><span>*</span> Alternate Email address:</td>
					<td><input type="text" ${f:text("alternateEmail")}></td>
				</tr>
				<tr>
					<td><span>*</span> Contact no:</td>
					<td><input type="text" ${f:text("contact")}></td>
				</tr>
				<tr>
					<td></td>
					<td>&nbsp; Accepted formats
						(001)123-456-7890,001-123-456-7890, 0011234567890,
						(001)-(123)-456-7890)</td>
				</tr>
				<tr>
					<td valign="top"><span>*</span>City</td>
					<td><input type="text" ${f:text("city")}></td>
				</tr>
				<tr>
					<td valign="top"><span>*</span>Country</td>
					<td><select name="country" id="country">
							<option value="">Select Country</option>
							<c:forEach var="e" items="${sessionScope.countryList}">
								<option ${f:select("country",f:h(e.key.id))}>${f:h(e.countryName)}</option>
							</c:forEach>
					</select></td>
				</tr>

				<tr>
					<td><span>*</span>State</td>
					<td>
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
					<td valign="top"><span>*</span>Comments :</td>
					<td><textarea name="comments" rows="4" cols="40"></textarea></td>
				</tr>
				<tr>
					<td colspan="2"><input type="hidden" name="actionParam"
						value="actionParam"> <input class="select1" type="submit"
						name="submit" value="Submit"> <input class="select1"
						type="button" onclick="clearFields()" value="Reset"> <input
						class="select1" type="submit" name="cancel" value="Cancel">
					</td>

				</tr>
			</table>
			<script type="text/javascript">
				$(function() {
					$('#country')
							.click(
									function() {

										var val = $(this).val();
										if (val != '') {

											$
													.getJSON(
															"jsonRequest?actionParam=stateListRequest&countryId="
																	+ val,
															function(data) {
																var str = '';
																var str = '<select  name="state" >';
																for (cnt = 0; cnt < data.stateList.length; cnt++) {
																	str = str
																			+ '<option value='+data.stateList[cnt].stateId+'>'
																			+ data.stateList[cnt].stateName
																			+ '</option>';
																}
																str = str
																		+ '</select>';
																$('#stateDiv')
																		.html(
																				str);
															});
										}
									});
				});

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
																var str = '<select  name="state" >';
																for (cnt = 0; cnt < data.stateList.length; cnt++) {
																	str = str
																			+ '<option value='+data.stateList[cnt].stateId+'>'
																			+ data.stateList[cnt].stateName
																			+ '</option>';
																}
																str = str
																		+ '</select>';
																$('#stateDiv')
																		.html(
																				str);
															});
										}
									});
				});
			</script>
		</form>
	</div>

	<%@include file="common/footer.jsp"%>