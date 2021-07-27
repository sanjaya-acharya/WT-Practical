<?php
	session_start();
	if (!isset($_SESSION['loggedin']) || $_SESSION['loggedin'] == false) {
		header("location: ../login/");
		exit();
	 }
?>

<!DOCTYPE html>
<html lang="en">
<head>
	
	<title>Change Password</title>
</head>
<body>
	<style>
		body 
		{
			font-size:24px;
		}
		.errors
		{
			color:#ae2052;
			padding: 0px; 
			margin: 0px;
			padding-left:10px;
			height:24px;
			font-size:20px
		}
		.btn
		{
			margin-top:0px;
			padding: 5px;
		}
		th
		{
			padding: 0px;
		}
		label  
		{
			margin: 0px;
			padding: 0px;
		}
		input {
			width: 250px;
			height: 30px;
		}
	</style>
	<form method="post"  onsubmit="return validate();">
		<table class="Tpass">
			<tr>
			<td><p class="errors response"></p></td>
			</tr>
			<tr>
				<th><label>Change password</label></th>
			</tr>
			<tr>
			<td><input type="text" name="newpassword" class="edit_password" placeholder="Enter your new password"></td>
			<tr>
			<td><p class="errors password_err"></p></td>
			</tr>
			</tr>
			<tr>
				<td><input type="text" name="oldpassword" class ="oldpassword" placeholder="Enter your current password"></td>
			</tr>
			<tr>
			<td><p class="errors pass_err"></p></td>
			</tr>
			<tr>
			<td><button type="Submit" name="change-password" class ="btn pass">Change</button></td>
			</tr>
		</table>
		<button  class="btn" onclick="window.location.href='../dashboard'">Cancel</button>
	 </form>
	<script>
		document.querySelector('.edit_password').addEventListener("keyup", validateNpass);
		document.querySelector('.edit_password').addEventListener("blur", validateNpass);

		document.querySelector('.oldpassword').addEventListener("keyup", validateCpass);
		document.querySelector('.oldpassword').addEventListener("blur", validateCpass);



		function validateNpass()
		{
			var n = document.querySelector(".edit_password").value;
			if (n == "")
			{
				document.querySelector(".password_err").innerHTML = "Enter password ";
				setTimeout(remove,2500);
				return false;
			}
			else 
			{
				document.querySelector(".password_err").innerHTML = "";
				return true;
			}
		}


		function validateCpass()
		{
			var p = document.querySelector(".oldpassword").value;
			if (p == "")
			{
				document.querySelector(".pass_err").innerHTML = "Enter your current password";
				setTimeout(remove,2500);
				return false;
			}
			else 
			{
				document.querySelector(".pass_err").innerHTML = "";
				return true;
			}
		}
		
		
		function validate()
		{
			var npass = validateNpass();
			var cpass = validateCpass();
			var valid = npass && cpass;
			if (!valid)
			{
				document.querySelector(".response").innerHTML = "Can't change your password";
				setTimeout(remove,2500);
				return false;
			}
			else 
			{
				document.querySelector(".response").innerHTML = "";
				return true;
			}
		}

		function remove()
		{
			document.querySelector(".pass_err").innerHTML = "";
			document.querySelector(".password_err").innerHTML = "";
			document.querySelector(".response").innerHTML = "";
		}
	</script>
</body>
</html>

<?php
	include ("EditP.php");
?>