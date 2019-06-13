package br.com.rp.services;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.com.rp.domain.MotivoRejeicao;
import br.com.rp.repository.MotivoRejeicaoRepository;

@Stateless
public class MotivoRejeicaoService {

	@EJB
	private MotivoRejeicaoRepository motivoRejeicaoRepository;

	public List<MotivoRejeicao> getAll() {
		return motivoRejeicaoRepository.getAll();
	}

	public MotivoRejeicao save(MotivoRejeicao motivo) {
		return motivoRejeicaoRepository.save(motivo);
	}

	public MotivoRejeicao findById(Long id) {
		return motivoRejeicaoRepository.findById(id);
	}

	public void remove(Long id) {
		motivoRejeicaoRepository.remove(id);
	}
}
