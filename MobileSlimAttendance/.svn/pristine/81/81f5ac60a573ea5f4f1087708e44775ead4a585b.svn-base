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

<script>

function clearFields() {

	document.forms[0].elements['startDate'].value = "";
	document.forms[0].elements['employeeType'].value = "";
	document.forms[0].elements['skill'].value = "";
	document.forms[0].elements['firstName'].value = "";
	document.forms[0].elements['lastName'].value = "";
	document.forms[0].elements['gender'][0].checked = false;
	document.forms[0].elements['gender'][1].checked = false;
	document.forms[0].elements['companyEmpId'].value='';
	document.forms[0].elements['numOfWorkingDays'].value = "";
	document.forms[0].elements['imeiCode'].value = "";
	document.forms[0].elements['city'].value = "";
	document.forms[0].elements['emailId'].value = "";
	document.forms[0].elements['dayOfWeeklyOff'][0].checked = false;
	document.forms[0].elements['dayOfWeeklyOff'][1].checked = false;
	document.forms[0].elements['dayOfWeeklyOff'][2].checked = false;
	document.forms[0].elements['dayOfWeeklyOff'][3].checked = false;
	document.forms[0].elements['dayOfWeeklyOff'][4].checked = false;
	document.forms[0].elements['dayOfWeeklyOff'][5].checked = false;
	document.forms[0].elements['dayOfWeeklyOff'][6].checked = false;

	
	document.forms[0].elements['isSuperwiser'][0].checked = false;
	document.forms[0].elements['isSuperwiser'][1].checked = true;
 
	document.forms[0].elements['isManager'][0].checked = false;
	document.forms[0].elements['isManager'][1].checked = true;
	
	document.forms[0].elements['imeiCode'].disabled = true;
	
	document.getElementById("msgdiv").style.display=	"none";
	
	if(document.forms[0].elements['uniqueIdFlag'].value == "Y") 
	{ 
		document.getElementById('employeeIdTr').style.display = 'block';
		
	} else {
		document.getElementById('employeeIdTr').style.display = 'none';
	}
	
}
	function listAndPrint(_action) {
		//alert(_action);
		document.forms[0].actionParam.value = _action;
		document.forms[0].submit();
	}
	function enablePasskeyField() {
		if(document.forms[0].elements['isSuperwiser'][0].checked==true) {
		
			document.forms[0].elements['imeiCode'].disabled=false;
            document.getElementById("msgdiv").style.display=	"inline-block";		
			
		} else {
			
			document.forms[0].elements['imeiCode'].disabled=true;
		
			document.forms[0].elements['imeiCode'].value='';
			document.getElementById("msgdiv").style.display=	"none";
		}
		
	}
	function enableEmailField() {
		if(document.forms[0].elements['isManager'][0].checked==true) {
		
			document.forms[0].elements['emailId'].disabled=false;
			document.forms[0].elements['isSuperwiser'][0].disabled = true;
			document.forms[0].elements['isSuperwiser'][1].disabled = true;
			document.forms[0].elements['isManager'][1].checked==true;
		} else {			
			document.forms[0].elements['emailId'].disabled=true;		
			document.forms[0].elements['emailId'].value='';	
			document.forms[0].elements['isSuperwiser'][0].disabled = false;
			document.forms[0].elements['isSuperwiser'][1].disabled = false;
			document.forms[0].elements['isManager'][1].checked==true;
		}
		
	}
	function setPartialEmployeeId() {
		if(document.forms[0].elements['uniqueIdFlag'].value=='Y' && document.forms[0].elements['employeeType'].value !=2) {
				document.forms[0].elements['empCompanyId'].value= document.forms[0].elements['companyId'].value +"-"; 
				document.getElementById("companyIdSpan").innerHTML=document.forms[0].elements['companyId'].value+"-";
				document.getElementById('employeeIdTr').style.display = 'block';
		} else if(document.forms[0].elements['contractorUniqueIdFlag'].value == "Y" && document.forms[0].elements['employeeType'].value ==2) 
		{ 
			 document.getElementById("companyIdSpan").innerHTML=document.forms[0].elements['empCompanyId'].value;
			 document.getElementById('employeeIdTr').style.display = 'block';
		} else {
			document.getElementById('employeeIdTr').style.display = 'none';
		}
		
	}
	
	function setContracotrPartialEmployeeId(companyId) {
		   
		    if( document.forms[0].elements['contractorUniqueIdFlag'].value == "Y" && null!=companyId && companyId!='') {
		    	document.getElementById('employeeIdTr').style.display = 'block';
		    	document.forms[0].elements['empCompanyId'].value= companyId +"-"; 
			    document.getElementById("companyIdSpan").innerHTML=companyId+"-";
			    
		    }
	}
	
	
	function setWeeklyOfCheckBox() {
		var chkValues= document.forms[0].elements['dayOfWeeklyOffStr'].value;
		
		var chkValArr = chkValues.split(',') ;
		var chkBoxes= document.forms[0].elements['dayOfWeeklyOff'];
		
		for(cnt1=0;cnt1<chkValArr.length;cnt1++) {
			
			for(cnt2=0;cnt2<chkBoxes.length;cnt2++)
		    {
		    	if(chkValArr[cnt1]== chkBoxes[cnt2].value)
		    	{
		    		chkBoxes[cnt2].checked=true;
		    		
		    	}
		    }
		}
		
		if(document.forms[0].elements['employeeType'].value ==2) {
			
			document.getElementById('contractorTr').style.display = 'block';
			if(document.forms[0].elements['contractorUniqueIdFlag'].value == "Y") 
			{ 
				document.getElementById('employeeIdTr').style.display = 'block';
				
			}
		}
		else if(document.forms[0].elements['employeeType'].value ==1 || document.forms[0].elements['employeeType'].value ==3) {
			
			if(document.forms[0].elements['uniqueIdFlag'].value == "Y") 
			{ 
				document.getElementById('employeeIdTr').style.display = 'block';
				
			}
		}	
	}
	function backToMain() {
		
		document.forms[0].actionParam.value = 'backToMain';
		document.forms[0].submit();
	}
	
	
