document.getElementById("cancelar").onClick = limparCampos;

var email = document.getElementById("cl-email");
var senha = document.getElementById("cl-pass");

function limparCampos() {
    email.value = "";
    senha.value = "";
};