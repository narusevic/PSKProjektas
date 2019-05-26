<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register room of DevBridge apartment</title>
</head>
<body>
    <div class="container">
        <form:form method="POST" modelAttribute="roomForm" class="form-create">
            <h2 class="form-heading">Register the room</h2>
            <spring:bind path="number">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <form:input path="number" type="number" class="form-control" placeholder="Number" autofocus="true"></form:input>
                    <form:errors path="number"></form:errors>
                </div>
            </spring:bind>
            <spring:bind path="location">
                <form:select path="location">
                    <form:options items="${locations}" itemValue="id" itemLabel="city"></form:options>
                </form:select>
            </spring:bind>
            <button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
        </form:form>
    </div>
</body>
</html>
