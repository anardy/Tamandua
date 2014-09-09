<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/template/header.html" />

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
								<input class="form-control" placeholder="senha" name="senha" type="password">
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

<c:import url="/template/footer.html" />
