checkError();

function checkError() {
    var error = document.getElementById("error").value;

    if (error != null) {
        if (error == "notAnAdmin") {
            console.log(error);
            document.getElementById("toastAlert").innerHTML = `<div class="alert alert-warning" role="alert">
                                                                Você não possui permissão para acessar essa área!
                                                               </div>`;
        } else if (error == "notUp") {
            console.log(error);
            document.getElementById("toastAlert").innerHTML = `<div class="alert alert-warning" role="alert">
                                                                O Usuário não está ativo no sistema!
                                                               </div>`;
        } else if (error == "notFound") {
            document.getElementById("toastAlert").innerHTML = `<div class="alert alert-warning" role="alert">
                                                                Informações incorretas!
                                                               </div>`;
        } else if (error == "missingSpaces") {
            document.getElementById("toastAlert").innerHTML = `<div class="alert alert-warning" role="alert">
                                                                Informações faltantes!
                                                               </div>`;
        } else {
            document.getElementById("toastAlert").innerHTML = `<div class="alert alert-warning" hidden role="alert"></div>`;
        }
    }
}