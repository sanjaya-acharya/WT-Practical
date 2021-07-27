<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8"/>
	<meta http-equiv='cache-control' content='no-cache'>
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
	<meta name='viewport' content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0'/>
	<title>Register</title>
    <link rel="icon" type="image/gif" href="../favicon.ico" />
	<link rel="stylesheet" type="text/css" href="register-style.css">
</head>
<body>
	<form method="post" onsubmit="return validateForm();">
		<div class="form-container">
			<div class="heading">Register</div>

			<div class="form-field">
				<input type="text" name ="email" class="text-input email" placeholder="Email" autocomplete="off">
				<label class="label-email input-label">Email</label>
				<div class="errors error-email"></div>
			</div>

			<div class="form-field">
				<input type="text" name ="username" class="text-input username" placeholder="Username" autocomplete="off">
				<label class="label-username input-label">Username</label>
				<div class="errors error-username"></div>
			</div>

			<div class="form-field">
				<input type="text" name ="password" class="text-input password" placeholder="Password" autocomplete="off">
				<label class="label-password input-label">Password</label>

				<div class="eye hide-show">
					<div class="eye-border" onclick="hide_show('')">
						<div class="eye-ball"></div>
						<div class="eye-line"></div>
					</div>
				</div>

				<div class="errors error-password"></div>
			</div>

			<div class="form-field">
				<input type="text" name ="confirm-password" class="text-input confirm-password" placeholder="Confirm Password" autocomplete="off">
				<label class="label-confirm-password input-label">Confirm Password</label>

				<div class="eye hide-show">
					<div class="eye-border" onclick="hide_show('confirm-')">
						<div class="eye-ball"></div>
						<div class="confirm-eye-line"></div>
					</div>
				</div>
				<!-- <img src="toggle-password/hide.jpg" class="hide-show confirm-hide" onclick="hide_show('hide', 'confirm-')" />
				<img src="toggle-password/show.jpg" class="hide-show confirm-show" onclick="hide_show('show', 'confirm-')" /> -->

				<div class="errors error-confirm-password"></div>
			</div>

			<div class="wrapper-links">
				<div class="btn">
					<button type="submit" name="register">Register</button>
				</div>

				<div class="errors response"></div>
				<div class="login-here">Already have an account?<br><a href="../login">Login here</a></div>
			</div>

		</div>
	</form>
	
	<script type="text/javascript" src="register-script.js"></script>
	<script type="text/javascript">
		let width = window.innerWidth;

		if (width > 0 && width <= 600) {
			document.querySelector('body').style.transform = "scale("+ (width/600) +")";
		}
	</script>
</body>

</html>

<?php
	require_once "register-validate.php";
?>