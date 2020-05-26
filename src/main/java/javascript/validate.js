

function account(naam,password,acces){

    this.naam=naam;
    this.password=password;
    this.acces=acces;

    toArray=function(){
        return [naam,password];
    }

    const toBase64 = file => new Promise((resolve, reject) => {
        if (file === undefined) resolve("");

        const reader = new FileReader();
        reader.readAsDataURL(file);
        reader.addEventListener("load", () => resolve(reader.result));
        reader.addEventListener("error", error => reject(error));
    });
}

function validate() {
    let email = document.getElementById("email").valueof();
    let password = document.getElementById("password").valueOf();

}
function addcustomer() {
    let email = document.getElementById("email").valueof();
    let password = document.getElementById("password").valueOf();

}




