package br.com.rp.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
@DiscriminatorValue(value = "funcionario")
public class UsuarioFuncionario extends Usuario {

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "funcionario_id", nullable = true)
	private Funcionario funcionario;

	public UsuarioFuncionario() {
		super();
	}

	public UsuarioFuncionario(String nome, String login, String senha, Funcionario funcionario) {
		super(nome, login, senha);
		this.funcionario = funcionario;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
}
