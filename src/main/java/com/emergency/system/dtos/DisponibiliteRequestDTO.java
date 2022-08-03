package com.emergency.system.dtos;

public class DisponibiliteRequestDTO {
	int hopital_id;
	int specialite_id;
	int lits;
	public DisponibiliteRequestDTO(int hopital_id, int specialite_id, int lits) {
		super();
		this.hopital_id = hopital_id;
		this.specialite_id = specialite_id;
		this.lits = lits;
	}
	public int getHopital_id() {
		return hopital_id;
	}
	public void setHopital_id(int hopital_id) {
		this.hopital_id = hopital_id;
	}
	public int getSpecialite_id() {
		return specialite_id;
	}
	public void setSpecialite_id(int specialite_id) {
		this.specialite_id = specialite_id;
	}
	public int getLits() {
		return lits;
	}
	public void setLits(int lits) {
		this.lits = lits;
	}
	public boolean valid() {
		return this.hopital_id <0 && this.specialite_id <0 && lits <0;
	}
}
