const toBase64 = file => new Promise((resolve, reject) => {
    if (file === undefined) resolve("");

    const reader = new FileReader();
    reader.readAsDataURL(file);
    reader.addEventListener("load", () => resolve(reader.result));
    reader.addEventListener("error", error => reject(error));
});


function  test() {
    console.log('ok');
}
/*
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

 */

        //wordt meerdere keren gebruikt
function filltable(dat,id){
    console.log("klant")
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


     let cell1=document.createElement("td");
    let cell2=document.createElement("td");
    let cell3=document.createElement("td");
     let cell4=document.createElement("td");
    let cell5=document.createElement("td");
    let button;
    console.log(dat);
    var table=document.querySelector("tbody");
   // var data=document.createElement("tbody");
    for (var i = 0; i < dat.length; i++) {
        //maakt een rij, koppelt er cellen aan,en vult het met data
       // row=document.createElement("tr");
        row=table.insertRow();
        /*
       cell1=row.insertCell(0);
       cell2=row.insertCell(1);
       cell3=row.insertCell(2);
       cell4=row.insertCell(3);
       //row = document.createElement("tr");
      //textnode1 = document.createTextNode(data[i].omschrijving);
       //textnode2 = document.createTextNode(data[i].categorie);
      // textnode3 = document.createTextNode(data[i].landvherkomst);
      // textnode4 = document.createTextNode(data[i].prijs);

       /*
       (id === "winkel"){
           button=document.createElement("button");
           cell5=row.insertCell(4);
           button.addEventListener("click", addToCart(dat[i].id))
           //onclick(addToCart(dat[i].id));
           button.innerHTML="voegtoe"
           console.log("winkel")
       }
*/
         if (id === "klant"){
            button=document.createElement("button");
            cell5=row.insertCell(-1);
            button.addEventListener("click",removeFromCart(dat[i].id) )
            //onclick(removeFromCart(dat[i].id));
            button.textContent="haal weg"
             console.log("klant")
        }

        cell1.textContent=dat[i]["omschrijving"].string
        cell2.textContent=dat[i]["categorie"].string;
        cell3.textContent=dat[i]["landvherkomst"].string;
        cell4.textContent=dat[i]["prijs"].string;
        row.appendChild(cell1);
        row.appendChild(cell2);
        row.appendChild(cell3);
        row.appendChild(cell4);
        row.appendChild(cell4);
        table.append(row);
    }
    //table.innerHTML=data;
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
async function removeFromCart(id) {
    await fetch("restservices/winkelwagen"+id, {method: "DELETE"}).then(response => Promise.all([response.status]))


}
async function addToCart(id) {
    await fetch("restservices/winkelwagen"+id, {method: "PUT"}).then(response => Promise.all([response.status]))
        .then(function (status){
        if(status.ok){console.log('succes')}
        if(status === 304){console.log('error')}
    })
}

async function getbudget() {
    await fetch("restservices/budget", {method: "GET"}).then(response => Promise.all([response.status, response.json()]))
        .then(function (data) {
            const budget=data[1].budget;
            var paragraphElement=document.querySelector("p");
            paragraphElement.innerText=budget;
        })

}
async function rekenAf() {
    await fetch("restservices/rekenaf", {method: "POST"}).then(response => Promise.all([response.status]))
        .then(function (status){
            if(status.ok){console.log('succes')}
            if(status.error()){console.log('error')
            }
        }
            )
}

async function checkLogin() {
    await fetch("restservices/checklogin", {method: "POST"}).then(response => Promise.all([response.status]))
        .then(function (status) {
                if (status.ok) {
                    console.log('succes')
                }
                if (status.error()) {
                    console.log('error')
                }
            }
        )
}

async function validate() {
    var formData = new FormData(document.querySelector("#auth"));
    var encData = new URLSearchParams(formData.entries());
    await fetch("restservices/auth", {method: "POST", body: encData})
         .then(response=Promise.all([response.status, response.json()]))
        .then(function ([data]) {
            if (data[0] === 404) {
                document.querySelector("#ans").innerHTML("foute credentials")
            }
            if (data[0] === 200) {
                if (data[1].naam === "winkel") {
                    window.location.href = ("menuwinkel.html")
                }
                if (data[1].naam === "klant") {
                    window.location.href = ("menuklant.html")
                }
            }
        })
}
function addCustomer() {
    const formData = new FormData(document.querySelector("#register"));
    const encData = new URLSearchParams(formData.entries());
    fetch("restservices/register" ,{method:"PUT",body:encData})
}




