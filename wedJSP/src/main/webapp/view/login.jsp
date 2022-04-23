<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/tagLib.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Đăng Nhập</title>
</head>

<body>
	<div class="container">
		<div class="d-flex justify-content-center h-100">
			<div class="card">
				<div class="card-header">
					<h3>Đăng Nhập</h3>
					<div class="d-flex justify-content-end social_icon">
						<span><i class="fab fa-facebook-square"></i></span>
						<span><i class="fab fa-google-plus-square"></i></span>
						<span><i class="fab fa-twitter-square"></i></span>
					</div>
				</div>
				<div class="card-body">
					<form action='<c:url value="/trang-chu"/>'  method="post">
						<div class="input-group form-group">
							<div class="input-group-prepend">
								<span class="input-group-text"><i class="fas fa-user"></i></span>
							</div>
							<input type="text" class="form-control" placeholder="username" name="userName">

						</div>
						<div class="input-group form-group">
							<div class="input-group-prepend">
								<span class="input-group-text"><i class="fas fa-key"></i></span>
							</div>
							<input type="password" class="form-control" placeholder="password" name="password">
						</div>
						<div class="row align-items-center remember">
							<input type="checkbox">Remember Me
						</div>
						<div class="form-group">
							<input type="submit" value="Login" class="btn float-right login_btn">
						</div>
						<input type="hidden" value="login" id="action" name="action">  
					</form> 
				</div>
				<div class="card-footer">
					<div class="d-flex justify-content-center links">
						Don't have an account?<a href="<c:url value="/dang-ky?action=registration&isExist=false"/>">Đăng Ký</a>
					</div>
					<div class="d-flex justify-content-center">
						<a href="#">Quên mật khẩu?</a>
					</div>
				</div>
				<c:if test="${not empty message}">
				<div id="message" class="alert alert-${alert}" role="alert">
  						${message}
				</div>
				</c:if>
			</div>
		</div>
	</div>
	<script type="text/javascript">
	$(document).ready(function(){
	    function hideMsg(){
	    //alert("hi");
	        $("#message").fadeOut();
	    }
	    setTimeout(hideMsg,5000);
		});
	</script>
</body>

</html>