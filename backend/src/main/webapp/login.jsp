<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
  <head>

      <meta charset="utf-8">
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
      <meta name="description" content="">
      <meta name="author" content="">

      <title>Login</title>

      <!-- Custom fonts for this template-->
      <link href="${contextPath}/resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">

      <!-- Custom styles for this template-->
      <link href="${contextPath}/resources/css/sb-admin.css" rel="stylesheet">

  </head>

  <body class="bg-dark">

  <div class="container">
      <div class="card card-login mx-auto mt-5">
          <div class="card-header">Log in</div>
          <div class="card-body">
              <form method="POST" action="${contextPath}/login" class="form-signin">
                  <div class="form-group ${error != null ? 'has-error' : ''}">
                      <span style="color: #007bff;">${message}</span>
                      <div class="form-label-group">
                          <input name="email" type="email" id="inputEmail" class="form-control" placeholder="Email address" required="required" autofocus="true">
                          <label for="inputEmail">Email Address</label>
                      </div>
                      <br/>
                      <div class="form-label-group">
                          <input name="password" type="password" id="inputPassword" class="form-control" placeholder="Password" required="required">
                          <label for="inputPassword">Password</label>
                      </div>
                      <span>${error}</span>
                      <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                  </div>
                  <button class="btn btn-lg btn-primary btn-block" type="submit">Log in</button>
              </form>
              <div class="text-center">
                  <a class="d-block small mt-3" href="${contextPath}/registration">Register an Account</a>
              </div>
          </div>
      </div>
  </div>

  <!-- Bootstrap core JavaScript-->
  <script src="${contextPath}/resources/vendor/jquery/jquery.min.js"></script>
  <script src="${contextPath}/resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

  <!-- Core plugin JavaScript-->
  <script src="${contextPath}/resources/vendor/jquery-easing/jquery.easing.min.js"></script>

  </body>

</html>
