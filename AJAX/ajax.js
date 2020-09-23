function loadPokemon(pokemon){
    document.getElementById("name").innerHTML="Name: " + pokemon.name;
    document.getElementById("pic").src=pokemon.sprites.other["official-artwork"].front_default;
    document.getElementById("abilities").innerHTML= "Abilities: " + pokemon.abilities[0].ability.name;
    document.getElementById("weight").innerHTML= "Weight: " + pokemon.weight + " pounds";
    moves(pokemon);
}

function moves(pokemon){
    let tableHead = document.getElementById("movesTable");
    let tableBody = document.getElementById("movesName");

    let headerRow = document.createElement("tr");
    let header = document.createElement("th");
    let headerText = document.createTextNode("Moves");

    tableHead.appendChild(headerRow);
    headerRow.appendChild(header);
    header.appendChild(headerText);

    for(let i = 0; i < pokemon.moves.length; i++){
        let moveRow = document.createElement("tr");
        let moveData = document.createElement("td");
        let move = pokemon.moves[i].move.name;
        let moveName = document.createTextNode(move);

        tableBody.appendChild(moveRow);
        moveRow.appendChild(moveData);
        moveData.appendChild(moveName);
    }

}

function getPokemon(){
    let pokemonID=document.getElementById("pkID").value;
    //Step 1
    var xhr = new XMLHttpRequest();
    //Step 2
    xhr.onreadystatechange = function(){

        if(xhr.readyState == 4 && xhr.status == 200){
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
    document.getElementById("pokeSubmit").addEventListener("click", getPokemon, false);
}