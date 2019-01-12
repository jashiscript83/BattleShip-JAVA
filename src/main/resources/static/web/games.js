var data;
var game;
var gamers;
var mails = [];

fetch("/api/games",{
    method:"GET",

}).then(function(response){
    if (response.ok){


        return response.json();
    }

}).then(function(json){
    data = json;

    createList();




    console.log(data);



}).catch(function (error){
    console.log("Request failed:" + error.message);
});

function createList() {

    var order = document.getElementById("ol");


    for (var i = 0; i < data.length; i++) {
        game = data[i].date;
        gamers = data[i].gamePlayers;
        var list = document.createElement("li");
        console.log(game)
        for (var r = 0; r < gamers.length; r++){

            mails.push(gamers[r].Player.email)


        }

        list.textContent =  game + ": " + mails.splice(0,2);


        order.appendChild( list);


    }



}
console.log(mails)