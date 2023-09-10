document.getElementById("cancelar").onClick = limparCampos;

var email = document.getElementById("us-email");
var senha = document.getElementById("us-pass");

function limparCampos() {
    email.value = "";
    senha.value = "";
}