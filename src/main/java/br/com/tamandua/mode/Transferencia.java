package br.com.tamandua.mode;

public class Transferencia {
	private int nrocontaconcedente;
	private int nrocontabeneficiado;
	private Double valor;
	private String senhaconcedente;

	public int getNrocontaconcedente() {
		return nrocontaconcedente;
	}

	public void setNrocontaconcedente(int nrocontaconcedente) {
		this.nrocontaconcedente = nrocontaconcedente;
	}

	public int getNrocontabeneficiado() {
		return nrocontabeneficiado;
	}

	public void setNrocontabeneficiado(int nrocontabeneficiado) {
		this.nrocontabeneficiado = nrocontabeneficiado;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public String getSenhaconcedente() {
		return senhaconcedente;
	}

	public void setSenhaconcedente(String senhaconcedente) {
		this.senhaconcedente = senhaconcedente;
	}
}
