<%@include file="common/common.jsp"%>
<!-- for FactSheetDashBoard -->
<script type="text/javascript">
 
 function shiftDashboard(name) {
	
		var d1 = document.getElementById(name);
		var display=d1.style.display;
		$('#pieChart1').hide();
		$('#pieChart2').hide();
		$('#pieChart3').hide();
		$('#pieChart4').hide();
		<c:forEach var="LocationDashboardDto"
			items="${locationDashboardDtoList}">
			$('#${f:h(LocationDashboardDto.location.locationName)}').hide();
			$('#${f:h(LocationDashboardDto.location.locationName)}1').hide();
			$('#${f:h(LocationDashboardDto.location.locationName)}2').hide();
			$('#${f:h(LocationDashboardDto.location.locationName)}3').hide();
			$('#${f:h(LocationDashboardDto.location.locationName)}4').hide();
			$('#${f:h(LocationDashboardDto.location.locationName)}5').hide();
		<c:forEach var="shiftDashboardDto"
			items="${LocationDashboardDto.shiftDashboardList}">
			
			$('#${f:h(shiftDashboardDto.shift.shiftName)}${f:h(LocationDashboardDto.location.locationName)}1').hide();
			$('#${f:h(shiftDashboardDto.shift.shiftName)}${f:h(LocationDashboardDto.location.locationName)}2').hide();
			$('#${f:h(shiftDashboardDto.shift.shiftName)}${f:h(LocationDashboardDto.location.locationName)}3').hide();
			$('#${f:h(shiftDashboardDto.shift.shiftName)}${f:h(LocationDashboardDto.location.locationName)}4').hide();
		
		</c:forEach>
		</c:forEach>
		
	//	alert("hi");
	//	alert(display);
		if(display=="block" || display==""){
			$('#' + name).hide();
			$('#' + name + '1').hide();
			$('#' + name + '2').hide();
			$('#' + name + '3').hide();
			$('#' + name + '4').hide();
			$('#' + name + '5').hide();
			$('#pieChart1').show();
			$('#pieChart2').show();
			$('#pieChart3').show();
			$('#pieChart4').show();
		}else 
		{
			$('#' + name).show();
			$('#' + name + '1').show();
			$('#' + name + '2').show();
			$('#' + name + '3').show();
			$('#' + name + '4').show();
			$('#' + name + '5').show();
			window.location='#' + name + '1';
		}
		
	}
	function shiftPie(shiftName,locationName) {
		//	alert("--"+name+"--");
		var d1 = document.getElementById(shiftName+""+locationName+""+1);
		var display=d1.style.display;
		<c:forEach var="LocationDashboardDto"
			items="${locationDashboardDtoList}">
			$('#${f:h(LocationDashboardDto.location.locationName)}2').hide();
			$('#${f:h(LocationDashboardDto.location.locationName)}3').hide();
			$('#${f:h(LocationDashboardDto.location.locationName)}4').hide();
			$('#${f:h(LocationDashboardDto.location.locationName)}5').hide();
			<c:forEach var="shiftDashboardDto"
				items="${LocationDashboardDto.shiftDashboardList}">
				
				$('#${f:h(shiftDashboardDto.shift.shiftName)}${f:h(LocationDashboardDto.location.locationName)}1').hide();
				$('#${f:h(shiftDashboardDto.shift.shiftName)}${f:h(LocationDashboardDto.location.locationName)}2').hide();
				$('#${f:h(shiftDashboardDto.shift.shiftName)}${f:h(LocationDashboardDto.location.locationName)}3').hide();
				$('#${f:h(shiftDashboardDto.shift.shiftName)}${f:h(LocationDashboardDto.location.locationName)}4').hide();
			
			</c:forEach>
		</c:forEach>
		
	//	if(display=="block" || display==""){
	//		$('#' + shiftName+""+locationName + '1').hide();
	//		$('#' + shiftName+""+locationName + '2').hide();
	//		$('#' + shiftName+""+locationName + '3').hide();
	//		$('#' + shiftName+""+locationName + '4').hide();
	//		$('#' + locationName + '2').show();
	//		$('#' + locationName + '3').show();
	//		$('#' + locationName + '4').show();
	//		$('#' + locationName + '5').show();
	//	}else 
	//	{		
			$('#' + shiftName+""+locationName + '1').show();
			$('#' + shiftName+""+locationName + '2').show();
			$('#' + shiftName+""+locationName + '3').show();
			$('#' + shiftName+""+locationName + '4').show();
			window.location='#' + shiftName+""+locationName + '1';
	//	}
	}

