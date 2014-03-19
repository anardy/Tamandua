/**
 * TaskClienteServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package br.com.tamandua.tasks;

public class TaskClienteServiceLocator extends org.apache.axis.client.Service implements br.com.tamandua.tasks.TaskClienteService {

    public TaskClienteServiceLocator() {
    }


    public TaskClienteServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public TaskClienteServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for TaskCliente
    private java.lang.String TaskCliente_address = "http://localhost:8080/TamanduaWS/services/TaskCliente";

    public java.lang.String getTaskClienteAddress() {
        return TaskCliente_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String TaskClienteWSDDServiceName = "TaskCliente";

    public java.lang.String getTaskClienteWSDDServiceName() {
        return TaskClienteWSDDServiceName;
    }

    public void setTaskClienteWSDDServiceName(java.lang.String name) {
        TaskClienteWSDDServiceName = name;
    }

    public br.com.tamandua.tasks.TaskCliente getTaskCliente() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(TaskCliente_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getTaskCliente(endpoint);
    }

    public br.com.tamandua.tasks.TaskCliente getTaskCliente(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            br.com.tamandua.tasks.TaskClienteSoapBindingStub _stub = new br.com.tamandua.tasks.TaskClienteSoapBindingStub(portAddress, this);
            _stub.setPortName(getTaskClienteWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setTaskClienteEndpointAddress(java.lang.String address) {
        TaskCliente_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (br.com.tamandua.tasks.TaskCliente.class.isAssignableFrom(serviceEndpointInterface)) {
                br.com.tamandua.tasks.TaskClienteSoapBindingStub _stub = new br.com.tamandua.tasks.TaskClienteSoapBindingStub(new java.net.URL(TaskCliente_address), this);
                _stub.setPortName(getTaskClienteWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("TaskCliente".equals(inputPortName)) {
            return getTaskCliente();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://tasks.tamandua.com.br", "TaskClienteService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://tasks.tamandua.com.br", "TaskCliente"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("TaskCliente".equals(portName)) {
            setTaskClienteEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
