<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html lang="pt-br">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<link rel="shortcut icon" href="img/logosite.png" type="image/x-icon" />
	<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">
	<link href="css/main.css" rel="stylesheet" type="text/css">
	<link href="css/font-awesome.min.css" rel="stylesheet" type="text/css">
	<link href="css/toastr.min.css" rel="stylesheet" type="text/css">
	<title>Banco Comunitario Tamandua</title>
</head>
<body>

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
			<li><a href="/Tamandua/cliente.do"><i class="icon-gift"></i> <span>Cliente</span></a></li>
			<li><a href="#"><i class="icon-gift"></i> <span>Empréstimo</span></a></li>
			<li><a href="/Tamandua/funcionario.do"><i class="icon-gift"></i> <span>Funcionário</span></a></li>
		</c:if>
	</ul>
</div>

<div class="content">
	<div class="container-fluid">
		<div class="row-fluid">