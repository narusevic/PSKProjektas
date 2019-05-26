<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create amenity</title>
</head>
<body>
    <div class="container">
        <form:form method="POST" modelAttribute="amenityForm" class="form-create">
            <h2 class="form-heading">Register the amenity</h2>
            <spring:bind path="name">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <form:input path="name" type="text" class="form-control" placeholder="Name" autofocus="true"></form:input>
                    <form:errors path="name"></form:errors>
                </div>
            </spring:bind>
            <spring:bind path="description">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <form:input path="description" type="text" class="form-control" placeholder="Description"></form:input>
                    <form:errors path="description"></form:errors>
                </div>
            </spring:bind>
            <button class="btn btn-lg" type="submit">Submit</button>
        </form:form>
    </div>
</body>
</html>
