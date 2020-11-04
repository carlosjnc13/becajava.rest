package br.rest.app.model;

public class Zona {
	
	private Long Id;
	private String Numero;

	public String getNumero() {
		return Numero;
	}
	
	public Long getId() {
		return Id;
	}
	
	public void setId(Long id) {
		Id = id;
	}

	public void setNumero(String numero) {
		Numero = numero;
	}
}
