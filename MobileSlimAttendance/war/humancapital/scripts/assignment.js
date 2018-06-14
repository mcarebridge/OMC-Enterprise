function validate(isDepartment) {
	
	//alert("Inside Validate");
	var flag=false;
	var form = document.forms[0];
	var assignemntIdArr = form.elements['assignmentId'];
	var employeeIdArr = form.elements['employeeId'];
	var locationArr = form.elements['location'];
	var shiftArr = form.elements['shiftId'];
	var startDateArr = form.elements['startDate'];
	var endDateArr = form.elements['endDate'];
	var statusArr = form.elements['status'];
	var currentDateStr= document.getElementById("currentDate").value;
	var today = getDateFromString(currentDateStr.substring(0,10));
	var currernt_hh =currentDateStr.substring(11,13)*1;
	var current_mm =currentDateStr.substring(14,16)*1;
	var minFromMidnight= (currernt_hh*60)+current_mm;
	
	var departmentIdArr;
	var departmentArr;
	if(isDepartment=='Y') {
		departmentIdArr = form.elements['departmentId'];
		departmentArr = form.elements['department'];
	}
	
	var validateArr = form.elements['validated'];
	var validateCnt=0;
	
	
	
	for(cnt=0;cnt<assignemntIdArr.length;cnt++)
	{
		
		
		var locationId=locationArr[cnt].value;
		var shiftId=shiftArr[cnt].value;
		var startDate=startDateArr[cnt].value;
		var endDate=endDateArr[cnt].value;
		
		if(locationId=='' && shiftId=='' && startDate=='' && endDate==''){
			flag=false;
			
		} 
		else 
		{
				var startDt = getDateFromString(startDateArr[cnt].value);
				var endDt= getDateFromString(endDateArr[cnt].value);
				
				if(startDt<today && statusArr[cnt].value!='CURRENT' ) {
					alert("Start date can not be past date.");
					return false;
				} 
				if(startDt==today &&  statusArr[cnt].value!='CURRENT') {
					
					shfiftStartTime =shiftId.substring(shiftId.length-4,shiftId.length); 
					
					var shiftStartHrs=shfiftStartTime.substring(0,2)*1;
					var shiftStartMin=shfiftStartTime.substring(2,4)*1;
					var shiftStartMinsFromMidinght= (shiftStartHrs*60)+shiftStartMin;


//					if(minFromMidnight>shiftStartMinsFromMidinght) {
//						alert("Can not assign as Shift is alreay started/ended for today.");
//						return false;
//					} 
					
					
				} 
				if(startDt>endDt) {
					alert("End Date can not be less then Start Date.");
					return false;
					
				}
				if(today>endDt) {
					alert("End date can not be past date.");
					return false;
				}
				if(assignemntIdArr[cnt].value!='' && endDt<today) {
					
					alert("End date can not be less then current date.");
					return false;
				}
					
				
					validateCnt++;
					validateArr[cnt].value="true";
					
					
				
			
		}
	
		
	}
	if(validateCnt>0 ){
		
          for(counter=0;counter<assignemntIdArr.length;counter++) {
			
			
			if(validateArr[counter].value=="true") {
				
				//shiftArr[counter].disabled=false;
				startDateArr[counter].disabled=false;
				endDateArr[counter].disabled=false;
				
				if(isDepartment=='Y') {
					departmentArr[counter].disabled=false;
				}
			}
			
		}
		
		flag=true;
	}
	
	//alert("End Validate= " +flag);
	return flag;
}
function populateShiftList(val,counter,isDepartment) {
	
	
	
	if(val!='') {
		var url = "jsonRequest?actionParam=shiftListRequest&locationId="+val;
		if(isDepartment=='Y')  {
			url=url+'&isDepartment=Y';
		}
		$.getJSON(url, 
		        function(data){
			
			
	    	var str ='<select class="shiftSelect1" name="shift" id="shift_'+counter+'" onchange="javascript:setShfitId('+counter+');" ><option value="">Select</option>';
	    	
	    	for(cnt=0;cnt<data.shiftList.length;cnt++) {
				str=str+'<option value='+data.shiftList[cnt].shiftId +'>'+data.shiftList[cnt].shiftName+'</option>';
			} 
    		str=str+'</select>';
    		var id='#shiftDiv_'+counter
    		$(id).html(str);
    		
    		if(isDepartment=='Y')  {
    			
    			
    	    	var str1 ='<select class="locationSelect" name="department" id="departmentSelect_'+counter+'" onchange="javascript:setDepartmentId('+counter+');" ><option value="">Select</option>';
    	    	
    	    	for(cnt1=0;cnt1<data.departmentList.length;cnt1++) {
    				str1=str1+'<option value='+data.departmentList[cnt1].departmentId +'>'+data.departmentList[cnt1].departmentName+'</option>';
    			}                                                                                                
        		str1=str1+'</select>';
        		var id1='#departmentDiv_'+counter
        		$(id1).html(str1);
    		}
    		
		 });
	
}
}
function setDataTable() {
	
	
	$('#results').dataTable( { 
		"sPaginationType": "full_numbers",
		"bLengthChange":false,
		"bFilter":false,
	    "bInfinite":false
		} ); 
}

