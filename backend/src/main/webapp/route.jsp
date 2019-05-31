<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Route</title>
</head>
<body>
    <tr>
        <td>${route.origin.city}</td>
        <td>${route.destination.city}</td>
        <td>${route.departureTime}</td>
        <td>${route.arrivalTime}</td>
    </tr>
    <div class="container">
        <c:forEach var="amenityItem" items="${amenityItems}">
            <div>${amenityItem.amenity}</div>
            <div>${amenityItem.comment}</div>
            <div>${amenityItem.confirmed}</div>
            <div>${amenityItem.price}</div>
        </c:forEach>
    </div>
    <div class="container">
        <div>aaa</div>
        <c:forEach var="user" items="${users}">
            <div>Hello</div>
            <div>${user.email}</div>
        </c:forEach>
    </div>
</body>
</html>
