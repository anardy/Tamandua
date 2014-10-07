<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:import url="/template/header.jsp" />

<h2>Cliente</h2>

<a href="cadCliente.do" role="button" class="btn btn-success pull-right">
	+ Novo Cliente </a>

<form id="formCliente">
	<div class="form-group">
		<label>CPF</label>
		<div class="controls">
			<input type="text" name="cpf" id="txtCpf" />
		</div>
	</div>
	<div class="form-group">
		<div class="controls">
			<input type="button" value="Pesquisar" class="btn btn-primary"
				onclick="Tamandua.PesquisarCliente()" />
		</div>
	</div>
</form>

<div id="dadosCliente" class="hide">
	<div class="row">
		<div class="col-md-6 widget">
			<h2>
				<i class="glyphicons icon-exchange"></i> Dados do Cliente
			</h2>
			<hr>
			<form id="formDadosCliente">
				<div class="form-group">
					<label>Nome</label>
					<div class="controls">
						<input type="text" name="nome" id="txtNome" /> <input
							type="hidden" name="cpf" id="hdnCpf" />
					</div>
				</div>
				<div class="form-group">
					<label>Endereço</label>
					<div class="controls">
						<input type="text" name="endereco" id="txtEndereco" />
					</div>
				</div>
				<div class="form-group">
					<label>Telefone</label>
					<div class="controls">
						<input type="text" name="telefone" id="txtTelefone" />
					</div>
				</div>
				<div class="form-group">
					<label>Status</label>
					<div class="controls">
						<select name="status" id="ddlStatus">
							<option value="1">Ativo</option>
							<option value="2">Desativo</option>
						</select>
					</div>
				</div>
			</form>

			<input type="button" value="Editar" class="btn btn-success"
				onclick="Tamandua.EditarCliente();"> <input type="button"
				value="Remover" class="btn btn-danger"
				onclick="Tamandua.RemoverCliente();">

		</div>
		<div class="col-md-6 widget">
			<h2>
				<i class="glyphicons icon-exchange"></i> Dados da Conta
			</h2>
			<hr>
		</div>
	</div>
</div>

<c:import url="/template/footer.jsp" />