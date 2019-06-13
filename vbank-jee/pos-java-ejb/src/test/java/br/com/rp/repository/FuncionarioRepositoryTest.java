package br.com.rp.repository;

import javax.ejb.EJB;

import org.jboss.arquillian.persistence.UsingDataSet;
import org.junit.Assert;
import org.junit.Test;

import br.com.rp.AbstractTest;
import br.com.rp.domain.Cargo;
import br.com.rp.domain.Funcionario;

public class FuncionarioRepositoryTest extends AbstractTest {

	@EJB
	private CargoRepository cargoRepository;

	@EJB
	private FuncionarioRepository funcionarioRepository;

	@Test
	public void deveInserirFuncionarioComSucesso() {
		Cargo cargo = new Cargo();
		cargo.setDescricaoCargo("Gerente de Vendas");
		cargoRepository.save(cargo);

		Funcionario funcionario = new Funcionario();
		funcionario.setCpf("15489758956");
		funcionario.setEmail("monica@gmail.com");
		funcionario.setNome("monica");
		funcionario.setCargo(cargo);
		funcionarioRepository.save(funcionario);
		Assert.assertNotNull(funcionario.getId());
	}
	
	@Test
	public void deveAlterarFuncionarioComSucesso() {
		
		Funcionario funcionarior = new Funcionario();
		funcionarior.setNome("monica");
		funcionarior.setId(100001L);
		funcionarioRepository.save(funcionarior);
		
		Funcionario funcionario = funcionarioRepository.findById(100001L);
		funcionario.setNome("formiga");
		funcionarioRepository.save(funcionario);
		Assert.assertEquals("FORMIGA", funcionarioRepository.findById(100001L).getNome());
	}
	/*
	@Test
	@UsingDataSet("db/funcionario.xml")
	public void deveRemoverFuncionarioComSucesso() {
		funcionarioRepository.remove(100001L);
		Assert.assertNull(funcionarioRepository.findById(100001L));
	}

	@Test
	@UsingDataSet("db/funcionario.xml")
	public void deveCompararNomeFuncionario() {
		Assert.assertEquals("formiga", funcionarioRepository.findById(100001L).getNome());
	}

	@Test
	@UsingDataSet("db/funcionario.xml")
	public void deveRetornarCargoFuncionario() {
		Assert.assertNotNull(funcionarioRepository.findById(100001L).getCargo());
	}

	@Test
	@UsingDataSet("db/funcionario.xml")
	public void deveCompararDescricaoCargoFuncionario() {
		Assert.assertEquals("Gerente de Vendas", funcionarioRepository.findById(100001L).getCargo().getDescricaoCargo());
	}
	
	@Test
	@UsingDataSet("db/funcionario.xml")
	public void deveRetornarDoisRegistros(){
		Assert.assertEquals(2, funcionarioRepository.getAll().size());
	}
*/
}
