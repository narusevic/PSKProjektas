<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
  <head>
      <meta charset="utf-8">
      <title>Create trip</title>
    </head>

  <body>

    <div class="container">
        <c:forEach var="trip" items="${trips}">
            <div>${trip.description}</div>
            <div>${trip.departureTime}</div>
            <div>${trip.arrivalTime}</div>
          <a href="${contextPath}/route/create/${trip.id}">Create route for trip</a>
          <div>----------------</div>
        </c:forEach>
    </div>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="${contextPath}/resources/js/bootstrap.min.js"></script>
  </body>
</html>