</script>
<script type="text/javascript" src="https://www.google.com/jsapi"></script>

</head>
<%@include file="common/pageUpper.jsp"%>
<form method="post" action="addEmployee" onsubmit="javascript:test();">
	<input type="hidden" name="actionParam" value="addEmployee">
	<!-- start page -->


	<table width="90%" cellpadding="0" cellspacing="0" align="center"
		border="1">

		<c:if test="${createdEmployeeId != null}">
			<tr>
				<td colspan="2">Employee created with employee id
					${f:h(createdEmployeeId)}</td>

			</tr>
		</c:if>

		<tr>
			<td width="30%">&nbsp;</td>
			<td width="70%">&nbsp;</td>
		</tr>
		<tr>
			<td valign="top">Start Date</td>
			<td><input type="text" ${f:text("startDate")} size="30"
				readonly="readonly" id="datepicker"></td>
		</tr>
		<tr>
			<td valign="top">Employee Type</td>
			<td><select name="employeeType" id="employeeType"
				class="employeeType">
					<option ${f:select("employeeType","")}>Select</option>
					<option ${f:select("employeeType","1")}>Permanent Employee</option>
					<option ${f:select("employeeType","2")}>Contractor Employee</option>
					<option ${f:select("employeeType","3")}>Individual Contractor</option>

			</select></td>
		</tr>
		<tr id="contractorTr" style="display: none;">
			<td valign="top">Contractor</td>
			<td>
				<div id="contractordiv">
					<select class="shiftSelect" name="contractorCompany"
						onchange="javascript:setContracotrPartialEmployeeId(this.value);">
						<option value="">Select</option>
						<c:forEach var="e" items="${requestScope.contractorList}">
							<option ${f:select("contractorCompany",f:h(e.key.id))}>${f:h(e.companyName)}</option>
						</c:forEach>
					</select>

				</div>
			</td>
		</tr>

		<tr id="employeeIdTr" style="display: none;">
			<td valign="top">Employee Id</td>

			<td><span id="companyIdSpan"> </span><input type="text"
				${f:text("companyEmpId")}  size="20" style="width: 60px;">

				<input type="hidden" ${f:hidden("empCompanyId")} id="empCompanyId">

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
			<td><input type="text" ${f:text("firstName")}  size="50"
				class="nameField"></td>
		</tr>
		<tr>
			<td valign="top">Last Name</td>
			<td><input type="text" ${f:text("lastName")}   size="50"
				class="nameField"></td>
		</tr>
		<tr>
			<td valign="top">City</td>
			<td><select name="city"
				id="city">
					<option value="">Select city</option>
					<c:forEach var="e" items="${requestScope.city}">
						<option ${f:select("city",f:h(e))}>${f:h(e)}</option>
					</c:forEach>
					</select></td>
		</tr>
		<tr>
			<td valign="top">Gender</td>
			<td valign="top"><input type="radio"
				${f:radio("gender", "M")} class="choice" />Male &nbsp;&nbsp;<input
				type="radio" ${f:radio("gender", "F")} class="choice" />Female</td>
		</tr>
		<!-- Location and Shift are not mandatory -->
		<%-- 
   <tr>
    <td class="lebel" valign="top">Location</td>
    <td align="left"><select name="location" class="countrySelect" id="location">
    <option value="">Select Location</option>
    <c:forEach var="e" items="${sessionScope.locationList}">
				<option ${f:select("location",f:h(e.key.id))}>${f:h(e.locationName)}</option>
			</c:forEach>
    </select></td>
  </tr>
    <td>Shift</td>
    
    <td>
    <div id="shiftDiv"><select name="shift" class="shiftSelect"></select>
    </div>
    </td>
  </tr>
 
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


			<td><input type="checkbox" name="dayOfWeeklyOff" value="0" />Sunday
				<input type="checkbox" name="dayOfWeeklyOff" value="1" />Monday <input
				type="checkbox" name="dayOfWeeklyOff" value="2" />Tuesday <input
				type="checkbox" name="dayOfWeeklyOff" value="3" />Wednesday <input
				type="checkbox" name="dayOfWeeklyOff" value="4" />Thursday <input
				type="checkbox" name="dayOfWeeklyOff" value="5" />Friday <input
				type="checkbox" name="dayOfWeeklyOff" value="6" />Saturday</td>
		</tr>
		<tr>
			<td valign="top">Is a Manager ?</td>
			<td valign="top"><input type="radio"
				${f:radio("isManager", "Y")} class="choice"
				onclick="javascript:enableEmailField();" />Manager &nbsp;&nbsp;<input
				type="radio" ${f:radio("isManager", "N")} class="choice"
				onclick="javascript:enableEmailField();" />Not a Manager</td>
		</tr>
		<tr>
			<td valign="top">Email Id</td>

			<td><input type="text" ${f:text("emailId")}   size="15"
				class="nameField" ></td>
		</tr>
		
		<tr>
			<td valign="top">Is the User going to be Shift supervisor ?</td>
			<td valign="top"><input type="radio"
				${f:radio("isSuperwiser", "Y")} class="choice"
				onclick="javascript:enablePasskeyField();" />Supervisor
				&nbsp;&nbsp;<input type="radio"
				${f:radio("isSuperwiser", "N")} class="choice"
				onclick="javascript:enablePasskeyField();" />Not a Supervisor
				<div style="display: none;" id="msgdiv">
					&nbsp;&nbsp;<b> <font color="red">Please assign a valid
							shift to a Supervisor.</font></b>
				</div></td>
		</tr>
		<tr>
			<td valign="top">IMEI Code</td>

			<td><input type="text" ${f:text("imeiCode")}   size="15"
				class="nameField" disabled="disabled"></td>
		</tr>
		
		<tr>
			<td></td>
			<td><span>To get IMEI code Dial *#06# on your Android phone without any spaces</span></td>
		</tr>
	
		<tr>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<td colspan='2' align="left"><input type="submit" width="100px"
				value="Create" name="Create" title="Create" class="select1">
				<input type="reset" value="Reset" name="Reset" title="Reset"
				class="select1">
				<input type="button" value="Cancel" name="Cancel"
									onclick="javascript:backToMain();" class='select1'>
				</td>
		</tr>

	</table>

	<br>

	<div id="employees" class="aout"></div>

	<!-- end page -->
	<input type="hidden" ${f:hidden("companyId")} id="companyId"> 
	<input type="hidden" ${f:hidden("uniqueIdFlag")} id="uniqueIdFlag"> 
	<input type="hidden"${f:hidden("dayOfWeeklyOffStr")}> 
	<input type="hidden"${f:hidden("contractorUniqueIdFlag")}> 
	<input type="hidden" name="_empCompanyEmpId">




