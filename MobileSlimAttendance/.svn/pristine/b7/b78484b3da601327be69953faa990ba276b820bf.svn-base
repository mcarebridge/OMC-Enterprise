<%@include file="common/common.jsp"%>
<%@include file="common/header.jsp"%>
<script>
	function listAndPrint(_action) {

		document.forms[0].actionParam.value = 'listAndPrint';
		document.forms[0].submit();
	}
</script>
</head>
<%@include file="common/assignmentPageUpper.jsp"%>

<form method="post" action="test">

<input type="hidden" name="actionParam" value="submit">

 <div style="float: left">
<table>
<tr>
<td>
select TimeZone 
<select name="timezone" >
<option value="">Select Timezone</option>
					<c:forEach var="e" items="${requestScope.timezonelist}">
						<option ${f:select("timezone",f:h(e))}>${f:h(e)}</option>
					</c:forEach>


</select>
<input type="submit" class="select1" name="submit" value="submit">
</tr>
<tr>
<td>
Date : <input type="text" name="Current" value="${requestScope.Current}">  * format: dd/MM/yyyy
</td>
</tr>
<tr>
<td>
Time : <input type="text" name="CurrentTime" value="${requestScope.CurrentTime}"> * format: hh:mm
</td>
</tr>
</table>

</div>
<div style="float: left">
<table>
<tr>
<td style="height: 25px">
</td>
</tr>
<tr>
<td>
GMT Date : <input type="text" name="GMT" value="${requestScope.GMT}"> 
</td>
</tr>
<tr>
<td>
GMT Time : <input type="text" name="GMTTime" value="${requestScope.GMTTime}"> 
</td>
</tr>
</table>

</div>
</form>

<%@include file="common/footer.jsp"%>