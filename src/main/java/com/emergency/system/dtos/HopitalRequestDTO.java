package com.emergency.system.dtos;

import java.util.Date;

public class HopitalRequestDTO {
	private int id;
	private String name;
	private String numero;
	private String rue;
	private String codePostal;
	private String ville;
	private String pays;
	public HopitalRequestDTO(String name, String numero, String rue, String codePostal, String ville,
			String pays) {
		super();
		this.name = name;
		this.numero = numero;
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
		this.pays = pays;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public boolean valid() {
		return this.name != null && this.codePostal != null && this.ville != null && this.pays != null;
	}
	
}
