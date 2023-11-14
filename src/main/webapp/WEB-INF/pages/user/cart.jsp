<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<link rel="icon" href="img/favicon.png" type="image/png" />
<title>ThuHa-Mobile</title>
<!-- Bootstrap CSS -->
<jsp:include page="import_css_user.jsp"></jsp:include>
</head>

<body>
	<!--================Header Menu Area =================-->
	<jsp:include page="header.jsp"></jsp:include>
	<!--================Header Menu Area =================-->

	<!--================Home Banner Area =================-->
	<section class="banner_area">
		<div class="banner_inner d-flex align-items-center">
			<div class="container">
				<div
					class="banner_content d-md-flex justify-content-between align-items-center">
					<div class="mb-3 mb-md-0">
						<h2>Giỏ hàng</h2>
					</div>
					<div class="page_link">
						<a href="user">Trang chủ</a> <a href="#">Giỏ hàng</a>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!--================End Home Banner Area =================-->

	<!--================Cart Area =================-->
	<h3 style="color: green">${success }</h3>
	<h3 style="color: red">${err }</h3>
	<section class="cart_area">
		<div class="container">
			<div class="cart_inner">
				<div class="table-responsive">
					<table class="table">
						<thead>
							<tr>
								<th scope="col">Sản phẩm:</th>
								<th scope="col">Giá</th>
								<th scope="col">Số lượng</th>
								<th scope="col">Thành tiền</th>
								<th scope="col">Hoạt động</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${listOrdetail }" var="o">
								<tr>
									<td>
										<div class="media">
											<div class="d-flex">
												<img
													src="<c:url value="resources/them1"/>/img/${o.products.productImage1}"
													width="150px" height="150px" alt="" />
											</div>
											<div class="media-body">
												<p>${o.products.productName}</p>
											</div>
										</div>
									</td>
									<td>
									<fmt:formatNumber value="${o.products.productPriceBeforeDiscount}" type="currency" currencySymbol=""/>VND
									
									</td>
									<td>
										<div class="product_count">
											<input type="text" name="${o.quantity}"
												id="sst-${o.products.id}" maxlength="12"
												value="${o.quantity}" title="Quantity:"
												class="input-text qty" />
											<button
												onclick="var result = document.getElementById('sst-${o.products.id}'); var sst = result.value; if( !isNaN( sst-${o.products.id} )) result.value++;return false;"
												class="increase items-count" type="button">
												<i class="lnr lnr-chevron-up"></i>
											</button>
											<button
												onclick="var result = document.getElementById('sst-${o.products.id}'); var sst = result.value; if( !isNaN( sst-${o.products.id} ) &amp;&amp; sst > 0 ) result.value--;return false;"
												class="reduced items-count" type="button">
												<i class="lnr lnr-chevron-down"></i>
											</button>
										</div>
									</td>
									<td>
										<h5><fmt:formatNumber value="${o.totalPrice}"/>VND</h5>
									</td>
									<td><a href="deleteProductToCart?id=${o.products.id }" onclick="return confirm('Sure?')">Xóa
											sản phẩm</a></td>
								</tr>
							</c:forEach>
							<tr class="out_button_area">
								<td></td>
								<td></td>
								<td></td>
								<td>
									<div class="checkout_btn_inner">
										<a class="gray_btn" href="user">Tiếp tục mua sắm</a> <a
											class="main_btn" href="initInsertOrders">Thanh toán</a>
									</div>
								</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</section>
	<!--================End Cart Area =================-->

	<!--================ start footer Area  =================-->
	<jsp:include page="footer.jsp"></jsp:include>
	<!--================ End footer Area  =================-->

	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<jsp:include page="import_javascript_user.jsp"></jsp:include>

	<script type="text/javascript">
  function formatMoney(money)
  {
     return money.toString().replace(/(\d)(?=(\d\d\d)+(?!\d))/g, "$1,");
  }
</script>
</body>
</html>
