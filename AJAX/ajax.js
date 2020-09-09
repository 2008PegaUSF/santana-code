function loadPokemon(pokemon){
    document.getElementById("name").innerHTML="Name: " + pokemon.name;
    document.getElementById("pic").src=pokemon.sprites.other["official-artwork"].front_default;
    document.getElementById("abilities").innerHTML= "Abilities: " + pokemon.abilities[0].ability.name;
    document.getElementById("weight").innerHTML= "Weight: " + pokemon.weight + " pounds";
}

function getPokemon(){
    console.log("in get pokemon");
    let pokemonID=document.getElementById("pkID").value;
    //Step 1
    var xhr = new XMLHttpRequest();
    //Step 2
    xhr.onreadystatechange = function(){
        console.log("in ORSC");

        if(xhr.readyState == 4 && xhr.status == 200){
            console.log(xhr.responseText);
            var pokemon = JSON.parse(xhr.responseText);
            loadPokemon(pokemon);
        }
    }
    //Step 3
    xhr.open("GET", "https://pokeapi.co/api/v2/pokemon/"+pokemonID,true);
    //Step 4
    xhr.send();
}

function getSprite(){
    console.log("in get sprite");
    let pokemonID=document.getElementById("pkID").value;
    //Step 1
    var xhr = new XMLHttpRequest();
    //Step 2
    xhr.onreadystatechange = function(){
        console.log("in ORSC");

        if(xhr.readyState == 4 && xhr.status == 200){
            console.log(xhr.responseText);
            var pokemon = JSON.parse(xhr.responseText);
            loadPokemon(pokemon);
        }
    }
    //Step 3
    xhr.open("GET", "https://pokeapi.co/api/v2/pokemon/"+pokemonID,true);
    //Step 4
    xhr.send();
}

window.onload=function(){
    console.log("in onload");
    document.getElementById("pokeSubmit").addEventListener("click", getPokemon, false);
    document.getElementById("pokeSubmit").addEventListener("click", getSprite, false);
    document.getElementById("pokeSubmit").addEventListener("click", getPokemon, false);
}