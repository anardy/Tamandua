(function($) {
  var app = $.sammy('#main', function() {
    this.use('Mustache', 'html');

    var teste = {
      msg: '',
      tipo: ''
    };

    this.helpers({
      getNroConta: function() {
        var store = new Sammy.Store.SessionStorage('conta');
        return store.get('nroconta');
      },
      limparNroConta: function() {
        var store = new Sammy.Store.SessionStorage('conta');
        store.clear('nroconta');
      }
    });

    // valida se o usuário foi autenticado no around

    this.get('#/', function(context) {
      context.app.swap('');
    });

    this.get('#/saldo', function(context) {
      context.app.swap('');
      this.load('http://localhost:8080/TamanduaWS/api/transacao/saldo/'+this.getNroConta())
      .then(function(items) {
        if (items !== null) {
          var json = $.parseJSON(items);
          context.saldo = json[0].saldo;
        } else {
           context.saldo = 'Não foi encontrado o saldo por falta de informação';
        }
      }).partial('templates/saldo.html');
    });

    this.get('#/transferencia', function(context) {
      context.app.swap('');
      this.msgm = teste.msg;
      this.nroconta = this.getNroConta();
      this.partial('templates/transferencia.html').then(function(content) {
        if (teste.msg !== '') {
          $('#divAlertTransferencia').addClass((teste.tipo === 'erro') ? 'alert-danger' : 'alert-success')
          .removeClass('hide');
        }
      });

    });

    this.post('#/transferencia', function(context) {
      $.ajaxSetup({async:false});
      var result;
      $.post('http://localhost:8080/TamanduaWS/api/transacao/transferencia', $('form').serialize(), function(data) {
        result = data;
      });
      $.ajaxSetup({async:true});
      teste = result;
      this.redirect('#/transferencia');
    });

    this.get('#/extrato', function(context) {
      context.app.swap('');
      this.load('http://localhost:8080/TamanduaWS/api/transacao/extrato/'+this.getNroConta(), {json: true})
      .then(function(item) {
        for (var i in item) {
          var data = new Date(item[i].data);
          item[i].fator = (item[i].fator === 1) ? '<i class=\'fa fa-plus\'/>' : '<i class=\'fa fa-minus\'/>';
          item[i].data = data.getDate() + "/" + data.getMonth() + "/" + data.getFullYear() + " " + data.getHours() + ":" + data.getMinutes();
          var tipo = '';
          switch(item[i].tipotransacao) {
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
          var element = {};
          item = [];
          item.push(element);
        }
        context.renderEach('templates/extrato.html', item)
        .appendTo(context.$element());
      });
    });

    this.get('#/logout', function(context) {
      this.limparNroConta();
      window.location.replace("http://localhost/Tamandua/src/");
    });

  });

  $(function() {
    app.run('#/');
  });
})(jQuery);
