document.getElementById("cancelar").onClick = limparCampos;

var email = document.getElementById("cl-email");
var senha = document.getElementById("cl-pass");

function limparCampos() {
    email.value = "";
    senha.value = "";
}

const toastTrigger = document.getElementById('liveToastBtn')
const toastLiveExample = document.getElementById('liveToast')
document.getElementById("mostraToast").onClick = mostraToast;
function mostraToast () {
if (toastTrigger) {
  const toastBootstrap = bootstrap.Toast.getOrCreateInstance(toastLiveExample)
  toastTrigger.addEventListener('click', () => {
  console.log("Toast")
    toastBootstrap.show()
  })
}
}