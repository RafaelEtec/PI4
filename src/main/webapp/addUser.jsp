<!DOCTYPE html>
<html lang="pt-BR">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" %>
    <head>
        <meta charset="UTF-8">
        <title>Menu</title>
        <link rel="stylesheet" href="css/reset.css">
        <link rel="stylesheet" href="css/addUser.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@300;500&display=swap" rel="stylesheet">
    </head>
    <body>
        <header class="container">
            <div class="card text-center">
                <div class="card-header">
                    Cadastro de Usuário
                </div>
                <div class="card-body">
                    <form action="/login" method="get">
                        <div class="row mb-1">
                            <label for="us-email" class="col-sm-2 col-form-label">Nome</label>
                            <div class="col-sm-10">
                                <input type="email" class="form-control" id="us-email" name="us-email">
                            </div>
                        </div>
                        <div class="row mb-2">
                            <label for="us-email" class="col-sm-2 col-form-label">E-mail</label>
                            <div class="col-sm-10">
                                <input type="email" class="form-control" id="us-email" name="us-email">
                            </div>
                        </div>
                        <div class="row mb-3">
                            <label for="us-email" class="col-sm-2 col-form-label">CPF</label>
                            <div class="col-sm-10">
                                <input type="email" class="form-control" id="us-email" name="us-email">
                            </div>
                        </div>
                        <div class="row mb-4">
                            <div id="divSelect" class="input-group mb-6">
                              <label class="input-group-text" for="inputGroupSelect01">Função</label>
                              <select class="form-select" id="inputGroupSelect01">
                                <option value="USER">USUÁRIO</option>
                                <option value="STOCKIST">ESTOQUISTA</option>
                                <option value="ADMIN">ADMINISTRADOR</option>
                              </select>
                            </div>
                        </div>
                        <button type="submit" id="enviar" class="btn btn-primary">Avançar</button>
                        <button onclick="limparCampos()" class="btn btn-secondary" id="cancelar">Cancelar</button>
                    </form>
                </div>
            </div>
        </header>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.min.js" integrity="sha384-Rx+T1VzGupg4BHQYs2gCW9It+akI2MM/mndMCy36UVfodzcJcF0GGLxZIzObiEfa" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
    </body>
</html>