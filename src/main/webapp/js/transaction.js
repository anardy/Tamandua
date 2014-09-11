var Tamandua = function() {
	return {
		TransacaoCambio: function() {
			Tamandua.Enviar("trancambio", "Cambio", $('#frmCambio').serialize(), function(msgm) {
				if (msgm === "Transa��o de Cambio executada com sucesso") {
					// call dados do montante
					$('#terminal').append("<p>"+ Tamandua.Data() +" - Chamada de transa��o de <strong>Cambio</strong> realizada com <strong>Sucesso</strong>.");
					$('#conta').append("Exibir dados do montante");
				} else {
					Tamandua.MensagemErro("Cambio", msgm);
				}
			});
		},
		TransacaoDeposito: function() {
			Tamandua.Enviar("trandeposito", "Deposito", $('#frmDeposito').serialize(), function(msgm) {
				if (msgm === "Transa��o de Dep�sito executada com sucesso") {
					// call dados conta
					$('#terminal').append("<p>"+ Tamandua.Data() +" - Chamada de transa��o de <strong>Deposito</strong> realizada com <strong>Sucesso</strong>.");
					$('#conta').append("Exibir informa��es da conta.");
				} else {
					Tamandua.MensagemErro("Deposito", msgm);
				}
			});
		},
		TransacaoSaque: function() {
			Tamandua.Enviar("transaque", "Saque", $('#frmSaque').serialize(), function(msgm) {
				if (msgm === "Transa��o realizada com sucesso!") {
					// call dados conta
					$('#terminal').append("<p>"+ Tamandua.Data() +" - Chamada de transa��o de <strong>Saque</strong> realizada com <strong>Sucesso</strong>.");
					$('#conta').append("Exibir informa��es da conta.");
				} else {
					Tamandua.MensagemErro("Saque", msgm);
				}
			});
		},
		TransacaoSaldo: function() {
			Tamandua.Enviar("transaldo", "Saldo", $('#frmSaldo').serialize(), function(msgm) {
				// call dados conta
				if (parseInt(msgm,10) > 0 || (parseInt(msgm, 10) < 0)) {
					$('#conta').append("<p>O saldo da conta �: " + msgm);
					$('#terminal').append("<p>"+ Tamandua.Data() +" - Chamada de transa��o de <strong>Saldo</strong> realizada com <strong>Sucesso</strong>.");
				} else {
					Tamandua.MensagemErro("Saldo", msgm);
				}
			});
		},
		TransacaoExtrato: function() {
			Tamandua.Enviar("tranextrato", "Extrato", $('#frmExtrato').serialize(), function(msgm) {
				if (msgm !== null) {
					$('#conta').append("<p>" + msgm + "</p>");
					$('#terminal').append("<p>"+ Tamandua.Data() +" - Chamada de transa��o de <strong>Extrato</strong> realizada com <strong>Sucesso</strong>.");
				} else {
					Tamandua.MensagemErro("Extrato", msgm);
				}
			});
		},
		TransacaoTransferencia: function() {
			Tamandua.Enviar("trantransferencia", "Transferencia", $('#frmTransferencia').serialize(), function(msgm) {
				if (msgm === "Transa��o de Transfer�ncia executada com sucesso") {
					// call dados conta
					$('#terminal').append("<p>"+ Tamandua.Data() +" - Chamada de transa��o de <strong>Transfer�ncia</strong> realizada com <strong>Sucesso</strong>.");
					$('#conta').append("Exibir informa��es da conta.");
				} else {
					Tamandua.MensagemErro("Transferencia", msgm);
				}
			});
		},
		Enviar: function(page, id, dados, callback) {
			$.ajax({
				  url: page+'.do',
				  type: 'POST',
				  data: dados,
				  beforeSend: function() {
					  $('#terminal').text('');
					  $('#terminal').append("<p>"+ Tamandua.Data() +" - Solicitando transa��o de <strong>" + id + "</strong>...</p>");
					  $('#conta').text('Carregando...');
				  },
				  success: function(data) {
					  result = JSON.parse(data);
					  $('#conta').text('');
					  callback(result.msgm);
				  },
				  complete: function() {
					  $('#terminal').append("<p>"+ Tamandua.Data() +" - Chamada de transa��o de <strong>" + id + "</strong> foi <strong>Conclu�da<strong>.");
				  },
				  error: function() {
					  $('#terminal').append("<p>"+ Tamandua.Data() +" - Ocorreu um <strong>erro</strong> na chamada da transa��o de <strong>" + id + "</strong>.");
					  $('#conta').text('');
				  }
			});
		},
		MensagemErro: function(id, erro) {
			$('#terminal').append("<p>"+ Tamandua.Data() +" - Ocorreu um <strong>erro</strong> no retorno da transa��o de <strong>" + id + "</strong>.");
			  $('#terminal').append("<p>"+ Tamandua.Data() +" - Erro retornado pelo sistema: <strong>" + erro + "</strong>.");
		},
		Data: function() {
			var hoje = new Date();
			var dia = hoje.getDate();
			var mes = hoje.getMonth();
			var ano = hoje.getFullYear();
			var hours = (hoje.getHours() < 10) ? "0" : "";
			hours = hours + + hoje.getHours();
			var minutes = (hoje.getMinutes() < 10) ? "0" : "";
			minutes = minutes + hoje.getMinutes();
			var segundos = (hoje.getSeconds() < 10) ? "0" : "";
			segundos = segundos + hoje.getSeconds();
			dia = (dia < 10) ? "0" + dia : dia;
			mes = parseInt(mes,10)+1;
			mes = (mes < 10) ? "0" + mes : mes;
			return dia + "/" + mes + "/" + ano + " " + hours + ":" + minutes + ":" + segundos;
		}
	};
}();

$(function() {
	$('#datainicio').datepicker({
		format : 'dd/mm/yyyy'
	});
	$('#datafinal').datepicker({
		format : 'dd/mm/yyyy'
	});
});

$('#datainicio').on('changeDate', function(ev) {
	$(this).datepicker('hide');
});

$('#datafinal').on('changeDate', function(ev) {
	$(this).datepicker('hide');
});