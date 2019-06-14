package br.com.rp.repository;

import javax.ejb.EJB;

import org.jboss.arquillian.persistence.UsingDataSet;
import org.junit.Assert;
import org.junit.Test;

import br.com.rp.AbstractTest;
import br.com.rp.domain.Cargo;
import br.com.rp.domain.Funcionario;
import br.com.rp.domain.UsuarioFuncionario;

public class UsuarioFuncionarioRepositoryTest extends AbstractTest {

	@EJB
	private UsuarioFuncionarioRepository usuarioFuncionarioRepository;

	@EJB
	private FuncionarioRepository funcionarioRepository;

	@EJB
	private CargoRepository cargoRepository;

	@Test
	public void deveInserirUsuarioFuncionarioComSucesso() {
		Cargo cargo = new Cargo();
		cargo.setDescricaoCargo("Gerente de vendas");
		cargoRepository.save(cargo);
		
		
		Funcionario funcionario = new Funcionario();
		funcionario.setNome("formiga");
		funcionario.setEmail("formiga@gmail.com");
		funcionario.setCpf("08564856652");
		funcionario.setCargo(cargo);
		funcionarioRepository.save(funcionario);

		UsuarioFuncionario usuarioFuncionario = new UsuarioFuncionario();
		usuarioFuncionario.setLogin("formiga");
		usuarioFuncionario.setNome("formiga");
		usuarioFuncionario.setSenha("123456");
		usuarioFuncionario.setFuncionario(funcionario);
		usuarioFuncionarioRepository.save(usuarioFuncionario);
		Assert.assertNotNull(usuarioFuncionario.getId());
	}
	
	@Test
	@UsingDataSet("db/usuario_funcionario.xml")
	public void deveRemoveUsuarioFuncionarioComSucesso(){
		usuarioFuncionarioRepository.remove(100001L);
		Assert.assertNull(usuarioFuncionarioRepository.findById(100001L));
	}
	
	@Test
	@UsingDataSet("db/usuario_funcionario.xml")
	public void deveAlterarUsuarioFuncionarioComSucesso(){
		UsuarioFuncionario usuarioFuncionario = usuarioFuncionarioRepository.findById(100001L);
		usuarioFuncionario.setLogin("ana");
		usuarioFuncionarioRepository.save(usuarioFuncionario);
		Assert.assertEquals("ana", usuarioFuncionarioRepository.findById(100001L).getLogin());
	}
	
	@Test
	@UsingDataSet("db/usuario_funcionario.xml")
	public void deveCompararNomeUsuarioFuncionario() {
		Assert.assertEquals("formiga", usuarioFuncionarioRepository.findById(100001L).getNome());
	}
	
	@Test
	@UsingDataSet("db/usuario_funcionario.xml")
	public void deveCompararLoginUsuarioFuncionario(){
		Assert.assertNotEquals("formiga", usuarioFuncionarioRepository.findById(100001L).getLogin());
	}
	
	@Test
	@UsingDataSet("db/usuario_funcionario.xml")
	public void deveRetornarFuncionarioDoUsuario(){
		Assert.assertNotNull(usuarioFuncionarioRepository.findById(100001L).getFuncionario());
	}
	
	@Test
	@UsingDataSet("db/usuario_funcionario.xml")
	public void deveCompararNomeFuncionarioDoUsuario(){
		Assert.assertEquals("formiga", usuarioFuncionarioRepository.findById(100001L).getFuncionario().getNome());
	}
	
	@Test
	@UsingDataSet("db/usuario_funcionario.xml")
	public void deveRetornarCargoDoFuncionarioUsuario(){
		Assert.assertNotNull(usuarioFuncionarioRepository.findById(100001L).getFuncionario().getCargo());
	}
	
	@Test
	@UsingDataSet("db/usuario_funcionario.xml")
	public void deveCompararNomeCargoUsuarioFuncionario(){
		Cargo cargo = new Cargo();
		cargo.setDescricaoCargo("Gerente de vendas");
		cargoRepository.save(cargo);
		
		
		Funcionario funcionario = new Funcionario();
		funcionario.setNome("formiga");
		funcionario.setEmail("formiga@gmail.com");
		funcionario.setCpf("08564856652");
		funcionario.setCargo(cargo);
		funcionarioRepository.save(funcionario);

		UsuarioFuncionario usuarioFuncionario = new UsuarioFuncionario();
		usuarioFuncionario.setLogin("formiga");
		usuarioFuncionario.setNome("formiga");
		usuarioFuncionario.setSenha("123456");
		usuarioFuncionario.setFuncionario(funcionario);
		usuarioFuncionarioRepository.save(usuarioFuncionario);
		
		Assert.assertEquals("Gerente de vendas", usuarioFuncionarioRepository.findById(100001L).getFuncionario().getCargo().getDescricaoCargo());
	}
	
	@Test
	@UsingDataSet("db/usuario_funcionario.xml")
	public void deveRetornarDoisUsuarioFuncionarios() {
		Assert.assertEquals(2, funcionarioRepository.getAll().size());
	}
}