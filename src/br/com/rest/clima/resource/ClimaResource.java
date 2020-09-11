package br.com.rest.clima.resource;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Encoded;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.rest.clima.controller.ClimaControl;
import br.com.rest.clima.controller.MunicipiosControl;
import br.com.rest.clima.model.ClimaModel;

@Path("/clima")
public class ClimaResource {

	@GET
	@Path("/ping")
	@Produces(MediaType.APPLICATION_JSON)
	public String ping() {
		return new ClimaControl().ping();
	}

	@GET
	@Path("/listAll")
	@Produces(MediaType.APPLICATION_JSON)
	public String listAll() {
		return new ClimaControl().listAll();
	}

	@GET
	@Path("/listMunicipios")
	@Produces(MediaType.APPLICATION_JSON)
	public String listMunicipios() {
		return new MunicipiosControl().listMunicipios();
	}

	@GET
	@Encoded
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/consultarClima/{municipio}/{estado}")
	public ClimaModel consultarClima(@PathParam("estado") String estado, @PathParam("municipio") String municipio) {
		ClimaModel clima = new ClimaModel();
		
		try {
			clima.setMunicipio(URLDecoder.decode(municipio, StandardCharsets.UTF_8.name()));
		} catch (UnsupportedEncodingException e) {
			return null;
		}
		clima.setEstado(estado);
		return new ClimaControl().consultarClima(clima);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/inserirClima")
	public Response inserirClima(ClimaModel clima) {
		return new ClimaControl().inserirClima(clima);
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/atualizarClima")
	public Response atualizarClima(ClimaModel clima) {
		return new ClimaControl().atualizarClima(clima);
	}

	@DELETE
	@Path("/excluirClima/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response excluirClima(@PathParam("id") int ID_Clima) {
		return new ClimaControl().excluirClima(ID_Clima);
	}

}
