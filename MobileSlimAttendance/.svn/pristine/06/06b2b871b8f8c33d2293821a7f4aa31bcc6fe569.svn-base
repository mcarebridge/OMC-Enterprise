<%@include file="common/common.jsp"%>
<%@include file="common/header.jsp"%>
<script type="text/javascript">
	function cancelNavigation() {
		document.forms[0].action="configurationIndex";
		document.forms[0].elements['actionParam'].value = null;
		document.forms[0].submit();
	}
	
	$(document).ready(function(){
		if(${alertType == 'RESOURCE STRENGTH'})
		{
			$("#resourceStrength").show();
			$("#punctuality").hide();
			var tolerance=document.forms[0].elements['toleranceLevel'].value;
			<c:forEach var="e" items="${alertList}">
			var min=document.forms[0].elements['${f:h(e.shiftRef.key.id)}min'].value;
			var max=document.forms[0].elements['${f:h(e.shiftRef.key.id)}max'].value;
			var tgt=document.forms[0].elements['${f:h(e.shiftRef.key.id)}tgtValue'].value;
			if( min !="" && max != "")
			{			
				min=parseInt(min)-parseInt(min/100*tolerance);
				max=parseInt(max)+parseInt(max/100*tolerance);
				document.forms[0].elements['${f:h(e.shiftRef.key.id)}minmaxtolerance'].value="<"+min+" or >"+max;
			}
			</c:forEach>
		}else if(${alertType == 'PUNCTUALITY'}){
			$("#resourceStrength").hide();
			$("#punctuality").show();
			
		}else if(${alertType == 'FEMALE EMPLOYEE SECURITY'})
		{
			$("#resourceStrength").show();
			$("#punctuality").hide();
			setFemaleNotCheckedOutAlert();
		}else{
			$("#resourceStrength").hide();
			$("#punctuality").hide();
		}		
	});
	function setFemaleNotCheckedOutAlert()
	{
		var tolerance=document.forms[0].elements['toleranceLevel'].disabled = true;
		<c:forEach var="e" items="${alertList}">
						
		document.forms[0].elements['${f:h(e.shiftRef.key.id)}tgtValue'].readOnly = true;
		document.forms[0].elements['${f:h(e.shiftRef.key.id)}min'].readOnly = true;
		document.forms[0].elements['${f:h(e.shiftRef.key.id)}max'].readOnly = true;
					
		document.forms[0].elements['${f:h(e.shiftRef.key.id)}tgtValue'].value="";
		document.forms[0].elements['${f:h(e.shiftRef.key.id)}min'].value="";
		document.forms[0].elements['${f:h(e.shiftRef.key.id)}max'].value="";
		</c:forEach>
		
		
	}
	function pageSubmit() {
		document.forms[0].elements['actionParam'].value = "updateAlert";
		document.forms[0].action="editAlert";
		document.forms[0].submit();
	}
	
	function setTolerance()	{	
		
		var tolerance=document.forms[0].elements['toleranceLevel'].value;
		<c:forEach var="e" items="${alertList}">
		var min=document.forms[0].elements['${f:h(e.shiftRef.key.id)}min'].value;
		var max=document.forms[0].elements['${f:h(e.shiftRef.key.id)}max'].value;
		var tgt=document.forms[0].elements['${f:h(e.shiftRef.key.id)}tgtValue'].value;
		if( min !="" && max != "")
		{			
			min=parseInt(min)-parseInt(min/100*tolerance);
			max=parseInt(max)+parseInt(max/100*tolerance);
			document.forms[0].elements['${f:h(e.shiftRef.key.id)}minmaxtolerance'].value="<"+min+" or >"+max;
		}
		</c:forEach>
	}
