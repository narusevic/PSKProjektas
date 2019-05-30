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

      <title>Registration</title>

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

                <form:form method="POST" modelAttribute="userForm" class="form-signin">
                    <h2 class="form-signin-heading">Create your account</h2>
                    <spring:bind path="email">
                        <div class="form-group ${status.error ? 'has-error' : ''}">
                            <form:input name="email" type="text" path="email" class="form-control" placeholder="Email"
                                        autofocus="true"></form:input>
                            <form:errors path="email"></form:errors>
                        </div>
                    </spring:bind>

                    <spring:bind path="password">
                        <div class="form-group ${status.error ? 'has-error' : ''}">
                            <form:input name="password" type="password" path="password" class="form-control" placeholder="Password"></form:input>
                            <form:errors path="password"></form:errors>
                        </div>
                    </spring:bind>

                    <spring:bind path="passwordConfirm">
                        <div class="form-group ${status.error ? 'has-error' : ''}">
                            <form:input name="password" type="password" path="passwordConfirm" class="form-control"
                                        placeholder="Confirm your password"></form:input>
                            <form:errors path="passwordConfirm"></form:errors>
                        </div>
                    </spring:bind>
                    <button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
                </form:form>
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