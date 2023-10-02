<!DOCTYPE html>
<html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" %>
    <head>
        <title>Disciplina Musical</title>
        <meta charset="UTF-8">
        <link rel="stylesheet" href="css/index.css">
        <link rel="stylesheet" href="css/reset.css">
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@300;500&display=swap" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css2?family=Oswald:wght@600&display=swap" rel="stylesheet">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css">
    </head>
    <body class="fundo">
        <input type="hidden" id="error" name="error" value="${error}">

        <nav class="navbar body-tertiary">
          <div class="container-fluid">
            <a id="tittleDis" class="navbar-brand" href="/Disciplina-Musical">
              &nbsp<i class="bi bi-music-note-beamed"></i> &nbsp
              Disciplina Musical
            </a>

            <div class="modal fade" id="modalLogin" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
              <div class="modal-dialog">
                <div class="modal-content">
                  <div class="modal-header">
                    <h1 class="modal-title fs-5" id="exampleModalLabel">Login</h1>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                  </div>
                  <div class="modal-body">
                    <!-- Inputs -->
                  </div>
                  <div class="modal-footer">
                    <!-- Botões -->
                  </div>
                </div>
              </div>
            </div>

            <div class="modal fade" id="modalCriar" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
              <div class="modal-dialog">
                <div class="modal-content">
                  <div class="modal-header">
                    <h1 class="modal-title fs-5" id="exampleModalLabel">Criar Conta</h1>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                  </div>
                  <div class="modal-body">
                    <!-- Inputs -->
                  </div>
                  <div class="modal-footer">
                    <!-- Botões -->
                  </div>
                </div>
              </div>
            </div>

            <div class="dropdown">
              <button type="button" class="btn dropdown-toggle" data-bs-toggle="dropdown" data-bs-auto-close="outside" aria-expanded="false">
                <i class="bi bi-person-fill"></i>
              </button>

              <form class="dropdown-menu p-1">
                  <div class="d-grid gap-2">
                    <button type="button" class="btn btn-secondary" data-bs-toggle="modal" data-bs-target="#modalLogin">
                      Login
                    </button>
                    <button type="button" class="btn btn-secondary" data-bs-toggle="modal" data-bs-target="#modalCriar">
                      Criar conta
                    </button>
                  </div>
              </form>
            </div>

            <button class="btn navbar-brand" data-bs-toggle="offcanvas" data-bs-target="#offcanvasRight" aria-controls="offcanvasRight">
              <i class="bi bi-cart"></i>
            </button>
            <div class="offcanvas offcanvas-end" tabindex="-1" id="offcanvasRight" aria-labelledby="offcanvasRightLabel">
              <div class="offcanvas-header">
                <h5 class="offcanvas-title" id="offcanvasRightLabel">Carrinho</h5>
                <button type="button" class="btn-close" data-bs-dismiss="offcanvas" aria-label="Close"></button>
              </div>
              <div class="offcanvas-body">
                <!-- Conteúdo do OffCanvas -->
              </div>
            </div>
          </div>
        </nav>

        <header class="container">
            <div style="width: 100%; height: 100px;">
                <div class="row">
                  <div class="col-sm-8 mb-0 mb-sm-0">
                    <nav class="navbar body-tertiary">
                      <div class="container-fluid">
                        <span class="navbar-brand mb-0 h1">${pr.nome}</span>
                      </div>
                    </nav>

                      <div class="col-sm-4 mb-3 mb-sm-0">
                        <div class="card mb-3">
                          <div id="carouselExampleAutoplaying1" class="carousel slide" data-bs-ride="carousel">
                            <div class="carousel-inner">
                              <div class="carousel-item active">
                                <c:choose>
                                  <c:when test="${pr.img != null}">
                                    <img src="img/${pr.img}" class="d-block w-100" style="width:400px;height:400px" alt="${pr.desc}">
                                  </c:when>
                                  <c:otherwise>
                                    <img src="img/mus.jpg" class="d-block w-100" style="width:400px;height:400px" alt="${pr.desc}">
                                  </c:otherwise>
                                </c:choose>
                              </div>
                            </div>

                          </div>
                          <div class="card-body text-center">
                            <h5 class="card-title">R$${pr.val}</h5>
                          </div>
                        </div>
                      </div>
                  </div>

                  <div class="col-sm-10 mb-10 mb-sm-10">
                      <h2>${pr.desc}</h2>
                    <div class="card-body text-center">
                      <h5 class="card-title"></h5>
                    </div>
                  </div>
                </div>
            </div>
        </header>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js" integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
    </body>
</html>