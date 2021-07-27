document.querySelector('body').style.height = window.innerHeight+"px";

document.querySelector('.password').type = "password";
document.querySelector(".label-hide-show").addEventListener("click", () => {
	let x = document.querySelector('.hide-show');

	if (x.checked == true) {
		x.checked = false;
		hide_show();
	}
	else {
		x.checked = true;
		hide_show();
	}
});

document.querySelector(".hide-show").addEventListener("change", hide_show);

function hide_show () {
	let x = document.querySelector('.hide-show');
	let y = document.querySelector('.password');

	if (x.checked) {
		y.type="text";
	}
	else {
		y.type="password";
	}
}

document.querySelector('.username').addEventListener('blur', validateUsername);
document.querySelector('.password').addEventListener('blur', validatePassword);
document.querySelector('.username').addEventListener('keyup', validateUsername);
document.querySelector('.password').addEventListener('keyup', validatePassword);


function validateForm() {
	let x = validate("username");
	let y = validate("password");
	return x && y;
}

function validateUsername() {
	validate("username");
}

function validatePassword() {
	validate("password");
}

function validate(className) {
	let input = document.querySelector('.'+ className);
	let error = document.querySelector('.error-' + className);

	if (input.value == '') {
		error.innerHTML = "Enter the "+ className;
		input.style.border = "3px solid #f00";
		return false;
	}
	else {
		error.innerHTML = "";
		input.style.border = "3px solid #008";
		return true;
	}
}

function removeResponse () {
	document.querySelector('.response').innerHTML = "";
}

if ( window.history.replaceState ) {
	window.history.replaceState( null, null, window.location.href );
}