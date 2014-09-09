<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="col-md-6 widget">
	<h2>
		<i class="glyphicons icon-info-sign"></i> Resultado da Transa��o
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
				<i class="glyphicons icon-terminal"></i> Informa��es da Requisi��o da Transa��o
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
				<span class="shortcut-label">Minha �rea</span>
			</a>
			
			<a href="cambio.do" class="shortcut"><i class="shortcut-icon icon-exchange"></i> 
				<span class="shortcut-label">C�mbio</span>
			</a>
			<a href="saque.do" class="shortcut"><i class="shortcut-icon icon-money"></i> 
				<span class="shortcut-label">Saque</span>
			</a>
			<a href="saldo.do" class="shortcut"><i class="shortcut-icon icon-trophy"></i> 
				<span class="shortcut-label">Saldo</span>
			</a>
			<a href="deposito.do" class="shortcut"><i class="shortcut-icon icon-refresh"></i> 
				<span class="shortcut-label">Dep�sito</span>
			</a>
			<a href="transferencia.do" class="shortcut"><i class="shortcut-icon icon-random"></i> 
				<span class="shortcut-label">Transfer�ncia</span>
			</a>
			<c:if test="${funcao == 'gerente' }">
				<a href="#" class="shortcut"><i class="shortcut-icon icon-gift"></i> 
					<span class="shortcut-label">Empr�stimo</span>
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