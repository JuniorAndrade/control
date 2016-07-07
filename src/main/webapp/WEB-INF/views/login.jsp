<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="author" content="Thomas Matheus">
<title>Login</title>
<link href="<c:url value='/static/bootstrap/css/bootstrap.min.css' />"
	rel="stylesheet"></link>
<link href="<c:url value='/static/plugins/iCheck/square/blue.css' />"
	rel="stylesheet"></link>
<link href="<c:url value='/static/css/AdminLTE.min.css' />"
	rel="stylesheet"></link>

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
<script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
<![endif]-->
</head>

<body class="hold-transition login-page">
	<div class="login-box">
		<div class="login-logo">
			<a href="#"><b>LOGIN</b></a>
		</div>
		<div class="login-box-body">
			<p class="login-box-msg"></p>

			<c:url var="loginUrl" value="/login" />
			<form action="${loginUrl}" method="post">
				<c:if test="${param.error != null}">
					<div class="alert alert-danger">
						<p>Usuário ou senha inválidos.</p>
					</div>
				</c:if>
				<c:if test="${param.logout != null}">
					<div class="alert alert-success">
						<p>Logout realizado com sucesso.</p>
					</div>
				</c:if>
				<div class="form-group has-feedback">
					<input id="username" name="ssoId" type="text" class="form-control"
						placeholder="Enter Username" required> <span
						class="glyphicon glyphicon-user form-control-feedback"></span>
				</div>
				<div class="form-group has-feedback">
					<input id="password" name="password" type="password"
						class="form-control" placeholder="Enter Password" required>
					<span class="glyphicon glyphicon-lock form-control-feedback"></span>
				</div>
				<div class="row">
					<div class="col-xs-8">
						<div class="checkbox icheck">
							<label> <input type="checkbox" id="rememberme"
								name="remember-me"> Remember Me
							</label>
						</div>
					</div>
					<div class="col-xs-4">
						<input type="hidden" name="${_csrf.parameterName}"
							value="${_csrf.token}" />
						<button type="submit" class="btn btn-primary btn-block btn-flat">Log In</button>
					</div>
				</div>
			</form>
		</div>
	</div>

	<script src="<c:url value='/static/plugins/jQuery/jQuery-2.1.4.min.js' />"></script>
	<script src="<c:url value='/static/bootstrap/js/bootstrap.min.js' />"></script>
	<script src="<c:url value='/static/plugins/iCheck/icheck.min.js' />"></script>
	<script>
	  $(function () {
	    $('input').iCheck({
	      checkboxClass: 'icheckbox_square-blue',
	      radioClass: 'iradio_square-blue',
	      increaseArea: '20%'
	    });
	  });
	</script>

</body>
</html>