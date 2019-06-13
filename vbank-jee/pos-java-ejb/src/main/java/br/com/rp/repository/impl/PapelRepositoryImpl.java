package br.com.rp.repository.impl;

import javax.ejb.Stateless;

import br.com.rp.domain.Papel;
import br.com.rp.repository.PapelRepository;

@Stateless
public class PapelRepositoryImpl extends AbstractRepositoryImpl<Papel> implements PapelRepository {

	public PapelRepositoryImpl() {
		super(Papel.class);
	}

}