</script>
</head>
<%@include file="common/pageUpper.jsp"%>
<div class="secondarymenu"
	style="height: 400px; width: 98%; vertical-align: middle; margin-left: 40px; clear: left;">
	<form action="editAlert" method="post">
		<input type="hidden" name="actionParam" value="updateAlert"> <input
			type="hidden" name="alertId" value="${f:h(alert.key.id)}">

		<table>
			<tr>
				<td>Alert Type</td>
				<td><input type="text" name="alertType" value="${alertType}"
					readonly="readonly"></td>
			</tr>
			<tr>
				<td>Location</td>
				<td><input type="text" name="location" value="${location}"
					readonly="readonly"></td>
			</tr>
			<tr>
				<td colspan="2">
					<div id="resourceStrength" class='aout' style="">
						<table>
							<tr>
								<th align="center">Shift Name</th>
								<th align="center">Target Value</th>
								<th align="center">Min</th>
								<th align="center">Max</th>
								<th style="font: 8px; width: 90px" align="center">Tolerance
									level for escalation (%)</th>
								<th align="center">First Manager</th>
								<th align="center">Second Manager</th>
								<th align="center">Active</th>
								<th align="center">Inactive</th>


							</tr>
							<tr class='altrow' style="border-bottom: 1px solid #CDCECE">
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td style="text-align: right;" align="right"><select
									name="toleranceLevel" onchange="setTolerance()"
									style="width: 90px">
										<option ${f:select("tolerance",f:h(00))}>00</option>
										<option ${f:select("tolerance",f:h(05))}>05</option>
										<option ${f:select("tolerance",f:h(10))}>10</option>
										<option ${f:select("tolerance",f:h(15))}>15</option>
										<option ${f:select("tolerance",f:h(20))}>20</option>
										<option ${f:select("tolerance",f:h(25))}>25</option>
										<option ${f:select("tolerance",f:h(30))}>30</option>
										<option ${f:select("tolerance",f:h(35))}>35</option>
										<option ${f:select("tolerance",f:h(40))}>40</option>
										<option ${f:select("tolerance",f:h(45))}>45</option>
										<option ${f:select("tolerance",f:h(50))}>50</option>
								</select></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
							</tr>
							<c:forEach var='e' items="${alertList}">
								<tr class='altrow' style="border-bottom: 1px solid #CDCECE">
									<td>${f:h(e.shiftRef.model.shiftName)}<input type="hidden"
										name="${f:h(e.shiftRef.key.id)}id" value="${e.key.id}"></td>
									<td><input type="text"
										name="${f:h(e.shiftRef.key.id)}tgtValue" style="width: 90px"
										value="${f:h(e.targetValues)}" onchange="setTolerance()" /></td>
									<td><input type="text"
										name="${f:h(e.shiftRef.key.id)}min" style="width: 90px"
										value="${f:h(e.minValueForAlert)}" onchange="setTolerance()" /></td>
									<td><input type="text"
										name="${f:h(e.shiftRef.key.id)}max" style="width: 90px"
										value="${f:h(e.maxValueForAlert)}" onchange="setTolerance()" /></td>

									<td><input type="text"
										name="${f:h(e.shiftRef.key.id)}minmaxtolerance"
										readonly="readonly" style="width: 90px" /></td>
									<td><select name="${e.shiftRef.key.id}1stManager">
											<option name="1stmanager" value="">Select First
												Manager</option>
											<c:forEach var="a" items="${requestScope.managerList}">
												<option
													${e.firstLevelManager.key.id==a.key.id?'selected':''}
													value="${a.key.id}">${f:h(a.firstName)}
													${f:h(a.lastName)}</option>
											</c:forEach>
									</select></td>
									<td><select name="${e.shiftRef.key.id}2ndManager">
											<option value="">Select Second Manager</option>
											<c:forEach var="a" items="${requestScope.managerList}">
												<option
													${e.secondLevelManager.key.id==a.key.id?'selected':''}
													value="${a.key.id}">${f:h(a.firstName)}
													${f:h(a.lastName)}</option>
											</c:forEach>
									</select></td>

									<td style="width: 90px"><input type="radio"
										${e.active=="Y"?'checked':''} value="Y"
										name="${f:h(e.shiftRef.key.id)}active"
										id="${f:h(e.shiftRef.key.id)}active" /></td>
									<td style="width: 90px;"><input type="radio"
										${e.active=="N"?'checked':''} value="N"
										name="${f:h(e.shiftRef.key.id)}active"
										id="${f:h(e.shiftRef.key.id)}active" /></td>


								</tr>
							</c:forEach>
						</table>
					</div>
					<div id="punctuality" class='aout'>

						<table>
							<tr>
								<th>Min (%)</th>
								<th style="font: 8px;">Tolerance level for escalation(%)</th>
								<th align="center">First Manager</th>
								<th align="center">Second Manager</th>
								<th align="center">Active</th>
								<th align="center">Inactive</th>

							</tr>
							<c:forEach var='e' items="${alertList}">

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
											<option ${f:select(f:h(e.minValueForAlert),f:h(50))}>50</option>
									</select></td>
									<td style="text-align: right;" align="right"><select
										name="toleranceLevel1" style="width: 90px">
											<option ${f:select("tolerance",f:h(00))}>00</option>
											<option ${f:select("tolerance",f:h(05))}>05</option>
											<option ${f:select("tolerance",f:h(10))}>10</option>
											<option ${f:select("tolerance",f:h(15))}>15</option>
											<option ${f:select("tolerance",f:h(20))}>20</option>
											<option ${f:select("tolerance",f:h(25))}>25</option>
											<option ${f:select("tolerance",f:h(30))}>30</option>
											<option ${f:select("tolerance",f:h(35))}>35</option>
											<option ${f:select("tolerance",f:h(40))}>40</option>
											<option ${f:select("tolerance",f:h(45))}>45</option>
											<option ${f:select("tolerance",f:h(50))}>50</option>
									</select></td>
									<td><select name="1stManager">
											<option name="1stmanager" value="">Select First
												Manager</option>
											<c:forEach var="a" items="${requestScope.managerList}">
												<option
													${e.firstLevelManager.key.id==a.key.id?'selected':''}
													value="${a.key.id}">${f:h(a.firstName)}
													${f:h(a.lastName)}</option>
											</c:forEach>
									</select></td>
									<td><select name="2ndManager">
											<option value="">Select Second Manager</option>
											<c:forEach var="a" items="${requestScope.managerList}">
												<option
													${e.secondLevelManager.key.id==a.key.id?'selected':''}
													value="${a.key.id}">${f:h(a.firstName)}
													${f:h(a.lastName)}</option>
											</c:forEach>
									</select></td>
									<td><input type="radio" ${e.active=="Y"?'checked':''}
										value="Y" name="active" id="active" /></td>
									<td><input type="radio" ${e.active=="N"?'checked':''}
										value="N" name="active" id="active" /></td>
								</tr>
							</c:forEach>

						</table>
					</div>
				</td>
			</tr>
			<tr class='altrow'>
				<td colspan="2"><input type="submit" name="Submit"
					value="Submit" class="select1" onclick="pageSubmit()" /> <input
					type="button" name="cancel" value="Cancel" class="select1"
					onclick="cancelNavigation()" /></td>
			</tr>
		</table>
	</form>
</div>
<%@include file="common/footer.jsp"%>