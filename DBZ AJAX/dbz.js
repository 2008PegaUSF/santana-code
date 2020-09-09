function loadCharacter(character){
    document.getElementById("name").innerHTML=character.series;
    document.getElementById("pic").src=character.image;
}

function getCharacter(){
    console.log("in get character");
    let charName=document.getElementById("charName").value;
    //Step 1
    var xhr = new XMLHttpRequest();
    //Step 2
    xhr.onreadystatechange = function(){
        console.log("in ORSC");

        if(xhr.readyState == 4 && xhr.status == 200){
            console.log(xhr.responseText);
            var character = JSON.parse(xhr.responseText);
            loadCharacter(character);
        }
    }
    //Step 3
    xhr.open("GET", "https://dragon-ball-api.herokuapp.com/api/character/"+charName,true);
    //Step 4
    xhr.send();
}

function getSprite(){
    console.log("in get sprite");
    let charName=document.getElementById("charName").value;
    //Step 1
    var xhr = new XMLHttpRequest();
    //Step 2
    xhr.onreadystatechange = function(){
        console.log("in ORSC");

        if(xhr.readyState == 4 && xhr.status == 200){
            console.log(xhr.responseText);
            var character = JSON.parse(xhr.responseText);
            loadCharacter(character);
        }
    }
    //Step 3
    xhr.open("GET", "https://dragon-ball-api.herokuapp.com/api/",true);
    //Step 4
    xhr.send();
}

window.onload=function(){
    console.log("in onload");
    document.getElementById("charSubmit").addEventListener("click", getCharacter, false);
    document.getElementById("charSubmit").addEventListener("click", getSprite, false);
}