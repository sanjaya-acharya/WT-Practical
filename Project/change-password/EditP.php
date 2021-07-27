<?php
	// Checking if the user is already logged in
	if (!isset($_SESSION['loggedin']) || $_SESSION['loggedin'] == false) {
		header("location: ../login/");
		exit();
	}

	// Checking form data only when submit button is clicked
	if (isset($_POST['change-password'])) {
		// including the file that gives a connection to the database
		require_once "../config.php";
		
		// Retrieving form data from super global $_POST
		$username = $_SESSION['username'];
		$oldpassword = mysqli_real_escape_string($conn, $_POST['oldpassword']);
		$newpassword = mysqli_real_escape_string($conn, $_POST['newpassword']);

		// Encrypting the form data because we have encrypted password in database also
		$oldpassword = md5($oldpassword);
		$newpassword = md5($newpassword);
		
		// Preaparing and binding statements to check user credientials
		$stmt = $conn->prepare("SELECT username, password FROM users WHERE username=? AND password=? LIMIT 1");
		$stmt->bind_param('ss', $username, $oldpassword);
		$result = $stmt;
		$stmt->execute();
		$stmt->bind_result($u, $p);
		$stmt->store_result();
		$num_of_rows = $stmt->num_rows;

		if($num_of_rows == 1) {
			if ($oldpassword == $newpassword) {
				echo "New Password must be different from Old password!";
			}
			else {
				$sql = "UPDATE users SET password = '$newpassword' WHERE username = '$username'";

				if ($conn->query($sql) === TRUE)
				{
					unset($_SESSION['loggedin']);
					header('Location: ../login?Password-Changed');
					exit();
				}
			}
		}
		else {
			echo "Invalid Password";
		}

		$stmt->close();
		$conn->close();
	}
?>