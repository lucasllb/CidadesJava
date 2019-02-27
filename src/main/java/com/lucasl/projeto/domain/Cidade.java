package com.lucasl.projeto.domain;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="cidades")
public class Cidade implements Serializable {
	@Id
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
	
	public Cidade() {
		
	}
	
	public Cidade(String ibgeid, String uf, String name, String capital, String lon, String lat, String no_accents,
			String alternative_names, String microregion, String mesoregion) {
		super();
		this.ibgeid = ibgeid;
		this.uf = uf;
		this.name = name;
		this.capital = capital;
		this.lon = lon;
		this.lat = lat;
		this.no_accents = no_accents;
		this.alternative_names = alternative_names;
		this.microregion = microregion;
		this.mesoregion = mesoregion;
	}
        
    public Cidade(List<String[]> listaDadosCidade){
        if(listaDadosCidade.size() > 0){
            for (String registro[] : listaDadosCidade) {
                this.ibgeid = registro[0];
                this.uf = registro[1];
                this.name = registro[2];
                this.capital = registro[3];
                this.lon = registro[4];
                this.lat = registro[5];
                this.no_accents = registro[6];
                this.alternative_names = registro[7];
                this.microregion = registro[8];
                this.mesoregion = registro[9];
            }
        }
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((alternative_names == null) ? 0 : alternative_names.hashCode());
		result = prime * result + ((capital == null) ? 0 : capital.hashCode());
		result = prime * result + ((ibgeid == null) ? 0 : ibgeid.hashCode());
		result = prime * result + ((lat == null) ? 0 : lat.hashCode());
		result = prime * result + ((lon == null) ? 0 : lon.hashCode());
		result = prime * result + ((mesoregion == null) ? 0 : mesoregion.hashCode());
		result = prime * result + ((microregion == null) ? 0 : microregion.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((no_accents == null) ? 0 : no_accents.hashCode());
		result = prime * result + ((uf == null) ? 0 : uf.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cidade other = (Cidade) obj;
		if (alternative_names == null) {
			if (other.alternative_names != null)
				return false;
		} else if (!alternative_names.equals(other.alternative_names))
			return false;
		if (capital == null) {
			if (other.capital != null)
				return false;
		} else if (!capital.equals(other.capital))
			return false;
		if (ibgeid == null) {
			if (other.ibgeid != null)
				return false;
		} else if (!ibgeid.equals(other.ibgeid))
			return false;
		if (lat == null) {
			if (other.lat != null)
				return false;
		} else if (!lat.equals(other.lat))
			return false;
		if (lon == null) {
			if (other.lon != null)
				return false;
		} else if (!lon.equals(other.lon))
			return false;
		if (mesoregion == null) {
			if (other.mesoregion != null)
				return false;
		} else if (!mesoregion.equals(other.mesoregion))
			return false;
		if (microregion == null) {
			if (other.microregion != null)
				return false;
		} else if (!microregion.equals(other.microregion))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (no_accents == null) {
			if (other.no_accents != null)
				return false;
		} else if (!no_accents.equals(other.no_accents))
			return false;
		if (uf == null) {
			if (other.uf != null)
				return false;
		} else if (!uf.equals(other.uf))
			return false;
		return true;
	}

	public String getMesoregion() {
		return mesoregion;
	}

	public void setMesoregion(String mesoregion) {
		this.mesoregion = mesoregion;
	}

    @Override
    public String toString() {
        return "Cidade{" + "ibge_id=" + ibgeid + ", uf=" + uf + ", name=" + name + ", capital=" + capital + ", lon=" + lon + ", lat=" + lat + ", no_accents=" + no_accents + ", alternative_names=" + alternative_names + ", microregion=" + microregion + ", mesoregion=" + mesoregion + '}';
    }
	    
}
