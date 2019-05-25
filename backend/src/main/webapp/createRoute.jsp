<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
  <head>
      <meta charset="utf-8">
      <title>Create Route</title>
    </head>

  <body>

    <div class="container">

        ${trip}

        <form:form method="POST" modelAttribute="routeForm" class="form-route">
            <h2 class="form-trip-heading">Create Route</h2>
            <spring:bind path="departureTime">
                <div class="form-group">
                    <form:input type="date" path="departureTime" class="form-control" placeholder="Departure" autofocus="true"></form:input>
                </div>
            </spring:bind>
            <spring:bind path="arrivalTime">
                <div class="form-group">
                    <form:input type="date" path="arrivalTime" class="form-control" placeholder="Arrival"></form:input>
                </div>
            </spring:bind>
            <%-- To be implemented after Location is implemented --%>
            <%-- <spring:bind path="startPlace">
                <div class="form-group">
                    <form:input type="text" path="startPlace" class="form-control" placeholder="Origin"></form:input>
                </div>
            </spring:bind>
            <spring:bind path="destination">
                <div class="form-group">
                    <form:input type="text" path="destination" class="form-control" placeholder="Destination"></form:input>
                </div>
            </spring:bind> --%>

            <button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
        </form:form>

    </div>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="${contextPath}/resources/js/bootstrap.min.js"></script>
  </body>
</html>