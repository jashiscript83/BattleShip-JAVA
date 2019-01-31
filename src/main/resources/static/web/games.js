var sound = document.createElement('audio')
sound.id = 'audio'
sound.autoplay = 'autoplay'
// sound.controls = 'controls'
sound.src = 'Vikings%20Intro%20(2013)%20HD.mp3'
sound.type = 'audio/mp3'
// document.body.appendChild(sound)

function playAudio() {
    document.getElementById('audio').play();
}

setTimeout("playAudio()", 3000);




var data;
var game;
var gamers;
var scores = [];
var mails = [];
var playersC = [];
Players = [];
var score = [];
var userData;
var user;
var gameId;





fetch("/api/games",{
    method:"GET",

}).then(function(response){
    if (response.ok){


        return response.json();
    }

}).then(function(json){
    data = json.games;
    userData = json;
    user = userData.User;
    console.log(user)
    console.log(json)
    createList();
    createScores();
    createTable();
    show();


}).catch(function (error){
    console.log("Request failed:" + error.message);
});



// function getParameterByName2(name) {
//
//     var match = RegExp('[?&]' + name + '=([^&]*)').exec(window.location.search);
//
//     return match && decodeURIComponent(match[1].replace(/\+/g, ' ',));
//
// }
//
// function getUrl2(){
//     gameId = getParameterByName2()
//     return"/api/game/"+ gameId +"/players";
// }

function join() {
    console.log(event.target)
    gameId = event.target.getAttribute("data-game")
    fetch("/api/game/"+gameId+"/players", {

        credentials: 'include',

        headers: {

            'Content-Type': 'application/x-www-form-urlencoded'

        },

        method: 'POST',



    })

        .then(function (data) {

            return data.json();        }).then(function (response) {
        window.location.href = "http://localhost:8080/web/game.html?gp=" + response.id

        console.log(response)})

        .catch(function (error) {

            console.log('Request failure: ', error.response);

        });
}

function createList() {

    var order = document.getElementById("ol");





    for (var i = 0; i < data.length; i++) {
        game = data[i].date;

        gamers = data[i].gamePlayers;


        var list = document.createElement("li");
        var a2 = document.createElement("a");
        var a = document.createElement("a");

         for (var r = 0; r < gamers.length; r++){

             mails.push(gamers[r].Player.email)





             idNumber = gamers[r].Id;

             if(gamers[r].Player.email == user) {

                 a.setAttribute("href", "http://localhost:8080/web/game.html?gp=" + idNumber);

                 a.textContent = " " + " ►" + "ENTRY" + "◄";



             }


         }

        if( mails.length == 1){

            a2.textContent = " " + " ►" + "JOIN" + "◄";
            a2.setAttribute("class","a2");


            a2.setAttribute("data-game",data[i].id);
            a2.addEventListener("click", join);
            a2.style.color = "#009688"


if(mails.includes(user)){
    a2.textContent = "";

}


        }


        list.textContent =  game + ": " +mails.splice(0,2);

        list.appendChild(a);
        list.appendChild(a2);

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

var email;
var password;


function getInput() {
    var inputEmail = document.getElementById("exampleInputEmail1");
    var inputPassword = document.getElementById("exampleInputPassword1");
    email = inputEmail.value
    password = inputPassword.value


    console.log(email + " " + password)
}




function login() {
    getInput();
    fetch("/api/login", {

        credentials: 'include',

        headers: {

            'Content-Type': 'application/x-www-form-urlencoded'

        },

        method: 'POST',

        body: 'userName='+email+'&password='+password,

    })

        .then(function (data) {


            console.log('Request success: ', data);        }).then(function () { location.reload(true)  })

.catch(function (error) {

            console.log('Request failure: ', error);

        });
}




function logout() {

    fetch("/api/logout", {

        credentials: 'include',

        headers: {

            'Content-Type': 'application/x-www-form-urlencoded'

        },

        method: 'POST',


    })

        .then(function (data) {

            console.log('Request success: ', data);        }).then(function () {location.reload(true)    })

        .catch(function (error) {

            console.log('Request failure: ', error);

        });
}


function signingUp() {
    getInput();


    fetch("/api/players", {

        credentials: 'include',

        headers: {

            'Content-Type': 'application/x-www-form-urlencoded'

        },

        method: 'POST',

        body: 'userName='+email+'&password='+password,

    })

        .then(function (data) {

            return data.json();        }).then(function (response) {  login(); console.log(response)})

        .catch(function (error) {

            console.log('Request failure: ', error.response);

        });
}
function createGame() {
    fetch("/api/games", {

        credentials: 'include',

        headers: {

            'Content-Type': 'application/x-www-form-urlencoded'

        },

        method: 'POST',



    })

        .then(function (data) {

            return data.json();        }).then(function (response) { console.log(response)})

        .catch(function (error) {

            console.log('Request failure: ', error.response);

        });

}


function  show() {

    var content = document.getElementById("showContent");
    var form = document.getElementById("showForm");
    var signButton = document.getElementById("sign");
    var loginButton = document.getElementById("login");
    var logoutButton = document.getElementById("logout");


    if (user == null ){

        form.style.display="block";
        content.style.display="none";

    }else if(user != null){
        form.style.display="none";
        content.style.display="block";
    }

    if(user != null){
        logoutButton.style.display ="block"
        loginButton.style.display ="none"
        signButton.style.display ="none"
    }else if (user == null){
        loginButton.style.display ="block"
        signButton.style.display ="block"
        logoutButton.style.display ="none"

    }

    console.log(user)
}


function  addships() {
    fetch("/api/games/players/"+ idNumber+"/ships", {

        credentials: 'include',

        headers: {

            'Accept': 'application/json',

            'Content-Type': 'application/json'

        },

        method: 'POST',
        body: JSON.stringify([{ }])



    })

        .then(function (response) {

            return response.json();            }).then(function (json) {        })

        .catch(function (error) {

            console.log('Request failure: ', error);
        });




}