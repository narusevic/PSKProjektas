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
            <div>Participants</div>
            <c:forEach var="userTrip" items="${trip.getUserTrips()}">
                <div>${userTrip.getUser().getEmail()}. User Approved? ${userTrip.getUserApproved()}</div>
            </c:forEach>

            <form:form action="${contextPath}/trip/addParticipant/${trip.id}" method="POST" modelAttribute="participantForm" class="participant-trip">
                <spring:bind path="user">
                    <form:select path="user">
                        <form:option value="NONE">User email</form:option>
                        <form:options items="${participants}" itemLabel="email"></form:options>
                    </form:select>
                </spring:bind>

                <button class="btn btn-lg btn-primary btn-block" type="submit">Add User</button>
            </form:form>
            <a href="${contextPath}/route/create/${trip.id}">Create route for trip</a>
            <div>----------------</div>
        </c:forEach>
    </div>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="${contextPath}/resources/js/bootstrap.min.js"></script>
  </body>
</html>