<!DOCTYPE html>
<html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" %>
    <head>
        <meta charset="UTF-8">
        <title>Login</title>
        <link rel="stylesheet" href="css/reset.css">
        <link rel="stylesheet" href="css/login.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@300;500&display=swap" rel="stylesheet">
    </head>
    <body>
    <header class="container">
        <div class="card text-center">
            <div class="card-header">
                Login de Usuário
            </div>
            <div class="card-body">
                <form action="/login" method="get">
                    <input type="hidden" id="error" name="error" value="${error}">
                    <div class="row mb-3">
                        <div id="alertaEmail"></div><br>
                        <label for="us-email" class="col-sm-2 col-form-label">Usuário:</label>
                        <div class="col-sm-10">
                            <input maxlength="40" type="email" class="form-control" id="us-email" name="us-email">
                        </div>
                    </div>
                    <div class="row mb-3">
                        <div id="alertaSenha"></div><br>
                        <label for="us-pass" class="col-sm-2 col-form-label">Senha:</label>
                        <div class="col-sm-10">
                            <input maxlength="20" type="password" class="form-control" id="us-pass" name="us-pass">
                        </div>
                    </div>
                    <button type="submit" id="enviar" class="btn btn-primary">OK</button>
                    <button onclick="limparCampos()" class="btn btn-secondary" id="cancelar">Cancelar</button>
                    <div id="toastAlert" class="row mb-3"></div>
                </form>
            </div>
        </div>
        </header>
        <script src="js/error.js"></script>
        <script src="js/login.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.min.js" integrity="sha384-Rx+T1VzGupg4BHQYs2gCW9It+akI2MM/mndMCy36UVfodzcJcF0GGLxZIzObiEfa" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
    </body>
</html>