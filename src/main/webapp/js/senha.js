document.getElementById("cancelar").onClick = limparCampos;
document.getElementById("avancar").onClick = checkCampos;

var nome = document.getElementById("us-nome");
var email = document.getElementById("us-email");
var cpf = document.getElementById("us-cpf");
var funcao = document.getElementById("us-funcao");
var senha = document.getElementById("us-pass");
var senhaC = document.getElementById("us-passC");
var closeCanvas = document.querySelector('[data-bs-dismiss="offcanvas"]');
var openCanvas = document.querySelector('[data-bs-toggle="offcanvas"]');
var form = document.getElementById('formAddUser');

if (form.attachEvent) {
    form.attachEvent("submit", processForm);
} else {
    form.addEventListener("submit", processForm);
}

function processForm(e) {
    if (e.preventDefault) e.preventDefault();
    if (checkSenha()) {
        form.submit();
    }
    return false;
}

function limparCampos() {
    senha.value = "";
    senhaC.value = "";
    closeCanvas.click();
}

function checkSenha() {
    if (senha.value != "" && senhaC.value != "") {
        if ((senha.value.length >= 8 && senha.value.length <= 20) || (senhaC.value.length >= 8 && senhaC.value.length <= 20)) {
            if (senha.value == senhaC.value) {
                return true;
            } else {
                            document.getElementById("passwordHelpInline").innerHTML = `<div class="alert alert-info" role="alert">
                                                                                        As senhas não se coincidem!
                                                                                       </div>`;
            }
        } else {
                            document.getElementById("passwordHelpInline").innerHTML = `<div class="alert alert-info" role="alert">
                                                                                        A senha deve conter de 8 à 20 caracteres!
                                                                                       </div>`;
        }
    } else {
        document.getElementById("passwordHelpInline").innerHTML = `<div class="alert alert-info" role="alert">
                                                                     Preencha ambos os campos de senha!
                                                                   </div>`;
    }
    return false;
}

function checkCampos() {
    if (nome.value == "") {
        document.getElementById("alert").innerHTML = `<div class="alert alert-info" role="alert">
                                                       Informe o Nome
                                                      </div>`;
        document.getElementById("us-nome").focus();
    } else if (email.value == "") {
        document.getElementById("alert").innerHTML = `<div class="alert alert-info" role="alert">
                                                       Informe o E-mail
                                                      </div>`;
        document.getElementById("us-email").focus();
    } else if (cpf.value == "") {
        document.getElementById("alert").innerHTML = `<div class="alert alert-info" role="alert">
                                                       Informe o CPF
                                                      </div>`;
        document.getElementById("us-cpf").focus();
    } else if (funcao.value == "") {
        document.getElementById("alert").innerHTML = `<div class="alert alert-info" role="alert">
                                                       Informe a função
                                                      </div>`;
        document.getElementById("us-funcao").focus();
    } else {
        document.getElementById("alert").innerHTML = `<div class="alert alert-info" hidden role="alert"></div>`;
        document.getElementById("avancar").focus();
        openCanvas.click();
    }
}