<%@page import="org.apache.jasper.tagplugins.jstl.core.Import"%>
<%@page pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>
<%@ page import="java.util.Date"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="Keywords" content="">
<meta name="Description" content="">
<title>Test Application</title>
<link href="styles/style.css?updated=<%=new Date()%>" rel="stylesheet"
	type="text/css">
<link href="styles/demo_table.css" rel="stylesheet" type="text/css">
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
</head>
<body>
	<!-- start header -->
	<div style="width: 100%">

		<div id="header">
			<div id="logo">
				<h1></h1>
			</div>
			<%--@include file="menu.jsp" --%>
			<div id="menu">
				<ul>
					<li><a href="${f:url('home')}">Home</a></li>
					<li><a href="${f:url('addLocation')}">Add Location</a></li>
					<li><a href="${f:url('addShift')}">Add Shift</a></li>
					<li><a href="${f:url('createContractorCompany')}">Add
							Contractor</a></li>
                    <li><a href="${f:url('configureTimeSheetRule')}">Configure Rules</a></li>							
					<li><a href="${f:url('addEmployee')}">Add Employee</a></li>
					<li><a href="${f:url('assignment')}">Assignment</a></li>
					<li><a href="${f:url('rechargeIndex')}">Charge your
							account</a></li>
					<li><a href="${f:url('consolidatedTimeSheet')}">Generate
							Consolidated Timesheet</a></li>
					<li><a href="${f:url('consolidatedTimesheetReport?actionParam=search')}">Time
							Report</a></li>
					<li><a href="${f:url('periodicTimesheetReport')}">Timecard</a></li>
					<li><a href="${f:url('logout')}">Logout</a></li>
				</ul>
			</div>
		</div>
	</div>