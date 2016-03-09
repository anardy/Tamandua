(function($) {
  var app = $.sammy('#main', function() {
    this.use('Mustache', 'html');

    var result = {
      tipo: '',
      msg: ''
    };

    this.helpers({
      getTipoFuncionario: function() {
        var store = new Sammy.Store.SessionStorage('funcionario');
        return store.get('tipo');
      },
      getCpfFuncionario: function() {
        var store = new Sammy.Store.SessionStorage('funcionario');
        return store.get('cpf');
      },
    });

    this.get('#/', function(context) {
      context.app.swap('');
      this.msg = result.msg;
      context.render('templates/login.html').appendTo(context.$element());
    });

    this.post('#/autentica', function(context) {
      $.ajaxSetup({
        async: false
      });
      $.post('http://localhost:8080/TamanduaWS/api/autentica', $('form').serialize(), function(data) {
        result = data;
      }).fail(function(xhr) {
        result = $.parseJSON(xhr.responseText);
      });
      $.ajaxSetup({
        async: true
      });
      if (result.tipo === 'erro') {
        this.redirect('#/');
      } else {
        if (result.msg !== 'Correntista') {
          var store = new Sammy.Store.SessionStorage('funcionario');
          store.set('cpf', $("[name='cpf']").val());
          store.set('tipo', result.msg);
          result.msg = 'Funcionario';
        }
        this.redirect('#/login' + result.msg);
      }
    });

    this.post('#/login', function(context) {
      $.ajaxSetup({
        async: false
      });
      $.post('http://localhost:8080/TamanduaWS/api/autentica/cliente', $('form').serialize(), function(data) {
        result = data;
      }).fail(function(xhr) {
        result = $.parseJSON(xhr.responseText);
      });
      $.ajaxSetup({
        async: true
      });
      if (result.tipo === 'erro') {
        this.redirect('#/loginCorrentista');
      } else {
        var store = new Sammy.Store.SessionStorage('conta');
        store.set('nroconta', $("[name='nroconta']").val());
        // gravar que foi feito o login
        window.location.replace("http://localhost/Tamandua/src/cliente/");
      }
    });

    this.post('#/loginFuncionario', function(context) {
      $.ajaxSetup({
        async: false
      });
      $.post('http://localhost:8080/TamanduaWS/api/autentica/funcionario', $('form').serialize(), function(data) {
        result = data;
      }).fail(function(xhr) {
        result = $.parseJSON(xhr.responseText);
      });
      $.ajaxSetup({
        async: true
      });
      if (result.tipo === 'erro') {
        this.redirect('#/loginFuncionario');
      } else {
        // gravar que foi feito o login
        window.location.replace("http://localhost/Tamandua/src/funcionario/");
      }
    });

    this.get('#/loginCorrentista', function(context) {
      this.msg = result.msg;
      this.partial('templates/loginCorrentista.html');
    });

    this.get('#/loginFuncionario', function(context) {
      this.msg = result.msg;
      this.cpf = this.getCpfFuncionario();
      this.partial('templates/loginFuncionario.html');
    });

  });

  $(function() {
    app.run('#/');
  });
})(jQuery);
