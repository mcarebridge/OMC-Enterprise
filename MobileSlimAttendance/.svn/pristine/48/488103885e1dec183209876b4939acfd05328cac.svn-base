<%@include file="common/common.jsp"%>
<%@include file="common/header.jsp"%>
	<script type="text/javascript">
				function dataPresent() {
					if(document.getElementById("userName").value!="")
						{
							document.getElementById("submit").disabled=false;
						}
					else
						{
							document.getElementById("submit").disabled=true;
						}
			}
	</script>
</head>
<%@include file="common/pageUpper.jsp"%>
<body>

	<div
		style="width: 100%; height: 15px; border: 0px solid red; margin: 15px 0 0 0; " align="center" onmousemove="javascript:dataPresent()" >
		<form method="post" action="forgotPassword" >
			<table width="100%" align="left" summary="Test" cellpadding="2px" >
					<tr>
						<td width="50%"
							style="font: bold 11px Verdana, Helvetica, Arial, sans-serif;">
							Please Enter Your Registered Email Address:
						</td>
						<td>
							<input type="text" name="userName" id="userName" >		
						</td>
					</tr>
					<tr >
						<td colspan="2"  >
					
					
							<input class="select1" id="submit" type="submit" name="actionParam" value="Submit" width="100px" disabled="disabled" >
							<input class="select1" type="submit" name="actionParam" value="Cancel">
						</td>
					</tr>
			</table>
			
			
		</form>
	</div>
	
	<%@include file="common/footer.jsp"%>