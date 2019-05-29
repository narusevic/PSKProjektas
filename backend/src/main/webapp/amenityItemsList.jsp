<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: macbook
  Date: 2019-05-26
  Time: 15:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Amenity items</title>
</head>
<body>
<h1>Amenity items created for trips of the current user</h1>
    <div class="container">
        <c:forEach var="amenityItem" items="${amenityItems}">
            <div>${amenityItem.amenity}</div>
            <div>${amenityItem.comment}</div>
            <div>${amenityItem.confirmed}</div>
            <div>${amenityItem.price}</div>
        </c:forEach>
    </div>
</body>
</html>
