<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
          <div class="banner_content d-md-flex justify-content-between align-items-center">
            <div class="mb-3 mb-md-0">
              <h2>Sảm phẩm cửa hàng</h2>
              <p>Vui lòng khách tới, hài lòng khách mua</p>
            </div>
            <div class="page_link">
              <a href="user">Trang chủ</a>
              <a href="userHome">Sản phẩm</a>
            </div>
          </div>
        </div>
      </div>
    </section>
    <!--================End Home Banner Area =================-->

    <!--================Category Product Area =================-->
    <section class="cat_product_area section_gap">
      <div class="container">
        <div class="row flex-row-reverse">
          <div class="col-lg-9">
            <div class="product_top_bar">
            </div>
            
            <div class="latest_product_inner">
              <div class="row">
              <c:forEach items="${list }" var="s">
                <div class="col-lg-4 col-md-6">
                  <div class="single-product">
                    <div class="product-img">
                      <img
                        class="card-img"
                        src="<c:url value="resources/them1"/>/img/${s.productImage1}" height="300px" width="350px"
                        alt=""
                      />
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
              <c:forEach items="${listPage}" var="page">
          		|&nbsp;&nbsp;<a href="userHome?page=${page}">${page}</a>&nbsp;&nbsp;
          </c:forEach>|
            </div>
          </div>

          <div class="col-lg-3">
            <div class="left_sidebar_area">
              <aside class="left_widgets p_filter_widgets">
                <div class="l_w_title">
                  <h3>Browse Categories</h3>
                </div>
                <div class="widgets_inner">
                 <c:forEach items="${listca }" var="c">
                  <ul class="list">
                    <li>
                    <a href="loadsubuser?id=${c.id }">${c.categoryName}</a>
                    </li>
                  </ul>
                  </c:forEach>
                </div>
              </aside>

              <aside class="left_widgets p_filter_widgets">
                <div class="l_w_title">
                  <h3>Product Brand</h3>
                </div>
                <div class="widgets_inner">
                <c:forEach items="${listsub }" var="s">
                  <ul class="list">
                    <li>
                    <%-- <c:if test="s.category.id == 2">  </c:if>--%>
                    	<a href="loadsubuser?id=${c.id }">${s.subcategory}</a>
                    </li>
                  </ul>
                  </c:forEach>
                </div>
              </aside>

            </div>
          </div>
        </div>
      </div>
    </section>
    <!--================End Category Product Area =================-->

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
