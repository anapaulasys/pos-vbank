package br.com.rp.repository.impl;

import javax.ejb.Stateless;

import br.com.rp.domain.Email;
import br.com.rp.repository.EmailRepository;

@Stateless
public class EmailRepositoryImpl extends AbstractRepositoryImpl<Email> implements EmailRepository {

	public EmailRepositoryImpl() {
		super(Email.class);
	}

}
