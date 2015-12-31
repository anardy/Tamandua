(function($) {
  var app = $.sammy('#main', function() {
    this.use('Mustache', 'html');

    this.get('#/', function(context) {
      context.app.swap('');
    });

    this.get('#/saldo', function(context) {
      context.app.swap('');
      this.load('http://localhost:8080/TamanduaWS/transacao/saldo/1')
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
      this.partial('templates/transferencia.html');
    });

    this.post('#/transferencia', function(context) {
      $.ajaxSetup({async:false});
      var result;
      $.post('http://localhost:8080/TamanduaWS/transacao/transferencia', $('form').serialize(), function(data) {
        result = data;
      });
      $.ajaxSetup({async:true});
      this.msgm = result.msg;
      this.partial('templates/teste.html');
    });

    this.get('#/extrato', function(context) {
      context.app.swap('');
      this.load('http://localhost:8080/TamanduaWS/transacao/extrato/1', {json: true})
      .then(function(items) {
        $.each(items, function(i, item) {
          var date = new Date(item.data);
          var dataFormat = date.getDate()+"/"+date.getMonth()+"/"+date.getFullYear() + " " + date.getHours() + ":"+ date.getMinutes();
          var fator = (item.fator === 1) ? 'credito' : 'debito';
          context.render('templates/extrato.html', {nroconta: item.nroconta, tptransacao: item.tipotransacao, valor: item.valor, data: dataFormat, fator: fator})
          .appendTo(context.$element());
        });
      });
    });

  });

  $(function() {
    app.run('#/');
  });
})(jQuery);
