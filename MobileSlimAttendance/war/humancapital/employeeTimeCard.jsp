<%@include file="common/common.jsp"%>
<%@include file="common/header.jsp"%>
<%@ page import="java.util.Date"%>
<link href="styles/jqueryui/jquery.ui.all.css" rel="stylesheet"
	type="text/css">
<script type="text/javascript"
	src="scripts/jquery-1.6.2.js?updated=<%=new Date()%>"></script>
<script type="text/javascript"
	src="scripts/jquery.dataTables.js?updated=<%=new Date()%>"></script>
<script type="text/javascript"
	src="scripts/jquery-ui-1.8.16.custom.js?updated=<%=new Date()%>"></script>
<script type="text/javascript"
	src="scripts/date.js?updated=<%=new Date()%>"></script>
<script type="text/javascript" src="https://www.google.com/jsapi"></script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<%@include file="common/assignmentPageUpper.jsp"%>

<form action="employeeTimeCard" method="post">
	<div class='controlbox'>
		<table  border="1">
			<tr>
				<td>From Date</td>
				<td><select name="startDate">

						<option ${f:select("startDate","01/01/2012")}>Jan-2012</option>
						<option ${f:select("startDate","02/01/2012")}>Feb-2012</option>
						<option ${f:select("startDate","03/01/2012")}>Mar-2012</option>
						<option ${f:select("startDate","04/01/2012")}>Apr-2012</option>
						<option ${f:select("startDate","05/01/2012")}>May-2012</option>
						<option ${f:select("startDate","06/01/2012")}>Jun-2012</option>
						<option ${f:select("startDate","07/01/2012")}>Jul-2012</option>
						<option ${f:select("startDate","08/01/2012")}>Aug-2012</option>
						<option ${f:select("startDate","09/01/2012")}>Sep-2012</option>
						<option ${f:select("startDate","10/01/2012")}>Oct-2012</option>
						<option ${f:select("startDate","11/01/2012")}>Nov-2012</option>
						<option ${f:select("startDate","12/01/2012")}>Dec-2012</option>

				</select></td>
				<td><input type="button" value="Search" name="Search"
					class='select1' onclick="javascript:search();"></td>

				<td><input type="button" value="Cancel" name="Cancel"
					class='select1' onclick="javascript:cancelNavigation();"></td>
			</tr>
		</table>
	</div>
	<br>
	<div class='aout'>

		
			<table>
				<tr>
					<td>#</td><% for(int i=0;i<=31;i++){%>
					<td><%=i%></td>	<%  } %>
				</tr>
				<tr>
					<td>In </td><% for(int i=0;i<=31;i++){%>
					<td>$in<%=i%>$</td>	<% } %>
				</tr>
				<tr>
					<td>Out Time</td><% for(int i=0;i<=31;i++){%>
					<td>$out<%=i%>$</td><% } %>
					</tr>
				<tr>
					<td>Work</td><% for(int i=0;i<=31;i++){%>					
						<td>$Work<%=i%>$</td>					<% } %>
				</tr>
				<tr>
					<td>Status</td>			<% for(int i=0;i<=31;i++){%>	
					<td>$Status<%=i%>$</td>				<% } %>
				</tr>
				<tr>
					<td>Excess</td>		<% for(int i=0;i<=31;i++){%>
					<td>$Excess<%=i%>$</td>					<% } %>
				</tr>
			</table>
</div>
	<input type="hidden" name="csvString" id="csvString"> <input
		type="hidden" name="reportFileName" value="Monthly_Time_Card_Grid.csv">
</form>
<script>
function search() {
	document.forms[0].action='employeeTimeCard';
	document.forms[0].submit(); 
} 
function cancelNavigation() {
	document.forms[0].action='reportsIndex';
	document.forms[0].submit(); 
}
</script>
<%@include file="common/footer.jsp"%>