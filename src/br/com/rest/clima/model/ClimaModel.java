package br.com.rest.clima.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public final class ClimaModel {

	private int id_clima;
	private String municipio;
	private String estado;
	private String temp_max;
	private String temp_min;
	private String sens_term;
	private String temp_atual;
	private String umidade;
	private String date_ins;

	public int getId_clima() {
		return id_clima;
	}

	public void setId_clima(int id_clima) {
		this.id_clima = id_clima;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio.toUpperCase();
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado.toUpperCase();
	}

	public String getTemp_max() {
		return temp_max;
	}

	public void setTemp_max(String temp_max) {
		this.temp_max = temp_max;
	}

	public String getTemp_min() {
		return temp_min;
	}

	public void setTemp_min(String temp_min) {
		this.temp_min = temp_min;
	}

	public String getSens_term() {
		return sens_term;
	}

	public void setSens_term(String sens_term) {
		this.sens_term = sens_term;
	}

	public String getTemp_atual() {
		return temp_atual;
	}

	public void setTemp_atual(String temp_atual) {
		this.temp_atual = temp_atual;
	}

	public String getUmidade() {
		return umidade;
	}

	public void setUmidade(String umidade) {
		this.umidade = umidade;
	}

	public String getDate_ins() {
		return date_ins;
	}

	public void setDate_ins(String date_ins) {
		this.date_ins = date_ins;
	}

	@Override
	public String toString() {
		return "ClimaModel [id_clima=" + id_clima + ", municipio=" + municipio + ", estado=" + estado + ", temp_max="
				+ temp_max + ", temp_min=" + temp_min + ", sens_term=" + sens_term + ", temp_atual=" + temp_atual
				+ ", umidade=" + umidade + ", date_ins=" + date_ins + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((municipio == null) ? 0 : municipio.hashCode());
		result = prime * result + ((date_ins == null) ? 0 : date_ins.hashCode());
		result = prime * result + ((estado == null) ? 0 : estado.hashCode());
		result = prime * result + id_clima;
		result = prime * result + ((sens_term == null) ? 0 : sens_term.hashCode());
		result = prime * result + ((temp_atual == null) ? 0 : temp_atual.hashCode());
		result = prime * result + ((temp_max == null) ? 0 : temp_max.hashCode());
		result = prime * result + ((temp_min == null) ? 0 : temp_min.hashCode());
		result = prime * result + ((umidade == null) ? 0 : umidade.hashCode());
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
		ClimaModel other = (ClimaModel) obj;
		if (municipio == null) {
			if (other.municipio != null)
				return false;
		} else if (!municipio.equals(other.municipio))
			return false;
		if (date_ins == null) {
			if (other.date_ins != null)
				return false;
		} else if (!date_ins.equals(other.date_ins))
			return false;
		if (estado == null) {
			if (other.estado != null)
				return false;
		} else if (!estado.equals(other.estado))
			return false;
		if (id_clima != other.id_clima)
			return false;
		if (sens_term == null) {
			if (other.sens_term != null)
				return false;
		} else if (!sens_term.equals(other.sens_term))
			return false;
		if (temp_atual == null) {
			if (other.temp_atual != null)
				return false;
		} else if (!temp_atual.equals(other.temp_atual))
			return false;
		if (temp_max == null) {
			if (other.temp_max != null)
				return false;
		} else if (!temp_max.equals(other.temp_max))
			return false;
		if (temp_min == null) {
			if (other.temp_min != null)
				return false;
		} else if (!temp_min.equals(other.temp_min))
			return false;
		if (umidade == null) {
			if (other.umidade != null)
				return false;
		} else if (!umidade.equals(other.umidade))
			return false;
		return true;
	}
}