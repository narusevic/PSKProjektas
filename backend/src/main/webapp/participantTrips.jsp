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
        <c:forEach var="userTrip" items="${userTrips}">
            <div>${userTrip.getTrip().description}</div>
            <div>${userTrip.getTrip().departureTime}</div>
            <div>${userTrip.getTrip().arrivalTime}</div>
            <div>User approved: ${userTrip.getUserApproved()}</div>
            <form:form action="${contextPath}/trip/approve/${userTrip.getTrip().id}" method="POST">
                <input type="submit" value="Change Approved status"/>
            </form:form>
            <form:form action="${contextPath}/trip/delete/${userTrip.getTrip().id}" method="POST">
                <input type="submit" value="Cancel Trip"/>
            </form:form>
            <div>----------------</div>
        </c:forEach>
    </div>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="${contextPath}/resources/js/bootstrap.min.js"></script>
  </body>
</html>