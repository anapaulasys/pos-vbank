package br.com.rp.repository.impl;

import javax.ejb.Stateless;

import br.com.rp.domain.MotivoRejeicao;
import br.com.rp.repository.MotivoRejeicaoRepository;


@Stateless
public class MotivoRejeicaoRepositoryImpl extends AbstractRepositoryImpl<MotivoRejeicao> implements MotivoRejeicaoRepository{

	public MotivoRejeicaoRepositoryImpl() {
		super(MotivoRejeicao.class);
	}

}
