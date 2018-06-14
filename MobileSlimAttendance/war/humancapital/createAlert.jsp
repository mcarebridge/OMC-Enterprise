
<%@include file="common/common.jsp"%>
<%@include file="common/header.jsp"%>

<script type="text/javascript">
	function cancelNavigation() {
		document.forms[0].action="configurationIndex";
		document.forms[0].elements['actionParam'].value = null;
		document.forms[0].submit();
	}
	
	$(document).ready(function(){
		if(${requestScope.alertType == 'RESOURCE STRENGTH'})
		{
			$("#resourceStrength").show();
			$("#punctuality").hide();
		}else if(${requestScope.alertType == 'PUNCTUALITY'}){
			$("#resourceStrength").hide();
			$("#punctuality").show();
			
		}else if(${requestScope.alertType == 'FEMALE EMPLOYEE SECURITY'}){
			$("#resourceStrength").show();
			$("#punctuality").hide();
			var tolerance=document.forms[0].elements['toleranceLevel'].disabled = true;
			<c:forEach var="e" items="${requestScope.shiftList}">
							
			document.forms[0].elements['${f:h(e.key.id)}tgtValue'].disabled = true;
			document.forms[0].elements['${f:h(e.key.id)}min'].disabled = true;
			document.forms[0].elements['${f:h(e.key.id)}max'].disabled = true;
						
		
			</c:forEach>
		}else{
			$("#resourceStrength").hide();
			$("#punctuality").hide();
		}
	});
	
	
	function alertTypeChange()
	{
		var location= document.forms[0].elements['location'].value;
		
		if(location != "")
			{
				document.forms[0].elements['actionParam'].value = "loadShift";
				document.forms[0].action="createAlert";
				document.forms[0].submit();
			}
		
	}
	function loadShift() {
			
		document.forms[0].elements['actionParam'].value = "loadShift";
		document.forms[0].action="createAlert";
		document.forms[0].submit();
	}
	
	function pageSubmit() {
		document.forms[0].elements['actionParam'].value = "createAlert";
		document.forms[0].action="createAlert";
		
		document.forms[0].submit();
	}

	function viewAlert() {
		document.forms[0].action="viewAlert";
		document.forms[0].elements['actionParam'].value = "viewAlert";
		document.forms[0].submit();
	}
	
	function pageReset() {		
		document.forms[0].elements['actionParam'].value = "";
		document.forms[0].elements['alertType'].value = "";
		document.forms[0].elements['location'].value = "";
		document.forms[0].elements['toleranceLevel'].value = "";
		document.forms[0].elements['toleranceLevel1'].value = "";
		document.forms[0].elements['maxValue'].value = "";
		$("#resourceStrength").hide();
		$("#punctuality").hide();
	}
	
	function setTolerance()	{	
		var tolerance=document.forms[0].elements['toleranceLevel'].value;
		<c:forEach var="e" items="${requestScope.shiftList}">
				
		
		var tgt=document.forms[0].elements['${f:h(e.key.id)}tgtValue'].value;
		var min=document.forms[0].elements['${f:h(e.key.id)}min'].value;
		var max=document.forms[0].elements['${f:h(e.key.id)}max'].value;
		if( min !="" && max != "")
		{			
			min=parseInt(min)-parseInt(min/100*tolerance);
			max=parseInt(max)+parseInt(max/100*tolerance);
			document.forms[0].elements['${f:h(e.key.id)}tolerance'].value="<"+min+" or >"+max;
		}
		</c:forEach>
	}
