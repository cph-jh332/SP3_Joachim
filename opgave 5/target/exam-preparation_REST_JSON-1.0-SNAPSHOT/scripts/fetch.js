var tableContainer = document.getElementById("tableContainer");
var amountOfPeople = document.getElementById("amountOfPeople");
var startId = document.getElementById("startId");
var submitButton = document.getElementById("submit");

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
                list += "</tr>";
                return list;
            }
    );
    var joined = mapped.join("");
    return "<table>" + content + joined + "</table>";
};

submitButton.onclick = function(){
    var promise = fetch("http://localhost:8080/exam-preparation_REST_JSON/api/data/"+amountOfPeople.value+"/"+startId.value, {method: "GET"});
    promise.then(function (response) {
        return response.json();
    }).then(function (json) {
        tableContainer.innerHTML = "";
        tableContainer.innerHTML += table(json);
    });
    event.preventDefault();
};