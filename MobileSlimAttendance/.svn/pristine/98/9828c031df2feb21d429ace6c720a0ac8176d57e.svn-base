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
   	function enablePasskeyField() {
		if (document.forms[0].elements['isSuperwiser'][0].checked == true) {

			document.forms[0].elements['imeiCode'].disabled = false;
			document.getElementById("msgdiv").style.display = "inline-block";
		} else {

			document.forms[0].elements['imeiCode'].disabled = true;
			document.forms[0].elements['imeiCode'].value = '';
			document.getElementById("msgdiv").style.display = "none";
		}

	}
	function enableEmailField() {
		
		
		if(document.forms[0].elements['isManager'][0].checked==true) {
		
			document.forms[0].elements['emailId'].disabled=false;
			document.forms[0].elements['isSuperwiser'][0].disabled = true;
			document.forms[0].elements['isSuperwiser'][1].disabled = true;
			document.forms[0].elements['isSuperwiser'][1].checked = true;
			document.forms[0].elements['imeiCode'].disabled = true;
			document.forms[0].elements['imeiCode'].value = '';
		} else {			
			document.forms[0].elements['emailId'].disabled=true;		
			document.forms[0].elements['emailId'].value='';	
			document.forms[0].elements['isSuperwiser'][0].disabled = false;
			document.forms[0].elements['isSuperwiser'][1].disabled = false;
			
		}
		
	}
	function setWeeklyOfCheckBox() {
		var chkValues = document.forms[0].elements['dayOfWeeklyOffStr'].value;
		var chkValArr = chkValues.split(',');
		var chkBoxes = document.forms[0].elements['dayOfWeeklyOff'];
		for (cnt1 = 0; cnt1 < chkValArr.length; cnt1++) {

			for (cnt2 = 0; cnt2 < chkBoxes.length; cnt2++) {
				if (chkValArr[cnt1] == chkBoxes[cnt2].value) {
					chkBoxes[cnt2].checked = true;
				}
			}
		}
	}
	function navigateCancel() {
		document.forms[0].action = "employeeList";
		document.forms[0].submit();
	}

	function enableEmpType() {

		document.forms[0].elements['employeeType'].disabled = false;
	}
</script>
</head>
<%@include file="common/pageUpper.jsp"%>

