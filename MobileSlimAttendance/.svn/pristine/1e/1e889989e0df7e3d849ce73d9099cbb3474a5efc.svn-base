<%@include file="common/common.jsp"%>
<div 
	style="width: 100%; height: 400px;  margin: 15px 0 0 0; padding: 10px 10px 10px 10px">
	<table style="width: 100%; align: center; border: 0px solid red;">
		<tr>
			<td align="left" colspan="2">

				<table>
					<tr>
						<td><b>Location :</b> &nbsp;&nbsp;<select name="location"
							class="locationSelect" id="location"
							onchange="populateShiftList(this.value);">
								<option value="">All Locations</option>
								<c:forEach var="e" items="${sessionScope.locationList}">
									<option ${f:select("location",f:h(e.key.id))}>${f:h(e.locationName)}</option>
								</c:forEach>
						</select></td>
						<td>

							<div id="shiftDiv">
								<b>Shift :</b> <select class="shiftSelect1" name="shift"
									id="shift" onchange="javascript:setShfitId(this.value);">
									<option value="">All Shift</option>
									<c:forEach var="shift" items="${shiftList}">
										<option ${f:select("shift",f:h(shift.key.id))}>${f:h(shift.shiftName)}</option>
									</c:forEach>
								</select>
							</div> <input type="hidden" ${f:hidden("shiftId")}> <input
							type="hidden" ${f:hidden("locationId")}>
						</td>
					</tr>
				</table>
		</tr>
		<tr style="width: 100%; align: center; border: 0px solid red;">
			<td
				style="width: 25%; vertical-align: text-top; border: 0px solid #6699CC;">
				<div>
					<div style="text-align: center; text; font-weight: bold;">Utilization
						of Assigned Employees</div>
					<div style="align: center; height: 100%" id="gauge_Utilization"></div>
					<div>
						<table style="width: 100%; align: center; border: 0px solid gray;">
							<tr
								style="width: 100%; height: 40px; align: center; border: 1px solid gray;">
								<td style="width: 70%; align: center; border: 1px solid gray;">Total
									No of Employees Assigned</td>
								<td
									style="width: 30%; text-align: center; border: 1px solid gray;">${f:h(no_of_assignemnt)}</td>
							</tr>
							<tr
								style="width: 100%; height: 40px; align: center; border: 1px solid gray;">
								<td style="width: 70%; align: center; border: 1px solid gray;">#
									of Employees Reported</td>
								<td
									style="width: 30%; text-align: center; border: 1px solid gray;">${f:h(no_of_employee_reported)}</td>
							</tr>

						</table>
					</div>
				</div>
			</td>
			<td style="width: 25%; align: center; border-left:1px dotted #6699CC;">
				<div style="text-align: center; text; font-weight: bold;">Not
					reported Assigned employees</div>
				<div style="align: center;" id="gauge_NotReported"></div>
				<div>
					<table style="width: 100%; align: center; border: 1px solid gray;">
						<tr
							style="width: 100%; height: 40px; align: center; border: 1px solid gray;">
							<td style="width: 70%; align: center; border: 1px solid gray;">Total
								No of Employees Assigned</td>
							<td
								style="width: 30%; text-align: center; border: 1px solid gray;">${f:h(no_of_assignemnt)}</td>
						</tr>
						<tr
							style="width: 100%; height: 40px; align: center; border: 1px solid gray;">
							<td style="width: 75%; align: center; border: 1px solid gray;">#
								of Assigned Employees Not Reported</td>
							<td
								style="width: 25%; text-align: center; border: 1px solid gray;">${f:h(no_of_not_reported)}</td>
						</tr>

					</table>
				</div>
			</td>
			<td style="width: 25%; align: center; border-left:1px dotted #6699CC;">
				<div
					style="text-align: center; text; font-weight: bold; height: 100%">Late-IN
					Employees</div>
				<div style="align: center;" id="gauge_LateIn"></div>
				<div>
					<table style="width: 100%; align: center; border: 1px solid gray;">
						<tr
							style="width: 100%; height: 40px; align: center; border: 1px solid gray;">
							<td style="width: 70%; align: center; border: 1px solid gray;">Total
								No of Employees Reported</td>
							<td
								style="width: 30%; text-align: center; border: 1px solid gray;">${f:h(no_of_employee_reported)}</td>
						</tr>
						<tr
							style="width: 100%; height: 40px; align: center; border: 1px solid gray;">
							<td style="width: 70%; align: center; border: 1px solid gray;">No
								of Employees Late-IN</td>
							<td
								style="width: 30%; text-align: center; border: 1px solid gray;">${f:h(late_in_employee_count)}</td>
						</tr>
					</table>
				</div>
			</td>
			<td style="width: 25%; align: center; border-left:1px dotted #6699CC;">
				<div style="text-align: center; text; font-weight: bold;">Early-OUT
					Employees</div>
				<div style="align: center;" id="gauge_EarlyLeft"></div>
				<div>
					<table style="width: 100%; align: center; border: 1px solid gray;">
						<tr
							style="width: 100%; height: 40px; align: center; border: 1px solid gray;">
							<td style="width: 70%; align: center; border: 1px solid gray;">Total
								No of Employees Reported</td>
							<td
								style="width: 30%; text-align: center; border: 1px solid gray;">${f:h(no_of_employee_reported)}</td>
						</tr>
						<tr
							style="width: 100%; height: 40px; align: center; border: 1px solid gray;">
							<td style="width: 70%; align: center; border: 1px solid gray;">No
								of Employees Early-OUT</td>
							<td
								style="width: 30%; text-align: center; border: 1px solid gray;">${f:h(early_out_employee_count)}</td>
						</tr>
					</table>
				</div>
			</td>
		</tr>
	</table>
</div>