package br.com.rp.services;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.com.rp.domain.UsuarioCliente;
import br.com.rp.repository.UsuarioClienteRepository;

@Stateless
public class UsuarioClienteService {

	@EJB 
	private UsuarioClienteRepository usuarioClienteRepository;
	
	public List<UsuarioCliente> getAll() {
		return usuarioClienteRepository.getAll();
	}
	
	public UsuarioCliente save(UsuarioCliente usuarioCliente){
		return usuarioClienteRepository.save(usuarioCliente);
	}
	
	public UsuarioCliente findById(Long id){
		return usuarioClienteRepository.findById(id);
	}
	
	public void remove(Long id){
		usuarioClienteRepository.remove(id);
	}	
		
}
