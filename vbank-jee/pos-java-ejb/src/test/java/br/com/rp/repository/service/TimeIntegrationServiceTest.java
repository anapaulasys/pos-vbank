package br.com.rp.repository.service;

import java.util.Calendar;

import javax.ejb.EJB;

import org.jboss.arquillian.persistence.UsingDataSet;
import org.junit.Assert;
import org.junit.Test;

import br.com.rp.AbstractTest;
import br.com.rp.domain.TimeIntegration;
import br.com.rp.services.TimeIntegrationService;

public class TimeIntegrationServiceTest extends AbstractTest {
	@EJB
	private TimeIntegrationService timeService;

	@Test
	public void deveInserirParametroComSucesso() {
		TimeIntegration time = new TimeIntegration();
		time.setHoraFimTransacoes(Calendar.getInstance().getTime());
		time.setHoraInicioTransacoes(Calendar.getInstance().getTime());
		time.setHorarioIntegracaoEUA(Calendar.getInstance().getTime());
		time.setIntervaloIntegracaoBancoCentral(5L);
		timeService.save(time);
		Assert.assertNotNull(time.getId());
	}

	@Test
	@UsingDataSet("db/timeintegration.xml")
	public void deveCompararDescricaoParametro() {
		TimeIntegration time = timeService.findById(100001L);
		Assert.assertEquals(new Long(5), time.getIntervaloIntegracaoBancoCentral());
	}

	@Test
	@UsingDataSet("db/timeintegration.xml")
	public void deveRetornarDoisRegistros() {
		Assert.assertEquals(2, timeService.getAll().size());
	}

	@Test
	@UsingDataSet("db/timeintegration.xml")
	public void deveRemoverParametroComSucesso() {
		timeService.remove(100001L);
		Assert.assertEquals(1, timeService.getAll().size());
	}

	@Test
	@UsingDataSet("db/timeintegration.xml")
	public void deveAtualizarIntervaloIntegracaoBacenComSucesso() {
		TimeIntegration time = timeService.findById(100001L);
		time.setIntervaloIntegracaoBancoCentral(10L);
		timeService.save(time);
		Assert.assertEquals(new Long(10), timeService.findById(100001L).getIntervaloIntegracaoBancoCentral());
	}
}
