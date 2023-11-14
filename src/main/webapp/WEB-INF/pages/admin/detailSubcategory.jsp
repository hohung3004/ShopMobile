<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
			<jsp:include page="navbar.jsp"></jsp:include>
			<!-- Navbar End -->
	
			<!--Add Category Start-->
	<div class="container-fluid pt-4 px-4">
				<div class="bg-secondary text-center rounded p-4">
					<div class="d-flex align-items-center justify-content-between mb-4">
						<h6 class="mb-0">Chi tiết danh mục phụ</h6>
						<a href="loadSubcategory"><button class="fa fa-undo me-2"></button></a>
					</div>
					<div class="table-responsive">
						<table
							class="table text-start align-middle table-bordered table-hover mb-0">
								<tr class="text-white">
									<td>Id: </td>
									<td>${s.id }</td>
								</tr>
								<tr class="text-white">
									<td>Category: </td>
									<td>${s.category.categoryName }</td>
								</tr>
								<tr class="text-white">
									<td>Subcategory: </td>
									<td>${s.subcategory } </td>
								</tr>
								<tr class="text-white">
									<td>Posting Date: </td>
									<td>${s.postingDate }</td>
								</tr>
						 </table>
                    </div>
                </div>
            </div>
        </div>
        <!--Add Category End-->
        <!-- Content End -->


        <!-- Back to Top -->
        <a href="#" class="btn btn-lg btn-primary btn-lg-square back-to-top"><i class="bi bi-arrow-up"></i></a>
    </div>

    <!-- JavaScript Libraries -->
    <jsp:include page="import_javascript.jsp"></jsp:include>
</body>
</html>