<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/template/transaction/first_body.html" />

<div class="container-fluid">
	<div class="row-fluid">
		<div class="col-md-6 widget">
			<h2>
				<i class="glyphicons icon-trophy"></i> Saldo
			</h2>
			<hr>
			<div class="content">
				<form id="frmSaldo">
					<div class="form-group">
						<label>Nº Conta:</label>
						<div class="controls">
							<input name="nroconta" type="text" />
						</div>
					</div>
					<div class="form-group">
						<label>Senha:</label>
						<div class="controls">
							<input name="senha" type="password" />
						</div>
					</div>
					<div class="form-group">
						<div class="controls">
							<input type="button" value="Enviar" class="btn btn-primary" onclick="Tamandua.TransacaoSaldo();">
						</div>
					</div>
				</form>
			</div>
		</div>

<c:import url="/template/transaction/last_body.jsp" />