package br.com.rp.repository.impl;

import javax.ejb.Stateless;

import br.com.rp.domain.UsuarioCliente;
import br.com.rp.repository.UsuarioClienteRepository;


@Stateless
public class UsuarioClienteRepositoryImpl extends AbstractRepositoryImpl<UsuarioCliente> implements UsuarioClienteRepository {

	public UsuarioClienteRepositoryImpl() {
		super(UsuarioCliente.class);
	}

}
