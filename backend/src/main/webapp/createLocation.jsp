<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Create location</title>
</head>
<body>
    <div class="container">
        <form:form method="POST" modelAttribute="locationForm" class="form-create">
            <h2 class="form-heading">Register the location</h2>
                <spring:bind path="city">
                    <div class="form-group ${status.error ? 'has-error':''}">
                    <form:input path="city" type="text" class="form-control" placeholder="City" autofocus="true"></form:input>
                    <form:errors path="city"></form:errors>
                </div>
                </spring:bind>
            <spring:bind path="country">
                <div path="form-group ${status.error ? 'has-error' : ''}">
                    <form:input path="country" type="text" class="form-control" placeholder="Country"></form:input>
                    <form:errors path="country"></form:errors>
                </div>
            </spring:bind>
            <spring:bind path="devBridge">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    Does DevBridge have office in this city?<form:checkbox path="devBridge" class="form-control"></form:checkbox>
                </div>
            </spring:bind>
                <button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
        </form:form>
    </div>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>