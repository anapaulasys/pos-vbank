package br.com.rp.repository.impl;

import javax.ejb.Stateless;

import br.com.rp.domain.Papel;
import br.com.rp.repository.AcaoRepository;

@Stateless
public class AcaoRepositoryImpl extends AbstractRepositoryImpl<Papel> implements AcaoRepository {

	public AcaoRepositoryImpl() {
		super(Papel.class);
	}

}
