document.querySelector('body').style.height = window.innerHeight+"px";

document.querySelector('.password').type = "password";
document.querySelector('.confirm-password').type = "password";
document.querySelector('.eye-line').style.display = "none";
document.querySelector('.confirm-eye-line').style.display = "none";
	
	function hide_show(id) {
		let line = document.querySelector('.' + id +'eye-line').style;

		if (line.display == "none") {
			line.display = "block";
			document.querySelector('.' + id + 'password').type = "text";
		} else {
			line.display = "none";
			document.querySelector('.' + id + 'password').type = "password";
		}
	}

document.querySelector('.email').addEventListener('blur', validateEmail);
document.querySelector('.username').addEventListener('blur', validateUsername);
document.querySelector('.password').addEventListener('blur', validatePassword);
document.querySelector('.confirm-password').addEventListener('blur', validateConfirmPassword);

document.querySelector('.email').addEventListener('keyup', validateEmail);
document.querySelector('.username').addEventListener('keyup', validateUsername);
document.querySelector('.password').addEventListener('keyup', validatePassword);
document.querySelector('.confirm-password').addEventListener('keyup', validateConfirmPassword);


function validateForm() {
	let w = validateEmail();
	let x = validateUsername();
	let y = validatePassword();
	let z = validateConfirmPassword();
	return w && x && y && z;
}

function validateEmail() {
	let x = validate("email");
	if (!x) {
		borderRed("email");
		return x;
	}
	else {
		x =	validateEmailFormat();
		if (!x) {
			document.querySelector('.error-email').innerHTML = "Enter a valid email address";
			borderRed("email");
			return false;
		}
		else {
			document.querySelector('.error-email').innerHTML = "";
			borderNormal("email");
			return true;
		}
	}
}

function validateEmailFormat() {
	var email = document.querySelector('.email').value;
	var format = /^[a-zA-Z0-9 .]+@+[a-zA-Z .]+$/;

	// checking basic format
	if(!email.match(format))
	{
		return false;
	}

	// checking if the first part contains at least one alphabet
	var str = email.substring(0, email.indexOf('@'));
		if (str.toLowerCase() == str.toUpperCase()) {
		return false;
	}

	// checking if beginning or the end of email contains '.'
	var SA = email.split('');
		if (SA[0] == '.' || SA[SA.length - 1] == '.') {
		return false;
	}

	// checking if email contains consecutive '.'
	var i;
	for (i = 0; i < (SA.length - 1); i++) {
		if ((SA[i] == '.' && SA[i+1] == '.') || (SA[i] == '@' && SA[i+1] == '.') || (SA[i] == '@' && SA[i+1] == '@') || (SA[i] == '.' && SA[i+1] == '@')) {
			return false;
		}
	}

	// checking if the last part contains at least one '.'
	str = email.substring(email.indexOf('@')+1, email.length);
	var count = 0;
	var s = str.split('');
	for (i = 0; i < s.length-1; i++) {
		if (s[i] == '.') {
			count++;
		}
	}
	if (count == 0) {
		return false;
	}
	return true;
}

function validateUsername() {
	let x = validate("username");
	if (!x) {
		borderRed("username");
		return x;
	}
	else {
		let y = validateUsernameFormat();
		if (!y) {
			borderRed("username");
		}
		else {
			borderNormal("username");
		}
		return y;
	}
}

function validateUsernameFormat() {
	var u = document.querySelector('.username').value;
	var format = /^[a-zA-Z0-9]+$/;

	// checking if username contains symbols
	if(!u.match(format))
	{
		document.querySelector('.error-username').innerHTML = "Username must not contain symbols";
		return false;
	}

	// setting minimum length
	if (u.length < 6) {
		document.querySelector('.error-username').innerHTML = "Username too short";
		return false;
	}

	// setting maximum length
	if (u.length > 20) {
		document.querySelector('.error-username').innerHTML = "Username too long";
		return false;
	}

	return true;
}

function validatePassword() {
	validateConfirmPassword();
	let x = validate("password");
	if (!x) {
		borderRed("password");
		return x;
	}
	else {
		let y = validatePasswordFormat();
		if (!y) {
			borderRed("password");
		}
		else {
			borderNormal("password");
		}

		return y;
	}
}

function validatePasswordFormat() {

	let p = document.querySelector('.password').value;

	// setting minimum length
	if (p.length < 6) {
		document.querySelector('.error-password').innerHTML = "Password too short";
		return false;
	}

	// setting maximum length
	if (p.length > 20) {
		document.querySelector('.error-password').innerHTML = "Password too long";
		return false;
	}

	if (!p.match(/[A-Z]/)) {
		document.querySelector('.error-password').innerHTML = "One uppercase required";
		return false;
	}
	else {
		if (!p.match(/[a-z]/)) {
			document.querySelector('.error-password').innerHTML = "One lowercase required";
			return false;
		}
		else {
			if (!p.match(/[0-9]/)) {
				document.querySelector('.error-password').innerHTML = "One number required";
				return false;
			}
		}
		document.querySelector('.error-password').innerHTML = "";
		return true;
	}
}

function validateConfirmPassword() {
	let p = document.querySelector('.password').value;
	let Cp = document.querySelector('.confirm-password').value;

	if (p != Cp) {
		document.querySelector('.error-confirm-password').innerHTML = "Passwords do not match";
		borderRed("confirm-password");
		return false;
	}
	else {
		document.querySelector('.error-confirm-password').innerHTML = "";
		borderNormal("confirm-password");
		return true;
	}

}

function validate(className) {
	let input = document.querySelector('.'+ className);
	let error = document.querySelector('.error-' + className);

	if (input.value == '') {
		error.innerHTML = "Enter the "+ className;
		return false;
	}
	else {
		error.innerHTML = "";
		return true;
	}
}

function borderRed (className) {
	let x = document.querySelector('.'+ className);
	x.style.border = "3px solid #f00";
}

function borderNormal (className) {
	let x = document.querySelector('.'+ className);
	x.style.border = "3px solid #008";
}

function removeResponse () {
	document.querySelector('.response').innerHTML = "";
}

if ( window.history.replaceState ) {
	window.history.replaceState( null, null, window.location.href );
}