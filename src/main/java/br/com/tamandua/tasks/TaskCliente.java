/**
 * TaskCliente.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package br.com.tamandua.tasks;

public interface TaskCliente extends java.rmi.Remote {
    public br.com.tamandua.Model.Funcionario taskdadosFuncionario(java.lang.String user, java.lang.String senha) throws java.rmi.RemoteException;
    public java.lang.String tasktransferencia(java.lang.String nroconta_concedente, java.lang.String nroconta_beneficiado, double valor, java.lang.String senha_concedente, java.lang.String codigoFunc) throws java.rmi.RemoteException;
    public boolean tasklogin(java.lang.String user, java.lang.String senha) throws java.rmi.RemoteException;
    public java.lang.String taskextrato(java.lang.String nroconta, java.lang.String data_inicio, java.lang.String data_fim) throws java.rmi.RemoteException;
    public java.lang.String tasksaque(java.lang.String nroconta, double valor, java.lang.String senha, java.lang.String codigoFunc) throws java.rmi.RemoteException;
    public java.lang.String taskdeposito(java.lang.String nroconta_beneficiado, double valor, java.lang.String codigoFunc) throws java.rmi.RemoteException;
    public java.lang.String taskcambio(java.lang.String tipo, double valor_tamandua, double valor_real, java.lang.String codigoFunc) throws java.rmi.RemoteException;
    public java.lang.String tasksaldo(java.lang.String nroconta, java.lang.String senha) throws java.rmi.RemoteException;
}
