<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	<h3 style="color: red">${err }</h3>
	<h3 style="color: red">${success }</h3>
	<section class="banner_area">
		<div class="banner_inner d-flex align-items-center">
			<div class="container">
				<div
					class="banner_content d-md-flex justify-content-between align-items-center">
					<div class="mb-3 mb-md-0">
						<h2>Kiểm tra thanh toán</h2>
					</div>
					<div class="page_link">
						<a href="user">Trang chủ</a> <a href="#">Kiểm tra thanh toán</a>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!--================End Home Banner Area =================-->

	<!--================Checkout Area =================-->
	<section class="checkout_area section_gap">
		<div class="container">
			<c:if test="${ user == null }">
				<div class="returning_customer">
					<div class="check_title">
						<h2>
							Vui lòng đăng nhập để thực hiện thanh toán <a href="loadLogin">Đăng
								nhập tại đây</a>
						</h2>
					</div>
				</div>
			</c:if>
			<c:if test="${ user != null }">
				<form:form class="row contact_form" action="insertOrders"
					method="post" modelAttribute="or" novalidate="novalidate">
					<div class="row">
						<div class="col-lg-6">
							<h3>Thông tin thanh toán</h3>
							<input type="hidden" value="${user.id }" name="userId" />
							<div class="col-md-12 form-group p_star">
								<form:input type="text" class="form-control"
									placeholder="Họ tên" path="userOr" />
							</div>
							<div class="col-md-12 form-group p_star">
								<form:input class="form-control" placeholder="Số điện thoại"
									id="number" type="tel" path="phonenumber" />
							</div>
							<div class="col-md-12 form-group p_star">
								<form:input type="text" class="form-control"
									placeholder="Tỉnh/thành phố" path="shippingAddress" />
							</div>
							<div class="col-md-12 form-group p_star">
								<form:input type="text" class="form-control"
									placeholder="Quận/huyện" path="shippingState" />
							</div>
							<div class="col-md-12 form-group p_star">
								<input type="text" class="form-control" placeholder="Phường/xã"
									path="shippingCity" />
							</div>
							<div class="col-md-12 form-group p_star">
								<form:input type="text" class="form-control"
									placeholder="Số nhà/thôn/.." path="shippingPincode" />
							</div>

						</div>
						<div class="col-lg-5">
							<div class="order_box">
								<h2>Đơn hàng của bạn</h2>
								<ul class="list">
									<li><a href="#">Sản phẩm <span>Tổng</span>
									</a></li>
									<c:forEach items="${listOrdetail }" var="o">
										<li><a href="#">${o.products.productName}<span
												class="middle">${o.quantity}</span> <span class="last"><fmt:formatNumber
														value="${o.totalPrice}" />VND</span>
										</a></li>
										<li></li>
									</c:forEach>
								</ul>
								<ul class="list list_2">
									<c:forEach items="${listOrdetail }" var="o">
									<li><a href="#">Phí ship: <span><fmt:formatNumber
														value="${o.products.shippingCharge}" />VND</span>
										</a></li>
										<li><a href="#">Tổng tiền <span><fmt:formatNumber
														value="${o.totalPrice}" />VND</span>
										</a></li>
										</c:forEach>
								</ul>
								<div class="payment_item">
									<div class="radion_btn">
										<form:radiobutton id="f-option5" path="paymentMethod" />
										<label for="f-option5"> Thanh toán khi nhận hàng:</label>
										<div class="check"></div>
										<div class="payment_item active">
											<div class="radion_btn">
												<form:radiobutton id="f-option6" path="paymentMethod" />
												<label for="f-option6">Paypal </label>
												<div class="check"></div>
											</div>
										</div>
									</div>
									<button type="submit" class="main_btn">Đặt hàng</button>
								</div>
							</div>

						</div>
					</div>
				</form:form>
			</c:if>
		</div>
	</section>
	<!--================End Checkout Area =================-->

	<!--================ start footer Area  =================-->
	<jsp:include page="footer.jsp"></jsp:include>
	<!--================ End footer Area  =================-->

	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<jsp:include page="import_javascript_user.jsp"></jsp:include>

	<script type="text/javascript">
		function formatMoney(money) {
			return money.toString().replace(/(\d)(?=(\d\d\d)+(?!\d))/g, "$1,");
		}
	</script>

</body>
</html>
