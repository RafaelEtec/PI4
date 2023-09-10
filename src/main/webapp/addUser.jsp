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
                    <form action="/addUser" method="get">
                        <div class="row mb-1">
                            <label for="us-nome" class="col-sm-2 col-form-label">Nome</label>
                            <div class="col-sm-10">
                                <input type="nome" class="form-control" id="us-nome" name="us-nome">
                            </div>
                        </div>
                        <div class="row mb-2">
                            <label for="us-email" class="col-sm-2 col-form-label">E-mail</label>
                            <div class="col-sm-10">
                                <input type="email" class="form-control" id="us-email" name="us-email">
                            </div>
                        </div>
                        <div class="row mb-3">
                            <label for="us-cpf" class="col-sm-2 col-form-label">CPF</label>
                            <div class="col-sm-10">
                                <input type="cpf" class="form-control" id="us-cpf" name="us-cpf">
                            </div>
                        </div>
                        <div class="row mb-4">
                            <div id="divSelect" class="input-group mb-6">
                              <label class="input-group-text" for="us-funcao">Função</label>
                              <select class="form-select" id="us-funcao" name="us-funcao">
                                <option value="USER">USUÁRIO</option>
                                <option value="STOCKIST">ESTOQUISTA</option>
                                <option value="ADMIN">ADMINISTRADOR</option>
                              </select>
                            </div>
                        </div>
                        <button class="btn btn-primary" type="button" data-bs-toggle="offcanvas" data-bs-target="#offcanvasWithBothOptions" aria-controls="offcanvasWithBothOptions">Avançar</button>

                        <div class="offcanvas offcanvas-start" data-bs-scroll="true" tabindex="-1" id="offcanvasWithBothOptions" aria-labelledby="offcanvasWithBothOptionsLabel">
                          <div class="offcanvas-header">
                            <h5 class="offcanvas-title" id="offcanvasWithBothOptionsLabel">Informe a senha do Usuário</h5>
                            <button type="button" class="btn-close" data-bs-dismiss="offcanvas" aria-label="Close"></button>
                          </div>
                          <div class="offcanvas-body">
                            <div class="row g-3 align-items-center">
                              <div class="col-auto">
                                <label for="inputPassword6" class="col-form-label">Senha</label>
                              </div>
                              <div class="col-auto">
                                <input type="password" minlength="8" maxlength="20" required id="inputPassword6" class="form-control" aria-describedby="passwordHelpInline">
                              </div>
                              <div class="col-auto">
                                <span id="passwordHelpInline" class="form-text">
                                  A senha deve conter de 8 à 20 caracteres.
                                </span>
                              </div><div class="row g-3 align-items-center">
                              <div class="col-auto">
                                <label for="inputPassword7" class="col-form-label">Confirme</label>
                              </div>
                              <div class="col-auto">
                                <input type="password" minlength="8" maxlength="20" required id="inputPassword7" class="form-control" aria-describedby="passwordHelpInline">
                              </div>
                              <div class="col-auto">
                                <span id="passwordHelpInline" class="form-text">
                                  Informe novamente a senha.
                                </span>
                              </div>
                            </div>
                            <button type="submit" id="enviar" class="btn btn-primary">Avançar</button>
                            <button onclick="limparCampos()" class="btn btn-secondary" id="cancelar">Cancelar</button>
                          </div>
                        </div>
                    </form>
                </div>
            </div>
        </header>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.min.js" integrity="sha384-Rx+T1VzGupg4BHQYs2gCW9It+akI2MM/mndMCy36UVfodzcJcF0GGLxZIzObiEfa" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
    </body>
</html>