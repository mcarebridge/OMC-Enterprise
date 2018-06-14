<%@page pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome to TimeSheet Test</title>
<script src="scripts/jquery.min.js"></script>


<script type="text/javascript" src="scripts/jquery.qrcode.js"></script>
<script type="text/javascript" src="scripts/qrcode.js"></script>
</head>
<body>
asasd
<div id="qrcode0" > </div>
<div id="qrcode1" > </div>
<div id="qrcode2" > </div>

<img src="http://qrfree.kaywa.com/?s=8&d=1212@12123132" alt="QRCode"/>

<script>

for(var i=0;i<3;i++)
	{
	//	jQuery('#qrcode'+i).qrcode("this plugin is great");
	
		jQuery('#qrcode'+i).qrcode({
		render	: "table",
		text	: "this plugin is great",
		height 	: 130,
		width	: 130
	});	
//	jQuery('#qrcodeCanvas').qrcode({
//		text	: "http://jetienne.com"
//	});	
	}
</script>
</body>
</html>