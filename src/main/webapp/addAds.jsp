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
<div class="formulaire">
    <form  method="post" action="ajouterPetition.php">

        <center><h1>Ajouter une annonce pour votre maison </h1></center>
        <label for="titre">Titre de l'annonce</label>
        <input type="text" id="titre" name="titre" placeholder="titre">

        <label for="ville">Ville</label>
        <input type="text" id="ville" name="ville" placeholder="ville">

        <label for="surface">Surface</label>
        <input type="number" id="surface" name="surface" placeholder="surface">

        <label for="prix">prix de location par mois</label>
        <input type="number" id="prix" name="prix" placeholder="prix">

        <label for="description">Description</label>
        <input type="text" id="description" name="description" placeholder="description...">


        <input type="submit" value="Ajouter l'annonce">
    </form>
</div>

</body>
</html>
<style>

    body{
        background-color: #f2f2f2;

    }
    .formulaire form{
        width: 50%;
        margin-left: 300px;
        margin-top: 100px;

    }
    .formulaire input[type=text], input[type=number], select {
        width: 100%;
        padding: 12px 20px;
        margin: 8px 0;
        display: inline-block;
        border-radius: 4px;
        box-sizing: border-box;

    }

    .formulaire input[type=submit] {
        width: 100%;
        background-color: orange;
        color: white;
        padding: 14px 20px;
        margin: 8px 0;
        border: none;
        border-radius: 4px;
        cursor: pointer;
    }

    .formulaire input[type=submit]:hover {
        background-color: orange;
    }

    .formulaire div {
        border-radius: 5px;
        background-color: #f2f2f2;
        padding: 20px;
    }
</style>