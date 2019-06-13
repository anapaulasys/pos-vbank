package br.com.rp.rest;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.rp.domain.TimeIntegration;
import br.com.rp.services.TimeIntegrationService;

@Path("/parametro")
@Produces("application/json")
public class TimeIntegrationRest {
	@EJB
	private TimeIntegrationService parametroService;

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/save")
	public TimeIntegration save(TimeIntegration parametro) {
		return parametroService.save(parametro);
	}

	@PUT
	@Path("/update/{id}")
	public TimeIntegration update(@PathParam("id") Long id, TimeIntegration parametro) {
		TimeIntegration parametroResult = parametroService.findById(id);
		parametroResult.setHoraFimTransacoes(parametro.getHoraFimTransacoes());
		parametroResult.setHoraInicioTransacoes(parametro.getHoraInicioTransacoes());
		parametroResult.setHorarioIntegracaoEUA(parametro.getHorarioIntegracaoEUA());
		parametroResult.setIntervaloIntegracaoBancoCentral(parametro.getIntervaloIntegracaoBancoCentral());
		return parametroService.save(parametroResult);
	}

	@DELETE
	@Path("/remove/{id}")
	public void remove(@PathParam("id") Long id) {
		parametroService.remove(id);
	}

	@GET
	@Path("/findById/{id}")
	public TimeIntegration findById(@PathParam("id") Long id) {
		return parametroService.findById(id);
	}

	@GET
	@Path("/getAll")
	public List<TimeIntegration> getAll() {
		return parametroService.getAll();
	}

}
