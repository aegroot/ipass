function  test() {
    console.log('ok');
}
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
function filltable(dat,id){
    //test
/*
    for (var j = 0; j <10; j++) {
        row=table.insertRow(0)
        cell1=row.insertCell(0);
        cell2=row.insertCell(1);
        cell3=row.insertCell(2);
        cell4=row.insertCell(3);
       // row = document.createElement("tr");
        //textnode1 = document.createTextNode('o');
        //textnode2 = document.createTextNode('c');
        //textnode3 = document.createTextNode('l');
        //textnode4 = document.createTextNode('p');
        cell1.innerHTML="o";
        cell2.innerHTML="c";
        cell3.innerHTML="l";
        cell4.innerHTML="p";
        //table.append(row);
    }
 */
//init declaration
    let row;
    //let textnode1;
    //let textnode2;
    //let textnode3;
    //let textnode4;
    let cell1;
    let cell2;
    let cell3;
    let cell4;
    console.log(dat);
    var table=document.getElementById(id.toString());
    for (var i = 0; i < dat.length; i++) {
        //maakt een rij, koppelt er cellen aan,en vult het met data
        row=table.insertRow(-1)
        cell1=row.insertCell(0);
        cell2=row.insertCell(1);
        cell3=row.insertCell(2);
        cell4=row.insertCell(3);
        //row = document.createElement("tr");
       //textnode1 = document.createTextNode(data[i].omschrijving);
        //textnode2 = document.createTextNode(data[i].categorie);
       // textnode3 = document.createTextNode(data[i].landvherkomst);
       // textnode4 = document.createTextNode(data[i].prijs);
        cell1.innerHTML=dat[i].omschrijving.string
        cell2.innerHTML=dat[i].categorie.string;
        cell3.innerHTML=dat[i].landvherkomst.string;
        cell4.innerHTML=dat[i].prijs.string;
        table.append(row);
    }
        }

async function filltablewinkel() {
    var list = await fetch("restservices/winkel", {method: "GET"}).then(response => Promise.all([response.status, response.json()]))
        .then(function (data) {
            filltable(data,"winkel")})

}


async function filltableklant() {
    var list = await fetch("restservices/winkelwagen", {method: "GET"}).then(response => Promise.all([response.status, response.json()]))
        .then(function (data) {
            filltable(data[1],"klant");

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




