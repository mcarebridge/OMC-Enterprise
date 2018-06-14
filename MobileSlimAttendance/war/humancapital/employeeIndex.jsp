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
<form method="post" action="printEmployeeLabels">
<input type="hidden" name="actionParam" value="printEmployeeLabels">
<div class="secondarymenu" style="height: 400px; width: 98%;  vertical-align: middle; margin-left: 40px ">
	<ol style="font-size: 12px;font-family: 'Gruppo', cursive; position:relative;
						left:30px; padding-top: 5px">
			<li type=disc  style="font-family: 'Gruppo', cursive;padding-top: 5px"><a
				href="/humancapital/addEmployee">Create Employee</a></li>
		
			<li type=disc  style="font-family: 'Gruppo', cursive;padding-top: 5px"><a
				href="/humancapital/employeeList">View Employees</a></li>
		
			<li type=disc  style="font-family: 'Gruppo', cursive;padding-top: 5px"><a
				href="javascript:listAndPrint();">Print Labels</a></li>
	</ol>
</div>
</form>
<%@include file="common/footer.jsp"%>