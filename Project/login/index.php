<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8"/>
	<meta http-equiv='cache-control' content='no-cache'>
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
	<meta name='viewport' content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0'/>
	<title>Login</title>
    <link rel="icon" type="image/gif" href="../favicon.ico" />
	<link rel="stylesheet" type="text/css" href="login-style.css">
</head>
<body>
	<form method="post" onsubmit="return validateForm();">
		<div class="form-container">
			<div class="heading">Log In</div>

			<div class="form-field">
				<input type="text" name ="username" class="text-input username" placeholder="Username" autocomplete="off">
				<label class="label-username input-label">Username</label>
				<div class="errors error-username"></div>
			</div>

			<div class="form-field">
				<input type="text" name ="password" class="text-input password" placeholder="Password" autocomplete="off">
				<label class="label-password input-label">Password</label>
				<div class="errors error-password"></div>
			</div>

			<div class="wrapper-hide-show">
				<input type="checkbox" name="hide-show" class="hide-show">
				<span class="label-hide-show">Show Password</span>
			</div>

			<div class="wrapper-links">
				<div class="btn">
					<button type="submit" name="login">Log In</button>
				</div>

				<div class="errors response"></div>
				<div class="forget-password"><a href="../forget-password/">Forget Password</a></div>
				<div class="register-now">Don't have an account?<br><a href="../register/">Register now</a></div>
			</div>

		</div>
	</form>
	
	<script type="text/javascript" src="login-script.js"></script>
	<script type="text/javascript">
		let width = window.innerWidth;

		if (width > 0 && width <= 600) {
			document.querySelector('body').style.transform = "scale("+ (width/600) +")";
		}
	</script>
</body>

</html>

<?php
	require_once "login-validate.php";
?>
