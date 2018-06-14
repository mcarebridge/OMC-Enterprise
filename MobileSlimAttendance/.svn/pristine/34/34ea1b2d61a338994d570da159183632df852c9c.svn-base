<%@include file="common/common.jsp"%>
<%@include file="common/header.jsp"%>
<style>
.required_string{ float:right; font:9px Verdana, Arial, Helvetica, sans-serif; color:#555555; clear:both; margin: 0 51% 10px 0;}
.required_string span{font: 10px Verdana, Arial, Helvetica, sans-serif; color: #dd0f13;}
.error_main{ float: left; width: 45%; padding: 15px; background: #F2F2F2; border:1px dashed #ddd; margin: 0 0 10px 100px; }
.error_main a, .about .error_main a:hover, .about.error_main a:visited{ text-decoration:none; display: inline-block; float: right; font: normal 10px Verdana; color: #71717; text-align:right; padding:5px; margin: -5px; }
.error_main h3{ display: block; loat:left; font: bold 12px Verdana; color: red; margin: 5px 15px;}
.error_main ul{ list-style-type: disc; display: block; float:left; font: normal 11px Verdana; color: red; margin: 5px 35px; tex-align: left; }
.error_main ul li{font: normal 11px Verdana; color: red; text-align: left;}
.error_main span{font: normal 10px Verdana; color:red;}

</style>

</head>
<body>
	    <form method="post" action="confirmAdminUser">
		     <table style="width: 98%; height: 90%;">
		     
		     <tr>
		         <td>
		         
		           <div style="width: 100%">
						<h2
								style="float: right; color: #6699CC; font-size: 8px; right; padding: 10px 10px 0px 0px">TM</h2>
							<a href='/' class='logo'>OneMasterControl</a>
				  </div>
		         
		         </td>
		     </tr>
		     <tr>
		     
		      <td style="height: 120px">
		      &nbsp;<br><br>
		      
		      </td>
		     </tr>
		     <tr>
		     <td style="width: 100%;" align="center">
		         <div class="content"  style="width: 50%;border: 1px solid #E1E0E6; overflow-y: auto; margin: 5px; background: #f8f8f8; align="center">
		
		   
				<table width="100%" align="center" summary="confirmation"
					cellpadding="2px">
					<tr>
						<td style="height:60px;">
						<c:if test="${requestScope.showErrBox == true}">
							<div class="required_string">
								<span>*</span>Required Fields
							</div>
							<span id="errormsg" class="error_main"> <a
								href="javascript:hidediv()">X</a>
								<h3>Please check the following error(s):</h3> <span> 
								     <c:forEach var="e"
										items="${f:errors()}">
										<li style="text-align: left">${f:h(e)}</li>
									</c:forEach>
									<ul>
									</ul>
							</span></span>
						</c:if>
						
						</td>
					</tr>
					<c:if test="${requestScope.accountVerified == false}">
					<tr>
						<td align="left" style="font-size: 15px;padding-left: 30px;padding-right: 30px;">Your company account has been created - please verify the
							details and create a password to operate the account.</td>
					</tr>
					<tr>
						<td  style="font-size: 15px;height:30px;"></td>
					</tr>
					<tr>
					<td align="center" style="font-size: 15px;">
						<table>
							<tr>
								<td width="60%">Create Password <span>*</span></td>
								<td><input type="password" name="password1" size="10"></td>
							</tr>
							<tr>
								<td width="60%">Confirm Password<span>*</span></td>
								<td><input type="password" name="password2" size="10"></td>
							</tr>
							<tr>
								<td height="20px;"></td>
								<td height="20px;"></td>
							</tr>
							<tr>
								<td><input type="submit" value="Accept" name="accept" title="accept" class='select1'></td>
								<td><input type="button" value="Decline" name="decline" title="decline" class='select1'></td>
							</tr>
						</table>
						</td>
					</tr>
					<tr>
						<td align="left" style="font-size: 15px;padding-left: 30px;padding-right: 30px;height: 10px;"></td>
					</tr>
					<tr>
						<td align="left" style="font-size: 15px;padding-left: 30px;padding-right: 30px;">Password Rules:</td>
					</tr>
					<tr>
						<td align="left" style="font-size: 15px;padding-left: 30px;padding-right: 30px;">1. Password length should be between 8 to 12 characters.</td>
					</tr>
					<tr>
						<td align="left" style="font-size: 15px;padding-left: 30px;padding-right: 30px;">2. Password should contain at least one digit (0-9). </td>
					</tr>
					<tr>
						<td align="left" style="font-size: 15px;padding-left: 30px;padding-right: 30px;">Ex. mypassword1 </td>
					</tr>
					</c:if>
					<c:if test="${requestScope.accountVerified == true}">
					<tr>
						<td align="left" style="font-size: 14px;padding-left: 13px;padding-right: 10px;">Your company account has been already activated.Please click following link to login.</td>
					</tr>
					<tr>
						<td style="height: 15px;"></td>
					</tr>
					<tr>
						<td align="center" style="font-size: 14px;padding-left: 13px;padding-right: 10px;"><a href="/humancapital/index">Login</a></td>
					</tr>
					</c:if>
					<tr>
						<td style="height: 50px;"></td>
					</tr>
				</table>
			<input type="hidden" ${f:hidden("companyId")} id="companyId">
		
		   </div>
		     </td>
		     </tr>
		     
		      <tr>
		     
		      <td style="height: 150px">
		      &nbsp;<br><br>
		      
		      </td>
		     </tr>
		     </table>
		
			
			
		</form>	
			

        <div id="footer">
	<div class="copyright">
		<div class="tools">Tools</div>
	</div>
</div>		    
</body>
</html>


