<!DOCTYPE html>
<html lang="pt-BR">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" %>
    <head>
        <meta charset="UTF-8">
        <title>Pedidos do sistema</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="css/reset.css">
        <link rel="stylesheet" href="css/produtos.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@300;500&display=swap" rel="stylesheet">
    </head>
    <body>
        <input type="hidden" id="gonna" name="gonna" value="inspect">

        <header class="container">

            <nav aria-label="breadcrumb">
              <ol class="breadcrumb">
                <li class="breadcrumb-item"><a href="principal.jsp">Menu</a></li>
                <li class="breadcrumb-item active" aria-current="page">Lista de Pedidos</li>
              </ol>
            </nav>

            <nav class="navbar bg-body-tertiary">
              <form class="container-fluid" action="/searchPedido" method="get">
                <div class="input-group">
                  <span class="input-group-text" id="basic-addon1">Nome</span>
                  <input type="text" class="form-control" name="nomeToSearch" id="nomeToSearch" aria-label="Nome" aria-describedby="basic-addon1">
                    <button id="search" class="btn btn-outline-success" type="submit">Procurar</button>
                </div>
              </form>
            </nav>

            <table class="table table-striped">
                <thead>
                    <tr>
                        <th scope="col">Pedido</th>
                        <th scope="col">Cliente</th>
                        <th scope="col">Val. total</th>
                        <th scope="col">Qnt. itens</th>
                        <th scope="col">Endereço</th>
                        <th scope="col">Frete</th>
                        <th scope="col">Pagamento</th>
                        <th scope="col">Status</th>
                    </tr>
                </thead>

                <tbody>
                    <c:forEach var="pe" items="${pes}">
                        <tr>
                            <td>${pe.id}</td>
                            <td>${pe.cl_id}</td>
                            <td>${pe.total}</td>
                            <td>${pe.qnt}</td>
                            <td>${pe.endereco}</td>
                            <td>${pe.frete}</td>
                            <td>${pe.pagamento}</td>
                            <td>${pe.status}</td>

                            <td>
                                <div class="dropdown">
                                  <button class="dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false">
                                    Alterar Status
                                  </button>
                                  <ul class="dropdown-menu">
                                    <li class="container text-center">
                                    <div class="row">
                                    <div class="col">
                                        <form action="/toUpdatePedidoStatus" method="get">
                                            <input type="hidden" name="pe_new_ID" id="pe_new_ID" value="${pe.id}">
                                            <select name="pe-stt" id="pe-stt">
                                                <option value=""></option>
                                                <option value="Aguardando pagamento">Aguardando pagamento</option>
                                                <option value="Pagamento rejeitado">Pagamento rejeitado</option>
                                                <option value="Pagamento com sucesso">Pagamento com sucesso</option>
                                                <option value="Aguardando retirada">Aguardando retirada</option>
                                                <option value="Em transito">Em transito</option>
                                                <option value="Entregue">Entregue</option>
                                            </select>
                                        </div>
                                        <div class="col">
                                            <button type="submit">&nbspAlterar &nbsp</button>
                                        </form>
                                        </div>
                                        </div>
                                    </li>
                                    <hr>
                                  </ul>
                                </div>
                            </td>
                            <td>
                                <div class="dropdown">
                                  <button class="dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false">
                                    Visualizar Produtos
                                  </button>
                                </div>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <p>${strTotal}</p>

        </header>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js" integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
    </body>
</html>