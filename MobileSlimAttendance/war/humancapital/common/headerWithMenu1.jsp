<%@page import="org.apache.jasper.tagplugins.jstl.core.Import"%>
<%@page pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>
<%@ page import="java.util.Date"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<meta name="Keywords" content="">
		<meta name="Description" content="">
			<title><fmt:message key="${requestScope.pageTitle}"/></title>
			<link href="styles/main.css?updated=<%=new Date()%>" rel="stylesheet"
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
	<div id="wrapper">
		<div id="header">
			<span> User </span> <span> Account </span> <a href="#">Logout</a>
		</div>
		<div id="Nav">

			<a href="${f:url('home')}">Home</a> <a href="${f:url('addLocation')}">Add
				Location</a> <a href="${f:url('addShift')}">Add Shift</a> <a
				href="${f:url('configureTimeSheetRule')}">Configure Rules</a> <a
				href="${f:url('addEmployee')}">Add Employee</a> <a
				href="${f:url('assignment')}">Assignment</a> <a
				href="${f:url('rechargeIndex')}">Charge your account</a>
				 <a
				href="${f:url('consolidatedTimesheetReport?actionParam=search')}">Time
				Report</a> <a href="${f:url('periodicTimesheetReport')}">Timecard</a> <a
				href="${f:url('logout')}">Logout</a>

		</div>