function setSelectedIndex(s, v) {  
	var len = 0;
	var val=0;
	var shiftId=0;
	
	
	  for ( var i = 0; i < s.options.length; i++ ) 
	  {        
		   val= s.options[i].value;
		   len=val.length;
		  shiftId=val.substring(0,len-4);
		  if ( shiftId == v ) 
	      {  
	          s.options[i].selected = true;            
	          return;        
	      }    
	 }
	}
function setUpPageComponents(len,isDepartment) {
	
	
	
	var form = document.forms[0];
	var assignemntIdArr = form.elements['assignmentId'];
	var locationArr = form.elements['location'];
	var shiftArr = form.elements['shift'];
	var locationIdArr = form.elements['locationId'];
	var departmentIdArr;
	var departmentArr;
	if(isDepartment=='Y') {
		departmentIdArr = form.elements['departmentId'];
		departmentArr = form.elements['department'];
	}
	var shiftIdArr = form.elements['shiftId'];
	var editable = form.elements['editable'];
	for(cnt=0;cnt<len;cnt++) {
		var startDateId="#startDate_"+cnt;
		var endDateId="#endDate_"+cnt;
		
		var disableFlag=false;
		if(editable[cnt].value=="N") {
			disableFlag=true;
		}
		$(startDateId).datepicker({
			showOn: "button",
			buttonImage: "images/calendar.gif",
			buttonImageOnly: true,
			disabled:disableFlag
		});
		$( endDateId).datepicker({
			showOn: "button",
			buttonImage: "images/calendar.gif",
			buttonImageOnly: true,
			disabled:disableFlag
		});
		//$(endDateId).rules('add', { greaterThan: startDateId });  	
		if(assignemntIdArr[cnt].value==''){
			document.getElementById("ass_"+cnt).style.background="red";
		} else {
			document.getElementById("ass_"+cnt).style.background="#32CD32";
		}
		
		
		locationArr[cnt].value=locationIdArr[cnt].value;
		if(isDepartment=='Y') {
		departmentArr[cnt].value=departmentIdArr[cnt].value;
		}
		setSelectedIndex(shiftArr[cnt],shiftIdArr[cnt].value);
		if(disableFlag) {
			locationArr[cnt].disabled=true;
			shiftArr[cnt].disabled=true;
			if(isDepartment=='Y') {
				departmentArr[cnt].disabled=true;
			}
		}
		
	}
}

function getDateFromString(val) {
	var tempDate= parseDate(val);
	return tempDate.getTime();
}

function editRecord(ind)  {
	var calInd= ind%10;
	var endDateId="#endDate_"+ind;
	var lockedId="locked_"+ind;
	if(document.getElementById(lockedId).value=='') {
		
		$( endDateId).datepicker('enable');
	} else {
		alert("Can not edit a locked assignment.")
	}

}
function setShfitId(ind)
{
 
	var calInd=ind%10;
	var shiftInd="shift_"+ind;
	var shiftIdInd="shiftId_"+ind;
	var temp= document.getElementById(shiftInd).value;
	var shiftId= temp.substring(0,temp.length-4);
	//alert("shiftId=" + shiftId);
	//document.forms[0].elements['shiftId'][calInd].value=shiftId;
	 document.getElementById(shiftIdInd).value=shiftId;
	
}

function setDepartmentId(ind)
{
	var departmentSelectInd="departmentSelect_"+ind;
	var departmentFieldId= "departmentId_"+ind;
	document.getElementById(departmentFieldId).value= document.getElementById(departmentSelectInd).value;
	
}

