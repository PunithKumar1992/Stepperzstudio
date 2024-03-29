<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
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
</head>
<body>
<section id="container">
<!--header start-->
<header class="header fixed-top clearfix">
<!--logo start-->
<div class="brand">
    <a href="index.html" class="logo">
        <img src="adminimages/logo.png" alt="stepper" style="width:90%;margin-top:-9%;">
    </a>
    <div class="sidebar-toggle-box">
        <div class="fa fa-bars"></div>
    </div>
</div>
<!--logo end-->

<div class="top-nav clearfix">
    <!--search & user info start-->
    <ul class="nav pull-right top-menu">
        <li>
            <input type="text" class="form-control search" placeholder=" Search">
        </li>
        <!-- user login dropdown start-->
        <li class="dropdown">
            <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                <img alt="" src="adminimages/2.png">
                <span class="username">John Doe</span>
                <b class="caret"></b>
            </a>
            <ul class="dropdown-menu extended logout">
                <li><a href="#"><i class=" fa fa-suitcase"></i>Profile</a></li>
                <li><a href="#"><i class="fa fa-cog"></i> Settings</a></li>
                <li><a href="login.html"><i class="fa fa-key"></i> Log Out</a></li>
            </ul>
        </li>
        <!-- user login dropdown end -->
       
    </ul>
    <!--search & user info end-->
</div>
</header>
<!--header end-->
<!--sidebar start-->
<aside style="overflow:hidden;">
			<div id="sidebar" class="nav-collapse" style="overflow-y: scroll;display: flex;">
				<!-- sidebar menu start-->
				<div class="leftside-navigation">
					<ul class="sidebar-menu" id="nav-accordion">
						<li><a class="active" href="bashboard.html"> <i
								class="fa fa-dashboard"></i> <span>Dashboard</span>
						</a></li>

						<li class="sub-menu"><a href="javascript:;"> <i
								class="fa fa-book"></i> <span>Time_Table</span>
						</a>
							<ul class="sub">
								<li class="sub-menu"><a href="sadashivtimetable.html">
										<i class="fa fa-bullhorn" aria-hidden="true"></i> <span>sadashiva
											Nagar</span>
								</a></li>
						<li class="sub-menu"><a href="kalyantimetable.html"> <i
								class="fa fa-bullhorn" aria-hidden="true"></i> <span>Kalyan
									Nagar</span>
						</a></li>
						<li class="sub-menu"><a href="mallesharamtimetable.html">
								<i class="fa fa-bullhorn" aria-hidden="true"></i> <span>Malleshwaram</span>
						</a></li>
						</ul>
						</li>
					<li><a href="adminbanner.html"> <i class="fa fa-glass"></i>
							<span>Banner</span>
					</a></li>
					<li><a href="adminads.html"> <i class="fa fa-adn"
							aria-hidden="true"></i> <span>Adds</span>
					</a></li>


					<li class="sub-menu"><a href="javascript:;"> <i
							class="fa fa-book"></i> <span>Gallery</span>
					</a>
						<ul class="sub">
							<li class="sub-menu"><a href="javascript:;"> <i
									class="fa fa-book"></i> <span>Images</span>
							</a>
								<ul class="sub">
									<li class="sub-menu"><a href="adminsadagallery.html">
											<i class="fa fa-bullhorn" aria-hidden="true"></i> <span>sadashiva
												Nagar</span>
									</a></li>
							<li class="sub-menu"><a href="adminkalagallery.html"> <i
									class="fa fa-bullhorn" aria-hidden="true"></i> <span>Kalyan
										Nagar</span>
							</a></li>
					<li class="sub-menu"><a href="adminmalleshgallery.html"> <i
							class="fa fa-bullhorn" aria-hidden="true"></i> <span>Malleshwaram</span>
					</a></li>
					</ul>
					</li>
					<li class="sub-menu"><a href="javascript:;"> <i
							class="fa fa-book"></i> <span>Videos</span>
					</a>
						<ul class="sub">
							<li class="sub-menu"><a href="adminsadavideo.html"> <i
									class="fa fa-bullhorn" aria-hidden="true"></i> <span>sadashiva
										Nagar</span>
							</a></li>
					<li class="sub-menu"><a href="adminkalavideo.html"> <i
							class="fa fa-bullhorn" aria-hidden="true"></i> <span>Kalyan
								Nagar</span>
					</a></li>
					<li class="sub-menu"><a href="adminmalleshvideo.html"> <i
							class="fa fa-bullhorn" aria-hidden="true"></i> <span>Malleshwaram</span>
					</a></li>
					</ul>
					</li>
					</ul>
					
					
					<li><a href="admintestimonials.html"> <i
							class="fa fa-comments-o" aria-hidden="true"></i> <span>testimonials</span>
					</a></li>
					<li><a href="admincareer.html"> <i
							class="fa fa-caret-square-o-right" aria-hidden="true"></i> <span>Career</span>
					</a></li>
					<li><a href="adminfeedback.html"> <i
							class="fa fa-commenting-o" aria-hidden="true"></i> <span>Feedback</span>
					</a></li>
					<li><a href="studentregbyadmin.html"> <i
							class="fa fa-registered" aria-hidden="true"></i> <span>Registration</span>
					</a></li>

					<!-- <li class="sub-menu">
                    <a href="javascript:;">
                        <i class="fa fa-envelope"></i>
                        <span>Mail </span>
                    </a>
                    <ul class="sub">
                        <li><a href="mail.html">Inbox</a></li>
                        <li><a href="mail_compose.html">Compose Mail</a></li>
                    </ul>
                </li> -->

					</ul>
				</div>
				<!-- sidebar menu end-->
			</div>
		</aside>
