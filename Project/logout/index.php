<<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>Logout</title>
</head>
<body>
<script type="text/javascript">
	let width = window.innerWidth;

	if (width > 0 && width <= 600) {
		document.querySelector('body').style.transform = "scale("+ (width/600) +")";
	}
</script>
</body>
</html>




<?php
	session_start();
	session_destroy();

	header("Location: ../login/");
?>