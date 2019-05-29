<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
  <head>
      <meta charset="utf-8">
      <title>Create trip</title>

      <!-- Custom fonts for this template-->
      <link href="${contextPath}/resources/vendor/fontawesome-free/css/all.css" rel="stylesheet" type="text/css">

      <!-- Page level plugin CSS-->
      <link href="${contextPath}/resources/vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet">

      <!-- Custom styles for this template-->
      <link href="${contextPath}/resources/css/sb-admin.css" rel="stylesheet">

      <!-- Custom styles for table -->
      <link href="${contextPath}/resources/css/custom.css" rel="stylesheet">

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
                        <a href="#">Organiser</a>
                    </li>
                    <li class="breadcrumb-item active">Trip Info</li>
                </ol>

                <div class="card mb-3">
                    <div class="card-header">
                        <i class="fas fa-table"></i>
                        Detailed Info</div>
                    <div class="card-body">
                        <ol class="breadcrumb">
                            <li class="breadcrumb-item active">From</li>
                        </ol>
                        ${trip.startPlace.getCity()}
                        <ol class="breadcrumb">
                            <li class="breadcrumb-item active">To</li>
                        </ol>
                        ${trip.destination.getCity()}
                        <ol class="breadcrumb">
                            <li class="breadcrumb-item active">Description</li>
                        </ol>
                            ${trip.description}
                        <ol class="breadcrumb">
                            <li class="breadcrumb-item active">Departure time</li>
                        </ol>
                            ${trip.departureTime}
                        <ol class="breadcrumb">
                            <li class="breadcrumb-item active">Arrival Time</li>
                        </ol>
                            ${trip.arrivalTime}
                        <ol class="breadcrumb">
                            <li class="breadcrumb-item active">Status</li>
                        </ol>
                            ${trip.status} 
                        <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                            <thead>
                            <tr>
                                <th>From City</th>
                                <th>To City</th>
                                <th>Departure Time</th>
                                <th>Arrival Time</th>
                                <th></th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="route" items="${trip.getRoutes()}">
                                <tr>
                                    <td>${route.getFrom()}</td>
                                    <td>${route.getTo()}</td>
                                    <td>${route.getDepartureTime()}</td>
                                    <td>${trip.getArrivalTime()}</td>
                                    <td><a href="${contextPath}/route/${route.getId()}" class="btn btn-outline-primary">Show route info</a></td>
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
    </body>
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
</html>
