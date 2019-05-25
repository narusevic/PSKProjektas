
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <title>Admin</title>
    </head>

    <body>

        <form:form method="POST" action="${contextPath}/admin/invitation" modelAttribute="invitationForm" class="form-route">
            <h2 class="form-trip-heading">Invite user</h2>
            <spring:bind path="email">
                <div class="form-group">
                    <form:input type="text" path="email" class="form-control" placeholder="Email" autofocus="true"></form:input>
                </div>
            </spring:bind>

            <button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
        </form:form>

        <c:forEach var="invitation" items="${invitations}">
            <div>${invitation.email}</div>
            <form:form action="${contextPath}/admin/invitation/${invitation.id}" method="POST">
                <input type="submit" value="Delete invitation"/>
            </form:form>
        </c:forEach>

        <div>--</div>

        <c:forEach var="user" items="${users}">
            <div>${user.email}</div>
            <div>Roles: ${user.getRoles()}</div>
            <form:form action="${contextPath}/admin/changeOrganizer/${user.id}" method="POST">
                <input type="submit" value="Change organizer role"/>
            </form:form>
            <form:form action="${contextPath}/admin/user/${user.id}" method="POST">
                <input type="submit" value="Delete User"/>
            </form:form>
            <div>-------------------------------------------------------------------------------------------------------------</div>
        </c:forEach>



        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
        <script src="${contextPath}/resources/js/bootstrap.min.js"></script>
    </body>
</html>