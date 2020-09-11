package br.com.rest.clima.controller;

import br.com.rest.clima.dao.MunicipiosDAO;

public class MunicipiosControl {

	public String listMunicipios() {
		return MunicipiosDAO.getInstance().listMunicipios();
	}
}
