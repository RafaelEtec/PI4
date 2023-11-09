var bolNome = false;
var bolEmail = false;
var bolCpf = false;
var bolNasc = false;
var bolGenero = false;

var nomeSpan = document.getElementById("colNome");
var emailSpan = document.getElementById("colEmail");
var cpfSpan = document.getElementById("colCpf");
var nascSpan = document.getElementById("colNasc");
var generoSpan = document.getElementById("colGenero");

var nome = document.getElementById("nomeSpan").innerHTML;
var email = document.getElementById("emailSpan").innerHTML;
var cpf = document.getElementById("cpfSpan").innerHTML;
var nasc = document.getElementById("nascSpan").innerHTML;
var genero = document.getElementById("generoSpan").innerHTML;

function editNome() {
    if (bolNome == false) {
        nomeSpan.innerHTML = `<input maxlength="40" type="text" class="form-control" id="nome" name="nome" value="${nome}">`;
        bolNome = true;
    } else {
        nomeSpan.innerHTML = `<span id="nomeSpan" class="navbar-brand mb-0 h1">${nome}</span>`;
        bolNome = false;
    }
}

function editEmail() {
    if (bolEmail == false) {
        emailSpan.innerHTML = `<input maxlength="40" type="text" class="form-control" id="email" name="email" value="${email}">`;
        bolEmail = true;
    } else {
        emailSpan.innerHTML = `<span id="emailSpan" class="navbar-brand mb-0 h1">${email}</span>`;
        bolEmail = false;
    }
}

function editCpf() {
    if (bolCpf == false) {
        cpfSpan.innerHTML = `<input maxlength="11" type="text" class="form-control" id="cpf" name="cpf" value="${cpf}">`;
        bolCpf = true;
    } else {
        cpfSpan.innerHTML = `<span id="cpfSpan" class="navbar-brand mb-0 h1">${cpf}</span>`;
        bolCpf = false;
    }
}

function editNasc() {
    if (bolNasc == false) {
        nascSpan.innerHTML = `<input type="date" class="form-control" id="nasc" name="nasc" value="${nasc}">`;
        bolNasc = true;
    } else {
        nascSpan.innerHTML = `<span id="nascSpan" class="navbar-brand mb-0 h1">${nasc}</span>`;
        bolNasc = false;
    }
}

function editGenero() {
    if (bolGenero == false) {
        generoSpan.innerHTML = `<div class="form-check">
            <input class="form-check-input" value="HOMEM" type="radio" name="cl-genero" id="cl-generoM" checked>
            <label class="form-check-label" for="flexRadioDefault1">Homem</label>
        </div>
        <div class="form-check">
            <input class="form-check-input" value="MULHER" type="radio" name="cl-genero" id="cl-generoF">
            <label class="form-check-label" for="flexRadioDefault2">Mulher</label>
        </div>`;
        bolGenero = true;
    } else {
        generoSpan.innerHTML = `<span id="generoSpan" class="navbar-brand mb-0 h1">${genero}</span>`;
        bolGenero = false;
    }
}