package com.expedition.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Expedition {
	
	@Id
	private Long id;
	private int idCommande;
	private int etat;
	
	public Expedition() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getIdCommande() {
		return idCommande;
	}

	public void setIdCommande(int idCommande) {
		this.idCommande = idCommande;
	}

	public int getEtat() {
		return etat;
	}

	public void setEtat(int etat) {
		this.etat = etat;
	}
}
