<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:import url="/template/header.html" />

<div id="sidebar-nav">
	<div class="user-block">
		<strong>${usuarioLogado}</strong>
		<ul>
			<li><a href="logout.do">Logout</a></li>
		</ul>
	</div>

	<ul class="nav nav-list" id="menu">
		<c:if test="${funcao == 'atendente' || funca == 'gerente' }">
			<li><a href="cambio.do"><i class="icon-exchange"></i> <span>Câmbio</span></a></li>
			<li><a href="saque.do"><i class="icon-money"></i> <span>Saque</span></a></li>
			<li><a href="saldo.do"><i class="icon-trophy"></i> <span>Saldo</span></a></li>
			<li><a href="deposito.do"><i class="icon-refresh"></i> <span>Depósito</span></a></li>
			<li><a href="transferencia.do"><i class="icon-random"></i> <span>Transferência</span></a></li>
			<li><a href="extrato.do"><i class="icon-eye-open"></i> <span>Extrato</span></a></li>
		</c:if>
		<c:if test="${funcao == 'gerente' }">
			<li><a href="#"><i class="icon-gift"></i> <span>Empréstimo</span></a></li>
			<li><a href="#"><i class="icon-gift"></i> <span>Funcionário</span></a></li>
		</c:if>
	</ul>
</div>
<div class="content">
	<div class="container-fluid">
		<div class="row-fluid">
			<h1>Área do ${funcao}</h1>
		</div>
	</div>
</div>

<c:import url="/template/footer.html" />