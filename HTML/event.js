function pow(event){
    var x = document.getElementById("B");
  if (x.style.display === "none") {
    x.style.display = "block";
  } else {
    x.style.display = "none";
  }
}

window.onload= function(){
    this.document.getElementById("A").addEventListener("dblclick",pow,true);
    this.document.getElementById("B").addEventListener("resize",pow,true);
    this.document.getElementById("C").addEventListener("click",pow,true);
    this.document.getElementById("D").addEventListener("dblclick",pow,true);
}