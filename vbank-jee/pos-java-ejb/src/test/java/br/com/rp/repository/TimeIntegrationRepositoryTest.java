package br.com.rp.repository;

import java.util.Calendar;

import javax.ejb.EJB;

import org.jboss.arquillian.persistence.UsingDataSet;
import org.junit.Assert;
import org.junit.Test;

import br.com.rp.AbstractTest;
import br.com.rp.domain.TimeIntegration;

public class TimeIntegrationRepositoryTest extends AbstractTest {
	@EJB
	private TimeIntegrationRepository timeIntegrationRepository;

	@Test
	public void deveInserirParametroComSucesso() {
		TimeIntegration timeIntegration = new TimeIntegration();
		timeIntegration.setHoraFimTransacoes(Calendar.getInstance().getTime());
		timeIntegration.setHoraInicioTransacoes(Calendar.getInstance().getTime());
		timeIntegration.setHorarioIntegracaoEUA(Calendar.getInstance().getTime());
		timeIntegration.setIntervaloIntegracaoBancoCentral(5L);
		timeIntegrationRepository.save(timeIntegration);
		Assert.assertNotNull(timeIntegration.getId());
	}

	@Test
	@UsingDataSet("db/timeintegration.xml")
	public void deveCompararDescricaoParametro() {
		TimeIntegration timeIntegration = timeIntegrationRepository.findById(100001L);
		Assert.assertEquals(new Long(5), timeIntegration.getIntervaloIntegracaoBancoCentral());
	}

	@Test
	@UsingDataSet("db/timeintegration.xml")
	public void deveRetornarDoisRegistros() {
		Assert.assertEquals(2, timeIntegrationRepository.getAll().size());
	}

	@Test
	@UsingDataSet("db/timeintegration.xml")
	public void deveRemoverParametroComSucesso() {
		timeIntegrationRepository.remove(100001L);
		Assert.assertEquals(1, timeIntegrationRepository.getAll().size());
	}

	@Test
	@UsingDataSet("db/timeintegration.xml")
	public void deveAtualizarIntervaloIntegracaoBacenComSucesso() {
		TimeIntegration timeIntegration = timeIntegrationRepository.findById(100001L);
		timeIntegration.setIntervaloIntegracaoBancoCentral(10L);
		timeIntegrationRepository.save(timeIntegration);
		Assert.assertEquals(new Long(10), timeIntegrationRepository.findById(100001L).getIntervaloIntegracaoBancoCentral());
	}
}
