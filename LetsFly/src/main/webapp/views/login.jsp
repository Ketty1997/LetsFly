<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib uri="http://java.sun.com/jsp/jstl/core"
prefix="c"%> <%@ taglib uri="http://www.springframework.org/tags/form"
prefix="f"%> <%boolean
loginBoolean=(boolean)request.getAttribute("loginBoolean");%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <link
      href="https://fonts.googleapis.com/css2?family=Jost:wght@500&display=swap"
      rel="stylesheet"
    />
    <link rel="stylesheet" href="/style.css" />
    <title>Login</title>
  </head>
  <body class="bodyLogin">
    <div class="main">
      <input type="checkbox" id="chk" aria-hidden="true" />
      <% if(loginBoolean){ %>
      <script>
        document.getElementById("chk").checked = true;
      </script>
      <% } %>
      <div class="signup">
        <f:form modelAttribute="userForm" method="POST" action="/user/insert">
          <label for="chk" aria-hidden="true">Sign up</label>
          <f:input type="text" path="name" placeholder="Name" required="true" />
          <f:input
            type="text"
            path="surname"
            placeholder="Surname"
            required="true"
          />
          <f:input
            type="text"
            path="username"
            placeholder="Username"
            required="true"
          />
          <div style="text-align: center">
            <a class="errorMessage d-inline-block">${usernameMessage}</a>
          </div>

          <f:input
            type="password"
            path="password"
            placeholder="Password"
            required="true"
          />
          <button>Sign up</button>
        </f:form>
      </div>

      <div class="login">
        <f:form
          modelAttribute="loginDto"
          method="POST"
          action="/user/authorize"
        >
          <label for="chk" aria-hidden="true">Login</label>
          <f:input
            type="text"
            path="username"
            placeholder="Username"
            required="true"
          />
          <f:input
            type="password"
            path="password"
            placeholder="Password"
            required="true"
          />
          <div style="text-align: center">
            <a class="errorMessage d-inline-block"
              >${passswordinvalidMessage}</a
            >
          </div>
          <button>Login</button>
        </f:form>
      </div>
    </div>
  </body>
</html>
