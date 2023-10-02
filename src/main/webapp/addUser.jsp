<!DOCTYPE html>
<html lang="pt-BR">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" %>
    <head>
        <meta charset="UTF-8">
        <title>Novo Usuário</title>
        <link rel="stylesheet" href="css/reset.css">
        <link rel="stylesheet" href="css/addUser.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@300;500&display=swap" rel="stylesheet">
    </head>
    <body>
        <header class="container">

            <nav aria-label="breadcrumb">
              <ol class="breadcrumb">
                <li class="breadcrumb-item"><a href="principal.jsp">Menu</a></li>
                <li class="breadcrumb-item"><a href="/listUsers">Lista de Usuários</a></li>
                <li class="breadcrumb-item active" aria-current="page">Cadastro de Usuário</li>
              </ol>
            </nav>

            <div class="card text-center">
                <div class="card-header">
                    Cadastro de Usuário
                </div>
                <div class="card-body">
                    <form action="/addUser" method="post" id="formAddUser">
                        <input type="hidden" id="error" name="error" value="${error}">
                        <input type="hidden" id="gonna" name="gonna" value="${gonna}">
                        <input type="hidden" id="email" name="email" value="${usC.email}">
                        <input type="hidden" id="cpf" name="cpf" value="${usC.cpf}">
                        <input type="hidden" id="id" name="id" value="${usC.id}">
                        <input type="hidden" id="idC" name="idC" value="${us.id}">

                        <div class="row mb-2">
                            <label for="us-nome" class="col-sm-2 col-form-label">Nome</label>
                            <div class="col-sm-10">
                                <input maxlength="40" type="text" class="form-control" id="us-nome" name="us-nome" value="${usC.nome}">
                            </div>
                        </div>

                        <c:choose>
                            <c:when test="${gonna == 'UPDATE'}">
                                <div id="divEmail" class="row mb-2">
                                    <label for="us-email" class="col-sm-2 col-form-label">E-mail</label>
                                    <div class="col-sm-10">
                                        <input maxlength="40" type="text" class="form-control" disabled id="us-email" name="us-email" value="${usC.email}">
                                    </div>
                                </div>
                            </c:when>
                            <c:otherwise>
                                <div id="divEmail" class="row mb-2">
                                    <label for="us-email" class="col-sm-2 col-form-label">E-mail</label>
                                    <div class="col-sm-10">
                                        <input maxlength="40" type="text" class="form-control" id="us-email" name="us-email" value="${usC.email}">
                                    </div>
                                </div>
                            </c:otherwise>
                        </c:choose>

                        <div class="row mb-2">
                            <label for="us-cpf" class="col-sm-2 col-form-label">CPF</label>
                            <div class="col-sm-10">
                                <input minlength="11" maxlength="11" type="text" class="form-control" id="us-cpf" name="us-cpf" value="${usC.cpf}">
                            </div>
                        </div>

                        <c:choose>
                            <c:when test="${us.id == usC.id}">
                                <div id="inputFuncao" class="row mb-2">
                                    <div id="divSelect" class="input-group mb-6">
                                    <input type="hidden" id="us-funcao" name="us-funcao" value="${usC.funcao}">
                                      <label class="input-group-text" for="us-funcao">Função</label>
                                      <select disabled class="form-select" id="us-funcao" name="us-funcao" value="${usC.funcao}">
                                        <option value="${usC.funcao}">${usC.funcao}</option>
                                        <option value="USER">USUÁRIO</option>
                                        <option value="STOCKIST">ESTOQUISTA</option>
                                        <option value="ADMIN">ADMINISTRADOR</option>
                                      </select>
                                    </div>
                                </div>
                            </c:when>
                            <c:otherwise>
                                <div id="inputFuncao" class="row mb-2">
                                    <div id="divSelect" class="input-group mb-6">
                                      <label class="input-group-text" for="us-funcao">Função</label>
                                      <select class="form-select" id="us-funcao" name="us-funcao" value="${usC.funcao}">
                                        <c:choose>
                                            <c:when test="${usC.funcao == 'USER'}">
                                                <option value=""></option>
                                                <option selected value="USER">USUÁRIO</option>
                                                <option value="STOCKIST">ESTOQUISTA</option>
                                                <option value="ADMIN">ADMINISTRADOR</option>
                                            </c:when>
                                            <c:when test="${usC.funcao == 'STOCKIST'}">
                                                <option value=""></option>
                                                <option value="USER">USUÁRIO</option>
                                                <option selected value="STOCKIST">ESTOQUISTA</option>
                                                <option value="ADMIN">ADMINISTRADOR</option>
                                            </c:when>
                                            <c:when test="${usC.funcao == 'ADMIN'}">
                                                <option value=""></option>
                                                <option value="USER">USUÁRIO</option>
                                                <option value="STOCKIST">ESTOQUISTA</option>
                                                <option selected value="ADMIN">ADMINISTRADOR</option>
                                            </c:when>
                                            <c:otherwise>
                                            <option selected value=""></option>
                                            <option value="USER">USUÁRIO</option>
                                            <option value="STOCKIST">ESTOQUISTA</option>
                                            <option value="ADMIN">ADMINISTRADOR</option>
                                            </c:otherwise>
                                        </c:choose>
                                      </select>
                                    </div>
                                </div>
                            </c:otherwise>
                        </c:choose>

                        <div id="toastAlert" class="alert alert-warning" hidden role="alert"></div>
                        <div id="alert" class="row mb-2"></div>
                        <button hidden data-bs-target="#offcanvasWithBothOptions" aria-controls="offcanvasWithBothOptions" data-bs-toggle="offcanvas"></button>

                        <c:choose>
                            <c:when test="${gonna == 'UPDATE'}">
                                <c:choose>
                                    <c:when test="${us.id == usC.id}">
                                        <button onclick="checkCampos()" id="avancar" class="btn btn-primary" type="button">Avançar</button>
                                        <a href="/listUsers" class="btn btn-secondary" id="Voltar">Voltar</a>
                                    </c:when>
                                    <c:otherwise>
                                        <button onclick="checkUpdate()" id="updateUser" class="btn btn-primary" type="button">Avançar</button>
                                        <a href="/listUsers" class="btn btn-secondary" id="Voltar">Voltar</a>
                                    </c:otherwise>
                                </c:choose>
                            </c:when>
                            <c:otherwise>
                                <button onclick="checkCampos()" id="avancar" class="btn btn-primary" type="button">Avançar</button>
                                <a href="/listUsers" class="btn btn-secondary" id="Voltar">Voltar</a>
                            </c:otherwise>
                        </c:choose>

                        <div class="offcanvas offcanvas-start" data-bs-scroll="true" tabindex="-1" id="offcanvasWithBothOptions" aria-labelledby="offcanvasWithBothOptionsLabel">
                          <div class="offcanvas-header">
                            <h5 class="offcanvas-title" id="offcanvasWithBothOptionsLabel">Informe a senha do Usuário</h5>
                            <button type="button" class="btn-close" data-bs-dismiss="offcanvas" aria-label="Close"></button>
                          </div>
                          <div class="offcanvas-body">
                            <div class="row g-3 align-items-center">
                              <div class="col-auto">
                                <label for="us-pass" class="col-form-label">Senha</label>
                              </div>
                              <div class="col-auto">
                                <input type="password" minlength="8" maxlength="20" required id="us-pass" name="us-pass" class="form-control" aria-describedby="passwordHelpInline"  value="${usC.pass}">
                              </div>
                              <div class="col-auto">
                              </div><div class="row g-3 align-items-center">
                              <div class="col-auto">
                                <label for="us-passC" class="col-form-label">Confirme</label>
                              </div>
                              <div class="col-auto">
                                <input type="password" minlength="8" maxlength="20" required id="us-passC" class="form-control" aria-describedby="passwordHelpInline">
                              </div>
                              <div class="col-auto">
                                <span id="passwordHelpInline" class="form-text">
                                  Informe novamente a senha.
                                </span>
                              </div>
                            </div>
                            <button type="submit" id="enviar" class="btn btn-primary">Avançar</button>
                            <a onclick="limparCampos()" role="button" class="btn btn-secondary" id="cancelar">Cancelar</a>
                          </div>
                        </div>
                    </form>
                </div>
            </div>
        </header>
    <script src="js/senha.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.min.js" integrity="sha384-Rx+T1VzGupg4BHQYs2gCW9It+akI2MM/mndMCy36UVfodzcJcF0GGLxZIzObiEfa" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
    </body>
</html>