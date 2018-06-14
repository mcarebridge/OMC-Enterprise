<%@include file="common/common.jsp"%>
<%@include file="common/header.jsp"%>
</head>
<%@include file="common/pageUpper.jsp"%>
<body>
	<div
		style="width: 100%; height: 15px; border: 0px solid red; margin: 15px 0 0 0">
		<form method="post" action="createAdminUser">
			<div class='controlbox'>
				<input type="hidden" name="actionParam" value="createUser">
				<table width="100%" align="left" summary="Test" cellpadding="2px">
					<tr>
						<td width="30%"
							style="font: bold 11px Verdana, Helvetica, Arial, sans-serif;">Admin
							User Details</td>
						<td width="70%">&nbsp;</td>
					</tr>
					<tr>
						<td width="30%">&nbsp;</td>
						<td width="70%">&nbsp;</td>
					</tr>
					<tr>
						<td valign="top"><span>*</span>Salutation</td>
						<td><select name="salutation">

								<option ${f:select("salutation","Mr.")}>Mr.</option>
								<option ${f:select("salutation","Mrs.")}>Mrs.</option>
								<option ${f:select("salutation","Ms.")}>Ms.</option>
						</select></td>
					</tr>
					<tr>
						<td valign="top"><span>*</span>First Name</td>
						<td><input type="text"${f:text("firstName")}></td>
					</tr>
					<tr>
						<td valign="top"><span>*</span>Last Name</td>
						<td><input type="text"${f:text("lastName")} ></td>
					</tr>
					<tr>
						<td valign="top"><span>*</span>Gender</td>
						<td valign="top"><input type="radio"
							${f:radio("gender", "M")} />Male &nbsp;&nbsp;<input type="radio"
							${f:radio("gender", "F")} />Female</td>
					</tr>
					<tr>
						<td><span>*</span>Telephone</td>
						<td><input type="text"${f:text("phone")}></td>
					</tr>
					<tr>
						<td></td>
						<td>&nbsp; Accepted formats (001)123-456-7890,
							001-123-456-7890, 0011234567890, (001)-(123)-456-7890)</td>
					</tr>
					<tr>
						<td><span>*</span>Cell Phone</td>
						<td><input type="text"${f:text("cell")}></td>
					</tr>
					<tr>
						<td></td>
						<td>&nbsp; Accepted formats
							(001)123-456-7890,001-123-456-7890, 0011234567890,
							(001)-(123)-456-7890)</td>
					</tr>
					<tr>
						<td><span>*</span>Email Address</td>
						<td><input type="text"${f:text("userName")}></td>
					</tr>
					<tr>
						<td></td>
						<td>Email Address will be used as Username for the
							application</td>
					</tr>
					<tr>
						<td><span>*</span>What is your profile</td>
						<td><select name="userProfile" id="userProfile">
								<option value="">Select Profile</option>
								<c:forEach var="e" items="${sessionScope.profileList}">
									<option ${f:select("userProfile",f:h(e.key.id))}>${f:h(e.userProfileDesc)}</option>
								</c:forEach>
						</select></td>
					</tr>
					<tr>
						<td><span>*</span>Are you going to control this operation?</td>
						<td valign="top"><input type="radio"
							${f:radio("operationFlag", "Y")} />Yes &nbsp;&nbsp;<input
							type="radio" ${f:radio("operationFlag", "N")} />No</td>
					</tr>
					<tr>
						<td><span>*</span>Company Name</td>
						<td><input type="text"${f:text("companyName")}></td>
					</tr>

					<tr>
						<td><span>*</span>Nature of Business</td>
						<td><select name="template" id="template">
								<option value="">Select</option>
								<c:forEach var="e" items="${templateList}">
									<option ${f:select("templateName",f:h(e.key.id))}>${f:h(e.templateName)}</option>
								</c:forEach>
						</select></td>
					</tr>
					<tr>
						<td><span>*</span>Employee population</td>
						<td><input type="text"${f:text("emplyoeePopulation")}>
						</td>
					</tr>

					<tr>
						<td valign="top"><span>*</span>Address Line 1</td>

						<td><input type="text"${f:text("line1")} ></td>
					</tr>
					<tr>
						<td valign="top"><span>*</span>Address Line 2</td>

						<td><input type="text"${f:text("line2")}></td>
					</tr>
					<tr>
						<td valign="top"><span>*</span>City</td>
						<td><input type="text"${f:text("city")}></td>
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
						<td><span>*</span>Zip</td>
						<td><input type="text"${f:text("pinCode")} ></td>
					</tr>
					<tr>
						<td><span>*</span>Please click here to accept <a href='javascript:openLicence()'>Terms and Licence</a></td>
						<td><input type="checkbox" name="licAgreement" value="Y"
							onClick='javascript:agreementAccept()'/>I agree.</td>
					</tr>
					<tr>
						<td></td>
						<td></td>
					</tr>
					<tr>
						<td>&nbsp;</td>
						<td align="left"><input class='select1' type="submit"
							width="100px" value="Create" name="Create" title="Create" disabled="disabled">
							<input type="reset" value="Reset" name="Reset" title="Reset"
							class='select1'></td>
					</tr>
				</table>
			</div>
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

				function agreementAccept() {
					var checkbox_val = document.forms[0].licAgreement.value;
					if (document.forms[0].licAgreement.checked == true) {
						document.forms[0].Create.disabled = false;
					} else {
						document.forms[0].Create.disabled = true;
					}
				}
				
				function openLicence()
				{					
					var URL = '/humancapital/documents/licence.html';
					var name = 'Terms and License';
					window.open(URL,'open_window','width=800,height=600,scrollbars=yes');
				}
				
			</script>
		</form>
	</div>
	<%@include file="common/footer.jsp"%>