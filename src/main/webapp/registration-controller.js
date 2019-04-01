function submitForm() {
    let company = {
        "id": null,
        "name": document.getElementById("company_name").value,
        "address": document.getElementById("address").value,
        "email": document.getElementById("email").value,
        "kkfRegistration": document.getElementById("kkfRegistration").value,
        "phoneNumber": [document.getElementById("phone_number").value],
        "retail": document.getElementById("retail").value,
        "wholesale": document.getElementById("wholesale").value,
    }
    var xmlhttp = new XMLHttpRequest();
    xmlhttp.open("POST", "/holesaler/api/company/register", true);
    xmlhttp.onreadystatechange = function () {
        if (xmlhttp.readyState > 3 && xmlhttp.status == 200) {

        }
    };
    xmlhttp.setRequestHeader("Content-Type", "application/json");
    xmlhttp.send(JSON.stringify(company));
}