var Tamandua = function() {
	return {
		OpenLoading: function(id) {
			$(id).block({
				message: '<i class="icon-spinner icon-spin icon-4x"></i>',
				css: { border: '0', width: '0' } 
			});
		},
		CloseLoading: function(id) {
			$(id).unblock();
		},
		PesquisarCliente: function() {
			$.ajax({
				  url: 'pesquisaCliente.do',
				  type: 'POST',
				  data: $('#formCliente').serialize(),
				  beforeSend: function() {
					Tamandua.OpenLoading('#formCliente');  
				  },
				  success: function(data) {
					  var result = JSON.parse(data);
					  var t = result.msgm.split(";");
					  for (var i=0; i<t.length;i++) {
						  switch (i) {
						  	case 0:
						  		$('#hdnCpf').val(t[i]);
						  		break;
						  	case 1:
						  		$('#txtNome').val(t[i]);
						  		break;
						  	case 2:
						  		$('#txtEndereco').val(t[i]);
						  		break;
						  	case 3:
						  		$('#txtTelefone').val(t[i]);
						  		break;
						  	case 4:
						  		$('#txtStatus').val(t[i]);
						  		break;
						  }
					  }
				  },
				  complete: function() {
					  Tamandua.CloseLoading('#formCliente');  
					  $('#dadosCliente').removeClass("hide");
					  $('#dadosCliente').show();
				  },
				  error: function() {
					  console.log('Deu erro');
				  }
			});
		},
		InserirCliente: function() {
			$.ajax({
				  url: 'inserirCliente.do',
				  type: 'POST',
				  data: $('#formCadCliente').serialize(),
				  success: function(data) {
					  console.log(data);
				  }
			});
		},
		RemoverCliente: function() {
			$.ajax({
				  url: 'removerCliente.do',
				  type: 'POST',
				  data: {cpf: $('#hdnCpf').val() },
				  success: function(data) {
					  console.log(data);
				  }
			});
		},
		EditarCliente: function() {
			$.ajax({
				  url: 'editarCliente.do',
				  type: 'POST',
				  data: $('#formDadosCliente').serialize(),
				  success: function(data) {
					  console.log(data);
				  }
			});
		},
		PesquisarFuncionario: function() {
			$.ajax({
				  url: 'pesquisaFuncionario.do',
				  type: 'POST',
				  data: $('#formFuncionario').serialize(),
				  beforeSend: function() {
					Tamandua.OpenLoading('#formFuncionario');  
				  },
				  success: function(data) {
					  var result = JSON.parse(data);
					  var t = result.msgm.split(";");
					  for (var i=0; i<t.length;i++) {
						  switch (i) {
						  	case 0:
						  		$('#hdnCpf').val(t[i]);
						  		break;
						  	case 1:
						  		$('#txtNome').val(t[i]);
						  		break;
						  	case 2:
						  		$('#txtLogin').val(t[i]);
						  		break;
						  	case 3:
						  		$('#txtStatus').val(t[i]);
						  		break;
						  	case 4:
						  		$('#txtFuncao').val(t[i]);
						  		break;
						  }
					  }
				  },
				  complete: function() {
					  Tamandua.CloseLoading('#formFuncionario');  
					  $('#dadosFuncionario').removeClass("hide");
					  $('#dadosFuncionario').show();
				  },
				  error: function() {
					  toastr.error("Houve um erro ao Pesquisar o Funcionario");
				  }
			});
		},
		InserirFuncionario: function() {
			$.ajax({
				  url: 'inserirFuncionario.do',
				  type: 'POST',
				  data: $('#formCadFuncionario').serialize(),
				  success: function(data) {
					  var result = JSON.parse(data);
					  toastr.success(result.msgm);
				  }
			});
		},
		RemoverFuncionario: function() {
			$.ajax({
				  url: 'removerFuncionario.do',
				  type: 'POST',
				  data: {cpf: $('#hdnCpf').val() },
				  success: function(data) {
					  var result = JSON.parse(data);
					  toastr.success(result.msgm);
				  }
			});
		},
		EditarFuncionario: function() {
			$.ajax({
				  url: 'editarFuncionario.do',
				  type: 'POST',
				  data: $('#formDadosFuncionario').serialize(),
				  success: function(data) {
					  var result = JSON.parse(data);
					  toastr.success(result.msgm);
				  }
			});
		}
	};
}();

$(function() {
	// Alterar o active do Menu na área do Gerente
	var site = window.location.pathname;

	$('#sidebar-nav a').each(function() {
		var href = $(this).attr('href');
		if (site === href) {
			$(this).closest('li').addClass('active');
		}
	});
	
	toastr.options.closeButton = true;
	
});