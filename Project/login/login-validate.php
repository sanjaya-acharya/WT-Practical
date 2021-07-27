<?php
	$_SESSION['login-response'] = "";

	// Checking if the user is already logged in
	session_start();
	if (isset($_SESSION['loggedin']) && $_SESSION['loggedin'] == true) {
		header("location: ../dashboard/");
		exit();
	}

	// Checking form data only when submit button is clicked
	if (isset($_POST['login'])) {
		// including the file that gives a connection to the database
		require_once "../config.php";
		
		// Retrieving form data from super global $_POST
		$username = mysqli_real_escape_string($conn, $_POST['username']);
		$password = mysqli_real_escape_string($conn, $_POST['password']);
		
		// Encrypting the form data because we have encrypted password in database also
		$password = md5($password);
		
		// Preaparing and binding statements to check user credientials
		$stmt = $conn->prepare("SELECT username, password FROM users WHERE username=? LIMIT 1");
		$stmt->bind_param('s', $username);
		$result = $stmt;
		$stmt->execute();
		$stmt->bind_result($u, $p);
		$stmt->store_result();
		$num_of_rows = $stmt->num_rows;

		$result->execute();
		$result = $result->get_result();
		$row = $result->fetch_assoc();
		$databasePassword = $row['password'];

		if($num_of_rows == 1) {
			// If the a  row is stored in variable, the username exists in database
			if ($databasePassword == $password) {
				// If program execution comes to this point, user had supplied correct details. 
				// So, setting session variables
				$_SESSION['loggedin'] = true;
				$_SESSION['username'] = $username;
				unset($_SESSION['login-response']);

				header("Location: ../dashboard/");
				exit();
			}
			else {
				?>
					<script type="text/javascript">
						document.querySelector('.response').innerHTML = "Invalid Password";
						setTimeout(removeResponse, 2000);
					</script>
				<?php
			}
		}
		else {
			?>
			<script type="text/javascript">
				document.querySelector('.response').innerHTML = "Invalid Username";
				setTimeout(removeResponse, 2000);
			</script>
			<?php
		}

		$stmt->close();
		$conn->close();
	}
?>
