var Tamandua = function() {
	return {
		// m�todo da transa��o de Cambio
		TransacaoCambio: function() {
			Tamandua.Enviar({url: "trancambio", page: "Cambio", dados: $('#frmCambio').serialize()}, function(obj) {
				if (obj.msgm === "Transa��o de Cambio executada com sucesso") {
					// call dados do montante
					$('#terminal').append("<p>"+ Tamandua.Data() +" - Chamada de transa��o de <strong>" + obj.page + "</strong> realizada com <strong>Sucesso</strong>.");
					$('#conta').append("Exibir dados do montante");
				} else {
					Tamandua.MensagemErro(obj);
				}
			});
		},
		// m�todo da transa��o de Deposito
		TransacaoDeposito: function() {
			Tamandua.Enviar({url: "trandeposito", page: "Deposito", dados: $('#frmDeposito').serialize()}, function(obj) {
				if (obj.msgm === "Transa��o de Dep�sito executada com sucesso") {
					// call dados conta
					$('#terminal').append("<p>"+ Tamandua.Data() +" - Chamada de transa��o de <strong>" + obj.page + "</strong> realizada com <strong>Sucesso</strong>.");
					$('#conta').append("Exibir informa��es da conta.");
				} else {
					Tamandua.MensagemErro(obj);
				}
			});
		},
		// m�todo da transa��o de Saque
		TransacaoSaque: function() {
			Tamandua.Enviar({url: "transaque", page: "Saque", dados: $('#frmSaque').serialize()}, function(obj) {
				if (obj.msgm === "Transa��o realizada com sucesso!") {
					// call dados conta
					$('#terminal').append("<p>"+ Tamandua.Data() +" - Chamada de transa��o de <strong>" + obj.page + "</strong> realizada com <strong>Sucesso</strong>.");
					$('#conta').append("Exibir informa��es da conta.");
				} else {
					Tamandua.MensagemErro(obj);
				}
			});
		},
		// m�todo da transa��o de Saldo
		TransacaoSaldo: function() {
			Tamandua.Enviar({url: "transaldo", page: "Saldo", dados: $('#frmSaldo').serialize()}, function(obj) {
				// call dados conta
				if ((parseInt(obj.msgm,10) > 0) || (parseInt(obj.msgm, 10) <= 0)) {
					$('#conta').append("<p>O saldo da conta �: " + obj.msgm);
					$('#terminal').append("<p>"+ Tamandua.Data() +" - Chamada de transa��o de <strong>" + obj.page + "</strong> realizada com <strong>Sucesso</strong>.");
				} else {
					Tamandua.MensagemErro(obj);
				}
			});
		},
		// m�todo da transa��o de Extrato
		TransacaoExtrato: function() {
			Tamandua.Enviar({url: "tranextrato", page: "Extrato", dados: $('#frmExtrato').serialize()}, function(obj) {
				if (obj.msgm !== "") {
					$('#conta').append("<p>" + obj.msgm + "</p>");
					$('#terminal').append("<p>"+ Tamandua.Data() +" - Chamada de transa��o de <strong>" + obj.page + "</strong> realizada com <strong>Sucesso</strong>.");
				} else {
					obj.msgm = "Nenhum registro encontrado!";
					Tamandua.MensagemErro(obj);
				}
			});
		},
		// m�todo da transa��o de Transfer�ncia
		TransacaoTransferencia: function() {
			Tamandua.Enviar({url: "trantransferencia", page: "Transferencia", dados: $('#frmTransferencia').serialize()}, function(obj) {
				if (obj.msgm === "Transa��o de Transfer�ncia executada com sucesso") {
					// call dados conta
					$('#terminal').append("<p>"+ Tamandua.Data() +" - Chamada de transa��o de <strong>" + obj.page + "</strong> realizada com <strong>Sucesso</strong>.");
					$('#conta').append("Exibir informa��es da conta.");
				} else {
					Tamandua.MensagemErro(obj);
				}
			});
		},
		// Enviar recebe um obj e um callback, onde o obj �:
		// url: a url da requisi��o AJAX
		// page: O nome da transa��o
		// dados: Dados do formul�rio preenchido pelo usu�rio
		// (retorna obj +) msgm: A mensagem de retorno da requisi��o AJAX passada para o callback 
		Enviar: function(obj, callback) {
			$.ajax({
				  url: obj.url+'.do',
				  type: 'POST',
				  data: obj.dados,
				  beforeSend: function() {
					  $('#terminal').text('');
					  $('#terminal').append("<p>"+ Tamandua.Data() +" - Solicitando transa��o de <strong>" + obj.page + "</strong>...</p>");
					  $('#conta').text('Carregando...');
				  },
				  success: function(data) {
					  var result = JSON.parse(data);
					  obj.msgm = result.msgm;
					  $('#conta').text('');
					  callback(obj);
				  },
				  complete: function() {
					  $('#terminal').append("<p>"+ Tamandua.Data() +" - Chamada de transa��o de <strong>" + obj.page + "</strong> foi <strong>Conclu�da<strong>.");
				  },
				  error: function() {
					  $('#terminal').append("<p>"+ Tamandua.Data() +" - Ocorreu um <strong>erro</strong> na chamada da transa��o de <strong>" + obj.page + "</strong>.");
					  $('#conta').text('');
				  }
			});
		},
		// mensagem de erro quando o retorno da transa��o n�o � de Sucesso.
		MensagemErro: function(obj) {
			$('#terminal').append("<p>"+ Tamandua.Data() +" - Ocorreu um <strong>erro</strong> no retorno da transa��o de <strong>" + obj.page + "</strong>.");
			$('#terminal').append("<p>"+ Tamandua.Data() +" - Erro retornado pelo sistema: <strong>" + obj.msgm + "</strong>.");
		},
		// Recupera a data do sistema
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

// Funcionar o datepicker na p�gina de Extrato
$(function() {
	$('#datainicio').datepicker({
		format : 'dd/mm/yyyy'
	});
	$('#datafinal').datepicker({
		format : 'dd/mm/yyyy'
	});
});

// Quando selecionar a data, fechar o datepicker
$('#datainicio').on('changeDate', function(ev) {
	$(this).datepicker('hide');
});

//Quando selecionar a data, fechar o datepicker
$('#datafinal').on('changeDate', function(ev) {
	$(this).datepicker('hide');
});