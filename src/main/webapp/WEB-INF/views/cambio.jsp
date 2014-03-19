<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/template/header_start.html" />

<c:import url="/template/transaction/first_body.html" />

<c:import url="/template/header_end.html" />


<div class="container-fluid">
	<div class="row-fluid">
		<div class="span6 widget">
			<h2>
				<i class="glyphicons icon-exchange"></i> Câmbio
			</h2>
			<hr>
			<div class="content">
				<form id="form">
					<div class="control-group">
						<label class="radio"> 
							<input type="radio" name="tipo" value="R/T"> Real para Tamanduá
						</label>
						<label class="radio"> 
							<input type="radio" name="tipo" value="T/R"> Tamanduá para Real
						</label>
					</div>
					<div class="control-group">
						<label class="control-label" for="inputValorReal">Valor em Real:</label>
						<div class="controls">
							<input name="valor_real" type="text" />
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="inputValorTamandua">Valor em Tamanduá:</label>
						<div class="controls">
							<input name="valor_tamandua" type="text" />
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
					enviar("trancambio", "Cambio", $('#form').serialize());
				});
			});
		</script>

		<c:import url="/template/footer_end.html" />