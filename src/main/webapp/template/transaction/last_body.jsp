<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="col-md-6 widget">
	<h2>
		<i class="glyphicons icon-info-sign"></i> Resultado da Transação
	</h2>
	<hr>
	<div class="content">
		<div id="conta"></div>
	</div>
</div>
</div>

<div class="row">
		<div class="col-md-12 widget">
			<h2>
				<i class="glyphicons icon-terminal"></i> Informações da Requisição da Transação
			</h2>
			<hr>
			<div class="content">
				<div id="terminal"></div>
			</div>
		</div>
	</div>
</div>
<div class="teste">
	<div class="container">
		<div class="shortcuts">
			<a href="area.do" class="shortcut"><i class="shortcut-icon icon-home"></i> 
				<span class="shortcut-label">Minha Área</span>
			</a>
			
			<a href="cambio.do" class="shortcut"><i class="shortcut-icon icon-exchange"></i> 
				<span class="shortcut-label">Câmbio</span>
			</a>
			<a href="saque.do" class="shortcut"><i class="shortcut-icon icon-money"></i> 
				<span class="shortcut-label">Saque</span>
			</a>
			<a href="saldo.do" class="shortcut"><i class="shortcut-icon icon-trophy"></i> 
				<span class="shortcut-label">Saldo</span>
			</a>
			<a href="deposito.do" class="shortcut"><i class="shortcut-icon icon-refresh"></i> 
				<span class="shortcut-label">Depósito</span>
			</a>
			<a href="transferencia.do" class="shortcut"><i class="shortcut-icon icon-random"></i> 
				<span class="shortcut-label">Transferência</span>
			</a>
			<c:if test="${funcao == 'gerente' }">
				<a href="#" class="shortcut"><i class="shortcut-icon icon-gift"></i> 
					<span class="shortcut-label">Empréstimo</span>
				</a>
			</c:if>
			<a href="extrato.do	" class="shortcut"><i class="shortcut-icon icon-eye-open"></i> 
				<span class="shortcut-label">Extrato</span>
			</a>
		</div>
	</div>
</div>

<script src="js/vendor/jquery.min.js"></script>
<script src="js/vendor/bootstrap-datepicker.js"></script>
<script src="js/transaction.js"></script>

</body>
</html>