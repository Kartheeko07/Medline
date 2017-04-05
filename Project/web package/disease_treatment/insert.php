<?php 
$a=$_POST["NewDis"];
mysql_connect("localhost","root","");
		mysql_select_db("treatment");
		$query="insert into kartheek (Disease) values ('$a')";
		$result=mysql_query($query);
		echo "Your Disease has been taken into account we will come back soon"
		?>