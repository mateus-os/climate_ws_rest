package br.com.rest.clima.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.ws.rs.core.Response;

import br.com.rest.clima.dao.ClimaDAO;
import br.com.rest.clima.model.ClimaModel;

public class ClimaControl {

	public String listAll() {
		return ClimaDAO.getInstance().listAll();
	}

	public String ping() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();

		return "Jre: " + System.getProperty("java.version") + "\nOS: " + System.getProperty("os.name")
				+ "\nOS version: " + System.getProperty("os.version") + "\n\n\n" + dtf.format(now);
	}

	public ClimaModel consultarClima(ClimaModel clima) {
		return ClimaDAO.getInstance().consultarClima(clima);
	}

	public Response inserirClima(ClimaModel clima) {
		return ClimaDAO.getInstance().inserirClima(clima);
	}

	public Response atualizarClima(ClimaModel clima) {
		return ClimaDAO.getInstance().atualizarClima(clima);
	}

	public Response excluirClima(int ID_Clima) {
		return ClimaDAO.getInstance().excluirClima(ID_Clima);
	}
}
