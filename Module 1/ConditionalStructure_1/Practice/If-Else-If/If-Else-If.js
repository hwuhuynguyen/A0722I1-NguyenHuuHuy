let inputUsername = prompt('Enter your username: ', '');

if (inputUsername == "Admin") {
    let inputPassword = prompt("Enter the password: ", '');
    if (inputPassword == "TheMaster") {
        alert('Welcome you, Admin!');
    } else if (inputPassword === '') {
        alert('Canceled');
    } else {
        alert('Wrong password!');
    }
} else if (inputUsername == '') {
    alert('Canceled');
} else {
    alert('I dont know you');
}

