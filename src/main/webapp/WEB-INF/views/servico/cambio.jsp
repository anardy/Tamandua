<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/template/transaction/first_body.html" />

<div class="container">
	<div class="row">
		<div class="col-md-6 widget">
			<h2>
				<i class="glyphicons icon-exchange"></i> Câmbio
			</h2>
			<hr>
			<div class="content">
				<form id="frmCambio">
					<div class="form-group">
						<label class="radio-inline"> 
							<input type="radio" name="tipo" value="R/T" /> Real para Tamanduá
						</label>
						<label class="radio-inline"> 
							<input type="radio" name="tipo" value="T/R" /> Tamanduá para Real
						</label>
					</div>
					<div class="form-group">
						<label>Valor em Real:</label>
						<div class="controls">
							<input name="valor_real" type="text" />
						</div>
					</div>
					<div class="form-group">
						<label>Valor em Tamanduá:</label>
						<div class="controls">
							<input name="valor_tamandua" type="text" />
						</div>
					</div>
					<div class="form-group">
						<div class="controls">
							<input type="button" value="Enviar" class="btn btn-primary" onclick="Tamandua.TransacaoCambio();">
						</div>
					</div>
				</form>
			</div>
		</div>	

<c:import url="/template/transaction/last_body.jsp" />