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

    <title>Welcome</title>

    <!-- Custom fonts for this template-->
    <link href="${contextPath}/resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">

    <!-- Page level plugin CSS-->
    <link href="${contextPath}/resources/vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="${contextPath}/resources/css/sb-admin.css" rel="stylesheet">

    <style>
        .container-fluid {
            margin: 0;
            padding: 0;
            width: 100%;
            height:  100vh;
            background: url(https://www.bearchitecture.com/wp-content/uploads/2017/04/Feature_larger-image-1.jpg) 50% 50% no-repeat;
            background-size: cover;
            display: table;
        }        h1 {
                     color: white;
                     font-family: "Source Sans Pro";
                     font-weight: 300;
                     font-size: 500%;
                     text-transform: uppercase;
                     margin-bottom: 0;
                     text-align: center;
                 }
        p {
            color: white;
            font-family: "Source Sans Pro";
            font-weight: lighter;
            text-transform: uppercase;
            letter-spacing: 15px;
            font-size: 20px;
            text-align: center;
            margin-top: 10px;
        }

        @media (max-width: 768px) {
            h1 {
                font-size: 300%;
            }
            p {
                font-size: 17px;
                letter-spacing: 10px;
            }
        }
    </style>

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
    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <form id="logoutForm" method="POST" action="${contextPath}/logout">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>
    <!-- Sidebar -->
    <ul class="sidebar navbar-nav">
        <li class="nav-item">
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


           <%--<h4 class="text-center"><a href="${contextPath}/amenity/create">Register an amenity (service)</a></h4>--%>
        <%--<h4 class="text-center"><a href="${contextPath}/accommodation/create">Register an accommodation fact</a></h4>--%>
        <%--<h4 class="text-center"><a href="${contextPath}/amenityItem/create">Register an amenity item</a></h4>--%>

    </ul>

    <div id="content-wrapper">

        <div class="container-fluid">

            <!-- Page Content -->
            <br/>
            <br/>
            <br/>
            <br/>
            <br/>
            <br/>
            <br/>
            <br/>
            <br/>
            <h1>DevBridge</h1>
            <p>Welcome</p>

        </div>
        <br/>
        <!-- /.container-fluid -->

        <!-- Sticky Footer -->
        <footer class="sticky-footer">
            <div class="container my-auto">
                <div class="copyright text-center my-auto">
                </div>
            </div>
        </footer>

    </div>
    <!-- /.content-wrapper -->
    </c:if>
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
