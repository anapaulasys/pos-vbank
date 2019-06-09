package br.com.rp.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "banco")
public class Banco extends BaseEntity implements Serializable {

	@Column(name = "descricao", length = 50, nullable = false)
	private String descricao;
	
	public Banco() {

	}

	public Banco(String descricao) {
		super();
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
}
