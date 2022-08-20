package com.hopital.urgence.services;

import java.util.List;

import com.hopital.urgence.entities.Specialite;
import com.hopital.urgence.exceptions.NoDataFoundException;

public interface ISpecialiteService {
	public List<Specialite> getSpecialites() throws NoDataFoundException;

}
