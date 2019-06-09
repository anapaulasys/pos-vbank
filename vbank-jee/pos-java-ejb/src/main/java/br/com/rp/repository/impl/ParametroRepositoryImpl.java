package br.com.rp.repository.impl;

import javax.ejb.Stateless;

import br.com.rp.domain.Parametro;
import br.com.rp.repository.ParametroRepository;

@Stateless
public class ParametroRepositoryImpl extends AbstractRepositoryImpl<Parametro> implements ParametroRepository {

	public ParametroRepositoryImpl() {
		super(Parametro.class);
	}

}
