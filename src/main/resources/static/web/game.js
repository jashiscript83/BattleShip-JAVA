var data;
var locations = [];
var Salvolocations1 = [];
var Salvolocations2 = [];
var gamer1;
var gamer2;
var id;
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
    createTable2();
     playersVs();




}).catch(function (error){
    console.log("Request failed:" + error.message);
});

function getParameterByName(name) {

var match = RegExp('[?&]' + name + '=([^&]*)').exec(window.location.search);

return match && decodeURIComponent(match[1].replace(/\+/g, ' '));

}

function getUrl(){
     id = getParameterByName("gp")
    return "/api/game_view/" + id;
};

function getParameters(){
console.log("hi")
    for(var a = 0; a < data.ships.length; a++){

        locations.push(data.ships[a].locations)



    }

console.log(data.salvos)

    for(let i = 0; i<data.salvos.length;i++){
        var salvoArray =  data.salvos[i].salvos;
        console.log(salvoArray)
        for(var q = 0; q <salvoArray.length; q++){
            if( id != salvoArray[q].GamePlayerId ){


                Salvolocations2.push(salvoArray[q].salvoLocations);
            }
            if( id == salvoArray[q].GamePlayerId ){

                Salvolocations1.push(salvoArray[q].salvoLocations);
            }


        }


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

            var positions = locations[n][s];


            var value = document.getElementById(positions);

               value.setAttribute("class","ships" );

        }
    }


    for(var m = 0; m <Salvolocations2.length; m++) {
        for(var l = 0; l < Salvolocations2[m].length; l++){

            var positions2 = Salvolocations2[m][l];



            var value2 = document.getElementById(positions2);
            value2.classList.add("salvos");

            if (value2.classList.contains("ships")){

                value2.setAttribute("class","hits")
            }

        }


    }
    var ships = document.getElementsByClassName("ships");
    var salvos = document.getElementsByClassName("salvos");
    var hits = document.getElementsByClassName("hits");


}
function createTable2() {
    var Alpha2 = ["","A","B","C","D","E","F","G","H","I","J"]
    var body2 = document.getElementById("table2");
    var table2 = document.createElement("table");
    var tbody2 = document.createElement("tbody");
    table2.appendChild(tbody2);
    table2.style.border = "5px solid blue";
    table2.style.width= "50%";
    table2.style.margin = "5%";

    for(var i = 0; i<11 ; i++){

        var tr2 = document.createElement("tr");
        tbody2.appendChild(tr2);
        tr2.style.border = "3px solid white";

        tr2.style.padding = "15px";


        for(var x = 0; x<11 ; x++){

            var td2 = document.createElement("td");
            if (i == 0 && x>0){
                td2.textContent = + x ;
            }
            if (i >0 && x==0){
                td2.textContent = Alpha2[i] ;
            }
            td2.setAttribute("id", "*" + Alpha2[i] + x );


            tr2.appendChild(td2);
            td2.style.border = "3px solid white";
            td2.style.padding = "15px"

        }


    }
    body2.appendChild(table2);


    for(var e = 0; e <Salvolocations1.length; e++) {
        for(var u = 0; u < Salvolocations1[e].length; u++){

            var positions3 = "*" +  Salvolocations1[e][u];

            console.log(positions3 )
            var value3 = document.getElementById(positions3);
            value3.style.background = "blue";

            console.log(value3)

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
