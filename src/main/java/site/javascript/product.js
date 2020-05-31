function product(omschrijving,categorie,landvherkomst,prijs) {
    this.omschrijving=omschrijving;
    this.categorie=categorie;
    this.landvherkomst=landvherkomst;
    this.prijs=prijs;
    toArray=function () {
        return {omschrijving,categorie,landvherkomst,prijs};
    }}

    function account(naam,password,acces){

        this.naam=naam;
        this.password=password;
        this.acces=acces;

        toArray=function(){
            return [naam,password];
        }

function filltable(){
    var list=fetch("restervices/winkel").then(response=Promise.all([response.status, response.json()]))

    for(var obj in list){
        row=document.createElement("tr");
        cell1 = document.createElement("td");
        cell2 = document.createElement("td");
        cell3 = document.createElement("td");
        cell4 = document.createElement("td");
        textnode1=document.createTextNode(obj.omschrijving);
        textnode2=document.createTextNode(obj.categorie);
        textnode3=document.createTextNode(obj.landvherkomst);
        textnode4=document.createTextNode(obj.prijs);
        cell1.appendChild(textnode1);
        cell2.appendChild(textnode2);
        cell3.appendChild(textnode3);
        cell4.appendChild(textnode4);
        row.appendChild(cell1);
        row.appendChild(cell2);
        document.querySelector("#tablewinkel").append(row);
    }

}


function filltablewinkel() {
    var list=fetch("restervices/winkel").then(response=Promise.all([response.status, response.json()]))

    for(var obj in list){
        row=document.createElement("tr");
        cell1 = document.createElement("td");
        cell2 = document.createElement("td");
        cell3 = document.createElement("td");
        cell4 = document.createElement("td");
        textnode1=document.createTextNode(obj.omschrijving);
        textnode2=document.createTextNode(obj.categorie);
        textnode3=document.createTextNode(obj.landvherkomst);
        textnode4=document.createTextNode(obj.prijs);
        cell1.appendChild(textnode1);
        cell2.appendChild(textnode2);
        cell3.appendChild(textnode3);
        cell4.appendChild(textnode4);
        row.appendChild(cell1);
        row.appendChild(cell2);
        document.querySelector("#tablewinkel").append(row);
    }
}
function filltableklant(){
    var list=fetch("restervices/winkelwagen").then(response=Promise.all([response.status, response.json()]))
    for(var obj in list){
        row=document.createElement("tr");
        cell1 = document.createElement("td");
        cell2 = document.createElement("td");
        cell3 = document.createElement("td");
        cell4 = document.createElement("td");
        textnode1=document.createTextNode(obj.omschrijving);
        textnode2=document.createTextNode(obj.categorie);
        textnode3=document.createTextNode(obj.landvherkomst);
        textnode4=document.createTextNode(obj.prijs);
        cell1.appendChild(textnode1);
        cell2.appendChild(textnode2);
        cell3.appendChild(textnode3);
        cell4.appendChild(textnode4);
        row.appendChild(cell1);
        row.appendChild(cell2);
        document.querySelector("#tablewinkel").append(row);
    }

}

}

function validate() {
    var formData=new FormData(document.querySelector("#auth"));
    var encData=new URLSearchParams(formData.entries());
    fetch("restservices/auth" ,{method:"POST",body:encData})
        .then(response=Promise.all([response.status, response.json()]))
    .then(function ([status,myJson]) {
        if (status===404){
            document.querySelector("#ans").append("foute credentials")
        }

        if (status===200){
            if (myJson.naam==="winkel"){window.location.href=("menuwinkel.html")}
            if (myJson.naam==="klant"){window.location.href=("menuklant.html")}
        }
    }
    )

}
function addcustomer() {
    var formData=new FormData(document.querySelector("#register"));
    var encData=new URLSearchParams(formData.entries());
    fetch("restservices/register" ,{method:"PUT",body:encData})


    let name=document.getElementById("name").valueOf();
    let email = document.getElementById("email").valueof();
    let password = document.getElementById("password").valueOf();

}




