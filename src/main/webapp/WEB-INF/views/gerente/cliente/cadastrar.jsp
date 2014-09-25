<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:import url="/template/header.jsp" />

<h2>Cadastrar Cliente</h2>

<form id="formCadCliente">
	<div class="form-group">
		<label>CPF</label>
		<div class="controls">
			<input type="text" name="cpf" id="txtCpf" />
		</div>
	</div>
	<div class="form-group">
		<label>Nome</label>
		<div class="controls">
			<input type="text" name="nome" id="txtNome" />
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
			<input type="text" name="status" id="txtStatus" />
		</div>
	</div>
	<div class="form-group">
		<div class="controls">
			<input type="button" value="Cadastrar" class="btn btn-primary" onclick="Tamandua.InserirCliente();">
		</div>
	</div>
</form>


<c:import url="/template/footer.jsp" />