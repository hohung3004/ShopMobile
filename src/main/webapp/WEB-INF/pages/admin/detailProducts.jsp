<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
			<jsp:include page="navbar.jsp"></jsp:include>
			<!-- Navbar End -->
	
			<!--Add Category Start-->
	<div class="container-fluid pt-4 px-4">
				<div class="bg-secondary text-center rounded p-4">
					<div class="d-flex align-items-center justify-content-between mb-4">
						<h6 class="mb-0">Chi tiết sản phẩm</h6>
						<a href="loadProducts"><button class="fa fa-undo me-2"></button></a>
					</div>
					<div class="table-responsive">
						<table
							class="table text-start align-middle table-bordered table-hover mb-0">
								<tr class="text-white">
									<td>Id: </td>
									<td>${p.id }</td>
								</tr>
								<tr class="text-white">
									<td>Category: </td>
									<td>${p.category.categoryName }</td>
								</tr>
								<tr class="text-white">
									<td>Subcategory: </td>
									<td>${p.subcategory.subcategory }</td>
								</tr>
								<tr class="text-white">
									<td>Product Name: </td>
									<td>${p.productName }</td>
								</tr>
								<tr class="text-white">
									<td>Product Company: </td>
									<td>${p.productCompany }</td>
								</tr>
								<tr class="text-white">
									<td>Product Price: </td>
									<td><fmt:formatNumber value="${p.productPrice }"/>VND</td>
								</tr>
								<tr class="text-white">
									<td>Product Price Before Discount: </td>
									<td><fmt:formatNumber value="${p.productPriceBeforeDiscount }"/>VND</td>
								</tr>
								<tr class="text-white">
									<td>Product Description: </td>
									<td>${p.productDescription }</td>
								</tr>
								<tr class="text-white">
									<td>Shipping Charge: </td>
									<td>${p.shippingCharge }</td>
								</tr>
								<tr class="text-white">
									<td>Product Availability: </td>
									<td>${p.productAvailability }</td>
								</tr>
								<tr class="text-white">
									<td>Posting Date: </td>
									<td>${p.postingDate }</td>
								</tr>
								<tr class="text-white">
									<td>Product Image1: </td>
									<td>
										<img alt="${p.productImage1 }" src="<c:url value="resources/them1"/>/img/${p.productImage1}" >
									</td>
								</tr>
								<tr class="text-white">
									<td>Product Image2: </td>
									<td>
										<img alt="${p.productImage2 }" src="<c:url value="resources/them1"/>/img/${p.productImage2}" >
									</td>
								</tr>
								<tr class="text-white">
									<td>Product Image3: </td>
									<td>
										<img alt="${p.productImage3 }" src="<c:url value="resources/them1"/>/img/${p.productImage3}" >
									</td>
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
    
    <script type="text/javascript">
  function formatMoney(money)
  {
     return money.toString().replace(/(\d)(?=(\d\d\d)+(?!\d))/g, "$1,");
  }
</script>
</body>
</html>