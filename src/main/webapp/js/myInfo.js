var bolNome = false;
var bolEmail = false;
var bolCpf = false;
var bolNasc = false;
var bolGenero = false;

var nome = document.getElementById("nomeSpan").innerHTML;
var email = document.getElementById("emailSpan").innerHTML;
var cpf = document.getElementById("cpfSpan").innerHTML;
var nasc = document.getElementById("nascSpan").innerHTML;
var genero = document.getElementById("generoSpan").innerHTML;

var nomeForm = document.getElementById("updateNomeForm");
var emailForm = document.getElementById("updateEmailForm");
var cpfForm = document.getElementById("updateCpfForm");
var nascForm = document.getElementById("updateNascForm");
var generoForm = document.getElementById("updateGeneroForm");

var nomeSpan = document.getElementById("colNome");
var emailSpan = document.getElementById("colEmail");
var cpfSpan = document.getElementById("colCpf");
var nascSpan = document.getElementById("colNasc");
var generoSpan = document.getElementById("colGenero");


function editNome() {
    if (bolNome == false) {
        nomeSpan.innerHTML = `<input maxlength="40" type="text" class="form-control" id="nomeInput" name="nome" value="${nome}">`;
        document.getElementById("nomeBtn").innerHTML = `<i class="bi bi-check-square"></i>`;
        bolNome = true;
    } else {
        if (nome == document.getElementById("nomeInput").value) {
            nomeSpan.innerHTML = `<span id="nomeSpan" class="navbar-brand mb-0 h1">${nome}</span>`;
            document.getElementById("nomeBtn").innerHTML = `<i class="bi bi-pencil-square"></i>`;
            bolNome = false;
        } else {
            nomeForm.submit();
        }
    }
}

function editEmail() {
    if (bolEmail == false) {
        emailSpan.innerHTML = `<input maxlength="40" type="text" class="form-control" id="emailInput" name="email" value="${email}">`;
        document.getElementById("emailBtn").innerHTML = `<i class="bi bi-check-square"></i>`;
        bolEmail = true;
    } else {
        emailSpan.innerHTML = `<span id="emailSpan" class="navbar-brand mb-0 h1">${email}</span>`;
        document.getElementById("emailBtn").innerHTML = `<i class="bi bi-pencil-square"></i>`;
        bolEmail = false;
    }
}

function editCpf() {
    if (bolCpf == false) {
        cpfSpan.innerHTML = `<input maxlength="11" type="text" class="form-control" id="cpfInput" name="cpf" value="${cpf}">`;
        document.getElementById("cpfBtn").innerHTML = `<i class="bi bi-check-square"></i>`;
        bolCpf = true;
    } else {
        cpfSpan.innerHTML = `<span id="cpfSpan" class="navbar-brand mb-0 h1">${cpf}</span>`;
        document.getElementById("cpfBtn").innerHTML = `<i class="bi bi-pencil-square"></i>`;
        bolCpf = false;
    }
}

function editNasc() {
    if (bolNasc == false) {
        nascSpan.innerHTML = `<input type="date" class="form-control" id="nasc" name="nascInput" value="${nasc}">`;
        document.getElementById("nascBtn").innerHTML = `<i class="bi bi-check-square"></i>`;
        bolNasc = true;
    } else {
        nascSpan.innerHTML = `<span id="nascSpan" class="navbar-brand mb-0 h1">${nasc}</span>`;
        document.getElementById("nascBtn").innerHTML = `<i class="bi bi-pencil-square"></i>`;
        bolNasc = false;
    }
}

function editGenero() {
    if (bolGenero == false) {
        generoSpan.innerHTML = `<div class="form-check">
            <input class="form-check-input" value="HOMEM" type="radio" name="cl-genero" id="cl-generoMInput" checked>
            <label class="form-check-label" for="flexRadioDefault1">Homem</label>
        </div>
        <div class="form-check">
            <input class="form-check-input" value="MULHER" type="radio" name="cl-genero" id="cl-generoFInput">
            <label class="form-check-label" for="flexRadioDefault2">Mulher</label>
        </div>`;
        document.getElementById("generoBtn").innerHTML = `<i class="bi bi-check-square"></i>`;
        bolGenero = true;
    } else {
        generoSpan.innerHTML = `<span id="generoSpan" class="navbar-brand mb-0 h1">${genero}</span>`;
        document.getElementById("generoBtn").innerHTML = `<i class="bi bi-pencil-square"></i>`;
        bolGenero = false;
    }
}