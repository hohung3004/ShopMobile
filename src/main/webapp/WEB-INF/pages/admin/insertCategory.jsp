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
						<h6 class="mb-0">Insert Category</h6>
						<a href="loadCategory"><button class="fa fa-undo me-2"></button></a>
					</div>
					<h3 style="color:red">${err }</h3>
					<div class="table-responsive">
					<form:form action="insertCategory" method="post" modelAttribute="c">
						<table
							class="table text-start align-middle table-bordered table-hover mb-0">
								<tr class="text-white">
									<td>Category Name: </td>
									<td><form:input path="categoryName"/></td>
								</tr>
								<tr class="text-white">
									<td>Category Description: </td>
									<td><form:textarea rows="5" cols="35" path="categoryDescription" /></td>
								</tr>
								<tr class="text-white">
									<td>Posting Date: </td>
									<td><form:input path="postingDate" type="date"/></td>
								</tr>
								<tr class="text-white">
									<td></td>
									<td><button type="submit" class="btn btn-primary">
									<font style="vertical-align: inherit;">Insert</font></button>
									<button type="reset" class="btn btn-primary">
									<font style="vertical-align: inherit;">Clear</font></button></td>
								</tr>
						 </table>
						 </form:form>
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