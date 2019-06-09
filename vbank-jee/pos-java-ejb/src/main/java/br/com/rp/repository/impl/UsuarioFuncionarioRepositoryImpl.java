package br.com.rp.repository.impl;

import javax.ejb.Stateless;

import br.com.rp.domain.UsuarioFuncionario;
import br.com.rp.repository.UsuarioFuncionarioRepository;


@Stateless
public class UsuarioFuncionarioRepositoryImpl extends AbstractRepositoryImpl<UsuarioFuncionario>
		implements UsuarioFuncionarioRepository {

	public UsuarioFuncionarioRepositoryImpl() {
		super(UsuarioFuncionario.class);
	}

}
