<!DOCTYPE html>
<html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" %>
    <head>
        <meta charset="UTF-8">
        <title>Menu</title>
        <link rel="stylesheet" href="css/reset.css">
        <link rel="stylesheet" href="css/principal.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@300;500&display=swap" rel="stylesheet">
    </head>
    <body>
    <header class="container">
        <nav aria-label="breadcrumb">
            <ol class="breadcrumb">
                <li class="breadcrumb-item active" aria-current="page">Home</li>
            </ol>
        </nav>
        <div class="card text-center">
        <div class="card" style="width: auto;">
            <div class="card-header">
                Principal
            </div>
            <ul class="list-group list-group-flush">
                <form action="/listProducts" method="get">
                    <li class="list-group-item"><button class="btn btn-primary" method="submit">Listar Produtos</button></li>
                </form>

                <c:choose>
                    <c:when test="${us.funcao == 'ADMIN'}">
                        <form action="/listUsers" method="get">
                            <li class="list-group-item"><button class="btn btn-primary" method="submit">Listar Usuários</button></li>
                        </form>
                    </c:when>
                    <c:otherwise>
                        <form action="/listUsers" method="get">
                            <li class="list-group-item"><button disabled class="btn btn-primary" method="submit">Listar Usuários</button></li>
                        </form>
                    </c:otherwise>
                </c:choose>
                <form action="/listPedidos" method="get">
                    <li class="list-group-item"><button class="btn btn-primary" method="submit">Listar Pedidos</button></li>
                </form>
            </ul>
        </div>
        </div>
    </header>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.min.js" integrity="sha384-Rx+T1VzGupg4BHQYs2gCW9It+akI2MM/mndMCy36UVfodzcJcF0GGLxZIzObiEfa" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
    </body>
</html>