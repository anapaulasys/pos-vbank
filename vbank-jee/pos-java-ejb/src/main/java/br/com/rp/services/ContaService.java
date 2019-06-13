package br.com.rp.services;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.com.rp.domain.Conta;
import br.com.rp.repository.ContaRepository;

@Stateless
public class ContaService {

	@EJB
	private ContaRepository contaRepository;

	public List<Conta> getAll() {
		return contaRepository.getAll();
	}

	public Conta save(Conta conta) {
		return contaRepository.save(conta);
	}

	public Conta findById(Long id) {
		return contaRepository.findById(id);
	}

	public void remove(Long id) {
		contaRepository.remove(id);
	}

}
