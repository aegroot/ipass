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

async function filltable() {
    const list = await fetch("restervices/winkel", {method: "GET"}).then(response => Promise.all([response.status, response.json()])).then(function (data) {
        let textnode1;
        let textnode2;
        let textnode4;
        let textnode3;
        let cell1;
        let cell2;
        let cell3;
        let cell4;
        let products = data.results;
        return products.map(function (obj) {
            row = document.createElement("tr");
            cell1 = document.createElement("td");
            cell2 = document.createElement("td");
            cell3 = document.createElement("td");
            cell4 = document.createElement("td");

            textnode1 = document.createTextNode(obj.omschrijving.toString);
            textnode2 = document.createTextNode(obj.categorie.toString);
            textnode3 = document.createTextNode(obj.landvherkomst.toString);
            textnode4 = document.createTextNode(obj.prijs.toString);

            cell1.appendChild(textnode1);
            cell2.appendChild(textnode2);
            cell3.appendChild(textnode3);
            cell4.appendChild(textnode4);
            row.appendChild(cell1);
            row.appendChild(cell2);
            document.querySelector("#tablewinkel").append(row);
        })


    })
}



async function filltablewinkel() {
    var list = await fetch("restervices/winkel", {method: "GET"}).then(response => Promise.all([response.status, response.json()]))
        .then(function (data) {
            let textnode1;
            let textnode2;
            let textnode4;
            let textnode3;
            let cell1;
            let cell2;
            let cell3;
            let cell4;
            let products = data.results;
            return products.map(function (obj) {
                row = document.createElement("tr");
                cell1 = document.createElement("td");
                cell2 = document.createElement("td");
                cell3 = document.createElement("td");
                cell4 = document.createElement("td");

                textnode1 = document.createTextNode(obj.omschrijving.toString);
                textnode2 = document.createTextNode(obj.categorie.toString);
                textnode3 = document.createTextNode(obj.landvherkomst.toString);
                textnode4 = document.createTextNode(obj.prijs.toString);

                cell1.appendChild(textnode1);
                cell2.appendChild(textnode2);
                cell3.appendChild(textnode3);
                cell4.appendChild(textnode4);
                row.appendChild(cell1);
                row.appendChild(cell2);
                document.querySelector("#tablewinkel").append(row);
            })



        })

}
async function filltableklant() {
    var list = await fetch("restervices/winkelwagen", {method: "GET"}).then(response => Promise.all([response.status, response.json()]))
        .then(function (data) {
        let textnode1;
        let textnode2;
        let textnode4;
        let textnode3;
        let cell1;
        let cell2;
        let cell3;
        let cell4;
        let products = data.results;
        return products.map(function (obj) {
            row = document.createElement("tr");
            cell1 = document.createElement("td");
            cell2 = document.createElement("td");
            cell3 = document.createElement("td");
            cell4 = document.createElement("td");

            textnode1 = document.createTextNode(obj.omschrijving.toString);
            textnode2 = document.createTextNode(obj.categorie.toString);
            textnode3 = document.createTextNode(obj.landvherkomst.toString);
            textnode4 = document.createTextNode(obj.prijs.toString);

            cell1.appendChild(textnode1);
            cell2.appendChild(textnode2);
            cell3.appendChild(textnode3);
            cell4.appendChild(textnode4);
            row.appendChild(cell1);
            row.appendChild(cell2);
            document.querySelector("#tablewinkel").append(row);
        })
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




