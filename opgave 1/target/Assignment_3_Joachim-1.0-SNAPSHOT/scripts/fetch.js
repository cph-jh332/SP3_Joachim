var tableContainer = document.getElementById("tableContainer");
var addPersonButton = document.getElementById("addPersonButton");
var personForm = document.getElementById("personForm");
var submitButton;

var table = function (array) {
    var content = "<thead><tr>";
    for (item in array[0]) {
        content += "<th>" + item + "</th>"
    }
    content += "</tr></thead>";
    var id;
    var mapped = array.map(
            function (items) {
                var list = "<tr>";
                for (key in items) {
                    list += "<td>" + items[key] + "</td>";
                }
                id = items.id;
                list += "<td class=\"button\" onclick=\"deletePerson("+items.id+")\">Delete</td>"+
                        "<td class=\"button\" onclick=\"editPerson("+items.id+",'"+items.firstname+"','"+items.lastname+"',"+items.phone+")\">Edit</td>"+
                        "</tr>";
                return list;
            }
    );
    var joined = mapped.join("");
    return "<table>" + content + joined + "</table>";
};

function getPersons() {
    tableContainer.innerHTML = "";
    var promise = fetch("http://localhost:8080/Assignment_3_Joachim/api/persons", {method: "GET"});
    promise.then(function (response) {
        return response.json();
    }).then(function (json) {
        tableContainer.innerHTML += table(json);
    });
};

addPersonButton.onclick = function () {
    personForm.innerHTML = "Firstname:<input id=\"firstname\">" +
            "Lastname<input id=\"lastname\">" +
            "Phone:<input type=\"phone\" id=\"phone\">" +
            "<button class=\"button\" id=\"submitButton\">Submit</button>";
    submitButton = document.getElementById("submitButton");
    submitButton.onclick = function () {
        var firstname = document.getElementById("firstname");
        var lastname = document.getElementById("lastname");
        var phone = document.getElementById("phone");
        var promise = fetch("http://localhost:8080/Assignment_3_Joachim/api/person", 
            {method: "POST", body: JSON.stringify({"firstname": firstname.value, "lastname":lastname.value, "phone":phone.value}),
            headers: new Headers({"content-type": "application/json"})});
        promise.then(function (response) {
            personForm.innerHTML = "";
            getPersons();
        });
        event.preventDefault();
    };
    event.preventDefault();
};

function deletePerson(id){
    var promise = fetch("http://localhost:8080/Assignment_3_Joachim/api/person/delete/"+id, {method: "DELETE"});
    promise.then(function (response) {
        getPersons();
    });
}

function editPerson( id, firstname, lastname, phone){
    personForm.innerHTML = "Firstname:<input id=\"firstname\" value=\""+firstname+"\">" +
            "Lastname<input id=\"lastname\" value=\""+lastname+"\">" +
            "Phone:<input type=\"phone\" id=\"phone\" value=\""+phone+"\">" +
            "<button class=\"button\" id=\"submitButton\">Submit</button>";
    submitButton = document.getElementById("submitButton");
    submitButton.onclick = function () {
        var firstnameInput = document.getElementById("firstname");
        var lastnameInput = document.getElementById("lastname");
        var phoneInput = document.getElementById("phone");
        
        var promise = fetch("http://localhost:8080/Assignment_3_Joachim/api/person", 
            {method: "PUT", body: JSON.stringify({"id": id, "firstname": firstnameInput.value, "lastname":lastnameInput.value, "phone":phoneInput.value}),
            headers: new Headers({"content-type": "application/json"})});
        promise.then(function (response) {
            personForm.innerHTML = "";
            getPersons();
        });
        event.preventDefault();
    };
}

getPersons();