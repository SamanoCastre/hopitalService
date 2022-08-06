package com.hopital.urgence.dtos;


public class RechercheRequestDTO {
	private String lieuIncident;
	private int specialite;
	
	public RechercheRequestDTO(String lieuIncident, int specialite) {
		this.lieuIncident = lieuIncident;
		this.specialite = specialite;
	}
	public RechercheRequestDTO() {
		
	}
	public String getLieuIncident() {
		return lieuIncident;
	}
	public void setLieuIncident(String lieuIncident) {
		this.lieuIncident = lieuIncident;
	}
	public int getSpecialite() {
		return specialite;
	}
	public void setSpecialite(int specialite) {
		this.specialite = specialite;
	}
	
	public boolean valid() {
		return !(this.getLieuIncident().isBlank() &&  this.getSpecialite()>0);
	}
}
