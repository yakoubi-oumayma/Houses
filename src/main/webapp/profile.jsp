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
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

    <link rel="stylesheet" href="">
    <title>Profile - page</title>
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
                <a class="nav-link" href="listeAnnonces">Accueil <span class="sr-only"></span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="addAds.jsp">Ajouter une annonce</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="ProfileServlet">Profil</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="deconnexion" style="color: red;">Déconnexion</a>
            </li>
        </ul>
    </div>
</nav>

<section class="articles">
    <%
        if(request.getAttribute("adList") != null) {
            ArrayList<Ad> allAds = (ArrayList<Ad>) request.getAttribute("adList");
            for(Ad ad : allAds){
                if (ad != null) {
    %>
    <article>
        <div class="article-wrapper">
            <figure>
                <img src="http://localhost/imageAds/<%=ad.getImgFileName()%>" alt="" />
            </figure>
            <div class="article-body">
                <h3><%=ad.getTitre()%> à <%= ad.getHouse().getCity()%></h3>
                <h5 STYLE="font-weight: bold;">De <%=ad.getDate_d()%> à <%=ad.getDate_f()%>  </h5>
                   <span><%= ad.getDescription() %></span>
                    <span> Prix: <%= ad.getHouse().getPrice() %>MAD </span>
                    <span> surface:  <%= ad.getHouse().getSurface() %>m²</span>


                <div>
                    <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal"> <%= ad.getEtat_annonce() %></button>
                </div>
                <span class="sr-only">about this is some title</span>
            </div>
        </div>
        </div>
    </article>
    <%          }
        }
    }
    %>

</section>
<style>


    span:hover {
        background-size: 100% 100%;
        background-position: 0% 100%;
        transition: background-position .7s, background-size .5s ease-in-out;
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
    article {
        --img-scale: 1.001;
        --title-color: black;
        --link-icon-translate: -20px;
        --link-icon-opacity: 0;
        position: relative;
        border-radius: 16px;
        box-shadow: none;
        background: #fff;
        transform-origin: center;
        transition: all 0.4s ease-in-out;
        overflow: hidden;
    }

    article a::after {
        position: absolute;
        inset-block: 0;
        inset-inline: 0;
        cursor: pointer;
        content: "";
    }

    /* basic article elements styling */
    article h2 {
        margin: 0 0 18px 0;
        font-family: "Bebas Neue", cursive;
        font-size: 1.9rem;
        letter-spacing: 0.06em;
        color: var(--title-color);
        transition: color 0.3s ease-out;
    }

    figure {
        margin: 0;
        padding: 0;
        aspect-ratio: 16 / 9;
        overflow: hidden;
    }

    article img {
        max-width: 100%;
        transform-origin: center;
        transform: scale(var(--img-scale));
        transition: transform 0.4s ease-in-out;
    }

    .article-body {
        padding: 24px;
    }

    article a {
        display: inline-flex;
        align-items: center;
        text-decoration: none;
        color: #d9aa71;
    }

    article a:focus {
        outline: 1px dotted #d9aa71;
    }

    article a .icon {
        min-width: 24px;
        width: 24px;
        height: 24px;
        margin-left: 5px;
        transform: translateX(var(--link-icon-translate));
        opacity: var(--link-icon-opacity);
        transition: all 0.3s;
    }

    /* using the has() relational pseudo selector to update our custom properties */
    article:has(:hover, :focus) {
        --img-scale: 1.1;
        --title-color: #d9aa71;
        --link-icon-translate: 0;
        --link-icon-opacity: 1;
        box-shadow: rgba(0, 0, 0, 0.16) 0px 10px 36px 0px, rgba(0, 0, 0, 0.06) 0px 0px 0px 1px;
    }

    *,
    *::before,
    *::after {
        box-sizing: border-box;
    }

    body {
        margin: 0;
        font-family: "Figtree", sans-serif;
        font-size: 1.2rem;
        line-height: 1.6rem;
        background-image: linear-gradient(45deg, #eeecec, #efe9e2);
        min-height: 100vh;
    }
    section{
        padding: 48px 0;
    }

    .articles {
        margin-top: 100px;
        display: grid;
        max-width: 1200px;
        margin-inline: auto;
        padding-inline: 24px;
        grid-template-columns: repeat(auto-fill, minmax(320px, 1fr));
        gap: 24px;
    }

    @media screen and (max-width: 960px) {
        article {
            container: card/inline-size;
        }
        .article-body p {
            display: none;
        }
    }

    @container card (min-width: 380px) {
        .article-wrapper {
            display: grid;
            grid-template-columns: 100px 1fr;
            gap: 16px;
        }
        .article-body {
            padding-left: 0;
        }
        figure {
            width: 100%;
            height: 100%;
            overflow: hidden;
        }
        figure img {
            height: 100%;
            aspect-ratio: 1;
            object-fit: cover;
        }
    }

    .sr-only:not(:focus):not(:active) {
        clip: rect(0 0 0 0);
        clip-path: inset(50%);
        height: 1px;
        overflow: hidden;
        position: absolute;
        white-space: nowrap;
        width: 1px;
    }

</style>
</body>
</html>