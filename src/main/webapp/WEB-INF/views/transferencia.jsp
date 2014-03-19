<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/template/header_start.html" />

<c:import url="/template/transaction/first_body.html" />

<c:import url="/template/header_end.html" />


<div class="container-fluid">
	<div class="row-fluid">
		<div class="span6 widget">
			<h2>
				<i class="glyphicons icon-random"></i> Transferência
			</h2>
			<hr>
			<div class="content">
				<form id="form">
					<div class="control-group">
						<label class="control-label" for="inputNrocontaConcedente">Nº Conta Concedente:</label>
						<div class="controls">
							<input name="nroconta_concedente" type="text" />
						</div>
					</div>
					
					<div class="control-group">
						<label class="control-label" for="inputNrocontaBeneficiado">Nº Conta Beneficiado:</label>
						<div class="controls">
							<input name="nroconta_beneficiado" type="text" />
						</div>
					</div>

					<div class="control-group">
						<label class="control-label" for="inputValor">Valor:</label>
						<div class="controls">
							<input name="valor" type="text" />
						</div>
					</div>

					<div class="control-group">
						<label class="control-label" for="inputSenha">Senha Concedente:</label>
						<div class="controls">
							<input name="senha_concedente" type="password" />
						</div>
					</div>

					<div class="control-group">
						<div class="controls">
							<input type="button" value="Enviar" class="btn btn-primary" id="enviar">
						</div>
					</div>
				</form>
			</div>
		</div>

<c:import url="/template/transaction/last_body.html" />

<c:import url="/template/footer_start.html" />

<script>
	$(document).ready(function() {
		$('#enviar').click(function() {
			enviar("trantransferencia", "Transferencia", $('#form').serialize());
		});
	});
</script>

<c:import url="/template/footer_end.html" />
