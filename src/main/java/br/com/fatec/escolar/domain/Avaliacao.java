package br.com.fatec.escolar.domain;

import javax.persistence.Entity;

@SuppressWarnings("serial")
@Entity
public class Avaliacao extends GenericDomain {


	private String tipo;

	
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

}
