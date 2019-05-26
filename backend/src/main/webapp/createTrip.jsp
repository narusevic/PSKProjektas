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

        <form:form method="POST" modelAttribute="tripForm" class="form-trip">
            <h2 class="form-trip-heading">Create Trip</h2>
            <spring:bind path="departureTime">
                <div class="form-group">
                    <form:input type="date" path="departureTime" class="form-control" placeholder="Departure" autofocus="true"></form:input>
                </div>
            </spring:bind>
            <spring:bind path="arrivalTime">
                <div class="form-group">
                    <form:input type="date" path="arrivalTime" class="form-control" placeholder="Arrival"></form:input>
                </div>
            </spring:bind>
             <spring:bind path="startPlace">
                <div class="form-group">
                    <form:select path="startPlace">
                        <form:options items="${locations}" itemValue="id" itemLabel="city"></form:options>
                    </form:select>
                </div>
            </spring:bind>
            <spring:bind path="destination">
                <div class="form-group">
                    <form:select path="destination">
                        <form:options items="${locations}" itemValue="id" itemLabel="city"></form:options>
                    </form:select>
                </div>
            </spring:bind>
            <spring:bind path="status">
                <form:select path="status" items="${statuses}" />
            </spring:bind>

            <button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
        </form:form>

    </div>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="${contextPath}/resources/js/bootstrap.min.js"></script>
  </body>
</html>