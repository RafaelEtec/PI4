document.getElementById("cancelar").onClick = limparCampos;
document.getElementById("enviar").onClick = verificaCampos;

var email = document.getElementById("us-email");
var senha = document.getElementById("us-pass");

function limparCampos() {
    email.value = "";
    senha.value = "";
    console.log("Campos limpados");
}

function verificaCampos() {
    if (email.value == "") {
        console.log("Email");
    } else if (senha.value == "") {
        console.log("Senha");
    } else if (email.value == "" && senha.value == "") {
        console.log("Email e Senha");
    }
}