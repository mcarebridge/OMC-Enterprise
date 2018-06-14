<%@include file="common/common.jsp"%>
<%@include file="common/header.jsp"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<style type='text/css'>
.bold-green-font {
	font-weight: bold;
	color: green;
}

.bold-font {
	font-weight: bold;
}

.right-text {
	text-align: right;
}

.large-font {
	font-size: 14px;
}

.italic-darkblue-font {
	font-style: none;
	color: darkblue;
}

.italic-purple-font {
	font-style: italic;
	color: purple;
}

.underline-blue-font {
	text-decoration: underline;
	color: blue;
}

.gray-border {
	border: 3px solid gray;
}

.deeppink-border {
	border: 3px solid deeppink;
}

.orange-background {
	background-color: orange;
}

.orchid-background {
	background-color: orchid;
}

.beige-background {
	background-color: beige;
}
</style>
<!-- ****************************************************************  -->
<link href="styles/main.css" rel="stylesheet" type="text/css">
<!--Load the AJAX API-->
<script type="text/javascript" src="https://www.google.com/jsapi"></script>
<script type="text/javascript"
	src="scripts/jquery-1.6.2.js"></script>
<script type="text/javascript"
	src="scripts/jquery.dataTables.js"></script>
<script type="text/javascript"
	src="scripts/jquery-ui-1.8.16.custom.js"></script>
<script type="text/javascript"
	src="scripts/date.js"></script>
<script type="text/javascript"
	src="scripts/jquery.ui.datepicker.js"></script>
<script>

$(document).ready(function(){
	
	var searchCriteria =document.forms[0].elements['searchCriteria'].value;
	if(searchCriteria=='city') {
		removeDatePicker();
		$("#searchText").hide();
		$("#city").show();
		
	}
});
function search() {
	document.forms[0].elements["searchText"].disabled=false;
	document.forms[0].actionParam.value = 'listAndPrintSearch';
	document.forms[0].submit();
}

function setDatePicker() {
	
	document.getElementById("searchText").disabled=true;
	
	$("#searchText").datepicker({
		showOn : "button",
		buttonImage : "images/calendar.gif",
		buttonImageOnly : true
	});
}

function removeDatePicker() {
	
	$("#searchText").datepicker("destroy");
}

function setMsg() {

	
	var searchCriteria =document.forms[0].elements['searchCriteria'].value;
	var msg='';
	document.getElementById("searchText").disabled=false; 
	if(null!=searchCriteria || searchCriteria !='') {
		
		document.forms[0].elements['searchText'].value='';
		
		if(searchCriteria=='companyEmpId') {
			removeDatePicker();
			msg='Please enter the complete employee Id. Ex- 8001-1001'
				$("#searchText").show();
			$("#city").hide();
		} else if(searchCriteria=='firstName') {
			removeDatePicker();
			msg='Please enter atleast first 3 character of First Name.Ex To search a employee with first name George,enter a search string Geo. This search is case sensitive'
				$("#searchText").show();
			$("#city").hide();
		} else if(searchCriteria=='lastName') {
			removeDatePicker();
			msg='Please enter atleast first 3 character of Last Name.Ex To search a employee with last name Smith,enter a search string Smi. This search is case sensitive.'
				$("#searchText").show();
			$("#city").hide();
		}  else if(searchCriteria=='startDate') {
			msg='Please select date.';
			setDatePicker();
			$("#searchText").show();
			$("#city").hide();
		} else if(searchCriteria=='city') {
			removeDatePicker();
			$("#searchText").hide();
			$("#city").show();
			
		}	else {
		
			removeDatePicker();
		}
		
	} else {
		
		msg='';
		
	}
	
	document.getElementById("msgTd").innerHTML=msg;
}



function resetAll() {
	document.forms[0].elements['searchCriteria'].value='';
	document.forms[0].elements['searchText'].value='';
	
	document.forms[0].elements['employeeType'][0].checked=false;
	document.forms[0].elements['employeeType'][1].checked=false;
	document.forms[0].elements['employeeType'][2].checked=false;
}

function backToMain() {
	
	document.forms[0].actionParam.value = 'backToMain';
	document.forms[0].submit();
}
</script>	
<script type="text/javascript">

	google.load('visualization', '1', {packages:['table, charteditor,corechart']});
	
	<c:if test="${employeeListSize > 0}">
	google.setOnLoadCallback(drawVisualization);
	</c:if>
	
	
	 

