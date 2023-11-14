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
    <meta
      name="viewport"
      content="width=device-width, initial-scale=1, shrink-to-fit=no"
    />
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
            class="banner_content d-md-flex justify-content-between align-items-center"
          >
            <div class="mb-3 mb-md-0">
              <h2>Chi tiết sản phẩm</h2>
              <p>Vui lòng khách đến, hài lòng khách mua</p>
            </div>
            <div class="page_link">
              <a href="user">Trang chủ</a>
              <a href="#">Chi tiết sản phẩm</a>
            </div>
          </div>
        </div>
      </div>
    </section>
    <!--================End Home Banner Area =================-->

    <!--================Single Product Area =================-->
    <div class="product_image_area">
      <div class="container">
        <div class="row s_product_inner">
          <div class="col-lg-6">
            <div class="s_product_img">
              <div
                id="carouselExampleIndicators"
                class="carousel slide"
                data-ride="carousel">
                <ol class="carousel-indicators">
                  <li
                    data-target="#carouselExampleIndicators"
                    data-slide-to="0"
                    class="active">
                    <img
                      src="<c:url value="resources/them1"/>/img/${p.productImage1}" width="60px" height="60px"
                      alt=""/>
                  </li>
                  <li
                    data-target="#carouselExampleIndicators"
                    data-slide-to="1">
                    <img
                      src="<c:url value="resources/them1"/>/img/${p.productImage2}" width="60px" height="60px"
                      alt=""/>
                  </li>
                  <li
                    data-target="#carouselExampleIndicators"
                    data-slide-to="2">
                    <img
                      src="<c:url value="resources/them1"/>/img/${p.productImage3}" width="60px" height="60px"
                      alt=""/>
                  </li>
                </ol>
                <div class="carousel-inner">
                  <div class="carousel-item active">
                    <img
                      class="d-block w-100"
                      src="<c:url value="resources/them1"/>/img/${p.productImage1}" 
                      alt="First slide"/>
                  </div>
                  <div class="carousel-item">
                    <img
                      class="d-block w-100"
                      src="<c:url value="resources/them1"/>/img/${p.productImage2}"
                      alt="Second slide" />
                  </div>
                  <div class="carousel-item">
                    <img
                      class="d-block w-100"
                      src="<c:url value="resources/them1"/>/img/${p.productImage3}"
                      alt="Third slide"
                    />
                  </div>
                </div>
              </div>
            </div>
          </div>
          <div class="col-lg-5 offset-lg-1">
            <div class="s_product_text">
              <h3>${p.productName }</h3>
              <h2><fmt:formatNumber value="${p.productPriceBeforeDiscount }"/>VND</h2>
              <ul class="list">
                <li>
                  <a class="active" href="#">
                    <span>Category</span>${p.category.categoryName }</a
                  >
                </li>
                <li>
                  <a href="#"> <span>Khả dụng: </span>${p.productAvailability }</a>
                </li>
              </ul>
              <p>
               ${p.productDescription }
              </p>
              <div class="product_count">
                      <input
                        type="text"
                        name="${o.orderDetailquantity}"
                        id="sst-${p.id}"
                        maxlength="12"
                        value="${o.quantity}"
                        title="Số lượng"
                        class="input-text qty" />
                      <button
                        onclick="var result = document.getElementById('sst-${p.id}'); var sst = result.value; if( !isNaN( sst-${p.id} )) result.value++;return false;"
                        class="increase items-count"
                        type="button" >
                        <i class="lnr lnr-chevron-up"></i>
                      </button>
                      <button
                        onclick="var result = document.getElementById('sst-${p.id}'); var sst = result.value; if( !isNaN( sst-${p.id} ) &amp;&amp; sst > 0 ) result.value--;return false;"
                        class="reduced items-count"
                        type="button" >
                        <i class="lnr lnr-chevron-down"></i>
                      </button>
                    </div>
              <div class="card_area">
                <a class="main_btn" href="addToCart?id=${p.id}">Thêm vào giỏ hàng</a>
                <a class="icon_btn" href="#">
                  <i class="lnr lnr lnr-heart"></i>
                </a>
              </div>
              
            </div>
          </div>
        </div>
      </div>
    </div>
    <!--================End Single Product Area =================-->

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
