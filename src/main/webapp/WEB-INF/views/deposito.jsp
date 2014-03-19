<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/template/header_start.html" />

<c:import url="/template/transaction/first_body.html" />

<c:import url="/template/header_end.html" />


<div class="container-fluid">
	<div class="row-fluid">
		<div class="span6 widget">
			<h2>
				<i class="glyphicons icon-refresh"></i> Dep�sito
			</h2>
			<hr>
			<div class="content">
				<form id="form">
					<div class="control-group">
						<label class="control-label" for="inputNrocontaBeneficiado">N� Conta do Beneficiado:</label>
						<div class="controls">
							<input name="nrocontabeneficiado" type="text" />
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="inputValor">Valor:</label>
						<div class="controls">
							<input name="valor" type="text" />
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
			enviar("trandeposito", "Deposito", $('#form').serialize());
		});
	});
</script>

<c:import url="/template/footer_end.html" />