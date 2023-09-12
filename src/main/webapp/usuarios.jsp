<!DOCTYPE html>
<html lang="pt-BR">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" %>
    <head>
        <meta charset="UTF-8">
        <title>Menu</title>
        <link rel="stylesheet" href="css/reset.css">
        <link rel="stylesheet" href="css/usuarios.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@300;500&display=swap" rel="stylesheet">
    </head>
    <body>
        <header class="container">
            <nav class="navbar bg-body-tertiary">
              <form class="container-fluid" action="/searchUser" method="get">
                <div class="input-group">
                  <span class="input-group-text" id="basic-addon1">Nome</span>
                  <input type="text" class="form-control" name="nomeToSearch" id="nomeToSearch" aria-label="Nome" aria-describedby="basic-addon1">
                    <button id="search" class="btn btn-outline-success" type="submit">Procurar</button>
                    <a id="addUser" role="button" href="addUser.jsp" class="btn btn-outline" style="font-size: 1.4rem;">&nbsp&nbsp&nbsp+&nbsp&nbsp&nbsp</a>
                </div>
              </form>
            </nav>

            <table class="table table-striped">
                <thead>
                    <tr>
                        <th scope="col">Nome</th>
                        <th scope="col">E-mail</th>
                        <th scope="col">Status</th>
                        <th scope="col">Função</th>
                        <th scope="col">Alterar</th>
                        <th scope="col">Hab/Des</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="user" items="${users}">
                        <tr>
                            <td>${user.nome}</td>
                            <td>${user.email}</td>
                            <td>${user.status ? "Ativo" : "Inativo"}</td>
                            <td>${user.funcao}</td>

                            <form action="/toUpdate" method="get">
                                <input type="hidden" id="us_ID" name="us_ID" value="${user.id}">
                                <td><button type="submit">Alterar</button></td>
                            </form>

                            <form action="/updateStatus" method="post">
                                <input type="hidden" id="us_ID" name="us_ID" value="${user.id}">
                                <c:choose>
                                    <c:when test="${user.id == us.id}">
                                        <td><button class="disabled">Usuário logado</button></td>
                                    </c:when>
                                    <c:otherwise>
                                        <td><button type="submit">${user.status ? "Desabilitar" : "Habilitar"}</button></td>
                                    </c:otherwise>
                                </c:choose>
                            </form>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <p>${strTotal}</p>
        </header>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.min.js" integrity="sha384-Rx+T1VzGupg4BHQYs2gCW9It+akI2MM/mndMCy36UVfodzcJcF0GGLxZIzObiEfa" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
    </body>
</html>