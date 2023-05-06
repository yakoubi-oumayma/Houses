<%@ page import="com.dp.Ad" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"  content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    <link rel="stylesheet" href="">
    <title>Ads - page</title>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light" >
    <a class="navbar-brand" href="ads.jsp" style="margin-left: 50px; margin-right: 300px;font-family: 'cursive';">H<span style="color:maroon;">L</span></a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav" >
        <ul class="navbar-nav" >
            <li class="nav-item active">
                <a class="nav-link" href="ads.jsp">Accueil <span class="sr-only"></span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="addAds.jsp">Ajouter une annonce</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="MyReservations">Mes reservations</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="requestedReservations.jsp">Demandes de réservation</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="profile.jsp">Profil</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="" style="color: red;">Déconnexion</a>
            </li>
        </ul>
    </div>
</nav>
<div class="search-section">
<form action="getQuery" method="post" class="search-bar">
    <input type="text" placeholder="Search..." name="chercher">
    <button type="submit"><svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="currentColor" class="bi bi-search" viewBox="0 0 16 16">
        <path d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001c.03.04.062.078.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1.007 1.007 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0z"/>
    </svg></button>

</form>
</div>
<h1>Les annonces</h1>
<section class="clean-block clean-catalog dark">
    <div class="container">
        <div class="content">
            <div class="row">
                <div class="col-md-9">
                    <div id="products" class="products">
                        <div class="row g-0">
                            <%
                                if(request.getAttribute("matchedAds") != null){
                                    ArrayList<Ad> matchedAds = (ArrayList<Ad>) request.getAttribute("matchedAds");
                                    for(Ad ad : matchedAds){
                                        if (ad != null) {

                            %>

                            <div class="col-12 col-md-6 col-lg-4">
                                <div class="clean-product-item">
                                    <div class="image"><a href=""><img class="img-fluid d-block mx-auto" src="images/1.jpg"></a>
                                    </div>
                                    <div class="product-name"><a href=""></a></div>
                                    <div class="about">
                                        <div class="info">
                                            <h5 class="card-title">Titre: <%= ad.getTitre()%></h5>
                                            <h5>date debut: <%= ad.getDate_d()%></h5>
                                            <h5>date fin: <%= ad.getDate_f()%></h5>
                                            <h7>Ville: <%= ad.getHouse().getCity() %></h7>
                                            <h7>Surface: <%= ad.getHouse().getSurface() %>m²</h7>
                                            <h7>Prix: <%= ad.getHouse().getPrice() %>MAD</h7>
                                            <p class="">Description: <%= ad.getDescription() %></p>
                                        </div>
                                        <div>
                                            <button type="button" class="btn btn-primary">Réserver</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <%
                                        }
                                    }
                                }
                            if(request.getAttribute("TotalAds") != null) {
                            ArrayList<Ad> allAds = (ArrayList<Ad>) request.getAttribute("TotalAds");
                            for(Ad ad : allAds){
                            if (ad != null) {
                            %>
                            <div class="col-12 col-md-6 col-lg-4">
                                <div class="clean-product-item">
                                    <div class="image"><a href=""><img class="img-fluid d-block mx-auto" src="images/1.jpg"></a>
                                    </div>
                                    <div class="product-name"><a href=""></a></div>
                                    <div class="about">
                                        <div class="info">
                                            <h5 class="card-title">Titre: <%= ad.getTitre()%></h5>
                                            <h5>date debut: <%= ad.getDate_d()%></h5>
                                            <h5>date fin: <%= ad.getDate_f()%></h5>
                                            <h7>Ville: <%= ad.getHouse().getCity() %></h7>
                                            <h7>Surface: <%= ad.getHouse().getSurface() %>m²</h7>
                                            <h7>Prix: <%= ad.getHouse().getPrice() %>MAD</h7>
                                            <p class="">Description: <%= ad.getDescription() %></p>
                                        </div>
                                        <div>
                                            <button type="button" class="btn btn-primary">Réserver</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <%
                                     }
                                   }
                                }
                            %>

                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

<style>

    .search-section{
        width:100%;
        min-height: 80vh;
        display: flex;
        align-items: center;
        justify-content: center;
        background-image: linear-gradient(rgba(0, 0, 0, 0.2), rgba(0, 0, 0, 0.2)),url(images/1.jpg);
        background-size: cover;
    }
.search-bar{
    width: 100%;
    max-width: 700px;
    background: rgb(0, 0, 0, 0.8);
    display: flex;
    align-items: center;
    border-radius:60px;
    padding: 10px 20px;
}
.search-bar input{
    background: transparent;
    flex: 1;
    border: 0;
    outline: none;
    padding: 24px 20px;
    font-size:20px ;
    color: white;
}
::placeholder{
    color: white;
}
.search-bar button svg{
    width: 25px;
}
    .search-bar button {
        border: 0;
        border-radius:50%;
        width: 60px;
        height: 60px;
        background: #D7A86E;
        cursor: pointer;
    }

    section {
        margin-top: 80px;
    }
    .row .col-12{
        align-items: center;

    }
    .row .col-12 .clean-product-item{
        margin-right: 40px;
    }
</style>
</body>
</html>