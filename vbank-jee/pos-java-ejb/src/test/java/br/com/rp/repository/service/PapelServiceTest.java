package br.com.rp.repository.service;

import javax.ejb.EJB;

import org.jboss.arquillian.persistence.UsingDataSet;
import org.junit.Assert;
import org.junit.Test;

import br.com.rp.AbstractTest;
import br.com.rp.domain.Papel;
import br.com.rp.services.PapelService;

public class PapelServiceTest extends AbstractTest{
	
	@EJB
	private PapelService papelService;

	@Test
	public void deveInserirAcaoComSucesso() {
		Papel papel = new Papel();
		papel.setDescricaoAcao("Consultar Saldo");
		papelService.save(papel);
		Assert.assertNotNull(papel.getId());
	}

	@Test
	@UsingDataSet("db/papel.xml")
	public void deveCompararDescricaoAcao() {
		Papel acao = papelService.findById(100001L);
		Assert.assertEquals("Consultar Saldo", acao.getDescricaoAcao());
	}

	@Test
	@UsingDataSet("db/papel.xml")
	public void deveRetornarDoisRegistros() {
		Assert.assertEquals(2, papelService.getAll().size());
	}

	@Test
	@UsingDataSet("db/papel.xml")
	public void deveRemoverAcaoComSucesso() {
		papelService.remove(100001L);
		Assert.assertEquals(1, papelService.getAll().size());
	}

	@Test
	@UsingDataSet("db/papel.xml")
	public void deveAtualizarDescricaoComSucesso() {
		Papel papel = papelService.findById(100001L);
		papel.setDescricaoAcao("Depósito");
		papelService.save(papel);
		Assert.assertEquals("Depósito", papelService.findById(100001L).getDescricaoAcao());
	}

}
