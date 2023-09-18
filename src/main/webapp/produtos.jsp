<!DOCTYPE html>
<html lang="pt-BR">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" %>
    <head>
        <meta charset="UTF-8">
        <title>Menu</title>
        <link rel="stylesheet" href="css/reset.css">
        <link rel="stylesheet" href="css/produtos.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@300;500&display=swap" rel="stylesheet">
    </head>
    <body>
        <header class="container">

            <nav aria-label="breadcrumb">
              <ol class="breadcrumb">
                <li class="breadcrumb-item"><a href="principal.html">Menu</a></li>
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

            <div class="accordion" id="accordionExample">
              <div class="accordion-item">
                <c:forEach var="pr" items="${prs}">
                    <h2 class="accordion-header">
                      <button class="accordion-button" type="button" data-bs-toggle="collapse" data-bs-target="#collapse${pr.id}" aria-expanded="true" aria-controls="collapse${pr.id}">
                        <strong>${pr.nome}</strong>
                      </button>
                    </h2>

                    <div id="collapse${pr.id}" class="accordion-collapse collapse" data-bs-parent="#accordionExample">
                      <div class="accordion-body">
                        <p class="pItems">
                            Código: ${pr.id} &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
                            Quantidade: ${pr.qnt} &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
                            Valor: R$${pr.val} &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
                            Status: ${pr.status ? "Ativo" : "Inativo"}

                            <form action="/toUpdateProduct" method="get">
                                <input type="hidden" id="pr_ID" name="pr_ID" value="${pr.id}">
                                <button type="submit">Alterar</button>
                            </form>

                            <form action="/updateProductStatus" method="get">
                                <input type="hidden" id="pr_ID" name="pr_ID" value="${pr.id}">
                                <button type="submit">${pr.status ? "Desabilitar" : "Habilitar"}</button>
                            </form>
                      </div>
                    </div>
                </c:forEach>
              </div>
            </div>

            <p>${strTotal}</p>
        </header>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.min.js" integrity="sha384-Rx+T1VzGupg4BHQYs2gCW9It+akI2MM/mndMCy36UVfodzcJcF0GGLxZIzObiEfa" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
    </body>
</html>