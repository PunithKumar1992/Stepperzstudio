<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<head>
<title>StepperzStudio::Admin</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Visitors Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- bootstrap-css -->
<link rel="stylesheet" href="admincss/bootstrap.min.css" >
<!-- //bootstrap-css -->
<!-- Custom CSS -->
<link href="admincss/style.css" rel='stylesheet' type='text/css' />
<link href="admincss/style-responsive.css" rel="stylesheet"/>
<!-- font CSS -->
<link href='//fonts.googleapis.com/css?family=Roboto:400,100,100italic,300,300italic,400italic,500,500italic,700,700italic,900,900italic' rel='stylesheet' type='text/css'>
<!-- font-awesome icons -->
<link rel="stylesheet" href="admincss/font.css" type="text/css"/>
<link href="admincss/font-awesome.css" rel="stylesheet"> 
<link rel="stylesheet" href="admincss/morris.css" type="text/css"/>
<!-- calendar -->
<link rel="stylesheet" href="admincss/monthly.css">
<!-- //calendar -->
<!-- //font-awesome icons -->
<script src="adminjs/jquery2.0.3.min.js"></script>
<script src="adminjs/raphael-min.js"></script>
<script src="adminjs/morris.js"></script>
<style type="text/css">
.error{
color:white;
size:2px;


}

</style>
</head>
<body>
<div class="reg-w3">
<div class="w3layouts-main">
	<h2>Register Now</h2>
		<form:form action="adminregistration.html" method="post" modelAttribute="adminreg">
		
		<form:input path="admin_name" class="ggg" placeholder="NAME" />
		<form:errors path="admin_name" cssClass="error"></form:errors>
		
		<form:input path="admin_email" class="ggg" placeholder="E-MAIL" />
		<form:errors path="admin_email" cssClass="error"></form:errors>
	
		<form:input path="admin_phone" class="ggg" placeholder="PHONE" />
		<form:errors path="admin_phone" cssClass="error"></form:errors>
		
		<form:password path="admin_password"  class="ggg" placeholder="PASSWORD" />
		<form:errors path="admin_password" cssClass="error"></form:errors>
		
		<input type="submit" value="Register">
		
		</form:form>
	
		<p>Already Registered.<a href="admin.html">Login</a></p>
</div>
</div>

<script src="adminjs/bootstrap.js"></script>
<script src="adminjs/jquery.dcjqaccordion.2.7.js"></script>
<script src="adminjs/scripts.js"></script>
<script src="adminjs/jquery.slimscroll.js"></script>
<script src="adminjs/jquery.nicescroll.js"></script>
<!--[if lte IE 8]><script language="javascript" type="text/javascript" src="js/flot-chart/excanvas.min.js"></script><![endif]-->
<script src="adminjs/jquery.scrollTo.js"></script>
<!-- morris JavaScript -->	
</body>
</html>
