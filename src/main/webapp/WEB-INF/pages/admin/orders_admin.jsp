<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ThuHa-Mobile</title>
<meta content="width=device-width, initial-scale=1.0" name="viewport">
<meta content="" name="keywords">
<meta content="" name="description">
<!-- Favicon - Import_css -->
<jsp:include page="import_css.jsp"></jsp:include>
</head>

<body>
	<div class="container-fluid position-relative d-flex p-0">
		<!-- Spinner Start -->
		
		<!-- Spinner End -->


		<!-- Sidebar Start -->
		<jsp:include page="slidebar.jsp"></jsp:include>
		<!-- Sidebar End -->


		<!-- Content Start -->
		<div class="content">
			<!-- Navbar Start -->
			<nav
				class="navbar navbar-expand bg-secondary navbar-dark sticky-top px-4 py-0">
				<form class="d-none d-md-flex ms-4">
					<input class="form-control bg-dark border-0" type="search"
						placeholder="Search">
				</form>
				<div class="navbar-nav align-items-center ms-auto">
					<div class="nav-item dropdown">
						<div
							class="dropdown-menu dropdown-menu-end bg-secondary border-0 rounded-0 rounded-bottom m-0">
						</div>
					</div>
					<div class="nav-item dropdown">
						<div
							class="dropdown-menu dropdown-menu-end bg-secondary border-0 rounded-0 rounded-bottom m-0">
						</div>
					</div>
					<div class="nav-item dropdown">
						<a href="#" class="nav-link dropdown-toggle"
							data-bs-toggle="dropdown"> <img
							class="rounded-circle me-lg-2" src="<c:url value="/resources/them1/img/user.jpg"/>"  alt=""
							style="width: 40px; height: 40px;"> <span
							class="d-none d-lg-inline-flex">ThuHa</span>
						</a>
						<div
							class="dropdown-menu dropdown-menu-end bg-secondary border-0 rounded-0 rounded-bottom m-0">
							<a href="#" class="dropdown-item">My Profile</a> <a href="#"
								class="dropdown-item">Settings</a> <a href="#"
								class="dropdown-item">Log Out</a>
						</div>
					</div>
				</div>
			</nav>
			<!-- Navbar End -->


			<!-- Recent Sales Start -->
			<div class="container-fluid pt-4 px-4">
				<div class="bg-secondary text-center rounded p-4">
					<div class="d-flex align-items-center justify-content-between mb-4">
						<h6 class="mb-0">Quản lý đơn hàng</h6>
					</div>
					<div class="table-responsive">
						<table
							class="table text-start align-middle table-bordered table-hover mb-0">
							<thead>
								<tr class="text-white">
									<th scope="col">Id</th>
									<th scope="col">User id</th>
									<th scope="col">User Order</th>
									<th scope="col">PhoneNumber</th>
									<th scope="col">Quantity</th>
									<th scope="col">Total Price</th>
									<th scope="col">Payment method</th>
									<th scope="col">Shipping Address</th>
									
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${list }" var="s">
									<tr>
										<td>${s.id }</td>
										<td>${s.users.id }</td>
										<td>${s.userOr }</td>
										<td>${s.phonenumber }</td>
										<td>${s.quantity }</td>
										<td><fmt:formatNumber value="${s.totalPrice }"/>VND</td>
										<td>${s.paymentMethod}</td>
										<td>${s.shippingAddress},${s.shippingState},${s.shippingCity},${s.shippingPincode}</td>
									</tr>
								</c:forEach>
							</tbody>
						 </table>
                    </div>
                </div>
            </div>
            <!-- Recent Sales End -->
        </div>
        <!-- Content End -->


        <!-- Back to Top -->
        <a href="#" class="btn btn-lg btn-primary btn-lg-square back-to-top"><i class="bi bi-arrow-up"></i></a>
    </div>

    <!-- JavaScript Libraries -->
    <jsp:include page="import_javascript.jsp"></jsp:include>
    
    <script type="text/javascript">
  function formatMoney(money)
  {
     return money.toString().replace(/(\d)(?=(\d\d\d)+(?!\d))/g, "$1,");
  }
</script>
</body>
</html>