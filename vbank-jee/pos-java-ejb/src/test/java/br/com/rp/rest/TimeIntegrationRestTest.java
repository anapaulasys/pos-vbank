package br.com.rp.rest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jboss.arquillian.persistence.UsingDataSet;
import org.junit.Assert;
import org.junit.Test;

import br.com.rp.AbstractTest;
import br.com.rp.domain.TimeIntegration;

public class TimeIntegrationRestTest extends AbstractTest {
	private static final String URL_BASE = "http://localhost:8080/vbank/api";

	@Test
	public void deveSalvarParametroComSucesso() throws ParseException {
		TimeIntegration time = new TimeIntegration();
		time.setHoraFimTransacoes(Calendar.getInstance().getTime());
		time.setHoraInicioTransacoes(Calendar.getInstance().getTime());
		time.setIntervaloIntegracaoBancoCentral(10L);
		time.setHorarioIntegracaoEUA(new SimpleDateFormat("hh:mm:ss").parse("23:50:00"));

		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL_BASE + "/parametro/save");
		Response response = target.request().accept(MediaType.APPLICATION_JSON)
				.post(Entity.entity(time, MediaType.APPLICATION_JSON));
		Assert.assertEquals(Integer.valueOf(200), Integer.valueOf(response.getStatus()));
		TimeIntegration integration = response.readEntity(TimeIntegration.class);
		Assert.assertNotNull(integration);
		Assert.assertEquals(new Long(10), integration.getIntervaloIntegracaoBancoCentral());
	}

	@Test
	@UsingDataSet("db/timeintegration.xml")
	public void deveAlterarParametroComSucesso() throws ParseException {
		TimeIntegration time = new TimeIntegration();
		time.setHoraFimTransacoes(Calendar.getInstance().getTime());
		time.setHoraInicioTransacoes(Calendar.getInstance().getTime());
		time.setIntervaloIntegracaoBancoCentral(10L);
		time.setHorarioIntegracaoEUA(new SimpleDateFormat("hh:mm:ss").parse("23:50:00"));

		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL_BASE + "/parametro/save");
		Response response = target.request().accept(MediaType.APPLICATION_JSON)
				.post(Entity.entity(time, MediaType.APPLICATION_JSON));
		Assert.assertEquals(Integer.valueOf(200), Integer.valueOf(response.getStatus()));
		TimeIntegration timeParan = response.readEntity(TimeIntegration.class);
		Assert.assertNotNull(timeParan);
		Assert.assertEquals(new Long(10), timeParan.getIntervaloIntegracaoBancoCentral());

		TimeIntegration time1 = new TimeIntegration();
		time1.setHoraFimTransacoes(timeParan.getHoraFimTransacoes());
		time1.setHoraInicioTransacoes(timeParan.getHoraInicioTransacoes());
		time1.setIntervaloIntegracaoBancoCentral(15L);
		time1.setHorarioIntegracaoEUA(timeParan.getHorarioIntegracaoEUA());

		target = client.target(URL_BASE + "/parametro/update/100001");
		response = target.request().put(Entity.entity(time1, MediaType.APPLICATION_JSON));
		Assert.assertEquals(Integer.valueOf(200), Integer.valueOf(response.getStatus()));
		TimeIntegration p = response.readEntity(TimeIntegration.class);
		Assert.assertEquals(new Long(15), p.getIntervaloIntegracaoBancoCentral());
	}

	@Test
	@UsingDataSet("db/timeintegration.xml")
	public void deveRemoverParametroComSucesso() {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL_BASE + "/parametro/remove/100001");
		Response response = target.request().delete();
		Assert.assertEquals(Integer.valueOf(204), Integer.valueOf(response.getStatus()));

		target = client.target(URL_BASE + "/parametro/findById/100001");
		response = target.request().get();
		Assert.assertEquals(Integer.valueOf(204), Integer.valueOf(response.getStatus()));
		TimeIntegration parametro = response.readEntity(TimeIntegration.class);
		Assert.assertNull(parametro);
	}

	@Test
	@UsingDataSet("db/timeintegration.xml")
	public void deveRetornarParametro() {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL_BASE + "/parametro/findById/100001");
		Response response = target.request().get();
		Assert.assertEquals(Integer.valueOf(200), Integer.valueOf(response.getStatus()));
	}
	

	@Test
	@UsingDataSet("db/timeintegration.xml")
	public void deveRetornaDoisParametros() {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL_BASE + "/parametro/getAll");
		Response response = target.request().get();
		Assert.assertEquals(Integer.valueOf(200), Integer.valueOf(response.getStatus()));
		List<TimeIntegration> time = (List<TimeIntegration>) response.readEntity(List.class);
		Assert.assertEquals(2, time.size());
	}
}
