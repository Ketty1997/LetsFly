<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@page import="com.letsfly.dto.*"%> <% boolean
hasUser=false;UserDto
userDto=(UserDto)request.getSession().getAttribute("userForm"); if
(userDto!=null) { hasUser = true; }%>
<!DOCTYPE html>
<html>
  <head>
  </head>
  <body>
    <!-- Navbar -->
     <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="container-fluid">
            <!-- Navbar brand (a sinistra) -->
            <a class="navbar-brand" href="/">
    <img src="https://i.pinimg.com/originals/e9/0a/29/e90a299a041b7d37cdafc6eb2905e9d6.png" width="30" height="30" alt="">
    LetsFly</a>

            <!-- Bottone per il toggle della navbar per schermi piccoli -->
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <!-- Contenuto della navbar (link e dropdown) -->
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <!-- Link singolo (a sinistra) -->
                    <li class="nav-item">
                        <a class="nav-link" href="/airport/findAll">Airports</a>
                    </li>
                </ul>
                <!-- Dropdown menu (a destra) -->
                <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
                <% if(hasUser){ %>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                            <% out.print(userDto.getUsername()); %>
                        </a>
                        <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="navbarDropdown">
                            <li><a class="dropdown-item" href="/user/edit">Profile</a></li>
                            <li><a class="dropdown-item" href="/user/myTicket">My ticket</a></li>
                            <% if(userDto.getIsadmin()>0){ %>
                            <li><hr class="dropdown-divider"></li>
                            <li><a class="dropdown-item" href="/views/home.jsp">Control Panel</a></li>
                            <% } %>
                            <li><hr class="dropdown-divider"></li>
                            <li><a class="dropdown-item" href="/user/logOut">LogOut</a></li>
                        </ul>
                <% }else{ %>
                  <li class="nav-item">
                  <a class="nav-link" href="/user/login">Login</a>
                <% } %>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
    </body>
    </html>