<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">

<head>
  <!-- Required meta tags -->
  <meta charset="utf-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
  <link rel="icon" href="img/favicon.png" type="image/png" />
  <title>ThuHa-Mobile</title>
  <!-- Bootstrap CSS -->
  <!-- main css -->
	<jsp:include page="import_css_user.jsp"></jsp:include>
</head>

<body>
  <!--================Header Menu Area =================-->
 <jsp:include page="header.jsp"></jsp:include>
  <!--================Header Menu Area =================-->

  <!--================Home Banner Area =================-->
  <section class="home_banner_area mb-40">
    <div class="banner_inner d-flex align-items-center">
      <div class="container">
        <div class="banner_content row">
        </div>
      </div>
    </div>
  </section>
  <!--================End Home Banner Area =================-->

  <!-- Start feature Area -->
  <section class="feature-area section_gap_bottom_custom">
    <div class="container">
      <div class="row">
        <div class="col-lg-3 col-md-6">
          <div class="single-feature">
            <a href="#" class="title">
              <i class="flaticon-money"></i>
              <h3>Đảm bảo hoàn lại tiền</h3>
            </a>
            <p>Sau 7 ngày nhận hàng</p>
          </div>
        </div>

        <div class="col-lg-3 col-md-6">
          <div class="single-feature">
            <a href="#" class="title">
              <i class="flaticon-truck"></i>
              <h3>Giao hàng miễn phí</h3>
            </a>
            <p>Trên khắp toàn quốc</p>
          </div>
        </div>

        <div class="col-lg-3 col-md-6">
          <div class="single-feature">
            <a href="#" class="title">
              <i class="flaticon-support"></i>
              <h3>Luôn hỗ trợ</h3>
            </a>
            <p>24/24</p>
          </div>
        </div>

        <div class="col-lg-3 col-md-6">
          <div class="single-feature">
            <a href="#" class="title">
              <i class="flaticon-blockchain"></i>
              <h3>Thanh toán an toàn</h3>
            </a>
            <p>Bảo mật thông tin</p>
          </div>
        </div>
      </div>
    </div>
  </section>
  <!-- End feature Area -->

 <!--================ Feature Product Area =================-->
  <section class="feature_product_area section_gap_bottom_custom">
    <div class="container">
      <div class="row justify-content-center">
        <div class="col-lg-12">
          <div class="main_title">
            <h2><span>Sản phẩm</span></h2>
          </div>
        </div>
      </div>

      <div class="row">
      <c:forEach items="${list }" var="s">
        <div class="col-lg-4 col-md-6">
          <div class="single-product">
            <div class="product-img">
              <img  src="<c:url value="resources/them1"/>/img/${s.productImage1}" height="250px" width="250px" alt="" />
              <div class="p_icon">
                <a href="detailProductsUser?id=${s.id }">
                  <i class="ti-eye"></i>
                </a>
                <a href="#">
                  <i class="ti-heart"></i>
                </a>
                <a href="addToCart?id=${s.id}">
                  <i class="ti-shopping-cart"></i>
                </a>
              </div>
            </div>
            <div class="product-btm">
              <a href="#" class="d-block">
                <h4>${s.productName }</h4>
              </a>
              <div class="mt-3">
                <span class="mr-4"><fmt:formatNumber value="${s.productPriceBeforeDiscount }"/>VND</span>
                <del><fmt:formatNumber value="${s.productPrice }"/>VND</del>
              </div>
            </div>
          </div>
        </div>
	</c:forEach>
      </div>
    </div>
  </section>
  <!--================ End Feature Product Area =================-->

  <!--================ Start footer Area =================-->
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