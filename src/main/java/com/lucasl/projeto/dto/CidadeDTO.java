package com.lucasl.projeto.dto;

import java.io.Serializable;

import com.lucasl.projeto.domain.Cidade;

public class CidadeDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private String ibgeid;
	private String uf;
	private String name;
	private String capital;
	private String lon;
	private String lat;
	private String no_accents;
	private String alternative_names;
	private String microregion;
	private String mesoregion;
	
	public CidadeDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public CidadeDTO(Cidade obj) {
		ibgeid = obj.getIbgeid();
		uf = obj.getUf();
		name = obj.getName();
		capital = obj.getCapital();
		lon = obj.getLon();
		lat = obj.getLat();
		no_accents = obj.getNo_accents();
		alternative_names = obj.getAlternative_names();
		microregion = obj.getMicroregion();
		mesoregion = obj.getMesoregion();
	}

	public String getIbgeid() {
		return ibgeid;
	}

	public void setIbgeid(String ibgeid) {
		this.ibgeid = ibgeid;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCapital() {
		return capital;
	}

	public void setCapital(String capital) {
		this.capital = capital;
	}

	public String getLon() {
		return lon;
	}

	public void setLon(String lon) {
		this.lon = lon;
	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getNo_accents() {
		return no_accents;
	}

	public void setNo_accents(String no_accents) {
		this.no_accents = no_accents;
	}

	public String getAlternative_names() {
		return alternative_names;
	}

	public void setAlternative_names(String alternative_names) {
		this.alternative_names = alternative_names;
	}

	public String getMicroregion() {
		return microregion;
	}

	public void setMicroregion(String microregion) {
		this.microregion = microregion;
	}

	public String getMesoregion() {
		return mesoregion;
	}

	public void setMesoregion(String mesoregion) {
		this.mesoregion = mesoregion;
	}
	
	
}
