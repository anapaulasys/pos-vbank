package br.com.rp.repository.impl;

import javax.ejb.Stateless;

import br.com.rp.domain.TimeIntegration;
import br.com.rp.repository.TimeIntegrationRepository;

@Stateless
public class TimeIntegrationRepositoryImpl extends AbstractRepositoryImpl<TimeIntegration> implements TimeIntegrationRepository {

	public TimeIntegrationRepositoryImpl() {
		super(TimeIntegration.class);
	}

}
