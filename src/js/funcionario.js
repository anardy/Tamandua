(function($) {

  var app = $.sammy('#main', function() {
    this.use('Mustache', 'html');

    // valida se o usuário foi autenticado no around
    // criar uma trigger de limpeza de form

    // no formAssociar colocar o nome do Funcionario e na mensagem de sucesso colocar o nome ao invés do CPF

    this.helpers({
      getTipoFuncionario: function() {
        var store = new Sammy.Store.SessionStorage('funcionario');
        return store.get('tipo');
      },
      limparStoreFunc: function() {
        var store = new Sammy.Store.SessionStorage('funcionario');
        store.clear('tipo');
        store.clear('cpf');
      }
    });

    this.around(function(callback) {
      var context = this;
      this.load('http://localhost:8080/TamanduaWS/api/autentica/menuFuncionario/' + this.getTipoFuncionario())
        .then(function(items) {
          context.items = $.parseJSON(items);
        }).then(callback);
    });

    this.get('#/', function(context) {
      context.app.swap('');
      this.trigger('menu');
    });

    this.get('#/logout', function(context) {
      this.limparStoreFunc();
      window.location.replace("http://localhost/Tamandua/src/");
    });

    this.get('#/funcionario', function(context) {
      context.app.swap('');
      this.trigger('menu');
      this.partial('templates/funcionario.html')
        .then(function() {
          $('#example').DataTable({
            "ajax": {
              "url": "http://localhost:8080/TamanduaWS/api/funcionario",
              "dataSrc": ""
            },
            "columns": [{
              "data": "cpf",
              "render": function(data, type, full, meta) {
                return '<a href="#/editarFunc/' + data + '">' + data + '</a>';
              }
            }, {
              "data": "nome"
            }]
          });
        });
    });

    this.get('#/cadastroFunc', function(context) {
      this.trigger('menu');
      context.tipo = 'Cadastrar';
      this.partial('templates/formFuncionario.html');
    });

    this.get('#/editarFunc/:cpf', function(context) {
      context.app.swap('');
      this.trigger('menu');
      var cpf = this.params.cpf;
      this.load('http://localhost:8080/TamanduaWS/api/funcionario/' + cpf, {
          cache: false
        })
        .then(function(items) {
          var json = $.parseJSON(items);
          context.cpf = json[0].cpf;
          context.nome = json[0].nome;
          context.tipo = 'Editar';
        }).partial('templates/formFuncionario.html');
    });

    this.get('#/ctrAcesso', function(context) {
      context.app.swap('');
      this.trigger('menu');
      this.partial('templates/ctrAcesso.html')
        .then(function() {
          $('#tblCtrAcesso').DataTable({
            "ajax": {
              "url": "http://localhost:8080/TamanduaWS/api/ctracesso",
              "dataSrc": ""
            },
            "columns": [{
              "data": "cpf",
              "render": function(data, type, full, meta) {
                return '<a href="#/editarCtrAcesso/' + data + '">' + data + '</a>';
              }
            }, {
              "data": "nomeFuncionario"
            }, {
              "data": "nomeStatus"
            }, {
              "data": "nomeTipo"
            }]
          });
        });
    });

    this.get('#/editarCtrAcesso/:cpf', function(context) {
      context.app.swap('');
      this.trigger('menu');
      var cpf = this.params.cpf;
      context.cpf = cpf;

      this.partial('templates/formCtrAcesso.html').then(function() {
        this.load('http://localhost:8080/TamanduaWS/api/ctracesso/tipoacesso/', {
          json: true
        }).
        then(function(item) {
          $select = $('#sltTipo');
          $.each(item, function(key, value) {
            $('<option>').val(value.codigo).text(value.nome).appendTo($select);
          });
        });

        this.load('http://localhost:8080/TamanduaWS/api/ctracesso/status/', {
          json: true
        }).
        then(function(item) {
          $select = $('#sltStatus');
          $.each(item, function(key, value) {
            $('<option>').val(value.codigo).text(value.status).appendTo($select);
          });
        });

        this.load('http://localhost:8080/TamanduaWS/api/ctracesso/' + cpf, {
          json: true
        }).
        then(function(item) {
          $('#sltStatus').val(item[0].status);
          $('#sltTipo').val(item[0].tipo);
        });

      });
    });

    this.post('#/editarCtrAcesso', function() {
      var $campoCPF = $('form').find('input[name="cpf"]');
      $campoCPF.removeAttr('disabled');
      var serialize = $('form').serialize();
      $campoCPF.attr('disabled', 'disabled');
      data = {
        "cpf": $('form').find('input[name="cpf"]').val(),
        "status": $('form').find('select[name="status"]').val(),
        "tipo": $('form').find('select[name="tipo"]').val()
      };
      $.ajax({
        url: 'http://localhost:8080/TamanduaWS/api/ctracesso',
        type: 'PUT',
        data: data,
        success: function(data) {
          window.location.replace("http://localhost/Tamandua/src/funcionario/#/ctrAcesso");
        }
      });
    });

    this.get('#/desassociados', function(context) {
      context.app.swap('');
      this.trigger('menu');
      this.partial('templates/desassociar.html')
        .then(function() {
          $('#tblDesassociado').DataTable({
            "ajax": {
              "url": "http://localhost:8080/TamanduaWS/api/ctracesso/desassociados",
              "dataSrc": ""
            },
            "columns": [{
              "data": "cpf",
              "render": function(data, type, full, meta) {
                return '<a href="#/associar/' + data + '">' + data + '</a>';
              }
            }, {
              "data": "nome"
            }]
          });
        });
    });

    this.get('#/associar/:cpf', function(context) {
      context.app.swap('');
      this.trigger('menu');
      context.cpf = this.params.cpf;
      this.partial('templates/formAssociar.html').then(function(content) {
        then(function(item) {
          $select = $('#sltTipo');
          $.each(item, function(key, value) {
            $('<option>').val(value.codigo).text(value.nome).appendTo($select);
          });
        });


        this.load('http://localhost:8080/TamanduaWS/api/ctracesso/status/', {
          json: true
        }).
        then(function(item) {
          $select = $('#sltStatus');
          $.each(item, function(key, value) {
            $('<option>').val(value.codigo).text(value.status).appendTo($select);
          });
        });
      });
    });

    this.post('#/associar', function() {
      var $campoCPF = $('form').find('input[name="cpf"]');
      $campoCPF.removeAttr('disabled');
      var serialize = $('form').serialize();
      $campoCPF.attr('disabled', 'disabled');
      $.post('http://localhost:8080/TamanduaWS/api/ctracesso/associar', serialize, function(data) {
        toastr.success('Funcionario ' + $('form').find('input[name="cpf"]').val() + ' foi associado a um perfil de acesso com sucesso!', 'Banco Tamandua');
      }).fail(function(xhr) {
        result = $.parseJSON(xhr.responseText);
      });
    });

    this.before({
      verb: 'post',
      path: '#/cadastroFunc'
    }, function() {
      var result = true;
      if ($('form').find('input[name="nome"]').val() === '') {
        toastr.error('O campo Nome está em branco!', 'Banco Tamandua');
        result = false;
      } else if ($('form').find('input[name="senha"]').val() === '') {
        toastr.error('O campo Senha está em branco!', 'Banco Tamandua');
        result = false;
      }
      return result;
    });


    this.post('#/cadastroFunc', function() {
      var tipo = $('form').find('input[name="tipo"]').val();
      if (tipo === 'Cadastrar') {
        $.post('http://localhost:8080/TamanduaWS/api/funcionario', $('form').serialize(), function(data) {
          toastr.success('Funcionario ' + $('form').find('input[name="nome"]').val() + ' cadastro com sucesso!', 'Banco Tamandua');
        }).fail(function(xhr) {
          result = $.parseJSON(xhr.responseText);
        });
      } else if (tipo === 'Editar') {
        data = {
          "cpf": $('form').find('input[name="cpf"]').val(),
          "nome": $('form').find('input[name="nome"]').val(),
          "senha": $('form').find('input[name="senha"]').val()
        };
        $.ajax({
          url: 'http://localhost:8080/TamanduaWS/api/funcionario',
          type: 'PUT',
          data: data,
          success: function(data) {
            window.location.replace("http://localhost/Tamandua/src/funcionario/#/funcionario");
          }
        });
      }
      $('form').find("input[type=text], input[type=password]").val("");
      $('form').find("input[name=cpf]").focus();
    });

    this.get('#/correntista', function(context) {
      context.app.swap('');
      this.trigger('menu');
      this.partial('templates/corrrentista.html')
        .then(function() {
          $('#tblCorrentista').DataTable({
            "ajax": {
              "url": "http://localhost:8080/TamanduaWS/api/correntista",
              "dataSrc": ""
            },
            "columns": [{
              "data": "cpf",
              "render": function(data, type, full, meta) {
                return '<a href="#/editarCorrentista/' + data + '">' + data + '</a>';
              }
            }, {
              "data": "nome"
            }, {
              "data": "endereco"
            }, {
              "data": "telefone"
            }]
          });
        });
    });

    this.get('#/cadCorrentista', function(context) {
      this.trigger('menu');
      context.tipo = 'Cadastrar';
      this.partial('templates/formCorrentista.html');
    });

    this.post('#/cadCorrentista', function() {
      var tipo = $('form').find('input[name="tipo"]').val();
      if (tipo === 'Cadastrar') {
        $.post('http://localhost:8080/TamanduaWS/api/correntista', $('form').serialize(), function(data) {
          toastr.success('Correntista ' + $('form').find('input[name="cpf"]').val() + ' cadastrado com sucesso!', 'Banco Tamandua');
          $('form').find("input[type=text]").val("");
          $('form').find("input[name=cpf]").focus();
        }).fail(function(xhr) {
          result = $.parseJSON(xhr.responseText);
        });
      } else if (tipo === 'Editar') {
        data = {
          "cpf": $('form').find('input[name="cpf"]').val(),
          "nome": $('form').find('input[name="nome"]').val(),
          "endereco": $('form').find('input[name="endereco"]').val(),
          "telefone": $('form').find('input[name="telefone"]').val()
        };
        $.ajax({
          url: 'http://localhost:8080/TamanduaWS/api/correntista',
          type: 'PUT',
          data: data,
          success: function(data) {
            window.location.replace("http://localhost/Tamandua/src/funcionario/#/correntista");
          }
        });
      }
    });

    this.get('#/editarCorrentista/:cpf', function(context) {
      context.app.swap('');
      this.trigger('menu');
      var cpf = this.params.cpf;
      this.load('http://localhost:8080/TamanduaWS/api/correntista/' + cpf, {
          cache: false
        })
        .then(function(items) {
          var json = $.parseJSON(items);
          context.cpf = json[0].cpf;
          context.nome = json[0].nome;
          context.endereco = json[0].endereco;
          context.telefone = json[0].telefone;
          context.tipo = 'Editar';
          context.desabilita = 'disabled';
        }).partial('templates/formCorrentista.html');
    });

    this.get('#/saldo', function(context) {
      this.trigger('menu');
      this.partial('templates/formSaldo.html');
    });

    this.post('#/saldo', function(context) {
      var nroconta = $('form').find('input[name="nroconta"]').val();
      this.load('http://localhost:8080/TamanduaWS/api/transacao/saldo/' + nroconta)
        .then(function(items) {
          if (items !== null) {
            var json = $.parseJSON(items);
            context.saldo = 'Saldo: R$ ' + json[0].saldo;
          } else {
            context.saldo = 'Não foi encontrado o saldo por falta de informação';
          }
        }).partial('templates/formSaldo.html');
    });

    this.get('#/extrato', function(context) {
      this.trigger('menu');
      this.partial('templates/formExtrato.html');
    });

    this.post('#/extrato', function(context) {
      var nroconta = $('form').find('input[name="nroconta"]').val();
      this.load('http://localhost:8080/TamanduaWS/api/transacao/extrato/' + nroconta, {
          json: true
        })
        .then(function(item) {
          for (var i in item) {
            var data = new Date(item[i].data);
            item[i].fator = (item[i].fator === 2) ? '<i class=\'fa fa-plus\'/>' : '<i class=\'fa fa-minus\'/>';
            item[i].data = data.getDate() + "/" + data.getMonth() + "/" + data.getFullYear() + " " + data.getHours() + ":" + data.getMinutes();
            var tipo = '';
            switch (item[i].tipotransacao) {
              case 1:
                tipo = 'Extrato';
                break;
              case 2:
                tipo = 'Transferência';
                break;
              case 3:
                tipo = 'Pagamento';
                break;
            }
            item[i].tipotransacao = tipo;
          }
          if (item === null) {
            var element = 'Nenhum Registro Encontrado com a conta (' + nroconta + ') informada!';
            context.msgm = element;
          } else {
            context.item = item;
          }
        }).partial('templates/formExtrato.html');
    });

    this.get('#/geraConta', function(context) {
      context.app.swap('');
      this.trigger('menu');
      this.partial('templates/contas.html')
        .then(function() {
          $('#tblConta').DataTable({
            "ajax": {
              "url": "http://localhost:8080/TamanduaWS/api/transacao/contas",
              "dataSrc": ""
            },
            "columns": [{
              "data": "nroconta",
              "render": function(data, type, full, meta) {
                return '<a href="#/editarConta/' + data + '">' + data + '</a>';
              }
            }, {
              "data": "correntista"
            }, {
              "data": "status"
            }]
          });
        });
    });

    this.get('#/cadConta', function(context) {
      this.trigger('menu');
      context.tipo = 'Cadastrar';

      this.partial('templates/formConta.html').then(function() {
        this.load('http://localhost:8080/TamanduaWS/api/ctracesso/status', {
          json: true
        }).
        then(function(item) {
          $select = $('#sltStatus');
          $.each(item, function(key, value) {
            $('<option>').val(value.codigo).text(value.status).appendTo($select);
          });
        });

        this.load('http://localhost:8080/TamanduaWS/api/correntista', {
          json: true
        }).
        then(function(item) {
          $select = $('#sltCorrentista');
          $.each(item, function(key, value) {
            $('<option>').val(value.cpf).text(value.cpf).appendTo($select);
          });
        });
      });
    });

    this.get('#/editarConta/:nroconta', function(context) {
      context.app.swap('');
      this.trigger('menu');
      var nroconta = this.params.nroconta;
      context.nroconta = nroconta;
      context.tipo = 'Editar';
      context.desabilita = 'disabled';

      this.partial('templates/formConta.html').then(function() {
        this.load('http://localhost:8080/TamanduaWS/api/ctracesso/status', {
          json: true
        }).
        then(function(item) {
          $select = $('#sltStatus');
          $.each(item, function(key, value) {
            $('<option>').val(value.codigo).text(value.status).appendTo($select);
          });
        });

        this.load('http://localhost:8080/TamanduaWS/api/correntista', {
          json: true
        }).
        then(function(item) {
          $select = $('#sltCorrentista');
          $.each(item, function(key, value) {
            $('<option>').val(value.cpf).text(value.cpf).appendTo($select);
          });
        });

        this.load('http://localhost:8080/TamanduaWS/api/transacao/conta/' + nroconta, {
            cache: false
          })
          .then(function(items) {
            var json = $.parseJSON(items);
            $('#sltStatus').val(json[0].status);
            $('#sltCorrentista').val(json[0].correntista);
          });
      });
    });

    this.bind('menu', function() {
      this.render('templates/sidebar.html', {
        items: this.items
      }).then(function() {
        $('#menu').empty();
      }).appendTo('#menu');
    });


  });

  $(function() {
    app.run('#/');
  });
})(jQuery);
