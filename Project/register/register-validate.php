<?php
	// Checking if the user is already logged in
	session_start();
	if (isset($_SESSION['loggedin']) && $_SESSION['loggedin'] == true) {
		header("location: ../dashboard/");
	}

	// Checking form data only when submit button is clicked
	if (isset($_POST['register'])) {
		// including the file that gives a connection to the database
		require_once "../config.php";

		// Retrieving form data from super global $_POST
		$email = mysqli_real_escape_string($conn, $_POST['email']);
		$username = mysqli_real_escape_string($conn, $_POST['username']);
		$password = mysqli_real_escape_string($conn, $_POST['password']);
		$rpassword = mysqli_real_escape_string($conn, $_POST['confirm-password']);

		// set $data_error to false at begining and set it true when error occurs
		$data_error = false;

	// Checking if the email is already used by other users...
		// Preaparing and binding statements to check user credientials...
		$stmt = $conn->prepare("SELECT email FROM users WHERE email=? LIMIT 1");
		$stmt->bind_param('s', $email);
		$stmt->execute();
		$stmt->bind_result($email);
		$stmt->store_result();

		// If the email already exists in the database, then $stmt will have one row...
		if ($stmt->num_rows == 1) {
			$data_error = true;
			
			?>
				<script type="text/javascript">
					document.querySelector('.error-email').innerHTML = "Email already taken";
				</script>
			<?php

		}

	// Checking if the username is already used by other users...
		// Preaparing and binding statements to check user credientials...
		$stmt = $conn->prepare("SELECT username FROM users WHERE username=? LIMIT 1");
		$stmt->bind_param('s', $username);
		$stmt->execute();
		$stmt->bind_result($username);
		$stmt->store_result();

		// If the username exists in the database, then $stmt will have one row...
		if ($stmt->num_rows == 1) {
			$data_error = true;

			?>
				<script type="text/javascript">
					var y = document.querySelector('.username').value;
					document.querySelector('.error-username').innerHTML = "Username already taken";
				</script>
			<?php

		}

		// If there is no data_error insert it to the database
		if (!$data_error) {
			// Preaparing and binding statements to insert user credientials...
			$stmt = $conn->prepare("INSERT INTO users (email, username, password) VALUES (?, ?, ?)");
			$stmt->bind_param("sss", $email, $username, $password);

			// Encrypt password...
			$password = md5($password);

			// Execute statement...
			$stmt->execute();

			?>
				<script type="text/javascript">
					document.querySelector('.response').innerHTML = "Account created succesfully";
					setTimeout(removeResponse, 2000);
				</script>
			<?php
		}
		else {
	
			?>
				<script type="text/javascript">
					document.querySelector('.response').innerHTML = "Account couldn't be created";
					setTimeout(removeResponse, 2000);
				</script>
			<?php
	
		}
		
		$stmt->close();
		$conn->close();
	}

?>