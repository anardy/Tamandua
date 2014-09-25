<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<link rel="shortcut icon" href="img/logosite.png" type="image/x-icon" />
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">
<link href="css/main.css" rel="stylesheet" type="text/css">
<title>Login | Banco Comunitario Tamandua</title>
</head>
<body>

	<div class="container" style="margin-top: 30px">
		<div class="col-md-4">
			<div class="login-panel panel panel-default">
				<div class="panel-heading">
					<h3 class="panel-title">Login</h3>
				</div>
				<div class="panel-body">
					${erro}
					<form method="POST" action="efetuaLogin.do">
						<fieldset>
							<div class="form-group">
								<input class="form-control" placeholder="login" name="login">
							</div>
							<div class="form-group">
								<input class="form-control" placeholder="senha" name="senha"
									type="password">
							</div>
							<div class="checkbox">
								<label> <input name="remember" type="checkbox"
									value="Remember Me">Remember Me
								</label>
							</div>
							<!-- Change this to a button or input when using this as a form -->
							<input type="submit" value="Login" class="btn btn-sm btn-success">
						</fieldset>
					</form>
				</div>
			</div>
		</div>
	</div>

</body>
</html>
