<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@page import="com.letsfly.dto.*"%> <% boolean hasUser =
false; UserDto userDto = (UserDto)
request.getSession().getAttribute("userForm"); if (userDto != null) { hasUser =
true; } %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Home</title>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
      crossorigin="anonymous"
    ></script>
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
      crossorigin="anonymous"
    />
    <link rel="stylesheet" href="/style.css" />
    <link rel="preconnect" href="https://fonts.googleapis.com" />
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
    <link
      href="https://fonts.googleapis.com/css2?family=Bitter:ital,wght@0,100..900;1,100..900&family=Playfair+Display&family=Ubuntu:ital,wght@0,300;0,400;0,500;0,700;1,300;1,400;1,500;1,700&display=swap"
      rel="stylesheet"
    />
  </head>
  <body style="overflow: hidden">
    <!-- Navbar -->
    <div id="navbar" class="sticky-top"></div>
    <!-- Carosello -->
    <!--Inizio Carosello-->
    <div
      id="carouselExampleIndicators"
      class="carousel slide"
      data-bs-ride="carousel"
    >
      <div class="carousel-indicators">
        <button
          type="button"
          data-bs-target="#carouselExampleIndicators"
          data-bs-slide-to="0"
          class="active"
          aria-current="true"
          aria-label="Slide 1"
        ></button>
        <button
          type="button"
          data-bs-target="#carouselExampleIndicators"
          data-bs-slide-to="1"
          aria-label="Slide 2"
        ></button>
        <button
          type="button"
          data-bs-target="#carouselExampleIndicators"
          data-bs-slide-to="2"
          aria-label="Slide 3"
        ></button>
      </div>

      <div class="carousel-inner" id="boximg">
        <div class="carousel-item active" data-bs-interval="2000">
          <img src="/img/plane1.jpg" class="d-block w-100" />
        </div>
        <div class="carousel-item" data-bs-interval="2000">
          <img src="/img/plane3.jpg" class="d-block w-100" />
        </div>
        <div class="carousel-item">
          <img src="/img/aereo.jpg" class="d-block w-100" />
        </div>
      </div>
      <button
        class="carousel-control-prev"
        type="button"
        data-bs-target="#carouselExampleIndicators"
        data-bs-slide="prev"
      >
        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
        <span class="visually-hidden">Previous</span>
      </button>
      <button
        class="carousel-control-next"
        type="button"
        data-bs-target="#carouselExampleIndicators"
        data-bs-slide="next"
      >
        <span class="carousel-control-next-icon" aria-hidden="true"></span>
        <span class="visually-hidden">Next</span>
      </button>
    </div>
    <!--Fine Carosello-->
    <!-- Inizio box presentazione + bottone -->
    <div id="box">
      <h1 id="titolo" class="display-5">Let's Fly</h1>
      <p id="slogan" class="display-6">
        Turn your dreams into journeys.
        <br />
        Book your flight today and fly into new adventures!
      </p>
      <button id="btn" onclick="location.href = '/findFlight'">
        <a>Where are we going?</a>
      </button>
    </div>
    <!-- Inizio box presentazione + bottone -->
    <script>
      $("#navbar").load("/views/navbar.jsp");
    </script>
  </body>
</html>
