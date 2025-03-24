package com.jihed.accessoires.entities;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Accessoire {
	
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	private long idAccess;

	private String nomAccess;
	private String couleurAccess;
	private Double prixAccess;
	private Date dateSortieAcess;

	public Accessoire() {
		super();
	}

	public Accessoire(String nomAccess, String couleurAccess, Double prixAccess, Date dateSortieAcess) {
		super();
		this.nomAccess = nomAccess;
		this.couleurAccess = couleurAccess;
		this.prixAccess = prixAccess;
		this.dateSortieAcess = dateSortieAcess;
	}

	public long getIdAccess() {
		return idAccess;
	}

	public void setIdAccess(long idAccess) {
		this.idAccess = idAccess;
	}

	public String getNomAccess() {
		return nomAccess;
	}

	public void setNomAccess(String nomAccess) {
		this.nomAccess = nomAccess;
	}

	public String getCouleurAccess() {
		return couleurAccess;
	}

	public void setCouleurAccess(String couleurAccess) {
		this.couleurAccess = couleurAccess;
	}

	public Double getPrixAccess() {
		return prixAccess;
	}

	public void setPrixAccess(Double prixAccess) {
		this.prixAccess = prixAccess;
	}

	public Date getDateSortieAcess() {
		return dateSortieAcess;
	}

	public void setDateSortieAcess(Date dateSortieAcess) {
		this.dateSortieAcess = dateSortieAcess;
	}

	@Override
	public String toString() {
		return "Accessoire [idAccess=" + idAccess + ", nomAccess=" + nomAccess + ", couleurAccess=" + couleurAccess
				+ ", prixAccess=" + prixAccess + ", dateSortieAcess=" + dateSortieAcess + "]";
	}

}
