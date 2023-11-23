var metodoFrete = document.getElementById("metodoFrete").value;
var metodoPagamento = document.getElementById("metodoPagamento").value;
var subtotal = document.getElementById("subtotal").innerHTML;
var total = document.getElementById("totalJS").value;

autoFrete();
function autoFrete() {
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