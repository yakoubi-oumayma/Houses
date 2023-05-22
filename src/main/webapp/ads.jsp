<%@ page import="com.dp.Ad" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Objects" %>

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

<div class="search-section">
<form action="listeAnnonces" method="post" class="search-bar">
    <input type="text" placeholder="Search..." name="chercher">
    <button type="submit"><svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="currentColor" class="bi bi-search" viewBox="0 0 16 16">
        <path d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001c.03.04.062.078.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1.007 1.007 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0z"/>
    </svg></button>

</form>
</div>
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
                <h2>Maison à  <%= ad.getHouse().getCity()%></h2>
                <p>
                    <%= ad.getDescription() %>
                   prix: <%= ad.getHouse().getPrice() %>MAD, surface:  <%= ad.getHouse().getSurface() %>m²
                </p>

                    <div>
                            <% if(Objects.equals(ad.getEtat_annonce(), "Disponible")){ %>
                        <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModalAllAds<%=ad.getAnnonce_id()%>">
                            Réservez maintenant</button>
                        <%
                            }
                            else { %>
                        <button type="button" class="btn btn-primary"  disabled>
                            Non disponible</button>
                        <%
                            }%>
                    </div>
                     <span class="sr-only">about this is some title</span>
            </div>
            </div>
        </div>
    </article>

    <!-- The Modal -->
    <div class="modal" id="myModalAllAds<%=ad.getAnnonce_id()%>">
        <div class="modal-dialog">
            <div class="modal-content">
                <!-- Modal Header -->
                <div class="modal-header">
                    <h4 class="modal-title">voulez-vous vraiment réserver cette maison? </h4>
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                </div>

                <form method="post" action="RequestHouse">
                <!-- Modal body -->
                <div class="modal-body">
                        <div class="form-group">
                            <input type="hidden" name="annonce_id" value="<%= ad.getAnnonce_id()%>">

                            <label>Date de début de resérvation</label>
                            <input type="date" class="form-control" name="date_deb" id="date_deb">
                        </div>
                        <div class="form-group">
                            <label>Date de fin de resérvation</label>
                            <input type="date" class="form-control" name="date_fin" id="date_fin" >
                        </div>

                </div>

                <!-- Modal footer -->
                <div class="modal-footer">
                    <input type="submit"  value="Envoyer la demande">
                    <button type="button" class="btn btn-danger" data-dismiss="modal" >Annuler</button>
                </div>
                </form>
            </div>
        </div>
    </div>

    <%          }
            }
        }
        else if(request.getAttribute("matchedAds") != null){
            ArrayList<Ad> matchedAds = (ArrayList<Ad>) request.getAttribute("matchedAds");
            for(Ad ad : matchedAds){
                if (ad != null) {
    %>
    <article>
        <div class="article-wrapper">
            <figure>
                <img src="http://localhost/imageAds/<%=ad.getImgFileName()%>" alt="" />
            </figure>
            <div class="article-body">
                <h2>Maison à  <%= ad.getHouse().getCity()%></h2>
                <p>
                    <%= ad.getDescription() %>
                    prix: <%= ad.getHouse().getPrice() %>MAD, surface:  <%= ad.getHouse().getSurface() %>m²
                </p>

                    <div>
                        <% if(Objects.equals(ad.getEtat_annonce(), "Disponible")){ %>
                        <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModalmatchedAd<%=ad.getAnnonce_id()%>">
                            Réservez maintenant</button>
                        <%
                        }
                        else { %>
                        <button type="button" class="btn btn-primary" disabled>
                            Non disponible</button>
                        <%
                            }%>
                    </div>

                <span class="sr-only">about this is some title</span>
            </div>
        </div>
        </div>
    </article>
    <!-- The Modal -->
    <div class="modal" id="myModalmatchedAd<%=ad.getAnnonce_id()%>">
        <div class="modal-dialog">
            <div class="modal-content">
                <!-- Modal Header -->
                <div class="modal-header">
                    <h4 class="modal-title">voulez-vous vraiment réserver cette maison? </h4>
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                </div>
                <form method="post" action="RequestHouse">
                <!-- Modal body -->
                <div class="modal-body">
                        <div class="form-group">
                            <input type="hidden" name="annonce_id" value="<%= ad.getAnnonce_id()%>" >

                            <label>Date de début de resérvation</label>
                            <input type="date" class="form-control" name="date_deb" id="date_d">
                        </div>
                        <div class="form-group">
                            <label>Date de fin de resérvation</label>
                            <input type="date" class="form-control" name="date_fin" id="date_f" >
                        </div>
                </div>

                <!-- Modal footer -->
                <div class="modal-footer">
                    <input type="submit"  value="Envoyer la demande">
                    <button type="button" class="btn btn-danger" data-dismiss="modal">Annuler</button>
                </div>
                </form>

            </div>
        </div>
    </div>

    <%
                }
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