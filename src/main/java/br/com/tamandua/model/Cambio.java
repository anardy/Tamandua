package br.com.tamandua.model;

public class Cambio {
	private String tipo;
	private Double valor_tamandua;
	private Double valor_real;

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Double getValor_tamandua() {
		return valor_tamandua;
	}

	public void setValor_tamandua(Double valor_tamandua) {
		this.valor_tamandua = valor_tamandua;
	}

	public Double getValor_real() {
		return valor_real;
	}

	public void setValor_real(Double valor_real) {
		this.valor_real = valor_real;
	}
}
