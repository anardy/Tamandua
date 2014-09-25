/**
 * FuncionarioModel.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package br.com.tamandua.Model;

public class FuncionarioModel  implements java.io.Serializable {
    private java.lang.String cpf;

    private java.lang.String funcao;

    private java.lang.String login;

    private java.lang.String nome;

    private java.lang.String senha;

    private java.lang.Short status;

    public FuncionarioModel() {
    }

    public FuncionarioModel(
           java.lang.String cpf,
           java.lang.String funcao,
           java.lang.String login,
           java.lang.String nome,
           java.lang.String senha,
           java.lang.Short status) {
           this.cpf = cpf;
           this.funcao = funcao;
           this.login = login;
           this.nome = nome;
           this.senha = senha;
           this.status = status;
    }


    /**
     * Gets the cpf value for this FuncionarioModel.
     * 
     * @return cpf
     */
    public java.lang.String getCpf() {
        return cpf;
    }


    /**
     * Sets the cpf value for this FuncionarioModel.
     * 
     * @param cpf
     */
    public void setCpf(java.lang.String cpf) {
        this.cpf = cpf;
    }


    /**
     * Gets the funcao value for this FuncionarioModel.
     * 
     * @return funcao
     */
    public java.lang.String getFuncao() {
        return funcao;
    }


    /**
     * Sets the funcao value for this FuncionarioModel.
     * 
     * @param funcao
     */
    public void setFuncao(java.lang.String funcao) {
        this.funcao = funcao;
    }


    /**
     * Gets the login value for this FuncionarioModel.
     * 
     * @return login
     */
    public java.lang.String getLogin() {
        return login;
    }


    /**
     * Sets the login value for this FuncionarioModel.
     * 
     * @param login
     */
    public void setLogin(java.lang.String login) {
        this.login = login;
    }


    /**
     * Gets the nome value for this FuncionarioModel.
     * 
     * @return nome
     */
    public java.lang.String getNome() {
        return nome;
    }


    /**
     * Sets the nome value for this FuncionarioModel.
     * 
     * @param nome
     */
    public void setNome(java.lang.String nome) {
        this.nome = nome;
    }


    /**
     * Gets the senha value for this FuncionarioModel.
     * 
     * @return senha
     */
    public java.lang.String getSenha() {
        return senha;
    }


    /**
     * Sets the senha value for this FuncionarioModel.
     * 
     * @param senha
     */
    public void setSenha(java.lang.String senha) {
        this.senha = senha;
    }


    /**
     * Gets the status value for this FuncionarioModel.
     * 
     * @return status
     */
    public java.lang.Short getStatus() {
        return status;
    }


    /**
     * Sets the status value for this FuncionarioModel.
     * 
     * @param status
     */
    public void setStatus(java.lang.Short status) {
        this.status = status;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof FuncionarioModel)) return false;
        FuncionarioModel other = (FuncionarioModel) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cpf==null && other.getCpf()==null) || 
             (this.cpf!=null &&
              this.cpf.equals(other.getCpf()))) &&
            ((this.funcao==null && other.getFuncao()==null) || 
             (this.funcao!=null &&
              this.funcao.equals(other.getFuncao()))) &&
            ((this.login==null && other.getLogin()==null) || 
             (this.login!=null &&
              this.login.equals(other.getLogin()))) &&
            ((this.nome==null && other.getNome()==null) || 
             (this.nome!=null &&
              this.nome.equals(other.getNome()))) &&
            ((this.senha==null && other.getSenha()==null) || 
             (this.senha!=null &&
              this.senha.equals(other.getSenha()))) &&
            ((this.status==null && other.getStatus()==null) || 
             (this.status!=null &&
              this.status.equals(other.getStatus())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getCpf() != null) {
            _hashCode += getCpf().hashCode();
        }
        if (getFuncao() != null) {
            _hashCode += getFuncao().hashCode();
        }
        if (getLogin() != null) {
            _hashCode += getLogin().hashCode();
        }
        if (getNome() != null) {
            _hashCode += getNome().hashCode();
        }
        if (getSenha() != null) {
            _hashCode += getSenha().hashCode();
        }
        if (getStatus() != null) {
            _hashCode += getStatus().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(FuncionarioModel.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Model.tamandua.com.br", "FuncionarioModel"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cpf");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Model.tamandua.com.br", "cpf"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("funcao");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Model.tamandua.com.br", "funcao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("login");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Model.tamandua.com.br", "login"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nome");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Model.tamandua.com.br", "nome"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("senha");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Model.tamandua.com.br", "senha"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("status");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Model.tamandua.com.br", "status"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "short"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
