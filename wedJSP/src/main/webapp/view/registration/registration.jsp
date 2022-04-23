<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/tagLib.jsp"%>
<c:url var="APIurl" value="/api-user" />
<c:url var="checkUserNameURL" value="/api-user-checking" />
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>Đăng Ký</title>
</head>

<body>
	<div class="container">
		<div class="d-flex justify-content-center h-100">
			<div class="card">
				<div class="card-header">
					<h3>Đăng Ký</h3>
					<div class="d-flex justify-content-end social_icon">
						<span><i class="fab fa-facebook-square"></i></span>
						<span><i class="fab fa-google-plus-square"></i></span>
						<span><i class="fab fa-twitter-square"></i></span>
					</div>
				</div>
				<div class="card-body">
					<form id="registrationForm">
						<span id="checkUserName"></span>
						<br>
						<div class="input-group form-group">
							<div class="input-group-prepend">
								<span class="input-group-text"><i class="fas fa-user"></i></span>
							</div>
							<input type="text" class="form-control" id="fullName" placeholder="full-name"
								name="fullName">
						</div>
						<div class="input-group form-group">
							<div class="input-group-prepend">
								<span class="input-group-text"><i class="fas fa-user"></i></span>
							</div>
							<input type="text" class="form-control" id="userName" placeholder="username"
								name="userName">
						</div>
						<div class="input-group form-group">
							<div class="input-group-prepend">
								<span class="input-group-text"><i class="fas fa-key"></i></span>
							</div>
							<input type="password" id="password" class="form-control" placeholder="password"
								name="password">
						</div>
						<div class="input-group form-group">
							<div class="input-group-prepend">
								<span class="input-group-text"><i class="fas fa-key"></i></span>
							</div>
							<input type="password" id="confirm-password" class="form-control"
								placeholder="confirm-password" name="confirmPassword">
						</div>
						<div class="form-group">
							<input type="submit" id="registrationSubmit" value="Đăng ký"
								class="btn float-right login_btn" />
						</div>
						<div class="form-group">
							<span id="cofirm-message"></span>
						</div>
						<div id="cofirm-message" class="alert alert-${alert}" role="alert">
						</div>
					</form>
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
		$(document).ready(function () {
			function hideMsg() {
				$("#message").fadeOut();
			}
			setTimeout(hideMsg, 5000);
			$('#registrationSubmit').attr('disabled', 'disabled');
			$('#userName').change(function () {
				var data = {};
				var username = $(this).val();
				data["userName"] = username;
				if (username.length == 0) {
					$('#checkUserName').html("");
				} else {
					$.ajax({
						url: "${checkUserNameURL}",
						type: 'POST',
						contentType: 'application/json',
						data: JSON.stringify(data),
						dataType: "text",
						success: function (html) {
							$('#checkUserName').html(html);
						}
					})
				}
			})
		});
		$('#password,#confirm-password').on('keyup', function () {
			if ($('#password').val().length == 0 || $('#userName').val().length == 0 || $('#fullName').val().length ==
				0) {
				$('#cofirm-message').html("điền đủ thông tin").css(
					'fontSize', '26px');
				$('#registrationSubmit').attr('disabled', 'disabled');
			} else {
				if ($('#password').val() == $('#confirm-password').val()) {
					$('#cofirm-message').html("Matching").css('color', 'green');
					$('#registrationSubmit').removeAttr('disabled');
				} else {
					$('#registrationSubmit').attr('disabled', 'disabled');
					$('#cofirm-message').html("Not Matching").css('color', 'red').css(
						'fontSize', '26px');
				}
			}
		})
		$("#registrationSubmit").click(function (e) {
			e.preventDefault();
			var data = {};
			var formData = $('#registrationForm').serializeArray();
			$.each(formData, function (i, v) {
				data["" + v.name + ""] = v.value;
			});
			if (Object.keys(data).length !== 0) {
				addUser(data);
			}
		});

		function addUser(data) {
			$.ajax({
				url: '${APIurl}',
				type: 'POST',
				contentType: 'application/json',
				data: JSON.stringify(data),
				dataType: 'text',
				success: function (result) {
					window.location.href ="<c:url value='/dang-nhap?action=login&message=registrationsuccess&alert=success'/>";
				},
			})
		};
	</script>
</body>

</html>