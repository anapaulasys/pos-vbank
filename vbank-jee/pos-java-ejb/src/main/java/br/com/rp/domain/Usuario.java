package br.com.rp.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;


@Entity
@Table(name = "usuario")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tp_usuario", discriminatorType = DiscriminatorType.STRING, length = 15)
public abstract class Usuario extends BaseEntity implements Serializable {

	@Column(name = "nome", length = 60, nullable = false)
	private String nome;

	/*
	 * Login do funcionário no sistema.
	 */
	@Column(name = "login", length = 30, nullable = true)
	private String login;
	
	@Size(min = 6, max = 8)
	@Column(name = "senha", length = 8, nullable = false)
	private String senha;

	/*
	 * Lista de papel que este usuário possui.
	 */
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "papel_usuario", joinColumns = {
			@JoinColumn(referencedColumnName = "id", name = "usuario_id") }, inverseJoinColumns = @JoinColumn(referencedColumnName = "id", name = "papel_id"))
	private List<Papel> papel;

	public Usuario() {

	}
	
	public Usuario(String nome, String login, String senha) {
		super();
		this.nome = nome;
		this.senha = senha;
		this.login = login;
	}



	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}
	
}