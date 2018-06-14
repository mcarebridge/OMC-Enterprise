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
<!-- ****************************************************************  -->
<!--Load the AJAX API-->
<script type="text/javascript" src="https://www.google.com/jsapi"></script>
<script type="text/javascript">

	//google.load('visualization', '1', {packages:['table, charteditor,corechart']});
  	//google.setOnLoadCallback(drawVisualization);

<!-- Load Tables -->
		/**
		function drawVisualization() {
		  // Create and populate the data table.		 
		  var data = new google.visualization.DataTable();
		  data.addColumn('string', 'Scan the Bar TODOwnload Android client');		
		  data.addRows(1);
		  data.setCell(0,0,"<table width='200px'><tr><td colspan='2'><img src='https://chart.googleapis.com/chart?chs=200x200&amp;chld=L|2&amp;cht=qr&amp;chl=http%3A%2F%2Fadviteya.com.com%2Fandroid%2Fomc.apk&amp;choe=UTF-8' alt='QR code' /></td></tr></table>");					
		  // Create and draw the visualization.
		  var table = new google.visualization.Table(document.getElementById('androidclient1'));
		  table.draw(data, {allowHtml: true, showRowNumber: false,page:'enable', pageSize : 15, sortAscending:false});
		  }
		**/
</script>
</head>
<body>
		<c:if test="${currentUser!= null}">
			<jsp:forward page="home"></jsp:forward>
		</c:if>
	<div id="wrapper">
		<div id="contentWrapperIndex">
			<div>
				<h2
					style="float: right; color: #6699CC; font-size: 8px; right; padding: 10px 10px 0px 0px">TM</h2>
				<a href='/' class='logo'>OneMasterControl</a>
			</div>
			<div class="left" style="width: 68%;">
				<div class="content">
					<table>
						<tr>
							<td ><img src="images/OMC_CollageNew.jpg" height="525px" width='550px' /></td>
							<td ><img src="images/OMC-Promotion.jpg" height="525px" /></td>
						</tr>
					</table>
					<!--  about -->
				</div>
				<!-- content -->
			</div>
			<!-- left -->
			<div class="right slide" id="slidemarginleft" style="width: 28%;">
				<div class="inner">
					<div class="content" style="height: 200px;">
						<h1>Controls</h1>
						<form method="post" action="login">
						
							<div>
								<span>
									<ul>
										<c:forEach var="e" items="${f:errors()}">
											<li style="font: normal 11px Verdana; color: red; text-align: left;">${f:h(e)}</li>
										</c:forEach>
									</ul>
								</span>
							</div>
							<div class='about'>
								<table height="90%" align="center" valign="center">
									<tr height="25px">
										<td>User Name</td>
										<td><input type="text" name="userName" class="username">
										</td>
									</tr>
									<tr height="25px">
										<td>Password</td>
										<td><input type="password" name="password"
											class="password"></td>
									</tr>

									<tr height="25px">
										<td colspan="2" align="center"><input type="submit"
											value="Login" class="select1"> <input type="reset"
											value="Reset" class="select1"></td>
									</tr>
									<tr height="25px">

										<td colspan="2" align="center"><a
											href="${f:url('createAdminUser')}">Sign Up Now</a>
										&nbsp;&nbsp;&nbsp;
										
										<a href="${f:url('forgotPassword?actionParam=forgotPassword')}">Forgot Password?</a>
										</td>
									</tr>
									<tr>
										<td colspan='2'><div id="androidclient"
												style='width: 250px; horizontal-align: center; overflow-x: false;'></div></td>
									</tr>
								</table>
								<input type="hidden" name="client" value="browser">
							</div>
							</form>
					</div>
					<div class="content" style="height: 100px; margin: 10px 0;">
						<h1>Quick Guide</h1>
					</div>
					<div class="content" style="height: 100px;">
						<h1>Support</h1>
					</div>
				</div>
			</div>
		 
			
		</div>
		<!-- content wrapper -->
	</div>
	<!-- wrapper -->
</body>
</html>