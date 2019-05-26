<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Accommodation</title>
</head>
<body>
    <div class="container">

        <form:form method="POST" modelAttribute="accommodationForm" class="form-accommodation">
            <h2>Create the accommodation</h2>
            <spring:bind path="price">
                <div class="form-group">
                    <form:input path="price" type="number" step="0.01" placeholder="0.00"></form:input>
                </div>
            </spring:bind>
            <spring:bind path="location">
                <div class="form-group">
                    <form:select path="location">
                        <form:options items="${locations}" itemValue="id" itemLabel="city"></form:options>
                    </form:select>
                </div>
            </spring:bind>
            <spring:bind path="users">
                <div class="form-group">
                    <form:select path="users">
                        <form:options items="${users}" itemValue="id" itemLabel="email"></form:options>
                    </form:select>
                </div>
            </spring:bind>
            <button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
        </form:form>
    </div>
</body>
</html>
