<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create amenity item</title>
</head>
<body>
    <div class="container">
        <form:form method="POST" modelAttribute="amenityItemForm" class="form-amenity_item">
            <h2>Create an amenity item (checklist item)</h2>
            <spring:bind path="amenity">
                <div class="form-group">
                    <form:select path="amenity">
                        <form:options items="${amenities}" itemValue="id" itemLabel="name"></form:options>
                    </form:select>
                </div>
            </spring:bind>
            <spring:bind path="price">
                <div class="form-group">
                    <form:input path="price" type="number" step="0.01" placeholder="0.00"></form:input>
                </div>
            </spring:bind>
            <spring:bind path="comment">
                <div class="form-group">
                    <form:input path="comment" type="text" placeholder="Comment"></form:input>
                </div>
            </spring:bind>
            <spring:bind path="confirmed">
                <div class="form-group">
                    Is this amenity item already purchased?<br>
                    <form:checkbox path="confirmed"></form:checkbox>
                </div>
            </spring:bind>
            <button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
        </form:form>
    </div>
</body>
</html>
