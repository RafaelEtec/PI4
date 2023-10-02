document.getElementById("cancelar").onClick = limparCampos;
var gonna = document.getElementById("gonna").value;
var id = document.getElementById("id").value;
var idC = document.getElementById("idC").value;
if (gonna != null) {
    if (gonna == "UPDATE" && id == idC) {
        document.getElementById("avancar").onClick = checkUpdate;
    } else if (gonna == "UPDATE") {
        document.getElementById("updateUser").onClick = checkUpdate;
    } else {
        document.getElementById("avancar").onClick = checkCampos;
    }
} else {
    document.getElementById("avancar").onClick = checkCampos;
}

var nome = document.getElementById("us-nome");
var email = document.getElementById("us-email");
var cpf = document.getElementById("us-cpf");
var funcao = document.getElementById("us-funcao");
var senha = document.getElementById("us-pass");
var senhaC = document.getElementById("us-passC");
var closeCanvas = document.querySelector('[data-bs-dismiss="offcanvas"]');
var openCanvas = document.querySelector('[data-bs-toggle="offcanvas"]');
var form = document.getElementById('formAddUser');

checkDupes();

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
    //} else if (TestaCPF(cpf)) {
     //   document.getElementById("alert").innerHTML = `<div class="alert alert-info" role="alert">
     //                                                  CPF Inválido
     //                                                </div>`;
     //   document.getElementById("us-cpf").focus();
    } else {
        document.getElementById("alert").innerHTML = `<div class="alert alert-info" hidden role="alert"></div>`;
        openCanvas.click();
    }
}

function TestaCPF(strCPF) {
    var Soma;
    var Resto;
    Soma = 0;
  if (strCPF == "00000000000") return false;

  for (i=1; i<=9; i++) Soma = Soma + parseInt(strCPF.substring(i-1, i)) * (11 - i);
  Resto = (Soma * 10) % 11;

    if ((Resto == 10) || (Resto == 11))  Resto = 0;
    if (Resto != parseInt(strCPF.substring(9, 10)) ) return false;

  Soma = 0;
    for (i = 1; i <= 10; i++) Soma = Soma + parseInt(strCPF.substring(i-1, i)) * (12 - i);
    Resto = (Soma * 10) % 11;

    if ((Resto == 10) || (Resto == 11))  Resto = 0;
    if (Resto != parseInt(strCPF.substring(10, 11) ) ) return false;
    return true;
}

function checkUpdate() {
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
        checkDupesUpdate();
    }
}

function checkDupesUpdate() {
    if (error != null) {
        if (error == "emailDupe") {
            console.log(error);
            document.getElementById("toastAlert").innerHTML = `<div class="alert alert-warning" role="alert">
                                                                O E-mail informado já foi cadastrado!
                                                               </div>`;
        } else if (error == "cpfDupe") {
            console.log(error);
            document.getElementById("toastAlert").innerHTML = `<div class="alert alert-warning" role="alert">
                                                                O CPF informado já foi cadastrado!
                                                               </div>`;
        } else if (error == "wrongPass") {
            document.getElementById("toastAlert").innerHTML = `<div class="alert alert-warning" role="alert">
                                                                Senha incorreta!
                                                               </div>`;
        } else if (error == "Erro não identificado") {
            document.getElementById("toastAlert").innerHTML = `<div class="alert alert-warning" role="alert">
                                                                Algo de errado não está certo!
                                                               </div>`;
        } else {
            document.getElementById("toastAlert").innerHTML = `<div class="alert alert-warning" hidden role="alert"></div>`;
            form.submit();
        }
    }
}

function checkDupes() {
    if (error != null) {
        if (error == "emailDupe") {
            console.log(error);
            document.getElementById("toastAlert").innerHTML = `<div class="alert alert-warning" role="alert">
                                                                O E-mail informado já foi cadastrado!
                                                               </div>`;
        } else if (error == "cpfDupe") {
            console.log(error);
            document.getElementById("toastAlert").innerHTML = `<div class="alert alert-warning" role="alert">
                                                                O CPF informado já foi cadastrado!
                                                               </div>`;
        } else if (error == "wrongPass") {
            document.getElementById("toastAlert").innerHTML = `<div class="alert alert-warning" role="alert">
                                                                Senha incorreta!
                                                               </div>`;
        } else if (error == "Erro não identificado") {
            document.getElementById("toastAlert").innerHTML = `<div class="alert alert-warning" role="alert">
                                                                Algo de errado não está certo!
                                                               </div>`;
        } else {
            document.getElementById("toastAlert").innerHTML = `<div class="alert alert-warning" hidden role="alert"></div>`;
        }
    }
}