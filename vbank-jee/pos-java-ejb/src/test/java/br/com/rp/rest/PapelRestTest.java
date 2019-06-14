package br.com.rp.rest;

import java.text.ParseException;
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
import br.com.rp.domain.Papel;

public class PapelRestTest extends AbstractTest {
	private static final String URL_BASE = "http://localhost:8080/vbank/api";

	@Test
	public void deveSalvarAcaoComSucesso() throws ParseException {

		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL_BASE + "/acao/save");
		Response response = target.request().accept(MediaType.APPLICATION_JSON)
				.post(Entity.entity(new Papel("adicionarAcao"), MediaType.APPLICATION_JSON));
		Assert.assertEquals(Integer.valueOf(200), Integer.valueOf(response.getStatus()));
		Papel acao = response.readEntity(Papel.class);
		Assert.assertNotNull(acao);
		Assert.assertEquals("adicionarAcao", acao.getDescricaoAcao());
	}

	@Test
	@UsingDataSet("db/acao.xml")
	public void deveAlterarAcaoComSucesso() throws ParseException {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL_BASE + "/acao/findById/100001");
		Response response = target.request().get();
		Assert.assertEquals(Integer.valueOf(200), Integer.valueOf(response.getStatus()));
		Papel acao = response.readEntity(Papel.class);
		Assert.assertEquals("Consultar Saldo", acao.getDescricaoAcao());

		target = client.target(URL_BASE + "/acao/update/100001");
		response = target.request().put(Entity.entity(new Papel("alterarAcao"), MediaType.APPLICATION_JSON));
		Assert.assertEquals(Integer.valueOf(200), Integer.valueOf(response.getStatus()));
		Papel acaoResult = response.readEntity(Papel.class);
		Assert.assertNotNull(acaoResult);
		Assert.assertEquals("alterarAcao", acaoResult.getDescricaoAcao());
	}

	@Test
	@UsingDataSet("db/acao.xml")
	public void deveRemoverAcaoComSucesso() {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL_BASE + "/acao/remove/100001");
		Response response = target.request().delete();
		Assert.assertEquals(Integer.valueOf(204), Integer.valueOf(response.getStatus()));

		target = client.target(URL_BASE + "/acao/findById/100001");
		response = target.request().get();
		Assert.assertEquals(Integer.valueOf(204), Integer.valueOf(response.getStatus()));
		Papel acao = response.readEntity(Papel.class);
		Assert.assertNull(acao);
	}

	@Test
	@UsingDataSet("db/acao.xml")
	public void deveRetornarAcao() {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL_BASE + "/acao/findById/100001");
		Response response = target.request().get();
		Assert.assertEquals(Integer.valueOf(200), Integer.valueOf(response.getStatus()));
		Papel acao = response.readEntity(Papel.class);
		Assert.assertNotNull(acao);
	}

	@Test
	@UsingDataSet("db/acao.xml")
	public void deveCompararAcaoDescricao() {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL_BASE + "/acao/findById/100001");
		Response response = target.request().get();
		Assert.assertEquals(Integer.valueOf(200), Integer.valueOf(response.getStatus()));
		Papel acao = response.readEntity(Papel.class);
		Assert.assertEquals("Consultar Saldo", acao.getDescricaoAcao());
	}

	@Test
	@UsingDataSet("db/acao.xml")
	public void deveRetornaDuasAcoes() {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL_BASE + "/acao/getAll");
		Response response = target.request().get();
		Assert.assertEquals(Integer.valueOf(200), Integer.valueOf(response.getStatus()));
		List<Papel> acoes = (List<Papel>) response.readEntity(List.class);
		Assert.assertEquals(2, acoes.size());
	}
}
