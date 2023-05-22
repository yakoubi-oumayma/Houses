<%--
  Created by IntelliJ IDEA.
  User: OY
  Date: 16/04/2023
  Time: 11:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
  <title>Login - Brand</title>
  <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i&amp;display=swap">
  <link rel="stylesheet" href="assets/fonts/fontawesome-all.min.css">
</head>
<body>
<input type="hidden" id="status" value=" <% request.getAttribute("status");%>">
<div class="container" style="margin-top: 100px !important;">
  <div class="row justify-content-center">
    <div class="col-md-9 col-lg-12 col-xl-10">
      <div class="card shadow-lg o-hidden border-0 my-5">
        <div class="card-body p-0">
          <div class="row">
            <div class="col-lg-6 d-none d-lg-flex">
              <div class="flex-grow-1 bg-login-image" style="background-image: url('images/1.jpg'); background-size: cover; "></div>
            </div>
            <div class="col-lg-6">
              <div class="p-5">
                <div class="text-center">
                  <h4 class="text-dark mb-4" style="color:#3C2A21 !important;">Bienvenue!</h4>
                </div>
                <form method="POST" action="login" class="user">
                  <div class="mb-3"><input class="form-control" type="email"   placeholder="adresse email" name="email"></div>
                  <div class="mb-3"><input class="form-control " type="password"  placeholder="mot de passe" name="password"></div>
                  <button class="btn btn-primary d-block btn-user w-100" type="submit" style="background-color: #D7A86E !important; border: #D7A86E">connexion</button>
                  <br>
                </form>
                <div class="text-center"><a class="small" href="register.jsp" style="color: #D7A86E">Créer un compte?</a></div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
<script src="assets/bootstrap/js/bootstrap.min.js"></script>
<script src="assets/js/theme.js"></script>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
 </body>
</html>
<style>
  @import url('https://fonts.googleapis.com/css2?family=Bebas+Neue&display=swap');
  *{
    letter-spacing: 1px;
    font-family: 'Bebas Neue', cursive;
    font-size: large;
  }
</style>
