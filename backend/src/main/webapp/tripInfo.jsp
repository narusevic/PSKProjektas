<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>View Full Trip Info</title>

    <!-- Custom fonts for this template-->
    <link href="${contextPath}/resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">

    <!-- Custom styles for this template-->
    <link href="${contextPath}/resources/css/sb-admin.css" rel="stylesheet">
</head>
    <body>
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
                <li class="nav-item">
                    <a class="nav-link" href="${contextPath}/trip/create">
                        Create Trip
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${contextPath}/route/create">
                        Create Route</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${contextPath}/trip/">
                        My Trips
                    </a>
                </li>
            </ul>

            <div id="content-wrapper">

                <div class="container-fluid">

                    <!-- Breadcrumbs-->
                    <ol class="breadcrumb">
                        <li class="breadcrumb-item">
                            <a href="">Organiser</a>
                        </li>
                        <li class="breadcrumb-item active">Trip Info</li>
                    </ol>

                    <!-- DataTables Example -->
                    <div class="card mb-3">
                        <div class="card-header">
                            <i class="fas fa-table"></i>
                            All trips</div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                    <thead>
                                    <tr>
                                        <th>From</th>
                                        <th>To</th>
                                        <th>Description</th>
                                        <th>Departure Time</th>
                                        <th>Arrival Time</th>
                                        <th>Status</th>
                                        <th></th>
                                        <th></th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach var="trip" items="${trips}">
                                        <tr>
                                            <td>${trip.startPlace.getCity()}</td>
                                            <td>${trip.destination.getCity()}</td>
                                            <td>${trip.description}</td>
                                            <td>${trip.departureTime}</td>
                                            <td>${trip.arrivalTime}</td>
                                            <td>${trip.status}</td>
                                            <td><a href="${contextPath}/route/create/${trip.id}" class="btn btn-outline-primary">Create route for trip</a></td>
                                            <td><a href="${contextPath}/tripInfo/${trip.id}" class="btn btn-outline-info"><span class="glyphicon glyphicon-info-sign">Full info</span></a></td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
        <script src="${contextPath}/resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

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
