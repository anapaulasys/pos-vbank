package br.com.rp.repository.impl;

import javax.ejb.Stateless;

import br.com.rp.domain.Deposito;
import br.com.rp.repository.DepositoRepository;


@Stateless
public class DepositoRepositoryImpl extends AbstractRepositoryImpl<Deposito> implements DepositoRepository {

	public DepositoRepositoryImpl() {
		super(Deposito.class);
	}

}
