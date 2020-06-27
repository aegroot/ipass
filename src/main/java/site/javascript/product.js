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
        }}

        //wordt meerdere keren gebruikt
function filltable(data){
    const table=document.querySelector("table")
    //init declaration
    let row;
    let textnode1;
    let textnode2;
    let textnode3;
    let textnode4;
    let cell1;
    let cell2;
    let cell3;
    let cell4;
    for (var i = 0; i < data.length; i++) {
        //maakt een rij, koppelt er cellen aan,en vult het met data
        row=table.insertRow()
        cell1=row.insertCell(0);
        cell2=row.insertCell(1);
        cell3=row.insertCell(2);
        cell4=row.insertCell(3);
        row = document.createElement("tr");
        textnode1 = document.createTextNode(data[i].omschrijving);
        textnode2 = document.createTextNode(data[i].categorie);
        textnode3 = document.createTextNode(data[i].landvherkomst);
        textnode4 = document.createTextNode(data[i].prijs);
        cell1.innerHTML=key.omschrijving;
        cell2.innerHTML=key.categorie;
        cell3.innerHTML=key.landvherkomst;
        cell4.innerHTML=key.prijs;
        table.append(row);
    }
        }





async function filltablewinkel() {
    var list = await fetch("restervices/winkel", {method: "GET"}).then(response => Promise.all([response.status, response.json()]))
        .then(function (data) {
            filltable(data)})

}
async function filltableklant() {
    var list = await fetch("restervices/winkelwagen", {method: "GET"}).then(response => Promise.all([response.status, response.json()]))
        .then(function (data) {
            filltable(data)

        })
}



function validate() {
    const formData = new FormData(document.querySelector("#auth"));
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
    })

}

function addCustomer() {
    const formData = new FormData(document.querySelector("#register"));
    const encData = new URLSearchParams(formData.entries());
    fetch("restservices/register" ,{method:"PUT",body:encData})
}




