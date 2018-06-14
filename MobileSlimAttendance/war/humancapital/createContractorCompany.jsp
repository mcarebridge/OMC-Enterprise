<%@include file="common/common.jsp"%>
<%@include file="common/header.jsp"%>
<!-- start header -->
<script type="text/javascript"
	src="scripts/jquery-1.6.2.js?updated=<%=new Date()%>"></script>
<script type="text/javascript"
	src="scripts/jquery.dataTables.js?updated=<%=new Date()%>"></script>
<script type="text/javascript"
	src="scripts/jquery-ui-1.8.16.custom.js?updated=<%=new Date()%>"></script>
<script type="text/javascript"
	src="scripts/date.js?updated=<%=new Date()%>"></script>
<script>

		function clearFields()  {
			
			document.forms[0].elements['companyName'].value="";
			document.forms[0].elements['emplyoeePopulation'].value="";
			document.forms[0].elements['firstName'].value="";
			document.forms[0].elements['lastName'].value="";
			document.forms[0].elements['phone'].value="";
			document.forms[0].elements['cell'].value="";
			document.forms[0].elements['userName'].value="";
			document.forms[0].elements['line1'].value="";
			document.forms[0].elements['line2'].value="";
			document.forms[0].elements['city'].value="";
			document.forms[0].elements['country'].value="";
			document.forms[0].elements['state'].value="";
			document.forms[0].elements['pinCode'].value="";
			
		}
		</script>
</head>
<%@include file="common/pageUpper.jsp"%>		
<form method="post" action="createContractorCompany">
<input type="hidden" name ="actionParam" value="createContractor">
    
    <table width="91%" align="left"  summary="Test" cellpadding="2px" >
    
    <c:if test="${createdContractor != null}">
				<tr>
				<td colspan="2" > <b> <fmt:message key="${requestScope.createdContractor}" /></b> 
				</td>
				    
				</tr>
				</c:if>
  
   <tr>
    <td>Company Name<span>*</span></td>
    <td><input type="text" ${f:text("companyName")} size="50"></td>
    </tr>
  </tr> 
  <tr>
					<td valign="top">Employee population <span>*</span></td>

					<td><input type="text"
						${f:text("emplyoeePopulation")} size="50" class="cityField">
					</td>
					</tr>
  
   <tr>
    <td valign="top">Salutation </td>
    <td><select name="salutation" class="salutationSelect">
    <option value="Mr.">Mr.</option>
    <option value="Mrs.">Mrs.</option>
    <option value="Ms.">Ms.</option>
    </select></td>
  </tr>
  <tr>
    <td valign="top">First Name <span>*</span></td>
    <td><input type="text"  ${f:text("firstName")}  size="50" class="nameField"></td>
  </tr>
  <tr>
    <td valign="top">Last Name <span>*</span> </td>
    <td><input type="text"  ${f:text("lastName")}   size="50" class="nameField"></td>
  </tr>
    <td>Telephone <span>*</span></td>
    <td><input type="text"   ${f:text("phone")} size="50" class="zip"></td>
  </tr>
  <tr>
    <td>Cell Phone <span>*</span></td>
    <td><input type="text" ${f:text("cell")}  size="50" class="zip"></td>
  </tr>
  <tr>
    <td>Email Address <span>*</span></td>
    <td><input type="text"  ${f:text("userName")}  size="50"></td>
  </tr>
   <tr>
    <td></td>
    <td>Email Address will be used as Username for the application</td>
  </tr>
 
  <tr>
    <td valign="top">Address Line 1 <span>*</span></td>

    <td><input type="text"  ${f:text("line1")}   cols="49" ></td>
  </tr>
  <tr>
    <td valign="top">Address Line 2</td>

    <td><input type="text" ${f:text("line2")} cols="49" ></td>
  </tr>
  <tr>
    <td valign="top">City <span>*</span></td>
    <td><input type="text" ${f:text("city")} size="50" class="cityField"></td>
  </tr>
  <tr>
    <td valign="top">Country <span>*</span></td>
    <td><select name="country" class="countrySelect" id="country">
    <option value="">Select Country</option>
    <c:forEach var="e" items="${sessionScope.countryList}">
				<option ${f:select("country",f:h(e.key.id))}>${f:h(e.countryName)}</option>
			</c:forEach>
    </select></td>
  </tr>
  <tr>
    <td>State <span>*</span></td>
    <td>
    <div id="stateDiv">
    <select name="state">
						<option value="">Select State</option>
					 <c:forEach var="e" items="${requestScope.stateList}">
						<option ${f:select("state",f:h(e.key.id))}>${f:h(e.stateName)}</option>
					 </c:forEach>
					</select>
					</div>
					</td>
    
  </tr>
  <tr>
    <td>Zip <span>*</span></td>
    <td><input type="text"  ${f:text("pinCode")}  size="20" class="zip"></td>
  </tr>
  <tr>
  <tr>
    <td>&nbsp;</td>
    <td align="left">
    <input type="submit" width="100px" value="Create" name="Create" title="Create" class="select1"">
    <input type="reset" value="Reset" name="Reset" title="Reset" class="select1">
      </td>
  </tr>
 
</table>

</fieldset>
<input type="hidden" name =userProfile" value="1006">
<script type="text/javascript">
$(function() { 
    $('#country').click( function() {
    	
    	var val = $(this).val(); 
    	if(val!='') {
    		
    		$.getJSON("jsonRequest?actionParam=stateListRequest&countryId="+val, 
    		        function(data){
    			
    			var str ='';
    	    	var str ='<select class="stateSelect" name="state" >';
    	    	for(cnt=0;cnt<data.stateList.length;cnt++) {
    				str=str+'<option value='+data.stateList[cnt].stateId+'>'+data.stateList[cnt].stateName+'</option>';
    			} 
        		str=str+'</select>';
        		$('#stateDiv').html(str);
    		 });
    		
    	} 
    }); 
});
$(function() { 
    $('#country').change( function() {
    	
    	var val = $(this).val(); 
    	if(val!='') {
    		
    		$.getJSON("jsonRequest?actionParam=stateListRequest&countryId="+val, 
    		        function(data){
    			
    			var str ='';
    	    	var str ='<select class="stateSelect" name="state" >';
    	    	for(cnt=0;cnt<data.stateList.length;cnt++) {
    				str=str+'<option value='+data.stateList[cnt].stateId+'>'+data.stateList[cnt].stateName+'</option>';
    			} 
        		str=str+'</select>';
        		$('#stateDiv').html(str);
    		 });
    		
    	} 
    }); 
});

</script>

			<%
			  if(request.getAttribute("initialLoad")!=null) {%>
			  <script  type="text/javascript">
			  clearFields();
			  </script>
				  
			<%  }
			%>
	</form>

<%@include file="common/footer.jsp"%>

