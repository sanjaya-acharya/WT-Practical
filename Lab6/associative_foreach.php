<html>
<body>

<?php
	$person = array("Name"=>"Sanjaya", "Address"=>"Lamachaur", "age"=>"21");

	echo "Person's Details<br>";
	foreach($person as $x => $value) {
		echo "Key = " . $x . ", Value = " . $value . "<br>";
	}
?>

</body>
</html>