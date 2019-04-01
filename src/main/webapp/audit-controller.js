loadNewRegistrations();

let coll = document.getElementsByClassName("collapsible");
let i;

for (i = 0; i < coll.length; i++) {
    coll[i].addEventListener("click", function () {
        this.classList.toggle("active");
        var content = this.nextElementSibling;
        if (content.style.display === "block") {
            content.style.display = "none";
        } else {
            content.style.display = "block";
        }
    });
}

function loadNewRegistrations() {
    let xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            let newRegistrations = JSON.parse(this.responseText);
            let newRegistrationsList = '';
            '<div class="w3 w3-card-4" style="padding-bottom: 5px">';

            newRegistrations.reverse();

            for (let index = 0; index < newRegistrations.length; index++) {
                let retail = '';
                let wholesale = '';
                if (newRegistrations[index].retail) {
                    retail = ' <span class="w3-large"> Retailer </span><br> '
                }
                if (newRegistrations[index].wholesale) {
                    wholesale = ' <span class="w3-large"> Wholesaler </span><br> '
                }
                newRegistrationsList +=
                    ' <div class="w3-bar-item"> ' +
                    ' <span class="w3-large"> Name: ' + newRegistrations[index].name + ' </span><br> ' +
                    retail +
                    wholesale +
                    ' <button type="submit" id= ' + newRegistrations[index].id + ' onclick="approveRegistration(this.id)" ' +
                    ' class="w3-bar-item w3-button w3-small w3-right">Approve</button> ' +
                    ' <button type="submit" id=' + newRegistrations[index].id + ' onclick="rejectRegistration(this.id)" ' +
                    ' class="w3-bar-item w3-button w3-small w3-right">Reject</button> ' +
                    ' </div> '
                //

                ;
                newRegistrationsList += "</div>";
                document.getElementById("newRegistrationsData").innerHTML = newRegistrationsList;
            }
        }
    };
    xhttp.open("GET", "/holesaler/api/company/new_registrations", true);
    xhttp.send();
}


function approveRegistration(id) {
    if (confirm('Are you sure u want to approve this company ')) {
        let company = {"id": id}
        var xhttp = new XMLHttpRequest();
        xhttp.open("POST", "/holesaler/api/company/approve", true);
        xhttp.onreadystatechange = function () {
            if (xhttp.readyState > 3 && xhttp.status == 200) {
                loadNewRegistrations();
            }
        };
        xhttp.setRequestHeader("Content-Type", "application/json");
        xhttp.send(JSON.stringify(company));
    }
}