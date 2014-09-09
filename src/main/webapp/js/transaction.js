var Tamandua = function() {
	return {
		TransacaoCambio: function() {
			Tamandua.Enviar("trancambio", "Cambio", $('#frmCambio').serialize());
		},
		TransacaoDeposito: function() {
			Tamandua.Enviar("trandeposito", "Deposito", $('#frmDeposito').serialize());
		},
		TransacaoSaque: function() {
			Tamandua.Enviar("transaque", "Saque", $('#frmSaque').serialize());
		},
		TransacaoSaldo: function() {
			Tamandua.Enviar("transaldo", "Saldo", $('#frmSaldo').serialize());
		},
		TransacaoExtrato: function() {
			Tamandua.Enviar("tranextrato", "Extrato", $('#frmExtrato').serialize());
		},
		TransacaoTransferencia: function() {
			Tamandua.Enviar("trantransferencia", "Transferencia", $('#frmTransferencia').serialize());
		},
		Enviar: function(page, id, dados) {
			$.ajax({
				  url: page+".do",
				  type: "POST",
				  data: dados,
				  beforeSend: function() {
					  $('#terminal').text("");
					  $('#terminal').append("<p>"+ Tamandua.Data() +" - Solicitando transação de <strong>" + id + "</strong>...</p>");
					  $('#conta').text("Carregando...");
				  },
				  success: function(data) {
					  $('#conta').text("");
					  // verificar se o data foi com sucesso, atualiza a flag
					  $('#conta').append(data);
					  // call dados conta
					  $('#terminal').append("<p>"+ Tamandua.Data() +" - Chamada de transação de <strong>" + id + "</strong> realizada com <strong>Sucesso</strong>.");
				  },
				  complete: function() {
					  // verifica a flag
					  $('#terminal').append("<p>"+ Tamandua.Data() +" - Chamada de transação de <strong>" + id + "</strong> foi <strong>Concluída<strong>.");
				  },
				  error: function() {
					  $('#terminal').append("<p>"+ Tamandua.Data() +" - Ocorreu um <strong>erro</strong> na chamada da transação de <strong>" + id + "</strong>.");
					  $('#conta').text("");
				  }
			});
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