<form method="post" action="editEmployee"
	onsubmit="javascript:enableEmpType();">
	<input type="hidden" name="actionParam" value="updateEmployee">
	<!-- start page -->


	<table width="90%" cellpadding="0" cellspacing="0" align="center" border="1">
		<tr>
			<td width="30%">&nbsp;</td>
			<td width="70%">&nbsp;</td>
		</tr>
		<tr>
			<td valign="top">Start Date</td>
			<td><input type="text" ${f:text("startDate")}
				readonly="readonly" id="datepicker" class="dateField"></td>
		</tr>
		<tr>
			<td valign="top">Employee Id</td>

			<td><input type="text" ${f:text("companyEmpId")}
				readonly="readonly"></td>
		</tr>

		<tr>
			<td valign="top">Employee Type</td>
			<td><select name="employeeType" id="employeeType"
				class="employeeType" disabled="disabled">

					<option ${f:select("employeeType","")}>Select</option>
					<option ${f:select("employeeType","1")}>Permanent Employee</option>
					<option ${f:select("employeeType","2")}>Contractor
						Employee</option>
					<option ${f:select("employeeType","3")}>Individual
						Contractor</option>

			</select></td>
		</tr>

		<tr id="contractorTr" style="display: none;">
			<td valign="top">Contractor</td>
			<td>
				<div id="contractordiv"></div>
			</td>
		</tr>

		<tr>
			<td class="lebel" valign="top">Employee Skill</td>
			<td align="left"><select name="skill" class="countrySelect"
				id="skill">
					<option value="">Select Skill</option>
					<c:forEach var="e" items="${requestScope.skillList}">
						<option ${f:select("skill",f:h(e.key.id))}>${f:h(e.skill)}</option>
					</c:forEach>
			</select></td>
		</tr>

		<tr>
			<td valign="top">Salutation</td>
			<td><select name="salutation" class="salutationSelect">

					<option ${f:select("salutation","Mr.")}>Mr.</option>
					<option ${f:select("salutation","Mrs.")}>Mrs.</option>
					<option ${f:select("salutation","Ms.")}>Ms.</option>

			</select></td>
		</tr>
		<tr>
			<td valign="top">First Name</td>
			<td><input type="text" ${f:text("firstName")} size="50"
				class="nameField"></td>
		</tr>
		<tr>
			<td valign="top">Last Name</td>
			<td><input type="text" ${f:text("lastName")} size="50"
				class="nameField"></td>
		</tr>
		<tr>
			<td valign="top">City</td>
			<td><select name="city" id="city">
					<option value="">Select city</option>
					<c:forEach var="e" items="${requestScope.cities}">
						<option ${f:select("city",f:h(e))}>${f:h(e)}</option>
					</c:forEach>
			</select></td>
		</tr>
		<tr>
			<td valign="top">Gender</td>
			<td valign="top"><input type="radio" ${f:radio("gender", "M")}
				class="choice" />Male &nbsp;&nbsp;<input type="radio"
				${f:radio("gender", "F")} class="choice" />Female</td>
		</tr>
		<%-- 
					<tr>
						<td>Min Daily Working Hrs</td>
						<td><select name="minWorkingHrsPerDay"
							class="workingHrsSelect">
								<option ${f:select("minWorkingHrsPerDay","")}>Select</option>
								<option ${f:select("minWorkingHrsPerDay","8")}>8</option>
								<option ${f:select("minWorkingHrsPerDay","9")}>9</option>
								<option ${f:select("minWorkingHrsPerDay","10")}>10</option>
								<option ${f:select("minWorkingHrsPerDay","11")}>11</option>
								<option ${f:select("minWorkingHrsPerDay","12")}>12</option>
						</select></td>
					</tr> --%>
		<tr>
			<td>No of Working Days</td>
			<td><select name="numOfWorkingDays" class="workingDaySelect">
					<option ${f:select("numOfWorkingDays","")}>Select</option>
					<option ${f:select("numOfWorkingDays","5")}>5</option>
					<option ${f:select("numOfWorkingDays","6")}>6</option>
			</select></td>
		</tr>
		<tr>
			<td>Weekly Off</td>
			<td><input name="dayOfWeeklyOff" type="checkbox" value="0">Sunday
				<input name="dayOfWeeklyOff" type="checkbox" value="1">Monday
				<input name="dayOfWeeklyOff" type="checkbox" value="2">Tuesday
				<input name="dayOfWeeklyOff" type="checkbox" value="3">Wednesday
				<input name="dayOfWeeklyOff" type="checkbox" value="4">Thursday
				<input name="dayOfWeeklyOff" type="checkbox" value="5">Friday
				<input name="dayOfWeeklyOff" type="checkbox" value="6">Saturday</td>
		</tr>
		<tr>
			<td valign="top">Is a Manager ?</td>
			<td valign="top"><input type="radio" class="choice"
				${f:radio("isManager", "Y")} onclick="javascript:enableEmailField();" />Manager &nbsp;&nbsp;<input
				type="radio" ${f:radio("isManager", "N")} class="choice" 
				onclick="javascript:enableEmailField();" value="N" />Not a Manager</td>
		</tr>
		<tr>
			<td valign="top">Email Id</td>
			<td><input type="text" ${f:text("emailId")} size="15"
				class="nameField" disabled="disabled"></td>
		</tr>
		<tr>
			<td valign="top">&nbsp;</td>
			<td valign="top"><input type="radio"
				${f:radio("isSuperwiser", "Y")} class="choice"
				onclick="javascript:enablePasskeyField();" />Supervisor
				&nbsp;&nbsp;<input type="radio" ${f:radio("isSuperwiser", "N")}
				class="choice" onclick="javascript:enablePasskeyField();" />Not a
				Supervisor
				<div style="display: none;" id="msgdiv">
					&nbsp;&nbsp;<b> <font color="red">Please assign a valid
							shift to a Supervisor.</font></b>
				</div></td>
		</tr>
		<tr>
			<td valign="top">IMEI Code</td>
			<td><input type="text" name="imeiCode" ${f:text("imeiCode")}
				size="15" class="nameField" disabled="disabled"></td>
		</tr>

		<tr>
			<td valign="top"></td>
			<td><input type="checkbox" value="N" name="active">
				Make Inactive</td>
		</tr>
		<tr>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<td colspan='2' align="left"><input type="submit" width="100px"
				value="Update" name="Update" title="Update" class="select1">
				<input type="button" value="Cancel" name="Cancel" title="Cancel"
				class="select1" onclick="javascript:navigateCancel();"></td>
		</tr>

	</table>


	<!-- end page -->
	<input type="hidden" ${f:hidden("companyId")} id="companyId"> <input
		type="hidden" ${f:hidden("dayOfWeeklyOffStr")}>

</form>

<script>
	enableEmailField();
	setWeeklyOfCheckBox();
	enablePasskeyField();
	document.getElementById("msgdiv").style.display = "none";
</script>

<script>
	$(function() {
		$("#datepicker").datepicker({
			showOn : "button",
			buttonImage : "images/calendar.gif",
			buttonImageOnly : true
		});
	});

	$('#employeeType')
			.change(
					function() {

						var val = $(this).val();
						if (val != '' && val == 2) {
							var companyId = $("#companyId").val();
							$
									.getJSON(
											"jsonRequest?actionParam=contractorListRequest&companyId="
													+ companyId,
											function(data) {

												var str = '';
												var str = '<select class="shiftSelect" name="contractorCompany" >';
												for (cnt = 0; cnt < data.contractorList.length; cnt++) {
													str = str
															+ '<option value='+data.contractorList[cnt].contractorId+'>'
															+ data.contractorList[cnt].contractorName
															+ '</option>';
												}
												str = str + '</select>';
												$('#contractordiv').html(str);
												document
														.getElementById('contractorTr').style.display = 'block';

											});

						} else {
							document.getElementById('contractorTr').style.display = 'none';
						}
					});
</script>

<!-- start footer -->
<%@include file="common/footerWithMenu.jsp"%>

