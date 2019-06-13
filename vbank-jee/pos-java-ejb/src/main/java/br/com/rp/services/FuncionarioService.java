package br.com.rp.services;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.caelum.stella.validation.CPFValidator;
import br.com.caelum.stella.validation.InvalidStateException;
import br.com.rp.domain.Funcionario;
import br.com.rp.repository.FuncionarioRepository;


@Stateless
public class FuncionarioService {

	@PersistenceContext(unitName = "vbank")
	private EntityManager em;
	
	@EJB
	private FuncionarioRepository funcionarioRepository;
	
	public List<Funcionario> getAll() {
		return funcionarioRepository.getAll();
	}
	
	
	public Funcionario save(Funcionario funcionario){
		return funcionarioRepository.save(funcionario);
	}
	
	public Funcionario findById(Long id){
		return funcionarioRepository.findById(id);
	}
	
	public void remove(Long id){
		funcionarioRepository.remove(id);
	}
	
	public Funcionario findByCpf(String cpf) {
		return em.createQuery("from " + Funcionario.class.getSimpleName() + " where cpf = '" + cpf + "'", Funcionario.class)
				.getSingleResult();
	}	
	
	public Boolean isCpfExistente(String cpf) {
		try {
			if (!findByCpf(cpf).equals(null)) {
				return true;
			}
		} catch (Exception e) {
			return false;
		}
		return false;
	}
	
	public Boolean isCpfValido(String cpf) {
		try {
			new CPFValidator().assertValid(cpf);
		} catch (InvalidStateException e) {
			return false;
		}
		return true;
	}
}