<!--sidebar end-->
<!--main content start-->
<section id="main-content">
	<section class="wrapper">
            <div class="row">
            <div class="col-md-12">
                    <section class="panel">
                        <header class="panel-heading">
                           Registration
                        </header>
                        <div class="panel-body">
                            <div >
                                <form>
								<div class="col-md-3">
                                  
                                    <input type="text" class="form-control" id="First-name" placeholder="First-name">
                                </div>
								 <div class="col-md-3">
                                  
                                    <input type="text" class="form-control" id="Last-name" placeholder="Last-name">
                                </div>
								 <div class="col-md-3">
                                  
                                    <input type="text" class="form-control" id="Course" placeholder="Course">
                                </div>
                                <div class="col-md-3">
                                  
                                    <input type="email" class="form-control" id="Email1" placeholder="Email">
                                </div>
                                <div class="col-md-3">
                                   
                                    <input type="text" class="form-control" id="address" placeholder="address ">
                                </div>
								<div class="col-md-3">
                                  
                                    <input type="text" class="form-control" id="Contact_no" placeholder="Contact_no">
                                </div>
								<div class="col-md-3">
                                    <button type="submit" class="btn btn-info" style="margin-top:-2%">Add</button>
                                </div>
                                </form>
                            </div>
                        </div>
                    </section>
            </div>
</section>
<div class="table-agile-info">
  <div class="panel panel-default">
    <div class="panel-heading">
     Registration Information
    </div>
     <div class="table-responsive">
      <table class="table table-striped b-t b-light">
        <thead>
          <tr>
            
            <th>First_name</th>
            <th>Last_name</th>
            <th>Course</th>
			<th>Email</th>
            <th> Address</th>
			  <th>Contact_no</th>
			  <th> Action</th>
          </tr>
        </thead>
        <tbody>
    
	 <tr>
           
           
            <td><span class="text-ellipsis">{item.PrHelpText1}</span></td>
			 <td><span class="text-ellipsis">{item.PrHelpText1}</span></td>
			  <td><span class="text-ellipsis">{item.PrHelpText1}</span></td>
			   <td><span class="text-ellipsis">{item.PrHelpText1}</span></td>
               <td><span class="text-ellipsis">{item.PrHelpText1}</span></td>
			 <td><span class="text-ellipsis">{item.PrHelpText1}</span></td>
			
			<td>
		  <input type="button" value="delete">
		  
		  </td>
           </tr>
		    <tr>
           
           
            <td><span class="text-ellipsis">{item.PrHelpText1}</span></td>
			 <td><span class="text-ellipsis">{item.PrHelpText1}</span></td>
			  <td><span class="text-ellipsis">{item.PrHelpText1}</span></td>
			   <td><span class="text-ellipsis">{item.PrHelpText1}</span></td>
               <td><span class="text-ellipsis">{item.PrHelpText1}</span></td>
			 <td><span class="text-ellipsis">{item.PrHelpText1}</span></td>
			
			<td>
		  <input type="button" value="delete">
		  
		  </td>
           </tr>
		    <tr>
           
           
            <td><span class="text-ellipsis">{item.PrHelpText1}</span></td>
			 <td><span class="text-ellipsis">{item.PrHelpText1}</span></td>
			  <td><span class="text-ellipsis">{item.PrHelpText1}</span></td>
			   <td><span class="text-ellipsis">{item.PrHelpText1}</span></td>
               <td><span class="text-ellipsis">{item.PrHelpText1}</span></td>
			 <td><span class="text-ellipsis">{item.PrHelpText1}</span></td>
			
			<td>
		  <input type="button" value="delete">
		  
		  </td>
           </tr>
		
		  
		
		 
        </tbody>
      </table>
    </div>
    
  </div>
</div>
 <!-- footer -->
		  <div class="footer">
			<div class="wthree-copyright">
			  <p>© 2017 Visitors. All rights reserved | Design by <a href="http://w3layouts.com">W3layouts</a></p>
			</div>
		  </div>
  <!-- / footer -->
</section>
<!--main content end-->
</section>
<script src="adminjs/bootstrap.js"></script>
<script src="adminjs/jquery.dcjqaccordion.2.7.js"></script>
<script src="adminjs/scripts.js"></script>
<script src="adminjs/jquery.slimscroll.js"></script>
<script src="adminjs/jquery.nicescroll.js"></script>
<!--[if lte IE 8]><script language="javascript" type="text/javascript" src="js/flot-chart/excanvas.min.js"></script><![endif]-->
<script src="adminjs/jquery.scrollTo.js"></script>
<!-- morris JavaScript -->	
<script>
	$(document).ready(function() {
		//BOX BUTTON SHOW AND CLOSE
	   jQuery('.small-graph-box').hover(function() {
		  jQuery(this).find('.box-button').fadeIn('fast');
	   }, function() {
		  jQuery(this).find('.box-button').fadeOut('fast');
	   });
	   jQuery('.small-graph-box .box-close').click(function() {
		  jQuery(this).closest('.small-graph-box').fadeOut(200);
		  return false;
	   });

</body>
</html>
