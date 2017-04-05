<!--A Design by W3layouts
Author: W3layout
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<!DOCTYPE HTML>
<html>
<head>
<title></title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Uibrush Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="js/jquery.min.js"></script>
<!-- Custom Theme files -->
<link href="css/style.css" rel='stylesheet' type='text/css' />
<link href='http://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700,800' rel='stylesheet' type='text/css'>
</head>
<body>
<div class="header">
  <div class="container">
	<div class="logo">
	</div>
    <div class="menu">
	   <a class="toggleMenu" href="#"><img src="images/menu.png" alt="" /> </a>
	   <ul class="nav" id="nav">
		 <li><a href="index.php"><h3><b>Home</b></h3></a></li>
		 <li class="current"><a href="about.php"><h3><b>Treatment</b></h3></a></li>
		 <li><a href="services.php"><h3><b>Services</b></h3></a></li>
		</ul>
	  <script type="text/javascript" src="js/responsive-nav.js"></script>
	</div>							
    <div class="clearfix"> </div>
	<!----//End-top-nav---->
  </div>
</div>
<div align="center"">
	<form method="post" action="<?php echo $_SERVER['PHP_SELF'];?>">
<select name="disease">
	<?php
		mysql_connect("localhost","root","");
		mysql_select_db("treatment");
		$query="select distinct(Disease) from treat order by Disease";
		$result=mysql_query($query);
		while($row=mysql_fetch_array($result))
		{
			$disease=$row["Disease"];
			echo "<option value=\"$disease\">$disease</option>";
		}
	?>
  </select>
		<br/><br/>
		<input type="submit" value="Get Treatment"><br/><br/>
	</form>
	<?php
		if(isset($_POST["disease"]))
		{
			$disease=$_POST["disease"];
			$query="select Treatment from treat where Disease='$disease'";
			$result=mysql_query($query);
			echo "<div style='border: 25px solid #E49002;'>";
			while($row=mysql_fetch_array($result))
			{
				$a=$row["Treatment"];
				echo "<b>".$row["Treatment"]."</b>"."<a href='services.php?info=$a'>?</a>"."<br/>";
			}
			echo "</div>";
		}
		echo "<br><br>";
		echo "If your Disease is not present in the above list then please enter the disease in the box below";
		?>
	    <form method="post" action="insert.php">
		<br/>
		<input type="text" name="NewDis" value=""/>
		<input type="submit" name="Dis" value="Submit"/>
		</form>
	
</div>
<br/><br/><br/><br/>
<br/><br/>
<div class="footer">
	<div class="container">
		<div class="col-md-3 box_3">
			<h3>About Us</h3>
			<p>This is an interface that is developed by a student of VIT with the help of extraction of data from the MEDLINE abstracts</p>
		</div>
		<div class="col-md-3 box_5">
			<h3>Why trust Us ?</h3>
			<div class="footer-list">
			    <ul>
				    <li class="list_top"><i class="arrow"> </i>
					<p>We have obtained the data from the abstracts of Medline<br></p></li>
					<li class="list_top"><i class="arrow"> </i>
					<p>MedLine is an database that consists of every medical data upto date which is maintained by the US National Library of Medicine<br></p></li>
		       </ul>
			</div>
		</div>
		<div class="col-md-3 box_5">
			<h3>Website Map</h3>
			<div class="footer-list1">
			    <ul>
				    <li><a href="#">Home</a></li>
					<li><a href="#">Treatments</a></li>
					<li><a href="#">Services</a></li>
				</ul>
			</div>
		</div>
		<div class="col-md-3 box_5">
			<h3>Contact Us</h3>
			<div class="footer-list">
			    <ul>
				    <li class="list_top"><i class="email"> </i>
					<p>Email id: kartheek.anumolu2010@vit.ac.in</p></li>
					<li class="list_top"><i class="phone"> </i>
					<p>9003053323</p></li>
		       </ul>
		    </div>
		    <p>This an interface that was developed a beta version.</p>
		</div>
	</div>
</div>
</body>
</html>		