</script>
<script>
	//Load the Visualization API and the piechart package.
	google.load('visualization', '1.0', {
		'packages' : [ 'corechart' ]
	});
	 google.load('visualization', '1', {packages: ['annotatedtimeline']});
	//google.setOnLoadCallback(drawTable);
	// Set a callback to run when the Google Visualization API is loaded.
	//google.setOnLoadCallback(drawChart);	
	google.setOnLoadCallback(drawVisualization);

function drawVisualization() {

	var pieChart1 = google.visualization.arrayToDataTable([
	                ['Location', 'No of Employee'],
	            	<c:forEach var="LocationDashboardDto" items="${locationDashboardDtoList}">
                  	
	            	['${f:h(LocationDashboardDto.location.locationName)}', 	${f:h(LocationDashboardDto.totalNumOfEmployeesIN)}	], //${f:h(LocationDashboardDto.totalNumOfEmployeesIN)}
                  	
                  	</c:forEach>
                  	[' ',0]               	
                ]);

                // Create and draw the visualization.
        new google.visualization.PieChart(document.getElementById('pieChart1')).
        draw(pieChart1, {title:"Time IN :: Distribution by location",
        	width:300, height:200,
			  chartArea:{left:40,top:20,width:"80%",height:"75%"}
                      });

    var pieChart1 = google.visualization.arrayToDataTable([
   	                ['Location', 'No of Employee'],
   	            	<c:forEach var="LocationDashboardDto"
   						items="${locationDashboardDtoList}">
                     	['${f:h(LocationDashboardDto.location.locationName)}', 	${f:h(LocationDashboardDto.totalNumOfEmployeesOUT)}	], //${f:h(LocationDashboardDto.totalNumOfEmployeesOUT)}
                     </c:forEach>
                     	[' ',0]               	
                   ]);

                   // Create and draw the visualization.
        new google.visualization.PieChart(document.getElementById('pieChart2')).
        draw(pieChart1, {title:"Time OUT:: Distribution by location",
        	width:300, height:200,
			  chartArea:{left:40,top:20,width:"80%",height:"75%"}
                         });
   	var pieChart1 = google.visualization.arrayToDataTable([
 	                ['Location', 'No of Employee'],
 	            	<c:forEach var="LocationDashboardDto1"
 						items="${locationDashboardDtoList1}">
                   	['${f:h(LocationDashboardDto1.location.locationName)}', 	${f:h(LocationDashboardDto1.totalNumOfEmployeesIN)}	], //${f:h(LocationDashboardDto1.totalNumOfEmployeesIN)}
                   </c:forEach>
                   	[' ',0]               	
                 ]);

                 // Create and draw the visualization.
      	new google.visualization.PieChart(document.getElementById('pieChart3')).
        draw(pieChart1, {title:"Time IN :: Distribution by location",
        	width:300, height:200,
			  chartArea:{left:40,top:20,width:"80%",height:"75%"}
                       });
	var pieChart1 = google.visualization.arrayToDataTable([
 	                ['Location', 'No of Employee'],
 	            	<c:forEach var="LocationDashboardDto1"
 						items="${locationDashboardDtoList1}">
                   	['${f:h(LocationDashboardDto1.location.locationName)}', ${f:h(LocationDashboardDto1.totalNumOfEmployeesOUT)}	], //${f:h(LocationDashboardDto1.totalNumOfEmployeesOUT)}
                   </c:forEach>
                   	[' ',0]               	
                 ]);

                 // Create and draw the visualization.
      	new google.visualization.PieChart(document.getElementById('pieChart4')).
        draw(pieChart1, {title:"Time OUT:: Distribution by location",
        	width:300, height:200,
			  chartArea:{left:40,top:20,width:"80%",height:"75%"}
                       });
      	<c:forEach var="LocationDashboardDto"
			items="${locationDashboardDtoList}"> 
			var pieChart1 = google.visualization.arrayToDataTable([
        	                ['Location', 'No of Employee'],
        	                <c:forEach var="shiftDashboardDto"
        						items="${LocationDashboardDto.shiftDashboardList}">
                          	['${f:h(shiftDashboardDto.shift.shiftName)}', 	${f:h(shiftDashboardDto.totalNumOfEmployeesIN)}	], //${f:h(shiftDashboardDto.totalNumOfEmployeesIN)}
                            </c:forEach>
                          	[' ',0]               	
                        ]);

                        // Create and draw the visualization.
             new google.visualization.PieChart(document.getElementById('${f:h(LocationDashboardDto.location.locationName)}2')).
             draw(pieChart1, {title:"Time IN :: ${f:h(LocationDashboardDto.location.locationName)} :: Shift Distribution",
            	 width:300, height:200,
				  chartArea:{left:40,top:20,width:"80%",height:"75%"}
                              });
             var pieChart1 = google.visualization.arrayToDataTable([
         	                ['Location', 'No of Employee'],
         	                <c:forEach var="shiftDashboardDto"
         						items="${LocationDashboardDto.shiftDashboardList}">
                           	['${f:h(shiftDashboardDto.shift.shiftName)}', 	${f:h(shiftDashboardDto.totalNumOfEmployeesOUT)}	], //${f:h(shiftDashboardDto.totalNumOfEmployeesOUT)}
                            </c:forEach>
                           	[' ',0]               	
                         ]);

                         // Create and draw the visualization.
              new google.visualization.PieChart(document.getElementById('${f:h(LocationDashboardDto.location.locationName)}3')).
              draw(pieChart1, {title:"Time OUT :: ${f:h(LocationDashboardDto.location.locationName)} :: Shift Distribution",
            	  width:300, height:200,
 				  chartArea:{left:40,top:20,width:"80%",height:"75%"}
                               });
			
		
		</c:forEach>
		<c:forEach var="LocationDashboardDto"
			items="${locationDashboardDtoList1}"> 
			var pieChart1 = google.visualization.arrayToDataTable([
        	                ['Location', 'No of Employee'],
        	                <c:forEach var="shiftDashboardDto"
        						items="${LocationDashboardDto.shiftDashboardList}">
                          	['${f:h(shiftDashboardDto.shift.shiftName)}', 	${f:h(shiftDashboardDto.totalNumOfEmployeesIN)}	], //${f:h(shiftDashboardDto.totalNumOfEmployeesIN)}
                            </c:forEach>
                          	[' ',0]               	
                        ]);

                        // Create and draw the visualization.
             new google.visualization.PieChart(document.getElementById('${f:h(LocationDashboardDto.location.locationName)}4')).
             draw(pieChart1, {title:"Time IN :: ${f:h(LocationDashboardDto.location.locationName)} :: Shift Distribution",
            	 width:300, height:200,
				  chartArea:{left:40,top:20,width:"80%",height:"75%"}
                              });
             var pieChart1 = google.visualization.arrayToDataTable([
         	                ['Location', 'No of Employee'],
         	                <c:forEach var="shiftDashboardDto"
         						items="${LocationDashboardDto.shiftDashboardList}">
                           	['${f:h(shiftDashboardDto.shift.shiftName)}', 	${f:h(shiftDashboardDto.totalNumOfEmployeesOUT)}	], //${f:h(shiftDashboardDto.totalNumOfEmployeesOUT)}
                            </c:forEach>
                           	[' ',0]               	
                         ]);

                         // Create and draw the visualization.
              new google.visualization.PieChart(document.getElementById('${f:h(LocationDashboardDto.location.locationName)}5')).
              draw(pieChart1, {title:"Time OUT :: ${f:h(LocationDashboardDto.location.locationName)} :: Shift Distribution",
            	  width:300, height:200,
 				  chartArea:{left:40,top:20,width:"80%",height:"75%"}
                               });
			
		
		</c:forEach>
        <c:forEach var="LocationDashboardDto"
				items="${locationDashboardDtoList}">              
			<c:forEach var="shiftDashboardDto"
					items="${LocationDashboardDto.shiftDashboardList}">
				var pieChart1 = google.visualization.arrayToDataTable([
               	                	['In Status', 'No of Employee'],
               	            		['Early In', 	${f:h(shiftDashboardDto.employeeEarlyIN)}	], //${f:h(shiftDashboardDto.employeeEarlyIN)}
                                   	['Right In',	${f:h(shiftDashboardDto.employeeRightIN)}	], //${f:h(shiftDashboardDto.employeeRightIN)} 
                                   	['Late In',		${f:h(shiftDashboardDto.employeeLateIN)}	]	//${f:h(shiftDashboardDto.employeeLateIN)}
                              ]);
				new google.visualization.PieChart(document.getElementById("${f:h(shiftDashboardDto.shift.shiftName)}${f:h(LocationDashboardDto.location.locationName )}1")).
		        draw(pieChart1, {title:"Time IN :: ${f:h(shiftDashboardDto.shift.shiftName)} :: Punctuality",
		        				 width:300, height:200,
		        				 colors: ['#088A08','#FE9A2E', '#DF0101'],
		                      	 chartArea:{left:50,top:20,width:"80%",height:"75%"}
		                       });
				 var pieChart1 = google.visualization.arrayToDataTable([
             	                	['In Status', 'No of Employee'],
             	            		['Early OUT', 	${f:h(shiftDashboardDto.employeeEarlyOUT)}	], //${f:h(shiftDashboardDto.employeeEarlyOUT)}
                                 	['Right OUT',	${f:h(shiftDashboardDto.employeeRightOUT)} 	], //${f:h(shiftDashboardDto.employeeRightOUT)} 
                                 	['Late OUT',	${f:h(shiftDashboardDto.employeeLateOUT)}	], //${f:h(shiftDashboardDto.employeeLateOUT)}
                                 	['No OUT Time',	${f:h(shiftDashboardDto.noOutTime)}			]
                            ]);
				new google.visualization.PieChart(document.getElementById("${f:h(shiftDashboardDto.shift.shiftName)}${f:h(LocationDashboardDto.location.locationName )}2")).
        		draw(pieChart1, {title:"Time OUT :: ${f:h(shiftDashboardDto.shift.shiftName)} :: Punctuality",
        						 width:300, height:200,colors: ['#DF0101','#FE9A2E','#088A08','#045FB4' ],
                      			 chartArea:{left:50,top:20,width:"80%",height:"75%"}
                       });
				</c:forEach>
		</c:forEach>     
                 
		<c:forEach var="LocationDashboardDto1"
			items="${locationDashboardDtoList1}">              
		<c:forEach var="shiftDashboardDto1"
				items="${LocationDashboardDto1.shiftDashboardList}">
			var pieChart1 = google.visualization.arrayToDataTable([
           	                	['Employee In Status', 'No of Employee'],
           	            		['Early In', 	${f:h(shiftDashboardDto1.employeeEarlyIN)}	], //${f:h(shiftDashboardDto1.employeeEarlyIN)}
                               	['Right In',	${f:h(shiftDashboardDto1.employeeRightIN)}	], //${f:h(shiftDashboardDto1.employeeRightIN)} 
                               	['Late In',		${f:h(shiftDashboardDto1.employeeLateIN)}	]	//${f:h(shiftDashboardDto1.employeeLateIN)}
                          ]);
			new google.visualization.PieChart(document.getElementById("${f:h(shiftDashboardDto1.shift.shiftName)}${f:h(LocationDashboardDto1.location.locationName )}3")).
	        draw(pieChart1, {title:"Time IN :: ${f:h(shiftDashboardDto1.shift.shiftName)} :: Punctuality",
				        	 width:300, height:200,
				        	 colors: ['#088A08','#FE9A2E', '#DF0101'],
	                      	 chartArea:{left:50,top:20,width:"80%",height:"75%"}
	                       });
		
			var pieChart1 = google.visualization.arrayToDataTable([
      	               		['In Status', 'No of Employee'],
      	            		['Early OUT', 	${f:h(shiftDashboardDto1.employeeEarlyOUT)}	], //${f:h(shiftDashboardDto1.employeeEarlyOUT)}
                          	['Right OUT',	${f:h(shiftDashboardDto1.employeeRightOUT)}	], //${f:h(shiftDashboardDto1.employeeRightOUT)} 
                          	['Late OUT',	${f:h(shiftDashboardDto1.employeeLateOUT)}	],	//${f:h(shiftDashboardDto1.employeeLateOUT)}
                          	['No OUT Time',	${f:h(shiftDashboardDto1.noOutTime)}		]  //${f:h(shiftDashboardDto1.noOutTime)}
                          	]);
			new google.visualization.PieChart(document.getElementById("${f:h(shiftDashboardDto1.shift.shiftName)}${f:h(LocationDashboardDto1.location.locationName )}4")).
       		draw(pieChart1, {title:"Time OUT :: ${f:h(shiftDashboardDto1.shift.shiftName)} :: Punctuality",
							  colors: ['#DF0101','#FE9A2E','#088A08','#045FB4' ],
             	 			  width:300, height:200,
             				  chartArea:{left:40,top:20,width:"80%",height:"75%"}
            });
			</c:forEach>
	</c:forEach>     
}
</script>
<div
	style="  margin-bottom: 1em; padding: 10px;">
	<div style="float: left; width: 100%; height: 100%;margin: 0px;padding: 0px; border: 0px solid #6699CC;">
		<div id="pieChart1"
			style="float: left; height: 200px; width: 25%; clear: left;border-left: 0px dotted #6699CC;"></div>
		<div id="pieChart2"
			style="float: left; height: 200px; width: 25%; border-left: 1px dotted #6699CC;"></div>
		
		<c:forEach var="LocationDashboardDto"
			items="${locationDashboardDtoList}">
			<div id="${f:h(LocationDashboardDto.location.locationName)}2"
			style="float: left; height: 200px; width: 25%; float: left;display: none;border-left: 0px dotted #6699CC;"></div>
			<div id="${f:h(LocationDashboardDto.location.locationName)}3"
			style="float: left; height: 200px; width: 24%; float: left;display: none;border-left: 1px dotted #6699CC;"></div>
			<c:forEach var="shiftDashboardDto"
				items="${LocationDashboardDto.shiftDashboardList}">
				
				<div
					id='${f:h(shiftDashboardDto.shift.shiftName)}${f:h(LocationDashboardDto.location.locationName)}1'
					style="float: left; height: 200px; width: 24%; display: none;border-left: 0px dotted #6699CC;"></div>
					<div
					id='${f:h(shiftDashboardDto.shift.shiftName)}${f:h(LocationDashboardDto.location.locationName)}2'
					style="float: left; height: 200px; width: 25%; display: none;border-left: 1px dotted #6699CC;"></div>
			
			</c:forEach>
		</c:forEach>
	
		<div id="pieChart3"
			style="float: left; height: 200px; width: 24%; border-left: 1px dotted #6699CC;"></div>
		<div id="pieChart4"
			style="float: left; height: 200px; width: 25%; border-left: 1px dotted #6699CC;"></div>
		
		<c:forEach var="LocationDashboardDto1"
			items="${locationDashboardDtoList1}">
			<div id="${f:h(LocationDashboardDto1.location.locationName)}4"
			style="float: left; height: 200px; width: 24%; float: left;display: none;border-left: 1px dotted #6699CC;"></div>
			<div id="${f:h(LocationDashboardDto1.location.locationName)}5"
			style="float: left; height: 200px; width: 25%; float: left;display: none;border-left: 1px dotted #6699CC;"></div>
			<c:forEach var="shiftDashboardDto1"
				items="${LocationDashboardDto1.shiftDashboardList}">
			
				<div
					id='${f:h(shiftDashboardDto1.shift.shiftName)}${f:h(LocationDashboardDto1.location.locationName)}3'
					style="float: left; height: 200px; width: 24%; display: none;border-left: 1px dotted #6699CC;"></div>
				<div
					id='${f:h(shiftDashboardDto1.shift.shiftName)}${f:h(LocationDashboardDto1.location.locationName)}4'
					style="float: left; height: 200px; width: 25%; display: none;border-left: 1px dotted #6699CC;"></div>
		
			</c:forEach>
		</c:forEach>
	
	</div>
	<div style="clear: left; width: 100%; float: left; margin: 0px;padding: 0px;">
	<table  style="width: 100%;">
	<tr>
				<td style="font: 16px bold; text-align: center;font: bold 13px Helvetica, sans-serif;width: 49%">Today (${today})</td>
				<td style="font: 16px bold; text-align: center;font: bold 13px Helvetica, sans-serif;width: 49%">Yesterday (${yesterday})</td>
			</tr>
	</table>
	</div>
	<div  style="height: 225px;overflow: auto;clear: left;">
	<div style="clear: left; width: 49%; float: left; margin: 0px;padding: 0px;">
		<table style="width: 100%;">
			
			<tr>
				<td><div class="aout">
						<table >
							<tr>
								<th style="width: 10%">location</th>
								<th style="width: 10%">Early In</th>
								<th style="width: 10%">Right In</th>
								<th style="width: 10%">Late In</th>
								<th style="width: 10%">Total In</th>
								<th style="width: 10%">Early Out</th>
								<th style="width: 10%">Right Out</th>
								<th style="width: 10%">Late Out</th>
								<th style="width: 10%">Total Out</th>
								<th style="width: 10%">No Out Time</th>
							</tr>
							<% int i=1; %>
							<c:forEach var="LocationDashboardDto"
								items="${locationDashboardDtoList}">
								
								<tr <%if(i%2!=0){ %> class='altrow' <%} %>style="border-bottom: 1px solid #CDCECE">
									<td><a href="javascript:shiftDashboard('${f:h(LocationDashboardDto.location.locationName)}');">${f:h(LocationDashboardDto.location.locationName)}</a></td>
									<td>${f:h(LocationDashboardDto.employeeEarlyIN)}</td>
									<td>${f:h(LocationDashboardDto.employeeRightIN)}</td>
									<td>${f:h(LocationDashboardDto.employeeLateIN)}</td>
									<td>${f:h(LocationDashboardDto.totalNumOfEmployeesIN)}</td>
									<td>${f:h(LocationDashboardDto.employeeEarlyOUT)}</td>
									<td>${f:h(LocationDashboardDto.employeeRightOUT)}</td>
									<td>${f:h(LocationDashboardDto.employeeLateOUT)}</td>
									<td>${f:h(LocationDashboardDto.totalNumOfEmployeesOUT)}</td>
									<td>${f:h(LocationDashboardDto.noOutTime)}</td>
								</tr>
								<% i++;%>
							</c:forEach>
						</table>
					</div></td>
			</tr>
		</table>
	</div>
	<div>
	<div style="float: right; width: 49%">
		<table style="width: 100%;">
			
			<tr>
				<td><div class="aout">
						<table>
							<tr style="width: 100%">
								<th style="width: 10%">location</th>
								<th style="width: 10%">Early In</th>
								<th style="width: 10%">Right In</th>
								<th style="width: 10%">Late In</th>
								<th style="width: 10%">Total In</th>
								<th style="width: 10%">Early Out</th>
								<th style="width: 10%">Right Out</th>
								<th style="width: 10%">Late Out</th>
								<th style="width: 10%">Total Out</th>
								<th style="width: 10%">No Out Time</th>
							</tr>
							<% int i1=1; %>
							<c:forEach var="LocationDashboardDto1"
								items="${locationDashboardDtoList1}">
								
								<tr <%if(i1%2!=0){ %> class='altrow' <%} %> style="border-bottom: 1px solid #CDCECE">
									<td><a
										href="javascript:shiftDashboard('${f:h(LocationDashboardDto1.location.locationName)}');">${f:h(LocationDashboardDto1.location.locationName)}</a></td>
									<td>${f:h(LocationDashboardDto1.employeeEarlyIN)}</td>
									<td>${f:h(LocationDashboardDto1.employeeRightIN)}</td>
									<td>${f:h(LocationDashboardDto1.employeeLateIN)}</td>
									<td>${f:h(LocationDashboardDto1.totalNumOfEmployeesIN)}</td>
									<td>${f:h(LocationDashboardDto1.employeeEarlyOUT)}</td>
									<td>${f:h(LocationDashboardDto1.employeeRightOUT)}</td>
									<td>${f:h(LocationDashboardDto1.employeeLateOUT)}</td>
									<td>${f:h(LocationDashboardDto1.totalNumOfEmployeesOUT)}</td>
									<td>${f:h(LocationDashboardDto1.noOutTime)}</td>
								</tr>
							<% i1++;%>
							</c:forEach>
						</table>
					</div></td>
			</tr>
		</table>
	</div>
	<c:forEach var="LocationDashboardDto"
		items="${locationDashboardDtoList}">
		<div id="${f:h(LocationDashboardDto.location.locationName)}"
			style="display: none; float: left; width: 49%; height: 100%;clear: left;">
			<table style="width: 100%">
				<tr>

					<td><div id="shift" class="aout">
							<table>
							<tr>
								<th colspan="10" style="border-bottom: 1px solid #CDCECE;">Location Name :${f:h(LocationDashboardDto.location.locationName)}
								</th>
							<tr>
								<tr>
									<th style="width: 10%">Shift</th>
									<th style="width: 10%">Early In</th>
									<th style="width: 10%">Right In</th>
									<th style="width: 10%">Late In</th>
									<th style="width: 10%">Total In</th>
									<th style="width: 10%">Early Out</th>
									<th style="width: 10%">Right Out</th>
									<th style="width: 10%">Late Out</th>
									<th style="width: 10%">Total Out</th>
									<th style="width: 10%">No Out Time</th>
								</tr>
								<% int i2=1; %>
									<c:forEach var="shiftDashboardDto"
										items="${LocationDashboardDto.shiftDashboardList}">
										
										<tr <%if(i2%2!=0){ %>class='altrow' <%} %> style="border-bottom: 1px solid #CDCECE">
											<td><a
												href="javascript:shiftPie('${f:h(shiftDashboardDto.shift.shiftName)}','${f:h(LocationDashboardDto.location.locationName)}');">${f:h(shiftDashboardDto.shift.shiftName)}</a></td>
											<td>${f:h(shiftDashboardDto.employeeEarlyIN)}</td>
											<td>${f:h(shiftDashboardDto.employeeRightIN)}</td>
											<td>${f:h(shiftDashboardDto.employeeLateIN)}</td>
											<td>${f:h(shiftDashboardDto.totalNumOfEmployeesIN)}</td>
											<td>${f:h(shiftDashboardDto.employeeEarlyOUT)}</td>
											<td>${f:h(shiftDashboardDto.employeeRightOUT)}</td>
											<td>${f:h(shiftDashboardDto.employeeLateOUT)}</td>
											<td>${f:h(shiftDashboardDto.totalNumOfEmployeesOUT)}</td>
											<td>${f:h(shiftDashboardDto.noOutTime)}</td>
										</tr>
										<% i2++;%>
									</c:forEach>
							</table>
						</div></td>
				</tr>
			</table>
		</div>
	</c:forEach>


	<c:forEach var="LocationDashboardDto1"
		items="${locationDashboardDtoList1}">

		<div id="${f:h(LocationDashboardDto1.location.locationName)}1"
			style="display: none; float: right; width: 49%">
			<table style="width: 100%">
				<tr>
					<td><div id="shift1" class="aout">
							<table>
							<tr>
								<th colspan="10" style="border-bottom: 1px solid #CDCECE">Location Name :${f:h(LocationDashboardDto1.location.locationName)}
								</th>
							<tr>
								<tr>
									<th style="width: 10%">Shift</th>
									<th style="width: 10%">Early In</th>
									<th style="width: 10%">Right In</th>
									<th style="width: 10%">Late In</th>
									<th style="width: 10%">Total In</th>
									<th style="width: 10%">Early Out</th>
									<th style="width: 10%">Right Out</th>
									<th style="width: 10%">Late Out</th>
									<th style="width: 10%">Total Out</th>
									<th style="width: 10%">No Out Time</th>
								</tr>
								<% int i3=1; %>
								<c:forEach var="shiftDashboardDto1"
									items="${LocationDashboardDto1.shiftDashboardList}">
									
									<tr <%if(i3%2!=0){ %>class='altrow' <%} %> style="border-bottom: 1px solid #CDCECE">
										<td><a
											href="javascript:shiftPie('${f:h(shiftDashboardDto1.shift.shiftName)}','${f:h(LocationDashboardDto1.location.locationName)}');">${f:h(shiftDashboardDto1.shift.shiftName)}</a></td>
										<td>${f:h(shiftDashboardDto1.employeeEarlyIN)}</td>
										<td>${f:h(shiftDashboardDto1.employeeRightIN)}</td>
										<td>${f:h(shiftDashboardDto1.employeeLateIN)}</td>
										<td>${f:h(shiftDashboardDto1.totalNumOfEmployeesIN)}</td>
										<td>${f:h(shiftDashboardDto1.employeeEarlyOUT)}</td>
										<td>${f:h(shiftDashboardDto1.employeeRightOUT)}</td>
										<td>${f:h(shiftDashboardDto1.employeeLateOUT)}</td>
										<td>${f:h(shiftDashboardDto1.totalNumOfEmployeesOUT)}</td>
										<td>${f:h(shiftDashboardDto1.noOutTime)}</td>
									</tr>
									<% i3++;%>
								</c:forEach>
							</table>
						</div></td>
				</tr>


			</table>
		</div>
	</c:forEach>
	</div>
	
</div>