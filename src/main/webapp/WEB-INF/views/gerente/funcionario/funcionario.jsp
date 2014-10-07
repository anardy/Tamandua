<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:import url="/template/header.jsp" />

<h2>Funcionário</h2>

<a href="cadFuncionario.do" role="button"
	class="btn btn-success pull-right"> + Novo Funcionário </a>

<form id="formFuncionario">
	<div class="form-group">
		<label>CPF</label>
		<div class="controls">
			<input type="text" name="cpf" id="txtCpf" />
		</div>
	</div>
	<div class="form-group">
		<div class="controls">
			<input type="button" value="Pesquisar" class="btn btn-primary"
				onclick="Tamandua.PesquisarFuncionario()" />
		</div>
	</div>
</form>

<div id="dadosFuncionario" class="hide">
	<div class="row">
		<div class="col-md-12 widget">
			<h2>
				<i class="glyphicons icon-exchange"></i> Dados do Funcionário
			</h2>
			<hr>
			<form id="formDadosFuncionario">
				<div class="form-group">
					<label>Nome</label>
					<div class="controls">
						<input type="text" name="nome" id="txtNome" /> <input
							type="hidden" name="cpf" id="hdnCpf" />
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
			</form>

			<input type="button" value="Editar" class="btn btn-success"
				onclick="Tamandua.EditarFuncionario();"> <input
				type="button" value="Remover" class="btn btn-danger"
				onclick="Tamandua.RemoverFuncionario();">

		</div>
	</div>
</div>

<c:import url="/template/footer.jsp" />