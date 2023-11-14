<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<title>ThuHa-Mobile</title>
<meta content="width=device-width, initial-scale=1.0" name="viewport">
<meta content="" name="keywords">
<meta content="" name="description">

<!-- Favicon - Import_css -->
<jsp:include page="import_css.jsp"></jsp:include>
</head>

<body>
	<div class="container-fluid position-relative d-flex p-0">


		<!-- Sidebar Start -->
		<jsp:include page="slidebar.jsp"></jsp:include>
		<!-- Sidebar End -->


		<!-- Content Start -->
		<div class="content">
			<!-- Navbar Start -->
			<nav
				class="navbar navbar-expand bg-secondary navbar-dark sticky-top px-4 py-0">
				<form action="searchProductsByName" class="d-none d-md-flex ms-4">
				<b>Products Name: </b>
					<input class="form-control bg-dark border-0" type="search"
						placeholder="Search" name="productName">
						<button type="submit" class="btn btn-primary">
									<font style="vertical-align: inherit;">Search</font></button>
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
							class="rounded-circle me-lg-2" src="<c:url value="/resources/them1/img/user.jpg"/>" alt=""
							style="width: 40px; height: 40px;"> <span
							class="d-none d-lg-inline-flex">ThuHa</span>
						</a>
						<div
							class="dropdown-menu dropdown-menu-end bg-secondary border-0 rounded-0 rounded-bottom m-0">
							 <a href="logoutAdmin" class="dropdown-item">Log Out</a>
						</div>
					</div>
				</div>
			</nav>
			<!-- Navbar End -->


			<!-- Recent Sales Start -->
			<div class="container-fluid pt-4 px-4">
				<div class="bg-secondary text-center rounded p-4">
					<div class="d-flex align-items-center justify-content-between mb-4">
						<h6 class="mb-0">Products</h6>
						<a href="initInsertProducts"><button class="fa fa-plus me-2"></button></a>
					</div>
					<div class="table-responsive">
					<h3 style="color:green">${success }</h3>
					<h3 style="color:red">${err }</h3>
						<table
							class="table text-start align-middle table-bordered table-hover mb-0">
							<thead>
								<tr class="text-white">
									<th scope="col">Id</th>
									<th scope="col">Product Name</th>
									<th scope="col">Category</th>
									<th scope="col">Subcategory</th>
									<th scope="col">Product Company</th>
									<th scope="col">Posting Date</th>
									<th scope="col">Updation Date</th>
									<th scope="col">Activate</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${list }" var="s">
									<tr>
										<td>${s.id }</td>
										<td>${s.productName }</td>
										<td>${s.category.categoryName }</td>
										<td>${s.subcategory.subcategory }</td>
										<td>${s.productCompany }</td>
										<td>${s.postingDate }</td>
										<td>${s.updationDate}</td>
										<td><a href="detailProducts?id=${s.id }"><button class="fa fa-eye me-2"></button></a>
											<a href="initUpdateProducts?id=${s.id }"><button class="fa fa-edit me-2"></button></a>
											<a href="deleteProducts?id=${s.id }" onclick="return confirm('Sure?')"><button class="fa fa-trash me-2"></button></a>
										</td>
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
</body>

</html>