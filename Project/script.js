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
    error.innerHTML = "Enter the "+ className + "!";
    input.style.border = "3px solid #f00";
    return false;
  }
  else {
    error.innerHTML = "";
    input.style.border = "3px solid #008";
    return true;
  }
}



// document.querySelector('.label-username').style.display = "none";
// document.querySelector('.label-password').style.display = "none";

// document.querySelector(".username").addEventListener("mouseover", inputAnimateU);
// document.querySelector(".username").addEventListener("click", inputAnimateU);
// document.querySelector(".username").addEventListener("mouseout", inputRemoveAnimateU);

// // document.querySelector(".password").addEventListener("mouseover", inputAnimate('.label-password'));
// // document.querySelector(".password").addEventListener("click", inputAnimate('.label-password'));

// function inputAnimateU() {
// 	document.querySelector('.label-username').style.display = "inline-block";
// 	var ph = document.querySelector('.username').placeholder = "";
// 	console.log(ph);
// }

// function inputRemoveAnimateU() {
// 	var x = document.querySelector('.username').value;
// 	if (x == ''){
// 		document.querySelector('.label-username').style.display = "none";
// 		var ph = document.querySelector('.username').placeholder = "Username";
// 	}
// }

document.querySelector(".showOrHide").addEventListener("change", hide_show);

function ValidateEmail() {
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
    if ((SA[i] == '.' && SA[i+1] == '.') || (SA[i] == '@' && SA[i+1] == '.') || (SA[i] == '@' && SA[i+1] == '@')) {
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


function hide_show () {
  var x = document.querySelector('.showOrHide');
  var y = document.querySelector('.password');

  if (x.checked) {
    y.type="text";
  }
  else {
    y.type="password"
  }
}

document.querySelector('.username').addEventListener("keyup", valid_username);
document.querySelector('.password').addEventListener("keyup", valid_password);

document.querySelector('.username').addEventListener("blur", valid_username);
document.querySelector('.password').addEventListener("blur", valid_password);

function valid_username () {
  var username = document.querySelector('.username').value;

  if (username == '') {
    document.querySelector('.username_err').innerHTML = "Username can't be empty";
    return false;
  }
  else {
    document.querySelector('.username_err').innerHTML = "";
    return true;
  }
}

function valid_password () {
  var username = document.querySelector('.password').value;

  if (username == '') {
    document.querySelector('.password_err').innerHTML = "Password can't be empty";
    return false;
  }
  else {
    document.querySelector('.password_err').innerHTML = "";
    return true;
  }
}

function validate () {
  var v_u = valid_username();
  var v_p = valid_password();
  var valid = v_u && v_p;

  if (!valid) {
    document.querySelector('.response').innerHTML = "Please provide a valid information to login"
    setTimeout(remove_messages, 3000);
  }
  
  return valid;
}


function remove_messages() {
  document.querySelector('.username_err').innerHTML = "";
  document.querySelector('.password_err').innerHTML = "";
  document.querySelector('.response').innerHTML = "";
}

if ( window.history.replaceState ) {
  window.history.replaceState( null, null, window.location.href );
}
