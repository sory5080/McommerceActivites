package com.clientui.beans;

public class ExpeditionBean {
	
	private Long id;
	private int idCommande;
	private int etat;
	
	public ExpeditionBean() {
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

	@Override
	public String toString() {
		return "ExpeditionBean [id=" + id + ", idCommande=" + idCommande + ", etat=" + etat + "]";
	}
		
}
