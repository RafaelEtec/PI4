document.getElementById("cancelar").onClick = limparCampos;

var email = document.getElementById("cl-email");
var senha = document.getElementById("cl-pass");
var canva = document.querySelector('[data-bs-target="#modalLogin"]');

function limparCampos() {
    email.value = "";
    senha.value = "";
};

function openLogin() {
    canva.click();
}