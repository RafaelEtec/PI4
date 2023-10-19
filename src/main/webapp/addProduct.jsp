<!DOCTYPE html>
<html lang="pt-BR">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" %>
    <head>
        <meta charset="UTF-8">
        <title>Novo Produto</title>
        <link rel="stylesheet" href="css/reset.css">
        <link rel="stylesheet" href="css/addUser.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@300;500&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css">
    </head>
    <body>
        <header class="container">

            <nav aria-label="breadcrumb">
              <ol class="breadcrumb">
                <li class="breadcrumb-item"><a href="principal.jsp">Menu</a></li>
                <li class="breadcrumb-item"><a href="/listProducts">Lista de Produtos</a></li>
                <li class="breadcrumb-item active" aria-current="page">Cadastro de Produtos</li>
              </ol>
            </nav>

            <div class="card text-center">
                <div class="card-header">
                    Cadastro de Produto
                </div>
                <div class="card-body">
                    <form action="/addProduct" method="post" id="formAddProduct" enctype="multipart/form-data">
                        <input type="hidden" id="error" name="error" value="${error}">
                        <input type="hidden" id="gonna" name="gonna" value="${gonna}">
                        <input type="hidden" id="id" name="id" value="${us.id}">
                        <input type="hidden" id="pr-id" name="pr-id" value="${pr.id}">

                        <div class="row mb-4">
                            <label for="pr-nome" class="col-sm-2 col-form-label">Nome</label>
                            <div class="col-sm-10">
                                <input maxlength="200" type="text" class="form-control" id="pr-nome" name="pr-nome" value="${pr.nome}">
                            </div>
                        </div>

                        <div class="row mb-2">
                            <label for="pr-ava" class="col-sm-2 col-form-label">Avaliação</label>
                            <div class="col-sm-10">
                                <label for="customRange3" class="form-label" id="labelAva"></label>
                                <input value="${pr.ava}" id="pr-ava" name="pr-ava" type="range" class="form-range" min="1" max="5" step="0.5" oninput="updateAvaliacao(this.value);">
                            </div>
                        </div>

                        <div class="row mb-2">
                            <label for="pr-desc" class="col-sm-2 col-form-label">Descrição</label>
                            <div class="col-sm-10">
                                <input maxlength="2000" type="text" class="form-control" id="pr-desc" name="pr-desc" value="${pr.desc}">
                            </div>
                        </div>

                        <div class="row mb-2">
                            <label for="pr-val" class="col-sm-2 col-form-label">Preço</label>
                            <div class="col-sm-10">
                                <input type="number" class="form-control" id="pr-val" name="pr-val" value="${pr.val}">
                            </div>
                        </div>

                        <div class="row mb-3">
                            <label for="pr-qnt" class="col-sm-2 col-form-label">Quantidade</label>
                            <div class="col-sm-10">
                                <input type="number" class="form-control" id="pr-qnt" name="pr-qnt" value="${pr.qnt}">
                            </div>
                        </div>

                        <div class="row mb-3">
                            <label for="pr-img" class="col-sm-2 col-form-label">Imagem</label>
                            <div class="col-sm-10">
                                <input type="file" class="form-control" id="img" name="img">
                            </div>
                        </div>

                        <div id="inputTag" class="row mb-3">
                            <div id="divSelect" class="input-group mb-6">
                            <input type="hidden" id="pr-tag" name="pr-tag" value="${pr.tag}">
                              <label class="input-group-text" for="us-funcao">Função</label>
                              <select class="form-select" id="pr-tag" name="pr-tag" value="${pr.tag}">
                                <option value="${pr.tag}">${pr.tag}</option>
                                <option value="PIANO">Piano</option>
                                <option value="GUITARRA">Guitarra</option>
                                <option value="VIOLAO">Violão</option>
                                <option value="BATERIA">Bateria</option>
                                <option value="FLAUTA">Flauta</option>
                                <option value="SAXOFONE">Saxofone</option>
                                <option value="TROMBONE">Trombone</option>
                                <option value="BAIXO">Baixo</option>
                                <option value="VIOLINO">Violino</option>
                                <option value="GAITA">Gaita</option>
                                <option value="XILOFONE">Xilofone</option>
                                <option value="TRIANGULO">Triângulo</option>
                                <option value="TECLADO">Teclado</option>
                                <option value="PANDEIRO">Pandeiro</option>
                                <option value="CAVACO">Cavaco</option>
                                <option value="UKULELE">Ukulele</option>
                              </select>
                            </div>
                        </div>

                        <button onclick="checkCampos()" id="avancar" class="btn btn-primary" type="button">Avançar</button>
                        <a href="/listProducts" class="btn btn-secondary" id="Voltar">Voltar</a>

                        <div id="toastAlert" class="row"></div>
                        <div id="alert" class="row"></div>
                    </form>
                </div>
            </div>
        </header>
    <script src="js/produtos.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.min.js" integrity="sha384-Rx+T1VzGupg4BHQYs2gCW9It+akI2MM/mndMCy36UVfodzcJcF0GGLxZIzObiEfa" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
    </body>
</html>