/**
 * TaskClienteService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package br.com.tamandua.tasks;

public interface TaskClienteService extends javax.xml.rpc.Service {
    public java.lang.String getTaskClienteAddress();

    public br.com.tamandua.tasks.TaskCliente getTaskCliente() throws javax.xml.rpc.ServiceException;

    public br.com.tamandua.tasks.TaskCliente getTaskCliente(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