<!-- Load Tables -->
		
		function drawVisualization() {
		  // Create and populate the data table.
		  
		  var cssClassNames = {
    		'headerRow': 'italic-darkblue-font large-font normal-font',
    		'tableRow': '',
    		'oddTableRow': 'beige-background',
    		'selectedTableRow': 'orange-background large-font',
    		'hoverTableRow': '',
    		'headerCell': 'gray-border',
    		//'tableCell': 'large-font gray-border',
    		'rowNumberCell': 'underline-blue-font'};
		 
		  var data = new google.visualization.DataTable();
		  data.addColumn('string', 'Column-1');
		  data.addColumn('string', 'Column-2');
		  data.addColumn('string', 'Column-3');
		  //data.addColumn('string', 'Column-4');
		  

		  var i = 0;
		  var j = 0;
		 
		 <c:forEach var="item" items="${requestScope.employeeList}">
		 			if(j == 0){
		            	data.addRows(1);
		 			}
			  		
			  		data.setCell(i,j,"<table width='75%' height='175px'><tr><td><table><tr><td>Company:</td><td>${item.companyRef.model.companyName}</td></tr><tr><td>EmplId</td><td>${item.companyEmpId}</td></tr><tr><td>Name</td><td>${item.salutation} ${item.firstName} ${item.lastName}</td></tr><tr><td>Gender</td><td>${item.gender}</td></tr><tr><td>Start Date</td><td>${item.startDate}</td></tr></table></td><td><img src='https://chart.googleapis.com/chart?chs=140x140&amp;chld=L|2&amp;cht=qr&amp;chl=${f:h(item.companyRef.key.id)}&#64;${f:h(item.companyEmpId)}&amp;choe=UTF-8' alt='QR code' /></td></tr></table>");					
			  		/*
			  		if("${item.isSuperwiser}.equals('Y')")
			  		{
			  			data.setCell(i,j,"<table width='75%' height='175px'><tr><td><table><tr><td>Company:</td><td>${item.companyRef.model.companyName}</td></tr><tr><td>EmplId</td><td>${item.companyEmpId}</td></tr><tr><td>Name</td><td>${item.salutation} ${item.firstName} ${item.lastName}</td></tr><tr><td>Gender</td><td>${item.gender}</td></tr><tr><td>Start Date</td><td>${item.startDate}</td></tr></table></td><td><img src='https://chart.googleapis.com/chart?chs=140x140&amp;chld=L|2&amp;cht=qr&amp;chl=${f:h(item.companyRef.key.id)}&#64;${f:h(item.companyEmpId)}&#64;${f:h(item.imeiCode)}&amp;choe=UTF-8' alt='QR code' /></td></tr></table>");
					}
			  		else
			  		{
				  		data.setCell(i,j,"<table width='75%' height='175px'><tr><td><table><tr><td>Company:</td><td>${item.companyRef.model.companyName}</td></tr><tr><td>EmplId</td><td>${item.companyEmpId}</td></tr><tr><td>Name</td><td>${item.salutation} ${item.firstName} ${item.lastName}</td></tr><tr><td>Gender</td><td>${item.gender}</td></tr><tr><td>Start Date</td><td>${item.startDate}</td></tr></table></td><td><img src='https://chart.googleapis.com/chart?chs=140x140&amp;chld=L|2&amp;cht=qr&amp;chl=${f:h(item.companyRef.key.id)}&#64;${f:h(item.companyEmpId)}&amp;choe=UTF-8' alt='QR code' /></td></tr></table>");			  			
			  		}
			  		*/
					j++;
					if(j == 3){
						j = 0;
						i++;
					}
		  </c:forEach>
		  
		  <c:if test="${modThree != 0}">
	
		  <c:if test="${employeeListSize <3}">
		  for(cnt=j;cnt<3;cnt++) {
			  data.setCell(i,cnt,"<table width='75%' height='175px'><tr><td><table><tr><td></td><td></td></tr><tr><td></td><td></td></tr><tr><td></td><td></td></tr><tr><td></td><td></td></tr><tr><td></td><td></td></tr></table></td><td><img src='images/blanklabel.png' height='140' width='370' /></td></tr></table>");
		  }
		  
		  </c:if>
		</c:if>
		  // Create and draw the visualization.
		  var table = new google.visualization.Table(document.getElementById('empList'));
		  table.draw(data, {allowHtml: true, 'cssClassNames': cssClassNames, showRowNumber: true, page:'enable', pageSize : 15, sortAscending:true, sortColumn:0});
		  }	
</script>
</head>
<%-- 
<%@include file="common/pageUpper.jsp"%>
--%>
<body>
<div id="wrapper">

