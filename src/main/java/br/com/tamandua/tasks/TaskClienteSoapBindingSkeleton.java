/**
 * TaskClienteSoapBindingSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package br.com.tamandua.tasks;

public class TaskClienteSoapBindingSkeleton implements br.com.tamandua.tasks.TaskCliente, org.apache.axis.wsdl.Skeleton {
    private br.com.tamandua.tasks.TaskCliente impl;
    private static java.util.Map _myOperations = new java.util.Hashtable();
    private static java.util.Collection _myOperationsList = new java.util.ArrayList();

    /**
    * Returns List of OperationDesc objects with this name
    */
    public static java.util.List getOperationDescByName(java.lang.String methodName) {
        return (java.util.List)_myOperations.get(methodName);
    }

    /**
    * Returns Collection of OperationDescs
    */
    public static java.util.Collection getOperationDescs() {
        return _myOperationsList;
    }

    static {
        org.apache.axis.description.OperationDesc _oper;
        org.apache.axis.description.FaultDesc _fault;
        org.apache.axis.description.ParameterDesc [] _params;
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tasks.tamandua.com.br", "tipo"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tasks.tamandua.com.br", "valor_tamandua"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"), double.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tasks.tamandua.com.br", "valor_real"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"), double.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("taskcambio", _params, new javax.xml.namespace.QName("http://tasks.tamandua.com.br", "taskcambioReturn"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://tasks.tamandua.com.br", "taskcambio"));
        _oper.setSoapAction("");
        _myOperationsList.add(_oper);
        if (_myOperations.get("taskcambio") == null) {
            _myOperations.put("taskcambio", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("taskcambio")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tasks.tamandua.com.br", "nroconta"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tasks.tamandua.com.br", "data_inicio"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tasks.tamandua.com.br", "data_fim"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("taskextrato", _params, new javax.xml.namespace.QName("http://tasks.tamandua.com.br", "taskextratoReturn"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://tasks.tamandua.com.br", "taskextrato"));
        _oper.setSoapAction("");
        _myOperationsList.add(_oper);
        if (_myOperations.get("taskextrato") == null) {
            _myOperations.put("taskextrato", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("taskextrato")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tasks.tamandua.com.br", "nroconta_beneficiado"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tasks.tamandua.com.br", "valor"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"), double.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("taskdeposito", _params, new javax.xml.namespace.QName("http://tasks.tamandua.com.br", "taskdepositoReturn"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://tasks.tamandua.com.br", "taskdeposito"));
        _oper.setSoapAction("");
        _myOperationsList.add(_oper);
        if (_myOperations.get("taskdeposito") == null) {
            _myOperations.put("taskdeposito", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("taskdeposito")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tasks.tamandua.com.br", "nroconta"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tasks.tamandua.com.br", "valor"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"), double.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tasks.tamandua.com.br", "senha"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("tasksaque", _params, new javax.xml.namespace.QName("http://tasks.tamandua.com.br", "tasksaqueReturn"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://tasks.tamandua.com.br", "tasksaque"));
        _oper.setSoapAction("");
        _myOperationsList.add(_oper);
        if (_myOperations.get("tasksaque") == null) {
            _myOperations.put("tasksaque", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("tasksaque")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tasks.tamandua.com.br", "nroconta"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tasks.tamandua.com.br", "senha"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("tasksaldo", _params, new javax.xml.namespace.QName("http://tasks.tamandua.com.br", "tasksaldoReturn"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://tasks.tamandua.com.br", "tasksaldo"));
        _oper.setSoapAction("");
        _myOperationsList.add(_oper);
        if (_myOperations.get("tasksaldo") == null) {
            _myOperations.put("tasksaldo", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("tasksaldo")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tasks.tamandua.com.br", "nroconta_concedente"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tasks.tamandua.com.br", "nroconta_beneficiado"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tasks.tamandua.com.br", "valor"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"), double.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://tasks.tamandua.com.br", "senha_concedente"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("tasktransferencia", _params, new javax.xml.namespace.QName("http://tasks.tamandua.com.br", "tasktransferenciaReturn"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://tasks.tamandua.com.br", "tasktransferencia"));
        _oper.setSoapAction("");
        _myOperationsList.add(_oper);
        if (_myOperations.get("tasktransferencia") == null) {
            _myOperations.put("tasktransferencia", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("tasktransferencia")).add(_oper);
    }

    public TaskClienteSoapBindingSkeleton() {
        this.impl = new br.com.tamandua.tasks.TaskClienteSoapBindingImpl();
    }

    public TaskClienteSoapBindingSkeleton(br.com.tamandua.tasks.TaskCliente impl) {
        this.impl = impl;
    }
    public java.lang.String taskcambio(java.lang.String tipo, double valor_tamandua, double valor_real) throws java.rmi.RemoteException
    {
        java.lang.String ret = impl.taskcambio(tipo, valor_tamandua, valor_real);
        return ret;
    }

    public java.lang.String taskextrato(java.lang.String nroconta, java.lang.String data_inicio, java.lang.String data_fim) throws java.rmi.RemoteException
    {
        java.lang.String ret = impl.taskextrato(nroconta, data_inicio, data_fim);
        return ret;
    }

    public java.lang.String taskdeposito(java.lang.String nroconta_beneficiado, double valor) throws java.rmi.RemoteException
    {
        java.lang.String ret = impl.taskdeposito(nroconta_beneficiado, valor);
        return ret;
    }

    public java.lang.String tasksaque(java.lang.String nroconta, double valor, java.lang.String senha) throws java.rmi.RemoteException
    {
        java.lang.String ret = impl.tasksaque(nroconta, valor, senha);
        return ret;
    }

    public java.lang.String tasksaldo(java.lang.String nroconta, java.lang.String senha) throws java.rmi.RemoteException
    {
        java.lang.String ret = impl.tasksaldo(nroconta, senha);
        return ret;
    }

    public java.lang.String tasktransferencia(java.lang.String nroconta_concedente, java.lang.String nroconta_beneficiado, double valor, java.lang.String senha_concedente) throws java.rmi.RemoteException
    {
        java.lang.String ret = impl.tasktransferencia(nroconta_concedente, nroconta_beneficiado, valor, senha_concedente);
        return ret;
    }

}
