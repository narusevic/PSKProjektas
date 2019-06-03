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
    <title>Amenity Items</title>
</head>
<body>
<h1>Amenity items</h1>
<table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
    <thead>
    <tr>
        <th>Service</th>
        <th>Comment</th>
        <th>Is purchased</th>
        <th>Price</th>
        <th>Related route id</th>
    </tr>
    </thead>
    <tbody>
        <c:forEach var="amenityItem" items="${amenityItems}">
    <tr>
            <td>${amenityItem.amenity.name}</td>
            <td>${amenityItem.comment}</td>
            <td>${amenityItem.confirmed}</td>
            <td>${amenityItem.price}</td>
            <td>${amenityItem.route.id}</td>
        </c:forEach>
    </tr>
    </tbody>
</table>
</body>
</html>
