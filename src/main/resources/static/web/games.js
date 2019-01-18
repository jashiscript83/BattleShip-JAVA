var data;
var game;
var gamers;
var scores = [];
var mails = [];
var playersC = [];
Players = [];
var score = [];



fetch("/api/games",{
    method:"GET",

}).then(function(response){
    if (response.ok){


        return response.json();
    }

}).then(function(json){
    data = json;

    createList();
    createScores();
    createTable()


}).catch(function (error){
    console.log("Request failed:" + error.message);
});

function createList() {

    var order = document.getElementById("ol");

    for (var i = 0; i < data.length; i++) {
        game = data[i].date;
        gamers = data[i].gamePlayers;
        var list = document.createElement("li");
         for (var r = 0; r < gamers.length; r++){

            mails.push(gamers[r].Player.email)

        }

        list.textContent =  game + ": " + mails.splice(0,2);

        order.appendChild( list);

    }

}

function  createScores() {



    for (var i = 0; i < data.length; i++){
       var results = data[i].scores;

        if (results.length == 2){

            scores.push(data[i].scores)
        }
    }
    for (var x = 0; x < scores.length; x++){
             for (var q = 0; q < scores[x].length; q++){
            playersC.push(scores[x][q].player)

            score.push(scores[x][q].score)

        }

    }

  Players = playersC.filter(function(item, pos) {
        return playersC.indexOf(item) == pos;
    })


    console.log(Players)
    console.log(score)



}

function  createTable() {


    var name = document.getElementById("name")

    name.style.fontSize="25px"
    name.style.fontWeight="bold"
    name.style.color="red"


    var total = document.getElementById("total")
    for (var x = 0; x < Players.length; x++){
        var tr = document.createElement("tr")
        var td = document.createElement("td")
        td.style.color ="black"

        var td2 = document.createElement("td")
        var td3 = document.createElement("td")
        var td4 = document.createElement("td")
        var td5 = document.createElement("td")
        var total = 0;
        var win = [];
        var lose = [];
        var tied = [];


        for (var l = 0; l < scores.length; l++){
            for (var q = 0; q < scores[l].length; q++){

                if(Players[x]==scores[l][q].player){
                   total += scores[l][q].score;

                    if( scores[l][q].score == 1){
                        win.push(scores[l][q].score)
                    }
                    if(scores[l][q].score == 0){
                        lose.push(scores[l][q].score)
                    }
                    if(scores[l][q].score == 0.5){
                        tied.push(scores[l][q].score)
                    }


                }



            }

        }

        td.textContent = Players[x] ;
        td2.textContent = total ;
        td3.textContent = win.length;
        td4.textContent = lose.length ;
        td5.textContent = tied.length;
        tr.appendChild(td)
        tr.appendChild(td2)
        tr.appendChild(td3)
        tr.appendChild(td4)
        tr.appendChild(td5)

        name.appendChild(tr)



    }

}