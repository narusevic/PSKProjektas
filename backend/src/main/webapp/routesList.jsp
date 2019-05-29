<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Routes list</title>
</head>
<body>
<table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
    <thead>
    <tr>
        <th>From</th>
        <th>To</th>
        <th>Departure Time</th>
        <th>Arrival Time</th>
        <th>Status</th>
        <th></th>
        <th></th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="route" items="${routes}">
        <tr>
            <td>${route.from.city}</td>
            <td>${route.to.city}</td>
            <td>${route.departureTime}</td>
            <td>${route.arrivalTime}</td>
            <td><a href="${contextPath}/route/create/${trip.id}" class="btn btn-outline-primary">Create route for trip</a></td>
            <td><a href="${contextPath}/trip/${trip.id}" class="btn btn-outline-info"><span class="glyphicon glyphicon-info-sign">Full info</span></a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
