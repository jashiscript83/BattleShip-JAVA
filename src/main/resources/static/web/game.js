var data;
var locations = [];
var gamer1;
var gamer2;
var mails = [];

fetch(getUrl(),{
    method:"GET",

}).then(function(response){
    if (response.ok){

        return response.json();
    }

}).then(function(json){
    data = json;
    console.log(data);
    getParameters();
    createTable();
    playersVs();



}).catch(function (error){
    console.log("Request failed:" + error.message);
});

function getParameterByName(name) {

var match = RegExp('[?&]' + name + '=([^&]*)').exec(window.location.search);

return match && decodeURIComponent(match[1].replace(/\+/g, ' '));

}

function getUrl(){
    let id = getParameterByName("gp")
    return "/api/game_view/" + id;
};

function getParameters(){

    for(var a = 0; a < data.ships.length; a++){

        locations.push(data.ships[a].locations)


    }
};

function createTable() {
    var Alpha = ["","A","B","C","D","E","F","G","H","I","J"]
    var body = document.getElementById("table");
    var table = document.createElement("table");
    var tbody = document.createElement("tbody");
    table.appendChild(tbody);
    table.style.border = "5px solid blue";
     table.style.width= "50%";
     table.style.margin = "5%";

    for(var i = 0; i<11 ; i++){

        var tr = document.createElement("tr");
        tbody.appendChild(tr);
        tr.style.border = "3px solid white";

        tr.style.padding = "15px";


        for(var x = 0; x<11 ; x++){

            var td = document.createElement("td");
            if (i == 0 && x>0){
                td.textContent = x ;
            }
            if (i >0 && x==0){
                td.textContent = Alpha[i] ;
            }
            td.setAttribute("id",Alpha[i] + x );


            tr.appendChild(td);
            td.style.border = "3px solid white";
            td.style.padding = "15px"

        }


    }
    body.appendChild(table);

    for(var n = 0; n < locations.length; n++) {
        for(var s = 0; s < locations[n].length; s++){

            var positions = locations[n][s]


            var value = document.getElementById(positions)
            value.style.background = "red";

        }
    }



}

function playersVs(){

    var players = document.getElementById("gamers")
    for (var l = 0; l < data.game.gamePlayers.length; l++) {

        gamer1 = data.game.gamePlayers[0].Player.email;
        gamer2 = data.game.gamePlayers[1].Player.email;

        players.textContent = gamer1 + " " + "VS"+ " " +gamer2;

    }
}
