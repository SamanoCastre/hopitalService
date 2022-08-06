package com.hopital.urgence.dtos;

public class SpecialiteRequestDTO {
	private int id;
	private String name;
	private String groupe;
	public SpecialiteRequestDTO(String name, String groupe) {
		super();
		this.name = name;
		this.groupe = groupe;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGroupe() {
		return groupe;
	}
	public void setGroupe(String groupe) {
		this.groupe = groupe;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public boolean valid() {
		return this.name != null && this.groupe != null;
	}
}
