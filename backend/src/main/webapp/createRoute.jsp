<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Create route</title>



    <!-- Add icon library -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

    <!-- Custom fonts for this template-->
    <link href="${contextPath}/resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">

    <!-- Page level plugin CSS-->
    <link href="${contextPath}/resources/vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="${contextPath}/resources/css/sb-admin.css" rel="stylesheet">

</head>

<body id="page-top">

<nav class="navbar navbar-expand navbar-dark bg-dark static-top">

    <!-- Navbar Search -->

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
        <li class="nav-item">
            <a class="nav-link" href="${contextPath}/trip/create">
                <span>Create Trip</span>
            </a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="${contextPath}/trip/">
                <span>Trip List</span>
            </a>
        </li>
        <li class="nav-item active">
            <a class="nav-link" href="${contextPath}/route/create">
                <span>Create Route</span></a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="${contextPath}/admin/user">
                <span>Users</span></a>
        </li>
    </ul>

    <div id="content-wrapper">

        <div class="container">
            <div class="card mb-3">
                <div class="card-header">Create a route</div>
                <div class="card-body">
                    <form:form method="POST" modelAttribute="routeForm" class="form-signin">
                        <spring:bind path="departureTime">
                            <div class="form-label-group">
                                <form:input type="date" path="departureTime" class="form-control" placeholder="Departure" autofocus="true"></form:input>
                                <label for="inputEmail">Departure Date</label>
                            </div>
                        </spring:bind>
                        <br/>
                        <br/>
                        <spring:bind path="arrivalTime">
                            <div class="form-label-group">
                                <form:input type="date" path="arrivalTime" class="form-control" placeholder="Arrival" autofocus="true"></form:input>
                                <label for="inputEmail">Arrival Date</label>
                            </div>
                        </spring:bind>
                        <br/>
                        <br/>
                        <ol class="breadcrumb">
                            <li class="breadcrumb-item active">From</li>
                        </ol>
                        <spring:bind path="from">
                            <div>
                                <form:select path="from" class="form-control">
                                    <form:options items="${locations}" itemValue="id" itemLabel="city"></form:options>
                                </form:select>
                            </div>
                        </spring:bind>
                        <br/>
                        <br/>
                        <ol class="breadcrumb">
                            <li class="breadcrumb-item active">To</li>
                        </ol>
                        <spring:bind path="to">
                            <div>
                                <form:select path="to" class="form-control">
                                    <form:options items="${locations}" itemValue="id" itemLabel="city"></form:options>
                                </form:select>
                            </div>
                        </spring:bind>
                        <br/>
                        <br/>
                        <button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
                    </form:form>
                </div>
            </div>
        </div>
        <br/>

        <!-- Sticky Footer -->
        <footer class="sticky-footer">
            <div class="container my-auto">
                <div class="copyright text-center my-auto">
                </div>
            </div>
        </footer>

    </div>
    <!-- /.content-wrapper -->

</div>
<!-- /#wrapper -->

<!-- Scroll to Top Button-->
<a class="scroll-to-top rounded" href="#page-top">
    <i class="fas fa-angle-up"></i>
</a>

<!-- Logout Modal-->
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
                <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                <a class="btn btn-primary" href="login.html">Logout</a>
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


