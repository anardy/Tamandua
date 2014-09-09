<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/template/transaction/first_body.html" />

<div class="container-fluid">
	<div class="row-fluid">
		<div class="col-md-6 widget">
			<h2>
				<i class="glyphicons icon-eye-open"></i> Extrato
			</h2>
			<hr>
			<div class="content">
				<form id="frmExtrato">
					<div class="form-group">
						<label>Nº Conta:</label>
						<div class="controls">
							<input name="nroconta" type="text" />
						</div>
					</div>
					<div class="form-group">
						<label>Data Inicio:</label>
						<div class="controls">
							<input name="datainicio" id="datainicio" type="text" />
						</div>
					</div>
					<div class="form-group">
						<label>Data Final:</label>
						<div class="controls">
							<input name="datafinal" id="datafinal" type="text" />
						</div>
					</div>
					<div class="form-group">
						<div class="controls">
							<input type="button" value="Enviar" class="btn btn-primary" onclick="Tamandua.TransacaoExtrato();">
						</div>
					</div>
				</form>
			</div>
		</div>

<c:import url="/template/transaction/last_body.jsp" />