</script>
</head>
<%@include file="common/pageUpper.jsp"%>
<div class="secondarymenu"
	style="min-height: 400px; width: 98%; vertical-align: middle; margin-left: 40px; clear: left;">
	<form action="createAlert" method="post">
		<input type="hidden" name="actionParam" value="createAlert">
		<table>
			<c:if test="${createdAlert != null}">
				<tr>
					<td colspan="2"><b> <fmt:message
								key="${requestScope.createdAlert}" /></b></td>
				</tr>
			</c:if>
			<tr>
				<td>Alert Type</td>
				<td><select name="alertType"
					onchange="javascript:alertTypeChange();" style="width: 175px">
						<option name="alertType" value="">
							<fmt:message key="select.alertType" />
						</option>
						<c:forEach var="e" items="${requestScope.alertList}">
							<option ${f:select("alertTypeId",f:h(e.key.id))}>${f:h(e.displayName)}</option>
						</c:forEach>

				</select></td>
			</tr>
			<tr>
				<td>Location</td>
				<td><select name="location" onchange="javascript:loadShift();"
					style="width: 175px">
						<option name="location" value="">
							<fmt:message key="select.Location" />
						</option>
						<c:forEach var="e" items="${requestScope.locationList}">
							<option ${f:select("location",f:h(e.key.id))}>
								${f:h(e.locationName)}</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td colspan="2">
					<div id="resourceStrength" class='aout'
						style="height: 350; overflow: auto;">
						<table>
							<tr>
								<th align="center">Shift Name</th>
								<th align="center">Target Value</th>
								<th align="center">Min</th>
								<th align="center">Max</th>
								<th style="font: 8px; width: 90px" align="center">Tolerance
									level for escalation (%)</th>
								<th>First Manager</th>
								<th>Second Manager</th>
							</tr>
							<tr class='altrow' style="border-bottom: 1px solid #CDCECE">
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td style="text-align: right;" align="right"><select
									name="toleranceLevel" onchange="setTolerance()"
									style="width: 90px">
										<option ${f:select("toleranceLevel",f:h(00))}>00</option>
										<option ${f:select("toleranceLevel",f:h(05))}>05</option>
										<option ${f:select("toleranceLevel",f:h(10))}>10</option>
										<option ${f:select("toleranceLevel",f:h(15))}>15</option>
										<option ${f:select("toleranceLevel",f:h(20))}>20</option>
										<option ${f:select("toleranceLevel",f:h(25))}>25</option>
										<option ${f:select("toleranceLevel",f:h(30))}>30</option>
										<option ${f:select("toleranceLevel",f:h(35))}>35</option>
										<option ${f:select("toleranceLevel",f:h(40))}>40</option>
										<option ${f:select("toleranceLevel",f:h(45))}>45</option>
										<option ${f:select("toleranceLevel",f:h(50))}>50</option>

								</select></td>
								<td></td>
								<td></td>
							</tr>
							<c:forEach var="e" items="${requestScope.shiftList}">
								<tr class='altrow' style="border-bottom: 1px solid #CDCECE">
									<td>${f:h(e.shiftName)}</td>
									<td><input type="text" name="${f:h(e.key.id)}tgtValue"
										id="${f:h(e.key.id)}tgtValue" style="width: 90px" value="0"
										onchange="setTolerance()" /></td>
									<td><input type="text" name="${f:h(e.key.id)}min"
										id="${f:h(e.key.id)}min" style="width: 90px" value="0"
										onchange="setTolerance()" /></td>
									<td><input type="text" name="${f:h(e.key.id)}max"
										id="${f:h(e.key.id)}max" style="width: 90px" value="0"
										onchange="setTolerance()" /></td>
									<td><input type="text" name="${f:h(e.key.id)}tolerance"
										readonly="readonly" id="${f:h(e.key.id)}tolerance"
										style="width: 90px; border: 0" /></td>
									<td><select name="${e.key.id}1stManager">
											<option name="1stmanager" value="">Select First
												Manager</option>
											<c:forEach var="a" items="${requestScope.managerList}">
												<option value="${ f:h(a.key.id)}">
													${f:h(a.firstName)} ${f:h(a.lastName)}</option>
											</c:forEach>
									</select></td>
									<td><select name="${e.key.id}2ndManager">
											<option value="">Select Second Manager</option>
											<c:forEach var="a" items="${requestScope.managerList}">
												<option value="${ f:h(a.key.id)}">
													${f:h(a.firstName)} ${f:h(a.lastName)}</option>
											</c:forEach>
									</select></td>

								</tr>
							</c:forEach>
						</table>
					</div>
					<div id="punctuality" class='aout'>
						<table>
							<tr>
								<th>Min ( % )</th>
								<th style="font: 8px;">Tolerance level for escalation(%)</th>
								<th>First Manager</th>
								<th>Second Manager</th>
							</tr>
							<tr class='altrow'>
								<td><select name="minValue" style="width: 90px">
										<option ${f:select(f:h(e.minValueForAlert),f:h(00))}>00</option>
										<option ${f:select(f:h(e.minValueForAlert),f:h(05))}>05</option>
										<option ${f:select(f:h(e.minValueForAlert),f:h(10))}>10</option>
										<option ${f:select(f:h(e.minValueForAlert),f:h(15))}>15</option>
										<option ${f:select(f:h(e.minValueForAlert),f:h(20))}>20</option>
										<option ${f:select(f:h(e.minValueForAlert),f:h(25))}>25</option>
										<option ${f:select(f:h(e.minValueForAlert),f:h(30))}>30</option>
										<option ${f:select(f:h(e.minValueForAlert),f:h(35))}>35</option>
										<option ${f:select(f:h(e.minValueForAlert),f:h(40))}>40</option>
										<option ${f:select(f:h(e.minValueForAlert),f:h(45))}>45</option>
										<option ${f:select(f:h(e.minValueForAlert),f:h(50))}>50</option><
								</td>
								<td style="text-align: right;" align="right"><select
									name="toleranceLevel1" style="width: 90px">
										<option ${f:select("toleranceLevel1",f:h(00))}>00</option>
										<option ${f:select("toleranceLevel1",f:h(05))}>05</option>
										<option ${f:select("toleranceLevel1",f:h(10))}>10</option>
										<option ${f:select("toleranceLevel1",f:h(15))}>15</option>
										<option ${f:select("toleranceLevel1",f:h(20))}>20</option>
										<option ${f:select("toleranceLevel1",f:h(25))}>25</option>
										<option ${f:select("toleranceLevel1",f:h(30))}>30</option>
										<option ${f:select("toleranceLevel1",f:h(35))}>35</option>
										<option ${f:select("toleranceLevel1",f:h(40))}>40</option>
										<option ${f:select("toleranceLevel1",f:h(45))}>45</option>
										<option ${f:select("toleranceLevel1",f:h(50))}>50</option>
								</select></td>
								<td><select name="1stManager">
										<option name="1stmanager" value="">Select First
											Manager</option>
										<c:forEach var="a" items="${requestScope.managerList}">
											<option value="${ f:h(a.key.id)}">${f:h(a.firstName)}
												${f:h(a.lastName)}</option>
										</c:forEach>
								</select></td>
								<td><select name="2ndManager">
										<option value="">Select Second Manager</option>
										<c:forEach var="a" items="${requestScope.managerList}">
											<option value="${ f:h(a.key.id)}">${f:h(a.firstName)}
												${f:h(a.lastName)}</option>
										</c:forEach>
								</select></td>
							</tr>
						</table>
					</div>
				</td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" name="Submit"
					value="Submit" class="select1" onclick="pageSubmit()" /><input
					type="reset" name="reset" value="Reset" class="select1" /> <input
					type="button" name="cancel" value="Cancel" class="select1"
					onclick="cancelNavigation()" /><input type="button" name="view"
					value="View Alerts" class="select1" onclick="viewAlert()" /></td>
			</tr>
		</table>
	</form>
</div>
<%@include file="common/footer.jsp"%>