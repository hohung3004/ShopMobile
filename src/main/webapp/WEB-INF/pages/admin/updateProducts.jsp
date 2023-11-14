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
						<h6 class="mb-0">Update Products</h6>
						<a href="loadProducts"><button class="fa fa-undo me-2"></button></a>
					</div>
					<h3 style="color:red">${err }</h3>
					<div class="table-responsive">
					<form:form action="insertProducts" method="post" modelAttribute="p" >
						<table
							class="table text-start align-middle table-bordered table-hover mb-0">
								<tr class="text-white">
									<td>Id: </td>
									<td><form:input path="id"/></td>
								</tr>
								<tr class="text-white">
									<td>Category: </td>
									<td><form:select path="category.id">
										<form:options items="${listCate}" itemLabel="categoryName" itemValue="id"/>
									</form:select></td>
								</tr>
								<tr class="text-white">
									<td>Subcategory: </td>
									<td><form:select path="subcategory.id">
										<form:options items="${listSub}" itemLabel="subcategory" itemValue="id"/>
									</form:select></td>
								</tr>
								<tr class="text-white">
									<td>Product Name: </td>
									<td><form:input path="productName" /></td>
								</tr>
								<tr class="text-white">
									<td>Product Company: </td>
									<td><form:input path="productCompany" /></td>
								</tr>
								<tr class="text-white">
									<td>Product Price: </td>
									<td><form:input path="productPrice" /></td>
								</tr>
								<tr class="text-white">
									<td>Product Price Before Discount: </td>
									<td><form:input path="productPriceBeforeDiscount" /></td>
								</tr>
								<tr class="text-white">
									<td>Product Description: </td>
									<td><form:input path="productDescription" /></td>
								</tr>
								<tr class="text-white">
									<td>Shipping Charge: </td>
									<td><form:input path="shippingCharge" /></td>
								</tr>
								<tr class="text-white">
									<td>Product Availability: </td>
									<td><form:input path="productAvailability" /></td>
								</tr>
								<%-- <tr class="text-white">
									<td>Updation Date: </td>
									<td><form:input path="updationDate" /></td>
								</tr> --%>
								<tr class="text-white">
									<td>Product Image1: </td>
									<td><form:input type="file" path="productImage1" /></td>
								</tr>
								<tr class="text-white">
									<td>Product Image2: </td>
									<td><input type="file" name="productImage2" /></td>
								</tr>
								<tr class="text-white">
									<td>Product Image3: </td>
									<td><input type="file" name="productImage3" /></td>
								</tr> 
								<tr class="text-white">
									<td></td>
									<td><button type="submit" class="btn btn-primary">
									<font style="vertical-align: inherit;">Update</font></button>
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