function enviar(page, id, dados) {
	$.ajax({
		  url: page+".do",
		  type: "POST",
		  data: dados,
		  beforeSend: function() {
			  $('#terminal').html("");
			  $('#terminal').append("<p>"+ data() +" - Solicitando transa��o de " + id + "...</p>");
			  $('#conta').html("Carregando...");
		  },
		  success: function(data) {
			  $('#conta').html(data);
		  },
		  complete: function() {
			  $('#terminal').append("<p>"+ data() +" - Transa��o de " + id + " realizada com Sucesso.");
		  },
		  error: function() {
			  $('#terminal').append("<p>"+ data() +" - Ocorreu um erro na execu��o da transa��o de " + id + ".");
		  }
	});
}

function data() {
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
	if (dia < 10) { 
		dia = "0" + dia;
	}
	return dia + "/" + mes+1 + "/" + ano + " " + hours + ":" + minutes + ":" + segundos;
}