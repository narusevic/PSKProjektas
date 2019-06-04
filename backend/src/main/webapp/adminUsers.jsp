<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="WEB-INF/custom.tld"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Users</title>



    <!-- Add icon library -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

    <!-- Custom fonts for this template-->
    <link href="${contextPath}/resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">

    <!-- Page level plugin CSS-->
    <link href="${contextPath}/resources/vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="${contextPath}/resources/css/sb-admin.css" rel="stylesheet">

    <style>
        .btn {
            background-color: DodgerBlue;
            border: none;
            color: white;
            padding: 12px 16px;
            font-size: 16px;
            cursor: pointer;
        }

        /* Darker background on mouse-over */
        .btn:hover {
            background-color: RoyalBlue;
        }
    </style>
</head>
<body id="page-top">

<nav class="navbar navbar-expand navbar-dark bg-dark static-top">

    <form class="d-none d-md-inline-block form-inline ml-auto mr-0 mr-md-3 my-2 my-md-0">
        <h2 style="color: ghostwhite;">${pageContext.request.userPrincipal.name}</h2>
    </form>

    <!-- Navbar -->
    <ul class="navbar-nav ml-auto ml-md-0">
        <li class="nav-item dropdown no-arrow">
            <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                <i class="fas fa-user-circle fa-fw"></i>
            </a>
            <div class="dropdown-menu dropdown-menu-right" aria-labelledby="userDropdown">
                <a class="dropdown-item" href="#" data-toggle="modal" data-target="#logoutModal">Logout</a>
            </div>
        </li>
    </ul>

</nav>

<div id="wrapper">

    <!-- Sidebar -->
    <ul class="sidebar navbar-nav">
        <li class="nav-item active">
            <a class="nav-link" href="${contextPath}/admin/user">
                <span>Users</span></a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="${contextPath}/route">
                Routes</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="${contextPath}/trip/">
                <span>Trips</span>
            </a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="${contextPath}/trip/create">
                <span>Create Trip</span>
            </a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="${contextPath}/trip/my">
                <span>My Trips</span>
            </a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="${contextPath}/amenity/create">
                <span>Create Amenity</span>
            </a>
        </li>
    </ul>

    <div id="content-wrapper">

        <div class="container">
            <div class="card mb-3">
                <div class="card-header">Invite User</div>
                <div class="card-body">

                    <form:form method="POST" action="${contextPath}/admin/invitation" class="form-signin">
                        <div class="form-label-group">
                            <input name="email" type="email" id="inputEmail" class="form-control" placeholder="Email address" required="required" autofocus="true">
                            <label for="inputEmail">Email Address</label>
                        </div>
                        <br/>
                        <button class="btn btn-lg btn-primary btn-block" type="submit">Invite</button>
                    </form:form>
                </div>
            </div>
        </div>
        <br/>

        <div class="container-fluid">

             <!--DataTables Example-->
            <div class="card mb-3">
                <div class="card-header">
                    <i class="fas fa-table"></i>
                    Invited Users</div>
                <div class="card-body">
                    <div class="table-responsive">
                        <table class="table table-bordered" id="dataTable1" width="100%" cellspacing="0">
                            <thead>
                            <tr>
                                <th>Email Address</th>
                                <th>Cancel Invitation</th>
                            </tr>
                            </thead>
                            <tfoot>
                            <tr>
                                <th>Email Address</th>
                                <th>Cancel Invitation</th>
                            </tr>
                            </tfoot>
                            <tbody>

                            <c:forEach var="invitation" items="${invitations}">
                                <tr>
                                    <td>${invitation.email}</td>
                                    <td>
                                        <form:form action="${contextPath}/admin/invitation/${invitation.id}" method="POST">
                                            <button class="btn" type="submit">
                                                <i class="fa fa-close"></i>
                                            </button>
                                        </form:form>
                                    </td>
                                </tr>
                            </c:forEach>

                            </tbody>
                        </table>
                    </div>
                </div>
            </div>

        </div>


        <div class="container-fluid">

            <!--DataTables Example-->
            <div class="card mb-3">
                <div class="card-header">
                    <i class="fas fa-table"></i>
                    User List</div>
                <div class="card-body">
                    <div class="table-responsive">
                        <table class="table table-bordered" id="dataTable2" width="100%" cellspacing="0">
                            <thead>
                            <tr>
                                <th>Email Address</th>
                                <th>Set as an organizer</th>
                                <th>Is Organizer</th>
                                <th>Delete user</th>
                            </tr>
                            </thead>
                            <tfoot>
                            <tr>
                                <th>Email Address</th>
                                <th>Set as an organizer</th>
                                <th>Is Organizer</th>
                                <th>Delete user</th>
                            </tr>
                            </tfoot>
                            <tbody>

                            <c:forEach var="user" items="${users}">
                                <tr>
                                    <td>${user.email}</td>
                                    <td>
                                        <form:form action="${contextPath}/admin/changeOrganizer/${user.id}" method="POST">
                                            <button class="btn btn-lg btn-primary btn-block" type="submit">Change organizer role</button>
                                        </form:form>
                                    </td>
                                    <td>
                                        ${fn:containsRole(user.getRoles(), "ORGANIZER")}
                                    </td>
                                    <td>
                                        <form:form action="${contextPath}/admin/user/${user.id}" method="POST">
                                            <button class="btn" type="submit">
                                                <i class="fa fa-close"></i>
                                            </button>
                                        </form:form>
                                    </td>
                                </tr>
                            </c:forEach>

                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>

         <!--Sticky Footer-->
        <footer class="sticky-footer">
            <div class="container my-auto">
                <div class="copyright text-center my-auto">
                </div>
            </div>
        </footer>

    </div>
     <!--/.content-wrapper-->

</div>
 <!--/#wrapper-->

 <!--Scroll to Top Button-->
<a class="scroll-to-top rounded" href="#page-top">
    <i class="fas fa-angle-up"></i>
</a>

 <!--Logout Modal-->
<div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
                <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">×</span>
                </button>
            </div>
            <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
            <div class="modal-footer">
                <c:if test="${pageContext.request.userPrincipal.name != null}">
                    <form id="logoutForm" method="POST" action="${contextPath}/logout">
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                    </form>
                    <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                    <a class="btn btn-primary" onclick="document.forms['logoutForm'].submit()">Logout</a>
                </c:if>
            </div>
        </div>
    </div>
</div>

<!-- Bootstrap core JavaScript-->
<script src="${contextPath}/resources/vendor/jquery/jquery.min.js"></script>
<script src="${contextPath}/resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

<!-- Core plugin JavaScript-->
<script src="${contextPath}/resources/vendor/jquery-easing/jquery.easing.min.js"></script>

<!-- Page level plugin JavaScript-->
<script src="${contextPath}/resources/vendor/datatables/jquery.dataTables.js"></script>
<script src="${contextPath}/resources/vendor/datatables/dataTables.bootstrap4.js"></script>

<!-- Custom scripts for all pages-->
<script src="${contextPath}/resources/js/sb-admin.min.js"></script>

<!-- Demo scripts for this page-->
<script src="${contextPath}/resources/js/demo/datatables-demo.js"></script>
</body>
</html>
