<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:import url="/template/header.jsp" />

<h2>Cadastrar Funcionário</h2>

<form id="formCadFuncionario">
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
		<label>Login</label>
		<div class="controls">
			<input type="text" name="login" id="txtLogin" />
		</div>
	</div>
	<div class="form-group">
		<label>Senha</label>
		<div class="controls">
			<input type="password" name="senha" id="txtSenha" />
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
	<div class="form-group">
		<label>Função</label>
		<div class="controls">
			<select name="funcao" id="ddlFuncao">
				<option value="Atendente">Atendente</option>
				<option value="Gerente">Gerente</option>
			</select>
		</div>
	</div>
	<div class="form-group">
		<div class="controls">
			<input type="button" value="Cadastrar" class="btn btn-primary"
				onclick="Tamandua.InserirFuncionario();">
		</div>
	</div>
</form>


<c:import url="/template/footer.jsp" />