<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/template/transaction/first_body.html" />

<div class="container-fluid">
	<div class="row-fluid">
		<div class="col-md-6 widget">
			<h2>
				<i class="glyphicons icon-refresh"></i> Dep�sito
			</h2>
			<hr>
			<div class="content">
				<form id="frmDeposito">
					<div class="form-group">
						<label>N� Conta do Beneficiado:</label>
						<div class="controls">
							<input name="nrocontabeneficiado" type="text" />
						</div>
					</div>
					<div class="form-group">
						<label>Valor:</label>
						<div class="controls">
							<input name="valor" type="text" />
						</div>
					</div>
					<div class="form-group">
						<div class="controls">
							<input type="button" value="Enviar" class="btn btn-primary" onclick="Tamandua.TransacaoDeposito();">
						</div>
					</div>
				</form>
			</div>
		</div>

<c:import url="/template/transaction/last_body.jsp" />
