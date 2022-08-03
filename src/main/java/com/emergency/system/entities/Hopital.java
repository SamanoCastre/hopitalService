package com.emergency.system.entities;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Hopital")
public class Hopital {
	@Transient
    public static final String SEQUENCE_NAME = "hopitals_sequence";
	
	@Id
	private int id;
	private String name;
	private Address address;
	private Date dateCreation;

	public Hopital() {
		
	}
	/**
	 * @param name
	 * @param address
	 * @param lits
	 */
	public Hopital(int id, String name, Address address, Date dateCreation) {
		this.name = name;
		this.address = address;
		this.id = id;
		this.dateCreation = dateCreation;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Date getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	@Override
	public String toString() {
		return "Hopital [id=" + id + ", name=" + name + ", address=" + address + "]";
	}
}
