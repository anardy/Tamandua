package br.com.tamandua.tasks;

public class TaskClienteProxy implements br.com.tamandua.tasks.TaskCliente {
  private String _endpoint = null;
  private br.com.tamandua.tasks.TaskCliente taskCliente = null;
  
  public TaskClienteProxy() {
    _initTaskClienteProxy();
  }
  
  public TaskClienteProxy(String endpoint) {
    _endpoint = endpoint;
    _initTaskClienteProxy();
  }
  
  private void _initTaskClienteProxy() {
    try {
      taskCliente = (new br.com.tamandua.tasks.TaskClienteServiceLocator()).getTaskCliente();
      if (taskCliente != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)taskCliente)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)taskCliente)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (taskCliente != null)
      ((javax.xml.rpc.Stub)taskCliente)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public br.com.tamandua.tasks.TaskCliente getTaskCliente() {
    if (taskCliente == null)
      _initTaskClienteProxy();
    return taskCliente;
  }
  
  public br.com.tamandua.Model.Funcionario taskdadosFuncionario(java.lang.String user, java.lang.String senha) throws java.rmi.RemoteException{
    if (taskCliente == null)
      _initTaskClienteProxy();
    return taskCliente.taskdadosFuncionario(user, senha);
  }
  
  public java.lang.String tasktransferencia(java.lang.String nroconta_concedente, java.lang.String nroconta_beneficiado, double valor, java.lang.String senha_concedente, java.lang.String codigoFunc) throws java.rmi.RemoteException{
    if (taskCliente == null)
      _initTaskClienteProxy();
    return taskCliente.tasktransferencia(nroconta_concedente, nroconta_beneficiado, valor, senha_concedente, codigoFunc);
  }
  
  public boolean tasklogin(java.lang.String user, java.lang.String senha) throws java.rmi.RemoteException{
    if (taskCliente == null)
      _initTaskClienteProxy();
    return taskCliente.tasklogin(user, senha);
  }
  
  public java.lang.String taskextrato(java.lang.String nroconta, java.lang.String data_inicio, java.lang.String data_fim) throws java.rmi.RemoteException{
    if (taskCliente == null)
      _initTaskClienteProxy();
    return taskCliente.taskextrato(nroconta, data_inicio, data_fim);
  }
  
  public java.lang.String tasksaque(java.lang.String nroconta, double valor, java.lang.String senha, java.lang.String codigoFunc) throws java.rmi.RemoteException{
    if (taskCliente == null)
      _initTaskClienteProxy();
    return taskCliente.tasksaque(nroconta, valor, senha, codigoFunc);
  }
  
  public java.lang.String taskdeposito(java.lang.String nroconta_beneficiado, double valor, java.lang.String codigoFunc) throws java.rmi.RemoteException{
    if (taskCliente == null)
      _initTaskClienteProxy();
    return taskCliente.taskdeposito(nroconta_beneficiado, valor, codigoFunc);
  }
  
  public java.lang.String taskcambio(java.lang.String tipo, double valor_tamandua, double valor_real, java.lang.String codigoFunc) throws java.rmi.RemoteException{
    if (taskCliente == null)
      _initTaskClienteProxy();
    return taskCliente.taskcambio(tipo, valor_tamandua, valor_real, codigoFunc);
  }
  
  public java.lang.String tasksaldo(java.lang.String nroconta, java.lang.String senha) throws java.rmi.RemoteException{
    if (taskCliente == null)
      _initTaskClienteProxy();
    return taskCliente.tasksaldo(nroconta, senha);
  }
  
  
}