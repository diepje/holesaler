function login() {
    const credentials = {
        "username": document.getElementById("username").value,
        "password": document.getElementById("password").value
    };
    let xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (xhttp.readyState > 3 && xhttp.status == 200) {
            if (this.responseText) {
                let user = JSON.parse(this.responseText)
                if (user.role) {
                    window.location = "employee-home.html";
                }
                sessionStorage.setItem("user", this.responseText)
            } else {
                loginFailedAlert();
            }
        }
    };
    xhttp.open("POST", "/holesaler/api/auth/login", true);
    xhttp.setRequestHeader("Content-Type", "application/json");
    xhttp.send(JSON.stringify(credentials));
    this.preventDefault();
}

function loginFailedAlert() {
    alert("Invalid password.. .. or username, please try again!");
}