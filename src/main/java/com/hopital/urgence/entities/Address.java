package com.hopital.urgence.entities;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Address")
public class Address {
	private String numero;
	private String rue;
	private String codePostal;
	private String ville;
	private String pays;
	
	public Address() {
		
	}
	
	public Address(String numero, String rue, String codePostal, String ville, String pays) {
		super();
		this.numero = numero;
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
		this.pays = pays;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}
}
