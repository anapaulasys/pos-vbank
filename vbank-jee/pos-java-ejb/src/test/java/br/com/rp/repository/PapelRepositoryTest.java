package br.com.rp.repository;

import javax.ejb.EJB;

import org.jboss.arquillian.persistence.UsingDataSet;
import org.junit.Assert;
import org.junit.Test;

import br.com.rp.AbstractTest;
import br.com.rp.domain.Papel;

public class PapelRepositoryTest extends AbstractTest {

	@EJB
	private PapelRepository papelRepository;

	@Test
	public void deveInserirAcaoComSucesso() {
		Papel papel = new Papel();
		papel.setDescricaoAcao("Consultar Saldo");
		papelRepository.save(papel);
		Assert.assertNotNull(papel.getId());
	}

	@Test
	@UsingDataSet("db/papel.xml")
	public void deveCompararDescricaoAcao() {
		Papel papel = papelRepository.findById(100001L);
		Assert.assertEquals("Consultar Saldo", papel.getDescricaoAcao());
	}

	@Test
	@UsingDataSet("db/papel.xml")
	public void deveRetornarDoisRegistros() {
		Assert.assertEquals(2, papelRepository.getAll().size());
	}

	@Test
	@UsingDataSet("db/papel.xml")
	public void deveRemoverAcaoComSucesso() {
		papelRepository.remove(100001L);
		Assert.assertEquals(1, papelRepository.getAll().size());
	}

	@Test
	@UsingDataSet("db/papel.xml")
	public void deveAtualizarDescricaoComSucesso() {
		Papel papel = papelRepository.findById(100001L);
		papel.setDescricaoAcao("Depósito");
		papelRepository.save(papel);
		Assert.assertEquals("Depósito", papelRepository.findById(100001L).getDescricaoAcao());
	}

}
