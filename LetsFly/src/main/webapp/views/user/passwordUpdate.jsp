<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%> <%@ taglib uri="http://java.sun.com/jsp/jstl/core"
prefix="c"%> <%@ taglib uri="http://www.springframework.org/tags/form"
prefix="f"%> <%@page import="com.letsfly.form.*"%>
<!DOCTYPE html>
<html>
  <head>
    <link rel="stylesheet" href="/styleFormUser.css" />
    <link rel="stylesheet" href="/css/common.css" />

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
    <meta charset="ISO-8859-1" />
    <title>Edit User</title>
  </head>
  <body class="bodyUser">
    <div id="navbar" class="sticky-top"></div>
    <div class="containerMio">
      <f:form
        modelAttribute="modelUserPasswordForm"
        method="PUT"
        action="/user/modifyPassword"
        id="contact"
      >
        <f:input path="id" type="hidden" />

        <fieldset>
          <f:label path="oldpassword">Current Password</f:label>
          <f:input
            path="oldpassword"
            type="password"
            placehoder="Actual Password"
            class="password"
          />
        </fieldset>
        <div style="text-align: center">
          <a class="errorMessage">${passswordinvalidMessage }</a>
        </div>

        <fieldset>
          <f:label path="newpassword">New Password</f:label>
          <f:input
            path="newpassword"
            type="password"
            placehoder="New Password"
            class="password"
          />
        </fieldset>
        <div style="text-align: center">
          <a class="errorMessage">${passswordunequalMessage }</a>
        </div>

        <fieldset>
          <f:label path="checknewpassword">Confirm new password</f:label>
          <f:input
            path="checknewpassword"
            type="password"
            placehoder="Repeat new password"
            class="password"
          />
        </fieldset>
        <div style="text-align: center">
          <a class="errorMessage">${passswordunequalMessage }</a>
        </div>

        <fieldset>
          <input type="submit" value="Update" id="contact-submit" />
        </fieldset>
        <fieldset>
          <a href="/user/edit" role="button" id="elimina">Undo</a>
        </fieldset>
      </f:form>
    </div>
    <script>
      $("#navbar").load("/views/navbar.jsp");
    </script>
  </body>
</html>
