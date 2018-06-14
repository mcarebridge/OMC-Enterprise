<%@include file="common/common.jsp"%>
<%@include file="common/header.jsp"%>
<!-- start header -->
<script>
	function navigateCancel() {
		document.forms[0].action = "cancelShiftEdit";
		document.forms[0].submit();
	}
	function updateShift() {
		document.forms[0].elements['shiftName'].disabled = false;
		document.forms[0].elements['location'].disabled = false;
		document.forms[0].elements['start_hrs'].disabled = false;
		document.forms[0].elements['start_min'].disabled = false;
		document.forms[0].elements['end_hrs'].disabled = false;
		document.forms[0].elements['end_min'].disabled = false;
		document.forms[0].submit();
	}
</script>
</head>
<%@include file="common/pageUpper.jsp"%>
<form method="post" action="editShift">
	<input type="hidden" name="actionParam" value="updateShift">
	<div class='controlbox'>
	<table width="70%">
		<tr>
			<td >&nbsp;</td>
			<td >&nbsp;</td>
		</tr>
		<tr>
			<td>Location</td>
			<td><select name="location" class="countrySelect"
				id="location" disabled="disabled">
					<option value="">Select Location</option>
					<c:forEach var="e" items="${sessionScope.locationList}">
						<option ${f:select("location",f:h(e.key.id))}>${f:h(e.locationName)}</option>
					</c:forEach>
			</select></td>
		</tr>
		<tr>
			<td >Shift Name</td>
			<td ><input type="text"
				${f:text("shiftName")}  size="20" disabled="disabled"></td>
		</tr>
		<tr>
		<tr>
			<td></td>
			<td >&nbsp;&nbsp; Hours
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;Minutes</td>
		</tr>

		<td  >Start Time</td>

		<td ><select name="start_hrs" class="hour"
			id="start_hrs" disabled="disabled">
				<option ${f:select("start_hrs",f:h(""))}>Hours</option>
				<option ${f:select("start_hrs",f:h(00))}>00</option>
				<option ${f:select("start_hrs",f:h(01))}>01</option>
				<option ${f:select("start_hrs",f:h(02))}>02</option>
				<option ${f:select("start_hrs",f:h(03))}>03</option>
				<option ${f:select("start_hrs",f:h(04))}>04</option>
				<option ${f:select("start_hrs",f:h(05))}>05</option>
				<option ${f:select("start_hrs",f:h(06))}>06</option>
				<option ${f:select("start_hrs",f:h(07))}>07</option>
				<option ${f:select("start_hrs",f:h(08))}>08</option>
				<option ${f:select("start_hrs",f:h(09))}>09</option>
				<option ${f:select("start_hrs",f:h(10))}>10</option>
				<option ${f:select("start_hrs",f:h(11))}>11</option>
				<option ${f:select("start_hrs",f:h(12))}>12</option>
				<option ${f:select("start_hrs",f:h(13))}>13</option>
				<option ${f:select("start_hrs",f:h(14))}>14</option>
				<option ${f:select("start_hrs",f:h(15))}>15</option>
				<option ${f:select("start_hrs",f:h(16))}>16</option>
				<option ${f:select("start_hrs",f:h(17))}>17</option>
				<option ${f:select("start_hrs",f:h(18))}>18</option>
				<option ${f:select("start_hrs",f:h(19))}>19</option>
				<option ${f:select("start_hrs",f:h(20))}>20</option>
				<option ${f:select("start_hrs",f:h(21))}>21</option>
				<option ${f:select("start_hrs",f:h(22))}>22</option>
				<option ${f:select("start_hrs",f:h(23))}>23</option>

		</select> &nbsp; <select name="start_min" class="hour" id="start_min"
			disabled="disabled">
				<option ${f:select("start_min",f:h(""))}>Min</option>
				<option ${f:select("start_min",f:h(00))}>00</option>
				<option ${f:select("start_min",f:h(15))}>15</option>
				<option ${f:select("start_min",f:h(30))}>30</option>
				<option ${f:select("start_min",f:h(45))}>45</option>
		</select></td>

		</tr>
		<tr>
			<td >End Time</td>

			<td ><select name="end_hrs" class="hour"
				id="end_hrs" disabled="disabled">
					<option ${f:select("end_hrs",f:h(""))}>Hours</option>
					<option ${f:select("end_hrs",f:h(0))}>00</option>
					<option ${f:select("end_hrs",f:h(1))}>01</option>
					<option ${f:select("end_hrs",f:h(2))}>02</option>
					<option ${f:select("end_hrs",f:h(3))}>03</option>
					<option ${f:select("end_hrs",f:h(4))}>04</option>
					<option ${f:select("end_hrs",f:h(5))}>05</option>
					<option ${f:select("end_hrs",f:h(6))}>06</option>
					<option ${f:select("end_hrs",f:h(7))}>07</option>
					<option ${f:select("end_hrs",f:h(8))}>08</option>
					<option ${f:select("end_hrs",f:h(9))}>09</option>
					<option ${f:select("end_hrs",f:h(10))}>10</option>
					<option ${f:select("end_hrs",f:h(11))}>11</option>
					<option ${f:select("end_hrs",f:h(12))}>12</option>
					<option ${f:select("end_hrs",f:h(13))}>13</option>
					<option ${f:select("end_hrs",f:h(14))}>14</option>
					<option ${f:select("end_hrs",f:h(15))}>15</option>
					<option ${f:select("end_hrs",f:h(16))}>16</option>
					<option ${f:select("end_hrs",f:h(17))}>17</option>
					<option ${f:select("end_hrs",f:h(18))}>18</option>
					<option ${f:select("end_hrs",f:h(19))}>19</option>
					<option ${f:select("end_hrs",f:h(20))}>20</option>
					<option ${f:select("end_hrs",f:h(21))}>21</option>
					<option ${f:select("end_hrs",f:h(22))}>22</option>
					<option ${f:select("end_hrs",f:h(23))}>23</option>

			</select> &nbsp; <select name="end_min" class="hour" id="end_min"
				disabled="disabled">
					<option ${f:select("end_min",f:h(""))}>Min</option>
					<option ${f:select("end_min",f:h(0))}>00</option>
					<option ${f:select("end_min",f:h(15))}>15</option>
					<option ${f:select("end_min",f:h(30))}>30</option>
					<option ${f:select("end_min",f:h(45))}>45</option>
			</select></td>
		</tr>
		<tr>
			<td >Status</td>
			<td align="left"><input type="radio"
				${f:radio("active", "Y")} class="choice" />Active &nbsp;&nbsp;<input
				type="radio" ${f:radio("active", "N")} class="choice" />Inactive</td>
		</tr>
		<tr>
			<td>&nbsp;</td>
			<td align="left"><input type="button" width="100px" value="Save"
				name="Create" title="Create" class="select1"
				onclick="javascript:updateShift();"> <input type="reset"
				value="Reset" name="Reset" title="Reset" class="select1"></td>
		</tr>
	</table>
	</div>
	<input type="hidden"${f:hidden("shiftId")}>
</form>
<%@include file="common/footer.jsp"%>
