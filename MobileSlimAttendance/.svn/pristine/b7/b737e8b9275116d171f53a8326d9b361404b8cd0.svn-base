<%@include file="common/common.jsp"%>
<%@include file="common/header.jsp"%>
</head>
<%@include file="common/pageUpper.jsp"%>
<div class='controlbox'>
<form method="post" action="createContractor">
	<input type="hidden" name="actionParam" value="createUser">
		<table width="100%" align="left" summary="Test" cellpadding="2px">
			<tr>
				<td width="30%">Contractor Details</td>
				<td width="70%">&nbsp;</td>
			</tr>
			<tr>
				<td width="30%">&nbsp;</td>
				<td width="70%">&nbsp;</td>
			</tr>
			<tr>
				<td><span>*</span>Company Name</td>
				<td><input type="text" ${f:text("contractorName")} ></td>
			</tr>
			
			<tr>
				<td valign="top"><span>*</span>Salutation</td>
				<td><select name="salutation" class="salutationSelect">
						<option value="Mr.">Mr.</option>
						<option value="Mrs.">Mrs.</option>
						<option value="Miss">Miss</option>
				</select></td>
			</tr>
			<tr>
				<td valign="top"><span>*</span>First Name</td>
				<td><input type="text" ${f:text("firstName")} 
					class="nameField"></td>
			</tr>
			<tr>
				<td valign="top"><span>*</span>Last Name</td>
				<td><input type="text" ${f:text("lastName")} 
					class="nameField"></td>
			</tr>
			<tr>
				<td><span>*</span>Telephone</td>
				<td><input type="text" ${f:text("phone")}
					class="zip"></td>
			</tr>
			<tr>
				<td><span>*</span>Cell Phone</td>
				<td><input type="text" ${f:text("cell")}
					class="zip"></td>
			</tr>
			<tr>
				<td><span>*</span>Email Address</td>
				<td><input type="text" ${f:text("userName")}  ></td>
			</tr>
			<tr>
				<td></td>
				<td>Email Address will be used as Username for the application</td>
			</tr>


			<tr>
				<td valign="top"><span>*</span>Address Line 1</td>

				<td><input type="text" ${f:text("line1")}   ></td>
			</tr>
			<tr>
				<td valign="top"><span>*</span>Address Line 2</td>

				<td><input type="text" ${f:text("line2")} ></td>
			</tr>
			<tr>
				<td valign="top"><span>*</span>City</td>
				<td><input type="text" ${f:text("city")}
					class="cityField"></td>
			</tr>
			<tr>
				<td valign="top"><span>*</span>Country</td>
				<td><select name="country" class="countrySelect" id="country">
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
						<select class="stateSelect" name="state">
							<option value="">Select State</option>
						</select>
				</td>
				</div>
			</tr>
			<tr>
				<td><span>*</span>Zip</td>
				<td><input type="text" ${f:text("pinCode")}
					class="zip"></td>
			</tr>
			<tr>
			<tr>
				<td>&nbsp;</td>
				<td align="left"><input type="submit" 
					value="Create" name="Create" title="Create" class="select1">
					<input type="reset" value="Reset" name="Reset" title="Reset"
					class="select1"></td>
			</tr>

		</table>
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
															str = str
																	+ '</select>';
															$('#stateDiv')
																	.html(str);
														});

									}
								});
			});
		</script>
</form>
</div>
<%@include file="common/footer.jsp"%>

