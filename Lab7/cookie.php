<?php
	$name = "Cookie_Name";
	$mail = "Abc@xyz.com";
	setcookie($name, $mail, time() + (86400 * 7)); # This makes cookie expire in 7 days...
?>

<!DOCTYPE html>
<html>

<head>
	<title>Cookie</title>
</head>

<body>

<?php
	if(isset($_COOKIE[$name])) {
		echo "Cookie name = " . $_COOKIE[$name];
	}
	else {
	  echo 'Cookie couldnot be created!';
	}
?>

</body>
</html>