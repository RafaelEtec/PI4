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

document.getElementById("toastbtn").onclick = function() {
    var toastElList = [].slice.call(document.querySelectorAll('.toast'))
    var toastList = toastElList.map(function(toastEl) {
      return new bootstrap.Toast(toastEl)
    });
   toastList.forEach(toast => toast.show());
    console.log(toastList);
  };