</form>
<!-- start footer -->
<script>
setPartialEmployeeId();
enablePasskeyField();
setWeeklyOfCheckBox();
enableEmailField();
</script>
<c:if test="${initialLoad != null}">
	<script> 
	  	 clearFields();
	  	 document.forms[0].elements['companyEmpId'].value=='';
	  	</script>
</c:if>

<%@include file="common/footer.jsp"%>


<script>
	$(function() {
		$("#datepicker").datepicker({
			showOn : "button",
			buttonImage : "images/calendar.gif",
			buttonImageOnly : true
		});
	});	
	$(function() {
		$('#location')
				.change(
						function() {

							var val = $(this).val();
							if (val != '') {

								$
										.getJSON(
												"jsonRequest?actionParam=shiftListRequest&locationId="
														+ val,
												function(data) {

													var str = '';
													var str = '<select class="shiftSelect" name="shift" >';
													for (cnt = 0; cnt < data.shiftList.length; cnt++) {
														str = str
																+ '<option value='+data.shiftList[cnt].shiftId+'>'
																+ data.shiftList[cnt].shiftName
																+ '</option>';
													}
													str = str + '</select>';
													$('#shiftDiv').html(str);
												});

							}
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
													var str = '<select class="shiftSelect" name="contractorCompany" onchange="javascript:setContracotrPartialEmployeeId(this.value)" ><option value="">Select</option>';
													for (cnt = 0; cnt < data.contractorList.length; cnt++) {
														str = str
																+ '<option value='+data.contractorList[cnt].contractorId+'>'
																+ data.contractorList[cnt].contractorName
																+ '</option>';
													}
													str = str + '</select>';
													$('#contractordiv').html(
															str);
													document
															.getElementById('contractorTr').style.display = 'block';
													

												    if( document.forms[0].elements['contractorUniqueIdFlag'].value == "Y") {
												    	document
														.getElementById('employeeIdTr').style.display = 'block';
												    } else {
												    	document
														.getElementById('employeeIdTr').style.display = 'none';
												    }
													

												});

							} else {
								document.getElementById('contractorTr').style.display = 'none';
								setPartialEmployeeId(companyId);
							}
						});
	});
</script>
<script>
//document.getElementById("employee_submenu").style.display='block';
</script>
