package br.com.tamandua.model;

public class Transferencia {
	private int nroconta_concedente;
	private int nroconta_beneficiado;
	private Double valor;
	private String senha_concedente;

	public int getNroconta_concedente() {
		return nroconta_concedente;
	}

	public void setNroconta_concedente(int nroconta_concedente) {
		this.nroconta_concedente = nroconta_concedente;
	}

	public int getNroconta_beneficiado() {
		return nroconta_beneficiado;
	}

	public void setNroconta_beneficiado(int nroconta_beneficiado) {
		this.nroconta_beneficiado = nroconta_beneficiado;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public String getSenha_concedente() {
		return senha_concedente;
	}

	public void setSenha_concedente(String senha_concedente) {
		this.senha_concedente = senha_concedente;
	}
}
