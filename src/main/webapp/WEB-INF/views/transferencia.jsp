<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/template/transaction/first_body.html" />

<div class="container-fluid">
	<div class="row-fluid">
		<div class="col-md-6 widget">
			<h2>
				<i class="glyphicons icon-random"></i> Transferência
			</h2>
			<hr>
			<div class="content">
				<form id="frmTansferencia">
					<div class="form-group">
						<label>Nº Conta Concedente:</label>
						<div class="controls">
							<input name="nroconta_concedente" type="text" />
						</div>
					</div>
					
					<div class="form-group">
						<label>Nº Conta Beneficiado:</label>
						<div class="controls">
							<input name="nroconta_beneficiado" type="text" />
						</div>
					</div>

					<div class="form-group">
						<label>Valor:</label>
						<div class="controls">
							<input name="valor" type="text" />
						</div>
					</div>

					<div class="form-group">
						<label>Senha Concedente:</label>
						<div class="controls">
							<input name="senha_concedente" type="password" />
						</div>
					</div>

					<div class="control-group">
						<div class="controls">
							<input type="button" value="Enviar" class="btn btn-primary" id="btnEnviarTransferencia">
						</div>
					</div>
				</form>
			</div>
		</div>

<c:import url="/template/transaction/last_body.jsp" />
