atualizaAvaliacao();

function atualizaAvaliacao() {
    let ava = document.getElementById('pr-ava').value;
    let output = document.getElementById('labelAva');
    if (ava == 1) {
        output.innerHTML = `<i class="bi bi-star-fill"></i><i class="bi bi-star"></i><i class="bi bi-star"></i><i class="bi bi-star"></i><i class="bi bi-star"></i>`;
      } else if (ava == 1.5) {
        output.innerHTML = `<i class="bi bi-star-fill"><i class="bi bi-star-half"></i><i class="bi bi-star"></i><i class="bi bi-star"></i><i class="bi bi-star"></i></i>`;
      } else if (ava == 2) {
        output.innerHTML = `<i class="bi bi-star-fill"></i><i class="bi bi-star-fill"><i class="bi bi-star"></i><i class="bi bi-star"></i><i class="bi bi-star"></i></i>`;
      } else if (ava == 2.5) {
        output.innerHTML = `<i class="bi bi-star-fill"></i><i class="bi bi-star-fill"><i class="bi bi-star-half"></i><i class="bi bi-star"></i><i class="bi bi-star"></i></i>`;
      } else if (ava == 3) {
        output.innerHTML = `<i class="bi bi-star-fill"></i><i class="bi bi-star-fill"></i><i class="bi bi-star-fill"><i class="bi bi-star"></i><i class="bi bi-star"></i></i>`;
      } else if (ava == 3.5) {
        output.innerHTML = `<i class="bi bi-star-fill"></i><i class="bi bi-star-fill"></i><i class="bi bi-star-fill"><i class="bi bi-star-half"></i><i class="bi bi-star"></i></i>`;
      } else if (ava == 4) {
        output.innerHTML = `<i class="bi bi-star-fill"></i><i class="bi bi-star-fill"></i><i class="bi bi-star-fill"></i><i class="bi bi-star-fill"><i class="bi bi-star"></i></i>`;
      } else if (ava == 4.5) {
        output.innerHTML = `<i class="bi bi-star-fill"></i><i class="bi bi-star-fill"></i><i class="bi bi-star-fill"></i><i class="bi bi-star-fill"><i class="bi bi-star-half"></i></i>`;
      } else if (ava == 5) {
        output.innerHTML = `<i class="bi bi-star-fill"></i><i class="bi bi-star-fill"></i><i class="bi bi-star-fill"></i><i class="bi bi-star-fill"></i><i class="bi bi-star-fill"></i>`;
      } else if (ava == null) {
        output.innerHTML = `<i class="bi bi-star-fill"></i><i class="bi bi-star-fill"></i><i class="bi bi-star-fill"><i class="bi bi-star"></i><i class="bi bi-star"></i></i>`;
    }
}

function updateAvaliacao(ava) {
  let output = document.getElementById('labelAva');
  if (ava == 1) {
    output.innerHTML = `<i class="bi bi-star-fill"></i><i class="bi bi-star"></i><i class="bi bi-star"></i><i class="bi bi-star"></i><i class="bi bi-star"></i>`;
  } else if (ava == 1.5) {
    output.innerHTML = `<i class="bi bi-star-fill"><i class="bi bi-star-half"></i><i class="bi bi-star"></i><i class="bi bi-star"></i><i class="bi bi-star"></i></i>`
  } else if (ava == 2) {
    output.innerHTML = `<i class="bi bi-star-fill"></i><i class="bi bi-star-fill"><i class="bi bi-star"></i><i class="bi bi-star"></i><i class="bi bi-star"></i></i>`
  } else if (ava == 2.5) {
    output.innerHTML = `<i class="bi bi-star-fill"></i><i class="bi bi-star-fill"><i class="bi bi-star-half"></i><i class="bi bi-star"></i><i class="bi bi-star"></i></i>`
  } else if (ava == 3) {
    output.innerHTML = `<i class="bi bi-star-fill"></i><i class="bi bi-star-fill"></i><i class="bi bi-star-fill"><i class="bi bi-star"></i><i class="bi bi-star"></i></i>`
  } else if (ava == 3.5) {
    output.innerHTML = `<i class="bi bi-star-fill"></i><i class="bi bi-star-fill"></i><i class="bi bi-star-fill"><i class="bi bi-star-half"></i><i class="bi bi-star"></i></i>`
  } else if (ava == 4) {
    output.innerHTML = `<i class="bi bi-star-fill"></i><i class="bi bi-star-fill"></i><i class="bi bi-star-fill"></i><i class="bi bi-star-fill"><i class="bi bi-star"></i></i>`
  } else if (ava == 4.5) {
    output.innerHTML = `<i class="bi bi-star-fill"></i><i class="bi bi-star-fill"></i><i class="bi bi-star-fill"></i><i class="bi bi-star-fill"><i class="bi bi-star-half"></i></i>`
  } else if (ava == 5) {
    output.innerHTML = `<i class="bi bi-star-fill"></i><i class="bi bi-star-fill"></i><i class="bi bi-star-fill"></i><i class="bi bi-star-fill"></i><i class="bi bi-star-fill"></i>`
  }
}

var nome = document.getElementById("pr-nome");
var desc = document.getElementById("pr-desc");
var val = document.getElementById("pr-val");
var qnt = document.getElementById("pr-qnt");
var form = document.getElementById('formAddProduct');

function checkCampos() {
    if (nome.value == "") {
            document.getElementById("alert").innerHTML = `<div class="alert alert-info" role="alert">
                                                           Informe o Nome
                                                          </div>`;
            document.getElementById("pr-nome").focus();
        } else if (desc.value == "") {
            document.getElementById("alert").innerHTML = `<div class="alert alert-info" role="alert">
                                                           Informe a Descrição
                                                          </div>`;
            document.getElementById("pr-desc").focus();
        } else if (val.value == "") {
            document.getElementById("alert").innerHTML = `<div class="alert alert-info" role="alert">
                                                           Informe o Preço
                                                          </div>`;
            document.getElementById("pr-val").focus();
        } else if (qnt.value == "") {
            document.getElementById("alert").innerHTML = `<div class="alert alert-info" role="alert">
                                                           Informe a Quantidade
                                                          </div>`;
            document.getElementById("pr-qnt").focus();
        } else {
            document.getElementById("alert").innerHTML = `<div class="alert alert-info" hidden role="alert"></div>`;
            form.submit();
    }
}