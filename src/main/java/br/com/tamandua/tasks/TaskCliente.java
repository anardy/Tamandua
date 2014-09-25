/**
 * TaskCliente.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package br.com.tamandua.tasks;

public interface TaskCliente extends java.rmi.Remote {
    public boolean taskverificaLoginAtivo(java.lang.String user) throws java.rmi.RemoteException;
    public java.lang.String taskconsultaFuncionario(java.lang.String cpf) throws java.rmi.RemoteException;
    public java.lang.String taskinserirFuncionario(java.lang.String cpf, java.lang.String nome, java.lang.String login, java.lang.String senha, short status, java.lang.String funcao) throws java.rmi.RemoteException;
    public java.lang.String taskremoverFuncionario(java.lang.String cpf) throws java.rmi.RemoteException;
    public boolean tasklogin(java.lang.String user, java.lang.String senha) throws java.rmi.RemoteException;
    public java.lang.String taskextrato(java.lang.String nroconta, java.lang.String data_inicio, java.lang.String data_fim) throws java.rmi.RemoteException;
    public java.lang.String tasksaque(java.lang.String nroconta, double valor, java.lang.String senha, java.lang.String codigoFunc) throws java.rmi.RemoteException;
    public java.lang.String taskdeposito(java.lang.String nroconta_beneficiado, double valor, java.lang.String codigoFunc) throws java.rmi.RemoteException;
    public java.lang.String taskcambio(java.lang.String tipo, double valor_tamandua, double valor_real, java.lang.String codigoFunc) throws java.rmi.RemoteException;
    public java.lang.String tasksaldo(java.lang.String nroconta, java.lang.String senha) throws java.rmi.RemoteException;
    public java.lang.String tasktransferencia(java.lang.String nroconta_concedente, java.lang.String nroconta_beneficiado, double valor, java.lang.String senha_concedente, java.lang.String codigoFunc) throws java.rmi.RemoteException;
    public java.lang.String taskinserirCliente(java.lang.String cpf, java.lang.String nome, java.lang.String telefone, java.lang.String endereco, short status) throws java.rmi.RemoteException;
    public java.lang.String taskremoverCliente(java.lang.String cpf) throws java.rmi.RemoteException;
    public java.lang.String taskconsultaCliente(java.lang.String cpf) throws java.rmi.RemoteException;
    public br.com.tamandua.Model.FuncionarioModel taskdadosFuncionario(java.lang.String user, java.lang.String senha) throws java.rmi.RemoteException;
    public java.lang.String taskeditarCliente(java.lang.String cpf, java.lang.String nome, java.lang.String telefone, java.lang.String endereco, short status) throws java.rmi.RemoteException;
    public java.lang.String taskeditarFuncionario(java.lang.String cpf, java.lang.String nome, java.lang.String login, java.lang.String senha, short status, java.lang.String funcao) throws java.rmi.RemoteException;
}
