var quoteContainer = document.getElementById("TheAwesomeQuote");
var submitButton = document.getElementById("submitButton");
var submitDelete = document.getElementById("submitDelete");
var submitQouteById = document.getElementById("submitGetQuote");
var newQuote = document.getElementById("newQuote");
var newQuoteID = document.getElementById("newQuoteId");
var quoteId = document.getElementById("quoteId");

function getRandomQuote() {
    var promise = fetch("http://localhost:8080/Exercise-REST_Quotes/api/quote/random", {method: "GET"});
    promise.then(function (response) {
        return response.json();
    }).then(function (json) {
        quoteContainer.innerText = json.quote;
    });
}
;

getRandomQuote();

submitButton.onclick = function () {
    var promise = fetch("http://localhost:8080/Exercise-REST_Quotes/api/quote/", {method: "POST", body: JSON.stringify(newQuote.value), headers: new Headers({"content-type": "application/json"})});
    promise.then(function (response) {
        return response.json();
    }).then(function (json) {
        quoteContainer.innerText = "Added: ID:" + json.id + " Quote: " + json.quote;
    });
    event.preventDefault();
};
submitDelete.onclick = function () {
    var promise = fetch("http://localhost:8080/Exercise-REST_Quotes/api/quote/" + quoteId.value, {method: "DELETE"});
    promise.then(function (response) {
        return response.json();
    }).then(function (json) {
        console.log(json);
        quoteContainer.innerText = "Deleted Quote: " + json.quote;
    });
    event.preventDefault();
};
submitQouteById.onclick = function () {
    var promise = fetch("http://localhost:8080/Exercise-REST_Quotes/api/quote/" + newQuoteID.value, {method: "GET"});
    promise.then(function (response) {
        return response.json();
    }).then(function (json) {
        if (json.quote == null) {
            quoteContainer.innerText = "The entered ID doesn't exist";
        } else {
            quoteContainer.innerText = json.quote;
        }
    });
    event.preventDefault();
};