<c:if test="${requestScope.showHeader == true}">
			<div id="header">
				<span>${sessionScope.currentUser.employeeRef.model.firstName}&nbsp;${sessionScope.currentUser.employeeRef.model.lastName}</span> 
				<span title="${sessionScope.currentUser.companyRef.model.companyName}">${fn:substring(sessionScope.currentUser.companyRef.model.companyName,0,15)}</span> <span><a
					href="/humancapital/logout">Logout</a></span>
			</div>
			<div id="Nav">
			        <ul id="maintab" class="basictab">
			        
				 <li>  <a href="/humancapital/home" class="active">Dashboard</a></li> 
				 
				  <li  rel="location_submenu"><a href="/humancapital/addLocation">Location</a> </li>
				  <li  rel="shift_submenu"><a href="/humancapital/addShift">Shift</a> </li>
				  <li  rel="employee_submenu"><a href="/humancapital/employeeIndex" >Employee</a></li> 
				  <li  rel="assignment_submenu"><a href="/humancapital/assignment">Assignment</a></li>
				  <li  rel="assignment_submenu"><a href="/humancapital/createContractorCompany">Contractor</a></li>  
				  <li  rel="reports_submenu" ><a href="/humancapital/reportsIndex">Reports</a></li>
				  <li><a href="/humancapital/configureTimeSheetRule">Configuration</a></li>
				</ul>
			</div>
		</c:if>
			<div id="contentWrapper">
        	<div>
				<h2
					style="float: right; color: #6699CC; font-size: 8px; right; padding: 10px 10px 0px 0px">TM</h2>
				<a href='/' class='logo'>OneMasterControl</a>
			</div>
			<div class="left">
				<div class="content">
<form method="post" action="printEmployeeLabels">
<input type="hidden" name="actionParam" value="listAndPrintSearch">
		<table width='100%' style="padding: 0px;">
			<tr>
				<td>
					<div class='controlbox'>
					     <div class="about">
					     <c:if test="${requestScope.showErrBox == true}">
							
							<span id="errormsg" class="error_main"> <a
								href="javascript:hidediv()">X</a>
								<h3>Please check the following error(s):</h3> <span
								class="error_list"> <c:forEach var="e"
										items="${f:errors()}">
										<li>${f:h(e)}</li>
									</c:forEach>
									<ul>
									</ul>
							</span></span>
						</c:if>
					    </div>
						<table width='99%' cellpadding="0" cellspacing="0" style="padding: 0px;">
							<tr>
							    <td width="32%"><input type="radio" ${f:radio("employeeType", "1")} > Company Employee  &nbsp;&nbsp;<input type="radio" ${f:radio("employeeType", "2")}> Contractor's Employee&nbsp;&nbsp;
								<input type="radio" ${f:radio("employeeType", "3")}>Show All</td>
							   <td width="30%">Search Criteria :&nbsp;&nbsp;
								<select name="searchCriteria" onchange="javascript:setMsg();">
								<option ${f:select("searchCriteria","")}>Select</option>
								<option ${f:select("searchCriteria","companyEmpId")}>Employe Id =</option>
								<option ${f:select("searchCriteria","firstName")}>First Name</option>
								<option ${f:select("searchCriteria","lastName")}>Last Name</option>
								<option ${f:select("searchCriteria","startDate")}>Start Date >=</option>
								<option ${f:select("searchCriteria","city")}>City</option>
						        </select> &nbsp;&nbsp; <input type="text"  ${f:text("searchText")} id="searchText" style="width: 70px;">
						       	<select name="searchCity"	id="city" style="display: none">
									<option name="searchCity" value="">Select city</option>
									<c:forEach var="e" items="${requestScope.cities}">
									<option  ${f:select("searchCity",f:h(e))}>${f:h(e)}</option>
									</c:forEach>
								</select>
						        </td>
						        <td width="37%" id="msgTd"></td>
							
                                								
							</tr>
							
							<tr>
							    <td width="32%"></td>
							   <td width="27%"></td>
							<td width="40%" align="right"><input type="button" value="Search" name="Search"
									onclick="javascript:search();" class='select1'> &nbsp;&nbsp;
									<input type="reset" value="Reset" name="Reset"
									class='select1' onclick="javascript:resetAll();">
									&nbsp;&nbsp;
									<input type="button" value="Cancel" name="Cancel"
									onclick="javascript:backToMain();" class='select1'>
									
									</td>
                                								
							</tr>
						</table>
					</div>
				</td>
			</tr>
			<tr>
				<td>
		<div id="empList" style='width:'90%';overflow-y: hidden;horizontal-align:center;'></div>
		</td>
		</tr>
		<tr>
		<td><c:if test="${searchResultsDisplay  != null}">
	
	
       <c:if test="${employeeListSize == 0}">
    <div id="noResultFound"  style="text-align:center;width:'90%'; horizontal-align:'center';font: 12px Verdana, Arial, Helvetica, sans-serif; ">No matching Record found Or Employee is inactive.</div>
      
	   </c:if>
	
	</c:if></td>
		</tr>
		</table>
		
		
	</form>
	
	
	
	
	</div>
	</div>
	</div><!-- content wrapper -->
</div><!-- wrapper -->
<script>

if(document.forms[0].elements['searchCriteria'].value=='startDate') {
	setDatePicker();
}
  
</script>
</body>
</html>

<%-- 
<%@include file="common/footer.jsp"%>
--%>