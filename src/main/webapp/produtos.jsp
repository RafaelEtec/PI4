<!DOCTYPE html>
<html lang="pt-BR">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" %>
    <head>
        <meta charset="UTF-8">
        <title>Produtos do sistema</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="css/reset.css">
        <link rel="stylesheet" href="css/produtos.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@300;500&display=swap" rel="stylesheet">
    </head>
    <body>
        <header class="container">

            <nav aria-label="breadcrumb">
              <ol class="breadcrumb">
                <li class="breadcrumb-item"><a href="principal.jsp">Menu</a></li>
                <li class="breadcrumb-item active" aria-current="page">Lista de Produtos</li>
              </ol>
            </nav>

            <nav class="navbar bg-body-tertiary">
              <form class="container-fluid" action="/searchProduct" method="get">
                <div class="input-group">
                  <span class="input-group-text" id="basic-addon1">Nome</span>
                  <input type="text" class="form-control" name="nomeToSearch" id="nomeToSearch" aria-label="Nome" aria-describedby="basic-addon1">
                    <button id="search" class="btn btn-outline-success" type="submit">Procurar</button>
                    <a id="addProduct" role="button" href="addProduct.jsp" class="btn btn-outline" style="font-size: 1.4rem;">&nbsp&nbsp&nbsp+&nbsp&nbsp&nbsp</a>
                </div>
              </form>
            </nav>

            <table class="table table-striped">
                <thead>
                    <tr>
                        <th scope="col">Código</th>
                        <th scope="col">Nome</th>
                        <th scope="col">Categoria</th>
                        <th scope="col">Quantidade</th>
                        <th scope="col">Valor</th>
                        <th scope="col">Status</th>
                        <th scope="col">Alterar produto</th>
                        <th scope="col">Hab/Des</th>
                        <th scope="col">Prévia do produto</th>
                    </tr>
                </thead>

                <tbody>
                    <c:forEach var="pr" items="${prs}">
                        <tr>
                            <td>${pr.id}</td>
                            <td>${pr.nome}</td>
                            <td>${pr.tag}</td>
                            <td>${pr.qnt}</td>
                            <td>${pr.val}</td>
                            <td>${pr.status ? "Ativo" : "Inativo"}</td>

                            <td>
                                <div class="dropdown">
                                  <button class="dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false">
                                    Alterar
                                  </button>
                                  <ul class="dropdown-menu">
                                    <li class="container text-center">
                                    <div class="row">
                                    <div class="col">
                                        <form action="/toUpdateProductQnt" method="get">
                                            <input type="hidden" id="pr_ID" name="pr_ID" value="${pr.id}">
                                            <input class="small" type="number" id="pr_new_QNT" name="pr_new_QNT" value="${pr.qnt}">
                                        </div>
                                        <div class="col">
                                            <button type="submit">&nbspAlterar quantidade &nbsp</button>
                                        </form>
                                        </div>
                                        </div>
                                    </li>
                                    <hr>
                                    <li class="d-flex justify-content-center">
                                        <form action="/toUpdateProduct" method="get">
                                            <input type="hidden" id="pr_ID" name="pr_ID" value="${pr.id}">
                                            <button disabled type="submit">Alterar produto</button>
                                        </form>
                                    </li>
                                  </ul>
                                </div>
                            </td>

                            <form action="/updateProductStatus" method="post">
                                <input type="hidden" id="pr_ID" name="pr_ID" value="${pr.id}">
                                <td><button type="submit">${pr.status ? "Desabilitar" : "Habilitar"}</button></td>
                            </form>

                            <form action="/previaDoProduto" method="post">
                                <input type="hidden" id="pr_ID" name="pr_ID" value="${pr.id}">
                                <td><button type="submit">Visualizar</button></td>
                            </form>
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