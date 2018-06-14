<%@include file="common/common.jsp"%>
<%@include file="common/header.jsp"%>
<script>
	function clearFields() {

		document.forms[0].elements['userProfile'].value = "";
		document.forms[0].elements['firstName'].value = "";
		document.forms[0].elements['lastName'].value = "";
		document.forms[0].elements['phone'].value = "";
		document.forms[0].elements['cell'].value = "";
		document.forms[0].elements['userName'].value = "";
		document.forms[0].elements['line1'].value = "";
		document.forms[0].elements['line2'].value = "";
		document.forms[0].elements['city'].value = "";
		document.forms[0].elements['country'].value = "";
		document.forms[0].elements['state'].value = "";
		document.forms[0].elements['pinCode'].value = "";

	}
</script>
</head>
<%@include file="common/pageUpper.jsp"%>
<body>
<div
	style="width: 100%; height: 15px; border: 0px solid red; margin: 15px 0 0 0">
	<form method="post" action="createCompany?actionParam=createCompany">
	<input type="hidden"${f:hidden("companyId")}> 
		<input
			type="hidden"${f:hidden("isManager")}>
		<div>
			<table width="100%" align="left" summary="Test" cellpadding="2px">
				<tr>
					<td width="30%">&nbsp;</td>
					<td width="70%">&nbsp;</td>
				</tr>
				<tr>
				<!-- 
				<tr>
					<td width="28%">Nature of Business</td>
					<td width="72%"><select name="natureOfBusiness"
						id="natureOfBusiness">
							<option value="">Select Nature Of Business</option>
							<c:forEach var="e" items="${natureOfCompanyList}">
								<option ${f:select("natureOfBusiness",f:h(e.key.id))}>${f:h(e.natureOfBusinessDesce)}</option>
							</c:forEach>
					</select></td>
				</tr> -->
				<tr>
					<td width="28%">Nature of Business</td>
					<td width="72%"><select name="template" id="template">
							<option value="">Select </option>
							<c:forEach var="e" items="${templateList}">
								<option ${f:select("templateName",f:h(e.key.id))}>${f:h(e.templateName)}</option>
							</c:forEach>
					</select></td>
				</tr>
				<tr>
					<td valign="top">Employee population</td>
					<td><input type="text"${f:text("emplyoeePopulation")}>
					</td>
				</tr>
				<tr>
					<td valign="top">Do you provide unique employee Id to your
						employees ?</td>
					<td><input type="radio"
						${f:radio("uniqueidFlag", "Y")} class="choice" />Yes &nbsp;&nbsp;<input
						type="radio" ${f:radio("uniqueidFlag", "N")} class="choice" />No</td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td align="left"><input type="submit" class='select1'
						value="Submit"> <input type="button" class='select1'
						value="Reset" name="Reset" title="Reset"></td>
				</tr>				
			</table>
		</div>
		
	</form>
</div>
<%@include file="common/footer.jsp"%>


