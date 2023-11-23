var subtotal = document.getElementById("subtotal").innerHTML;
var total = document.getElementById("totalJS").value;

var val1 = total / 1;
var val2 = total / 2;
var val3 = total / 3;
var val4 = total / 4;
var val5 = total / 5;
var val6 = total / 6;

console.log(total);

atualizaParcelas();
function atualizaParcelas() {
    document.getElementById("parflexRadioDefault1").innerHTML = `1x - ${val1}`;
    document.getElementById("parflexRadioDefault2").innerHTML = `2x - ${val2}`;
    document.getElementById("parflexRadioDefault3").innerHTML = `3x - ${val3}`;
    document.getElementById("parflexRadioDefault4").innerHTML = `4x - ${val4}`;
    document.getElementById("parflexRadioDefault5").innerHTML = `5x - ${val5}`;
    document.getElementById("parflexRadioDefault6").innerHTML = `6x - ${val6}`;
}

metodoFrete = document.getElementById("metodoFrete").value;

autoFrete();
function autoFrete() {
    console.log(metodoFrete);
    if (metodoFrete == "buscar") {
        atualizaFrete1();
    } else if (metodoFrete == "correios") {
        atualizaFrete2();
    } else if (metodoFrete == "fast") {
        atualizaFrete3();
    }
}

function atualizaFrete1() {
    document.getElementById("liFrete").innerHTML = `Frete: R$0,00`;
    document.getElementById("liTotal").innerHTML = `Total: R$${total}`;
}

function atualizaFrete2() {
    var value = parseFloat(total.replace(",", "."));
    var showTotal = value + 15;
    document.getElementById("liFrete").innerHTML = `Frete: R$15,00`;
    document.getElementById("liTotal").innerHTML = `Total: R$${showTotal}`;
}

function atualizaFrete3() {
    var value = parseFloat(total.replace(",", "."));
    var showTotal = value + 21;
    document.getElementById("liFrete").innerHTML = `Frete: R$21,00`;
    document.getElementById("liTotal").innerHTML = `Total: R$${showTotal}`;
}

var metodoPagamento;

function mudaPag1() {
    metodoPagamento = "pix";
    document.getElementById("metodoPagamento").value = "pix";
}

function mudaPag2() {
    metodoPagamento = "credito";
    document.getElementById("metodoPagamento").value = "credito";
}

function mudaPag3() {
    metodoPagamento = "debito";
    document.getElementById("metodoPagamento").value = "debito";
}

function mudaPag4() {
    metodoPagamento = "boleto";
    document.getElementById("metodoPagamento").value = "boleto";
}