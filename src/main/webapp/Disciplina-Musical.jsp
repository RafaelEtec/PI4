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
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css">
    </head>

    <body class="fundo">
        <input type="hidden" id="error" name="error" value="${error}">
        <input type="hidden" id="sessionStatus" name="sessionStatus" value="${sessionStatus}">
        <input type="hidden" id="gonna" name="gonna" value="buy">

        <nav class="navbar body-tertiary">
            <div class="container-fluid">
                <a id="tittleDis" class="navbar-brand" href="/Disciplina-Musical">
                    &nbsp<i class="bi bi-music-note-beamed"></i> &nbsp
                    Disciplina Musical
                </a>

                <div class="modal fade" id="modalLogin" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                    <form action="/loginCli" method="get" id="loginCliForm">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h1 class="modal-title fs-5" id="exampleModalLabel">Login</h1>
                                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                </div>
                                <div class="modal-body">
                                    <input type="hidden" id="error" name="error" value="${error}">
                                    <div class="row mb-3">
                                        <div id="alertaEmail"></div>
                                        <br>
                                        <label for="cl-email" class="col-sm-2 col-form-label">Usuário:</label>
                                        <div class="col-sm-10">
                                            <input maxlength="40" type="email" class="form-control" id="cl-email"
                                                   name="cl-email">
                                        </div>
                                    </div>
                                    <div class="row mb-3">
                                        <div id="alertaSenha"></div>
                                        <br>
                                        <label for="cl-pass" class="col-sm-2 col-form-label">Senha:</label>
                                        <div class="col-sm-10">
                                            <input maxlength="20" type="password" class="form-control" id="cl-pass"
                                                   name="cl-pass">
                                        </div>
                                    </div>
                                </div>
                                <div class="modal-footer">
                                    <!-- Botões -->
                                    <button type="submit" id="enviar" class="btn btn-primary">OK</button>
                                    <button onclick="limparCampos()" type="button" class="btn btn-secondary" id="cancelar">
                                        Cancelar
                                    </button>
                                    <div id="toastAlert" class="row mb-3"></div>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>

                <div class="modal fade" id="modalCriar" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                    <form action="/addClient" method="post" id="addClientForm">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h1 class="modal-title fs-5" id="exampleModalLabel">Criar Conta</h1>
                                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                </div>

                                <div class="modal-body">
                                    <div class="row mb-2">
                                        <label for="cl-nome" class="col-sm-2 col-form-label">Nome</label>
                                        <div class="col-sm-10">
                                            <input maxlength="40" type="text" class="form-control" id="cl-nome" name="cl-nome" value="${cl.nome}">
                                        </div>
                                    </div>

                                    <div class="row mb-2">
                                        <label for="cl-emailC" class="col-sm-2 col-form-label">E-mail</label>
                                        <div class="col-sm-10">
                                            <input maxlength="40" type="text" class="form-control" id="cl-emailC" name="cl-emailC" value="${cl.email}">
                                        </div>
                                    </div>

                                    <div class="row mb-2">
                                        <label for="cl-cpf" class="col-sm-2 col-form-label">CPF</label>
                                        <div class="col-sm-10">
                                            <input minlength="11" maxlength="11" type="text" class="form-control" id="cl-cpf" name="cl-cpf" value="${cl.cpf}">
                                        </div>
                                    </div>

                                    <div class="row mb-2">
                                        <label for="cl-nasc" class="col-sm-2 col-form-label">Data de nascimento</label>
                                        <div class="col-sm-10">
                                            <input type="date" class="form-control" id="cl-nasc" name="cl-nasc" value="${cl.nasc}">
                                        </div>
                                    </div>

                                    <div class="row mb-2">
                                        <div class="form-check">
                                            <input class="form-check-input" value="HOMEM" type="radio" name="cl-genero" id="cl-generoM" checked>
                                            <label class="form-check-label" for="flexRadioDefault1">Homem</label>
                                        </div>
                                        <div class="form-check">
                                            <input class="form-check-input" value="MULHER" type="radio" name="cl-genero" id="cl-generoF">
                                            <label class="form-check-label" for="flexRadioDefault2">Mulher</label>
                                        </div>
                                    </div>

                                    <hr>
                                    <h1 class="modal-title fs-5" id="exampleModalLabel">Senha</h1>
                                    <hr>

                                    <div class="row g-3 align-items-center">
                                        <div class="col-auto">
                                            <label for="cl-passCria" class="col-form-label">Senha&nbsp&nbsp&nbsp&nbsp&nbsp</label>
                                            <input type="password" minlength="8" maxlength="20" required id="cl-passCria" name="cl-passCria" class="form-control" aria-describedby="passwordHelpInline">
                                        </div>
                                    </div>

                                    <div class="row g-3 align-items-center">
                                        <div class="col-auto">
                                            <label for="cl-passC" class="col-form-label">Confirme</label>
                                            <input type="password" minlength="8" name="cl-passC" maxlength="20" required id="cl-passC" class="form-control" aria-describedby="passwordHelpInline">
                                        </div>
                                        <span id="passwordHelpInline" class="form-text">Informe novamente a senha.</span>
                                    </div>

                                    <hr>
                                    <h1 class="modal-title fs-5" id="exampleModalLabel">Endereço de Faturamento</h1>
                                    <hr>

                                    <div class="row mb-2">
                                        <label for="f-cep" class="col-sm-2 col-form-label">CEP</label>
                                        <div class="col-sm-10">
                                            <input maxlength="8" type="number" class="form-control" id="f-cep" name="f-cep">
                                        </div>
                                    </div>

                                    <div class="row mb-2">
                                        <label for="f-log" class="col-sm-2 col-form-label">Logradouro</label>
                                        <div class="col-sm-10">
                                            <input maxlength="40" type="text" class="form-control" id="f-log" name="f-log"">
                                        </div>
                                    </div>

                                    <div class="row mb-2">
                                        <label for="f-num" class="col-sm-2 col-form-label">Número</label>
                                        <div class="col-sm-10">
                                            <input maxlength="4" type="number" class="form-control" id="f-num" name="f-num">
                                        </div>
                                    </div>

                                    <div class="row mb-2">
                                        <label for="f-com" class="col-sm-2 col-form-label">Complemento</label>
                                        <div class="col-sm-10">
                                            <input maxlength="40" type="text" class="form-control" id="f-com" name="f-com">
                                        </div>
                                    </div>

                                    <div class="row mb-2">
                                        <label for="f-est" class="col-sm-2 col-form-label">Estado</label>
                                        <div class="col-sm-10">
                                            <select name="f-est" id="f-est">
                                                <option value="">Selecione</option>
                                                <option value="AC">Acre</option>
                                                <option value="AL">Alagoas</option>
                                                <option value="AP">Amapa</option>
                                                <option value="AM">Amazonas</option>
                                                <option value="BA">Bahia</option>
                                                <option value="CE">Ceara</option>
                                                <option value="DF">Distrito Federal</option>
                                                <option value="ES">Espirito Santo</option>
                                                <option value="GO">Goias</option>
                                                <option value="MA">Maranhao</option>
                                                <option value="MT">Mato Grosso</option>
                                                <option value="MS">Mato Grosso do Sul</option>
                                                <option value="MG">Minas Gerais</option>
                                                <option value="PA">Para</option>
                                                <option value="PB">Paraiba</option>
                                                <option value="PR">Parana</option>
                                                <option value="PE">Pernambuco</option>
                                                <option value="PI">Piaui</option>
                                                <option value="RJ">Rio de Janeiro</option>
                                                <option value="RN">Rio Grande do Norte</option>
                                                <option value="RS">Rio Grande do Sul</option>
                                                <option value="RO">Rondonia</option>
                                                <option value="RR">Roraima</option>
                                                <option value="SC">Santa Catarina</option>
                                                <option value="SP">Sao Paulo</option>
                                                <option value="SE">Sergipe</option>
                                                <option value="TO">Tocantins</option>
                                            </select>
                                        </div>
                                    </div>

                                    <div class="row mb-2">
                                        <label for="f-cid" class="col-sm-2 col-form-label">Cidade</label>
                                        <div class="col-sm-10">
                                            <input maxlength="40" type="text" class="form-control" id="f-cid" name="f-cid">
                                        </div>
                                    </div>

                                    <hr>
                                    <h1 class="modal-title fs-5" id="exampleModalLabel">Endereço de Entrega</h1>
                                    <hr>

                                    <div class="row mb-2">
                                        <label for="e-cep" class="col-sm-2 col-form-label">CEP</label>
                                        <div class="col-sm-10">
                                            <input maxlength="8" type="number" class="form-control" id="e-cep" name="e-cep">
                                        </div>
                                    </div>

                                    <div class="row mb-2">
                                        <label for="e-log" class="col-sm-2 col-form-label">Logradouro</label>
                                        <div class="col-sm-10">
                                            <input maxlength="40" type="text" class="form-control" id="e-log" name="e-log"">
                                        </div>
                                    </div>

                                    <div class="row mb-2">
                                        <label for="e-num" class="col-sm-2 col-form-label">Número</label>
                                        <div class="col-sm-10">
                                            <input maxlength="4" type="number" class="form-control" id="e-num" name="e-num">
                                        </div>
                                    </div>

                                    <div class="row mb-2">
                                        <label for="e-com" class="col-sm-2 col-form-label">Complemento</label>
                                        <div class="col-sm-10">
                                            <input maxlength="40" type="text" class="form-control" id="e-com" name="e-com">
                                        </div>
                                    </div>

                                    <div class="row mb-2">
                                        <label for="e-est" class="col-sm-2 col-form-label">Estado</label>
                                        <div class="col-sm-10">
                                            <select name="e-est" id="e-est">
                                                <option value="">Selecione</option>
                                                <option value="AC">Acre</option>
                                                <option value="AL">Alagoas</option>
                                                <option value="AP">Amapa</option>
                                                <option value="AM">Amazonas</option>
                                                <option value="BA">Bahia</option>
                                                <option value="CE">Ceara</option>
                                                <option value="DF">Distrito Federal</option>
                                                <option value="ES">Espirito Santo</option>
                                                <option value="GO">Goias</option>
                                                <option value="MA">Maranhao</option>
                                                <option value="MT">Mato Grosso</option>
                                                <option value="MS">Mato Grosso do Sul</option>
                                                <option value="MG">Minas Gerais</option>
                                                <option value="PA">Para</option>
                                                <option value="PB">Paraiba</option>
                                                <option value="PR">Parana</option>
                                                <option value="PE">Pernambuco</option>
                                                <option value="PI">Piaui</option>
                                                <option value="RJ">Rio de Janeiro</option>
                                                <option value="RN">Rio Grande do Norte</option>
                                                <option value="RS">Rio Grande do Sul</option>
                                                <option value="RO">Rondonia</option>
                                                <option value="RR">Roraima</option>
                                                <option value="SC">Santa Catarina</option>
                                                <option value="SP">Sao Paulo</option>
                                                <option value="SE">Sergipe</option>
                                                <option value="TO">Tocantins</option>
                                            </select>
                                        </div>
                                    </div>

                                    <div class="row mb-2">
                                        <label for="e-cid" class="col-sm-2 col-form-label">Cidade</label>
                                        <div class="col-sm-10">
                                            <input maxlength="40" type="text" class="form-control" id="e-cid" name="e-cid">
                                        </div>
                                    </div>

                                </div>
                                    <div class="modal-footer">
                                        <button type="submit" id="enviarC" class="btn btn-primary">OK</button>
                                        <button onclick="limparCamposCriar()" type="button" class="btn btn-secondary"
                                        id="cancelarC">Cancelar
                                        </button>
                                    <div id="toastAlert" class="row mb-3"></div>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>

                <c:choose>
                    <c:when test="${sessionStatus == 'naologado'}">
                        <div class="dropdown">
                            <button type="button" class="btn dropdown-toggle" data-bs-toggle="dropdown"
                                    data-bs-auto-close="outside" aria-expanded="false">
                                <i class="bi bi-person-fill"></i>
                            </button>

                            <div class="dropdown-menu p-1">
                                <div class="d-grid gap-2">
                                    <button type="button" class="btn btn-secondary" data-bs-toggle="modal"
                                            data-bs-target="#modalLogin">
                                        Login
                                    </button>
                                    <button type="button" class="btn btn-secondary" data-bs-toggle="modal"
                                            data-bs-target="#modalCriar">
                                        Criar conta
                                    </button>
                                </div>
                            </div>
                        </div>
                    </c:when>
                    <c:otherwise>
                        <div class="dropdown">
                            <button type="button" class="btn dropdown-toggle" data-bs-toggle="dropdown"
                                    data-bs-auto-close="outside" aria-expanded="false">
                                <i class="bi bi-person-fill"></i>
                            </button>

                            <div class="dropdown-menu p-1">
                                <div class="d-grid gap-2">
                                    <form action="/myInfo" method="get" id="myInfoForm">
                                        <button type="submit" class="btn btn-secondary">
                                            &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbspMeus dados  &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
                                        </button>
                                    </form>

                                    <form action="/Logoff" method="get" id="logoffCliForm">
                                        <button type="submit" class="btn btn-secondary text-center" data-bs-toggle="modal"data-bs-target="#modal">
                                            &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbspLogoff&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
                                        </button>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </c:otherwise>
                </c:choose>

                <button class="btn navbar-brand" data-bs-toggle="offcanvas" data-bs-target="#offcanvasRight" aria-controls="offcanvasRight">
                    <i class="bi bi-cart"></i>
                </button>
                <div class="offcanvas offcanvas-end" tabindex="-1" id="offcanvasRight" aria-labelledby="offcanvasRightLabel">
                    <div class="offcanvas-header">
                        <h5 class="offcanvas-title" id="offcanvasRightLabel">Carrinho</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="offcanvas" aria-label="Close"></button>
                    </div>
                    <div class="offcanvas-body">
                        <c:choose>
                            <c:when test="${carrinho.size() == 0}">
                                <h1>${txtCar}</h1>
                            </c:when>
                            <c:otherwise>
                                <c:forEach var="prCar" items="${carrinho}">
                                    <div class="card mb-3" style="max-width: auto;">
                                      <div class="row g-0">
                                        <div class="card">
                                          <div class="card-header d-flex justify-content-between">
                                            <p>${prCar.nome}</p>
                                            <ul class="nav nav-pills">
                                              <button type="button" class="btn">
                                                <i class="bi bi-trash3"></i>
                                              </button>
                                            </ul>
                                          </div>
                                          <div class="card-body">
                                            <blockquote class="blockquote mb-0">
                                              <p>${prCar.desc}</p>
                                              <footer class="blockquote-footer">${prCar.val}</footer>
                                            </blockquote>
                                          </div>
                                        </div>
                                      </div>
                                    </div>
                                </c:forEach>
                            </c:otherwise>
                        </c:choose>
                    </div>
                    <hr>
                    <div class="modal-footer d-flex justify-content-evenly">
                        <c:choose>
                        <c:when test="${carrinho.size() == 0}">
                            <button type="button" disabled class="btn btn-secondary" data-bs-dismiss="modal">Esvaziar carrinho</button>
                            <button type="button" disabled class="btn btn-primary">Finalizar</button>
                        </c:when>
                        <c:otherwise>
                        <form action="/limparCarrinhoIndex" method="get" id="limparCarrinhoForm">
                            <button type="submit" class="btn btn-secondary" data-bs-dismiss="modal">Esvaziar carrinho</button>
                        </form>
                            ${total}
                            <button type="button" class="btn btn-primary">Finalizar</button>
                        </c:otherwise>
                        </c:choose>
                    </div>
                    <hr>
                </div>
            </div>
        </nav>

        <header class="container">
            <div style="width: 100%; height: 100px;">
                <div class="row">

                    <nav class="navbar body-tertiary">
                        <div class="container-fluid">
                            <span class="navbar-brand mb-0 h1">Principais escolhas</span>
                        </div>
                    </nav>

                    <div class="col-sm-3 mb-3 mb-sm-0">
                        <div class="card mb-3">
                            <div id="carouselExampleAutoplaying1" class="carousel slide" data-bs-ride="carousel">
                                <div class="carousel-inner">
                                    <c:forEach var="piano" items="${pianos}">
                                        <div class="carousel-item active">
                                            <form action="/showProduct" method="get">
                                                <input type="hidden" id="pr-id" name="pr-id" value="${piano.id}">
                                                <button type="submit">
                                                    <p class="pNomes">${piano.nome}</p>
                                                    <c:choose>
                                                        <c:when test="${piano.img != null}">
                                                            <img src="img/${piano.img}" class="d-block w-100"
                                                                 style="width:400px;height:400px" alt="${piano.desc}">
                                                        </c:when>
                                                        <c:otherwise>
                                                            <img src="img/mus.jpg" class="d-block w-100"
                                                                 style="width:400px;height:400px" alt="${piano.desc}">
                                                        </c:otherwise>
                                                    </c:choose>
                                                </button>
                                            </form>
                                        </div>
                                    </c:forEach>
                                </div>

                                <button class="carousel-control-prev" type="button"
                                        data-bs-target="#carouselExampleAutoplaying1" data-bs-slide="prev">
                                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                                    <span class="visually-hidden">Previous</span>
                                </button>
                                <button class="carousel-control-next" type="button"
                                        data-bs-target="#carouselExampleAutoplaying1" data-bs-slide="next">
                                    <span class="carousel-control-next-icon" aria-hidden="true"></span>
                                    <span class="visually-hidden">Next</span>
                                </button>

                            </div>
                            <div class="card-body text-center">
                                <h5 class="card-title">Pianos</h5>
                            </div>
                        </div>
                    </div>

                    <div class="col-sm-2 mb-3 mb-sm-0">
                        <div class="card mb-3">
                            <div id="carouselExampleAutoplaying2" class="carousel slide" data-bs-ride="carousel">
                                <div class="carousel-inner">
                                    <c:forEach var="guitarra" items="${guitarras}">
                                        <div class="carousel-item active">
                                            <form action="/showProduct" method="get">
                                                <input type="hidden" id="pr-id" name="pr-id" value="${guitarra.id}">
                                                <button type="submit">
                                                    <p class="pNomes">${guitarra.nome}</p>
                                                    <c:choose>
                                                        <c:when test="${guitarra.img != null}">
                                                            <img src="img/${guitarra.img}" class="d-block w-100"
                                                                 style="width:400px;height:200px" alt="${guitarra.desc}">
                                                        </c:when>
                                                        <c:otherwise>
                                                            <img src="img/mus.jpg" class="d-block w-100"
                                                                 style="width:400px;height:200px" alt="${guitarra.desc}">
                                                        </c:otherwise>
                                                    </c:choose>
                                                </button>
                                            </form>
                                        </div>
                                    </c:forEach>
                                </div>

                                <button class="carousel-control-prev" type="button"
                                        data-bs-target="#carouselExampleAutoplaying2" data-bs-slide="prev">
                                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                                    <span class="visually-hidden">Previous</span>
                                </button>
                                <button class="carousel-control-next" type="button"
                                        data-bs-target="#carouselExampleAutoplaying2" data-bs-slide="next">
                                    <span class="carousel-control-next-icon" aria-hidden="true"></span>
                                    <span class="visually-hidden">Next</span>
                                </button>

                            </div>
                            <div class="card-body text-center">
                                <h5 class="card-title">Guitarras</h5>
                            </div>
                        </div>
                    </div>

                    <div class="col-sm-2 mb-3 mb-sm-0">
                        <div class="card mb-3">
                            <div id="carouselExampleAutoplaying3" class="carousel slide" data-bs-ride="carousel">
                                <div class="carousel-inner">
                                    <c:forEach var="flauta" items="${flautas}">
                                        <div class="carousel-item active">
                                            <form action="/showProduct" method="get">
                                                <input type="hidden" id="pr-id" name="pr-id" value="${flauta.id}">
                                                <button type="submit">
                                                    <p class="pNomes">${flauta.nome}</p>
                                                    <c:choose>
                                                        <c:when test="${flauta.img != null}">
                                                            <img src="img/${flauta.img}" class="d-block w-100"
                                                                 style="width:400px;height:200px" alt="${flauta.desc}">
                                                        </c:when>
                                                        <c:otherwise>
                                                            <img src="img/mus.jpg" class="d-block w-100"
                                                                 style="width:400px;height:200px" alt="${flauta.desc}">
                                                        </c:otherwise>
                                                    </c:choose>
                                                </button>
                                            </form>
                                        </div>
                                    </c:forEach>
                                </div>

                                <button class="carousel-control-prev" type="button"
                                        data-bs-target="#carouselExampleAutoplaying3" data-bs-slide="prev">
                                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                                    <span class="visually-hidden">Previous</span>
                                </button>
                                <button class="carousel-control-next" type="button"
                                        data-bs-target="#carouselExampleAutoplaying3" data-bs-slide="next">
                                    <span class="carousel-control-next-icon" aria-hidden="true"></span>
                                    <span class="visually-hidden">Next</span>
                                </button>

                            </div>
                            <div class="card-body text-center">
                                <h5 class="card-title">Flautas</h5>
                            </div>
                        </div>
                    </div>

                    <div class="col-sm-2 mb-3 mb-sm-0">
                        <div class="card mb-3">
                            <div id="carouselExampleAutoplaying4" class="carousel slide" data-bs-ride="carousel">
                                <div class="carousel-inner">
                                    <c:forEach var="violao" items="${violoes}">
                                        <div class="carousel-item active">
                                            <form action="/showProduct" method="get">
                                                <input type="hidden" id="pr-id" name="pr-id" value="${violao.id}">
                                                <button type="submit">
                                                    <p class="pNomes">${violao.nome}</p>
                                                    <c:choose>
                                                        <c:when test="${violao.img != null}">
                                                            <img src="img/${violao.img}" class="d-block w-100"
                                                                 style="width:400px;height:200px" alt="${violao.desc}">
                                                        </c:when>
                                                        <c:otherwise>
                                                            <img src="img/mus.jpg" class="d-block w-100"
                                                                 style="width:400px;height:200px" alt="${violao.desc}">
                                                        </c:otherwise>
                                                    </c:choose>
                                                </button>
                                            </form>
                                        </div>
                                    </c:forEach>
                                </div>

                                <button class="carousel-control-prev" type="button"
                                        data-bs-target="#carouselExampleAutoplaying4" data-bs-slide="prev">
                                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                                    <span class="visually-hidden">Previous</span>
                                </button>
                                <button class="carousel-control-next" type="button"
                                        data-bs-target="#carouselExampleAutoplaying4" data-bs-slide="next">
                                    <span class="carousel-control-next-icon" aria-hidden="true"></span>
                                    <span class="visually-hidden">Next</span>
                                </button>

                            </div>
                            <div class="card-body text-center">
                                <h5 class="card-title">Violões</h5>
                            </div>
                        </div>
                    </div>

                    <div class="col-sm-2 mb-3 mb-sm-0">
                        <div class="card mb-3">
                            <div id="carouselExampleAutoplaying5" class="carousel slide" data-bs-ride="carousel">
                                <div class="carousel-inner">
                                    <c:forEach var="saxofone" items="${saxofones}">
                                        <div class="carousel-item active">
                                            <form action="/showProduct" method="get">
                                                <input type="hidden" id="pr-id" name="pr-id" value="${saxofone.id}">
                                                <button type="submit">
                                                    <p class="pNomes">${saxofone.nome}</p>
                                                    <c:choose>
                                                        <c:when test="${saxofone.img != null}">
                                                            <img src="img/${saxofone.img}" class="d-block w-100"
                                                                 style="width:400px;height:200px" alt="${saxofone.desc}">
                                                        </c:when>
                                                        <c:otherwise>
                                                            <img src="img/mus.jpg" class="d-block w-100"
                                                                 style="width:400px;height:200px" alt="${saxofone.desc}">
                                                        </c:otherwise>
                                                    </c:choose>
                                                </button>
                                            </form>
                                        </div>
                                    </c:forEach>
                                </div>

                                <button class="carousel-control-prev" type="button"
                                        data-bs-target="#carouselExampleAutoplaying5" data-bs-slide="prev">
                                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                                    <span class="visually-hidden">Previous</span>
                                </button>
                                <button class="carousel-control-next" type="button"
                                        data-bs-target="#carouselExampleAutoplaying5" data-bs-slide="next">
                                    <span class="carousel-control-next-icon" aria-hidden="true"></span>
                                    <span class="visually-hidden">Next</span>
                                </button>

                            </div>
                            <div class="card-body text-center">
                                <h5 class="card-title">Saxofones</h5>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </header>
        <script src="js/cliente.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js"
                integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+"
                crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
                integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
                crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
                integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
                crossorigin="anonymous"></script>
    </body>
</html>