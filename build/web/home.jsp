<%-- 
    Document   : home
    Created on : 18-mar-2020, 9:33:50
    Author     : Jorge
--%>

<%@page import="entities.Movie"%>
<%@page import="entities.Person"%>
<%@page import="entities.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<!doctype html>
<html lang="en">

<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.2/css/all.css">
    <link rel="stylesheet" href="css/mycss.css">
    <title></title>
</head>

<body>
    
     <% 
         String pulsado = (String)session.getAttribute("pulsado");
         Usuario user = (Usuario) session.getAttribute("usuario");
     %>
    <!--Barra-->
    <div class="container shadow">
        <nav class="navbar navbar-dark bg-dark px-0">
          <img src="img/logotmdb.png" alt="movie">
            <div class="col">
                <ul class="navbar-nav ml-auto">
                  <li class="nav-item">
                     <a class="nav-link" href="Controller?op=personomovie&pulsado=person">Person <span class="sr-only">(current)</span></a>
                  </li>
                </ul>
            </div>
            
            <div class="col">
                <ul class="navbar-nav ml-auto">
                  <li class="nav-item">
                    <a class="nav-link" href="Controller?op=personomovie&pulsado=movie">Movie</a>
                  </li>
                </ul>
            </div>
            
        <%if (user!=null) {%>
            <form class="row" action="Controller?op=logout" method="POST">
            
                <h4 class="text-white m-2">Welcome, <%= user.getNombre()%>!</h4> 

                <button type="submit" class="btn btn-danger px-4 mr-5">Log Out</button>
           
            </form>
              
        <%}else {%>
            
            <form class="row" action="Controller?op=login" method="POST">
                <div class="col">
                    <input type="text" class="form-control" name="dni" placeholder="dni">
                </div>
                <div class="col">
                  <input type="text" class="form-control" name="nombre" placeholder="nombre">
                </div>
                <div class="col">
                  <button type="submit" class="btn btn-danger pr-4 pl-4">Login/Register</button>
                </div>
            <form>
        <%}%>
        </nav>
        <!-- Cuerpo-->
            <%
    if (pulsado.equals("person")) {
    %>
        <div class="row py-5">
            <%
                List<Person> personas = (List<Person>)session.getAttribute("personas");
                
                for(int i=0; i<personas.size();i++){
                    Person persona = personas.get(i);
            %>
            <div class="col-lg-4 col-md-6">
                <div class="card">
                    <img src="https://image.tmdb.org/t/p/w500<%=persona.getFoto()%>" class="card-img-top">
                    <div class="card-body">
                      <h5 class="card-title text-center">"<%=persona.getNombre()%>"</h5>
                      <h2 class="card-title text-center"></h2>
                      <button type="submit" class="btn btn-danger pr-4 pl-4">FILMOGRAFÍA</button>
                    </div>
                </div>
            </div>
            <%} %>
        </div>
        <p class="pb-5"></p>
        <footer class="fixed-bottom container">
            <h1>The MovieDB - Azarquiel 2020</h1>
        </footer>
    </div>
        <%}%>
        
    <%
    if (pulsado.equals("movie")) {
    %>
        <div class="row py-5">
            <%
                List<Movie> peliculas = (List<Movie>)session.getAttribute("peliculas");
                
                for(int i=0; i<peliculas.size();i++){
                    Movie pelicula = peliculas.get(i);
            %>
            <div class="col-lg-4 col-md-6">
                <div class="card">
                    <%if(pelicula.getPoster()!=null)%>
                    <img src="https://image.tmdb.org/t/p/w500<%=pelicula.getPoster()%>" class="card-img-top">
                    <div class="card-body">
                      <h5 class="card-title text-center">"<%=pelicula.getTitulo()%>"</h5>
                      <h5 class="card-title text-center">"<%=pelicula.getFecha()%>"</h5>
                      <h5 class="card-title text-center">"<%=pelicula.getTrama()%>"</h5>
                      <h2 class="card-title text-center"></h2>
                    </div>
                </div>
            </div>
            <%} %>
        </div>
        <p class="pb-5"></p>
        <footer class="fixed-bottom container">
            <h1>The MovieDB - Azarquiel 2020</h1>
        </footer>
    </div>
        <%}%>


        
        
        
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
    <script src="js/myjs.js"></script>
</body>

</html>
