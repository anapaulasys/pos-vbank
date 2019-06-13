package br.com.rp.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
@DiscriminatorValue(value = "cliente")
public class UsuarioCliente extends Usuario {

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "cliente_id", nullable = true)
	private Cliente cliente;

	public Cliente getCliente() {
		return cliente;
	}

	public UsuarioCliente(String nome, String login, String senha, Cliente cliente) {
		super(nome, login, senha);
		this.cliente = cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public UsuarioCliente() {
		super();
	}

}
