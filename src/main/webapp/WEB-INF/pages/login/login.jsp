<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link href="https://fonts.googleapis.com/css?family=Roboto:300,400&display=swap" rel="stylesheet">

    <link rel="stylesheet" href="<c:url value="/resources/them3/fonts/icomoon/style.css"/>" >

    <link rel="stylesheet" href="<c:url value="/resources/them3/css/owl.carousel.min.css"/>">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="<c:url value="/resources/them3/css/bootstrap.min.css"/>">
    
    <!-- Style -->
    <link rel="stylesheet" href="<c:url value="/resources/them3/css/style.css"/>">

    <title>Login</title>
  </head>
  <body>
  

  
  <div class="content">
    <div class="container">
      <div class="row">
        <div class="col-md-6 order-md-2">
          <img src="<c:url value="/resources/them3/images/undraw_file_sync_ot38.svg"/>" alt="Image" class="img-fluid">
        </div>
        <div class="col-md-6 contents">
          <div class="row justify-content-center">
            <div class="col-md-8">
              <div class="mb-4">
              <h3>Đăng nhập <strong>ThuHaMoile</strong></h3>
              <p class="mb-4"></p>
            </div>
            <h3 style="color:green">${success }</h3>
			<h3 style="color:red">${err }</h3>
            <form action="loginUser" method="post">
              <div class="form-group first">
                <label for="email">Email</label>
                <input type="email" class="form-control" name="email">

              </div>
              <div class="form-group last mb-4">
                <label for="password">Password</label>
                <input type="password" class="form-control" name="password">
                
              </div>
              
              <div class="d-flex mb-5 align-items-center">
                <label class="control control--checkbox mb-0"><span class="caption">Remember me</span>
                  <input type="checkbox" checked="checked"/>
                  <div class="control__indicator"></div>
                </label>
                <span class="ml-auto"><a href="#" class="forgot-pass">Forgot Password</a></span> 
              </div>

              <input type="submit" value="Log In" class="btn text-white btn-block btn-primary">

              <span class="d-block text-left my-4 text-muted">Bạn chưa có tài khoản? <a href="initInsertUser">Đăng kí</a></span>
              
              <div class="social-login">
                <a href="#" class="facebook">
                  <span class="icon-facebook mr-3"></span> 
                </a>
                <a href="#" class="twitter">
                  <span class="icon-twitter mr-3"></span> 
                </a>
                <a href="#" class="google">
                  <span class="icon-google mr-3"></span> 
                </a>
              </div>
            </form>
            </div>
          </div>
          
        </div>
        
      </div>
    </div>
  </div>

  
    <script src="<c:url value="/resources/them3/js/jquery-3.3.1.min.js"/>"></script>
    <script src="<c:url value="/resources/them3/js/popper.min.js"/>"></script>
    <script src="<c:url value="/resources/them3/js/bootstrap.min.js"/>"></script>
    <script src="<c:url value="/resources/them3/js/main.js"/>"></script>
  </body>
</html>